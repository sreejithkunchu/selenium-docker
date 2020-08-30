package com.searchmodule.pagesBy;

import org.openqa.selenium.By;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.xpath;

public interface SearchPageImpl {

    By searchInput = xpath("//input[@id='search_form_input_homepage']");
    By searchButton = xpath("//input[@id='search_button_homepage']");
    By videoLink = xpath("//a[text()='Videos']");
    By vidoesList = className("tile--vid");


    void openUrl();

    void searchKeyword(String searchInput);

    void goToVideoLink();

    int countOfVidoes();




}

