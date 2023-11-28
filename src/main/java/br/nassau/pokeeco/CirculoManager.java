package main.java.br.nassau.pokeeco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class CirculoManager {
    private List<Point> circulos;
    private Image imagemCirculo;
    private double tamanhoImagem = 1.6;
    private Random random;
    private Timer circuloTimer;
    private int maxCirculos = 25;

    public CirculoManager(SimpEco simpEco) {
        circulos = new ArrayList<>();
        random = new Random();
        setupBlueDotTimer();
        imagemCirculo = new ImageIcon("src\\assets\\bluefruit.png").getImage();
    }

    private void setupBlueDotTimer() {
        circuloTimer = new Timer(3000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (circulos.size() < maxCirculos) {
                    adicionarCirculoAleatorio();
                }
            }
        });
        circuloTimer.start();
    }

    private void adicionarCirculoAleatorio() {
        int x = random.nextInt(800 - 20);
        int y = random.nextInt(600 - 20);
        circulos.add(new Point(x, y));
    }

    public List<Point> getCirculos() {
        return circulos;
    }

    public void drawCirculos(Graphics g) {
        for (Point circulo : circulos) {
            int largura = (int) (imagemCirculo.getWidth(null) * tamanhoImagem);
            int altura = (int) (imagemCirculo.getHeight(null) * tamanhoImagem);
            g.drawImage(imagemCirculo, circulo.x, circulo.y, largura, altura, null);
        }
    }

    // Correção para aceitar uma lista de qualquer tipo que estenda EntidadeEcossistema
    public void checkCollisions(List<? extends EntidadeEcossistema> entidades) {
        Iterator<Point> iterator = circulos.iterator();

        while (iterator.hasNext()) {
            Point circulo = iterator.next();
            Rectangle circuloBounds = new Rectangle(circulo.x, circulo.y, 40, 40);

            for (EntidadeEcossistema entidade : entidades) {
                Rectangle entidadeBounds = new Rectangle(entidade.getX(), entidade.getY(), 64, 72);

                if (entidadeBounds.intersects(circuloBounds)) {
                    iterator.remove();
                    entidade.aumentarVida(30);
                    break;
                }
            }
        }
    }
}
