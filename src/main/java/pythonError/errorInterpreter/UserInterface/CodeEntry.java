package pythonError.errorInterpreter.UserInterface;

/**
 * Created by Matthew Doyle on 28/05/2016.
 */

import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import javafx.scene.layout.VBox;

import org.fxmisc.flowless.VirtualizedScrollPane;

public class CodeEntry {

    private String input;

    public void initialise(VBox parent) {
        CodeArea richTextEntry = new CodeArea("Code Entry");
        richTextEntry.setWrapText(false);
        richTextEntry.setParagraphGraphicFactory(LineNumberFactory.get(richTextEntry));

        parent.getChildren().add(new VirtualizedScrollPane(richTextEntry));
    }

    public void setText(String strText) {
        input = strText;
    }

    public String getText() {
        return input;
    }
}
