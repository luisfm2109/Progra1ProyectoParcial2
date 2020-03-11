
package progra1proyecto2;

import java.util.Scanner;

/*
    NOTA: SE UTILIZA LA VARIABLE "lea" PARA EL SCANNER
    */
public class GhostGame {
      
    //Declarar variable
    static Scanner leer = new Scanner(System.in);
    public Players jugadores[];
    static String tablero[][] = new String[6][6];
    static String dificultad = "NORMAL";
    static String modojuego = "ALEATORIO";
    //Constructor
    public GhostGame (){
        jugadores = new Players [50];
    }
    
   
    //Buscar usuario dentro de la colección de jugadores
    public Players buscar (String username){
        for (Players jugadorF: jugadores) { //En caso de que ya exista dicho usuario en el arreglo de jugadores
            if ( jugadorF!=null && jugadorF.nombre.equalsIgnoreCase(username))
                return jugadorF;
        }
        //En caso de que no esté dentro de la colección de jugadores
        return null;
    }
    
    //Buscar contraseña dentro de la colección de jugadores
    public boolean buscar2 (String username, String contrasenia){
        for (int posicion=0; posicion<jugadores.length; posicion++) { //En caso de que ya exista dicho usuario en el arreglo de jugadores
            if ( jugadores[posicion]!=null && jugadores[posicion].nombre.equalsIgnoreCase(username) && jugadores[posicion].contrasenia.equalsIgnoreCase(contrasenia))
                return true;
        }
        //En caso de que no esté dentro de la colección de jugadores
        return false;
    }
    
    //Crear un usuario a la colección de jugadores
    public boolean crearPlayer(String username, String password){
        
        if (buscar(username)==null){
            for (int posicion=0; posicion< jugadores.length; posicion++){
                if (jugadores[posicion]==null){ //En caso de que el usuario no exista
                    jugadores[posicion] = new Players (username, password); //Se crea el usuario dentro del arreglo
                    return true;
                }
                    
            }
        }
        //En caso de que el usuario ya exista
        return false;
    }
    
    public void eliminarPlayer(String username){
        for (int posicion=0; posicion<jugadores.length;posicion++){
            if (jugadores[posicion]!=null && jugadores[posicion].nombre==username){
                jugadores[posicion].nombre="";
                jugadores[posicion].contrasenia="";
            }
        }
    }
    
    //Jugador 1
    public String jugador1 (String username){
        for (Players jugadorF: jugadores){
            if (jugadorF!=null && jugadorF.nombre.equalsIgnoreCase(username))
                return jugadorF.nombre;
        }
        return null;
    }
    
    //Jugador 2
    public String jugador2 (String username){
        for (Players jugadorF: jugadores){
            if (jugadorF!=null && jugadorF.nombre.equalsIgnoreCase(username))
                return jugadorF.nombre;
        }
        return null;
    }
    
    //Ranking de jugadores
    public void RankingJugadores(){
        System.out.println("\nNombre\tContraseña\tPuntuación");
        for (int posicion=0; posicion<jugadores.length; posicion++){
            if (jugadores[posicion]!=null){
                System.out.println(jugadores[posicion].nombre + "\t\t" + jugadores[posicion].contrasenia + "\t" + jugadores[posicion].puntuacion);
            }
        }
    }
    
    static void Jugar(String jugador1, String jugador2){
        TableroInicial();
        int turno=1;
        String jugadoractual="";
        do{
            System.out.print("Turno de ");
            if(turno%2==1){
                System.out.println(jugador1);
                jugadoractual="F1";
            }else{
                System.out.println(jugador2);
                jugadoractual="F2";
            }
            if(!ElegirPieza(jugadoractual))
                continue;
            ImprimirTablero();
            turno++;
        }while(true);
    }
    
    static boolean ElegirPieza(String jugadoractual){
        String jugador=jugadoractual;
        int fila;
        int columna;
        
        do{
            do{
        System.out.print("Ingresar fila de la pieza: ");
        fila = leer.nextInt()-1;
        if(fila<0 || fila>5){
          System.out.println("Fila fuera de rango");  
        }
            }while(fila<0 || fila>5);
            
            do{
        System.out.print("Ingresar columna de la pieza: ");
        columna = leer.nextInt()-1;
        if(columna<0 || columna>5){
          System.out.println("Columna fuera de rango");  
        }
            }while(columna<0 || columna>5);
        if(tablero[fila][columna].equals("[]")){
           System.out.println("Espacio vacio"); 
        }else if(!tablero[fila][columna].equals(jugador)){
            System.out.println("Pieza del jugador contrario");
        }
       
        }while(!tablero[fila][columna].equals(jugador));
        
        return MoverPieza(jugador,fila,columna);
    }
    
    static boolean MoverPieza(String jugadoractual, int filapieza, int columnapieza){
        String jugador=jugadoractual;
        int fila;
        int columna;
        System.out.println("Coordenada donde mover la pieza");
        loop: do{
            do{
                System.out.print("Fila: ");
                fila = leer.nextInt()-1;
                if(fila>filapieza+1 || fila<filapieza-1 || fila<0 || fila>5){
                    System.out.println("Fila fuera de rango"); 
                }
            }while(fila>filapieza+1 || fila<filapieza-1 || fila<0 || fila>5);
            
            do{
                System.out.print("Columna: ");
                columna = leer.nextInt()-1;
                if(columna<0 || columna>5 || columna>columnapieza+1 || columna<columnapieza-1){
                    System.out.println("Columna fuera de rango");
                }
            }while(columna<0 || columna>5 || columna>columnapieza+1 || columna<columnapieza-1);
            
            if(tablero[fila][columna].equals(jugador) || (fila==0 && columna==0) || (fila==0 && columna==5) || (fila==5 && columna==0) || (fila==5 && columna==5) || (fila!=filapieza && columna!=columnapieza)){
                System.out.println("Movimiento invalido");
                do{
                System.out.println("1. Ingresar otra cooordenada de movimiento\n2. Seleccionar otro fantasma");
                int seleccion = leer.nextInt();
                if(seleccion==1)
                continue loop;
                else if(seleccion==2){
                    return false;
                }
                }while(true);
            }
            break;
        }while(true);
        if(!tablero[fila][columna].equals("[]")){
            System.out.println("Te comiste una pieza del jugador contrario!");
        }
        tablero[fila][columna]=jugador;
        tablero[filapieza][columnapieza]="[]";
        return true;
    }
    
    static void TableroInicial(){
        for(int fila=0;fila<6;fila++){
            for(int columna=0;columna<6;columna++){
                if(dificultad.equals("NORMAL")){
                    Normal(fila,columna);
                }else if(dificultad.equals("EXPERT")){
                    Expert(fila,columna);
                }else{
                    Genius(fila,columna);
                }
            }
        }
        ImprimirTablero();
    }
    
    static void ImprimirTablero(){
        System.out.println("  1 2 3 4 5 6");
        for(int fila=0;fila<6;fila++){
            System.out.print((fila+1)+" ");
            for(int columna=0;columna<6;columna++){
               System.out.print(tablero[fila][columna]);
            }
            System.out.print("\n");
        }
    }
    static void Normal(int fila, int columna){
        if(columna==0 || columna==5 || (fila==2 || fila==3)){
                    tablero[fila][columna] ="[]";
                }else{
                    if(fila<=1){
                        tablero[fila][columna] ="F2";
                    }else if(fila>=4){
                        tablero[fila][columna] ="F1";
                    }
                
                }
    }
    
    static void Expert(int fila, int columna){
        if(columna==0 || columna==5 || (fila>=1 && fila<=4)){
                    tablero[fila][columna] ="[]";
                }else{
                    if(fila<1){
                        tablero[fila][columna] ="F2";
                    }else if(fila>4){
                        tablero[fila][columna] ="F1";
                    }
                
                }
    }
    
    static void Genius(int fila, int columna){
        if(columna<=1 || columna>=4 || (fila>=1 && fila<=4)){
                    tablero[fila][columna] ="[]";
                }else{
                    if(fila<1){
                        tablero[fila][columna] ="F2";
                    }else if(fila>4){
                        tablero[fila][columna] ="F1";
                    }
                
                }
    }
    static void Dificultad(){
        do{
            System.out.println("Elegir dificultad: NORMAL, EXPERT o GENIUS");
            dificultad = leer.next().toUpperCase();
            
                if(!dificultad.equals("NORMAL")&&!dificultad.equals("EXPERT")&&!dificultad.equals("GENIUS")){
                    System.out.println("Dificultad invalida");
                        }
        }while(!dificultad.equals("NORMAL")&&!dificultad.equals("EXPERT")&&!dificultad.equals("GENIUS"));
        
    }
    
    static void MododeJuego(){
        do{
            System.out.println("Elegir modo de juego: ALEATORIO o MANUAL");
            modojuego = leer.next().toUpperCase();
            
                if(!dificultad.equals("ALEATORIO")&&!dificultad.equals("MANUAL")){
                    System.out.println("Modo de juego invalido");
                        }
        }while(!dificultad.equals("ALEATORIO")&&!dificultad.equals("MANUAL"));
    }
    
    static void Configuracion(){
        char opcionconfig;
        
        do{
            System.out.println("a. Dificultad\nb. Modo de juego\nc. Volver al menu principal");
            opcionconfig= leer.next().toLowerCase().charAt(0);
            
            switch(opcionconfig){
               case 'a': Dificultad();
                   break;
               case 'b': MododeJuego();
                   break;
               case 'c':break;
               default: System.out.println("Opcion no valida");
           }
       }while(opcionconfig!='c');
    }
}
