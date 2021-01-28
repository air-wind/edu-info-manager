package come.edu.info.manager.service;

import come.edu.info.manager.dao.StudentDao;
import come.edu.info.manager.domain.Student;

public class StudentService {
    private StudentDao studentDao = new StudentDao();

    public boolean addStudent(Student student) {
        return studentDao.addStudent(student);
    }


    public boolean isExit(String sid) {
        Student[] allStudent = studentDao.findAllStudent();
        for (int i = 0; i < allStudent.length; i++) {
            Student student = allStudent[i];
            if (student != null && sid.equals(allStudent[i].getSid())) {
                return true;
            }
        }
        return false;
    }

    public Student[] findAllStudents() {
        Student[] students = studentDao.findAllStudent();

        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                return students;
            }
        }
        return null;
    }


    public void deleteStudentById(String sid) {
        studentDao.deleteStudentById(sid);
    }

    public void modifyStudent(String sid, Student student) {
        studentDao.modifyStudent(sid, student);
    }
}
