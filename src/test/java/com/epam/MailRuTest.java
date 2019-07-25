package com.epam;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.epam.MailBoxPage;


public class MailRuTest {
	private static final String BASE_URL = "https://mail.ru/";
	private static final String LOGIN = "testnameselenium1";
	private static final String PASSWORD = "passwordselenium";
	private static final String EMAIL_ADDRESS = "testnameselenium1@gmail.com";
	private static final String SUBJECT = "Test";
	private static final String BODY_TEXT = "zvsvsvTest";
    private WebDriver driver;
	private MailBoxPage mailBoxPage;
	
    @BeforeClass
    public void setUpBefore(){
    	String exePath = "D:\\3lvl\\EPAM QA\\selenium\\Chrome driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);		
    }
    
    @Test
    public void loginMailRu() {
    	driver = new ChromeDriver();
    	mailBoxPage = new MailBoxPage(driver);
        driver.get(BASE_URL);
    	System.out.println(driver.getTitle());
    	mailBoxPage.loginMailRu(LOGIN, PASSWORD);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	mailBoxPage.createAndSaveNewEmail(EMAIL_ADDRESS, SUBJECT, BODY_TEXT);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	mailBoxPage.goToDraft();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	mailBoxPage.verifyMailInDraft(EMAIL_ADDRESS, SUBJECT, BODY_TEXT);
    	mailBoxPage.isDraftMailSentAndDeleteFromDraft(EMAIL_ADDRESS, SUBJECT, BODY_TEXT);
    	mailBoxPage.goOut();
    }
}
