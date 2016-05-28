package pythonError.errorInterpreter.UserInterface;

/**
 * Created by Matthew Doyle on 28/05/2016.
 */

import org.fxmisc.richtext.InlineCssTextArea;

public class TracebackEntry {

    private String m_Text;
    private InlineCssTextArea RichTextEntry;

    public InlineCssTextArea initialise() {
        RichTextEntry = new InlineCssTextArea("Test");
        RichTextEntry.setWrapText(true);
        return RichTextEntry;
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
