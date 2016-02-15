package managementdeshommes;

import wizardgame.XMLModel;
import wizardgame.Joueur;
import wizardgame.ChoiceButton;
import wizardgame.Game;
import actions.Action;
import actions.ActionFactory;
import views.ViewFactory;
import views.View;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class StoryModel implements XMLModel
{
    private Document document;
    private Element racine;
    private ViewFactory viewFactory;
    private ActionFactory actionFactory;
    private String firstView = null;
    
    public StoryModel(String path)
    {
        viewFactory = new ViewFactory();
        actionFactory = new ActionFactory();
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try
        {
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            InputStream is = getClass().getResourceAsStream(path); 
            document = builder.parse(is);
            racine = document.getDocumentElement();
            
            this.initPlayer();
        }
        catch(ParserConfigurationException | SAXException | IOException ex)
        {
            Logger.getLogger(StoryModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initPlayer()
    {
        Element joueur = (Element) racine.getElementsByTagName("joueur").item(0);

        NodeList stats = joueur.getElementsByTagName("stat");
        for(int i=0; i<stats.getLength(); i++)
        {
            String label = ((Element) stats.item(i)).getAttribute("label");
            int value = Integer.parseInt(((Element) stats.item(i)).getAttribute("value"));
            
            Joueur.getInstance().setStat(label, value);
        }
    }

    @Override
    public void fill(Game window, JProgressBar progress)
    {
        NodeList views = racine.getElementsByTagName("view");
        
        int nbViews = views.getLength();
        double pas = 100 / nbViews;
        for(int i=0; i<nbViews; i++)
        {
            Element viewXML = (Element) views.item(i);
            this.createView(viewXML, window);
            progress.setValue((int)(i * pas));
        }
        
        this.firstView = ((Element) views.item(0)).getAttribute("id");
                
        progress.setValue(100);
    }
    
    private void createView(Element viewXML, Game window)
    {
        String id = viewXML.getAttribute("id");
        String type = ((Element) viewXML.getElementsByTagName("type").item(0)).getTextContent();
        
        View view = viewFactory.createView(id, type);
        view.fill(viewXML);
        
        Node textNode = viewXML.getElementsByTagName("text").item(0);
        view.setText(nodeToString(textNode));
        
        NodeList buttonsList = viewXML.getElementsByTagName("button");
        view.setNumberOfButtons(buttonsList.getLength());
        for(int i=0; i<buttonsList.getLength(); i++)
        {
            Element xmlButton = (Element) buttonsList.item(i);
            view.addButton(this.createButton(xmlButton, window));
        }
        
        window.addView(view);
    }
    
    public String nodeToString(Node node) 
    {
        StringWriter sw = new StringWriter();
        try
        {
            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.transform(new DOMSource(node), new StreamResult(sw));
            
        }
        catch(TransformerConfigurationException ex)
        {
            Logger.getLogger(StoryModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(TransformerException ex)
        {
            Logger.getLogger(StoryModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sw.toString();
    }
    
    private ChoiceButton createButton(Element xmlButton, Game window)
    {
        String label = xmlButton.getAttribute("label");
        String target = xmlButton.getAttribute("target");

        ChoiceButton button;
        if(xmlButton.hasAttribute("image"))
        {
            try
            {
                BufferedImage img = ImageIO.read(getClass().getResource(xmlButton.getAttribute("image")));
                ImageIcon image = new ImageIcon(img.getScaledInstance(150, 150, Image.SCALE_SMOOTH));

                button = new ChoiceButton(image, label, target, window);
            }
            catch(IOException ex)
            {
                button = new ChoiceButton(label, target, window);
                Logger.getLogger(StoryModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else
        {
            button = new ChoiceButton(label, target, window);
        }
        
        NodeList actions = xmlButton.getElementsByTagName("action");
        for(int i=0; i<actions.getLength(); i++)
        {
            Element xmlAction = (Element) actions.item(i);
            Action action = actionFactory.createAction(xmlAction.getAttribute("type"));
            action.createFromXML(xmlAction);

            button.addAction(action);
        }
        button.addActionListener(button);
        
        return button;
    }

    @Override
    public String getFirstView()
    {
        return this.firstView;
    }
}
