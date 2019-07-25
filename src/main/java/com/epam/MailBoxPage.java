package com.epam;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import javax.script.*;

public class MailBoxPage extends AbstractPage{	
	public static final int WAIT_FOR_ELEMENT_TIMEOUT_SECONDS = 10;
	private static final String BASE_URL = "https://mail.ru/";		
	private static final By LOGIN_INPUT_LOCATOR = By.xpath("//*[@id=\"mailbox:login\"]");
	private static final By PASSWORD_INPUT_LOCATOR = By.xpath("//*[@id=\"mailbox:password\"]");
	private static final By ENTER_BUTTON_LOCATOR = By.xpath("/html/body/div[2]/div[2]/div[1]/div[1]/div[2]/form/div[2]/div[2]/label/input");
	private static final By EMAIL_BUTTON_CREATE_LOCATOR = By.xpath("//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div[1]/div[1]/div/span/span");
	private static final By EMAIL_INPUT_TO_LOCATOR = By.xpath("/html/body/div[14]/div[2]/div/div[1]/div[2]/div[3]/div[2]/div/div/div[1]/div/div[2]/div/div/label/div/div/input");
	private static final By EMAIL_INPUT_SUBJECT_LOCATOR = By.xpath("/html/body/div[14]/div[2]/div/div[1]/div[2]/div[3]/div[3]/div[1]/div[2]/div/input");
	
	private static final By EMAIL_INPUT_TEXT_LOCATOR = By.xpath(".//div[@role='textbox']");
	
	private static final By EMAIL_BUTTON_SAVE_LOCATOR = By.xpath("/html/body/div[14]/div[2]/div/div[2]/div[1]/span[2]/span/span");
	private static final By EMAIL_BUTTON_EXIT_LOCATOR = By.xpath("/html/body/div[14]/div[2]/div/div[1]/div[2]/div[2]/div/div/button[2]");
	private static final By EMAIL_BUTTON_DRAFT_FOLDER_LOCATOR = By.xpath("//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div[1]/div[2]/div/div[1]/nav/a[5]/div");
	private static final By EMAIL_BUTTON_MAIL_IN_DRAFT_FOLDER_LOCATOR = By.xpath("//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div/div/div/a[1]/div[4]/div/div[3]");
	private static final By EMAIL_INPUT_TO_LOCATOR_DRAFT = By.xpath("/html/body/div[14]/div[2]/div/div[1]/div[2]/div[3]/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div/div/span");
	private static final By EMAIL_INPUT_SUBJECT_LOCATOR_DRAFT = By.xpath("/html/body/div[14]/div[2]/div/div[1]/div[2]/div[3]/div[3]/div[1]/div[2]/div/input");
	private static final By EMAIL_INPUT_TEXT_LOCATOR_DRAFT = By.xpath(".//div[@role='textbox']");
	
	private static final By EMAIL_BUTTON_SEND_LOCATOR = By.xpath("/html/body/div[14]/div[2]/div/div[2]/div[1]/span[1]/span/span");
	private static final By EMAIL_BUTTON_EXIT_SEND_LOCATOR =  By.xpath("/html/body/div[8]/div/div/div[2]/div[2]/div/div/div[1]/span/span");
	
	private static final By EMAIL_BUTTON_SENT_LOCATOR = By.xpath("//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div[1]/div[2]/div/div[1]/nav/a[4]");
	private static final By EMAIL_BUTTON_MAIL_IN_SENT_FOLDER_LOCATOR = By.xpath("//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div/div/div/a[1]/div[4]/div/div[3]");
	private static final By EMAIL_INPUT_TO_LOCATOR_SENT = By.xpath("//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/div/div/div[2]/div/div[1]/div/div[2]/div[2]/span");
	private static final By EMAIL_INPUT_SUBJECT_LOCATOR_SENT = By.xpath("//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/div/div/div[1]/div");
	private static final By EMAIL_INPUT_TEXT_LOCATOR_SENT = By.xpath("//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[2]/div/div/div/div/div/div/div[2]/div/div[2]/div[2]/div/div/div/div/div/div/div/div");
	private static final By EXIT = By.xpath("//*[@id=\"PH_logoutLink\"]");
	
	public MailBoxPage(WebDriver driver) {
        super(driver);
    }
	
	public void OpenPage() {
		driver.get(BASE_URL);	
	}
	
	public void waitForElementEnabled(By locator) {
		new WebDriverWait(driver, WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void loginMailRu(String login, String password) {
		waitForElementEnabled(LOGIN_INPUT_LOCATOR);
		driver.findElement(LOGIN_INPUT_LOCATOR).click();
        driver.findElement(LOGIN_INPUT_LOCATOR).sendKeys(login);
        driver.findElement(PASSWORD_INPUT_LOCATOR).click();
        driver.findElement(PASSWORD_INPUT_LOCATOR).sendKeys(password);
        driver.findElement(ENTER_BUTTON_LOCATOR).click();
	}	
	
	public void createAndSaveNewEmail(String to, String subject, String text) {
		waitForElementEnabled(EMAIL_BUTTON_CREATE_LOCATOR);
		driver.findElement(EMAIL_BUTTON_CREATE_LOCATOR).click();
		driver.switchTo().defaultContent();
		waitForElementEnabled(EMAIL_INPUT_TO_LOCATOR);
		driver.findElement(EMAIL_INPUT_TO_LOCATOR).click();
		driver.findElement(EMAIL_INPUT_TO_LOCATOR).sendKeys(to);
		driver.findElement(EMAIL_INPUT_SUBJECT_LOCATOR).click();
		driver.findElement(EMAIL_INPUT_SUBJECT_LOCATOR).sendKeys(subject);
		driver.findElement(EMAIL_INPUT_TEXT_LOCATOR).sendKeys(text);
		//waitForElementEnabled(EMAIL_BUTTON_SAVE_LOCATOR);
		driver.findElement(EMAIL_BUTTON_SAVE_LOCATOR).click();	
	}
	
	public void goToDraft() {
		waitForElementEnabled(EMAIL_BUTTON_EXIT_LOCATOR);
		driver.findElement(EMAIL_BUTTON_EXIT_LOCATOR).click();
		waitForElementEnabled(EMAIL_BUTTON_DRAFT_FOLDER_LOCATOR);
		driver.findElement(EMAIL_BUTTON_DRAFT_FOLDER_LOCATOR).click();	
	}
	
	public void verifyMailInDraft(String to, String subject, String text) {
		waitForElementEnabled(EMAIL_BUTTON_MAIL_IN_DRAFT_FOLDER_LOCATOR);
		driver.findElement(EMAIL_BUTTON_MAIL_IN_DRAFT_FOLDER_LOCATOR).click();
		Assert.assertEquals(driver.findElement(EMAIL_INPUT_TO_LOCATOR_DRAFT).getText(), to, "Receiver is invalid");
		Assert.assertEquals(driver.findElement(EMAIL_INPUT_SUBJECT_LOCATOR_DRAFT).getAttribute("value"), subject, "Subject is invalid");
		Assert.assertTrue(driver.findElement(EMAIL_INPUT_TEXT_LOCATOR_DRAFT).getText().contains(text), "Text is invalid");
		waitForElementEnabled(EMAIL_BUTTON_SEND_LOCATOR);
		driver.findElement(EMAIL_BUTTON_SEND_LOCATOR).click();
		driver.findElement(EMAIL_BUTTON_EXIT_SEND_LOCATOR).click();
	}
	
	 public void isDraftMailSentAndDeleteFromDraft(String to, String subject, String text) {
	     driver.findElement(EMAIL_BUTTON_SENT_LOCATOR).click();
	     waitForElementEnabled(EMAIL_BUTTON_MAIL_IN_SENT_FOLDER_LOCATOR);
	     driver.findElement(EMAIL_BUTTON_MAIL_IN_SENT_FOLDER_LOCATOR).click();
		 Assert.assertEquals(driver.findElement(EMAIL_INPUT_TO_LOCATOR_SENT).getText(), to, "Receiver is invalid");
		 Assert.assertEquals(driver.findElement(EMAIL_INPUT_SUBJECT_LOCATOR_SENT).getText(), subject, "Subject is invalid");
		 Assert.assertTrue(driver.findElement(EMAIL_INPUT_TEXT_LOCATOR_SENT).getText().contains(text), "Text is invalid");
	 }
	 
	 public void goOut() {
		 driver.findElement(EXIT).click();
	 }
}
