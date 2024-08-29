package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Customer360_LandingPage {
	WebDriver driver;

	@FindBy(id = "UserName")
	WebElement UserName;

	@FindBy(id = "Password")
	WebElement Password;

	@FindBy(xpath ="//button[@type = 'submit']")
	WebElement SigninButton;

	public Customer360_LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String username) {
		this.UserName.sendKeys(username);
	}

	public void enterPassword(String password) {
		this.Password.sendKeys(password);
	}

	public void clickBtnSignIn() {
		this.SigninButton.click();
	}

	public void logIn(String username, String password) {
		this.UserName.sendKeys(username);
		this.Password.sendKeys(password);
		this.SigninButton.click();
	}
}
