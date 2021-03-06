package ua.ternopil.igorbendera.service;

import ua.ternopil.igorbendera.domain.User;
import ua.ternopil.igorbendera.shared.AbstractCRUD;

public interface UserService extends AbstractCRUD<User> {
}


//package ua.ternopil.igorbendera.service;
//
//        import ua.ternopil.igorbendera.domain.User;
//
//        import java.util.ArrayList;
//        import java.util.List;
//
//public class UserService {
//    private List<User> users = new ArrayList<>();
//    private static UserService userService;
//
//    private UserService() { }
//
//    public static UserService getUserService() {
//        if(userService == null) {
//            userService = new UserService();
//        }
//        return userService;
//    }
//
//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void saveUser(User user) {
//        users.add(user);
//    }
//
//    public User getParticularUser(String email) {
//        return users.stream().filter(user -> user.getEmail().equals(email)).findAny().orElse(null);
//    }
//}
