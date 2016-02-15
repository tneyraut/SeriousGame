package managementdeshommes;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class TextWindow  extends JFrame 
{
    public TextWindow()
    {
        super("Management des Hommes");
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        
        this.getContentPane().setLayout(new BorderLayout());
        
        StringBuilder out = new StringBuilder();
        
        try
        {
            InputStream is = getClass().getResourceAsStream("/story/about.html");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
        
            while ((line = reader.readLine()) != null)
            {
                out.append(line);
            }
        }
        catch(IOException ex)
        {
            Logger.getLogger(TextWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JTextPane textArea = new JTextPane();
        textArea.setContentType("text/html");
        textArea.setBorder(new EmptyBorder(10,10,10,10));
        textArea.setText(out.toString());
        JScrollPane scroll = new JScrollPane(textArea);
            
        this.setIconImage(getToolkit().getImage(getClass().getResource("/icones/icone.png")));
        
        this.getContentPane().add(scroll);
    }
}
