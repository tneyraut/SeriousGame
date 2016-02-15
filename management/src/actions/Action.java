package actions;

import org.w3c.dom.Element;
import wizardgame.Game;

public abstract class Action
{
    protected String condition;
    
    protected Game game;
    
    public Action()
    {
        this.condition = null;
    }

    public abstract void run();
    
    public abstract boolean isChangingView();
    
    public void createFromXML(Element xmlAction)
    {
        if(xmlAction.hasAttribute("condition"))
            this.condition = xmlAction.getAttribute("condition");
    }
    
    public boolean isConditionRespected()
    {
        return condition == null || condition.equals(game.getCurrentValue());
    }
    
    public void setGameWizard(Game game)
    {
        this.game = game;
    }
}
