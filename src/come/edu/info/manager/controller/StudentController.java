package come.edu.info.manager.controller;

import come.edu.info.manager.domain.Student;
import come.edu.info.manager.service.StudentService;

import java.util.Scanner;

public class StudentController {
    private StudentService studentService = new StudentService();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        studentloop:
        while (true) {
            System.out.println("--------欢迎来到 <学生> 管理系统--------");
            System.out.println("请输入您的选择: 1.添加学生  2.删除学生  3.修改学生  4.查看学生  5.退出");
            Scanner sc = new Scanner(System.in);
            String choice = sc.next();
            switch (choice) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    deleteStudentById();
                    break;
                case "3":
                    modifyStudent();
                    break;
                case "4":
                    showStudents();
                    break;
                case "5":
                    System.out.println("退出成功");
                    break studentloop;
                default:
                    System.out.println("输入有误！");
            }
        }
    }

    //修改学生
    private void modifyStudent() {
        String sid = inputStudentId();
        Student student = inputStudentInfo(sid);
        studentService.modifyStudent(sid, student);
        System.out.println("修改成功！");
    }

    //删除学生信息
    private void deleteStudentById() {
        String sid = inputStudentId();

        studentService.deleteStudentById(sid);
        System.out.println("删除成功！");
    }

    private String inputStudentId() {
        String sid;
        while (true) {
            System.out.println("请输入学生的学号:");
            sid = sc.next();
            if (studentService.isExit(sid)) {
                break;
            } else {
                System.out.println("无此学生信息，请重新输入！");
            }
        }
        return sid;
    }

    //显示学生信息
    private void showStudents() {
        Student[] students = studentService.findAllStudents();
        if (students == null) {
            System.out.println("暂无信息");
        } else {
            System.out.println("学号\t姓名\t年龄\t生日");
            for (int i = 0; i < students.length; i++) {
                Student student = students[i];
                if (student != null) {
                    System.out.println(student.getSid() + "\t" + student.getName() + "\t" +
                            student.getAge() + "\t" + student.getBirthday());
                }
            }
        }
    }

    //添加学生
    private void addStudent() {
        String sid;
        while (true) {
            System.out.println("请输入学号:");
            sid = sc.next();
            if (studentService.isExit(sid)) {
                System.out.println("改学生信息已经存在！");
            } else {
                break;
            }
        }
        Student student = inputStudentInfo(sid);
        boolean res = studentService.addStudent(student);
        if (res) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    private Student inputStudentInfo(String sid) {
        System.out.println("请输入姓名:");
        String name = sc.next();

        System.out.println("请输入年龄:");
        String age = sc.next();

        System.out.println("请输入生日:");
        String birthday = sc.next();

        return new Student(sid, name, age, birthday);
    }
}
