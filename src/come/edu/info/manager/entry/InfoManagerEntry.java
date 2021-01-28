package come.edu.info.manager.entry;

import come.edu.info.manager.controller.StudentController;

import java.util.Scanner;

public class InfoManagerEntry {
    public static void main(String[] args) {
        while (true) {
            System.out.println("--------欢迎来到黑马信息管理系统--------");
            System.out.println("请输入您的选择: 1.学生管理  2.老师管理  3.退出");
            Scanner sc = new Scanner(System.in);
            String choice = sc.next();
            switch (choice) {
                case "1":
                    StudentController studentController = new StudentController();
                    studentController.start();
                    break;
                case "2":
                    System.out.println("此功能与学生管理相同，暂不实现！");
                    break;
                case "3":
                    System.out.println("退出成功");
                    System.exit(0);
                default:
                    System.out.println("输入有误！");
            }
        }
    }
}
