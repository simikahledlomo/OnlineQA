package steps;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Customer360_HomePage;
import pages.Customer360_LandingPage;
import sharedService.PublicFunctions;

public class Customer360Steps {
	
	WebDriver driver;
	JavascriptExecutor js;
	Customer360_LandingPage land;
	Customer360_HomePage home;
	PublicFunctions pf;
	
	@Given("Customer360  baseURL {string} browser {string}")
	public void customer360_base_url_browser(String baseURL, String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
	}

	@When("User enters valid username {string} and passwod {string} and click login button")
	public void user_enters_valid_username_and_passwod_and_click_login_button (String username, String password) throws InterruptedException {
		Customer360_LandingPage land = new Customer360_LandingPage(driver);
		land.logIn(username, password);
		Thread.sleep(500);
	}

	@Then("User clicks Apply")
	public void user_clicks_apply() throws InterruptedException {
		home = new Customer360_HomePage(driver);
		home.clickApplyButton();
		Thread.sleep(500);
	}

	@Then("User clicks pay")
	public void user_clicks_pay()  throws InterruptedException {
		home.clickPlayButton();
		Thread.sleep(500);
	}

	@Then("User clicks Find")
	public void user_clicks_find() throws InterruptedException{
		home.clickFindButton();
		Thread.sleep(500);
	}

	@Then("User clicks connect")
	public void user_clicks_connect() throws InterruptedException {
		home.clickConnectButton();
		Thread.sleep(500);
	}

	@Then("User clicks search")
	public void user_clicks_search() throws InterruptedException {
		home.clickSearchButton();
		Thread.sleep(500);
	}

	@Then("User clicks home")
	public void user_clicks_home() throws InterruptedException {
		home.clickHomeButton();
		Thread.sleep(500);
		pf = new PublicFunctions(driver);
		js = (JavascriptExecutor) driver;
		pf.scrollDown(js);
	}

	@Then("User select account on drop down list {string}")
	public void user_select_account_on_drop_down_list (String meterNo) throws InterruptedException {
		Thread.sleep(500);
		home.sitchIframe();
		home.selectAccountNumberDdl(meterNo);
	}

	@Then("User select meter number on drop down list {string}")
	public void user_select_meter_number_on_drop_down_list (String meterNo) throws InterruptedException {
		Thread.sleep(500);
		home = new Customer360_HomePage(driver);
		home.selectMeterTypeDdl(meterNo);
	}

	@Then("User select start date on the date picker {string}")
	public void user_select_end_date_on_the_date_picker(String startDate) throws InterruptedException {
		Thread.sleep(500);
		home = new Customer360_HomePage(driver);
		home.getStartDate(startDate);
	}

	@Then("User select end date on the date picker {string}")
	public void user_select_start_date_on_the_date_picker (String endDate) throws InterruptedException {
		Thread.sleep(500);
		home = new Customer360_HomePage(driver);
		home.getEndDate(endDate);
	}

	@Then("User clicks Show button")
	public void user_clicks_show_button() throws InterruptedException {
		Thread.sleep(500);
		home = new Customer360_HomePage(driver);
		home.clickSubmitShowGraph();
		Thread.sleep(500);
		PublicFunctions pf = new PublicFunctions(driver);
		js = (JavascriptExecutor) driver;
		pf.scrollDown(js);
	}

	@Then("User clicks log out")
	public void user_clicks_log_out() throws InterruptedException {
		Thread.sleep(500);
		driver.switchTo().defaultContent();
		Thread.sleep(500);
		home = new Customer360_HomePage(driver);
		home.clickLogOut();
	}

	@Then("Good Bye browser")
	public void good_bye_browser() throws InterruptedException {
		Thread.sleep(500);
		driver.quit();
	}
}
