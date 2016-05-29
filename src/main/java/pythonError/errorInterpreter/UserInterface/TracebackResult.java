package pythonError.errorInterpreter.UserInterface;

/**
 * Created by Matthew Doyle on 28/05/2016.
 */

import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.InlineCssTextArea;
import javafx.scene.layout.VBox;

public class TracebackResult {

    private String result;

    public void initialise(VBox parent) {
        InlineCssTextArea richTextEntry = new InlineCssTextArea("Result");
        richTextEntry.setWrapText(true);
        richTextEntry.setEditable(false);
        parent.getChildren().add(new VirtualizedScrollPane(richTextEntry));
    }

    public void setText(String strText) {
        result = strText;
//        richTextEntry.setAccessibleText(strText);
    }

    public String getText() {
        return result;
    }
}
