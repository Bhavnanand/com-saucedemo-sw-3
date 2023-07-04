package testsuit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

//Create the package ‘testsuite’ and create the
//following class inside the ‘testsuite’ package.
//1. LoginTest
public class LogIn extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUrl() {
        openBrowser(baseUrl);
    }

    //3. Write down the following test into ‘LoginTest’
    //class
    //1. userSholdLoginSuccessfullyWithValid
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {

        //* Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@id='user-name']"),"problem_user");

        //* Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"),"sauceDemo");

        //* Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));

        //* Verify the text “PRODUCTS”
        String expected= "Products";
        String actual=getTextFromElement(By.xpath("//span[contains(text(),'Products')]"));
        Assert.assertEquals("Both text are equal",expected,actual);

    }

    //2. verifyThatSixProductsAreDisplayedOnPage
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //* Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");

        //* Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");

        //* Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));

        //* Verify the text “PRODUCTS”
        String expected = "Products";
        String actual = getTextFromElement(By.xpath("//span[contains(text(),'Products')]"));
        Assert.assertEquals("Both text are equal", expected, actual);
        //* Verify that six products are displayed on page

        List<WebElement> productList = driver.findElements(By.xpath("//div[@class = 'inventory_item']"));
        System.out.println("Total products are : " + productList.size());

    }/*List<WebElement> product = driver.findElements(By.xpath("//span[contains(text(),'Products')]"));

        for (WebElement total:product)
              {
                  System.out.println(total);
        }
        System.out.println("Product displayed on Page  : "+product.size());*/


        @After
        public void tersdown() {
            closeBrowser();
        }
    }
