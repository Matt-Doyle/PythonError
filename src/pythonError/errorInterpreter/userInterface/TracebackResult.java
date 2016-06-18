package pythonError.errorInterpreter.userInterface;

/**
 * Created by Matthew Doyle on 28/05/2016.
 */

import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.InlineCssTextArea;
import javafx.scene.layout.VBox;

public class TracebackResult {

	private VirtualizedScrollPane nodeObject;
	private InlineCssTextArea richTextEntry;

	public TracebackResult() {
		richTextEntry = new InlineCssTextArea();
		richTextEntry.setWrapText(true);
		richTextEntry.setEditable(false);

		nodeObject = new VirtualizedScrollPane(richTextEntry);
		nodeObject.setPrefSize(700, 200);
	}

	public VirtualizedScrollPane getNodeObject() {
		return nodeObject;
	}

	public void setText(String strText) {
		richTextEntry.clear();
		richTextEntry.appendText(strText);
	}

	public void appendText(String strText) {
		richTextEntry.appendText(strText);
	}

	public String getText() {
		return richTextEntry.getText();
	}
}
