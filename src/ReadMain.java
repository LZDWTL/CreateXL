import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class ReadMain {
    public static void main(String[] args) throws ClassNotFoundException {
        boolean bool = true;
        while (bool) {
            Scanner sc = new Scanner(System.in);

            System.out.println("�������û�����");
            String username = sc.next();
            System.out.println("�û���Ϊ��" + username);

            System.out.println("���������룺");
            String password = sc.next();
            System.out.println("����Ϊ��" + password);

//            File file = new File("D:\\WorkSpace\\JavaWorkSpce\\ideal\\2020-12\\2020-12-15\\src\\users.xlsx");
//            File file = new File("src/users.xlsx");
            InputStream inuser = Class.forName("ReadMain").getResourceAsStream("/users.xlsx");
            InputStream inproduct = Class.forName("ReadMain").getResourceAsStream("/Products.xlsx");
            ReadUser readuser = new ReadUser();  //��������
            ReadProduct readproduct = new ReadProduct();  //��������
//            User[] users = read.readExcel(file);
            User[] users = readuser.readUser(inuser);
            Product[] products = readproduct.readProduct(inproduct);
            for (int i = 0; i < users.length; i++) {
                if (username.equals(users[i].getUsername()) && password.equals(users[i].getPassword())) {
                    System.out.println("��½�ɹ���");

                    for(Product product:products){
                        System.out.print(product.getId());
                        System.out.print("\t" + product.getName());
                        System.out.print("\t" + product.getPrice());
                        System.out.println("\t" + product.getDescribe());
                    }

                    bool = false;
                    break;
                } else {
                    System.out.println("��½ʧ�ܣ�");
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

