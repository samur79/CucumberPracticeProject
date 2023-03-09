package com.fidexio.step_definitions;

import com.fidexio.pages.Log_Out_Page;
import com.fidexio.pages.Login_page;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.implementation.auxiliary.MethodCallProxy;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Log_Out_Functionality {
    Login_page loginPage=new Login_page();
    Log_Out_Page logOutPage= new Log_Out_Page();

    @When("user clicks username at the right top corner.")
    public void user_clicks_username_at_the_right_top_corner() {
        logOutPage.username.isDisplayed();
    }
    @When("user see {string} button.")
    public void user_see_button(String string) {
        logOutPage.logOutBtn.isDisplayed();
    }
    @When("user clicks {string} button.")
    public void user_clicks_button(String string) {
        logOutPage.username.click();
        logOutPage.logOutBtn.click();
    }
    @Then("user goes back to login page.")
    public void user_goes_back_to_login_page() {
        String actualTitle=Driver.getDriver().getTitle();
        String expectedTitle= "Login | Best solution for startups";
        Assert.assertEquals(expectedTitle,actualTitle);
    }
    @Then("user press {string} key on the keyboard")
    public void user_press_key_on_the_keyboard(String string) {
        loginPage.loginBtn.sendKeys(Keys.BACK_SPACE);
    }
    @Then("user is still on login page")
    public void user_is_still_on_login_page() {
        String actualTitle=Driver.getDriver().getTitle();
        String expectedTitle= "Login | Best solution for startups";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @And("user logged in with a valid credential")
    public void userLoggedInWithAValidCredential() {
        loginPage.email.sendKeys("salesmanager64@info.com");
        loginPage.password.sendKeys("salesmanager");
        loginPage.loginBtn.click();
    }
}
