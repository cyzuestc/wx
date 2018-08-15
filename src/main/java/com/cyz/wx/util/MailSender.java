package com.cyz.wx.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.util.Properties;



@Service
public class MailSender implements InitializingBean{
    private static final Logger logger = LoggerFactory.getLogger(MailSender.class);
    private JavaMailSenderImpl mailSender;


    public boolean sendWithHTMLTemplate(String to, String subject, String content){
        try {
            String nick = MimeUtility.encodeText("MimeUtility.encodeText");
            InternetAddress from = new InternetAddress("421248827@qq.com");
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content,true);
            mailSender.send(mimeMessage);
            logger.info("邮件发送成功");
            return true;
        } catch (Exception e) {
            logger.error("邮件发送失败: "+e.getMessage());
        }
        return false;
    }



    @Override
    public void afterPropertiesSet() throws Exception {
        mailSender = new JavaMailSenderImpl();
        mailSender.setUsername("421248827@qq.com");
        mailSender.setPassword("oxdbnqfsecazbjca");
        mailSender.setHost("smtp.qq.com");
        mailSender.setPort(465);
        mailSender.setProtocol("smtps");
        mailSender.setDefaultEncoding("utf8");
        Properties properties = new Properties();
        properties.put("mail.stmp.ssl.enable",true);
        mailSender.setJavaMailProperties(properties);
    }
}
