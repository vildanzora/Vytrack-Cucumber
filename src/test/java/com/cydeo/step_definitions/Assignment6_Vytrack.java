package com.cydeo.step_definitions;

import com.cydeo.pages.Pages_Assignment6_Vytrack;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.collections.CollectionUtils;

public class Assignment6_Vytrack {


//        System.out.println("pages.gridSettings.getLocation() = " + pages.gridSettings.getLocation());
//        System.out.println("pages.exportGridBtn.getLocation() = " + pages.exportGridBtn.getLocation());
//        System.out.println("pages.refreshBtn.getLocation() = " + pages.refreshBtn.getLocation());
//        System.out.println("pages.resetBtn.getLocation() = " + pages.resetBtn.getLocation());
//        System.out.println("pages.gridSettings.getLocation() = " + pages.gridSettings.getLocation());

//         pages.exportGridBtn.getLocation() = (0, 0)   (x , y)
//         pages.refreshBtn.getLocation() = (1137, 169)
//         pages.resetBtn.getLocation() = (1171, 169)
//         pages.gridSettings.getLocation() = (1206, 169)

    Pages_Assignment6_Vytrack pages = new Pages_Assignment6_Vytrack();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 500);
    Actions actions = new Actions(Driver.getDriver());


    @Given("user enter valid {string} and valid {string}")
    public void user_enter_valid_and_valid(String username, String password) {
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack_url"));
        pages.logIn(username, password);

    }

    @When("User can click Vehicles button under the Fleet Module")
    public void user_can_click_vehicles_button_under_the_fleet_module() {
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        actions.moveToElement(pages.fleetBtn).perform();
        pages.vehiclesBtn.click();
    }

    @When("Export Grid dropdown is on the left of the page")
    public void export_grid_dropdown_is_on_the_left_of_the_page() {
        wait.until(ExpectedConditions.titleIs("Car - Entities - System - Car - Entities - System"));
        boolean isExportButtonLeftSideOnThePage = false;

        if (pages.exportGridBtn.getLocation().getX() < pages.gridSettings.getLocation().getX()) {
            isExportButtonLeftSideOnThePage = true;
            System.out.println("Export button on the left side of the page");
        }

        Assert.assertTrue("Export Grid location verification is failed",  isExportButtonLeftSideOnThePage);
    }

    @When("User should be able to click refresh button")
    public void user_should_be_able_to_click_refresh_button() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(pages.refreshBtn));
        pages.refreshBtn.click();
        Thread.sleep(2000);
    }

    @When("User should be able click reset button")
    public void user_should_be_able_click_reset_button() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(pages.resetBtn));
        pages.resetBtn.click();
        Thread.sleep(2000);

    }

    @When("User should be able to click Grid Settings button")
    public void user_should_be_able_to_click_grid_settings_button() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(pages.gridSettings));
        pages.gridSettings.click();
        Thread.sleep(2000);
    }

    @Then("Refresh button should be on the left side of Reset button")
    public void refresh_button_should_be_on_the_left_side_of_reset_button() {
        int refreshX = pages.refreshBtn.getLocation().getX();
        int resetX = pages.resetBtn.getLocation().getX();
        boolean refreshIsLeft = false;

        if (refreshX < resetX) {
            refreshIsLeft = true;
            System.out.println("Refrest button is on the left side of reset button");
        }

        Assert.assertTrue("\"Refresh button should be on the left side of reset button\" verification is failed", refreshIsLeft);
    }

    @Then("Grid Settings should be on the right side of the Reset button")
    public void grid_settings_should_be_on_the_right_side_of_the_reset_button() {

        int gridSeetingX = pages.gridSettings.getLocation().getX();
        int resetX = pages.resetBtn.getLocation().getX();
        boolean gridIsRight = false;

        if (gridSeetingX > resetX) {
            gridIsRight = true;
            System.out.println("Grid Setting button is on the right side of reset button");
        }
        Assert.assertTrue("\"Grid Setting button is on the right side of reset button\" verification is failed", gridIsRight);
    }

    @Then("Grid Setting button is on the right of the page")
    public void grid_setting_button_is_on_the_right_of_the_page() {

        boolean isGridSettingsButtonRightSideOnThePage = false;

        if (pages.gridSettings.getLocation().getX() > pages.exportGridBtn.getLocation().getX()) {
            isGridSettingsButtonRightSideOnThePage = true;
            System.out.println("Grid Setting button on the right side of the page");
        }

        Assert.assertTrue("Grid Setting Button location verification is failed",  isGridSettingsButtonRightSideOnThePage);

    }
}
