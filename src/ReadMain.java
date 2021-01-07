import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.RichTextString;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ReadMain {
    /*
     创建一个购物车数组：存的是商品
    */
    private static Product carts[] = new Product[3];
    private static int j=0;
    public static String outputFile = "D:\\WorkSpace\\JavaWorkSpce\\ideal\\2020-12\\2020-12-15\\src\\ProductOrder.xls";

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
                                /*
                                 * 将用户和订单联系起来
                                 */
                                users[i].setProductOrder(order);
                                CreateOrder(users[i].getUsername(),carts);
                                System.exit(0);
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

    public static void CreateOrder(String name,Product carts[]){
        try {
            int i=0;
            int j=1;
            // 创建新的Excel 工作簿
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 在Excel工作簿中建一工作表，其名为缺省值
            // 如要新建一名为"效益指标"的工作表，其语句为：
            HSSFSheet sheet = workbook.createSheet(name+"的订单");
            // 在索引0的位置创建行（最顶端的行）
            String ordertitle[]={"用户名","商品id","数量","需付","实付","订单日期"};
            String ordermessage[]={name,carts[i].getId(),String.valueOf(i+1),String.valueOf(carts[i].getPrice()*(i+1)),String.valueOf(carts[i].getPrice()*(i+1)),"2020/1/7"};
            setData(ordertitle,sheet,0);
            while(carts[i]!=null){
                setData(ordermessage,sheet,i+1);
                i++;
            }

            // 新建一输出文件流
            FileOutputStream fOut = new FileOutputStream(outputFile);
            // 把相应的Excel 工作簿存盘
            workbook.write(fOut);
            fOut.flush();
            // 操作结束，关闭文件
            fOut.close();
            System.out.println("订单已生成！");
        } catch (Exception e) {
            System.out.println("已运行 xlCreate() : " + e);
        }
    }

    public static void setData(String orderarray[],HSSFSheet sheet,int i){

        HSSFRow row_i = sheet.createRow(i);
        //在索引0的位置创建单元格（左上端）

        for(int k=0; k<orderarray.length; k++){

            HSSFCell cell_k = row_i.createCell(k);
            cell_k.setCellValue(orderarray[k]);
        }
    }

    public static void setData(Product orderarray[],HSSFSheet sheet,int i){

        HSSFRow row_i = sheet.createRow(i);
        //在索引0的位置创建单元格（左上端）

        for(int k=0; k<6; k++){

            HSSFCell cell_k = row_i.createCell(k);
            cell_k.setCellValue((RichTextString) orderarray[k]);
        }
    }

}

