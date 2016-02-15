package actions;

import org.w3c.dom.Element;
import wizardgame.Joueur;

public class StatAction extends Action
{
    private String name;
    private int effect;
    @Override
    public void run()
    {
        Joueur.getInstance().add(name, effect);
    }
    
    @Override
    public void createFromXML(Element xmlAction)
    {
        super.createFromXML(xmlAction);
        
        name = xmlAction.getAttribute("name");
        effect = Integer.parseInt(xmlAction.getAttribute("effect"));
    }

    @Override
    public boolean isChangingView()
    {
        return false;
    }
}
