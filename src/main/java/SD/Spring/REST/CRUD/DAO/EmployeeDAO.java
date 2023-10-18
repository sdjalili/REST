package SD.Spring.REST.CRUD.DAO;

import SD.Spring.REST.CRUD.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee theEmployee);
    Employee deleteById(int id);
}
