import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpEco extends JPanel implements ActionListener {
    private ImageIcon imagemFundo;
    private int windowWidth = 800;
    private int windowHeight = 600;

    private CirculoManager circuloManager;
    private AnimalManager animalManager;

    public SimpEco() {
        imagemFundo = new ImageIcon("src\\\\assets\\grass.jpg");
        setPreferredSize(new Dimension(windowWidth, windowHeight));

        circuloManager = new CirculoManager(this);
        animalManager = new AnimalManager(this);

        setFocusable(true);
        requestFocus();

        Timer timer = new Timer(20, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagemFundo.getImage(), 0, 0, null);
        circuloManager.drawCirculos(g);
        animalManager.drawAnimais(g);
    }

    public void actionPerformed(ActionEvent e) {
        circuloManager.checkCollisions(animalManager); 
        animalManager.moveAnimais();
        animalManager.checkAnimalCollisions();
        animalManager.checkBlueDotCollisions();
        animalManager.checkAnimalHealth();
        circuloManager.checkCollisions(animalManager); 
        animalManager.moveAnimais();
        animalManager.checkAnimalCollisions();
        animalManager.checkAnimalHealth();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("SimpEco");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new SimpEco());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    public CirculoManager getCirculoManager() {
        return circuloManager;
    }

    public AnimalManager getAnimalManager() {
        return animalManager;
    }

    public void checkBlueDotCollisions() {
        circuloManager.checkCollisions(animalManager);
    }
}