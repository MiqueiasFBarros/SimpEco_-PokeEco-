package pokeeco.floresta;

import main.java.br.nassau.pokeeco.SimpEco;

public class SimpEcoMain {
    public static void main(String[] args) {
        SimpEco simpEco = new SimpEco();
        
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("PokeEco");
            frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            frame.add(simpEco);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}