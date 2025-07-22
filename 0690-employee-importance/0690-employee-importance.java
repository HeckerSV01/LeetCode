/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    int res=0;
    public void recur(List<Employee> list,Employee e)
    {
        if(e==null)
        {
            return;
        }
        res=res+e.importance;
        for(int k:e.subordinates)
        {
            recur(list,get(list,k));
        }
    }
    public Employee get(List<Employee> employees, int id)
    {
        for(Employee e:employees)
        {
            if(e.id==id)
            {
                return e;
            }
        }
        return null;
    }
    public int getImportance(List<Employee> employees, int id) {
        recur(employees,get(employees,id));
        return res;
    }
}