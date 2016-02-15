package views;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.w3c.dom.Element;

public class ImageView extends View
{
    public ImageView(String id)
    {
        super(id);
    }
    
    @Override
    public void fill(Element viewXML)
    {
        String backgroundPath = ((Element) viewXML.getElementsByTagName("background").item(0)).getTextContent();
        this.setImage(backgroundPath);
    }
    
    public void setImage(String path)
    {
        try
        {
            BufferedImage img = ImageIO.read(getClass().getResource(path));
            ImageIcon image = new ImageIcon(img.getScaledInstance(400, 400, Image.SCALE_SMOOTH));
            
            JLabel imageLabel = new JLabel(image);
            this.centerPanel.setLayout(new BorderLayout());
            this.centerPanel.add(imageLabel, BorderLayout.CENTER);
        }
        catch(IOException ex)
        {
            Logger.getLogger(ImageView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getValue()
    {
        return "";
    }

    @Override
    public void onShow()
    {
    }
}
