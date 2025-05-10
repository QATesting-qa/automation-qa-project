package automation;

import driver.DriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import pages.*;
import java.io.ByteArrayInputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class BaseAppTest {
    private static final Logger LOG = LogManager.getLogger(BaseAppTest.class);


    protected LoginAppPage loginAppPage;
    protected HomeAppPage homeAppPage;
    protected AddToCartPage addToCartPage;
    protected CartPage cartPage;

    protected WebDriver driver = DriverManager.getDriver();

    public abstract void init();

    protected <T extends BaseAppPage> T createInstance(Class<T> page) {
        return BaseAppPageFactory.createInstance(driver, page);
    }

    @BeforeClass
    public void setup() {
        init();

        // instantiate POM pages
        loginAppPage = createInstance(LoginAppPage.class);
        homeAppPage = createInstance(HomeAppPage.class);
        addToCartPage = createInstance(AddToCartPage.class);
        cartPage = createInstance(CartPage.class);
    }

    @AfterMethod
    public void assessTestStatus(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            Allure.addAttachment("Step screenshot: ", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        } else if (result.getStatus() == ITestResult.SKIP) {
            Allure.addAttachment("Step screenshot: ", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        } else if (result.getStatus() == ITestResult.SUCCESS) {

        }
    }

    @AfterClass
    public void quitDriver(){
        driver.quit();
    }

    @AfterSuite
    public void tearDown() {

        driver.quit();
    }
}
