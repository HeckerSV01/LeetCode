/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap<Integer,Employee> map=new HashMap<>();
    int res=0;
    public void recur(int id)
    {
        Employee e=map.get(id);
        res=res+e.importance;
        for(int k:e.subordinates)
        {
            recur(k);
        }
    }
    public int getImportance(List<Employee> employees, int id) {
        for(Employee e:employees)
        {
            map.put(e.id,e);
        }
        recur(id);
        return res;
    }
}