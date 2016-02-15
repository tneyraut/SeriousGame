package actions;

import org.w3c.dom.Element;

public class ViewAction extends Action
{
    private String view;
    
    @Override
    public void run()
    {
        game.show(view);
    }
    
    @Override
    public void createFromXML(Element xmlAction)
    {
        super.createFromXML(xmlAction);
        
        view = xmlAction.getAttribute("view");
    }

    @Override
    public boolean isChangingView()
    {
        return true;
    }
}
