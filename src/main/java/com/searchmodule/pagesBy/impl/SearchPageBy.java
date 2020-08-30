package com.searchmodule.pagesBy.impl;

import com.searchmodule.pagesBy.SearchPageImpl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPageBy implements SearchPageImpl {

    private WebDriver driver;
    private WebDriverWait wait;


    public SearchPageBy(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    @Override
    public void openUrl() {
        this.driver.get("https://duckduckgo.com/");
    }

    @Override
    public void searchKeyword(String input) {
        this.wait.until(ExpectedConditions.visibilityOf(this.driver.findElement(searchInput)));
        this.driver.findElement(searchInput).sendKeys(input);
        this.driver.findElement(searchButton).click();

    }

    @Override
    public void goToVideoLink() {
        this.wait.until(ExpectedConditions.visibilityOf(this.driver.findElement(videoLink)));
        this.driver.findElement(videoLink).click();
    }

    @Override
    public int countOfVidoes() {
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(vidoesList,0));
        int videoCount = this.driver.findElements(vidoesList).size();
        System.out.println("Total Video Count => " + videoCount);
        return videoCount;

    }
}
