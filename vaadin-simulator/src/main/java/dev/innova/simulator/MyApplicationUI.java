package dev.innova.simulator;


import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Label;

import javax.servlet.annotation.WebServlet;

@Title("Android Simulator")
@Theme("valo")
public class MyApplicationUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout view = new VerticalLayout();
        view.addComponent(new Label("Hello Vaadin!"));
        setContent(view);
    }

    @WebServlet(urlPatterns = "/*")
    @VaadinServletConfiguration(ui = MyApplicationUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
