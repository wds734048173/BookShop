package org.lanqiao;

import org.junit.Test;
import org.lanqiao.domain.BookType;
import org.lanqiao.domain.Condition;
import org.lanqiao.service.IBookTypeService;
import org.lanqiao.service.impl.BookTypeServiceImpl;

import java.util.List;

public class BookTypeTest {
    IBookTypeService bookTypeService = new BookTypeServiceImpl();
    @Test
    public void getBookTypeList(){
        Condition condition = new Condition();
        List<BookType> bookTypeList = bookTypeService.getBookTypeList(condition);
        for (int i = 0; i < bookTypeList.size(); i++) {
            System.out.println(bookTypeList.get(i).toString());
        }
    }
}
