package com.epam;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.epam.MailBoxPage;
import com.epam.MailBoxSteps;

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
    	//System.setProperty("webdriver.gecko.driver", "D:\\3lvl\\2 семестр\\EPAM\\Selenium\\geckodriver.exe");
    	String exePath = "D:\\3lvl\\EPAM QA\\selenium\\Chrome driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		
        //driver = new FirefoxDriver();
		
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
    }
    
    @Test
    public void loginMailRu() {
    	driver = new ChromeDriver();
    	mailBoxPage = new MailBoxPage(driver);
        driver.get(BASE_URL);
    	System.out.println(driver.getTitle());
    	mailBoxPage.loginMailRu(LOGIN, PASSWORD);
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	mailBoxPage.createAndSaveNewEmail(EMAIL_ADDRESS, SUBJECT, BODY_TEXT);
    	
    }
}
