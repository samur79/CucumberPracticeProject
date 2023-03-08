package com.fidexio.step_definitions;

import com.fidexio.pages.Login_page;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Login_Functionality {
    Login_page loginPage=new Login_page();

    @Given("user is on login page")
    public void user_is_on_login_page() {
        Driver.getDriver().get("https://qa.fidexio.com/");

    }
    @When("user enters valid email {string}")
    public void user_enters_valid_email(String email) {
        loginPage.email.sendKeys(email);

    }
    @When("user enters valid password {string}")
    public void user_enters_valid_password(String password) {
    loginPage.password.sendKeys(password);
    }


    @Then("user is on home page")
    public void user_is_on_home_page() {
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),5);
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));

        String actualTitle= Driver.getDriver().getTitle();
        String expectedTitle= "#Inbox - Odoo";
        Assert.assertTrue(expectedTitle.equals(actualTitle));

    }

    @And("user clicks login button")
    public void userClicksLoginButton() {
        loginPage.loginBtn.click();
    }

    @When("user enters invalid email {string}")
    public void userEntersInvalidEmail(String email) {
        loginPage.email.sendKeys(email);
    }

    @And("user enters invalid password {string}")
    public void userEntersInvalidPassword(String password) {
        loginPage.password.sendKeys(password);
    }


    @Then("user see  warning message")
    public void userSeeWarningMessage() {
        Assert.assertTrue(loginPage.alertMessage.isDisplayed());
        Assert.assertEquals("Wrong login/password", loginPage.alertMessage.getText());
    }

    @When("user do not enter  email {string} or {string} or both of them.")
    public void userDoNotEnterEmailOrOrBothOfThem(String arg0, String arg1) {
    }
}

