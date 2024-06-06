public class Jugador {
    private String name;
    private String DCI_n;
    private Mazo mazo_torneo;

    public Jugador(String name, Mazo mazo_torneo) {
        String DCI = String.valueOf((int)(Math.random() * 100000 + 100000));
        this.name = name;
        this.DCI_n = DCI;
        this.mazo_torneo = mazo_torneo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDCI_n() {
        return DCI_n;
    }

    public void setDCI_n(String DCI_n) {
        this.DCI_n = DCI_n;
    }

    public Mazo getMazo_torneo() {
        return mazo_torneo;
    }

    public void setMazo_torneo(Mazo mazo_torneo) {
        this.mazo_torneo = mazo_torneo;
    }

    @Override
    public String toString() {
        return "\nJugador{" +
                "DCI_n='" + DCI_n + '\'' +
                ", name='" + name + '\'' +
                ", mazo_torneo=" + mazo_torneo +
                '}';
    }
}
