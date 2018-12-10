package org.lanqiao.utils;

import org.lanqiao.dao.IBookTypeDao;
import org.lanqiao.dao.impl.BookTypeDaoImpl;
import org.lanqiao.domain.BookType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: WDS
 * @Date: 2018/12/9 15:01
 * @Description:
 */
public class DataMap {
    //把图书分类id和图书分类名称制作为键值对
    public Map<Integer,String> getBookTypeIdNameMap(){
        IBookTypeDao bookTypeDao = new BookTypeDaoImpl();
        List<BookType> bookTypeList = bookTypeDao.getBookTypeList(null);
        Map<Integer,String> map = new HashMap<>();
        for (int i = 0; i < bookTypeList.size(); i++) {
            map.put(bookTypeList.get(i).getBookTypeId(),bookTypeList.get(i).getBookTypeName()) ;
        }
        return map;
    }
}
