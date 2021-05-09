package com.example.SpringBootPlayground;


import com.example.SpringBootPlayground.wicketGUI.FirstPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;


public class WicketApplication extends WebApplication {

    @Override
    public Class<FirstPage> getHomePage() {

        return FirstPage.class; // return default page
    }

    @Override
    protected void init() {
        super.init();
       // addComponentInstantiationListener(new SpringComponentInjector(this));

        //todo

    }

}
