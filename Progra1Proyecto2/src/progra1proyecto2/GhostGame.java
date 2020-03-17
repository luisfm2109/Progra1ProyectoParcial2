
package progra1proyecto2;

import java.util.Scanner;

/*
    NOTA: SE UTILIZA LA VARIABLE "leer" PARA EL SCANNER
    */
public class GhostGame {
      
    //Declarar variable
    static Scanner leer = new Scanner(System.in);
    static public Players jugadores[];
    static String tablero[][] = new String[6][6];
    static Piezas tablero2[][] = new Piezas[6][6];
    static int dificultad = 1;
    static int modojuego = 1;
    static int fantasmasbuenos1=0;
    static int fantasmasmalos1=0;
    static int fantasmasbuenos2=0;
    static int fantasmasmalos2=0;
    //static String ultimosJuegos[]= new String [50];
    
    //Constructor
    public GhostGame (){
        jugadores = new Players [50];
    }
    
   
    //Buscar usuario dentro de la colección de jugadores
    static public Players buscar (String username){
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
                jugadores[posicion]=null;
                /*jugadores[posicion].nombre="";
                jugadores[posicion].contrasenia="";
                jugadores[posicion].puntuacion=0;*/
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
    static void UltimosJuegos(String jugador1, String razonganar){
        for (int juego=buscar(jugador1).ultimosJuegos.length-1; juego>=0; juego--){
            if (buscar(jugador1).ultimosJuegos[juego]==null){
                buscar(jugador1).ultimosJuegos[juego]=razonganar;
                break;
            }
        }
    }
    static void ImprimirJuegos(String jugador1){
        int contador=0; 
        for(int juego=0; juego<=buscar(jugador1).ultimosJuegos.length-1; juego++){
            if (buscar(jugador1).ultimosJuegos[juego]!=null && contador<10){ 
                System.out.println(buscar(jugador1).ultimosJuegos[juego]);
                contador++;
            }  
        }
    }
    
    static void OrdenarRanking(String nombre, String contrasenia){
        Players temporalJugador = new Players(nombre, contrasenia);
        for(int x=0; x<jugadores.length; x++){//En la parte de x<emp, emp es el tamaño del arreglo igual en y<emp
                     for(int y=1; y<jugadores.length;y++){
                         if(jugadores[y-1]!=null && jugadores[y]!=null && jugadores[y-1].puntuacion<jugadores[y].puntuacion){//Si queres que te los presente de menor a mayor solo le das vuelta al signo < por >
                             temporalJugador = jugadores[y-1];
                             jugadores[y-1]= jugadores[y];
                             jugadores[y]=temporalJugador;
                         }
                     }  
                 }  
    }
    //Ranking de jugadores
    public void RankingJugadores(){
        //String rankingJugador1= buscar(jugador1).ranking;
        System.out.println("\nNombre\t\tPuntuación");
        for (int posicion=0; posicion<jugadores.length; posicion++){
            if (jugadores[posicion]!=null){
                System.out.println(jugadores[posicion].nombre + "\t\t" + jugadores[posicion].puntuacion);
            }
        }
    }
  
    static void Jugar(String jugador1, String jugador2){
        fantasmasbuenos1=0;
        fantasmasmalos1=0;
        fantasmasbuenos2=0;
        fantasmasmalos2=0;
        TableroInicial();
        int turno=1;
        
        String jugadoractual="";
        do{
            CantidadFantasmas(jugador1,jugador2);
            if(Ganador(jugador1, jugador2))
                break;
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
            ImprimirTablero2();
            
            turno++;
        }while(true);
    }
    
    static boolean Ganador(String jugador1, String jugador2){
        String razonganar;
        if(fantasmasbuenos2==0){
            razonganar=jugador1+" triunfo sobre "+jugador2+" porque le comio todos los fantasmas buenos";
            System.out.println(razonganar);
            UltimosJuegos(jugador1, razonganar);
            buscar(jugador1).puntuacion+=3;
            return true;
        }
        if(fantasmasmalos1==0){
            razonganar=jugador1+" triunfo sobre "+jugador2+" porque le comio todos los fantasmas malos";
            System.out.println(razonganar);
            UltimosJuegos(jugador1, razonganar);
            buscar(jugador1).puntuacion+=3;
            return true;
        }
        if((tablero2[0][0].jugador.equals("F1") && tablero2[0][0].fantasmabueno) || (tablero2[0][5].jugador.equals("F1") && tablero2[0][5].fantasmabueno)){
            razonganar=jugador1+" triunfo sobre "+jugador2+" porque logro sacar del castillo un fantasma bueno";
            System.out.println(razonganar);
            UltimosJuegos(jugador1 , razonganar);
            buscar(jugador1).puntuacion+=3;
            return true;
        }
        
        if(fantasmasbuenos1==0){
            razonganar=jugador2+" triunfo sobre "+jugador1+" porque le comio todos los fantasmas buenos";
            System.out.println(razonganar);
            UltimosJuegos(jugador1, razonganar);
            buscar(jugador2).puntuacion+=3;
            return true;
        }
        if(fantasmasmalos2==0){
            razonganar=jugador2+" triunfo sobre "+jugador1+" porque le comio todos los fantasmas malos";
            System.out.println(razonganar);
            UltimosJuegos(jugador1, razonganar);
            buscar(jugador2).puntuacion+=3;
            return true;
        }
        if((tablero2[5][0].jugador.equals("F2") && tablero2[5][0].fantasmabueno) || (tablero2[5][5].jugador.equals("F2") && tablero2[5][5].fantasmabueno)){
            razonganar=jugador2+" triunfo sobre "+jugador1+" porque logro sacar del castillo un fantasma bueno";
            System.out.println(razonganar);
            UltimosJuegos(jugador1, razonganar);
            buscar(jugador2).puntuacion+=3;
            return true;
        }
        return false;
    }
    
    static void CantidadFantasmas(String jugador1, String jugador2){
        fantasmasbuenos1=0;
        fantasmasmalos1=0;
        fantasmasbuenos2=0;
        fantasmasmalos2=0;
        
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                if(tablero2[i][j].jugador.equals("F1")){
                    if(tablero2[i][j].fantasmabueno){
                        fantasmasbuenos1++;
                    }else{
                        fantasmasmalos1++;
                    }
                }else if(tablero2[i][j].jugador.equals("F2")){
                    if(tablero2[i][j].fantasmabueno){
                        fantasmasbuenos2++;
                    }else{
                        fantasmasmalos2++;
                    }
                }
                
            }
        }
        
        System.out.println(jugador1);
        System.out.println("Fantasmas buenos: "+fantasmasbuenos1+"\tFantasmas malos: "+fantasmasmalos1);
        System.out.println(jugador2);
        System.out.println("Fantasmas buenos: "+fantasmasbuenos2+"\tFantasmas malos: "+fantasmasmalos2);
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
        if(tablero2[fila][columna].jugador.equals("[]")){
           System.out.println("Espacio vacio"); 
        }else if(!tablero2[fila][columna].jugador.equals(jugador)){
            System.out.println("Pieza del jugador contrario");
        }
       
        }while(!tablero2[fila][columna].jugador.equals(jugador));
        
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
            
            if(tablero2[fila][columna].jugador.equals(jugador) || (fila==0 && columna==0 && tablero2[fila][columna].jugador.equals("F2")) || (fila==0 && columna==5 && tablero2[fila][columna].jugador.equals("F2")) || (fila==5 && columna==0 && tablero2[fila][columna].jugador.equals("F1")) || (fila==5 && columna==5 && tablero2[fila][columna].jugador.equals("F1")) || (fila!=filapieza && columna!=columnapieza)){
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
        if(!tablero2[fila][columna].jugador.equals("[]")){
            if(tablero2[fila][columna].fantasmabueno){
            System.out.println("TE HAS COMIDO UN FANTASMA BUENO DEL JUGADOR CONTRARIO");
            }else{
                System.out.println("TE HAS COMIDO UN FANTASMA MALO DEL JUGADOR CONTRARIO");
            }
        }
        tablero2[fila][columna].jugador= tablero2[filapieza][columnapieza].jugador;
        tablero2[fila][columna].fantasmabueno= tablero2[filapieza][columnapieza].fantasmabueno;
        tablero2[filapieza][columnapieza].jugador="[]";
        tablero2[filapieza][columnapieza].fantasmabueno=false;
        return true;
    }
    
    static void TableroInicial(){
        
        for(int fila=0;fila<6;fila++){
            for(int columna=0;columna<6;columna++){
                tablero[fila][columna]="[]";
                tablero2[fila][columna]=new Piezas("[]",false);
            }
        }
        ImprimirTablero();
        if(dificultad==1){
            Normal();
        }else if(dificultad==2){
            Expert();
        }else{
            Genius();
        }
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
    
    static void ImprimirTablero2(){
        System.out.println("  1 2 3 4 5 6");
        for(int fila=0;fila<6;fila++){
            System.out.print((fila+1)+" ");
            for(int columna=0;columna<6;columna++){
               System.out.print(tablero2[fila][columna].jugador);
            }
            System.out.print("\n");
        }
    }
    
    static void Normal(){
        String jugador="F1";
        int fila;
        int columna;
        System.out.println("Jugador 1");
        for(int i =1;i<=8;i++){
            do{
            if(i%2==1){
                System.out.println("¿Dónde quiere el fantasma bueno?");
            }else{
                System.out.println("¿Dónde quiere el fantasma malo?");
            }
            System.out.print("Fila: ");
            fila=leer.nextInt()-1;
            System.out.print("Columna: ");
            columna=leer.nextInt()-1;
            if((fila<4) || (columna==0 || columna==5) || tablero2[fila][columna].jugador.equals(jugador)){
                System.out.println("Posicion inválida");
                continue;
            }
            break;
            }while(true);
            if(i%2==1){
            tablero2[fila][columna].jugador="F1";
            tablero2[fila][columna].fantasmabueno=true;
            }else{
                tablero2[fila][columna].jugador="F1";
            tablero2[fila][columna].fantasmabueno=false;
            }
            ImprimirTablero2();
        }
        
        jugador="F2";
        System.out.println("Jugador 2");
        for(int i =1;i<=8;i++){
            do{
            if(i%2==1){
                System.out.println("¿Dónde quiere el fantasma bueno?");
            }else{
                System.out.println("¿Dónde quiere el fantasma malo?");
            }
            System.out.print("Fila: ");
            fila=leer.nextInt()-1;
            System.out.print("Columna: ");
            columna=leer.nextInt()-1;
            if((fila>1) || (columna==0 || columna==5) || tablero2[fila][columna].jugador.equals(jugador)){
                System.out.println("Posicion inválida");
                continue;
            }
            break;
            }while(true);
            if(i%2==1){
            tablero2[fila][columna]=new Piezas(jugador,true);
            }else{
                tablero2[fila][columna]=new Piezas(jugador,false);
            }
            ImprimirTablero2();
        }
        
        for(int i=0;i<6;i++){
            for(int j=0;i<6;i++){
                if(tablero2[i][j]==null){
                    tablero2[i][j]=new Piezas("[]",false);
                }
            }
        }
        
    }
    
    static void Expert(){
        String jugador="F1";
        int fila;
        int columna;
        System.out.println("Jugador 1");
        for(int i =1;i<=4;i++){
            do{
            if(i%2==1){
                System.out.println("¿Dónde quiere el fantasma bueno?");
            }else{
                System.out.println("¿Dónde quiere el fantasma malo?");
            }
            System.out.print("Fila: ");
            fila=leer.nextInt()-1;
            System.out.print("Columna: ");
            columna=leer.nextInt()-1;
            if((fila<4) || (columna==0 || columna==5) || tablero2[fila][columna].jugador.equals(jugador)){
                System.out.println("Posicion inválida");
                continue;
            }
            break;
            }while(true);
            if(i%2==1){
            tablero2[fila][columna]=new Piezas(jugador,true);
            }else{
                tablero2[fila][columna]=new Piezas(jugador,false);
            }
            ImprimirTablero2();
        }
        
        jugador="F2";
        System.out.println("Jugador 2");
        for(int i =1;i<=4;i++){
            do{
            if(i%2==1){
                System.out.println("¿Dónde quiere el fantasma bueno?");
            }else{
                System.out.println("¿Dónde quiere el fantasma malo?");
            }
            System.out.print("Fila: ");
            fila=leer.nextInt()-1;
            System.out.print("Columna: ");
            columna=leer.nextInt()-1;
            if((fila>1) || (columna==0 || columna==5) || tablero2[fila][columna].jugador.equals(jugador)){
                System.out.println("Posicion inválida");
                continue;
            }
            break;
            }while(true);
            if(i%2==1){
            tablero2[fila][columna]=new Piezas(jugador,true);
            }else{
                tablero2[fila][columna]=new Piezas(jugador,false);
            }
            ImprimirTablero2();
        }
        
        for(int i=0;i<6;i++){
            for(int j=0;i<6;i++){
                if(tablero2[i][j]==null){
                    tablero2[i][j]=new Piezas("[]",false);
                }
            }
        }
    }
    
    static void Genius(){
        String jugador="F1";
        int fila;
        int columna;
        System.out.println("Jugador 1");
        for(int i =1;i<=2;i++){
            do{
            if(i%2==1){
                System.out.println("¿Dónde quiere el fantasma bueno?");
            }else{
                System.out.println("¿Dónde quiere el fantasma malo?");
            }
            System.out.print("Fila: ");
            fila=leer.nextInt()-1;
            System.out.print("Columna: ");
            columna=leer.nextInt()-1;
            if((fila<4) || (columna==0 || columna==5 || tablero2[fila][columna].jugador.equals(jugador))){
                System.out.println("Posicion inválida");
                continue;
            }
            break;
            }while(true);
            if(i%2==1){
            tablero2[fila][columna]=new Piezas(jugador,true);
            }else{
                tablero2[fila][columna]=new Piezas(jugador,false);
            }
            ImprimirTablero2();
        }
        
        jugador="F2";
        System.out.println("Jugador 2");
        for(int i =1;i<=2;i++){
            do{
            if(i%2==1){
                System.out.println("¿Dónde quiere el fantasma bueno?");
            }else{
                System.out.println("¿Dónde quiere el fantasma malo?");
            }
            System.out.print("Fila: ");
            fila=leer.nextInt()-1;
            System.out.print("Columna: ");
            columna=leer.nextInt()-1;
            if((fila>1) || (columna==0 || columna==5) || tablero2[fila][columna].jugador.equals(jugador)){
                System.out.println("Posicion inválida");
                continue;
            }
            break;
            }while(true);
            if(i%2==1){
            tablero2[fila][columna]=new Piezas(jugador,true);
            }else{
                tablero2[fila][columna]=new Piezas(jugador,false);
            }
            ImprimirTablero2();
        }
        
        for(int i=0;i<6;i++){
            for(int j=0;i<6;i++){
                if(tablero2[i][j]==null){
                    tablero2[i][j]=new Piezas("[]",false);
                }
            }
        }
    }
    
    static void Dificultad(){
        do{
            System.out.print("Elegir dificultad:\t1. NORMAL\t2. EXPERT\t3. GENIUS\nIngrese opción: ");
            dificultad = leer.nextInt();
            
                if(dificultad!=1 && dificultad!=2 && dificultad!=3){
                    System.out.println("Dificultad inválida");
                }
        }while(dificultad!=1 && dificultad!=2 && dificultad!=3);
        
    }
    
    static void MododeJuego(){
        do{
            System.out.println("Elegir modo de juego:\t1. ALEATORIO\t2. MANUAL");
            modojuego = leer.nextInt();
            
                if(modojuego!=1 && modojuego!=2){
                    System.out.println("Modo de juego invalido");
                        }
        }while(modojuego!=1 && modojuego!=2);
    }
    
}
