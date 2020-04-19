package service;

import model.Gender;
import model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserService {
    List<User> users;

    public List<User> getAllUsers() {
        return users;
    }

    public void storeUsers(List<String> inputs) {
        users = parseInputList(inputs);
    }

    public User getDummyUser() {
        String name = "UserB";
        int age = 27;
        Gender gender = Gender.MALE;
        List<String> interests = Arrays.asList(new String[] {"Cricket", "Football", "Movies"});
        return new User(name, age, gender, interests);
    }

    private List<User> parseInputList(List<String> inputs) {
        List<User> users = new ArrayList<>();
        for(String input : inputs) {
            User user = createUser(input);
            users.add(user);
        }
        return users;
    }

    private User createUser(String input) {
        String[] userInfo = input.split("-");
        String name = userInfo[0];
        int age = Integer.parseInt(userInfo[1]);
        Gender gender = userInfo[2].equalsIgnoreCase("Male") ? Gender.MALE : Gender.FEMALE;
        List<String> interests = Arrays.asList(userInfo[3].split(","));

        return new User(name, age, gender, interests);
    }
}
