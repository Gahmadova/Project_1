import entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import repositories.UserDAO;
import repositories.UserDAOPostgres;

public class UserDAOTests {
    static UserDAO employeeDAO = new UserDAOPostgres();
    @Test
    void create_user_test(){
        User new_employee = new User("Gul1107","Dsc15");
        User saved_user = employeeDAO.createEmployee(new_employee);
        Assertions.assertNotEquals(0,saved_user.getId());
    }
    @Test
    void get_User_By_Id(){
        User gottenUser = employeeDAO.getEmployeeById(1);
        Assertions.assertEquals("Gul1107", gottenUser.getUsername());
    }
}
