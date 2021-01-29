package come.edu.info.manager.service;

import come.edu.info.manager.dao.BaseStudentDao;
import come.edu.info.manager.dao.NewStudentDao;
import come.edu.info.manager.dao.StudentDao;
import come.edu.info.manager.domain.Student;
import come.edu.info.manager.factory.StudentDaoFactory;

public class StudentService {
    //private StudentDao studentDao = new StudentDao();

    //集合改进
    //private NewStudentDao studentDao = new NewStudentDao();

    //多态改进
    private final BaseStudentDao studentDao = StudentDaoFactory.getStudentDao();

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
