package come.edu.info.manager.dao;

import come.edu.info.manager.domain.Student;

public interface BaseStudentDao {
    public abstract boolean addStudent(Student student);

    public abstract Student[] findAllStudent();

    public abstract void deleteStudentById(String sid);

    public abstract int getStudentById(String sid);

    public abstract void modifyStudent(String sid, Student student);
}