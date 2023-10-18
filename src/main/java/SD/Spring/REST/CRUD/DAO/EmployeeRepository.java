package SD.Spring.REST.CRUD.DAO;

import SD.Spring.REST.CRUD.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
