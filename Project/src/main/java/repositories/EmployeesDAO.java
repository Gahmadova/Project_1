package repositories;

import org.example.Employees;

import java.util.List;

public interface EmployeesDAO {

    Employees creatEmployees(Employees employees);
    Employees getEmployeesID(int id);

    List<Employees>getAllEmployees();

    Employees updateEmployees(Employees employees);

    boolean deleteEmployees(int id);
}
