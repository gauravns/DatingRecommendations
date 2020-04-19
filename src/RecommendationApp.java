import factory.InputFactory;
import model.InputType;
import model.User;
import service.InputService;
import service.RecommendationService;
import service.UserService;

import java.util.List;

public class RecommendationApp {

    public static void main(String[] args) {
        InputService inputService = InputFactory.getInputFrom(InputType.FILE);
        UserService userService = new UserService();
        RecommendationService recommendationService = new RecommendationService(userService);

        List<String> inputs = inputService.readInput();
        userService.storeUsers(inputs);
        User user = userService.getDummyUser();
        recommendationService.getTopRecommendations(user, 2);
    }
}
