package pythonError.errorInterpreter.UserInterface;

/**
 * Created by Matthew Doyle on 28/05/2016.
 */

import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import javafx.scene.layout.VBox;

import org.fxmisc.flowless.VirtualizedScrollPane;

public class CodeEntry {

    private String m_Text;
    private CodeArea RichTextEntry;
    private VBox parent;

    public boolean initialise(VBox parent) {
        this.parent = parent;

        RichTextEntry = new CodeArea("Code Entry");
        RichTextEntry.setWrapText(false);
        RichTextEntry.setParagraphGraphicFactory(LineNumberFactory.get(RichTextEntry));

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
