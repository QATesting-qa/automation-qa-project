package automation.smoke;

import automation.BaseAppTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class LoginAppTest extends BaseAppTest {

    String usr = "MaryKay";
    String psswd = "admin123";
    String phoneName = "Samsung galaxy s6";

    @Override
    public void init() {
    }


    @Test()
    public void testLoginWithValidCredentials() throws InterruptedException {
        loginAppPage.open();
        loginAppPage.loginToApp(usr, psswd);
        Assert.assertEquals(homeAppPage.getWelcomeUserName(), "Welcome" + " " + usr);
    }

    @Test(priority = 1)
    public void verifySamsungPhoneIsDisplayed() throws InterruptedException {
        Assert.assertTrue(homeAppPage.isSamsungPhoneDisplayed());
    }

    @Test(priority = 2)
    public void verifySamsungPhoneIsReadyToBeAddedToCart() throws InterruptedException {
        homeAppPage.clickOnSamsung();
        Assert.assertTrue(addToCartPage.verifyProductDescription(phoneName));
    }

    @Test(priority = 3)
    public void addSamsungPhoneToCartandVerifyItIsDisplayed() throws InterruptedException {
        addToCartPage.clickOnAddToCartButton();
        addToCartPage.clickOnCartLink();
        Assert.assertTrue(cartPage.verifySamsungAppearsOnCartPage());
    }

    @Test(priority = 4)
    public void deleteProductFromCart() throws InterruptedException {
        cartPage.removeProductFromCart();
        Assert.assertTrue(cartPage.isSamsungStillPresent());
    }


    @AfterClass(alwaysRun = true)
    public void quit() {
        quitDriver();
    }


}
