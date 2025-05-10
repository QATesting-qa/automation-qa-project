package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;


public class CartPage extends BaseAppPage {


    @FindBy(xpath = "//button[normalize-space()='Place Order']")
    private WebElement placeOrderButton;

    @FindBy(xpath = "//td[normalize-space()='Samsung galaxy s6']")
    private WebElement samsungProduct;

    @FindBy(xpath = "//td[normalize-space()='Samsung galaxy s6']")
    private List<WebElement> samsungProducts;

    @FindBy(xpath = "//a[normalize-space()='Delete']")
    private WebElement removeProduct;


    public boolean isSamsungStillPresent() throws InterruptedException {
        this.sleepForThreeSeconds();
        return this.samsungProducts.isEmpty();
    }


    public void removeProductFromCart() throws InterruptedException {
        this.sleepForThreeSeconds();
        this.removeProduct.click();
        this.sleepForThreeSeconds();
    }


    public boolean isPlaceOrderButtonDisplayed() {

        return placeOrderButton.isDisplayed();
    }


    public boolean verifySamsungAppearsOnCartPage() {

        return samsungProduct.isDisplayed();
    }


}
