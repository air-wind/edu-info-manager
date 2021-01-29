package come.edu.info.manager.factory;

import come.edu.info.manager.dao.BaseStudentDao;
import come.edu.info.manager.dao.NewStudentDao;

public class StudentDaoFactory {
    public static BaseStudentDao getStudentDao() {
        return new NewStudentDao();
    }
}
