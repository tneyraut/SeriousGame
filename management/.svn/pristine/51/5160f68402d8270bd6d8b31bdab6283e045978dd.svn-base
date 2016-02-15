package wizardgame;

import actions.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class ChoiceButton extends JButton implements ActionListener
{
    private String target;
    private Game game;
    private ArrayList<Action> actions;
    
    public ChoiceButton(String text, String target, Game game)
    {
        super();
        
        this.setText(this.sizeText(text));
        
        this.target = target;
        this.game = game;
        this.actions = new ArrayList<>();
    }
    
    public ChoiceButton(ImageIcon image, String value, String target, Game game)
    {
        super(image);
        
        this.setText(this.sizeText(value));
        this.setVerticalTextPosition(SwingConstants.TOP);
        this.setHorizontalTextPosition(SwingConstants.CENTER);

        this.target = target;
        this.game = game;
        this.actions = new ArrayList<>();
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        boolean changeView = true;
        for(Action action : actions)
        {
            if(action.isConditionRespected())
            {
                action.run();
                changeView &= !action.isChangingView();
            }
        }
        
        if(changeView)
        {
            if(!"endgame".equals(target))
            {
                game.show(target);
            }
            else
            {
                game.gameOver();
            }
        }
    }
    
    public void addAction(Action action)
    {
        this.actions.add(action);
        action.setGameWizard(game);
    }
    
    private String sizeText(String text)
    {
        String result = "";
        int lineCount = 0;
        
        for(int i=0; i<text.length(); i++)
        {
            result += text.charAt(i);
            if(lineCount > 20 && text.charAt(i) == ' ')
            {
                result += "<br/>";
                lineCount = 0;
            }
            
            lineCount++;
        }
        
        return "<html>"+result+"</html>";
    }
}
