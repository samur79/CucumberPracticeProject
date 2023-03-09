package com.fidexio.pages;

import com.fidexio.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Log_Out_Page {
    public Log_Out_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@class='oe_topbar_name']")
    public WebElement username;

    @FindBy (xpath = "(//*[.='Log out'])[2]")
    public  WebElement logOutBtn;


}
