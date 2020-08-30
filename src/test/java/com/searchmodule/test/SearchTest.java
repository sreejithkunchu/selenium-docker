package com.searchmodule.test;

import com.searchmodule.pages.SearchPage;
import com.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {


    @Test
    @Parameters({"keyword"})
    public void openUrl(String keyword) {
        SearchPage searchPage = new SearchPage(this.driver);
        searchPage.openUrl();
        searchPage.searchInput(keyword);
        searchPage.gotoVideoLink();
        int count = searchPage.countOfVideos();
        Assert.assertTrue(count > 0);
    }


}
