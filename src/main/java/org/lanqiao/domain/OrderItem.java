package org.lanqiao.domain;

/*订单子表*/
public class OrderItem {
    private int id;
    private int oId;
    private int bookId;
    private int mprice;
    private int price;
    private int num;
    private String bookName;

    public OrderItem() {
    }

    public OrderItem(int id, int oId, int bookId, int mprice, int price, int num, String bookName) {
        this.id = id;
        this.oId = oId;
        this.bookId = bookId;
        this.mprice = mprice;
        this.price = price;
        this.num = num;
        this.bookName = bookName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getMprice() {
        return mprice;
    }

    public void setMprice(int mprice) {
        this.mprice = mprice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", oId=" + oId +
                ", bookId=" + bookId +
                ", mprice=" + mprice +
                ", price=" + price +
                ", num=" + num +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
