package main.java.br.nassau.pokeeco;

import java.awt.*;

public interface EntidadeEcossistema {
    int getX();

    int getY();

    int getVida();

    void moveAleatoriamente();

    void reduzirVida(int quantidade);

    void aumentarVida(int quantidade);

    void draw(Graphics g);

    boolean intersects(EntidadeEcossistema outraEntidade);
}