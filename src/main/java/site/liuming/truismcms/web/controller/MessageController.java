package site.liuming.truismcms.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.liuming.truismcms.core.common.UnifyResponse;
import site.liuming.truismcms.web.pojo.Message;
import site.liuming.truismcms.web.service.MessageService;

@RequestMapping("/message")
@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/")
    public UnifyResponse<String> receiveMessage(@RequestBody Message message) {
        return messageService.receive(message);
    }


}
