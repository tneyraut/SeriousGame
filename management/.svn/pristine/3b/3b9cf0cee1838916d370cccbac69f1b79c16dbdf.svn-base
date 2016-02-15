package actions;

import org.w3c.dom.Element;

public class GameOverAction extends Action
{
    private String text;
    
    @Override
    public void run()
    {
        game.showNotification("Game Over", text, true);
        game.gameOver();
    }
    
    @Override
    public void createFromXML(Element xmlAction)
    {
        super.createFromXML(xmlAction);
        
        text = xmlAction.getAttribute("text");
    }

    @Override
    public boolean isChangingView()
    {
        return true;
    }
}
