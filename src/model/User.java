package model;

import java.util.Comparator;
import java.util.List;

public class User extends Person {

    private List<String> interests;
    
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        User user = (User) o;
        return interests.equals(user.interests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), interests);
    }
}
