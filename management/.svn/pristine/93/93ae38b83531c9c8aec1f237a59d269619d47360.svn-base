package managementdeshommes;

import wizardgame.Game;
import views.View;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class MainWindow extends JFrame implements Game
{
    private StoryModel model;
    
    private JPanel views;
    private HashMap<String, View> viewsList;
    private String currentView;
    
    private CardLayout card;
    private StatPanel statPanel;
    private JLabel text;
    
    private IntroWindow parent;
    
    public MainWindow(IntroWindow parent, JProgressBar progress)
    {
        super("Management des Hommes");
        
        this.parent = parent;
        
        this.setSize(800, 550);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setIconImage(getToolkit().getImage(getClass().getResource("/icones/icone.png")));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.model = new StoryModel("/story/story.xml");
        this.viewsList = new HashMap<>();
        
        this.setLayout(new BorderLayout());
        
        views = new JPanel();
        card = new CardLayout();
        views.setLayout(card);
        this.getContentPane().add(views, BorderLayout.CENTER);

        statPanel = new StatPanel();
        this.getContentPane().add(statPanel, BorderLayout.WEST);
        statPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        model.fill(this, progress);
        
        parent.gameReady();
    }
    
    @Override
    public void addView(View view)
    {
        if(currentView == null)
            currentView = view.getId();
        
        views.add(view, view.getId());
        viewsList.put(view.getId(), view);
    }
    
    @Override
    public void show(String id)
    {
        currentView = id;
        viewsList.get(id).onShow();
        card.show(views, id);
        statPanel.updateStats();
    }

    @Override
    public void showNotification(String title, String notification, boolean modal)
    {
        if(modal)
        {
            JOptionPane.showMessageDialog(this, "<html><body><p style='width: 400px;'>"+notification+"</body></html>", title, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public String getCurrentValue()
    {
        return viewsList.get(currentView).getValue();
    }

    @Override
    public void gameOver()
    {
        this.setVisible(false);
        
        parent.setVisible(true);
        parent.getPlayButton().setText("Rejouer");
        
        this.model.initPlayer();
        statPanel.updateStats();
        card.show(views, model.getFirstView());
    }
}
