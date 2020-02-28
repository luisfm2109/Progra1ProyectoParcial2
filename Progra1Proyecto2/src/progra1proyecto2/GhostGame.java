
package progra1proyecto2;

import java.util.Scanner;

/*
    NOTA: SE UTILIZA LA VARIABLE "lea" PARA EL SCANNER
    */
public class GhostGame {
    static Scanner lea = new Scanner(System.in);
    static String tablero[][] = new String[6][6];
    static String dificultad = "NORMAL";
    static String modojuego = "ALEATORIO";
    
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
        for(int fila=0;fila<6;fila++){
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
            dificultad = lea.next().toUpperCase();
            
                if(!dificultad.equals("NORMAL")&&!dificultad.equals("EXPERT")&&!dificultad.equals("GENIUS")){
                    System.out.println("Dificultad invalida");
                        }
        }while(!dificultad.equals("NORMAL")&&!dificultad.equals("EXPERT")&&!dificultad.equals("GENIUS"));
        
    }
    
    static void MododeJuego(){
        do{
            System.out.println("Elegir modo de juego: ALEATORIO o MANUAL");
            modojuego = lea.next().toUpperCase();
            
                if(!dificultad.equals("ALEATORIO")&&!dificultad.equals("MANUAL")){
                    System.out.println("Modo de juego invalido");
                        }
        }while(!dificultad.equals("ALEATORIO")&&!dificultad.equals("MANUAL"));
    }
    
    static void Configuracion(){
        char opcionconfig;
        
        do{
            System.out.println("a. Dificultad\nb. Modo de juego\nc. Volver al menu principal");
            opcionconfig= lea.next().toLowerCase().charAt(0);
            
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
