package strategy;

import model.User;

import java.util.List;

public interface RecommendationStrategy {
    List<User> makeRecommendation(User user);

}
