class Customer {
    private String customerId;
    private String customerName;
    private String phonenumber;
    private String adress;

    private Order order;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        /*
        * 判断phonenumber是否全为数字
        */
        String error="";
        try{
            int number=Integer.parseInt(phonenumber);
        }
        catch(NumberFormatException e){
            error="电话号码错误";
            System.out.println(error);
        }
        if(!error.equals("")){
            return;
        }
        this.phonenumber = phonenumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
