package org.lanqiao.domain;

import java.util.Date;

/*书籍*/
public class Book {
    private int BookId;
    private int BookTypeid;
    private String BookName;
    private String BookPress;
    private Date BookPubDate;
    private String BookSize;
    private String BookVersion;
    private String BookAuthor;
    private String BookTanslor;
    private String Bookisbn;
    private int BookPrice;
    private int BookPages;
    private String BookOutline;
    private String BookCatalog;
    private int BookMprice;
    private String BookPic;
    private int BookPicStatus;
    private int BookStoremount;
    private Date BookStoretime;
    private String BookPackstyle;

    public Book() {
    }

    public Book(int bookId, int bookTypeid, String bookName, String bookPress, Date bookPubDate, String bookSize, String bookVersion, String bookAuthor, String bookTanslor, String bookisbn, int bookPrice, int bookPages, String bookOutline, String bookCatalog, int bookMprice, String bookPic, int bookPicStatus, int bookStoremount, Date bookStoretime, String bookPackstyle) {
        BookId = bookId;
        BookTypeid = bookTypeid;
        BookName = bookName;
        BookPress = bookPress;
        BookPubDate = bookPubDate;
        BookSize = bookSize;
        BookVersion = bookVersion;
        BookAuthor = bookAuthor;
        BookTanslor = bookTanslor;
        Bookisbn = bookisbn;
        BookPrice = bookPrice;
        BookPages = bookPages;
        BookOutline = bookOutline;
        BookCatalog = bookCatalog;
        BookMprice = bookMprice;
        BookPic = bookPic;
        BookPicStatus = bookPicStatus;
        BookStoremount = bookStoremount;
        BookStoretime = bookStoretime;
        BookPackstyle = bookPackstyle;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }

    public int getBookTypeid() {
        return BookTypeid;
    }

    public void setBookTypeid(int bookTypeid) {
        BookTypeid = bookTypeid;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getBookPress() {
        return BookPress;
    }

    public void setBookPress(String bookPress) {
        BookPress = bookPress;
    }

    public Date getBookPubDate() {
        return BookPubDate;
    }

    public void setBookPubDate(Date bookPubDate) {
        BookPubDate = bookPubDate;
    }

    public String getBookSize() {
        return BookSize;
    }

    public void setBookSize(String bookSize) {
        BookSize = bookSize;
    }

    public String getBookVersion() {
        return BookVersion;
    }

    public void setBookVersion(String bookVersion) {
        BookVersion = bookVersion;
    }

    public String getBookAuthor() {
        return BookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        BookAuthor = bookAuthor;
    }

    public String getBookTanslor() {
        return BookTanslor;
    }

    public void setBookTanslor(String bookTanslor) {
        BookTanslor = bookTanslor;
    }

    public String getBookisbn() {
        return Bookisbn;
    }

    public void setBookisbn(String bookisbn) {
        Bookisbn = bookisbn;
    }

    public int getBookPrice() {
        return BookPrice;
    }

    public void setBookPrice(int bookPrice) {
        BookPrice = bookPrice;
    }

    public int getBookPages() {
        return BookPages;
    }

    public void setBookPages(int bookPages) {
        BookPages = bookPages;
    }

    public String getBookOutline() {
        return BookOutline;
    }

    public void setBookOutline(String bookOutline) {
        BookOutline = bookOutline;
    }

    public String getBookCatalog() {
        return BookCatalog;
    }

    public void setBookCatalog(String bookCatalog) {
        BookCatalog = bookCatalog;
    }

    public int getBookMprice() {
        return BookMprice;
    }

    public void setBookMprice(int bookMprice) {
        BookMprice = bookMprice;
    }

    public String getBookPic() {
        return BookPic;
    }

    public void setBookPic(String bookPic) {
        BookPic = bookPic;
    }

    public int getBookPicStatus() {
        return BookPicStatus;
    }

    public void setBookPicStatus(int bookPicStatus) {
        BookPicStatus = bookPicStatus;
    }

    public int getBookStoremount() {
        return BookStoremount;
    }

    public void setBookStoremount(int bookStoremount) {
        BookStoremount = bookStoremount;
    }

    public Date getBookStoretime() {
        return BookStoretime;
    }

    public void setBookStoretime(Date bookStoretime) {
        BookStoretime = bookStoretime;
    }

    public String getBookPackstyle() {
        return BookPackstyle;
    }

    public void setBookPackstyle(String bookPackstyle) {
        BookPackstyle = bookPackstyle;
    }

    @Override
    public String toString() {
        return "Book{" +
                "BookId=" + BookId +
                ", BookTypeid=" + BookTypeid +
                ", BookName='" + BookName + '\'' +
                ", BookPress='" + BookPress + '\'' +
                ", BookPubDate=" + BookPubDate +
                ", BookSize='" + BookSize + '\'' +
                ", BookVersion='" + BookVersion + '\'' +
                ", BookAuthor='" + BookAuthor + '\'' +
                ", BookTanslor='" + BookTanslor + '\'' +
                ", Bookisbn='" + Bookisbn + '\'' +
                ", BookPrice=" + BookPrice +
                ", BookPages=" + BookPages +
                ", BookOutline='" + BookOutline + '\'' +
                ", BookCatalog='" + BookCatalog + '\'' +
                ", BookMprice=" + BookMprice +
                ", BookPic='" + BookPic + '\'' +
                ", BookPicStatus=" + BookPicStatus +
                ", BookStoremount=" + BookStoremount +
                ", BookStoretime=" + BookStoretime +
                ", BookPackstyle='" + BookPackstyle + '\'' +
                '}';
    }
}
