package testTeretana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import testTeretana.dao.OperaterDao;
import testTeretana.domain.Clan;
import testTeretana.domain.Operater;
import testTeretana.domain.dto.OperaterResDto;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
public class JavaMailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	
	
	@Autowired
	private OperaterDao operaterDao;
	
	public JavaMailService(JavaMailSender javaMailSender) {
	}
	
	public void setMailSender(JavaMailSender mailSender) {
	        this.mailSender = mailSender;
	}
	
	/*
	 	public void sendMessage(Clan clan) throws MailException {
		SimpleMailMessage message = new SimpleMailMessage(); 
		message.setTo("bajricaleksa4@gmail.com");
		message.setFrom("bajricaleksa4@gmail.com");
		message.setSubject("Proba");
		message.setText("<b>Hello</b>");
		
		javaMailSender.send(message);
		 
	}*/
	
	public void sendEmailToUsers(Clan clan) throws MessagingException{
		MimeMessage message =mailSender.createMimeMessage();
			StringBuilder sb = new StringBuilder("<body style='border:2px solid black'>");
			sb.append("<ul>");
	        MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");

	        List<Operater> li = operaterDao.findAll();
	        List<OperaterResDto> result = new ArrayList<>();
	        for (Operater operater : li) {
	        	result.add(new OperaterResDto(operater));
			
			for (OperaterResDto ord : result) {
				sb.append("<li>");
				sb.append(ord.toString());
				sb.append("</li>");
			}		 	
		}	
	        
	        //sb.append(result.toString());
	        sb.append("</ul>");
	        sb.append("<img src=\"http://cnti.info/blogs/wp-content/uploads/2017/02/tumblr_static_tumblr_static_under_the_gun__sidebar__transparent_-431x510.gif\">");
	
	        sb.append("</body>");
    
	        message.setContent(sb.toString(), "text/html");
	        helper.setTo("bajricaleksa4@gmail.com");
	        helper.setSubject("Proba");
	       
	        mailSender.send(message);
	}

	//Email with attachments//	
	public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) throws MessagingException {
		
		MimeMessage message1 = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message1, true);
		
		helper.setTo(to);
	    helper.setSubject(subject);
	    helper.setText(text);
		
		FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
		helper.addAttachment("Invoice", file);
		
		
		mailSender.send(message1);
		
	}
	//End Email with attachments//	
	
	
	
	
	
	
	  //Email with attachments//	
    /*
    Multipart multipart = new MimeMultipart();
    BodyPart attach = new MimeBodyPart();
    DataSource source = new FileDataSource("/home/aleksa/Documents/workspace-spring-tool-suite-4-4.1.1.RELEASE/teretana-master.git/teretana-master/src/main/java/testTeretana/img/test.jpg");
    attach.setDataHandler(new DataHandler(source));
    attach.setFileName("test.jpg");
    multipart.addBodyPart(attach);
    message.setContent(multipart);
     */
   //End Email with attachments//
		
	}
