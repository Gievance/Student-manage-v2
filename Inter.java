package version2;

import com.alibaba.druid.support.json.JSONUtils;
import version2.StudenDAO.BasicDao;
import version2.StudenDAO.StudentDaoImple;
import version2.bean.Student;

import javax.swing.border.Border;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.setOut;

public class Inter extends StudentDaoImple {
    public void show(){
        System.out.println("-----请选择你要执行的功能------");
        System.out.println("10:添加一个学生");
        System.out.println("11:根据ID查找一个学生");
        System.out.println("12:获取所有学生");
        System.out.println("13:根据页数获取学生");
        System.out.println("14:根据ID删除");
        System.out.println("15:删除所有");
        System.out.println("16:更新学生");
        System.out.println("17:退出系统");
        System.out.println("----------------------------");
    }

    public void start() throws SQLException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        boolean flag=true;
        while(flag) {
            show();
            System.out.print("输入序号：");
            String s = sc.nextLine();
            if (s.equals("17"))
            {flag=false;
            }
            boolean check = check(s);
            if (check) {
                int i = Integer.parseInt(s);
                order(i);
                sleep();
            }
        }
    }

    private void order(int i) throws SQLException {
        Scanner sc = new Scanner(System.in);
        switch(i)
        {
            case 10:createStudent();break;
            case 11:searchById(sc);break;
            case 12:searchAll();break;
            case 13:searchByPage(sc);break;
            case 14:{searchAll();delByID(sc);}break;
            case 15:deleteAll();break;
            case 16:change(sc);break;
            default:exit(0);
        }
    }

    private void change(Scanner sc) throws SQLException {
        System.out.println("请输入信息:ID Name Age python java linux sql avg sum");
        Student s = new Student();
        System.out.println("请输入姓名: ");
        sc.reset();
        s.setName(sc.nextLine());
        System.out.println("请输入ID");
        s.setId(sc.nextInt());
        System.out.println("请输入Age: ");
        s.setAge(sc.nextInt());
        System.out.println("请输入python: ");
        s.setPyhton(sc.nextInt());
        System.out.println("请输入java: ");
        s.setJava(sc.nextInt());
        System.out.println("请输入linux: ");
        s.setLinux(sc.nextInt());
        System.out.println("请输入sql: ");
        s.setSql(sc.nextInt());
        int avg=(s.getJava()+s.getLinux()+s.getSql()+s.getPyhton())/4;
        s.setAvg(avg);
        int sum = (s.getJava()+s.getPyhton()+s.getSql()+s.getLinux());
        s.setSum(sum);
        System.out.println(s);
        int i = update(s);
        if (i>0)
            System.out.println("修改成功");
    }

    private void delByID(Scanner sc) throws SQLException {
        System.out.println("请输入删除的ID");
        int i = sc.nextInt();
        int i1 = deleteById(i);
        if (i1>0)
            System.out.println("删除成功");
    }

    private void searchByPage(Scanner sc) throws SQLException {
        System.out.println("请输入页数: ");
        int num = sc.nextInt();
        System.out.println("请输入记录数: ");
        int dex = sc.nextInt();
        List<Student> byPage = getByPage(num, dex);
        for (Student s:byPage)
        {
            System.out.println(s);
        }
    }

    private void searchAll() throws SQLException {
        List<Student> all = getAll();
        for (Student s:all)
            System.out.println(s);

    }

    private void searchById(Scanner sc) throws SQLException {
        System.out.println("输入学生ID：");
        Student id = getById(sc.nextInt());
        System.out.println(id);
    }


    private void createStudent() throws SQLException {
        System.out.println("请输入学生信息：");
        Student s = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.println("输入Name");
        String name = sc.next();
        s.setName(name);
        System.out.println("输入age");
        int age = sc.nextInt();
        s.setAge(age);
        System.out.println("输入python");
        int py = sc.nextInt();
        s.setPyhton(py);
        System.out.println("输入java");
        int java = sc.nextInt();
        s.setJava(java);
        System.out.println("输入linux");
        int linux = sc.nextInt();
        s.setLinux(linux);
        System.out.println("输入sql");
        int sql = sc.nextInt();
        s.setSql(sql);
        int avg=(s.getJava()+s.getLinux()+s.getSql()+s.getPyhton())/4;
        s.setAvg(avg);
        int sum = (s.getJava()+s.getPyhton()+s.getSql()+s.getLinux());
        s.setSum(sum);
        int add = add(s);
        if (add>0)
            System.out.println("创建成功！！！");
    }

    public boolean check(String s){

       try {
           int i = Integer.parseInt(s);
       }catch (Exception e)
       {
           return false;
       }
       return true;
    }
    public void sleep() throws InterruptedException {
        Thread.sleep(1500);
        System.out.println("\n\n\n\n");
    }
}
