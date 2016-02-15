package managementdeshommes;

import wizardgame.Joueur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class IntroWindow extends JFrame implements ActionListener
{
    private final JButton boutonJouer;
    private final JButton boutonAbout;
    private JLabel chargementLabel;
    private JProgressBar progress;
    private MainWindow mainWindow;
    private  TextWindow textWindow;
    
    public IntroWindow()
    {
        super("Management des Hommes");
        this.setSize(300, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(80, 30, 30, 30));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        
            boutonJouer = new JButton("Jouer");
            boutonJouer.setEnabled(false);
            boutonJouer.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            boutonJouer.addActionListener(this);
            mainPanel.add(boutonJouer);
            
                    
            boutonAbout = new JButton("Charisme et Assertivité");
            boutonAbout.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            boutonAbout.addActionListener(this);
            mainPanel.add(boutonAbout);
            
            chargementLabel = new JLabel("Chargement du Jeu...");
            chargementLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            mainPanel.add(chargementLabel);
            
            progress = new JProgressBar();
            progress.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            mainPanel.add(progress);
            
        this.setIconImage(getToolkit().getImage(getClass().getResource("/icones/icone.png")));
        
        this.setContentPane(mainPanel);
        this.setVisible(true);
        
        textWindow = new TextWindow();
        
        mainWindow = new MainWindow(this, progress);
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        if(event.getSource() == boutonJouer)
        {
            String s = (String)JOptionPane.showInputDialog(this, "Veuillez entrer votre nom", "Nouvelle partie", JOptionPane.PLAIN_MESSAGE, null, null, "Dupont");

            //If a string was returned, say so.
            if ((s != null) && (s.length() > 0)) {
                Joueur.getInstance().setUsername(s);
            }
            else
                return;
            
            this.setVisible(false);
            mainWindow.setVisible(true);
        }
        else if(event.getSource() == boutonAbout)
        {
            textWindow.setVisible(true);
        }
    }

    public void gameReady()
    {
        this.chargementLabel.setText("Chargement terminé.");
        this.boutonJouer.setEnabled(true);
    }

    public JButton getPlayButton()
    {
        return this.boutonJouer;
    }
}
