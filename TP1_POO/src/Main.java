import javax.swing.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        //Pool de cartas
        LinkedList<Carta> poolcartas = new LinkedList<>();
        //Cartas blancas (white="W")
        poolcartas.add(new Carta("Serra Angel", "W",4,4));
        poolcartas.add(new Carta ("Sun Titan","W",6,6));
        poolcartas.add(new Carta ("Elite Inquisitor","W",2,2));
        poolcartas.add(new Carta("Mother of Runes","W",1,1));
        poolcartas.add(new Carta("Baneslayer Angel","W",5,5));
        poolcartas.add(new Carta("Adorned Pouncer","W",1,1));
        //Cartas azules (blue="U")
        poolcartas.add(new Carta("Delver of Secrets","U",1,1));
        poolcartas.add(new Carta("Snapcaster Mage","U",2,1));
        poolcartas.add(new Carta("Mulldrifter","U",2,2));
        poolcartas.add(new Carta("Aetherling","U",4,5));
        poolcartas.add(new Carta("Trinket Mage","U",2,2));
        poolcartas.add(new Carta("Frost Titan","U",6,6));
        //Cartas negras (black="B")
        poolcartas.add(new Carta("Grave Titan","B",6,6));
        poolcartas.add(new Carta("Phyrexian Obliterator","B",5,5));
        poolcartas.add(new Carta("Blood Artist","B",0,1));
        poolcartas.add(new Carta("Vampire Nighthawk","B",2,3));
        poolcartas.add(new Carta("Fleshbag Marauder","B",3,1));
        poolcartas.add(new Carta("Gonti, Lord of Luxury","B",2,3));
        //Cartas rojas (red="R")
        poolcartas.add(new Carta("Goblin Guide","R",2,2));
        poolcartas.add(new Carta("Stormbreath Dragon","R",4,4));
        poolcartas.add(new Carta("Kiki-Jiki, Mirror Breaker","R",2,2));
        poolcartas.add(new Carta("Monastery Swiftspear","R",1,2));
        poolcartas.add(new Carta("Thundermaw Hellkite","R",5,5));
        poolcartas.add(new Carta("Glorybringer","R",4,4));
        //Cartas verdes (green="G")
        poolcartas.add(new Carta("Llanowar Elves","G",1,1));
        poolcartas.add(new Carta("Vorinclex, Monstrous Raider","G",6,6));
        poolcartas.add(new Carta("Primeval Titan","G",6,6));
        poolcartas.add(new Carta("Scavenging Ooze","G",2,2));
        poolcartas.add(new Carta("Eternal Witness","G",2,1));
        poolcartas.add(new Carta("Goreclaw, Terror of Qal Sisma","G",4,3));

        //Creo el torneo vacio
        LinkedList<Jugador> jugadores = new LinkedList<>();
        GestorJugadores torneo = new GestorJugadores(jugadores);

        //Creo unos jugadores
        Jugador player1 = new Jugador("Loolee", new Mazo("Muldrotha", "UGB", poolcartas));
        Jugador player2 = new Jugador("Chay",  new Mazo("Xenagos", "RG", poolcartas));

        //Agrego unos jugadores al torneo
        torneo.addplayer(player1);
        torneo.addplayer(player2);

        //Opciones del menu
        JOptionPane.showMessageDialog(null, "Bienvenido al torneo.");
        String[] opcionesDisponibles = {
                "Jugadores", "Torneo",  "Salir"
        };
        int opcion;
        do {
            opcion = JOptionPane.showOptionDialog(null,
                    "Elija una opcion",
                    null,
                    0,
                    0,
                    null,
                    opcionesDisponibles,
                    opcionesDisponibles[0]);
            switch (opcion) {
                //Opciones de jugador
                case 0:
                    String[] opcionesJugadores = {
                            "Agregar jugador", "Eliminar jugador", "Buscar jugador", "Cantidad de jugadores", "Mostrar jugadores", "Volver al menu anterior"
                    };
                    do {
                        opcion = JOptionPane.showOptionDialog(null,
                                "Elija una opcion",
                                null,
                                0,
                                0,
                                null,
                                opcionesJugadores,
                                opcionesJugadores[0]);
                        switch (opcion) {
                            case 0:
                                boolean colorCheck = false;
                                String jugadorMazoColor;
                                String jugador = JOptionPane.showInputDialog("Ingrese el nombre del jugador a agregar: ");
                                String jugadorMazo = JOptionPane.showInputDialog("Ingrese el nombre del mazo a jugar: ");
                                do {
                                    jugadorMazoColor = JOptionPane.showInputDialog("Ingrese el color del mazo a jugar: ");
                                    if (jugadorMazoColor.length() < 2) {
                                        JOptionPane.showMessageDialog(null, "El mazo debe tener por lo menos dos colores.");
                                    } else {
                                        colorCheck = true;
                                    }

                                } while (!colorCheck);

                                torneo.addplayer(new Jugador(jugador, (new Mazo(jugadorMazo, jugadorMazoColor.toUpperCase(), poolcartas))));
                                break;
                            case 1:
                                if (torneo.checkTorneo(torneo)) {
                                    String jugadorDCI = JOptionPane.showInputDialog("Ingrese el N° de DCI del jugador a eliminar: ");
                                    torneo.removeplayer(torneo, jugadorDCI);
                                } else {
                                    JOptionPane.showMessageDialog(null, "No se pueden remover jugadores de un torneo vacio.");
                                }
                                break;
                            case 2:
                                if (torneo.checkTorneo(torneo)) {
                                    String buscarDCI = JOptionPane.showInputDialog("Ingrese el N° de DCI del jugador que busca: ");
                                    torneo.searchplayer(torneo, buscarDCI);
                                } else {
                                    JOptionPane.showMessageDialog(null, "No se pueden buscar jugadores en un torneo vacio.");
                                }
                                break;
                            case 3:
                                torneo.cantplayers(torneo);
                                break;
                            case 4:
                                torneo.displayplayers(torneo);
                                break;
                        }
                    }while (opcion != 5);
                    break;
                case 1:
                    if (torneo.getJugadores().size()<2){
                        JOptionPane.showMessageDialog(null, "No se puede jugar el torneo.\n" +
                                "Jugadores insuficientes.");
                    }else {
                        LinkedList<Jugador> jugadoresActivos = new LinkedList<>();
                        for (int i = 0; i < 2; i++) {
                            int jugadorActivo = (int) (Math.random() * torneo.getJugadores().size());
                            Jugador jugadorSeleccionado = torneo.getJugadores().get(jugadorActivo);
                            if (jugadoresActivos.isEmpty()) {
                                jugadoresActivos.add(jugadorSeleccionado);
                            } else {
                                if (jugadoresActivos.contains(jugadorSeleccionado)) {
                                    i = i - 1;
                                } else {
                                    jugadoresActivos.add(jugadorSeleccionado);
                                }
                            }
                        }
                        torneo.superMatch(jugadoresActivos.getFirst(), jugadoresActivos.getLast());
                    }
                    break;
                }
            } while (opcion != 2);
        }
}