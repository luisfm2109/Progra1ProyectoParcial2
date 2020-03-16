
package progra1proyecto2;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Progra1Proyecto2 {
static Scanner leer = new Scanner(System.in);
    
    //Instanciando la clase GhostGame
    static GhostGame juego=new GhostGame();
    //static String nombre="", contrasenia="";
    
    public static void MenuPrincipal(String nombre){
       //juego.buscar(nombre).cualquiercosa
        int opcion=0;
        //Players jugador= juego.buscar(nombre);
        loop: do{
            System.out.print("\n1.Jugar Ghost\n2. Configuración\n3. Reportes\n4. Mi Perfil\n5. Cerrar sesión\nIngrese opción: ");
            opcion = leer.nextInt();
            String nombre2;
            Players jugador1 = juego.buscar(nombre);
            switch (opcion){
                case 1:
                    System.out.print("***Jugar Ghost***\nIngrese nombre del jugador 2: ");
                    nombre2 = leer.next();
                    Players jugador2 = juego.buscar(nombre2);
                        if(jugador2!=null && !jugador1.nombre.equalsIgnoreCase(nombre2)){
                            System.out.println("\nTablero");
                            System.out.println("\nJugador 1 es: " + jugador1.nombre + "\tJugador 2 es: " + jugador2.nombre);
                            GhostGame.Jugar(jugador1.nombre, jugador2.nombre);
                        }
                        else
                            System.out.println("\nJugador ingresado no es válido");

                break;
                case 2:
                    char submenu2;
                    do {
                        System.out.print("\n***Configuración***\na. Dificultad\nb. Modo de Juego\nc. Regresar al Menú Principal\nIngrese opción: ");
                        submenu2 = leer.next().toUpperCase().charAt(0);
                        switch (submenu2){
                            case 'A':
                                GhostGame.Dificultad();
                            break;
                            case 'B':
                                GhostGame.MododeJuego();
                            break;
                            case 'C':
                            break;
                            default:
                                System.out.println("Opción no válida");
                            break;
                        }
                    } while(submenu2!='C');
                break;
                case 3:
                    char submenu3;
                    do {
                    System.out.print("\n***Reportes***\na. Descripción de mis últimos 10 juegos\nb. Ranking de Jugadores\nc. Regresar al Menú Principal\nIngrese opción: ");
                    submenu3 = leer.next().toUpperCase().charAt(0);
                    switch (submenu3){
                        case 'A':
                            System.out.println("\n***Descripción de mis últimos 10 juegos***");
                            juego.ImprimirJuegos();
                        break;
                        case 'B':
                            System.out.println("\n***Ranking de jugadores");
                            //Cuando el jugador gana la puntuación se le aumenta 5pts.
                            juego.RankingJugadores();
                        break;
                        case 'C':
                        break;
                        default:
                                System.out.println("Opción no válida");
                        break;
                    }
                    } while (submenu3!='C');
                break;
                case 4:
                    char submenu4;
                    do {
                    System.out.print("\n***Mi Perfil***\na. Ver mis Datos\nb. Modificiar mi datos\nc.Eliminar mi cuenta\nd. Regresar al Menú Principal\nIngrese opción: ");
                    submenu4 = leer.next().toUpperCase().charAt(0);
                    switch (submenu4){
                        case 'A':
                            System.out.println("\n***Ver mis Datos***\nMi nombre: " + jugador1.nombre + "\nMi contraseña: " + 
                                    jugador1.contrasenia);
                        break;
                        case 'B':
                            System.out.print("\n***Modificar mis datos\na. Modificar usuario\nb. Modificar contraseña\nIngrese opción: ");
                            char modificarDatos = leer.next().toUpperCase().charAt(0);
                            switch (modificarDatos){
                                case 'A':
                                    System.out.print("Nuevo nombre: ");
                                    nombre = leer.next();
                                    jugador1.setNombre(nombre);
                                break;
                                case 'B':
                                    System.out.print("Nueva contraseña: ");
                                    jugador1.setContrasenia(leer.next());
                                break;
                                default:
                                    System.out.println("Opción no válida");
                                break;
                            }
                        break;
                        case 'C':
                            System.out.print("\n***Eliminar mi cuenta***\n¿Desea eliminar su cuenta actual?\n1. Sí\n2. No\nIngrese opción: ");
                            int eliminar=leer.nextInt();
                            if (eliminar==1){
                                juego.eliminarPlayer(nombre);
                                jugador1.setNombre("");
                                jugador1.setContrasenia("");
                                break loop;
                            }
                        break;
                        case 'D':
                        break;
                        default:
                            System.out.println("Opción no válida");
                        break;
                    }
                    } while (submenu4!='D');
                    
                break;
                case 5:
                    //Salir
                break;
                default:
                   System.out.println("Opción no válida");
                break;
            }
          
          } while (opcion!=5);
        } 
        
        
    
    
    public static void main(String[] args) {
        //Declaración de variables       
        int opcion;
        String username="", password="";
        //Instanciando la clase Players
       JOptionPane.showMessageDialog(null, "Bienvenido");
        
        
        do{
            System.out.print("\n\tMENU DE INICIO\n1. Login\n2. Crear Player\n3. Salir\nOpción a elegir: ");
            opcion = leer.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("\n***LOGIN***");
                    System.out.print("Ingrese usuario: ");
                    username = leer.next();
                    System.out.print("Ingrese contraseña: ");
                    password = leer.next();
                    //Se utiliza la función BUSCAR de la clase GhostGame para verificar que exista el usuario ingresado
                    if(juego.buscar2(username, password)){ //En caso de que exista, buscar devuelve los jugadores existentes (no es vacío)
                        
                        System.out.println("\n\n***Menú principal***\n");
                        //jugador.setNombre(username);
                        //jugador.setContrasenia(password);
                        Progra1Proyecto2.MenuPrincipal(username);
                    }
                    else //En el caso de que BUSCAR devuelva vacío, no existe tal jugador en arreglo de jugadores
                        System.out.println("Usuario o contraseña incorrecta");
                break;
                case 2:
                    System.out.print("***CREAR PLAYER***\nCrear usuario del jugador: ");
                    username = leer.next();
                    System.out.print("Ingrese contraseña: ");
                    password = leer.next();
                    //Se utiliza la función BUSCAR de la clase GhostGame para validar que no se repita el nombre de usuario más de una vez
                    juego.buscar(username);
                    if (juego.crearPlayer(username, password)){ //En el caso de que BUSCAR devolviera vacío, la función CREARPLAYER es verdadera
                        System.out.println("Se ha creado el jugador\n\n***Menú Principal***\n");
                        Progra1Proyecto2.MenuPrincipal(username);
                    }
                    else //En el caso de que BUSCAR haya devuelto valores existentes, el usuario ingresado ya existe
                        System.out.println("Jugador ya existe");
                    
                break;
                case 3:
                break;
                default:
                    System.out.println("Opción no válida");
                break;
            }
        
        } while (opcion!=3);
    }
    
}
