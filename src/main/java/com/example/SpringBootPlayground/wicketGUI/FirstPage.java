package com.example.SpringBootPlayground.wicketGUI;

import org.apache.wicket.*;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class FirstPage extends WebPage {


    public FirstPage(final PageParameters parameters) {

        add(new Label("msg", "test"));

    }

}

