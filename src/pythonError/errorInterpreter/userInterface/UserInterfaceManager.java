package pythonError.errorInterpreter.userInterface;

/**
 * Created by Matthew Doyle on 28/05/2016.
 */

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import javafx.scene.control.Button;

public class UserInterfaceManager {

    public void initialise(Stage primaryStage) {
        primaryStage.setTitle("Python Error Interpreter - By Matthew Doyle and Christopher Hall");

        // Create layout
        VBox root = new VBox(12);
        root.setPadding(new Insets(12));

        // Fields
        CodeEntry codeEntry = new CodeEntry();
        TracebackEntry tracebackEntry = new TracebackEntry();
        TracebackResult tracebackResult = new TracebackResult();

        // Labels
        Label codeLabel = new Label("Enter your python code here:");
        Label tracebackEntryLabel = new Label("Enter your traceback error here:");
        Label traebackResultLabel = new Label("Result:");

        // Buttons
        Button analyseButton = new Button();
        analyseButton.setText("Analyse Traceback");

        // Add all objects in correct order
        root.getChildren().addAll(codeLabel, codeEntry.getNodeObject(), tracebackEntryLabel, tracebackEntry.getNodeObject(), analyseButton, traebackResultLabel, tracebackResult.getNodeObject());

        primaryStage.setScene(new Scene(root, 500, 472));
        primaryStage.show();
    }
}
