package practice08;

public class Teacher extends Person{
    private Klass klass;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        return super.introduce() + " I am a Teacher. " + getTeacherClassIntroduction();
    }

    public String introduceWith(Student student) {
        return super.introduce() + " I am a Teacher. " + getIntroduceWithStudent(student);
    }

    private String getTeacherClassIntroduction() {
        return klass == null ? "I teach No Class." : String.format("I teach Class %d.", klass.getNumber());
    }

    private String getIntroduceWithStudent(Student student) {
        return isSameClassWithTeacher(student) ? String.format("I teach %s.", student.getName()) : String.format("I don't teach %s.", student.getName());
    }

    private boolean isSameClassWithTeacher(Student student) {
        return this.klass.getNumber() == student.getKlass().getNumber();
    }
}
