import javax.swing.*;
import java.util.LinkedList;

public class Mazo {
    private String name;
    private String color;
    LinkedList<Carta> mazo = new LinkedList<>();

    public Mazo(String name, String color, LinkedList<Carta> pool) {
        int maxCards = 10;
        LinkedList<Carta> mazo = new LinkedList<>();
        for (int i = 0; i < maxCards; i++) {
            int carta = (int) (Math.random() * pool.size());
            Carta cartaseleccionada = pool.get(carta);
            boolean cartaUsada = false;
            if (color.contains(cartaseleccionada.getColor())){
                for (Carta usada : mazo){
                    if (usada.getName().equals(cartaseleccionada.getName())){
                        cartaUsada = true;
                    }
                }
                if (!cartaUsada){
                    mazo.add(cartaseleccionada);
                } else {
                    i = i-1;
                }
            } else {
                i = i-1;
            }
        }
        this.name = name;
        this.color = color;
        this.mazo = mazo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void addcards(Carta carta){
        if (this.mazo.size()>10){
            JOptionPane.showMessageDialog(null, "El mazo ya esta completo, por favor sacar una carta antes de agregar una nueva carta");
        } else {
            JOptionPane.showMessageDialog(null, "La carta "+carta.getName()+" fue agregada al mazo.");
            this.mazo.add(carta);
        }
    }

    public LinkedList<Carta> getMazo() {
        return mazo;
    }

    public void setMazo(LinkedList<Carta> mazo) {
        this.mazo = mazo;
    }

    public void removecards(Mazo mazo, String nombre){
        if (mazo.getMazo().isEmpty()){
            JOptionPane.showMessageDialog(null, "No se pueden remover cartas de un mazo vacio");
        } else {
            for (Carta carta : mazo.getMazo()){
                if (carta.getName().equalsIgnoreCase(nombre)){
                    JOptionPane.showMessageDialog(null, "La carta "+carta.getName()+" fue eliminada del mazo.");
                    mazo.getMazo().remove(carta);
                }
            }
        }
   }

   public void searchcards(Mazo mazo, String nombre){
        for (Carta carta: mazo.getMazo()){
            if (carta.getName().equalsIgnoreCase(nombre)){
                JOptionPane.showMessageDialog(null,carta);
            }
        }
   }

   public void cantcards(Mazo mazo){
        JOptionPane.showMessageDialog(null,"El mazo "+mazo.getName()+" tiene "+ mazo.getMazo().size()+" cartas.");
   }

    public void displaycards(Mazo mazo){
        JOptionPane.showMessageDialog(null, mazo.getMazo());
    }

    @Override
    public String toString() {
        return "Mazo{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
