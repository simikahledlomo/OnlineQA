package sharedService;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PublicFunctions {
	WebDriver driver;
	
	public PublicFunctions (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectByVisibleText(String text, WebElement element) {
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(text);
	}
	
	public void selectByIndex(int index, WebElement element) {
		Select dropdown = new Select(element);
		dropdown.selectByIndex(index);
	}
	
	public void selectByValue(String value, WebElement element) {
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);
	}
	
	public void scrollElementIntoView(WebElement element, JavascriptExecutor js) throws InterruptedException{
		js = (JavascriptExecutor) this.driver;
		js.executeScript("arguments[0].scrollIntView;", element);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-190);");
	}
	
	public void scrollDown(JavascriptExecutor js) throws InterruptedException{
		js = (JavascriptExecutor) this.driver;
		js.executeScript("window.scrollBy(0,1000);");
		Thread.sleep(2000);
	}
}
