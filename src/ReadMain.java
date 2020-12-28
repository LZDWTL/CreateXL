import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ReadMain {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
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
                    bool = false;


                    /*
                    ����һ�����ﳵ���飺�������Ʒ
                    */
                    Product carts[] = new Product[3];
                    int j=0;

                    int num =9;
                    while (num!=0) {


                        System.out.println("��ѡ��Ʒ�밴1");
                        System.out.println("�鿴���ﳵ�밴2");

                        num=sc.nextInt();
                        switch(num){
                            case 0:
                                break;
                            case 1:
                                /*
                                ��ʾ��Ʒ��Ϣ
                                */
                                for (Product p : products) {
                                    System.out.print(p.getId());
                                    System.out.print("\t" + p.getName());
                                    System.out.print("\t" + p.getPrice());
                                    System.out.println("\t" + p.getDescribe());
                                }
                                System.out.println("��������Ʒid");
                                String id = sc.next();

                                /*
                                ���¶���������Ϊ֮ǰ��inputstream����������
                                */
                                inproduct = null;
                                inproduct = Class.forName("ReadMain").getResourceAsStream("/Products.xlsx");
                                Product product = readproduct.getProductBuId(id, inproduct);
                                System.out.println(id + "����Ʒ�۸�Ϊ" + product.getPrice());
                                if (product != null) {
                                    carts[j] = product;
                                    j++;
                                }
                                break;
                            case 2:
                                if(carts!=null){
                                    for(Product cart:carts){
                                        System.out.print(cart.getId());
                                        System.out.print("\t" + cart.getName());
                                        System.out.print("\t" + cart.getPrice());
                                        System.out.println("\t" + cart.getDescribe());
                                    }
                                }
                                else{
                                    System.out.println("���ﳵ������Ʒ");
                                }
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Error��");
                        }

                    }

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

