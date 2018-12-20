package com.balceda.ws.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.balceda.ws.model.Content;
import com.balceda.ws.model.Message;

@Controller
public class MessageController {

    @MessageMapping("/chat")
    @SendTo("/topic/content")
    public Content sendContent(Message msg) throws Exception {
	Thread.sleep(1000);
	return new Content(
		HtmlUtils.htmlEscape(msg.getName()) + " says: " + HtmlUtils.htmlEscape(msg.getMessage() + "."));
    }
}
