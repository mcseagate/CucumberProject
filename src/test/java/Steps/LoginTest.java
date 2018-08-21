package Steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    public WebDriver driver;

    /*
    I have used a hypothetical domain name (url) since i wasn't supplied with
    one. Also on the job, I would rather use the page object model so i dont have to write a web element for
    any given page more than ones. Additionally, I will be able to more easily manage my web elements
    in a fast changing development environment
     */


    @Given("^i navigate to the homepage$")
    public void iNavigateToTheHomepage() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "/Users/mcseagate/Documents/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://letskodeit.teachable.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String title = driver.getTitle();
        System.out.println(title);
    }


    @And("^i input username  and password$")
    public void iInputUsernameAndPassword() throws Throwable {
        //clicks on link to route user to the login page
        driver.findElement(By.id("eidlogin-form")).click();
        //inputs a value for email
        driver.findElement(By.id("inputEmail")).sendKeys("mcseagate@gmail.com");
        //inputs a value for password
        driver.findElement(By.id("inputPassword")).sendKeys("YouDontWantToKnow");
        //clicks remember ID checkbox
        driver.findElement(By.id("rememberId")).click();

    }

    @And("^click login button$")
    public void clickLoginButton() throws Throwable {
        //clicks on sign in button
        driver.findElement(By.id("submitButton")).click();
    }

    @Then("^i am logged in and close the browser$")
    public void iAmLoggedInAndCloseTheBrowser() throws Throwable {
        //user is on the homepage once signed in
        Thread.sleep(5000);
        driver.quit();
    }


}
