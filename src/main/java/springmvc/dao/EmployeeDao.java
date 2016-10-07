package springmvc.dao;

import springmvc.model.Employee;

import java.util.List;

/**
 * Created by alvo0416 on 9/30/2016.
 */
public interface EmployeeDao {
    Employee findById(int id);

    void saveEmployee(Employee employee);

    void deleteEmployeeBySsn(String ssn);

    List<Employee> findAllEmployees();

    Employee findEmployeeBySsn(String ssn);
}
