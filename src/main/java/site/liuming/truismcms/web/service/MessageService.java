package site.liuming.truismcms.web.service;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.liuming.truismcms.core.common.UnifyResponse;
import site.liuming.truismcms.core.common.UnifyResponseFactory;
import site.liuming.truismcms.web.mapper.MessageMapper;
import site.liuming.truismcms.web.pojo.Message;

import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@Service
public class MessageService {

    private final int pageSize = 10;

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

    /**
     * 获取未回复留言列表
     * @param pageNum
     * @return
     */
    public UnifyResponse<List<Message>> getMessageList(Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);

        List<Message> messageList = messageMapper.getList();

        return UnifyResponseFactory.success(messageList);

    }

    /**
     *  设置已回复留言
     * @param id
     * @return
     */
    public UnifyResponse<String> replyMessage(Integer id) {
        if( !Objects.nonNull(id)) {
            return UnifyResponseFactory.fail("此留言不存在");
        }
        int count = messageMapper.replyMessage(id);
        return count > 0 ? UnifyResponseFactory.success("回复成功") : UnifyResponseFactory.fail("回复失败");
    }
}
