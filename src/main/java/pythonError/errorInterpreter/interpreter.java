package pythonError.errorInterpreter;

/**
 * Created by Matthew Doyle on 28/05/2016.
 */

import javafx.application.Application;
import javafx.stage.Stage;

import pythonError.errorInterpreter.UserInterface.UserInterfaceManager;

public class interpreter extends Application {

    private UserInterfaceManager uiManager;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        uiManager = new UserInterfaceManager();
        uiManager.initialise(primaryStage);
    }
}
