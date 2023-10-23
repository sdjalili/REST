package SD.Spring.REST.CRUD.DAO;


import SD.Spring.REST.CRUD.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager){
        this.entityManager=theEntityManager;
    }
    @Override
    public List<User> findAll() {
        TypedQuery<User> theQuery = entityManager.createQuery("from Employee",User.class);
        return theQuery.getResultList();
    }

    @Override
    public User findById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User save(User theEmployee) {
        //if employee id be equals to 0 then entity manager inserts the employee as e new record. otherwise it will be updated.
        return entityManager.merge(theEmployee);
    }

    @Override
    public User deleteById(int id) {
        User theEmployee = entityManager.find(User.class, id);
        entityManager.remove(theEmployee);
        return theEmployee;
    }
}
