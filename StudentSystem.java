package javaliu;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public static void startStudentSystem() {
        ArrayList<Student> list = new ArrayList<>();
       loop : while (true) {
                System.out.println("-----------欢迎来到学生管理系统-----------");
                System.out.println("           1:添加学生信息");
                System.out.println("           2:删除学生信息");
                System.out.println("           3:修改学生信息");
                System.out.println("           4:查询学生信息");
                System.out.println("           5:退出管理系统");
                System.out.println("请输入您的选择：");
                Scanner sc = new Scanner(System.in);
                String choose = sc.next();
                switch (choose){
                    case "1": addStudent(list);
                    break ;
                    case "2": deleteStudent(list);
                    break ;
                    case "3": updateStudent(list);
                    break ;
                    case "4": queryStudent(list);
                    break ;
                    case "5": {System.out.println("退出管理系统");
                    break loop;}
                    default:
                        System.out.println("没有这个选项");
                }
            }

    }
    public static void addStudent(ArrayList<Student> list){
        Student s = new Student();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("输入学生id");
            String id = sc.next();
            boolean flag = contains(list,id);
            if(flag){
                s.setId(id);
                break;
            }else {
                System.out.println("id已经存在，请重新输入");
            }
        }

        System.out.println("输入学生的姓名");
        String name = sc.next();
        s.setName(name);
        System.out.println("输入学生的年龄");
        int age = sc.nextInt();
        s.setAge(age);
        System.out.println("输入学生的家庭地址");
        String address = sc.next();
        s.setAddress(address);
        list.add(s);
        System.out.println("学生信息添加成功");



    }
    public static void deleteStudent(ArrayList<Student> list){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除学生的id");
        String id = sc.next();
        int index = getIndex(list,id);
        if(index >= 0){
            list.remove(index);
            System.out.println("id为"+id+"的学生信息已经删除");
        }else {
            System.out.println("id不存在");
        }
    }
    public static void updateStudent(ArrayList<Student> list){
        System.out.println("要修改的学生ID：");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int index = getIndex(list,id);
        if(index == -1){
            System.out.println("要修改的学生" + id + "不存在，请重新输入");
            return;
        }
        Student stu = list.get(index);
        System.out.println("请输入要修改的姓名");
        String newName = sc.next();
        stu.setName(newName);
        System.out.println("请输入要修改的年龄");
        int newAge = sc.nextInt();
        stu.setAge(newAge);
        System.out.println("请输入要修改的家庭地址");
        String newAddress = sc.next();
        stu.setAddress(newAddress);
        System.out.println("学生信息修改成功");



    }
    public static void queryStudent(ArrayList<Student> list){
        if(list.size() == 0){
            System.out.println("当前无学生信息，请添加后再查询");
            return;
        }
        System.out.println("id\t姓名\t年龄\t家庭住址\t");
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getId()+"\t"+stu.getName()+"\t\t"+stu.getAge()+"\t\t"+stu.getAddress());
        }
    }
    public static boolean contains(ArrayList<Student> list,String id){
        return getIndex(list,id) < 0;
//        for (int i = 0; i < list.size(); i++) {
//            if(list.get(i).getId().equals(id)){
//                return false;
//            }
//        }
//        return true;
    }
    public static int getIndex(ArrayList<Student> list,String id){
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            if(stu.getId().equals(id)){
                return i;
            }
        }
        return -1;
    }






}


