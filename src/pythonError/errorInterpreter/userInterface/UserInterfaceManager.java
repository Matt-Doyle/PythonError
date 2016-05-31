package pythonError.errorInterpreter.userInterface;

/**
 * Created by Matthew Doyle on 28/05/2016.
 */

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pythonError.errorInterpreter.inputPhaser.InputParser;
import pythonError.errorInterpreter.inputPhaser.LinedError;
import pythonError.errorInterpreter.pythonInterpreter.Python;

public class UserInterfaceManager {

	public void initialise(Stage primaryStage) {
		primaryStage.setTitle("Python LinedError Interpreter - By Matthew Doyle and Christopher Hall");
		Python pSearch = new Python(true);
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
		analyseButton.setOnAction(event -> {
			if (tracebackEntry.getText().isEmpty()) {
				tracebackResult.setText("Please enter your error into the field above");
				return;
			}
			LinedError error = InputParser.parseError(tracebackEntry.getText(), pSearch);
			tracebackResult.setText("Oops!\n" +
					"You made an error at line " + error.getLine() + ".\n" +
					"The error was a " + error.getBmPattern().getPattern());
			if (error.getSimpleExplanation().isEmpty())
				tracebackResult.appendText("Explanation:\n" + error.getExplanation() + '\n');
			else
				tracebackResult.appendText("Explanation:\n" + error.getSimpleExplanation() + '\n');
			if (!error.getSolution().isEmpty())
				tracebackResult.appendText("Solution:\n" + error.getSolution() + '\n');
		});

		// Add all objects in correct order
		root.getChildren().addAll(codeLabel, codeEntry.getNodeObject(), tracebackEntryLabel, tracebackEntry.getNodeObject(), analyseButton, traebackResultLabel, tracebackResult.getNodeObject());

		primaryStage.setScene(new Scene(root, 500, 472));
		primaryStage.show();
	}
}
