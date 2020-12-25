import java.sql.SQLOutput;

public class Test {
    public static void main(String[] args) {
        /*
         * 创建一个对象
         */
        Customer customer = new Customer();
        Order order = new Order();

        /*
         * 给对象的属性赋值（相当于你在京商城注册的时候填写自己的信息）
         */
        /*customer.customerId = "666";
        customer.customerName = "蓝雪瑞";
        customer.adress = "桂林电子科技大学";
        customer.phonenumber = "1877877662";

        order.ammount = 8888f;
        order.orderId = "01";*/

        customer.setCustomerId("666");
        customer.setCustomerName("蓝雪瑞");
        customer.setPhonenumber("1837877662");
        customer.setAdress("桂林电子科技大学");
        System.out.println(customer.getPhonenumber());

        order.setOrderId("01");
        order.setAmmount(9999f);


        /*
         * 将客户与数据库进行关联
         */
//        customer.order = order;
        customer.setOrder(order);

        /*
         * 需求：查询客户的订单金额
         */
        System.out.println("订单金额：" + order.getAmmount());
    }
}
