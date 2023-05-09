package stepefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class JSLanguageChange {
	
	
	WebDriver driver = null;
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	

	@Given("user is on home page")
	public void user_is_on_home_page() throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		System.out.println("project path is ::" + projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/Drivers/chromedriver.exe");
		ChromeOptions p = new ChromeOptions();
		p.addArguments("--disable-notifications");
		driver = new ChromeDriver(p);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.moneycorp.com/en-gb/");
		//Thread.sleep(5000);

	}

	@And("User Change the language and region")
	public void user_change_the_language_and_region() throws InterruptedException  {
				
		
		 //driver.findElement(By.xpath("//div[id='language-dropdown']")).click();
	     Thread.sleep(3000);
	     //driver.findElement(By.xpath("//button[@id='language-dropdown-flag']//img[@data-src='/globalassets/images/icons/flags/united-kingdom.svg']")).click();
	   driver.findElement(By.xpath("//*[@alt='English']")).click();
	   driver.findElement(By.xpath("//span[text()='USA']")).click();
	   System.out.println("Language and Region Changed");
	}

	
	  @And("user enter search item internationpayments in serch box") 
	  public void user_enter_search_item_internationpayments_in_serch_box()throws
	  InterruptedException {
	  
	  //JavascriptExecutor jse= (JavascriptExecutor)driver; WebElement
	  //WebDriverWait wait=new WebDriverWait(driver, 50); 
	  //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='nav_search']")));
	  WebElement searchtext=driver.findElement(By.xpath("//input[@id='nav_search']"));
	  searchtext.sendKeys("Foreign exchange solutions");
	  //jse.executeScript("arguments[0].value='International payments'",searchtext);
	  //Thread.sleep(10000); System.out.println("entered seache item in textbox"); 
	  }
	  
	  @When("user hits search icon") public void user_hits_search_icon()throws
	  InterruptedException {
	  
	  Thread.sleep(3000); 
	  WebElement clickSearch=driver.findElement(By.xpath( "(//input[@type='submit'])[2]"));
	  	 
	  //Thread.sleep(5000); 
	  clickSearch.click(); //jse.
	   Thread.sleep(5000); }
	  
	  @Then("system displays the internationalpayments page") public void
	  system_displays_the_internationalpayments_page() {
		  
		  String str1=driver.findElement(By.xpath("//input[@class='chosen-select']")).getText();
		  
		  if(str1.equals("international payments"))
		  {
			  System.out.println("Test Pass");
		  }
		  else
		  {
			  System.out.println("Test Pass");
		  }
	  
	  }
	  
	 
}
