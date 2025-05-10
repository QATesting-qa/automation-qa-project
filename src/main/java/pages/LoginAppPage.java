package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static utils.UrlAppConstants.*;

public class LoginAppPage extends BaseAppPage {

    private static final String SUCCESS_LOGIN_MESSAGE = "**Successful Login**";

    @FindBy(id = "loginusername")
    private WebElement username;

    @FindBy(id = "loginpassword")
    private WebElement password;

    @FindBy(id = "login2")
    private WebElement loginButton;

    @FindBy(xpath = "//button[normalize-space()='Log in']")
    private WebElement submitButton;

    @FindBy(css = "[color='#008000']")
    private WebElement successMessage;

    public LoginAppPage open() throws InterruptedException {
        driver.get(BASE_URL);
        this.sleepForFiveSeconds();
        return this;
    }

    public HomeAppPage loginToApp(String username, String password) throws InterruptedException {
        this.loginButton.click();
        this.sleepForThreeSeconds();
        this.username.click();
        this.sleepForThreeSeconds();
        this.username.sendKeys(username);
        this.password.click();
        this.sleepForThreeSeconds();
        this.password.sendKeys(password);
        this.submitButton.click();
        this.sleepForThreeSeconds();
        return new HomeAppPage();
    }


}
