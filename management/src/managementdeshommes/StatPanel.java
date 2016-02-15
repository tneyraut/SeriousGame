package managementdeshommes;

import java.awt.Font;
import wizardgame.Joueur;
import java.util.HashMap;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatPanel extends JPanel
{
    private HashMap<String, JLabel> labels;
    
    public StatPanel()
    {
        super();
        labels = new HashMap<>();
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.updateStats();
    }
    
    public void updateStats()
    {
        HashMap<String, Integer> stats = Joueur.getInstance().getStats();
        for(String stat : stats.keySet())
        {
            if(labels.get(stat) == null)
            {
                JLabel label = new JLabel(stat+" : "+stats.get(stat));
                label.setFont(new Font("Serif", Font.PLAIN, 16));
                this.add(label);
                labels.put(stat, label);
            }
            else
            {
                labels.get(stat).setText(stat+" : "+stats.get(stat));
            }
        }
    }
}
