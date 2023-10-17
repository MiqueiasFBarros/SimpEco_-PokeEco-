import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SimpEco extends JPanel implements ActionListener {
    private ImageIcon imagemFundo;
    private int windowWidth = 800;
    private int windowHeight = 600;

    Personagem personagem;
    private CirculoManager circuloManager;
    private AnimalManager animalManager;

    public SimpEco() {
        imagemFundo = new ImageIcon("src\\\\assets\\grass.jpg");
        setPreferredSize(new Dimension(windowWidth, windowHeight));

        personagem = new Personagem(100, 100, this);
        circuloManager = new CirculoManager(this);
        animalManager = new AnimalManager(this);

        addKeyListener(new GameKeyListener());

        setFocusable(true);
        requestFocus();

        Timer timer = new Timer(20, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagemFundo.getImage(), 0, 0, null);
        personagem.draw(g);
        circuloManager.drawCirculos(g);
        animalManager.drawAnimais(g);
    }

    public void actionPerformed(ActionEvent e) {
        personagem.move();
        circuloManager.checkCollisions(animalManager); 
        animalManager.moveAnimais();
        animalManager.checkAnimalCollisions();
        animalManager.checkBlueDotCollisions();
        animalManager.checkAnimalHealth();
        personagem.move();
        circuloManager.checkCollisions(animalManager); 
        animalManager.moveAnimais();
        animalManager.checkAnimalCollisions();
        personagem.checkBlueDotCollisions();
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

    private class GameKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            if (keyCode == KeyEvent.VK_F1) {
                personagem.toggleVisibility();
            } else if (keyCode == KeyEvent.VK_W) {
                personagem.setVelocity(0, -personagem.getSpeed());
            } else if (keyCode == KeyEvent.VK_S) {
                personagem.setVelocity(0, personagem.getSpeed());
            } else if (keyCode == KeyEvent.VK_A) {
                personagem.setVelocity(-personagem.getSpeed(), 0);
            } else if (keyCode == KeyEvent.VK_D) {
                personagem.setVelocity(personagem.getSpeed(), 0);
            } else if (keyCode == KeyEvent.VK_F2) {
                animalManager.reviverAnimais();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();

            if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_S) {
                personagem.setVelocity(0, 0);
            } else if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_D) {
                personagem.setVelocity(0, 0);
            }
        }
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