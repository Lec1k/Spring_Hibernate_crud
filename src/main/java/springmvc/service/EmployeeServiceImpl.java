package springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springmvc.dao.EmployeeDao;
import springmvc.model.Employee;

import java.util.List;

/**
 * Created by alvo0416 on 10/21/2016.
 */

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao dao;




    @Override
    public Employee findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void saveEmployee(Employee employee) {
            dao.saveEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
            Employee employeeToUpdate = dao.findById(employee.getId());
            if(employeeToUpdate!=null){
                employeeToUpdate.setSalary(employee.getSalary());
                employeeToUpdate.setJoiningDate(employee.getJoiningDate());
                employeeToUpdate.setName(employee.getName());
                employeeToUpdate.setSsn(employee.getSsn());
            }
    }

    @Override
    public void deleteEmployeeBySsn(String ssn) {
            dao.deleteEmployeeBySsn(ssn);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return dao.findAllEmployees();
    }

    @Override
    public Employee findEmployeeBySsn(String ssn) {
        return dao.findEmployeeBySsn(ssn);
    }

    @Override
    public boolean isEmployeeSsnUnique(Integer id, String ssn) {
        Employee employee = dao.findEmployeeBySsn(ssn);
        return ( employee == null || ((id != null) && (employee.getId() == id)));
    }
}
