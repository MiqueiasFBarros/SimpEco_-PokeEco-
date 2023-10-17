import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class Personagem {
    private int x;
    private int y;
    private int velocityX = 0;
    private int velocityY = 0;
    private int speed = 5;
    private boolean visible = false;
    private ImageIcon imagemPersonagemCima;
    private ImageIcon imagemPersonagemBaixo;
    private ImageIcon imagemPersonagemEsquerda;
    private ImageIcon imagemPersonagemDireita;
    private ImageIcon imagemPersonagemParado;
    private SimpEco simpEco;

    public Personagem(int x, int y, SimpEco simpEco) {
        this.x = x;
        this.y = y;
        this.simpEco = simpEco;

        imagemPersonagemCima = new ImageIcon("src\\assets\\cima.png");
        imagemPersonagemBaixo = new ImageIcon("src\\assets\\baixo.png");
        imagemPersonagemEsquerda = new ImageIcon("src\\\\assets\\esquerda.png");
        imagemPersonagemDireita = new ImageIcon("src\\\\assets\\direita.png");
        imagemPersonagemParado = new ImageIcon("src\\\\assets\\parado.png");
    }

    public void draw(Graphics g) {
        int characterWidth = 64;
        int characterHeight = 72;

        if (visible) {
            if (x < 0) {
                x = 0;
            } else if (x > 800 - characterWidth) {
                x = 800 - characterWidth;
            }

            if (y < 0) {
                y = 0;
            } else if (y > 600 - characterHeight) {
                y = 600 - characterHeight;
            }

            if (velocityX == 0 && velocityY == 0) {
                g.drawImage(imagemPersonagemParado.getImage(), x, y, characterWidth, characterHeight, null);
            } else if (Math.abs(velocityX) > Math.abs(velocityY)) {
                if (velocityX > 0) {
                    g.drawImage(imagemPersonagemDireita.getImage(), x, y, characterWidth, characterHeight, null);
                } else {
                    g.drawImage(imagemPersonagemEsquerda.getImage(), x, y, characterWidth, characterHeight, null);
                }
            } else {
                if (velocityY > 0) {
                    g.drawImage(imagemPersonagemBaixo.getImage(), x, y, characterWidth, characterHeight, null);
                } else {
                    g.drawImage(imagemPersonagemCima.getImage(), x, y, characterWidth, characterHeight, null);
                }
            }
        }
    }

    public void checkBlueDotCollisions() {
        if (visible) {
            CirculoManager circuloManager = simpEco.getCirculoManager();
            Iterator<Point> it = circuloManager.getCirculos().iterator();

            while (it.hasNext()) {
                Point circulo = it.next();
                Rectangle personagemBounds = new Rectangle(x, y, 64, 72);
                Rectangle circuloBounds = new Rectangle(circulo.x, circulo.y, 20, 20);

                if (personagemBounds.intersects(circuloBounds)) {
                    it.remove();
                }
            }
        }
    }

    public void checkAnimalCollisions() {
        AnimalManager animalManager = simpEco.getAnimalManager();
        Iterator<Animal> it = animalManager.getAnimais().iterator();

        Rectangle personagemBounds = new Rectangle(x, y, 64, 72);

        while (it.hasNext()) {
            Animal animal = it.next();
            Rectangle animalBounds = new Rectangle(animal.getX(), animal.getY(), 64, 72);

            if (personagemBounds.intersects(animalBounds)) {
                animal.reduzirVidaAoColidirComPersonagem(2); 
                if (animal.getVida() <= 0) {
                    it.remove(); 
                }
            }
        }
    }
    

    public void move() {
        x += velocityX;
        y += velocityY;
    }

    public void toggleVisibility() {
        visible = !visible;
    }

    public int getSpeed() {
        return speed;
    }

    public void setVelocity(int dx, int dy) {
        velocityX = dx;
        velocityY = dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}