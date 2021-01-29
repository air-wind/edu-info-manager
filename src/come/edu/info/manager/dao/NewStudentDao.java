package come.edu.info.manager.dao;

import come.edu.info.manager.domain.Student;

import java.util.ArrayList;

public class NewStudentDao implements BaseStudentDao {
    private static final ArrayList<Student> students = new ArrayList<>();

    static {
        Student student1 = new Student("2000", "xiaoming", "12", "1999");
        Student student2 = new Student("2001", "xiaowang", "12", "1999");
        Student student3 = new Student("2002", "xiaozhang", "12", "1999");
        students.add(student1);
        students.add(student2);
        students.add(student3);
    }

    public boolean addStudent(Student student) {
        return students.add(student);
    }

    public Student[] findAllStudent() {
        Student[] studentArray = new Student[students.size()];
        for (int i1 = 0; i1 < students.size(); i1++) {
            studentArray[i1] = students.get(i1);
        }
        return studentArray;
    }

    public void deleteStudentById(String sid) {
        int index = getStudentById(sid);
        if (index != -1) {
            students.remove(index);
        }
    }

    public int getStudentById(String sid) {
        int index = -1;
        for (int i = 0; i < students.size(); i++) {
            if (sid.equals(students.get(i).getSid())) {
                index = i;
                return index;
            }
        }
        return index;
    }

    public void modifyStudent(String sid, Student student) {
        int index = getStudentById(sid);
        if (index != -1) {
            students.set(index, student);
        }
    }
}
