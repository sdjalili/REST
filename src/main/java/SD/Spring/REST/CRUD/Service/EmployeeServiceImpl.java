package SD.Spring.REST.CRUD.Service;


import SD.Spring.REST.CRUD.Entity.User;
import SD.Spring.REST.CRUD.Entity.UserRepository;
import SD.Spring.REST.CRUD.Exception.Employee.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    //previous method for declaring DAO layer
    //private EmployeeDAO employeeDAO;
    //new approach to Spring Data JPA
    private UserRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(UserRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }
    @Override
    public User findEmployeeById(int id) {
        Optional<User> operationalEmployee = employeeRepository.findById(id);
        if(operationalEmployee.isPresent()) {
            return operationalEmployee.get();
        }else {
            throw new EmployeeNotFoundException("Employee not found with id = " + id);
        }
    }

    @Override
    public List<User> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public User save(User theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    @Transactional
    public void delete(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
