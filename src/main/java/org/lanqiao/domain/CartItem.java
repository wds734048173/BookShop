package org.lanqiao.domain;

public class CartItem {
    private int CustomerId;
    private int BookId;
    private int ordermount;
    private int BookMprice;
    private int BookPrice;
    private String BookName;
    private String BookPic;

    public CartItem() {
    }

    public CartItem(int customerId, int bookId, int ordermount, int bookMprice, int bookPrice, String bookName, String bookPic) {
        CustomerId = customerId;
        BookId = bookId;
        this.ordermount = ordermount;
        BookMprice = bookMprice;
        BookPrice = bookPrice;
        BookName = bookName;
        BookPic = bookPic;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }

    public int getOrdermount() {
        return ordermount;
    }

    public void setOrdermount(int ordermount) {
        this.ordermount = ordermount;
    }

    public int getBookMprice() {
        return BookMprice;
    }

    public void setBookMprice(int bookMprice) {
        BookMprice = bookMprice;
    }

    public int getBookPrice() {
        return BookPrice;
    }

    public void setBookPrice(int bookPrice) {
        BookPrice = bookPrice;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getBookPic() {
        return BookPic;
    }

    public void setBookPic(String bookPic) {
        BookPic = bookPic;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "CustomerId=" + CustomerId +
                ", BookId=" + BookId +
                ", ordermount=" + ordermount +
                ", BookMprice=" + BookMprice +
                ", BookPrice=" + BookPrice +
                ", BookName='" + BookName + '\'' +
                ", BookPic='" + BookPic + '\'' +
                '}';
    }
}
