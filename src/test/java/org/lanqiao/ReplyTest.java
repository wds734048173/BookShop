package org.lanqiao;

import org.junit.Test;
import org.lanqiao.domain.Reply;
import org.lanqiao.service.IReplyService;
import org.lanqiao.service.impl.ReplyServiceImpl;

import java.util.List;

public class ReplyTest {
    IReplyService replyService = new ReplyServiceImpl();
    @Test
    public void getReplyList(){
        List<Reply> replyList = replyService.getReplyList();
        for (int i = 0;i < replyList.size();i++ ){
            System.out.println(replyList.get(i).toString());
        }
    }
}


