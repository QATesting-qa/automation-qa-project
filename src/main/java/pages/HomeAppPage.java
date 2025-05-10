package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeAppPage extends BaseAppPage {


    @FindBy(id = "nameofuser")
    private WebElement welcomeUserText;

    @FindBy(xpath = "//a[normalize-space()='Samsung galaxy s6']")
    private WebElement samsungGalaxyPhone;


    public String getWelcomeUserName(){
        return welcomeUserText.getText();
    }


    public boolean isSamsungPhoneDisplayed() throws InterruptedException {
        this.sleepForThreeSeconds();
        return this.samsungGalaxyPhone.isDisplayed();
    }

    public AddToCartPage clickOnSamsung() throws InterruptedException {
        this.sleepForThreeSeconds();
        this.samsungGalaxyPhone.click();
        this.sleepForFiveSeconds();
        return new AddToCartPage();
    }

}





