import java.sql.SQLException;
import java.util.Scanner;

public class UserService {

    private final Scanner scanner = new Scanner(System.in);
    private final UserRepository userRepository = new UserRepository();

    public UserService() throws SQLException {
    }

    public void singUp() throws SQLException {
        System.out.println("Please enter your firstname:");
        String firstname = scanner.nextLine();

        System.out.println("Please enter your lastname:");
        String lastname = scanner.nextLine();

        System.out.println("Please enter your username:");
        String username = scanner.nextLine();

        System.out.println("Please enter your password:");
        String password = scanner.nextLine();

        User user = new User(firstname, lastname, username, password);
        int result = userRepository.registerUser(user);
        if(result == 1)
            System.out.println(firstname + " you successfully register :)");
        else
            System.out.println("something is wrong :|");
    }

    public void signIn() throws SQLException {
        System.out.println("Please enter your username:");
        String username = scanner.nextLine();

        System.out.println("Please enter your password");
        String password = scanner.nextLine();

        User user = userRepository.findByUsername(username);
        if(user == null)
            System.out.println("Please register first");
        else if(!user.getPassword().equals(password))
            System.out.println("Please enter correct password");
        else
        System.out.println("WELCOME " + user.getUsername());
    }
}
