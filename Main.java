
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Slam
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Juego ctrl = new Juego();
        boolean seguir = true;
        // ciclo principal
        while (seguir) {
            boolean debug = false;
            System.out.println("Bienvenidos al Juego \"Piedra, papel, tijera, lagarto, Spock\"");
            System.out.println("Este juego consiste en 5 enfrentamientos antes de determinar el ganador");
            for (int i = 0; i < 5; i++) {
                System.out.println("Ingrese la jugada:");
                String jugada = scan.next().concat(scan.nextLine());
                ctrl.añadirJugadas(jugada);
            }
            System.out.println("Desea ver los análisis de cada jugada? (s/n)");
            String respuesta = scan.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                debug = true;
            }
            ctrl.analizarJugadas(debug);
            System.out.println("--- Resultado del juego ---");

            String gana = ctrl.obtenerGanador();
            if (gana.equals("Tie")) {
                System.out.println("Hubo empate");
            } else {
                System.out.println("El ganador del juego es: " + ctrl.obtenerGanador());
            }
            System.out.println("Desea otro enfrentamiento? (s/n)");
            respuesta = scan.nextLine();
            if (respuesta.equalsIgnoreCase("n")) {
                seguir = false;
            }
        }

    }

    static class Juego {

        List<String> jugadas = new ArrayList<>();
        Jugador[] jugadores = new Jugador[2];

        public Juego() {
            jugadores[0] = new Jugador("Player 1");
            jugadores[1] = new Jugador("Player 2");
        }

        public void añadirJugadas(String jugadas) {
            this.jugadas.add(jugadas);
        }

        public String obtenerGanador() {
            String ganador = (jugadores[0].juegosGanados() > jugadores[1].juegosGanados()) ? jugadores[0].getNombre() : jugadores[1].getNombre();
            if (jugadores[0].juegosGanados() == jugadores[1].juegosGanados()) {
                ganador = "Tie";
            }
            return ganador;
        }

        public void analizarJugadas(boolean debug) {
            for (String tupla : jugadas) {
                String[] valores = tupla.split(",");
                /*
                Las tijeras cortan el papel. *
                El papel cubre la piedra. *
                La piedra aplasta el lagarto. *
                El lagarto envenena a Spock. *
                Spock aplasta las tijeras. *
                Las tijeras decapitan el lagarto. *
                El lagarto se come el papel. *
                El papel refuta a Spock. *
                Spock vaporiza la piedra. *
                La piedra aplasta a las tijeras. *
                 */
                // casos en que gana P1
                if (valores[0].equalsIgnoreCase("Piedra") && valores[1].equalsIgnoreCase("Tijera")) {
                    System.out.println("La piedra aplasta a las tijeras.");
                    if (debug) {
                        System.out.println("Gana el jugador: " + jugadores[0].getNombre());
                    }
                    jugadores[0].ganador();
                } else if (valores[0].equalsIgnoreCase("Piedra") && valores[1].equalsIgnoreCase("Lagarto")) {
                    System.out.println("La piedra aplasta el lagarto.");
                    if (debug) {
                        System.out.println("Gana el jugador: " + jugadores[0].getNombre());
                    }
                    jugadores[0].ganador();
                } else if (valores[0].equalsIgnoreCase("Tijera") && valores[1].equalsIgnoreCase("Papel")) {
                    System.out.println("Las tijeras cortan el papel.");
                    if (debug) {
                        System.out.println("Gana el jugador: " + jugadores[0].getNombre());
                    }
                    jugadores[0].ganador();
                } else if (valores[0].equalsIgnoreCase("Tijera") && valores[1].equalsIgnoreCase("Lagarto")) {
                    System.out.println("Las tijeras decapitan el lagarto.");
                    if (debug) {
                        System.out.println("Gana el jugador: " + jugadores[0].getNombre());
                    }
                    jugadores[0].ganador();
                } else if (valores[0].equalsIgnoreCase("Papel") && valores[1].equalsIgnoreCase("Piedra")) {
                    System.out.println("El papel cubre la piedra.");
                    if (debug) {
                        System.out.println("Gana el jugador: " + jugadores[0].getNombre());
                    }
                    jugadores[0].ganador();
                } else if (valores[0].equalsIgnoreCase("Piedra") && valores[1].equalsIgnoreCase("Lagarto")) {
                    System.out.println("La piedra aplasta el lagarto.");
                    if (debug) {
                        System.out.println("Gana el jugador: " + jugadores[0].getNombre());
                    }
                    jugadores[0].ganador();
                } else if (valores[0].equalsIgnoreCase("Lagarto") && valores[1].equalsIgnoreCase("Spock")) {
                    System.out.println("El lagarto envenena a Spock.");
                    if (debug) {
                        System.out.println("Gana el jugador: " + jugadores[0].getNombre());
                    }
                    jugadores[0].ganador();
                } else if (valores[0].equalsIgnoreCase("Spock") && valores[1].equalsIgnoreCase("Tijeras")) {
                    System.out.println("Spock aplasta las tijeras.");
                    if (debug) {
                        System.out.println("Gana el jugador: " + jugadores[0].getNombre());
                    }
                    jugadores[0].ganador();
                } else if (valores[0].equalsIgnoreCase("Lagarto") && valores[1].equalsIgnoreCase("Papel")) {
                    System.out.println("El lagarto se come el papel.");
                    if (debug) {
                        System.out.println("Gana el jugador: " + jugadores[0].getNombre());
                    }
                    jugadores[0].ganador();
                } else if (valores[0].equalsIgnoreCase("Papel") && valores[1].equalsIgnoreCase("Spock")) {
                    System.out.println("El papel refuta a Spock.");
                    if (debug) {
                        System.out.println("Gana el jugador: " + jugadores[0].getNombre());
                    }
                    jugadores[0].ganador();
                } else if (valores[0].equalsIgnoreCase("Spock") && valores[1].equalsIgnoreCase("Piedra")) {
                    System.out.println("Spock vaporiza la piedra.");
                    if (debug) {
                        System.out.println("Gana el jugador: " + jugadores[0].getNombre());
                    }
                    jugadores[0].ganador();
                } else // casos en que gana P2
                if (valores[1].equalsIgnoreCase("Piedra") && valores[0].equalsIgnoreCase("Tijera")) {
                    System.out.println("La piedra aplasta a las tijeras.");
                    if (debug) {
                        System.out.println("Gana el jugador: " + jugadores[1].getNombre());
                    }
                    jugadores[1].ganador();
                } else if (valores[1].equalsIgnoreCase("Piedra") && valores[0].equalsIgnoreCase("Lagarto")) {
                    System.out.println("La piedra aplasta el lagarto.");
                    if (debug) {
                        System.out.println("Gana el jugador: " + jugadores[1].getNombre());
                    }
                    jugadores[1].ganador();
                } else if (valores[1].equalsIgnoreCase("Tijera") && valores[0].equalsIgnoreCase("Papel")) {
                    System.out.println("Las tijeras cortan el papel.");
                    if (debug) {
                        System.out.println("Gana el jugador: " + jugadores[1].getNombre());
                    }
                    jugadores[1].ganador();
                } else if (valores[1].equalsIgnoreCase("Tijera") && valores[0].equalsIgnoreCase("Lagarto")) {
                    System.out.println("Las tijeras decapitan el lagarto.");
                    if (debug) {
                        System.out.println("Gana el jugador: " + jugadores[1].getNombre());
                    }
                    jugadores[1].ganador();
                } else if (valores[1].equalsIgnoreCase("Papel") && valores[0].equalsIgnoreCase("Piedra")) {
                    System.out.println("El papel cubre la piedra.");
                    if (debug) {
                        System.out.println("Gana el jugador: " + jugadores[1].getNombre());
                    }
                    jugadores[1].ganador();
                } else if (valores[1].equalsIgnoreCase("Piedra") && valores[0].equalsIgnoreCase("Lagarto")) {
                    System.out.println("La piedra aplasta el lagarto.");
                    if (debug) {
                        System.out.println("Gana el jugador: " + jugadores[1].getNombre());
                    }
                    jugadores[1].ganador();
                } else if (valores[1].equalsIgnoreCase("Lagarto") && valores[0].equalsIgnoreCase("Spock")) {
                    System.out.println("El lagarto envenena a Spock.");
                    if (debug) {
                        System.out.println("Gana el jugador: " + jugadores[1].getNombre());
                    }
                    jugadores[1].ganador();
                } else if (valores[1].equalsIgnoreCase("Spock") && valores[0].equalsIgnoreCase("Tijeras")) {
                    System.out.println("Spock aplasta las tijeras.");
                    if (debug) {
                        System.out.println("Gana el jugador: " + jugadores[1].getNombre());
                    }
                    jugadores[1].ganador();
                } else if (valores[1].equalsIgnoreCase("Lagarto") && valores[0].equalsIgnoreCase("Papel")) {
                    System.out.println("El lagarto se come el papel.");
                    if (debug) {
                        System.out.println("Gana el jugador: " + jugadores[1].getNombre());
                    }
                    jugadores[1].ganador();
                } else if (valores[1].equalsIgnoreCase("Papel") && valores[0].equalsIgnoreCase("Spock")) {
                    System.out.println("El papel refuta a Spock.");
                    if (debug) {
                        System.out.println("Gana el jugador: " + jugadores[1].getNombre());
                    }
                    jugadores[1].ganador();
                } else if (valores[1].equalsIgnoreCase("Spock") && valores[0].equalsIgnoreCase("Piedra")) {
                    System.out.println("Spock vaporiza la piedra.");
                    if (debug) {
                        System.out.println("Gana el jugador: " + jugadores[1].getNombre());
                    }
                    jugadores[1].ganador();
                }

            }
        }
    }

    static class Jugador {

        private String nombre;
        //private String jugada;
        private int ganados;

        public Jugador(String nombre) {
            this.nombre = nombre;
            //this.jugada = "";
            this.ganados = 0;
        }

        public String getNombre() {
            return nombre;
        }

        /*public String getJugada() {
            return jugada;
        }

        public void añadirJugada(String jugada) {
            this.jugada = jugada;
        }*/
        public void ganador() {
            this.ganados++;
        }

        public int juegosGanados() {
            return this.ganados;
        }
    }
}
