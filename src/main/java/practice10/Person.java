package practice10;

public class Person {
    private int id;
    private String name;
    private int age;

    public Person(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String introduce(){
        return String.format("My name is %s. I am %d years old.", name, age);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.id + this.age;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Person && this.id == ((Person) obj).id && this.age == ((Person) obj).age && this.name.equals(((Person) obj).name);
    }
}
