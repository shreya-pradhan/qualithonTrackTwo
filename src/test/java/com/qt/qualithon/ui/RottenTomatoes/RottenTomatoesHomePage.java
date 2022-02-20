package com.qt.qualithon.ui.RottenTomatoes;

import com.qt.qualithon.TestSession;
import com.qt.qualithon.ui.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

/**
 * represents IMDb Web Home Page elements and ui actions (page object)
 **/
public class RottenTomatoesHomePage extends Page {

    public RottenTomatoesHomePage(TestSession testSession){
        super(testSession);
    }

    /**
     * perform a search for movie title and return the resultlist page
     *
     * @param     movieTitle    movie name
     * @return    IMDb Results Page page object
     **/
    public RottenTomatoesResultsPage  search(String movieTitle){
        WebElement searchInput = this.testSession.driverWait().until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input.search-text")
            )
        );
        searchInput.sendKeys(movieTitle);
        WebElement searchIcon = this.testSession.driverWait().until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(" a.search-submit")
            )
        );
        searchIcon.click();

        return new RottenTomatoesResultsPage(this.testSession);
    }
}
