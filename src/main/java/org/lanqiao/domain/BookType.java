package org.lanqiao.domain;

public class BookType {
    private int bookTypeId;
    private String bookTypeName;

    public BookType() {
    }

    public BookType(String bookTypeName) {
        this.bookTypeName = bookTypeName;
    }

    public BookType(int bookTypeId, String bookTypeName) {
        this.bookTypeId = bookTypeId;
        this.bookTypeName = bookTypeName;
    }

    public int getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(int bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public String getBookTypeName() {
        return bookTypeName;
    }

    public void setBookTypeName(String bookTypeName) {
        this.bookTypeName = bookTypeName;
    }

    @Override
    public String toString() {
        return "BookType{" +
                "bookTypeId=" + bookTypeId +
                ", bookTypeName='" + bookTypeName + '\'' +
                '}';
    }
}
