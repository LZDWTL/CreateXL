import java.sql.SQLOutput;

public class Test {
    public static void main(String[] args) {
        /*
         * ����һ������
         */
        Customer customer = new Customer();
        Order order = new Order();

        /*
         * ����������Ը�ֵ���൱�����ھ��̳�ע���ʱ����д�Լ�����Ϣ��
         */
        /*customer.customerId = "666";
        customer.customerName = "��ѩ��";
        customer.adress = "���ֵ��ӿƼ���ѧ";
        customer.phonenumber = "1877877662";

        order.ammount = 8888f;
        order.orderId = "01";*/

        customer.setCustomerId("666");
        customer.setCustomerName("��ѩ��");
        customer.setPhonenumber("1837877662");
        customer.setAdress("���ֵ��ӿƼ���ѧ");
        System.out.println(customer.getPhonenumber());

        order.setOrderId("01");
        order.setAmmount(9999f);


        /*
         * ���ͻ������ݿ���й���
         */
//        customer.order = order;
        customer.setOrder(order);

        /*
         * ���󣺲�ѯ�ͻ��Ķ������
         */
        System.out.println("������" + order.getAmmount());
    }
}
