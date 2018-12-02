package org.lanqiao.domain;


import java.sql.Date;

public class Book {
    private int bookId;
    private int bookTypeId;
    private String bookName;
    private String bookPress;
    private Date bookPubDate;
    private String bookSize;
    private String bookVersion;
    private String bookAuthor;
    private String bookTanslor;
    private String bookisbn;
    private int price;
    private String bookPages;
    private String bookOutline;
    private String bookCatalog;
    private int Mprice;
    private String bookPic;
    private int bookPicStatus;
    private int bookStoremount ;
    private Date bookStoretime;
    private String bookPackstyle;

    public Book() {
    }

    public Book(int bookTypeId, String bookName, String bookPress, Date bookPubDate, String bookSize, String bookVersion, String bookAuthor, String bookTanslor, String bookisbn, int price, String bookPages, String bookOutline, String bookCatalog, int mprice, String bookPic, int bookPicStatus, int bookStoremount, Date bookStoretime, String bookPackstyle) {
        this.bookTypeId = bookTypeId;
        this.bookName = bookName;
        this.bookPress = bookPress;
        this.bookPubDate = bookPubDate;
        this.bookSize = bookSize;
        this.bookVersion = bookVersion;
        this.bookAuthor = bookAuthor;
        this.bookTanslor = bookTanslor;
        this.bookisbn = bookisbn;
        this.price = price;
        this.bookPages = bookPages;
        this.bookOutline = bookOutline;
        this.bookCatalog = bookCatalog;
        Mprice = mprice;
        this.bookPic = bookPic;
        this.bookPicStatus = bookPicStatus;
        this.bookStoremount = bookStoremount;
        this.bookStoretime = bookStoretime;
        this.bookPackstyle = bookPackstyle;
    }

    public Book(int bookId, int bookTypeId, String bookName, String bookPress, Date bookPubDate, String bookSize, String bookVersion, String bookAuthor, String bookTanslor, String bookisbn, int price, String bookPages, String bookOutline, String bookCatalog, int mprice, String bookPic, int bookPicStatus, int bookStoremount, Date bookStoretime, String bookPackstyle) {
        this.bookId = bookId;
        this.bookTypeId = bookTypeId;
        this.bookName = bookName;
        this.bookPress = bookPress;
        this.bookPubDate = bookPubDate;
        this.bookSize = bookSize;
        this.bookVersion = bookVersion;
        this.bookAuthor = bookAuthor;
        this.bookTanslor = bookTanslor;
        this.bookisbn = bookisbn;
        this.price = price;
        this.bookPages = bookPages;
        this.bookOutline = bookOutline;
        this.bookCatalog = bookCatalog;
        Mprice = mprice;
        this.bookPic = bookPic;
        this.bookPicStatus = bookPicStatus;
        this.bookStoremount = bookStoremount;
        this.bookStoretime = bookStoretime;
        this.bookPackstyle = bookPackstyle;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(int bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookPress() {
        return bookPress;
    }

    public void setBookPress(String bookPress) {
        this.bookPress = bookPress;
    }

    public Date getBookPubDate() {
        return bookPubDate;
    }

    public void setBookPubDate(Date bookPubDate) {
        this.bookPubDate = bookPubDate;
    }

    public String getBookSize() {
        return bookSize;
    }

    public void setBookSize(String bookSize) {
        this.bookSize = bookSize;
    }

    public String getBookVersion() {
        return bookVersion;
    }

    public void setBookVersion(String bookVersion) {
        this.bookVersion = bookVersion;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookTanslor() {
        return bookTanslor;
    }

    public void setBookTanslor(String bookTanslor) {
        this.bookTanslor = bookTanslor;
    }

    public String getBookisbn() {
        return bookisbn;
    }

    public void setBookisbn(String bookisbn) {
        this.bookisbn = bookisbn;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBookPages() {
        return bookPages;
    }

    public void setBookPages(String bookPages) {
        this.bookPages = bookPages;
    }

    public String getBookOutline() {
        return bookOutline;
    }

    public void setBookOutline(String bookOutline) {
        this.bookOutline = bookOutline;
    }

    public String getBookCatalog() {
        return bookCatalog;
    }

    public void setBookCatalog(String bookCatalog) {
        this.bookCatalog = bookCatalog;
    }

    public int getMprice() {
        return Mprice;
    }

    public void setMprice(int mprice) {
        Mprice = mprice;
    }

    public String getBookPic() {
        return bookPic;
    }

    public void setBookPic(String bookPic) {
        this.bookPic = bookPic;
    }

    public int getBookPicStatus() {
        return bookPicStatus;
    }

    public void setBookPicStatus(int bookPicStatus) {
        this.bookPicStatus = bookPicStatus;
    }

    public int getBookStoremount() {
        return bookStoremount;
    }

    public void setBookStoremount(int bookStoremount) {
        this.bookStoremount = bookStoremount;
    }

    public Date getBookStoretime() {
        return bookStoretime;
    }

    public void setBookStoretime(Date bookStoretime) {
        this.bookStoretime = bookStoretime;
    }

    public String getBookPackstyle() {
        return bookPackstyle;
    }

    public void setBookPackstyle(String bookPackstyle) {
        this.bookPackstyle = bookPackstyle;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookTypeId=" + bookTypeId +
                ", bookName='" + bookName + '\'' +
                ", bookPress='" + bookPress + '\'' +
                ", bookPubDate=" + bookPubDate +
                ", bookSize='" + bookSize + '\'' +
                ", bookVersion='" + bookVersion + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookTanslor='" + bookTanslor + '\'' +
                ", bookisbn='" + bookisbn + '\'' +
                ", price=" + price +
                ", bookPages='" + bookPages + '\'' +
                ", bookOutline='" + bookOutline + '\'' +
                ", bookCatalog='" + bookCatalog + '\'' +
                ", Mprice=" + Mprice +
                ", bookPic='" + bookPic + '\'' +
                ", bookPicStatus=" + bookPicStatus +
                ", bookStoremount=" + bookStoremount +
                ", bookStoretime=" + bookStoretime +
                ", bookPackstyle='" + bookPackstyle + '\'' +
                '}';
    }
}
