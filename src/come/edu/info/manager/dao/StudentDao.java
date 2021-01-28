package come.edu.info.manager.dao;

import come.edu.info.manager.domain.Student;

public class StudentDao {
    private static Student[] students = new Student[5];

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

    private int getStudentById(String sid) {
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
