package main.java.br.nassau.pokeeco;

import java.awt.*;

public class Circulo implements EntidadeEcossistema {
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

    @Override
    public int getX() {
        return ponto.x;
    }

    @Override
    public int getY() {
        return ponto.y;
    }

    @Override
    public int getVida() {
        // Se um círculo tem "vida", você pode retornar um valor apropriado aqui.
        return 0;
    }

    @Override
    public void moveAleatoriamente() {
        // A implementação específica para um círculo movendo-se aleatoriamente
    }

    @Override
    public void reduzirVida(int quantidade) {
        // A implementação específica para reduzir a "vida" de um círculo
    }

    @Override
    public void aumentarVida(int quantidade) {
        // A implementação específica para aumentar a "vida" de um círculo
    }

    @Override
    public void draw(Graphics g) {
        // A implementação específica para desenhar um círculo
    }

    @Override
    public boolean intersects(EntidadeEcossistema outraEntidade) {
        if (outraEntidade instanceof Circulo) {
            Circulo outroCirculo = (Circulo) outraEntidade;
            double distancia = ponto.distance(outroCirculo.getPonto());
            return distancia <= raio + outroCirculo.getRaio();
        }
        return false;
    }
}
