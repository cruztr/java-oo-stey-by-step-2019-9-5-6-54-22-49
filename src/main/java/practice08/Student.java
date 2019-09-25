package practice08;

public class Student extends Person{
    private Klass klass;

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public String introduce(){
        return super.introduce() + " I am a Student. " + getClassIntroduction();
    }

    private String getClassIntroduction() {
        return isClassLeader() ? String.format("I am Leader of Class %d.", klass.getNumber()) : String.format("I am at Class %d.", klass.getNumber());
    }

    private boolean isClassLeader() {
        return klass.getLeader() != null && klass.getLeader().getName().equals(this.getName());
    }

}
