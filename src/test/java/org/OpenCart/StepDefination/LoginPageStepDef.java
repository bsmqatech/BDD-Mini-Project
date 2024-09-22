package org.OpenCart.StepDefination;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.OpenCart.Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginPageStepDef {
private WebDriver driver;
private LoginPage loginpage;

    @Before
    public void setUP(){
        driver= new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }



    @Given("I am on the Open cart login page")
    public void i_am_on_the_open_cart_login_page() {
    driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
    loginpage = new LoginPage(driver);
    }
    @Given("I have entered a valid name and password")
    public void i_have_entered_a_valid_name_and_password() {
        loginpage.enterEmail("mishrabhabani@outlook.com");
        loginpage.enterPassword("Godisgreate@753003");

    }

    @Given("I have entered a Invalid {string} and {string}")
    public void i_have_entered_a_invalid_and(String UserName, String Password) {
       loginpage.enterEmail(UserName);
       loginpage.enterPassword(Password);
    }


    @When("I clicked on the login button")
    public void i_clicked_on_the_login_button() {
        loginpage.clickLoginBtn();
    }
    @Then("I should be logged in Successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertEquals(loginpage.checklogOutLink(), true);
    }


    @Then("I should see error message indicating {string}")
    public void i_should_see_error_message_indicating(String errorMessage) {
        Assert.assertEquals(driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), true);
    }


    @When("I click on the Forgotten Password link")
    public void i_click_on_the_forgotten_password_link() {
        loginpage.clickForgottenPasswordLink();
    }

    @Then("I should be redirect to password reset page")
    public void i_should_be_redirect_to_password_reset_page() {

        Assert.assertTrue(loginpage.getForgotPasswordPageURL().contains("account/forgotten"));

    }




}
