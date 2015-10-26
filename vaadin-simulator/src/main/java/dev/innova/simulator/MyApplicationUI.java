package dev.innova.simulator;


import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.Sizeable;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.AlignmentInfo;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.Runo;

import javax.servlet.annotation.WebServlet;

@Title("Android Simulator")
@Theme("runo")
public class MyApplicationUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout view = new VerticalLayout();

        TabSheet tabsheet = new TabSheet();
        view.addComponent(tabsheet);


        VerticalLayout tab1 = new VerticalLayout();

        Panel panel = new Panel("Notification Send");
        panel.setStyleName(Runo.PANEL_LIGHT);
        //panel.setSizeUndefined();
        panel.setSizeFull();
        tab1.addComponent(panel);
        FormLayout content = new FormLayout();
        TextField textField = new TextField("Title");
        textField.setWidth("300px");
        content.addComponent(textField);
        TextArea textArea = new TextArea("Notification");
        textArea.setWidth("300px");
        content.addComponent(textArea);
        HorizontalLayout buttonsList = new HorizontalLayout();
        Button restButton = new Button("Reset");
        Button sendButton = new Button("Send");
        buttonsList.addComponent(sendButton);
        buttonsList.addComponent(restButton);
        content.addComponent(buttonsList);
        content.setSizeUndefined();
        content.setMargin(true);
        panel.setContent(content);
        tabsheet.addTab(tab1, "Server Simulator");

        VerticalLayout tab2 = new VerticalLayout();
        tab2.addComponent(new Label("Android Simulator"));
        tabsheet.addTab(tab2, "Android Simulator");

        GridLayout grid = new GridLayout(1, 1);
        grid.setWidth(600, Sizeable.UNITS_PIXELS);
        grid.setHeight(400, Sizeable.UNITS_PIXELS);
        grid.addComponent(view, 0, 0);
        grid.setSpacing(true);

        VerticalLayout settingsTab = new VerticalLayout();
        Label settingsHeader = new Label("Android Google cloud Messaging Settings");
        settingsHeader.setStyleName(Runo.LABEL_SMALL);
        settingsTab.addComponent(settingsHeader);
        tabsheet.addTab(settingsTab, "Settings");


        GridLayout rootGrid = new GridLayout(1, 1);
        rootGrid.setSizeFull();

        rootGrid.addComponent(grid);
        rootGrid.setComponentAlignment(grid, new Alignment(
                AlignmentInfo.Bits.ALIGNMENT_VERTICAL_CENTER
                        | AlignmentInfo.Bits.ALIGNMENT_HORIZONTAL_CENTER));

        setContent(rootGrid);
        setResponsive(true);
    }

    @WebServlet(urlPatterns = "/*")
    @VaadinServletConfiguration(ui = MyApplicationUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
