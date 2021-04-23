package com.aa.awesomecareer.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.aa.awesomecareer.entity.Application;
import com.aa.awesomecareer.model.ApplicationModel;
import com.aa.awesomecareer.model.MailModel;
import com.aa.awesomecareer.repository.ApplicationRepository;
import com.aa.awesomecareer.service.EmailSenderService;


@Service
public class EmailSenderServiceImp implements EmailSenderService {
	
	private static final Logger logger = LoggerFactory.getLogger(EmailSenderServiceImp.class);
	
	@Autowired 
	ApplicationRepository applicationRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;
    
    @Override
    public void sendEmail(MailModel mailModel) throws MessagingException, IOException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
        MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
        StandardCharsets.UTF_8.name());

        String html = getHtmlContent(mailModel);

        helper.setTo(mailModel.getTo());
        helper.setFrom(mailModel.getFrom());
        helper.setSubject(mailModel.getSubject());
        helper.setText(html, true);
        
        FileSystemResource file = new FileSystemResource("C:\\Users\\Admin\\Desktop\\Awesome.pdf");
        helper.addAttachment(file.getFilename(), file);
        
        javaMailSender.send(message);
    }

    private String getHtmlContent(MailModel mailModel) {
        Context context = new Context();
        context.setVariables(mailModel.getHtmlTemplate().getProps());
        return templateEngine.process(mailModel.getHtmlTemplate().getTemplate(), context);
    }
    
    
    @Override
    public void sendEmailWithLink (String recipientEmail, String link) throws MessagingException, UnsupportedEncodingException{
    	logger.info("Sending email to recipient");
    	try {
    	MimeMessage message = javaMailSender.createMimeMessage();
    	MimeMessageHelper helper = new MimeMessageHelper(message);
    	
    	helper.setFrom("dinhhieu@gmail.com","Inform about forgot email");
    	helper.setTo(recipientEmail);
    	
    	String subject ="Here the link to reset your password";
    	
    	String content ="<p>Hello,</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p>Click the link below to change your password:</p>"
                + "<p><a href=\"" + link + "\">Change my password</a></p>"
                + "<br>"
                + "<p>Ignore this email if you do remember your password, "
                + "or you have not made the request.</p>";
    	helper.setSubject(subject);
    	helper.setText(content,true);
    	
    	javaMailSender.send(message);
    }catch(Exception e) {
    	logger.error("An error occurred while sending email to recepient",e);
    }
    }
}