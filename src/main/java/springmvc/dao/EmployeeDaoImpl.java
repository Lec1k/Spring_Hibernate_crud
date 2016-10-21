package springmvc.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import springmvc.model.Employee;

import java.util.List;

/**
 * Created by alvo0416 on 10/11/2016.
 */
@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {
    @Override
    public Employee findById(int id) {
        return getByKey(id);
    }

    @Override
    public void saveEmployee(Employee employee) {
            persist(employee);
    }

    @Override
    public void deleteEmployeeBySsn(String ssn) {
        Query query = getSession().createSQLQuery("delete FROM Employee where ssn =: ssn");
        query.setString("ssn", ssn);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Employee> findAllEmployees() {
        Criteria criteria = createEntityCriteria();
        return (List<Employee>)criteria.list();
    }

    @Override
    public Employee findEmployeeBySsn(String ssn) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("ssn",ssn));
        return (Employee) criteria.uniqueResult();
    }
}
