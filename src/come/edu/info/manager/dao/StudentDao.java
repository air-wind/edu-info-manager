package come.edu.info.manager.dao;

import come.edu.info.manager.domain.Student;

public class StudentDao implements BaseStudentDao {
    private static final Student[] students = new Student[5];

    static {
        Student student1 = new Student("2000", "xiaoming", "12", "1999");
        Student student2 = new Student("2001", "xiaowang", "12", "1999");
        Student student3 = new Student("2002", "xiaozhang", "12", "1999");
        students[0] = student1;
        students[1] = student2;
        students[2] = student3;
    }

    public boolean addStudent(Student student) {
        int index = -1;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false;
        } else {
            students[index] = student;
            return true;
        }

    }

    public Student[] findAllStudent() {
        return students;
    }

    public void deleteStudentById(String sid) {
        int index = getStudentById(sid);
        if (index != -1) {
            students[index] = null;
        }
    }

    public int getStudentById(String sid) {
        int index = -1;
        for (int i = 0; i < students.length; i++) {
            if (sid.equals(students[i].getSid())) {
                index = i;
                return index;
            }
        }
        return index;
    }

    public void modifyStudent(String sid, Student student) {
        int index = getStudentById(sid);
        if (index != -1) {
            students[index] = student;
        }
    }
}
