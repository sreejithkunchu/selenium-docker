package com.searchmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id="search_form_input_homepage")
    private WebElement searchInput;

    @FindBy(id = "search_button_homepage")
    private WebElement searchButton;

    @FindBy(linkText = "Videos")
    private WebElement videoLink;

    @FindBy(className = "tile--vid")
    private List<WebElement> videoList;

    public SearchPage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver, this);
    }

    public void openUrl(){
        this.driver.get("https://duckduckgo.com/");
    }

    public void searchInput(String searchText){
        this.wait.until(ExpectedConditions.visibilityOf(this.searchInput));
        this.searchInput.sendKeys(searchText);
        this.searchButton.click();
    }

    public void gotoVideoLink(){
       this.wait.until(ExpectedConditions.visibilityOf(videoLink));
       this.videoLink.click();
    }

    public int countOfVideos(){
        By by = By.className("tile--vid");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by,0));
        System.out.println("size of the video =>" + this.videoList.size());
        return this.videoList.size();
    }





}
