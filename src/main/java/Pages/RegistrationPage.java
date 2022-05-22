package Pages;


import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class RegistrationPage {
    private static WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

        public void createAccount() throws InterruptedException {
            Thread.sleep(2000);
            WebElement titleMr = driver.findElement(By.id("id_gender1"));
            WebElement titleMrs = driver.findElement(By.id("id_gender2"));
            WebElement first_name = driver.findElement(By.id("customer_firstname"));
            WebElement last_name = driver.findElement(By.id("customer_lastname"));
            WebElement password = driver.findElement(By.id("passwd"));

            Faker faker = new Faker();
            Random generator = new Random();

            boolean gender = generator.nextBoolean();
            if (gender ==true) {
                titleMrs.click();
            } else {
                titleMr.click();
            }


            first_name.sendKeys(faker.name().firstName());
            last_name.sendKeys(faker.name().lastName());
            password.sendKeys("haslo123");

        }
        public void createNewUser(String firstName, String lastName, String password) throws InterruptedException {
            Thread.sleep(2000);
            WebElement titleMr = driver.findElement(By.id("id_gender1"));
            WebElement titleMrs = driver.findElement(By.id("id_gender2"));
            WebElement first_name_input = driver.findElement(By.id("customer_firstname"));
            WebElement last_name_input = driver.findElement(By.id("customer_lastname"));
            WebElement password_input = driver.findElement(By.id("passwd"));


            Random generator = new Random();

            boolean gender = generator.nextBoolean();
            if (gender ==true) {
                titleMrs.click();
            } else {
                titleMr.click();
            }


            first_name_input.sendKeys(firstName);
            last_name_input.sendKeys(lastName);
            password_input.sendKeys(password);
        }

        public void registerButton() {
        WebElement submitAccount = driver.findElement(By.id("submitAccount"));
        submitAccount.click();
        }
    }