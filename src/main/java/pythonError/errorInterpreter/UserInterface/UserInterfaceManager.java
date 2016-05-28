package pythonError.errorInterpreter.UserInterface;

/**
 * Created by Matthew Doyle on 28/05/2016.
 */

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class UserInterfaceManager {
    private StackPane root;
    public boolean initialise(Stage primaryStage) {
        primaryStage.setTitle("Python Error Interpreter - By Matthew Doyle and Christopher Hall");

        root = new StackPane();

        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
        return true;
    }

    public boolean shutdown() {
        return true;
    }
}
