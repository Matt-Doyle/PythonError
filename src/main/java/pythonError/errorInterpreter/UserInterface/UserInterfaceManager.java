package pythonError.errorInterpreter.UserInterface;

/**
 * Created by Matthew Doyle on 28/05/2016.
 */

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import javafx.scene.control.Button;

public class UserInterfaceManager {

    public void initialise(Stage primaryStage) {
        primaryStage.setTitle("Python Error Interpreter - By Matthew Doyle and Christopher Hall");

        CodeEntry codeEntry = new CodeEntry();
        TracebackEntry tracebackEntry = new TracebackEntry();
        TracebackResult tracebackResult = new TracebackResult();

        VBox root = new VBox(16);

        codeEntry.initialise(root);
        tracebackEntry.initialise(root);
        Button Analyse = new Button();
        Analyse.setText("Analyse Stack Traceback");
        root.getChildren().add(Analyse);
        tracebackResult.initialise(root);

        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }

    public boolean shutdown() {
        return true;
    }
}
