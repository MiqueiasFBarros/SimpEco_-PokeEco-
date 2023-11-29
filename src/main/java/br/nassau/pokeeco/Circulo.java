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
      
        return 0;
    }

    @Override
    public void moveAleatoriamente() {
        
    }

    @Override
    public void reduzirVida(int quantidade) {

    }

    @Override
    public void aumentarVida(int quantidade) {
       
    }

    @Override
    public void draw(Graphics g) {
       
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
