package pythonError.errorInterpreter;/**
 * Created by Matthew Doyle on 28/05/2016.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import pythonError.errorInterpreter.UserInterface.UserInterfaceManager;

public class interpreter extends Application {
    private UserInterfaceManager ui_Manager;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ui_Manager = new UserInterfaceManager();
        ui_Manager.initialise(primaryStage);
    }
}
