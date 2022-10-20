package repositories;

import org.example.Employees;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeesDAOLocal implements EmployeesDAO{

    private int idCount = 1;
    private Map<Integer,Employees> employessInfo = new HashMap();
    @Override
    public Employees creatEmployees(Employees employees) {
        employees.setId(idCount);
        idCount++;
        employessInfo.put(Employees.getID(),employees);

        return employees;
    }

    @Override
    public Employees getEmployeesID(int id) {
        return null;
    }

    @Override
    public List<Employees> getAllEmployees() {
        return null;
    }

    @Override
    public Employees updateEmployees(Employees employees) {
        return null;
    }

    @Override
    public boolean deleteEmployees(int id) {
        return false;
    }
}
