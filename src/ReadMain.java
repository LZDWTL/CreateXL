import java.io.File;
import java.util.Scanner;

public class ReadMain {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("�������û�����");
        String username=sc.next();
        System.out.println("�û���Ϊ��"+username);

        System.out.println("���������룺");
        String password=sc.next();
        System.out.println("����Ϊ��"+password);

        File file =new File("D:\\WorkSpace\\JavaWorkSpce\\ideal\\2020-12\\2020-12-15\\src\\users.xlsx");
        ReadExcel read =new ReadExcel();  //��������
        User []users =read.readExcel(file);
        for(int i=0;i<users.length;i++){
            //if(users[i].getUsername().equals(username) && users[i].getPassword().equals(password)){
            if(username.equals(users[i].getUsername())  &&password.equals(users[i].getPassword())){
                System.out.println("��½�ɹ���");
                break;
            }
            else{
                System.out.println("��½ʧ�ܣ�");
            }
            /*System.out.print(users[i].getUsername());
            System.out.print(users[i].getPassword());
            System.out.print(users[i].getAddress());
            System.out.println(users[i].getPhone());*/
        }
    }
}
