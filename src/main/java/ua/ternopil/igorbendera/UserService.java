package ua.ternopil.igorbendera;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();
    private static UserService userService;

    private UserService() { }

    public static UserService getUserService() {
        if(userService == null) {
            userService = new UserService();
        }
        return userService;
    }

    public List<User> getUsers() {
        return users;
    }

    public void saveUser(User user) {
        users.add(user);
    }

    public User getParticularUser(String email) {
        return users.stream().filter(user -> user.getEmail().equals(email)).findAny().orElse(null);
    }
}
