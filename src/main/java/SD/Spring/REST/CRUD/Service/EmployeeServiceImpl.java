package SD.Spring.REST.CRUD.Service;

import SD.Spring.REST.CRUD.DAO.EmployeeDAO;
import SD.Spring.REST.CRUD.Entity.Employee;
import SD.Spring.REST.CRUD.Exception.Employee.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    //previous method for declaring DAO layer
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }
    @Override
    public Employee findEmployeeById(int id) {
        Optional<Employee> operationalEmployee = Optional.ofNullable(employeeDAO.findById(id));
        if(operationalEmployee.isPresent()) {
            return operationalEmployee.get();
        }else {
            throw new EmployeeNotFoundException("Employee not found with id = " + id);
        }
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Override
    @Transactional
    public void delete(Integer employeeId) {
        employeeDAO.deleteById(employeeId);
    }
}
