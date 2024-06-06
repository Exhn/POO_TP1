import javax.swing.*;
import java.util.LinkedList;

public class GestorJugadores {
    LinkedList<Jugador> jugadores = new LinkedList<>();

    public GestorJugadores(LinkedList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public LinkedList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(LinkedList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void addplayer(Jugador jugador){
        boolean playerExists = false;
        for (Jugador existingPlayer : jugadores) {
            if (existingPlayer.getDCI_n().equals(jugador.getDCI_n())) {
                JOptionPane.showMessageDialog(null, "El jugador ya se encuentra registrado en el torneo.");
                playerExists = true;
                break;
            }
        }
        if (!playerExists) {
            this.jugadores.add(jugador);
            JOptionPane.showMessageDialog(null, "Jugador: "+ jugador.getName()+" agregado al torneo.");
        }
    }

    public void removeplayer(GestorJugadores jugadores,String DCI_n){
        boolean jugadorExiste = true;
        for (Jugador jugador : jugadores.getJugadores()){
            if (jugador.getDCI_n().equalsIgnoreCase(DCI_n)){
                JOptionPane.showMessageDialog(null, "Jugador "+ jugador.getName()+" eliminado del torneo.");
                jugadores.getJugadores().remove(jugador);
                jugadorExiste = false;
                break;
            }
        }
        if (jugadorExiste){
            JOptionPane.showMessageDialog(null, "El DCI ingresado es incorrecto o el jugador no esta registrado en el torneo.");
        }
    }

    public void searchplayer(GestorJugadores jugadores, String DCI_n){
        boolean jugadorExiste = true;
        for (Jugador jugador : jugadores.getJugadores()){
            if (jugador.getDCI_n().equalsIgnoreCase(DCI_n)){
                JOptionPane.showMessageDialog(null,jugador);
                jugadorExiste = false;
            }
        }
        if (jugadorExiste){
            JOptionPane.showMessageDialog(null, "El DCI ingresado es incorrecto o el jugador no esta registrado en el torneo.");
        }
    }

    public void cantplayers(GestorJugadores jugadores){
        JOptionPane.showMessageDialog(null, "Hay "+jugadores.getJugadores().size()+" jugadores en el torneo.");
    }

    public void displayplayers(GestorJugadores jugadores){
        JOptionPane.showMessageDialog(null, jugadores);
    }

    public boolean checkTorneo (GestorJugadores jugadores){
        if (!jugadores.getJugadores().isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    public void superMatch (Jugador jugador1, Jugador jugador2){
        // Batalla player1 VS player2
        int rondasP1 = 0;
        int rondasP2 = 0;
        int puntosGanar = 3;

        do {
            int cartaPlayer1 = (int) (Math.random() * jugador1.getMazo_torneo().mazo.size());
            int cartaPlayer2 = (int) (Math.random() * jugador2.getMazo_torneo().mazo.size());

            Carta jugadaPlayer1 = jugador1.getMazo_torneo().mazo.get(cartaPlayer1);
            Carta jugadaPlayer2 = jugador2.getMazo_torneo().mazo.get(cartaPlayer2);

            if (jugadaPlayer1.getStrength() > jugadaPlayer2.getResistance() &&
                    jugadaPlayer2.getStrength() < jugadaPlayer1.getResistance()){
                JOptionPane.showMessageDialog(null, jugador1.getName() + " le gana a " + jugador2.getName() + " con la carta: " +
                        jugadaPlayer1 + "\ncontra carta: " + jugadaPlayer2);
                rondasP1++;
            } else if (jugadaPlayer2.getStrength() > jugadaPlayer1.getResistance() &&
                    jugadaPlayer1.getStrength() < jugadaPlayer2.getResistance()) {
                JOptionPane.showMessageDialog(null, jugador2.getName() + " le gana a " + jugador1.getName() + " con la carta: " +
                        jugadaPlayer2 + "\ncontra carta: " + jugadaPlayer1);
                rondasP2++;
            }
        } while ((rondasP1 != puntosGanar) && (rondasP2 != puntosGanar));

        if (rondasP1 > rondasP2) {
            JOptionPane.showMessageDialog(null, "El ganador es el jugador: "+ jugador1.getName()+" , DCI_n: "+jugador1.getDCI_n()+
                    "\nCon "+rondasP1+" puntos VS "+rondasP2+" puntos.");
        } else {
            JOptionPane.showMessageDialog(null, "El ganador es el jugador: "+ jugador2.getName()+" , DCI_n: "+jugador2.getDCI_n()+
                    "\nCon "+rondasP2+" puntos VS "+rondasP1+" puntos.");
        }
    }

    @Override
    public String toString() {
        return "GestorJugadores{" +
                "jugadores=" + jugadores +
                '}';
    }
}
