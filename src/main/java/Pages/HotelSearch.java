package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class HotelSearch {

    private WebDriver driver;

    public HotelSearch(WebDriver driver) {
        this.driver = driver;
    }

    public void HotelSearch() {
        Random random = new Random();
        int random3 = random.nextInt(3);

        List<WebElement> bookNowButtons = driver.findElements(By.className("ajax_add_to_cart_button"));
        WebElement choosenHotel = bookNowButtons.get(random3);

        choosenHotel.click();
        WebElement proceedToCheckOut = driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[3]/a/span"));
        proceedToCheckOut.click();
    }
}
