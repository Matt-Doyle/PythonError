package pythonError.errorInterpreter.userInterface;

/**
 * Created by Matthew Doyle on 28/05/2016.
 */

import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import javafx.scene.layout.VBox;

import org.fxmisc.flowless.VirtualizedScrollPane;

public class CodeEntry {

    private String input;

    private VirtualizedScrollPane nodeObject;

    public CodeEntry() {
        CodeArea richTextEntry = new CodeArea();
        richTextEntry.setWrapText(false);
        richTextEntry.setParagraphGraphicFactory(LineNumberFactory.get(richTextEntry));

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
