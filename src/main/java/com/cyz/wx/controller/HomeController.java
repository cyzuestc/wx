package com.cyz.wx.controller;

import com.cyz.wx.util.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Autowired
    MailSender mailSender;
    @RequestMapping(path = {"/"})
    @ResponseBody
    public String index(@RequestParam("content") String content){

        mailSender.sendWithHTMLTemplate("617217616@qq.com",content,content);

        return "index";
    }

}
