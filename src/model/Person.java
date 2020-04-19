package model;

public abstract class Person {

    protected String name;
    protected Gender gender;
    protected Integer age;

    public Person(String name, Gender gender, Integer age) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object obj) {
        Person person = (Person) obj;

        return this.name.equals(person.name) &&
                this.gender.equals(person.gender) &&
                this.age.equals(person.age);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
