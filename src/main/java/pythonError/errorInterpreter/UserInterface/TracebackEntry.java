package pythonError.errorInterpreter.UserInterface;

/**
 * Created by Matthew Doyle on 28/05/2016.
 */

import org.fxmisc.richtext.InlineCssTextArea;
import javafx.scene.layout.VBox;

import org.fxmisc.flowless.VirtualizedScrollPane;

public class TracebackEntry {

    private String m_Text;
    private InlineCssTextArea RichTextEntry;
    private VBox parent;

    public boolean initialise(VBox parent) {
        this.parent = parent;

        RichTextEntry = new InlineCssTextArea("Stack Traceback Entry");
        RichTextEntry.setWrapText(true);

        parent.getChildren().add(new VirtualizedScrollPane(RichTextEntry));
        return true;
    }

    public boolean shutdown() {
        return true;
    }

    public void setText(String strText) {
        m_Text = strText;
    }

    public String getText() {
        return m_Text;
    }
}
