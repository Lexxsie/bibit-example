package services;

import models.User;
import database.UserDataStore;
import database.DataStore;

import java.util.List;

public class AuthenticationService {

    public static User login(String email, String password) {
        for (User u : DataStore.users) {
            if (u.getEmail().equalsIgnoreCase(email) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    public static User register(String nama, String email, String nomorHP, String password) {
        String userId = "U" + System.currentTimeMillis();
        User newUser = new User(userId, nama, email, nomorHP, password);
        DataStore.users.add(newUser);
        UserDataStore.saveUsers(DataStore.users);
        return newUser;
    }
}
