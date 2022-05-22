package HotelSitesSteps;

import Pages.LandingPage;
import Pages.LoginPage;
import Pages.MyAccount;
import Pages.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hotel3Steps {

    WebDriver driver;

    @Given("The user is on {string} home page")
    public void enterPage(String url) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @When("The user clicks on SignIn button")
    public void SignIn() {
        LandingPage onLandingPage = new LandingPage(driver);
        onLandingPage.clickOnSingIn();

    }

    @And("User inputs an email address {string} and clicks the CreateAnAccount button")
    public void formAndRegisterButton(String mail) throws InterruptedException {
        LoginPage onLoginPage = new LoginPage(driver);
        onLoginPage.authentication(mail);
    }

    @And("User completes the registration form {string}, {string}, {string} and clicks Register button")
    public void fillRegistrationForm(String firstName, String lastName, String password) throws InterruptedException {
        RegistrationPage onRegistrationPage = new RegistrationPage(driver);
        onRegistrationPage.createNewUser(firstName, lastName, password);
        onRegistrationPage.registerButton();
    }

    @Then("User account has been created and the user with {string} is logged into his account")
    public void checkAccount(String firstName) {
        MyAccount onMyAccount = new MyAccount(driver);
        onMyAccount.checkUsernameVisibility(firstName);
        driver.quit();
    }
}