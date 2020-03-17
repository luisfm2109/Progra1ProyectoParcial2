
package progra1proyecto2;
import java.util.Scanner;

/*
    NOTA: SE UTILIZA LA VARIABLE "lea" PARA EL SCANNER
    */
public class Players {
    Scanner leer = new Scanner(System.in);
   
    
    //Atributos que tiene la clase player
    String nombre, contrasenia;
    int puntuacion;
    String ultimosJuegos[];
    String ranking;
    
    //Constructor
    public Players(String nombre, String contrasenia){
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        puntuacion=0;
        ultimosJuegos= new String [50];
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setContrasenia(String contrasenia){
        this.contrasenia = contrasenia;
    }
    
   
   
    //Imprimir
    /*public static void Imprimir(){
        System.out.print("Ingrese usuario: ");
        nombre = leer.next();
        System.out.print("Ingrese contraseña: ");
        contrasenia = leer.next();
    }*/
}
