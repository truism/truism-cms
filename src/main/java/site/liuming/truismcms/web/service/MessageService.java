package site.liuming.truismcms.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.liuming.truismcms.core.common.UnifyResponse;
import site.liuming.truismcms.core.common.UnifyResponseFactory;
import site.liuming.truismcms.web.mapper.MessageMapper;
import site.liuming.truismcms.web.pojo.Message;

import java.util.Calendar;

@Service
public class MessageService {

    @Autowired
    private MessageMapper messageMapper;

    /**
     * 接收留言
     * @param message
     * @return
     */
    @Transactional
    public UnifyResponse<String> receive(Message message) {
        // 设置用户名--邮箱
        message.setUsername(message.getUserEmail());
        // 设置留言时间
        message.setPublishTime(Calendar.getInstance().getTime());
        // 设置留言未读
        message.setReply(false);
        int count = messageMapper.insert(message);
        if(count == 0) {
            return UnifyResponseFactory.fail("发送留言失败，请稍后重试或联系博主");
        }
        return UnifyResponseFactory.success("发送留言成功");
    }
}
