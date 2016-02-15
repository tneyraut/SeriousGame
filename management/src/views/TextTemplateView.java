package views;

import conditions.Condition;
import conditions.ConditionFactory;
import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Set;
import javax.swing.JLabel;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import wizardgame.Joueur;

public class TextTemplateView extends View
{
    private ConditionFactory conditionFactory;
    private HashMap<String, Condition[]> items;
    
    public TextTemplateView(String id)
    {
        super(id);
        items = new HashMap<>();
        conditionFactory = new ConditionFactory();
    }
    
    @Override
    public void createStructure()
    {   
        this.setLayout(new BorderLayout());
        textLabel.setAlignmentX(JLabel.CENTER);
        this.add(textLabel, BorderLayout.CENTER);
        this.add(choicePanel, BorderLayout.SOUTH);
    }
    
    @Override
    public String getValue()
    {
        return "";
    }

    @Override
    public void fill(Element viewXML)
    { 
        NodeList itemList = viewXML.getElementsByTagName("item");
        for(int i=0; i<itemList.getLength(); i++)
        {
            Element xmlItem = (Element) itemList.item(i);
            this.addItem(xmlItem);
        }
    }

    private void addItem(Element xmlItem)
    {
        NodeList conditionsList = xmlItem.getElementsByTagName("condition");
        Condition[] conditions = new Condition[conditionsList.getLength()];
        for(int i=0; i<conditionsList.getLength(); i++)
        {
            Element xmlCondition = (Element) conditionsList.item(i);
            conditions[i] = conditionFactory.createCondition(xmlCondition.getAttribute("type"));
            conditions[i].fill(xmlCondition);
        }
        String text = ((Element) xmlItem.getElementsByTagName("content").item(0)).getTextContent();
        items.put(text, conditions);
    }
    
    @Override
    public void onShow()
    {
        String template = textLabel.getText();
        Set<String> textSet = items.keySet();
        for(String text : textSet)
        {
            boolean afficher = true;
            for(Condition condition : items.get(text))
            {
                afficher &= condition.eval();
            }
            
            if(afficher)
            {
                template += text;
            }
        }
        
        textLabel.setText(fillTemplate(template));
    }
    
    public String fillTemplate(String template)
    {
        String text = template;
        HashMap stats = Joueur.getInstance().getStats();
        Set<String> keys = stats.keySet();
        
        for(String key : keys)
        {
            text = text.replace("*"+key+"*", ""+stats.get(key));
        }
        
        text = text.replace("*username*", Joueur.getInstance().getUsername());
        return text;
    }
}
