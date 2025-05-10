package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage  extends BaseAppPage{

    @FindBy(xpath = "//a[normalize-space()='Add to cart']")
    private WebElement addToCartButton;

    @FindBy(id = "tbodyid")
    private WebElement productDescription;


    public boolean verifyProductDescription(String prodName){

        return productDescription.getText().contains(prodName);
    }

    public void clickOnAddToCartButton() throws InterruptedException {
        try {
            this.sleepForThreeSeconds();
            this.addToCartButton.click();
            this.sleepForThreeSeconds();
            Alert alt = driver.switchTo().alert();
            alt.accept();
            this.sleepForThreeSeconds();
        }
        catch(NoAlertPresentException noe) {
            // No alert found on page, proceed with test.
        }

    }


}
