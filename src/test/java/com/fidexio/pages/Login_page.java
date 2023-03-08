package com.fidexio.pages;

import com.fidexio.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {
    public  Login_page(){
        PageFactory.initElements(Driver.getDriver(),this);


    }
    @FindBy(name = "login")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement loginBtn;

    @FindBy(xpath = "//p[@class='alert alert-danger']")
    public WebElement alertMessage;




}
