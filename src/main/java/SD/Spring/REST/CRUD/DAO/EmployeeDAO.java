package SD.Spring.REST.CRUD.DAO;

import SD.Spring.REST.CRUD.Entity.User;

import java.util.List;

public interface EmployeeDAO {
    List<User> findAll();
    User findById(int id);
    User save(User theEmployee);
    User deleteById(int id);
}
