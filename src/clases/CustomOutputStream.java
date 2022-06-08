package clases;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;

/**
 * Reads text from console to JTextArea.
 * 
 * @author erick
 */
public class CustomOutputStream extends OutputStream{
    JTextArea jta;
    
    /**
     * Initialize instance to read text from console to JTextArea. Can't be null.
     * 
     * @param textArea Text area where console text is write.
     */
    public CustomOutputStream(JTextArea textArea){
        this.jta=textArea;
    }
    
    /**
     * Write all text displayed on the console to a text area
     * 
     * @throws IOException if JTextArea is null
     */
    @Override
    public void write(int b) throws IOException{
        // redirects data to the text area
        jta.append(String.valueOf((char)b));
        // scrolls the text area to the end of data
        jta.setCaretPosition(jta.getDocument().getLength());
        // keeps the textArea up to date
        jta.update(jta.getGraphics());
    }
}