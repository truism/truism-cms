package site.liuming.truismcms.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.liuming.truismcms.core.common.UnifyResponse;
import site.liuming.truismcms.dto.PagePojoDto;
import site.liuming.truismcms.web.pojo.Message;
import site.liuming.truismcms.web.service.MessageService;

import java.util.List;

@RequestMapping("/message")
@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/")
    public UnifyResponse<String> receiveMessage(@RequestBody Message message) {
        return messageService.receive(message);
    }

    @GetMapping("/")
    public UnifyResponse<PagePojoDto<Message>> messageList(@RequestParam(value = "pageNum", required = true) Integer pageNum) {
        return messageService.getMessageList(pageNum);
    }

    @PutMapping("/reply/{id}")
    public UnifyResponse<String> replyMessage(@PathVariable("id") Long id) {
        return messageService.replyMessage(id);
    }

    @DeleteMapping("/{id}")
    public UnifyResponse<String> deleteMessage(@PathVariable Long id) {
        return messageService.deleteMessage(id);
    }

}
