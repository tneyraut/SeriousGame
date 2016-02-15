package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import org.w3c.dom.Element;

public class TextView extends View
{
    public TextView(String id)
    {
        super(id);
    }
    
    @Override
    public void fill(Element viewXML)
    { 
    }
    
    @Override
    public void createStructure()
    {   
        this.setLayout(new BorderLayout());
        this.add(textLabel, BorderLayout.NORTH);
        
        centerPanel.setLayout(new FlowLayout());
        
            centerPanel.add(choicePanel);
        
        this.add(centerPanel, BorderLayout.CENTER);
        
        
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
