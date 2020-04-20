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
        SortedMap<Double, User> rankedMatchedUsers = new TreeMap<>(Comparator.reverseOrder());
        for (User otherUser : allUsers) {
            rankedMatchedUsers.put(calcMatchScore(user, otherUser), otherUser);
        }
        return new ArrayList<>(rankedMatchedUsers.values());
    }

    private double calcMatchScore(User u1, User u2) {
        int score = genderMatchScore(u1.getGender(), u2.getGender());
        score += getAgeVariance(u1.getAge(), u2.getAge());
        score += getMatchingHobbyCount(u1.getInterests(), u2.getInterests());
        return score;
    }

    private int getMatchingHobbyCount(List<String> interests1, List<String> interests2) {
        Set<String> hobbies1 = new HashSet<>(interests1);
        Set<String> hobbies2 = new HashSet<>(interests2);
        hobbies1.retainAll(hobbies2);
        return hobbies1.size();
    }

    private double getAgeVariance(Integer age1, Integer age2) {
        double avg = (age1 + age2) / 2.0;
        return -(Math.pow((age1 - avg), 2) + Math.pow((age2 - avg), 2)) / 2;
    }

    private int genderMatchScore(Gender gender1, Gender gender2) {
        return gender1 != gender2 ? 100 : -100;
    }
}
