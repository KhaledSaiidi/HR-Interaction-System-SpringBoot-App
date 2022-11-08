package tn.esprit.spring.controllers;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import tn.esprit.spring.config.MyConstants;



@RestController
public class EmailRestController {

	
	@Autowired
    public JavaMailSender emailSender;
	
	@ResponseBody
    @PostMapping("/api/sendSimpleEmail")
    public String sendSimpleEmail() {

        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();
        
        message.setTo(MyConstants.FRIEND_EMAIL);
        message.setSubject("Test Simple Email");
        message.setText("Hello, Im testing Simple Email");

        // Send Message!
        this.emailSender.send(message);

        return "Email Sent!";
    }
	
	
	
	@ResponseBody
    @RequestMapping("/api/sendAttachmentEmail")
    public String sendAttachmentEmail() throws MessagingException {

        MimeMessage message = emailSender.createMimeMessage();

        boolean multipart = true;

        MimeMessageHelper helper = new MimeMessageHelper(message, multipart);

        helper.setTo(MyConstants.FRIEND_EMAIL);
        helper.setSubject("Test email with attachments");
        
        helper.setText("Hello, Im testing email with attachments!");
        
        String path1 = "C:\\Users\\khaoula\\Desktop\\hummer.jpg";
//        String path2 = "/home/tran/Downloads/readme.zip";

        // Attachment 1
        FileSystemResource file1 = new FileSystemResource(new File(path1));
        helper.addAttachment("Txt file", file1);

        // Attachment 2
//        FileSystemResource file2 = new FileSystemResource(new File(path2));
//        helper.addAttachment("Readme", file2);

        emailSender.send(message);

        return "Email Sent!";
    }
	
	
	@ResponseBody
    @GetMapping("api/sendHtmlEmail")
    public String sendHtmlEmail() throws MessagingException {

        MimeMessage message = emailSender.createMimeMessage();

        boolean multipart = true;
        
        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");
        
        String htmlMsg = "<h3>Im testing send a HTML email</h3>"
        		+"<h1>Spring Boot</1>"
                +"<img src='http://www.apache.org/images/asf_logo_wide.gif'>";
        
        message.setContent(htmlMsg, "text/html");
        
        helper.setTo(MyConstants.FRIEND_EMAIL);
        
        helper.setSubject("Test send HTML email");
        
    
        this.emailSender.send(message);

        return "Email Sent successfully !";
    }

	
	
	
}
