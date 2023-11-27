package main.java.br.nassau.pokeeco;
import java.awt.Point;

public class Circulo {
    private Point ponto;
    private int raio;

    public Circulo(Point ponto, int raio) {
        this.ponto = ponto;
        this.raio = raio;
    }

    public Point getPonto() {
        return ponto;
    }

    public int getRaio() {
        return raio;
    }

    public boolean colideCom(Point outroPonto) {
        double distancia = ponto.distance(outroPonto);
        return distancia <= raio;
    }
}