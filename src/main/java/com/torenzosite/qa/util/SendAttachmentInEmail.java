package com.torenzosite.qa.util;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import static com.torenzosite.qa.util.TestUtil.OSName;
import static com.torenzosite.qa.util.TestUtil.screenshotName;

import java.util.Properties;
public class SendAttachmentInEmail {
		
	public static void main(String[] args) throws InterruptedException {
		SendAttachmentInEmail ml = new SendAttachmentInEmail();
		ml.email();
		}
	
	   String filename2;
	   String filename;		
       String image;
       DataSource fds;
       String to = "sachin.patil.uk@gmail.com";
       String from = "patilkrishna668@gmail.com";
       final String username = "patilkrishna668@gmail.com";//change accordingly
	   final String password = "9552619077";//change accordingly	
	   String host = "smtp.googlemail.com";
     
	  public void sentScreenShot(){
	    	 Properties props = new Properties();
			    props.put("mail.smtp.auth", "true");
			    props.put("pro.turbo-smtp.com", "true");
			    props.put("mail.smtp.starttls.enable", "true");
			    props.put("mail.smtp.host", host);
			    props.put("mail.smtp.port", 587);
			    props.put("-Djava.net.preferIPv4Stack", "true");
			    props.setProperty("mail.smtp.host", host);

		  Session session = Session.getDefaultInstance(props,
				  
				         new javax.mail.Authenticator() {
				           protected javax.mail.PasswordAuthentication getPasswordAuthentication()  {
				
				           return new javax.mail.PasswordAuthentication( username, password.toString());
			
				          }
				  
				          });
		    try {
		     System.out.println("Attach capture screenshot and here is screenshot name ==>"+screenshotName);
	           Message message = new MimeMessage(session);
		       message.setFrom(new InternetAddress(from));
		       message.setRecipients(Message.RecipientType.TO,
		          InternetAddress.parse(to));
		       message.setSubject("Testing Report");
		       //
		       BodyPart messageBodyPart = new MimeBodyPart();
		       messageBodyPart.setText("It's execution reprot of the test cases and it's conatin log , screenshot and .html file");
		
		       MimeMultipart multipart1 = new MimeMultipart("related");

		         // first part (the html)
		         BodyPart messageBodyPart1 = new MimeBodyPart();
		    
		         if(OSName.equalsIgnoreCase("Mac OS X")){
		             image = "/Users/rahul.kardel/Documents/TorenzoWebSite/Screenshot/"+ screenshotName +".jpeg";
			          messageBodyPart1.setContent(image, "text/html"); 
		         }
		         else if(OSName.equalsIgnoreCase("Windows 7")||OSName.equalsIgnoreCase("Windows 10")){
		        	 
			          image = "E:\\SeleniumWorkSpace\\torenzowebsite\\TorenzoWebSite\\Screenshot\\"+ screenshotName +".jpeg";
			          messageBodyPart1.setContent(image, "text/html");
		          
		        	 
		         }
	        
		         multipart1.addBodyPart(messageBodyPart1);
		         messageBodyPart1 = new MimeBodyPart();
		         if(OSName.equalsIgnoreCase("Mac OS X")){

			    	  fds = new FileDataSource("/Users/rahul.kardel/Documents/TorenzoWebSite/Screenshot/"+ screenshotName +".jpeg");
			    	   messageBodyPart1.setDataHandler(new DataHandler(fds));
		         }
		         else if(OSName.equalsIgnoreCase("Windows 7")||OSName.equalsIgnoreCase("Windows 10")){

			    	  fds = new FileDataSource("E:\\SeleniumWorkSpace\\torenzowebsite\\TorenzoWebSite\\Screenshot\\"+ screenshotName +".jpeg");
			    	   messageBodyPart1.setDataHandler(new DataHandler(fds)); 
		         }


		         messageBodyPart1.setHeader("Content-ID", "<image>"); 
		         multipart1.addBodyPart(messageBodyPart1);
		         message.setContent(multipart1);
		         Transport.send(message);
		         System.out.println("Screenshot Sent successfully....");
	     	
		    } catch (MessagingException e) {
		       throw new RuntimeException(e);
		    }
	    	 
	     }
	  
	public void email() throws InterruptedException
		{ 
		 Properties props = new Properties();
		    props.put("mail.smtp.auth", "true");
		    props.put("pro.turbo-smtp.com", "true");
		    props.put("mail.smtp.starttls.enable", "true");
		    props.put("mail.smtp.host", host);
		    props.put("mail.smtp.port", 587);
		    props.put("-Djava.net.preferIPv4Stack", "true");
		    props.setProperty("mail.smtp.host", host);

	  Session session = Session.getDefaultInstance(props,
			  
			         new javax.mail.Authenticator() {
			           protected javax.mail.PasswordAuthentication getPasswordAuthentication()  {
			
			           return new javax.mail.PasswordAuthentication( username, password.toString());
		

			          }
			  
			          });	   
	  
	        try {
	   	     System.out.println("Attaching .html report from TestNG");
	              Message message = new MimeMessage(session);
	   	       message.setFrom(new InternetAddress(from));
	   	       message.setRecipients(Message.RecipientType.TO,
	   	          InternetAddress.parse(to));
	   	       message.setSubject("Testing Report");
	   	       //
	   	       BodyPart messageBodyPart = new MimeBodyPart();
	   	    messageBodyPart.setText("It's execution reprot of the test cases and it's conatin log , screenshot and .html file");
	         Multipart multipart = new MimeMultipart();
		       multipart.addBodyPart(messageBodyPart);
		       messageBodyPart = new MimeBodyPart();
		       Thread.sleep(5000);	
		       if(OSName.equalsIgnoreCase("Mac OS X")){
		    		filename = "/Users/rahul.kardel/Documents/TorenzoWebSite/test-output/TorenzoWebSiteReport.html"; 
			    	   DataSource source = new FileDataSource(filename);
			    	   messageBodyPart.setDataHandler(new DataHandler(source));
			    	     messageBodyPart.setFileName(filename);  
		       }
		       else if(OSName.equalsIgnoreCase("Windows 7")||OSName.equalsIgnoreCase("Windows 10")){
		    		filename = "E:\\SeleniumWorkSpace\\torenzowebsite\\TorenzoWebSite\\test-output\\TorenzoWebSiteReport.html"; 
			    	   DataSource source = new FileDataSource(filename);
			    	   messageBodyPart.setDataHandler(new DataHandler(source));
			    	     messageBodyPart.setFileName(filename);   
		    	   
		       }
		      		
		          multipart.addBodyPart(messageBodyPart);
		           messageBodyPart = new MimeBodyPart();
		       // Send the complete message parts
		         message.setContent(multipart);	     
		        Transport.send(message);
                System.out.println(".HTML report Sent successfully....");
 	
	    } catch (MessagingException e) {
	       throw new RuntimeException(e);
	    }
	        
	       try {
		   	           System.out.println("TestNG report or Execution report of the app");
		              Message message2= new MimeMessage(session);
		   	          message2.setFrom(new InternetAddress(from));
		   	          message2.setRecipients(Message.RecipientType.TO,
		   	          InternetAddress.parse(to));
		   	           message2.setSubject("Testing Report"); 	     
		   	       BodyPart messageBodyPart2 = new MimeBodyPart();
		   	    messageBodyPart2.setText("It's execution reprot of the test cases and it's conatin log , screenshot and .html file");
		         Multipart multipart2 = new MimeMultipart();
			       multipart2.addBodyPart(messageBodyPart2);
			       messageBodyPart2 = new MimeBodyPart();
			       Thread.sleep(5000);
			       if(OSName.equalsIgnoreCase("Mac OS X")){
			    	   filename2 = "/Users/rahul.kardel/Documents/TorenzoWebSite/test-output/emailable-report.html";
				  	     DataSource source = new FileDataSource(filename2);
				 	    messageBodyPart2.setDataHandler(new DataHandler(source));
				 	     messageBodyPart2.setFileName(filename2);   
			       }
			       else if(OSName.equalsIgnoreCase("Windows 7")||OSName.equalsIgnoreCase("Windows 10")){
			    	   filename2 = "E:\\SeleniumWorkSpace\\torenzowebsite\\TorenzoWebSite\\test-output\\emailable-report.html";
				  	     DataSource source = new FileDataSource(filename2);
				 	    messageBodyPart2.setDataHandler(new DataHandler(source));
				 	     messageBodyPart2.setFileName(filename2);  
			    	   
			       }
			    	 
			       multipart2.addBodyPart(messageBodyPart2);
			      messageBodyPart2 = new MimeBodyPart();
			       // Send the complete message parts
			       message2.setContent(multipart2);
     
			        Transport.send(message2);
	         System.out.println(" Sent emailable-report.html successfully....");
	    } catch (MessagingException e) {
		       throw new RuntimeException(e);
		    }
	 }

}
