package pythonError.errorInterpreter.UserInterface;

/**
 * Created by Matthew Doyle on 28/05/2016.
 */

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

import pythonError.errorInterpreter.UserInterface.TracebackEntry;

import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.InlineCssTextArea;

public class UserInterfaceManager {
    private StackPane root;
    private TracebackEntry traceback;
    public boolean initialise(Stage primaryStage) {
        primaryStage.setTitle("Python Error Interpreter - By Matthew Doyle and Christopher Hall");

        traceback = new TracebackEntry();
        InlineCssTextArea RichTextEntry = traceback.initialise();

        root = new StackPane(new VirtualizedScrollPane(RichTextEntry) );

        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
        return true;
    }

    public boolean shutdown() {
        return true;
    }
}
