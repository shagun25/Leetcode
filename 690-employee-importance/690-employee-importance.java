/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        int total =0;
        Queue<Employee> queue = new LinkedList<>();
        queue.add(map.get(id));
        while(!queue.isEmpty()){
            Employee emp=queue.poll();
            total+=emp.importance;
            for(int sub : emp.subordinates){
                queue.add(map.get(sub));
            }
        }
        return total;
    }
}