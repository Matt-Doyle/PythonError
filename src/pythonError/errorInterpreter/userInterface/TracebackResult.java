package pythonError.errorInterpreter.userInterface;

/**
 * Created by Matthew Doyle on 28/05/2016.
 */

import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.InlineCssTextArea;
import javafx.scene.layout.VBox;

public class TracebackResult {

    private String result;

    private VirtualizedScrollPane nodeObject;

    public TracebackResult() {
        InlineCssTextArea richTextEntry = new InlineCssTextArea();
        richTextEntry.setWrapText(true);
        richTextEntry.setEditable(false);

        nodeObject = new VirtualizedScrollPane(richTextEntry);
    }

    public VirtualizedScrollPane getNodeObject() {
        return nodeObject;
    }

    public void setText(String strText) {
        result = strText;
//        richTextEntry.setAccessibleText(strText);
    }

    public String getText() {
        return result;
    }
}
