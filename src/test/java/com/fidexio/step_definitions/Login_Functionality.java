package com.fidexio.step_definitions;

import com.fidexio.pages.Login_page;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

public class Login_Functionality {
    Login_page loginPage = new Login_page();
    BrowserUtils browserUtils = new BrowserUtils();

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
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.titleIs("#Inbox - Odoo"));

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "#Inbox - Odoo";
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




    @Then("user see {string} warning message")
    public void userSeeWarningMessage(String arg0) {
        String fillMessage = loginPage.email.getAttribute("validationMessage");
        loginPage.loginBtn.click();
        browserUtils.isAttributePresent(loginPage.password, fillMessage);
    }


    @Then("the password should be masked with asteriks")
    public void thePasswordShouldBeMaskedWithAsteriks() {
        String passwordAttribute = loginPage.password.getAttribute("type");
        browserUtils.isAttributePresent(loginPage.password, passwordAttribute);
    }

    @And("user enters Enter key on the keyboard.")
    public void userEntersEnterKeyOnTheKeyboard() {
        loginPage.password.sendKeys(Keys.ENTER);
    }

    @When("user click {string} link")
    public void userClickLink(String arg0) {
        loginPage.resetPassword.click();

    }

    @Then("User land on reset  password page")
    public void userLandOnResetPasswordPage() {
        String resetPassPage=Driver.getDriver().getTitle();
        Assert.assertTrue(resetPassPage.contains("reset"));
    }

    @When("user do not enter email or password")
    public void userDoNotEnterEmailOrPassword() {
        loginPage.loginBtn.click();

        browserUtils.isAttributePresent(loginPage.email, "required");
        browserUtils.isAttributePresent(loginPage.password, "required");
    }
}


