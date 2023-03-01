package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {
    //create constructor
    // initialize the driver instance and this class' instance using PageFactory.initElements
    public GoogleSearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //We can start locating web elements using @FindBy annotation
    @FindBy(name = "q")
    public WebElement searchBox;

    @FindBy(xpath = "//div[.='Accept all']")
    public  WebElement acceptAll;

    @FindBy(name = "btnK")
    public WebElement searchGoogle;

    public void searchAnItem(String string){
        acceptAll.click();
        searchBox.sendKeys(string+ Keys.ENTER);

    }

   public WebElement capitalElement(String capital){
        return Driver.getDriver().findElement(By.linkText(capital));
   }

    public String getCapital(){
        return Driver.getDriver().findElement(By.xpath("//a[@class='FLP8od']")).getText();
    }
}
