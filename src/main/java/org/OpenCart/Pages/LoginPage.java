package org.OpenCart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    //By locators
    private By emailInputLocator = By.name("email");
    private By passwordInputLocator = By.name("password");
    private By loginBtnLocator = By.xpath("//input [@type='submit']");
    private By forgotpasswordLocator = By.linkText("Forgotten Password");
    private By logOutLocator = By.linkText("Logout");


    public LoginPage(WebDriver driver){
        this.driver= driver;
    }


    //Page Methods / Actions

    public void enterEmail(String email){
        WebElement emailInput= driver.findElement(emailInputLocator);
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password){
        WebElement passwordInput= driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }

    public void clickLoginBtn(){
        WebElement LoginBtn= driver.findElement(loginBtnLocator);
        LoginBtn.click();
    }


    public boolean checkForgottenPasswordLink(){
       return driver.findElement(forgotpasswordLocator).isDisplayed();

    }
    public void clickForgottenPasswordLink(){
        WebElement ForgottenPasswordLink = driver.findElement(forgotpasswordLocator);
        ForgottenPasswordLink.click();
    }

    public boolean checklogOutLink(){
      return driver.findElement(logOutLocator).isDisplayed();

    }


    public void login(String email, String pwd){
        enterEmail(email);
        enterPassword(pwd);
        clickLoginBtn();
    }

    public String getForgotPasswordPageURL(){
        String forgotPasswordURL= driver.getCurrentUrl();
        return forgotPasswordURL;
    }


}
