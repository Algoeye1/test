package bindings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class test {
    public static WebDriver driver;
    @Given("^user is on \"([^\"]*)\" homepage and using \"([^\"]*)\" browser$")
    public void user_is_on_homepage(String website,String browser) throws Throwable {




        if (browser.equalsIgnoreCase("firefox"))
        { driver = new FirefoxDriver();

            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);}
        if (browser.equalsIgnoreCase("chrome"))
        { System.setProperty("webdriver.chrome.driver", "C:/Users/amy/Desktop/chromedriver.exe");

            driver = new ChromeDriver();

            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);}


        driver.get(website);
        driver.manage().timeouts().implicitlyWait(1500, TimeUnit.SECONDS);
    }

    @When("^user select a product and is on shopping basket$")
    public void add_a_Product()  {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Our recommendations for you'])[1]/following::img[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Including VAT'])[1]/following::button[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Quantity:'])[2]/following::button[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='£26.00'])[5]/following::button[1]")).click();
        driver.findElement(By.id("dcp-login-guest-user-email")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=dcp-login-guest-user-email | ]]
        driver.findElement(By.id("dcp-login-guest-user-email")).clear();
        driver.findElement(By.id("dcp-login-guest-user-email")).sendKeys("amresh01@gmail.com");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email address *'])[1]/following::button[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Your invoice address'])[1]/following::label[1]")).click();
        driver.findElement(By.id("co_payment_address-firstName")).click();
    }

    @When("^user enters First name as \"([^\"]*)\", Lastname as \"([^\"]*)\",Number as \"([^\"]*)\",street as \"([^\"]*)\",City as \"([^\"]*)\",Post code as \"([^\"]*)\",Email as \"([^\"]*)\"$")
    public void form_details(String first_name, String Last_name, String Number, String Street,String city, String post_code,String email) throws Throwable {
        driver.findElement(By.id("co_payment_address-firstName")).clear();
        driver.findElement(By.id("co_payment_address-firstName")).sendKeys(first_name);
        driver.findElement(By.id("co_payment_address-lastName")).clear();
        driver.findElement(By.id("co_payment_address-lastName")).sendKeys(Last_name);
        driver.findElement(By.id("co_payment_address-line1")).clear();
        driver.findElement(By.id("co_payment_address-line1")).sendKeys(Street);
        driver.findElement(By.id("co_payment_address-town")).clear();
        driver.findElement(By.id("co_payment_address-town")).sendKeys(city);
        driver.findElement(By.id("co_payment_address-postalCode")).clear();
        driver.findElement(By.id("co_payment_address-postalCode")).sendKeys(post_code);
        driver.findElement(By.id("co_payment_address-phone")).clear();
        driver.findElement(By.id("co_payment_address-phone")).sendKeys("+44678999911");
        driver.findElement(By.id("co_payment_address-line2")).click();
        driver.findElement(By.id("co_payment_address-line2")).clear();
        driver.findElement(By.id("co_payment_address-line2")).sendKeys(Street);
        driver.findElement(By.name("co_payment_address")).click();
        driver.findElement(By.id("co_payment_address-postalCode")).clear();
        driver.findElement(By.id("co_payment_address-postalCode")).sendKeys(post_code);
    }

    @Then("^user is taken to Verification and order placement screen$")
    public void Verification() throws Throwable {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Post code'])[1]/following::label[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Deliver offer to different address'])[1]/following::button[1]")).click();
        driver.quit();
    }
}