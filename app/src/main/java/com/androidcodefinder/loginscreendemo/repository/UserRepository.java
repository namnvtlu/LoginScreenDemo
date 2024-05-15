package com.androidcodefinder.loginscreendemo.repository;

import com.androidcodefinder.loginscreendemo.model.User;

import java.util.ArrayList;

public class UserRepository {
    private static ArrayList<User> userData  = new ArrayList<>();

    public static ArrayList<User> getUserData() {
        return userData;
    }

    public static void setUserData(ArrayList<User> userData) {
        UserRepository.userData = userData;
    }

    public boolean checkExistedUser(User u){
        for (User user: userData) {
            if (user.getUsername().toString().equals(u.getUsername().toString()) &&
                    user.getPassword().toString().equals(u.getPassword().toString())){
                return true;
            }
        }
        return false;
    }
    public void addUser(User u){
        userData.add(u);
    }
    public void removeUser(User u){
        userData.remove(u);
    }
    public User getUser(String username){
        for (User u : userData ) {
            if (username.equals(u.getUsername())){
                return u;
            }
        }
        return null;
    }
}
