package com.qt.qualithon.ui.RottenTomatoes;

import com.qt.qualithon.TestSession;
import com.qt.qualithon.ui.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * page object class represents elements and actions on the IMDb Movie Page
 **/
public class RottenTomatoesMoviePage extends Page{

    public RottenTomatoesMoviePage(TestSession testSession){
        super(testSession);

        // adjust page for tablet formfactor
        /*WebElement showMoreLink = this.testSession.driverWait().until(
            ExpectedConditions.presenceOfElementLocated(
              By.cssSelector("a[data-testid='title-pc-expand-more-button']")));
       
        if(showMoreLink.isDisplayed()){
            showMoreLink.click();
        }*/

    }

    /**
     * get movie title
     *
     * @return    movie title
     **/
    public String title(){
        return this.testSession.driverWait().until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("h1.scoreboard__title")
            ) 
        ).getText();
    }

    /**
     * get movie director name
     *
     * @return    movie director name
     **/
    public String director(){

        return this.testSession.driverWait().until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div a[data-qa=movie-info-director]")
            ) 
        ).getText();
            
        // traverse credits sections to find the section with Directors
    }

    /**
     * get list of movie genres
     *
     * @return    list of movie genres
     **/
    public List<String> genres(){
       
        WebElement credits = this.testSession.driverWait().until(
            ExpectedConditions.presenceOfElementLocated(
              By.cssSelector("div.meta-value.genre")));
              String[] strSplitk=credits.getText().split(",");
              List<String> genres = new ArrayList<String>( Arrays.asList(strSplitk));

        // traverse credits sections to find the section with Writers
              
        // if genres list is empty throw exception
        if(genres.isEmpty()){
            throw new NoSuchElementException("Could not lookup genres on Movie page");
        }
        return genres;
    }
    
    /**
     * get movie release year
     *
     * @return    movie release year
     **/
    public String releaseYear(){
        return this.testSession.driverWait().until(
            ExpectedConditions.presenceOfElementLocated(
                                By.cssSelector("div [data-qa='movie-info-item-value'] time")
            ) 
        ).getText().trim().split(",")[1];
    }

    public String maturityRating(){
        String maturityRating= this.testSession.driverWait().until(
            ExpectedConditions.presenceOfElementLocated(
                                By.cssSelector("score-board")
            ) 
        ).getShadowRoot().findElement(By.cssSelector("span#rating")).getText();
        return maturityRating.contains("(")?maturityRating.split("(")[0]:maturityRating;
    }

    public String movieRating(){
        return this.testSession.driverWait().until(
            ExpectedConditions.presenceOfElementLocated(
                                By.cssSelector("score-board.scoreboard")
            )
        ).getShadowRoot().findElement(By.cssSelector("score-icon-critic"))
        .getShadowRoot().findElement(By.cssSelector("span.percentage")).getText();
    }

    /**
     * get list of movie writers
     *
     * @return    list of movie writer names
     **/
    public List<String> writers(){
                WebElement credits = this.testSession.driverWait().until(
            ExpectedConditions.presenceOfElementLocated(
              By.cssSelector("div.panel-body li.meta-row:nth-of-type(4)>div.meta-value>a")));
              String[] strSplitk=credits.getText().split(",");
              List<String>writers = new ArrayList<String>( Arrays.asList(strSplitk));
        // if writers list is empty throw exception
        if(writers.isEmpty()){
            throw new NoSuchElementException("Could not lookup Writers on movie page");
        }
        return writers;
    }

}
