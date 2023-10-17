import java.awt.*;
import javax.swing.ImageIcon;
import java.util.Random;

public class Animal {
    private int x;
    private int y;
    private int vida;
    private int vidaMaxima;
    private Image imagem;
    private Random random = new Random();
    private int quantidade;

    public Animal(int x, int y, int vidaMaxima, String imagemPath) {
        this.x = x;
        this.y = y;
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima;
        imagem = new ImageIcon(imagemPath).getImage();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVida() {
        return vida;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void moveAleatoriamente() {
        int newX = x + random.nextInt(5) - 2;
        int newY = y + random.nextInt(5) - 2;

        if (newX < 0) {
            newX = 0;
        } else if (newX > 780) {
            newX = 780;
        }

        if (newY < 0) {
            newY = 0;
        } else if (newY > 580) {
            newY = 580;
        }

        x = newX;
        y = newY;
    }

    public void reduzirVida(int quantidade) {
        vida -= quantidade;
        if (vida < 0) {
            vida = 0;
        }
    }

    public void aumentarVida(int quantidade) {
        vida += quantidade;
        if (vida > vidaMaxima) {
            vida = vidaMaxima;
        }
    }

    public void draw(Graphics g) {
        g.drawImage(imagem, x, y, null);
        g.setColor(Color.BLACK);
        g.drawString("Vida: " + vida + "/" + vidaMaxima, x, y - 5);
    }

    public boolean intersects(Animal outroAnimal) {
        Rectangle bounds1 = new Rectangle(x, y, 64, 72);
        Rectangle bounds2 = new Rectangle(outroAnimal.getX(), outroAnimal.getY(), 64, 72);
        return bounds1.intersects(bounds2);
    }

    public void reduzirVidaAoColidirComPersonagem(int i) {
            vida -= quantidade;
        if (vida < 0) {
            vida = 0;
        }
    }
}