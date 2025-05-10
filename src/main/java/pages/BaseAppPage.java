package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaseAppPage {
    protected WebDriver driver;

    @FindBy(xpath = "//a[@id='cartur']")
    private WebElement cartLink;


    public CartPage clickOnCartLink() throws InterruptedException {
        this.sleepForThreeSeconds();
        this.cartLink.click();
        this.sleepForFiveSeconds();
        return new CartPage();
    }


    public void init(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sleepForThreeSeconds() throws InterruptedException {
        Thread.sleep(3000);
    }

    public void sleepForFiveSeconds() throws InterruptedException {
        Thread.sleep(5000);
    }


}
