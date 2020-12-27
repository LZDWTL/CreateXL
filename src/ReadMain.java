import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class ReadMain {
    public static void main(String[] args) throws ClassNotFoundException {
        boolean bool = true;
        while (bool) {
            Scanner sc = new Scanner(System.in);

            System.out.println("请输入用户名：");
            String username = sc.next();
            System.out.println("用户名为：" + username);

            System.out.println("请输入密码：");
            String password = sc.next();
            System.out.println("密码为：" + password);

//            File file = new File("D:\\WorkSpace\\JavaWorkSpce\\ideal\\2020-12\\2020-12-15\\src\\users.xlsx");
//            File file = new File("src/users.xlsx");
            InputStream in = Class.forName("ReadMain").getResourceAsStream("/users.xlsx");
            ReadExcel read = new ReadExcel();  //创建对象
//            User[] users = read.readExcel(file);
            User[] users = read.readExcel(in);
            for (int i = 0; i < users.length; i++) {
                if (username.equals(users[i].getUsername()) && password.equals(users[i].getPassword())) {
                    System.out.println("登陆成功！");
                    bool = false;
                    break;
                } else {
                    System.out.println("登陆失败！");
                }
            /*System.out.print(users[i].getUsername());
            System.out.print("\t" + users[i].getPassword());
            System.out.print("\t" + users[i].getAddress());
            System.out.println("\t" + users[i].getPhone());*/
            }
        }
//    }
    }
}

