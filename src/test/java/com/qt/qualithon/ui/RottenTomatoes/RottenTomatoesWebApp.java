package com.qt.qualithon.ui.RottenTomatoes;

import com.qt.qualithon.TestSession;
import com.qt.qualithon.ui.Page;
import com.qt.qualithon.ui.RottenTomatoes.*;

/**
 * entry class to hold IMDB Web Application UI Model/Page Objects
 **/
public class RottenTomatoesWebApp extends Page{

    public RottenTomatoesWebApp(TestSession testSession){
        super(testSession);
    }

    /**
     * launch IMDb landing page in browser test session
     *
     * @return    IMDb Web Home Page page object
     **/
    public RottenTomatoesHomePage launch(){
        this.testSession.driver().get("https://www.rottentomatoes.com/");
        return new RottenTomatoesHomePage(this.testSession);
    }
}
