package practice06;

public class Teacher extends Person{
    private int klass;

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, int klass) {
        super(name, age);
        this.klass = klass;
    }

    public int getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        return super.introduce() + " I am a Teacher. " + getTeacherClassIntroduction();
    }

    private String getTeacherClassIntroduction() {
        return klass == 0 ? "I teach No Class." : String.format("I teach Class %d.", klass);
    }
}
