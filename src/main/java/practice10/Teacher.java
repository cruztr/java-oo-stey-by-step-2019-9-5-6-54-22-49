package practice10;

import java.util.LinkedList;

public class Teacher extends Person{
    private LinkedList<Klass> klassList;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, LinkedList<Klass> klassList) {
        super(id, name, age);
        this.klassList = klassList;
    }

    public LinkedList<Klass> getClasses() {
        return klassList;
    }

    @Override
    public String introduce() {
        return super.introduce() + " I am a Teacher. " + getTeacherClassIntroduction();
    }

    public String introduceWith(Student student) {
        return super.introduce() + " I am a Teacher. " + getIntroduceWithStudent(student);
    }

    public boolean isTeaching(Student student) {
        return klassList.stream()
                .anyMatch(klass -> klass.getNumber() == student.getKlass().getNumber());
    }

    private String getTeacherClassIntroduction() {
        if(klassList == null || klassList.isEmpty()) {
            return "I teach No Class.";
        }

        StringBuilder builder = new StringBuilder();
        klassList.forEach(c -> {
            if(klassList.getLast().getNumber() != c.getNumber())
                builder.append(c.getNumber()).append(", ");
            else
                builder.append(c.getNumber()).append(".");
        });
        return "I teach Class " + builder.toString();
    }

    private String getIntroduceWithStudent(Student student) {
        return isSameClassWithTeacher(student) ? String.format("I teach %s.", student.getName()) : String.format("I don't teach %s.", student.getName());
    }

    private boolean isSameClassWithTeacher(Student student) {
        return this.klassList.stream()
                .anyMatch(klass -> klass.getNumber() == student.getKlass().getNumber());

    }
}
