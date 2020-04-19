package service;

import model.User;
import strategy.DatingRecommendation;
import strategy.RecommendationStrategy;

import java.util.ArrayList;
import java.util.List;

public class RecommendationService {
    private UserService userService;
    private RecommendationStrategy recommendationStrategy;

    public RecommendationService(UserService userService) {
        this.userService = userService;
        this.recommendationStrategy = new DatingRecommendation(userService);
    }

    public List<User> getAllRecommendationForUser(User user) {
        return getRecommendations(user);
    }

    public List<User> getTopRecommendations(User user, int top) {
        return getRecommendations(user, top);
    }

    private List<User> getRecommendations(User user, int top) {
        List<User> allRecommendations = getRecommendations(user);
        List<User> topRecommendations = new ArrayList<>();
        for(int i = 0; i < top; i++) {
            topRecommendations.add(allRecommendations.get(i));
        }
        return topRecommendations;
    }

    private List<User> getRecommendations(User user) {
        return recommendationStrategy.makeRecommendation(user);
    }
}
