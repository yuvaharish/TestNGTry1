package com.testNg;

import java.net.MalformedURLException;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.testng.TestNG;

public class TestRunner {
	
	static TestNG testNg;
	public static void main(String[] args) throws MalformedURLException, EmailException {
		testNg = new TestNG();
		testNg.setTestClasses(new Class[] {TestNg.class});
		testNg.run();
		
		
	}
	
	public static void sentEmail() throws EmailException, MalformedURLException {

		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("emailable-report.html");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Screen shots");
		attachment.setName("SS Result");
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("aiitetechnologyst2021@gmail.com", "One@0101"));
		email.setSSLOnConnect(true);
		email.setFrom("yuvaharish16@gmail.com");
		email.setSubject("Selenium Test Report");
		email.setMsg("This is a test mail From Yuva");
		email.addTo("jackie.raj8@gmail.com");
		email.attach(attachment);
		email.send();
	}

}
