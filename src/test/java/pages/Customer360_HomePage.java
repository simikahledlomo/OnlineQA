package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sharedService.PublicFunctions;

public class Customer360_HomePage {
	WebDriver driver;

	@FindBy(xpath = "//button[@class = 'tablinks' and text()='Apply']")
	WebElement ApplyButton;

	@FindBy(xpath = "//button[@class = 'tablinks' and text()='Pay']")
	WebElement PlayButton;

	@FindBy(xpath = "//button[@class = 'tablinks' and text()='Find']")
	WebElement FindButton;

	@FindBy(xpath = "//button[@class = 'tablinks' and text()='Connect']")
	WebElement ConnectButton;

	@FindBy(xpath = "//button[@class = 'tablinks' and text()='Search']")
	WebElement SearchButton;

	@FindBy(xpath = "//button[@class = 'tablinks' and text()='Home']")
	WebElement HomeButton;

	@FindBy(xpath = "//iframe[@src= 'https://customer360.ekurhuleni.gov.za/Customer360/Consumption/IndexMobi']")
	WebElement IFrameOne;

	@FindBy(id = "accountNumberDdl")
	WebElement AccountNumberDdl;

	@FindBy(id = "meterTypeDdl")
	WebElement MeterTypeDdl;

	@FindBy(id = "startDate")
	WebElement StartDate;

	@FindBy(xpath = "//div[@class = 'xdsoft_label xdsoft_month']")
	WebElement Amonth;

	@FindBy(xpath ="//div[@class =xdsoft_label xdsoft_year']")
	WebElement Ayear;

	@FindBy(xpath = "//div[@class = 'xdsoft_mounthpicker']//  button [@class= 'xdsoft_prev']")
	WebElement SkipBackButton;

	@FindBy(xpath = "//div[@class= 'xdsoft_calendar'] //tr// td [@data-date = '1' and @data-month = '1']")
	WebElement Dates;

	@FindBy(id = "endDate")
	WebElement EndDate;

	@FindBy(id = "submitShowGraph")
	WebElement SubmitShowGraph;

	@FindBy(xpath = "//div [@class = 'sidebar-user-details']//a [@data-original-title]")
	WebElement LogOut;

	public Customer360_HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickApplyButton () {
		this.ApplyButton.click();
	}

	public void clickPlayButton () {
		this.PlayButton.click();
	}

	public void clickFindButton () {
		this.FindButton.click();
	}

	public void clickConnectButton () {
		this.ConnectButton.click();
	}

	public void clickSearchButton () {
		this.SearchButton.click();
	}

	public void clickHomeButton (){
		this.HomeButton.click();
	}

	public WebElement getAccountDropDown() {
		return AccountNumberDdl;
	}

	public void sitchIframe() {
		driver.switchTo().frame(this.IFrameOne);
	}

	public void selectAccountNumberDdl(String accountNo) {
		PublicFunctions pf = new PublicFunctions(driver);
		pf.selectByVisibleText(accountNo, this.AccountNumberDdl);
	}

	public void selectMeterTypeDdl(String MeterType) {
		PublicFunctions pf = new PublicFunctions(driver);
		pf.selectByVisibleText(MeterType, this.MeterTypeDdl);
	}

	public void getStartDate(String date) throws InterruptedException {
		this.StartDate.click();
		Thread.sleep(500);
		this.StartDate.sendKeys(date);
		this.StartDate.click();
	}

	public void getEndDate(String date) throws InterruptedException {
		this.EndDate.click();
		Thread.sleep(500);
		this.EndDate.sendKeys(date);
		this.EndDate.click();
	}

	public void clickSubmitShowGraph() {
		this.SubmitShowGraph.click();
	}

	public void clickLogOut() {
		this.LogOut.click();
	}
}
