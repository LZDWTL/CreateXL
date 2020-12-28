import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ReadMain {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
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
            InputStream inuser = Class.forName("ReadMain").getResourceAsStream("/users.xlsx");
            InputStream inproduct = Class.forName("ReadMain").getResourceAsStream("/Products.xlsx");
            ReadUser readuser = new ReadUser();  //创建对象
            ReadProduct readproduct = new ReadProduct();  //创建对象
//            User[] users = read.readExcel(file);
            User[] users = readuser.readUser(inuser);
            Product[] products = readproduct.readProduct(inproduct);
            for (int i = 0; i < users.length; i++) {
                if (username.equals(users[i].getUsername()) && password.equals(users[i].getPassword())) {
                    System.out.println("登陆成功！");
                    bool = false;


                    /*
                    创建一个购物车数组：存的是商品
                    */
                    Product carts[] = new Product[3];
                    int j=0;

                    int num =9;
                    while (num!=0) {


                        System.out.println("挑选商品请按1");
                        System.out.println("查看购物车请按2");

                        num=sc.nextInt();
                        switch(num){
                            case 0:
                                break;
                            case 1:
                                /*
                                显示商品信息
                                */
                                for (Product p : products) {
                                    System.out.print(p.getId());
                                    System.out.print("\t" + p.getName());
                                    System.out.print("\t" + p.getPrice());
                                    System.out.println("\t" + p.getDescribe());
                                }
                                System.out.println("请输入商品id");
                                String id = sc.next();

                                /*
                                重新读入流，因为之前的inputstream流读到底了
                                */
                                inproduct = null;
                                inproduct = Class.forName("ReadMain").getResourceAsStream("/Products.xlsx");
                                Product product = readproduct.getProductBuId(id, inproduct);
                                System.out.println(id + "的商品价格为" + product.getPrice());
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
                                    System.out.println("购物车中无商品");
                                }
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Error！");
                        }

                    }

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

