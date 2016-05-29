package pythonError.errorInterpreter.UserInterface;

/**
 * Created by Matthew Doyle on 28/05/2016.
 */

import org.fxmisc.richtext.InlineCssTextArea;
import javafx.scene.layout.VBox;

import org.fxmisc.flowless.VirtualizedScrollPane;

public class TracebackEntry {

    private String input;

    public void initialise(VBox parent) {
        InlineCssTextArea richTextEntry = new InlineCssTextArea("Stack Traceback Entry");
        richTextEntry.setWrapText(true);

        parent.getChildren().add(new VirtualizedScrollPane(richTextEntry));
    }

    public void setText(String strText) {
        input = strText;
    }

    public String getText() {
        return input;
    }
}
