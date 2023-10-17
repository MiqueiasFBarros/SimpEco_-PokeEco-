import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class AnimalManager {
    private List<Animal> animais;
    private Random random;
    private int vidaMinimaParaPegarPontoAzul = 110;
    private int tempoSemPontoAzulAnimal1 = 0;
    private int tempoSemPontoAzulAnimal2 = 0;
    private int tempoMaximoSemPontoAzul = 500;
    private SimpEco simpEco;

    public AnimalManager(SimpEco simpEco) {
        this.simpEco = simpEco;
        animais = new ArrayList<>();
        random = new Random();
        Animal animal1 = new Animal(50, 50, 100, "src\\assets\\dragonite.png");
        Animal animal2 = new Animal(700, 500, 100, "src\\assets\\salamence.png");
        animais.add(animal1);
        animais.add(animal2);
    }

    public void drawAnimais(Graphics g) {
        for (Animal animal : animais) {
            animal.draw(g);
        }
    }

    public void moveAnimais() {
        for (Animal animal : animais) {
            if (animal.getVida() > 0) { 
                animal.moveAleatoriamente();
            }
        }
    }
    
    public void checkAnimalCollisions() {
        for (int i = 0; i < animais.size(); i++) {
            Animal animal1 = animais.get(i);
            for (int j = i + 1; j < animais.size(); j++) {
                Animal animal2 = animais.get(j);
                if (animal1.intersects(animal2)) {
                    animal1.reduzirVida(5);
                    animal2.reduzirVida(5);
                }
            }
        }
    }
    
    public void checkBlueDotCollisions() {
        CirculoManager circuloManager = (CirculoManager) simpEco.getCirculoManager();
        Iterator<Point> it = circuloManager.getCirculos().iterator();
    
        while (it.hasNext()) {
            Point circulo = it.next();
            for (Animal animal : animais) {
                Rectangle animalBounds = new Rectangle(animal.getX(), animal.getY(), 64, 72);
                Rectangle circuloBounds = new Rectangle(circulo.x, circulo.y, 20, 20);
    
                if (animalBounds.intersects(circuloBounds) && animal.getVida() < vidaMinimaParaPegarPontoAzul) {
                    animal.aumentarVida(30);
                    it.remove();
                }
            }
        }
    }
    
    public void checkAnimalHealth() {
        if (!((CirculoManager) simpEco.getCirculoManager()).getCirculos().isEmpty()) {
            tempoSemPontoAzulAnimal1++;
            tempoSemPontoAzulAnimal2++;

            if (tempoSemPontoAzulAnimal1 > tempoMaximoSemPontoAzul && animais.get(0).getVida() < vidaMinimaParaPegarPontoAzul) {
                animais.get(0).reduzirVida(1);
                tempoSemPontoAzulAnimal1 = 0;
            }

            if (tempoSemPontoAzulAnimal2 > tempoMaximoSemPontoAzul && animais.get(1).getVida() < vidaMinimaParaPegarPontoAzul) {
                animais.get(1).reduzirVida(1);
                tempoSemPontoAzulAnimal2 = 0;
            }
        }

        animais.removeIf(animal -> animal.getVida() <= 0);
        while (animais.size() < 2) {
            reviverAnimais();
        }
    }
    
    public List<Animal> getAnimais() {
        return animais;
    }
    
    public void reviverAnimais() {
        if (animais.size() < 2) {
            int x = random.nextInt(800 - 20);
            int y = random.nextInt(600 - 20);

            String imagemPath = (Math.random() < 0.5) ? "src\\assets\\dragonite.png" : "src\\assets\\salamence.png";

            Animal animal = new Animal(x, y, 100, imagemPath);
            animais.add(animal);
        }
    }
}