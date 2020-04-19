package service;

import factory.InputFactory;
import model.Gender;
import model.InputType;
import model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RecommendationServiceTest {
    RecommendationService recommendationService;
    User user;
    @Before
    public void setUp(){
        InputService inputService = InputFactory.getInputFrom(InputType.FILE);
        UserService userService = new UserService();
        recommendationService = new RecommendationService(userService);

        List<String> inputs = inputService.readInput();
        userService.storeUsers(inputs);

        user = getDummyUser();
    }

    @Test
    public void getAllRecommendationForUser() throws Exception {
        List<User> recommendedUsers = recommendationService.getAllRecommendationForUser(user);
        assertEquals("UserA", recommendedUsers.get(0).getName());
        assertEquals("UserD", recommendedUsers.get(1).getName());
        assertEquals("UserE", recommendedUsers.get(2).getName());
        assertEquals("UserC", recommendedUsers.get(3).getName());

    }

    @Test
    public void getTopRecommendations() throws Exception {
        List<User> recommendedUsers = recommendationService.getTopRecommendations(user,2);
        assertEquals("UserA", recommendedUsers.get(0).getName());
        assertEquals("UserD", recommendedUsers.get(1).getName());

    }

    private User getDummyUser() {
        String name = "UserB";
        int age = 27;
        Gender gender = Gender.MALE;
        List<String> interests = Arrays.asList(new String[] {"Cricket", "Football", "Movies"});
        return new User(name, age, gender, interests);
    }

}