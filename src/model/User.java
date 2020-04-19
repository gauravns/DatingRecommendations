package model;

import java.util.Comparator;
import java.util.List;

public class User extends Person {

    private List<String> interests;

    public final Comparator<User> SORT_ORDER = new SortOrder();

    public User(String name, Integer age, Gender gender, List<String> interests) {
        super(name, gender, age);
        this.interests = interests;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public Gender getGender() {
        return this.gender;
    }

    public List<String> getInterests() {
        return this.interests;
    }

    @Override
    public boolean equals(Object obj) {
        User user = (User) obj;
        return super.equals(obj) && user.interests.equals(this.interests);
    }

    private class SortOrder implements Comparator<User> {

        public int compare(User user1, User user2) {
            User currentUser = User.this;
            Gender oppositeGender = currentUser.gender == Gender.MALE ? Gender.FEMALE : Gender.MALE;
            List<String> currentUserInterest = currentUser.interests;

            if(user1.gender == oppositeGender && user2.gender !=oppositeGender)
                return -1;

            if(user1.gender != oppositeGender && user2.gender == oppositeGender)
                return 1;

            int ageDiff1 = Math.abs(currentUser.age - user1.age);
            int ageDiff2 = Math.abs(currentUser.age - user2.age);

            if(ageDiff1 < ageDiff2)
                return -1;

            if(ageDiff1 > ageDiff2)
                return 1;

            currentUserInterest.retainAll(user1.interests);
            int size1 = currentUserInterest.size();
            currentUserInterest = currentUser.interests;
            currentUserInterest.retainAll(user2.interests);
            int size2 = currentUserInterest.size();

            if(size1 > size2)
                return -1;
            else
                return 1;
        }
    }
}
