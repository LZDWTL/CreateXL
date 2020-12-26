import java.io.File;
import java.util.Scanner;

public class ReadMain {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("请输入用户名：");
        String username=sc.next();
        System.out.println("用户名为："+username);

        System.out.println("请输入密码：");
        String password=sc.next();
        System.out.println("密码为："+password);

        File file =new File("D:\\WorkSpace\\JavaWorkSpce\\ideal\\2020-12\\2020-12-15\\src\\users.xlsx");
        ReadExcel read =new ReadExcel();  //创建对象
        User []users =read.readExcel(file);
        for(int i=0;i<users.length;i++){
            //if(users[i].getUsername().equals(username) && users[i].getPassword().equals(password)){
            if(username.equals(users[i].getUsername())  &&password.equals(users[i].getPassword())){
                System.out.println("登陆成功！");
                break;
            }
            else{
                System.out.println("登陆失败！");
            }
            /*System.out.print(users[i].getUsername());
            System.out.print(users[i].getPassword());
            System.out.print(users[i].getAddress());
            System.out.println(users[i].getPhone());*/
        }
    }
}
