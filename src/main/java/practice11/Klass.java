package practice11;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Klass extends Observable {
    private int number;
    private Student leader;
    private List<Student> studentList;

    public Klass(int number) {
        this.number = number;
        studentList = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public Student getLeader() {
        return leader;
    }

    public String getDisplayName() {
        return "Class " + number;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void assignLeader(Student student) {
        if(this.studentList.contains(student)) {
            this.leader = student;
            setChanged();
            notifyObservers(student);
        } else
            System.out.print("It is not one of us.\n");
    }

    public void appendMember(Student student) {
        student.setKlass(this);
        this.studentList.add(student);

        setChanged();
        notifyObservers(student);
    }
}
