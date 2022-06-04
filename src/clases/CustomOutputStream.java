package clases;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;

/**
 *
 * @author erick
 */
public class CustomOutputStream extends OutputStream{
    JTextArea jta;
    public CustomOutputStream(JTextArea textArea){
        this.jta=textArea;
    }
    
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