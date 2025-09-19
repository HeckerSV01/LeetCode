class pair{
    int id;
    int task;
    int prior;
    public pair(int id,int task,int prior)
    {
        this.id=id;
        this.task=task;
        this.prior=prior;
    }
}
class TaskManager {
PriorityQueue<pair> pq;
HashMap<Integer,pair> map;
    public TaskManager(List<List<Integer>> tasks) {
        pq=new PriorityQueue<>((a,b)->{
            if(a.prior==b.prior)
            {
                return b.task-a.task;
            }
            return b.prior-a.prior;
        });
        map=new HashMap<>();
        for(List<Integer> k:tasks)
        {
            pq.add(new pair(k.get(0),k.get(1),k.get(2)));
            map.put(k.get(1),new pair(k.get(0),k.get(1),k.get(2)));
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        pq.add(new pair(userId,taskId,priority));
        map.put(taskId,new pair(userId,taskId,priority));
    }
    
    public void edit(int taskId, int newPriority) {
        pair p=map.get(taskId);
        pair update=new pair(p.id,taskId,newPriority);
        pq.add(update);
        map.put(taskId,update);
    }
    
    public void rmv(int taskId) {
        map.remove(taskId);
    }
    
    public int execTop() {
        while(!pq.isEmpty())
        {
            pair p=pq.remove();
            pair rec=map.get(p.task);
            if(rec==null)
            {
                continue;
            }
            if(p.prior!=rec.prior||p.id!=rec.id)
            {
                continue;
            }
            map.remove(p.task);
            return p.id;
        }
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */