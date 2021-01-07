import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ReadMain {
    /*
     ����һ�����ﳵ���飺�������Ʒ
    */
    static Product carts[] = new Product[3];
    static int j=0;
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

                    int choosenum = 9;
                    while (choosenum != 0) {
                        int flag=0;
                        System.out.println("->��ѡ��Ʒ�밴1");
                        System.out.println("->�鿴���ﳵ�밴2");
                        System.out.println("->�����밴3");
                        System.out.println("->�˳��밴0");

                        choosenum = sc.nextInt();
                        switch (choosenum) {
                            case 0:
                                break;
                            case 1:
                                /*
                                1����������
                                    ��1����ʾ������Ʒ����Ϣ
                                */
                                for (Product p : products) {
                                    System.out.print(p.getId());
                                    System.out.print("\t" + p.getName());
                                    System.out.print("\t" + p.getPrice());
                                    System.out.println("\t" + p.getDescribe());
                                }
                                System.out.println("--->��������Ҫ�������Ʒid");
                                String id = sc.next();
                                shopping(readproduct,id,carts);

                                break;
                            case 2:
                                /*
                                2���鿴���ﳵ
                                    ��1�����ﳵ��������ģ���
                                    ��2���������ڵ�Ԫ��һ��һ������������������
                                 */
//                                if(carts!=null){    //�����ж������Ƿ�Ϊ�ջ����У����������ǿյ������ǻ��ȥ����ʱû��Ū��
                                if(flag==0){
                                    System.out.println("----->���ﳵ��");
                                    flag=1;
                                }
                                viewCarts(carts);
                                break;
                            case 3:
                                /*
                                1����������
                                2����poi����ProductOrder
                                3���ѹ��ﳵ�е���Ʒд��ProductOrder.xlsx�ļ�
                                */
                                ProductOrder order=new ProductOrder();
                                users[i].setProductOrder(order);

                                break;
                            default:
                                System.out.println("Error��");
                        }
                    }
                    break;
                } else {
                    System.out.println("��½ʧ�ܣ�");
                }
            }
        }
//    }
    }

    public static void shopping(ReadProduct readproduct, String id, Product carts[]) throws ClassNotFoundException {
        /*
        ���¶���������Ϊ֮ǰ��inputstream����������
        */

        InputStream inproduct = null;
        inproduct = Class.forName("ReadMain").getResourceAsStream("/Products.xlsx");

        Product product = readproduct.getProductById(id, inproduct);
        System.out.println("----->��Ʒ��" + id + "����Ʒ�۸�Ϊ" + product.getPrice() + "Ԫ");
        if (product != null) {
            carts[j] = product;
            j++;
        }
    }

    public static void viewCarts(Product carts[]){
        if (carts[0] != null) {
            for (Product cart : carts) {
                if (cart == null) {
                    break;
                }
                System.out.print("----->"+cart.getId());
                System.out.print("\t" + cart.getName());
                System.out.print("\t" + cart.getPrice());
                System.out.println("\t" + cart.getDescribe());
            }
        } else {
            System.out.println("--->���ﳵ������Ʒ");
        }
    }
}

