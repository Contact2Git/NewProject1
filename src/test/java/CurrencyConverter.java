package stepefinitions;

import java.util.concurrent.TimeUnit;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class CurrencyConverter {
	WebDriver driver= null;

	@Given("user is on Currency conversion page") 
	public void user_is_on_currency_conversion_page()throws InterruptedException {



		System.out.println("Inside step-browser is open");

		String projectPath= System.getProperty("user.dir");
		System.out.println("project path is ::" +projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath + "/src/test/resources/Drivers/chromedriver.exe");

		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://partners.moneycorp.com/ComparisonsitesConverter/?rp=10168283&baseCCY=GBP&termsCCY=EUR&amount=1000.00");
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		Thread.sleep(5000);
	}

	/*
	 * @And("user move to menu Maintain currencies and selects maintain currencies rates option"
	 * ) public void
	 * user_move_to_menu_maintain_currencies_and_selects_maintain_currencies_rates_option
	 * () {
	 * 
	 * WebElement target= driver.findElement(By.xpath("//h2[text()='Hyderabad']"));
	 * WebElement target1=driver.findElement(By.xpath("//a[text()='Ameerpet']"));
	 * Actions s=new Actions(driver); s.moveToElement(target); s.click(target1);
	 * s.build().perform(); System.out.println("Header Menu success"); }
	 */

	@And("user selects country from currency I have dropdown")
	public void user_selects_country_from_currency_i_have_dropdown() throws InterruptedException {

		WebElement currency_from = driver.findElement(By.xpath("//select[@id='currency-from']"));
		Select select_option_currency_from=new Select(currency_from);
		select_option_currency_from.selectByIndex(2);
		Thread.sleep(3000);
		System.out.println("selected currency I have ");
	}

	@And("user select coungry from currency I want dropdown")
	public void user_select_coungry_from_currency_i_want_dropdown() throws InterruptedException {

		WebElement currency_to = driver.findElement(By.xpath("//select[@id='currency-to']"));
		Select select_option_currency_to=new Select(currency_to);
		select_option_currency_to.selectByIndex(5);
		Thread.sleep(3000);
		System.out.println("selected currency I have ");

	}

	@And("user input amount in Amount I have dropdown")
	public void user_input_amount_in_amount_i_have_dropdown() {

		WebElement Amount=driver.findElement(By.xpath("//input[@name='amount']"));
		Amount.clear();
		Amount.sendKeys("3000");
	}

	/*
	 * @When("user click on convert button") public void
	 * user_click_on_convert_button() {
	 * 
	 * driver.findElement(By.xpath("//input[@name='action_Convert']"));
	 * 
	 * }
	 */

	@Then("system displays currency in user want")
	public void system_displays_currency_in_user_want() {

		String Amountyouget= driver.findElement(By.xpath("//*[@id='you-get']/span")).getText();
		System.out.println(Amountyouget);
		/*
		 * if Amountyouget.equals("NYZ"){
		 * System.out.println("conversion success ......."); }
		 */

	}

}
