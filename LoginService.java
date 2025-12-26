package Metro;

import java.util.HashMap;
import java.util.Map;

public class LoginService {

    private Map<String, UserAccount> users = new HashMap<>();

    public LoginService() {
        // Default users
        users.put("admin", new UserAccount("admin", "admin123", "ADMIN"));
        users.put("user", new UserAccount("user", "user123", "USER"));
    }

    public String login(String username, String password)
            throws AuthenticationException {

        if (!users.containsKey(username)) {
            throw new AuthenticationException("User not found");
        }

        UserAccount account = users.get(username);

        if (!account.getPassword().equals(password)) {
            throw new AuthenticationException("Invalid password");
        }

        return account.getRole();
    }
}
