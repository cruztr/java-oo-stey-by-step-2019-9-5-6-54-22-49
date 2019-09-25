package practice11;

import java.util.*;

public class Teacher extends Person implements Observer {
    private LinkedList<Klass> klassList;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, LinkedList<Klass> klassList) {
        super(id, name, age);
        this.klassList = klassList;
        this.klassList.forEach(klass -> klass.addObserver(this));
    }

    public LinkedList<Klass> getClasses() {
        return klassList;
    }

    @Override
    public void update(Observable o, Object studentObj) {
        Student student = (Student) studentObj;

        for(Klass klass : klassList){
            if(student.isIn(klass))
                System.out.print(String.format("I am %s. I know %s has joined %s.\n", this.getName(),
                        student.getName(), klass.getDisplayName()));
            if(student.equals(klass.getLeader())) {
                System.out.print(String.format("I am %s. I know %s become Leader of %s.\n", this.getName(),
                        student.getName(), klass.getDisplayName()));
            }
        }
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
        StringBuilder builder = new StringBuilder();

        if(klassList == null || klassList.isEmpty()) {
            return "I teach No Class.";
        }

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
