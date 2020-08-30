package com.searchmodule.testBy;

import com.searchmodule.pagesBy.SearchPageImpl;
import com.searchmodule.pagesBy.impl.SearchPageBy;
import com.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTestBy extends BaseTest {


    @Test
    @Parameters({"keyword"})
    public void Search(String keyword){
       SearchPageImpl searchPage = new SearchPageBy(this.driver);
       searchPage.openUrl();
       searchPage.searchKeyword(keyword);
       searchPage.goToVideoLink();
       int count = searchPage.countOfVidoes();
       Assert.assertTrue(count > 0);
    }

}
