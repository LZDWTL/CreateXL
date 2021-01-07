import java.sql.Date;

public class ProductOrder {
    private User user;
    private Product product;
    private int amount;  //数量
    private float totalpay;
    private float actualpay;
    private Date orderdate;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getTotalpay() {
        return totalpay;
    }

    public void setTotalpay(float totalpay) {
        this.totalpay = totalpay;
    }

    public float getActualpay() {
        return actualpay;
    }

    public void setActualpay(float actualpay) {
        this.actualpay = actualpay;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }
}
