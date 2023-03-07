package com.testNg;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.mail.*;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNg {
	static WebDriver driver;

	public static void screenshot() throws WebDriverException, IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		FileHandler.copy(screenshot.getScreenshotAs(OutputType.FILE),
			new File("Screenshots" + System.currentTimeMillis() + ".png"));
	}

	@BeforeClass
	public void loadUrl() {
		// System.setProperty("webdriver.chrome.driver",
		// "E:\\Selenium\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void facebook() throws WebDriverException, IOException {
		driver.get("https://www.facebook.com/");
		screenshot();
	}

	/*@Test
	public void adactin() throws WebDriverException, IOException {
		driver.get("https://www.google.com/");
		screenshot();
	}

	@Test
	public void google() throws WebDriverException, IOException {
		driver.get("https://adactin.com/HotelApp/");
		screenshot();
	}*/

	@AfterClass
	public void browserClose() throws EmailException, MalformedURLException {
		driver.quit();
	}

	
	
	public static void sendmail() {

	    String username = "aiitetechnologyst2021@gmail.com";
	    String password = "One@0101";

	    Properties props = new Properties();
	    props.put("mail.smtp.auth", true);
	    props.put("mail.smtp.starttls.enable", true);
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "587");

	    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	        }
	    });
	    
	    //Decisionmindstest12@gmail.com
	    //Test@1234

	    try {
	    	
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress("sendingmailid"));
	        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("jackie.raj8@gmail.com"));
	        message.setSubject("Testing Subject");
	        message.setText("PFA");
	        
	        MimeBodyPart messageBodyPart = new MimeBodyPart();
	        String filename = "E:\\eclipse\\AllProjectFile.zip_expanded\\TryTestNg\\test-output\\emailable-report.html";
	        Multipart multipart = new MimeMultipart();
	        DataSource sourceA = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(sourceA));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);
	         
	        messageBodyPart = new MimeBodyPart();
	        String file = "E:\\eclipse\\AllProjectFile.zip_expanded\\TryTestNg\\test-output\\emailable-report.html";
	        String fileName = "emailable-report.html";
	        DataSource source = new FileDataSource(file);
	        messageBodyPart.setDataHandler(new DataHandler(source));
	        messageBodyPart.setFileName(fileName);
	        multipart.addBodyPart(messageBodyPart);

	        message.setContent(multipart);

	        System.out.println("Sending");

	        Transport.send(message);

	        System.out.println("Done");

	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
	    
	    
	}
	@AfterSuite
	public void appstop() throws IOException {
        sendmail();
    }
}
