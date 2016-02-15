package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import wizardgame.Joueur;

public class ImageSelectionView extends View implements MouseListener
{
    private CardLayout card;
    private ArrayList<String> items;
    private int selectedItem;
    private JPanel panelPrecedent;
    private JPanel panelSuivant;
    
    public ImageSelectionView(String id)
    {
        super(id);
        items = new ArrayList<>();
        selectedItem = 0;
    }
    
    
    @Override
    public void fill(Element viewXML)
    {
        NodeList imagesList = viewXML.getElementsByTagName("item");
        for(int i=0; i<imagesList.getLength(); i++)
        {
            Element xmlImage = (Element) imagesList.item(i);
            this.addItem(xmlImage.getAttribute("path"), xmlImage.getTextContent(), xmlImage.getAttribute("value"));
        }
    }
    
    @Override
    public void createStructure()
    {
        this.setLayout(new BorderLayout());
        
        this.add(textLabel, BorderLayout.NORTH);
        
        JPanel selectPanel = new JPanel();
        selectPanel.setLayout(new BorderLayout());
        
            try
            {
                ImageIcon imagePrecedent = new ImageIcon(ImageIO.read(getClass().getResource("/icones/boutonPrecedent.png")));

                panelPrecedent = new JPanel();
                JLabel labelPrecedent = new JLabel(imagePrecedent);
                labelPrecedent.setCursor(new Cursor(Cursor.HAND_CURSOR));
                panelPrecedent.setLayout(new BorderLayout());
                panelPrecedent.add(labelPrecedent, BorderLayout.CENTER);
                panelPrecedent.addMouseListener(this);
                selectPanel.add(panelPrecedent, BorderLayout.WEST);

                ImageIcon imageSuivant = new ImageIcon(ImageIO.read(getClass().getResource("/icones/boutonSuivant.png")));

                panelSuivant = new JPanel();
                JLabel labelSuivant = new JLabel(imageSuivant);
                labelSuivant.setCursor(new Cursor(Cursor.HAND_CURSOR));
                panelSuivant.setLayout(new BorderLayout());
                panelSuivant.add(labelSuivant, BorderLayout.CENTER);
                panelSuivant.addMouseListener(this);
                selectPanel.add(panelSuivant, BorderLayout.EAST);
            }
            catch(IOException ex)
            {
                Logger.getLogger(ImageSelectionView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            card = new CardLayout();
            centerPanel.setLayout(card);
            centerPanel.setBorder(new EmptyBorder(20, 0, 0, 0));
            
            selectPanel.add(centerPanel, BorderLayout.CENTER);
        
        this.add(selectPanel, BorderLayout.CENTER);
        
        this.add(choicePanel, BorderLayout.SOUTH);
    }
    
    public void addItem(String imagePath, String label, String value)
    {
        try
        {
            
            BufferedImage img = ImageIO.read(getClass().getResource(imagePath));
            ImageIcon image = new ImageIcon(img.getScaledInstance(300, 300, Image.SCALE_SMOOTH));
            
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
            panel.setBorder(new EmptyBorder(10, 35, 0, 0));
                
                String html = label.replace("*username*", Joueur.getInstance().getUsername());
                
                JLabel labelLabel = new JLabel("<html><strong>"+html+"</strong></html>");
                labelLabel.setVerticalAlignment(JLabel.CENTER);
                labelLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
                labelLabel.setFont(new Font("Serif", Font.PLAIN, 16));
                panel.add(labelLabel);
                
                JLabel imageLabel = new JLabel(image);
                imageLabel.setVerticalAlignment(JLabel.CENTER);
                imageLabel.setHorizontalAlignment(JLabel.CENTER);
                panel.add(imageLabel);
            
            centerPanel.add(panel, imagePath);
            
            items.add(value);
        }
        catch(IOException ex)
        {
            Logger.getLogger(ImageSelectionView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getValue()
    {
        return items.get(selectedItem);
    }

    @Override
    public void mouseClicked(MouseEvent event)
    {
        if(event.getSource() == panelPrecedent)
        {
            card.previous(centerPanel);
            selectedItem--;
            
            if(selectedItem < 0)
                selectedItem = items.size() - 1;
        }
        else if(event.getSource() == panelSuivant)
        {
            card.next(centerPanel);
            selectedItem++;
            
            if(selectedItem >= items.size())
                selectedItem = 0;
        }
    }

    @Override
    public void mousePressed(MouseEvent me)
    {
    }

    @Override
    public void mouseReleased(MouseEvent me)
    {
    }

    @Override
    public void mouseEntered(MouseEvent me)
    {
    }

    @Override
    public void mouseExited(MouseEvent me)
    {
    }

    @Override
    public void onShow()
    {
    }
}
