
package progra1proyecto2;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Progra1Proyecto2 {
static Scanner leer = new Scanner(System.in);
 
    //Instanciando la clase GhostGame
    static GhostGame juego=new GhostGame();
    
    
    public static void MenuPrincipal(String nombre){
        int opcion=0;
        loop: do{
            System.out.print("\n1.Jugar Ghost\n2. Configuración\n3. Reportes\n4. Mi Perfil\n5. Cerrar sesión\nIngrese opción: ");
            opcion = leer.nextInt();
            String nombre2;
            //Jugador1 será el objeto Players que está log-in y del cual se basan las funciones
            Players jugador1 = juego.buscar(nombre);
            switch (opcion){
                case 1:
                    //JUGAR GHOST
                    System.out.print("***Jugar Ghost***\nIngrese nombre del jugador 2: ");
                    nombre2 = leer.next();
                    
                    //Jugador2 es el objeto players contra quien el jugador log-in va a jugar.
                    Players jugador2 = juego.buscar(nombre2);
                        //Asegurar que el jugador2 existe y no es el mismo jugador1
                        if(jugador2!=null && !jugador1.nombre.equalsIgnoreCase(nombre2)){
                            System.out.println("\nTablero");
                            System.out.println("\nJugador 1 es: " + jugador1.nombre + "\tJugador 2 es: " + jugador2.nombre);
                            //Se llama a la función Jugar donde se encuentra la lógica del juego, tiene como parámetros el jugador1(log.in) y el 2 que ya se validó anteriormente
                            GhostGame.Jugar(jugador1.nombre, jugador2.nombre);
                        }
                        //En caso de que el jugador2 no exista o si es el mismo jugador1
                        else
                            System.out.println("\nJugador ingresado no es válido");

                break;
                case 2:
                    //CONFIGURACIÓN
                    char submenu2;
                    do {
                        System.out.print("\n***Configuración***\na. Dificultad\nb. Modo de Juego\nc. Regresar al Menú Principal\nIngrese opción: ");
                        submenu2 = leer.next().toUpperCase().charAt(0);
                        switch (submenu2){
                            case 'A':
                                //Se llama al método Dificultad de la Clase GhostGame
                                GhostGame.Dificultad();
                            break;
                            case 'B':
                                //Se llama al método Modo de Juego de la Clase GhostGame
                                GhostGame.MododeJuego();
                            break;
                            case 'C':
                                //Regresa al menú anterior
                            break;
                            default:
                                System.out.println("Opción no válida");
                            break;
                        }
                    } while(submenu2!='C');
                break;
                case 3:
                    //REPORTES
                    char submenu3;
                    do {
                    System.out.print("\n***Reportes***\na. Descripción de mis últimos 10 juegos\nb. Ranking de Jugadores\nc. Regresar al Menú Principal\nIngrese opción: ");
                    submenu3 = leer.next().toUpperCase().charAt(0);
                    switch (submenu3){
                        case 'A':
                            System.out.println("\n***Descripción de mis últimos 10 juegos***");
                            //Me muestra los últimos 10 juegos en base al jugador que recibe de parámetro (el que está log-in)
                            juego.ImprimirJuegos(jugador1.nombre);
                        break;
                        case 'B':
                            System.out.println("\n***Ranking de jugadores***");
                            //Primero se ordenan todos los jugadores existentes en el juego en base a la puntuación
                            juego.OrdenarRanking(jugador1.nombre,jugador1.contrasenia);
                            //Luego se imprimen
                            juego.RankingJugadores();
                        break;
                        case 'C':
                            //Regresar al menú anterior
                        break;
                        default:
                                System.out.println("Opción no válida");
                        break;
                    }
                    } while (submenu3!='C');
                break;
                case 4:
                    //MI PERFIL
                    char submenu4;
                    do {
                    System.out.print("\n***Mi Perfil***\na. Ver mis Datos\nb. Modificiar mi datos\nc.Eliminar mi cuenta\nd. Regresar al Menú Principal\nIngrese opción: ");
                    submenu4 = leer.next().toUpperCase().charAt(0);
                    switch (submenu4){
                        case 'A':
                            //VER MIS DATOS
                            System.out.println("\n***Ver mis Datos***\nMi nombre: " + jugador1.nombre + "\nMi contraseña: " + 
                                    jugador1.contrasenia);
                        break;
                        case 'B':
                            //MODIFICAR MIS DATOS
                            System.out.print("\n***Modificar mis datos\na. Modificar usuario\nb. Modificar contraseña\nIngrese opción: ");
                            char modificarDatos = leer.next().toUpperCase().charAt(0);
                            switch (modificarDatos){
                                case 'A':
                                    //MODIFICAR USUARIO
                                    System.out.print("Nuevo nombre: ");
                                    nombre = leer.next();
                                    if (juego.buscar(nombre)==null) //Para validar que se repitan nombres de jugadores
                                        jugador1.setNombre(nombre); //Se actualiza el nombre del jugador log-in por uno nuevo
                                    else
                                        System.out.println("Nombre de jugador ya existe");
                                break;
                                case 'B':
                                    //MODIFICAR CONTRASEÑA
                                    System.out.print("Nueva contraseña: ");
                                    jugador1.setContrasenia(leer.next()); //Se actualiza la contraseña del jugador log-in
                                break;
                                default:
                                    System.out.println("Opción no válida");
                                break;
                            }
                        break;
                        case 'C':
                            //ELIMINAR CUENTA
                            System.out.print("\n***Eliminar mi cuenta***\n¿Desea eliminar su cuenta actual?\n1. Sí\n2. No\nIngrese opción: ");
                            int eliminar=leer.nextInt();
                            if (eliminar==1){
                                //Se llama a la función EliminarPlayer de la clase GhostGame
                                juego.eliminarPlayer(nombre);
                                break loop; //Para que me regrese al menú de inicio automáticamente
                            }
                        break;
                        case 'D':
                            //Regresar al menú anterior
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
        
        do{
            System.out.print("\n\tMENU DE INICIO\n1. Login\n2. Crear Player\n3. Salir\nOpción a elegir: ");
            opcion = leer.nextInt();
            switch(opcion){
                case 1:
                    //LOGIN
                    System.out.println("\n***LOGIN***");
                    System.out.print("Ingrese usuario: ");
                    username = leer.next();
                    System.out.print("Ingrese contraseña: ");
                    password = leer.next();
                    //Se utiliza la función BUSCAR2 de la clase GhostGame para verificar que exista el usuario ingresado y que el usuario y contra son compatibles
                    if(juego.buscar2(username, password)){ //En caso de que exista, BUSCAR2 devuelve el jugador ingresado
                        
                        System.out.println("\n\n***Menú principal***\n");
                        //Llama al método MenuPrincipal para desplegarlo con parámetro del jugador log-in
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
                    //Se utiliza la función BUSCAR de la clase GhostGame para validar que  el nombre del usuario es único
                    juego.buscar(username);
                    if (juego.crearPlayer(username, password)){ //En el caso de que BUSCAR devolviera vacío, la función CrearPlayer es verdadera
                        System.out.println("Se ha creado el jugador\n\n***Menú Principal***\n");
                        //Llama al método MenuPrincipal para desplegarlo con parámetro del jugador que se acaba de crear
                        Progra1Proyecto2.MenuPrincipal(username);
                    }
                    else //En el caso de que BUSCAR haya devuelto un valor no vacío, el usuario ingresado ya existe
                        System.out.println("Jugador ya existe");
                    
                break;
                case 3:
                    //SALIR
                break;
                default:
                    System.out.println("Opción no válida");
                break;
            }
        
        } while (opcion!=3);
    }
    
}
