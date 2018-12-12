package org.lanqiao.control;

import org.lanqiao.domain.Book;
import org.lanqiao.domain.BookType;
import org.lanqiao.domain.Condition;
import org.lanqiao.service.IBookService;
import org.lanqiao.service.impl.BookServiceImpl;
import org.lanqiao.utils.DataMap;
import org.lanqiao.utils.PageModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/*
* 书籍管理
* */

@WebServlet("/book.do")
public class BookServlet extends HttpServlet {

    IBookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        switch (method){
            case "getBooklist":
                getBooklist(req,resp,null);
                break;
            case "addBook":
                addBook(req,resp);
                break;
            case "deleteBook":
                deleteBook(req,resp);
                break;
            case "updateBook":
                updateBook(req,resp);
                break;
            case "getBookById":
                getBookById(req,resp);
                break;
        }
    }

    private void getBookById(HttpServletRequest req, HttpServletResponse resp) {
        String param = req.getParameter("param");
        String bookId = req.getParameter("bookId");
        Book book = bookService.getBookById(Integer.valueOf(bookId));
        //把图书分类id转换为图书名称
        int bookTypeId = book.getBookTypeid();
        Map<Integer,String> map = DataMap.getBookTypeIdNameMap();
        if(map.containsKey(bookTypeId)){
            book.setBookTypeName(map.get(bookTypeId));
        }
        req.setAttribute("book",book);
        try {
            if("getBookInfo".equals(param)){
                req.getRequestDispatcher("/manager/bookInfo.jsp").forward(req,resp);
            }else if("updateBook".equals(param)){
                req.getRequestDispatcher("/manager/updateBook.jsp").forward(req,resp);
            }
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateBook(HttpServletRequest req, HttpServletResponse resp) {
        Book book = new Book();
        //图片url
        HttpSession session = req.getSession();
        if(session.getAttribute("picUrl") != null){
            String picUrl = session.getAttribute("picUrl").toString();
            book.setBookPic(picUrl);
        }
        //图书id
        String bookId = req.getParameter("bookId");
        System.out.println(bookId);
        book.setBookId(Integer.valueOf(bookId));
        //图书类型
        String bookTypeId = req.getParameter("bookTypeId");
        book.setBookTypeid(Integer.valueOf(bookTypeId));
        //图书名称
        String bookName = req.getParameter("bookName");
        book.setBookName(bookName);
        //出版社
        String bookPress = req.getParameter("bookPress");
        book.setBookPress(bookPress);
        //出版日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String bookPubDate = req.getParameter("bookPubDate");
        try {
            book.setBookPubDate(sdf.parse(bookPubDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //开本
        String bookSize = req.getParameter("bookSize");
        book.setBookSize(bookSize);
        //版次
        String bookVersion = req.getParameter("bookVersion");
        book.setBookVersion(bookVersion);
        //图书作者
        String bookAuthor = req.getParameter("bookAuthor");
        book.setBookAuthor(bookAuthor);
        //图书译者
        String bookTanslor = req.getParameter("bookTanslor");
        book.setBookTanslor(bookTanslor);
        //图书ISBN
        String bookisbn = req.getParameter("bookisbn");
        book.setBookisbn(bookisbn);
        //图书定价
        String bookPrice = req.getParameter("bookPrice");
        book.setBookPrice(Integer.valueOf(bookPrice));
        //图书页码
        String bookPages = req.getParameter("bookPages");
        book.setBookPages(Integer.valueOf(bookPages));
        //图书简介
        String bookOutline = req.getParameter("bookOutline");
        book.setBookOutline(bookOutline);
        //图书目录
        String bookCatalog = req.getParameter("bookCatalog");
        book.setBookCatalog(bookCatalog);
        //市场价
        String bookMprice = req.getParameter("bookMprice");
        book.setBookMprice(Integer.valueOf(bookMprice));
        //图书封面状态
        book.setBookPicStatus(0);
        //图书库存量
        String bookStoremount = req.getParameter("bookStoremount");
        book.setBookStoremount(Integer.valueOf(bookStoremount));
        //封装方式
        String bookPackstyle = req.getParameter("bookPackstyle");
        book.setBookPackstyle(bookPackstyle);
        bookService.updateBook(book);
        try {
            req.getRequestDispatcher("/book.do?method=getBooklist").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteBook(HttpServletRequest req, HttpServletResponse resp) {
        int bookId = Integer.valueOf(req.getParameter("bookId"));
        bookService.deleteBookById(bookId);
        getBooklist(req,resp,"delete");
    }


    private void addBook(HttpServletRequest req, HttpServletResponse resp) {
        Book book = new Book();
        //图片url
        HttpSession session = req.getSession();
        if(session.getAttribute("picUrl") != null){
            String picUrl = session.getAttribute("picUrl").toString();
            book.setBookPic(picUrl);
        }
        //图书类型
        String bookTypeId = req.getParameter("bookTypeId");
        book.setBookTypeid(Integer.valueOf(bookTypeId));
        //图书名称
        String bookName = req.getParameter("bookName");
        book.setBookName(bookName);
        //出版社
        String bookPress = req.getParameter("bookPress");
        book.setBookPress(bookPress);
        //出版日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String bookPubDate = req.getParameter("bookPubDate");
        try {
            book.setBookPubDate(sdf.parse(bookPubDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //开本
        String bookSize = req.getParameter("bookSize");
        book.setBookSize(bookSize);
        //版次
        String bookVersion = req.getParameter("bookVersion");
        book.setBookVersion(bookVersion);
        //图书作者
        String bookAuthor = req.getParameter("bookAuthor");
        book.setBookAuthor(bookAuthor);
        //图书译者
        String bookTanslor = req.getParameter("bookTanslor");
        book.setBookTanslor(bookTanslor);
        //图书ISBN
        String bookisbn = req.getParameter("bookisbn");
        book.setBookisbn(bookisbn);
        //图书定价
        String bookPrice = req.getParameter("bookPrice");
        book.setBookPrice(Integer.valueOf(bookPrice));
        //图书页码
        String bookPages = req.getParameter("bookPages");
        book.setBookPages(Integer.valueOf(bookPages));
        //图书简介
        String bookOutline = req.getParameter("bookOutline");
        book.setBookOutline(bookOutline);
        //图书目录
        String bookCatalog = req.getParameter("bookCatalog");
        book.setBookCatalog(bookCatalog);
        //市场价
        String bookMprice = req.getParameter("bookMprice");
        book.setBookMprice(Integer.valueOf(bookMprice));
        //图书封面状态
        book.setBookPicStatus(0);
        //图书库存量
        String bookStoremount = req.getParameter("bookStoremount");
        book.setBookStoremount(Integer.valueOf(bookStoremount));
        //封装方式
        String bookPackstyle = req.getParameter("bookPackstyle");
        book.setBookPackstyle(bookPackstyle);
        bookService.addBook(book);
        try {
            req.getRequestDispatcher("/book.do?method=getBooklist").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getBooklist(HttpServletRequest req, HttpServletResponse resp,String mark) {
        int pageNum = 1;
        if(req.getParameter("currentPage") != null){
            pageNum = Integer.valueOf(req.getParameter("currentPage"));
        }
        int pageSize = 5;
        if(req.getParameter("pageSize") != null){
            pageSize = Integer.valueOf(req.getParameter("pageSize"));
        }

        //查询条件
        String searchBookTypeId = "";
        if(req.getParameter("searchBookTypeId") != null){
            searchBookTypeId = req.getParameter("searchBookTypeId");
        }
        String searchBookName = "";
        if(req.getParameter("searchBookName") != null){
            searchBookName = req.getParameter("searchBookName");
        }
        String searchBookAuthor = "";
        if(req.getParameter("searchBookAuthor") != null){
            searchBookAuthor = req.getParameter("searchBookAuthor");
        }
        Condition condition = new Condition();
        condition.setName(searchBookName);
        condition.setBookTypeId(searchBookTypeId);
        condition.setState(searchBookAuthor);

        int totalRecords = bookService.getBookCount(condition);
        //不同操作，不同的当前页设置
        PageModel pm = new PageModel(pageNum,totalRecords,pageSize);
        if("add".equals(mark)){
            pageNum = pm.getEndPage();
        }else if("update".equals(mark)){
            pageNum = Integer.valueOf(req.getParameter("currentPage"));
        }else{
            pageNum = Integer.valueOf(req.getParameter("currentPage"));
            if(pageNum > pm.getTotalPageNum()){
                pageNum = pm.getTotalPageNum();
            }
        }
        PageModel pageModel = new PageModel(pageNum,totalRecords,pageSize);
        //分页条件封装
        condition.setCurrentPage(pageModel.getStartIndex());
        condition.setPageSize(pageModel.getPageSize());
        List<Book> bookList = bookService.getBookList(condition);
        req.setAttribute("currentPage",pageNum);
        pageModel.setRecords(bookList);
        req.setAttribute("pm",pageModel);
        req.setAttribute("condition",condition);
        req.setAttribute("bookList",bookList);
        try {
            req.getRequestDispatcher("manager/bookList.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
