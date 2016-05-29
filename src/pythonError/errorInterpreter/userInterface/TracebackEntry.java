package pythonError.errorInterpreter.userInterface;

/**
 * Created by Matthew Doyle on 28/05/2016.
 */

import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.InlineCssTextArea;

public class TracebackEntry {

    private String input;

    private VirtualizedScrollPane nodeObject;

    public TracebackEntry() {
        InlineCssTextArea richTextEntry = new InlineCssTextArea();
        richTextEntry.setWrapText(true);

        nodeObject = new VirtualizedScrollPane(richTextEntry);
    }

    public VirtualizedScrollPane getNodeObject() {
        return nodeObject;
    }

    public void setText(String strText) {
        input = strText;
    }

    public String getText() {
        return input;
    }
}
