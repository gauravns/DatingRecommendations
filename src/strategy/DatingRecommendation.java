package strategy;

import model.User;
import service.UserService;

import java.util.Collections;
import java.util.List;

public class DatingRecommendation implements RecommendationStrategy {
    private UserService userService;

    public DatingRecommendation(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> makeRecommendation(User user) {
        List<User> allUsers = userService.getAllUsers();
        Collections.sort(allUsers, user.SORT_ORDER);
        allUsers.remove(user);
        return allUsers;
    }
}
