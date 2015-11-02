package dev.innova.simulator;


import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.*;
import com.vaadin.shared.ui.AlignmentInfo;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.Runo;
import dev.innova.simulator.storage.Property;
import dev.innova.simulator.storage.PropertyHolder;

import javax.servlet.annotation.WebServlet;

@Title("Android Simulator")
@Theme("runo")
public class MyApplicationUI extends UI {

    PropertyHolder propertyHolder;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        propertyHolder = new PropertyHolder();
        VerticalLayout view = new VerticalLayout();

        TabSheet tabsheet = new TabSheet();
        view.addComponent(tabsheet);

        tabsheet.addTab(getServerTab(), "Server Simulator");
        tabsheet.addTab(androidSimulatorTab(), "Android Simulator");
        tabsheet.addTab(getSettingsTab(), "Settings");

        GridLayout grid = new GridLayout(1, 1);
        grid.setWidth(600, Sizeable.UNITS_PIXELS);
        grid.setHeight(500, Sizeable.UNITS_PIXELS);
        grid.addComponent(view, 0, 0);
        grid.setSpacing(true);

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


    /**
     * return Server Tab
     *
     * @return
     */
    private VerticalLayout getServerTab() {
        VerticalLayout serverTab = new VerticalLayout();

        Panel panel = new Panel("Notification Send");
        panel.setStyleName(Runo.PANEL_LIGHT);
        //panel.setSizeUndefined();
        panel.setSizeFull();
        serverTab.addComponent(panel);
        FormLayout content = new FormLayout();
        final TextField textField = new TextField("Title");
        textField.setWidth("300px");
        content.addComponent(textField);
        final TextArea textArea = new TextArea("Notification");
        textArea.setWidth("300px");
        textArea.setHeight("200px");
        content.addComponent(textArea);
        HorizontalLayout buttonsList = new HorizontalLayout();
        Button restButton = new Button("Reset");
        Button sendButton = new Button("Send",
                new Button.ClickListener() {
                    public void buttonClick(Button.ClickEvent event) {

                        if (!textField.getValue().equals("") || !textArea.getValue().equals("")) {
                            Notification.show("Notification Send Success",
                                    "successfully send notification to phone",
                                    Notification.Type.HUMANIZED_MESSAGE);
                        } else {
                            Notification.show("Notification Send Failed",
                                    "Please Enter Title And Message",
                                    Notification.Type.ERROR_MESSAGE);
                        }


                    }
                });
        buttonsList.addComponent(sendButton);
        buttonsList.addComponent(restButton);
        content.addComponent(buttonsList);
        content.setSizeUndefined();
        content.setMargin(true);
        panel.setContent(content);
        return serverTab;
    }

    /**
     * Return Android Simulator Tab
     *
     * @return
     */
    private VerticalLayout androidSimulatorTab() {
        VerticalLayout androidSimulator = new VerticalLayout();
        androidSimulator.addComponent(new Label("Android Simulator"));
        return androidSimulator;
    }

    /**
     * Settings Tab
     *
     * @return
     */
    private VerticalLayout getSettingsTab() {
        VerticalLayout settingsTab = new VerticalLayout();
        Label settingsHeader = new Label("Android Google cloud Messaging Settings");
        settingsHeader.setStyleName(Runo.LABEL_SMALL);


        Panel panel = new Panel("Common Settings");
        panel.setStyleName(Runo.PANEL_LIGHT);
        //panel.setSizeUndefined();
        panel.setSizeFull();
        settingsTab.addComponent(panel);
        FormLayout content = new FormLayout();

        final PasswordField applicationId = new PasswordField("API Key");
        applicationId.setWidth("350px");

        final PasswordField applicationPassword = new PasswordField("Application Password");
        applicationPassword.setWidth("350px");

        final HorizontalLayout notificationList = new HorizontalLayout();
        Resource res = new ThemeResource("../runo/icons/16/ok.png");
        final Embedded image = new Embedded(null, res);
        image.setVisible(false);

        Resource failed = new ThemeResource("../runo/icons/16/cancel.png");
        final Embedded failedImage = new Embedded(null, failed);
        failedImage.setVisible(false);

        final Label settings = new Label("Settings Save Successfully");
        settings.setStyleName(Runo.LABEL_SMALL);
        notificationList.addComponent(image);
        notificationList.addComponent(failedImage);
        notificationList.addComponent(settings);
        notificationList.setVisible(false);


        HorizontalLayout buttonsList = new HorizontalLayout();
        Button saveButton = new Button("Save",
                new Button.ClickListener() {
                    public void buttonClick(Button.ClickEvent event) {
                        System.out.println(" Values : " + applicationId.getValue());
                        if (!applicationId.getValue().equals("") && !applicationPassword.getValue().equals("")) {
                            image.setVisible(true);
                            failedImage.setVisible(false);
                            settings.setValue("Settings Save Successfully");
                            notificationList.setVisible(true);
                            Property property = new Property();
                            property.setApiKey(applicationId.getValue());
                            property.setRegistrationId(applicationPassword.getValue());
                            propertyHolder.insertSettings(property);
                        } else {
                            image.setVisible(false);
                            failedImage.setVisible(true);
                            settings.setValue("Settings Save Failed");
                            notificationList.setVisible(true);
                        }
                    }
                });
        Button resetButton = new Button("Reset",
                new Button.ClickListener() {
                    public void buttonClick(Button.ClickEvent event) {
                        settings.setValue("Settings Reset Successfully");
                        applicationId.setValue("");
                        applicationPassword.setValue("");
                        notificationList.setVisible(true);
                    }
                });
        buttonsList.addComponent(saveButton);
        buttonsList.addComponent(resetButton);

        content.addComponent(applicationId);
        content.addComponent(applicationPassword);
        content.addComponent(buttonsList);
        content.addComponent(notificationList);
        content.setSizeUndefined();
        content.setMargin(true);
        panel.setContent(content);

        settingsTab.addComponent(settingsHeader);
        settingsTab.addComponent(panel);
        ;
        return settingsTab;
    }
}
