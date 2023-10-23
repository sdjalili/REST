package SD.Spring.REST.CRUD.REST;


import SD.Spring.REST.CRUD.Entity.User;
import SD.Spring.REST.CRUD.Exception.Employee.EmployeeNotFoundException;
import SD.Spring.REST.CRUD.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeREST {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeREST(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees/{employeeId}")
    public User getEmployee(@PathVariable int employeeId) {
        User theEmployee = null;
        theEmployee = employeeService.findEmployeeById(employeeId);
        if(employeeId <=0 || theEmployee ==null) {
            throw new EmployeeNotFoundException("Employee not found with id = " + employeeId);
        }
        return theEmployee;
    }
    @GetMapping("/employees")
    public List<User> getAllEmployees(){
        return employeeService.findAll();
    }
    @PostMapping("/employees")
    public User insertEmployee(@RequestBody User theEmployee){
         return employeeService.save(theEmployee);
    }
    @PutMapping("/employees")
    public User updateEmployee(@RequestBody User theEmployee){
       return employeeService.save(theEmployee);
    }
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        User deletedEmployee = employeeService.findEmployeeById(employeeId);
        employeeService.delete(employeeId);
        return "The Employee " + deletedEmployee.getFistName() + " " + deletedEmployee.getLastName()+
                " with id = " + deletedEmployee.getId() + " deleted.";
    }
}
