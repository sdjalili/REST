package SD.Spring.REST.CRUD.Service;


import SD.Spring.REST.CRUD.Entity.User;

import java.util.List;

public interface EmployeeService {
    User findEmployeeById(int id);
    List<User> findAll();
    User save(User theEmployee);
    void delete(Integer employeeId);
}
