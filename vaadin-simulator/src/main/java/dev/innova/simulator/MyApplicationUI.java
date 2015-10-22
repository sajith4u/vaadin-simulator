package dev.innova.simulator;

/**
 * Created by sajithv on 10/22/15.
 */
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Label;

public class MyApplicationUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout view = new VerticalLayout();
        view.addComponent(new Label("Hello Vaadin!"));
        setContent(view);
    }
}
