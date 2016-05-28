package pythonError.errorInterpreter.UserInterface;

/**
 * Created by Matthew Doyle on 28/05/2016.
 */

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

import pythonError.errorInterpreter.UserInterface.TracebackEntry;

import org.fxmisc.flowless.VirtualizedScrollPane;
public class UserInterfaceManager {
    private VBox root;
    private TracebackEntry tracebackEntry;
    private TracebackResult tracebackResult;
    public boolean initialise(Stage primaryStage) {
        primaryStage.setTitle("Python Error Interpreter - By Matthew Doyle and Christopher Hall");

        tracebackEntry = new TracebackEntry();
        tracebackResult = new TracebackResult();

        root = new VBox(16); // 16px spacing


        tracebackEntry.initialise(root);
        tracebackResult.initialise(root);

        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
        return true;
    }

    public boolean shutdown() {
        return true;
    }
}
