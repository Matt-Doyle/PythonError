package pythonError.errorInterpreter.UserInterface;

/**
 * Created by Matthew Doyle on 28/05/2016.
 */
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.InlineCssTextArea;
import javafx.scene.layout.VBox;

public class TracebackResult {

    private String m_Text;
    private InlineCssTextArea RichTextEntry;
    private VBox parent;

    public boolean initialise(VBox parent) {
        this.parent = parent;

        RichTextEntry = new InlineCssTextArea("Test");
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
