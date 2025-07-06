class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        List<Integer> res=new ArrayList<>();
        HashSet<String> s1=new HashSet<>();
        HashSet<String> s2=new HashSet<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
        int sa = map.get(a);
        int sb = map.get(b);
        if(sa != sb) 
        return sb - sa;
        return a - b;
        });
        for(int i=0;i<positive_feedback.length;i++)
        {
            s1.add(positive_feedback[i]);
        }
        for(int i=0;i<negative_feedback.length;i++)
        {
            s2.add(negative_feedback[i]);
        }
        int scorearr[]=new int[student_id.length];
        for(int i=0;i<student_id.length;i++)
        {
            String words[]=report[i].split(" ");
            for(String st:words)
            {
                if(s1.contains(st))
                {
                    scorearr[i]=scorearr[i]+3;
                }
                else if(s2.contains(st))
                {
                    scorearr[i]=scorearr[i]-1;
                }
            }
        }
        for(int i=0;i<student_id.length;i++)
        {
            map.put(student_id[i],scorearr[i]);
        }
        for(int i=0;i<student_id.length;i++)
        {
            pq.add(student_id[i]);
        }
        for(int i=0;i<k&&!pq.isEmpty();i++)
        {
            res.add(pq.remove());
        }
        return res;
    }
}