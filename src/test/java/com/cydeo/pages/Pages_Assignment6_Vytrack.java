package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pages_Assignment6_Vytrack {

    public Pages_Assignment6_Vytrack() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="//*[@id=\"prependedInput\"]" )
    public WebElement input_username;

    @FindBy(xpath = "//*[@id=\"prependedInput2\"]" )
    public WebElement input_password;

    @FindBy(xpath ="//*[@id=\"_submit\"]" )
    public WebElement logInBtn;

    public void logIn(String username, String password) {
        input_username.sendKeys(username);
        input_password.sendKeys(password);
        logInBtn.click();
    }

    @FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[1]/a/span" )
    public WebElement fleetBtn;

    @FindBy(xpath ="//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[3]/a/span" )
    public WebElement vehiclesBtn;

    @FindBy(xpath = "(//a[@href='#'])[12]" )
    public WebElement exportGridBtn;

    @FindBy(xpath = "(//a[@title='Refresh'])[1]" )
    public WebElement refreshBtn;

    @FindBy(xpath = "(//a[@title='Reset'])[1]")
    public WebElement resetBtn;

    @FindBy(xpath = "(//a[@title='Grid Settings'])[1]")
    public WebElement gridSettings;





}
