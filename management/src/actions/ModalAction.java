package actions;

import org.w3c.dom.Element;

public class ModalAction extends Action
{
    private String title;
    private String text;
    
    @Override
    public void run()
    {
        game.showNotification(title, text, true);
    }
    
    @Override
    public void createFromXML(Element xmlAction)
    {
        super.createFromXML(xmlAction);
        
        title = xmlAction.getAttribute("title");
        text = xmlAction.getAttribute("text");
    }

    @Override
    public boolean isChangingView()
    {
        return false;
    }
}
