package org.lanqiao.domain;

import java.util.Date;

/*订单*/
public class Order {
private int id;
private String no;
private int price;
private int freight;
private int money;
private int state;
private String name;
private String phone;
private String address;
private Date ctime;
private Date rtime;
private int customerId;

    public Order() {
    }

    public Order(int id, String no, int price, int freight, int money, int state, String name, String phone, String address, Date ctime, Date rtime, int customerId) {
        this.id = id;
        this.no = no;
        this.price = price;
        this.freight = freight;
        this.money = money;
        this.state = state;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.ctime = ctime;
        this.rtime = rtime;
        this.customerId = customerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFreight() {
        return freight;
    }

    public void setFreight(int freight) {
        this.freight = freight;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getRtime() {
        return rtime;
    }

    public void setRtime(Date rtime) {
        this.rtime = rtime;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", price=" + price +
                ", freight=" + freight +
                ", money=" + money +
                ", state=" + state +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", ctime=" + ctime +
                ", rtime=" + rtime +
                ", customerId=" + customerId +
                '}';
    }
}
