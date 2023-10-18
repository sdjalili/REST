package SD.Spring.REST.CRUD.Service;

import SD.Spring.REST.CRUD.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee findEmployeeById(int id);
    List<Employee> findAll();
    Employee save(Employee theEmployee);
    void delete(Integer employeeId);
}
