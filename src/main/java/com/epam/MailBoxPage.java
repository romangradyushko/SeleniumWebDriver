package com.epam;

import org.openqa.selenium.*;
import javax.script.*;

public class MailBoxPage extends AbstractPage{	
	private static final String BASE_URL = "https://mail.ru/";		
	private static final By LOGIN_INPUT_LOCATOR = By.xpath("//*[@id=\"mailbox:login\"]");
	private static final By PASSWORD_INPUT_LOCATOR = By.xpath("//*[@id=\"mailbox:password\"]");
	private static final By ENTER_BUTTON_LOCATOR = By.xpath("/html/body/div[2]/div[2]/div[1]/div[1]/div[2]/form/div[2]/div[2]/label/input");
	private static final By EMAIL_BUTTON_CREATE_LOCATOR = By.xpath("//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div[1]/div[1]/div/span/span");
	private static final By EMAIL_INPUT_TO_LOCATOR = By.xpath("/html/body/div[14]/div[2]/div/div[1]/div[2]/div[3]/div[2]/div/div/div[1]/div/div[2]/div/div/label/div/div/input");
	private static final By EMAIL_INPUT_SUBJECT_LOCATOR = By.xpath("/html/body/div[14]/div[2]/div/div[1]/div[2]/div[3]/div[3]/div[1]/div[2]/div/input");
	
	private static final By EMAIL_INPUT_TEXT_LOCATOR = By.xpath("/html/body/div[14]/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div[1]/div/div/div[1]/div[2]/button");
	
	private static final By EMAIL_BUTTON_SAVE_LOCATOR = By.xpath("/html/body/div[14]/div[2]/div/div[2]/div[1]/span[2]/span/span");
	private static final By EMAIL_BUTTON_SEND_LOCATOR = By.xpath("/html/body/div[14]/div[2]/div/div[2]/div[1]/span[1]/span/span");
	
	public MailBoxPage(WebDriver driver) {
        super(driver);
    }
	
	public void OpenPage() {
		driver.get(BASE_URL);	
	}
	
	public void loginMailRu(String login, String password) {
		driver.findElement(LOGIN_INPUT_LOCATOR).click();
        driver.findElement(LOGIN_INPUT_LOCATOR).sendKeys(login);
        driver.findElement(PASSWORD_INPUT_LOCATOR).click();
        driver.findElement(PASSWORD_INPUT_LOCATOR).sendKeys(password);
        driver.findElement(ENTER_BUTTON_LOCATOR).click();
	}	
	
	public void createAndSaveNewEmail(String to, String subject, String text) {
		driver.findElement(EMAIL_BUTTON_CREATE_LOCATOR).click();
		//driver.switchTo().defaultContent();
		//driver.switchTo().frame("page g-default-font theme-default");
		//driver.switchTo().frame(driver.findElement(By.className("page g-default-font theme-default")));
		
		driver.findElement(EMAIL_INPUT_TO_LOCATOR).click();
		driver.findElement(EMAIL_INPUT_TO_LOCATOR).sendKeys(to);
		driver.findElement(EMAIL_INPUT_SUBJECT_LOCATOR).click();
		driver.findElement(EMAIL_INPUT_SUBJECT_LOCATOR).sendKeys(subject);
		
		
		//driver.findElement(EMAIL_INPUT_TEXT_LOCATOR).click();
		//driver.findElement(EMAIL_INPUT_TEXT_LOCATOR).sendKeys(text);
		ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        String script = "document.getElementByClassName('editable-container-p2pp').innerHTML=" + text;
        try {
			engine.eval(script);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("document.getElementByClassName('editable-container-p2pp').innerHTML="+ text);
		
		
		//driver.findElement(EMAIL_BUTTON_SAVE_LOCATOR).click();
	}
	
	
}
