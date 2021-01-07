import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ReadMain {
    /*
     创建一个购物车数组：存的是商品
    */
    static Product carts[] = new Product[3];
    static int j=0;
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

                    int choosenum = 9;
                    while (choosenum != 0) {
                        int flag=0;
                        System.out.println("->挑选商品请按1");
                        System.out.println("->查看购物车请按2");
                        System.out.println("->结账请按3");
                        System.out.println("->退出请按0");

                        choosenum = sc.nextInt();
                        switch (choosenum) {
                            case 0:
                                break;
                            case 1:
                                /*
                                1、继续购物
                                    （1）显示所有商品的信息
                                */
                                for (Product p : products) {
                                    System.out.print(p.getId());
                                    System.out.print("\t" + p.getName());
                                    System.out.print("\t" + p.getPrice());
                                    System.out.println("\t" + p.getDescribe());
                                }
                                System.out.println("--->请输入需要购买的商品id");
                                String id = sc.next();
                                shopping(readproduct,id,carts);

                                break;
                            case 2:
                                /*
                                2、查看购物车
                                    （1）购物车是用数组模拟的
                                    （2）把数组内的元素一个一个输出：即对数组遍历
                                 */
//                                if(carts!=null){    //这样判断数组是否为空还不行，就算数组是空的它还是会进去，暂时没有弄懂
                                if(flag==0){
                                    System.out.println("----->购物车：");
                                    flag=1;
                                }
                                viewCarts(carts);
                                break;
                            case 3:
                                /*
                                1、产生订单
                                2、用poi创建ProductOrder
                                3、把购物车中的商品写入ProductOrder.xlsx文件
                                */
                                ProductOrder order=new ProductOrder();
                                users[i].setProductOrder(order);

                                break;
                            default:
                                System.out.println("Error！");
                        }
                    }
                    break;
                } else {
                    System.out.println("登陆失败！");
                }
            }
        }
//    }
    }

    public static void shopping(ReadProduct readproduct, String id, Product carts[]) throws ClassNotFoundException {
        /*
        重新读入流，因为之前的inputstream流读到底了
        */

        InputStream inproduct = null;
        inproduct = Class.forName("ReadMain").getResourceAsStream("/Products.xlsx");

        Product product = readproduct.getProductById(id, inproduct);
        System.out.println("----->商品号" + id + "的商品价格为" + product.getPrice() + "元");
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
            System.out.println("--->购物车中无商品");
        }
    }
}

