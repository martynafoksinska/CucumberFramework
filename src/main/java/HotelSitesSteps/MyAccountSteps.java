package HotelSitesSteps;

import Pages.LoginPage;
import Pages.MyAccount;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyAccountSteps {

    WebDriver driver;

    @Given("Human is on {string} home page")
    public void enterHomePage(String url) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @And("User is logged out")
    public void loggingOut() {
        MyAccount onMyAccount = new MyAccount(driver);
        onMyAccount.logOut();
    }

    @And("User inputs an email address {string}, {string} and clicks Sign in button")
    public void userLogIn(String mail, String password) {
        LoginPage onLoginPage = new LoginPage(driver);
        onLoginPage.login(mail, password);
    }

    @And("User clicks on MyAddresses then on AddANewAddress button and fills up the form and clicks Save button")
    public void addingMyAddress() {
        MyAccount onMyAccount = new MyAccount(driver);
        onMyAccount.addFirstAddress();
    }

    @Then("User address has been added")
    public void closeBrowser() {
        driver.quit();
    }
}