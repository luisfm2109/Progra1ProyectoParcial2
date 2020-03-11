
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
    
    String puntuacionA[];
    
    //Constructor
    public Players(String nombre, String contrasenia){
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        puntuacion=0;
        puntuacionA= new String [10];
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setContrasenia(String contrasenia){
        this.contrasenia = contrasenia;
    }
    
    public String getNombre(String nombre){
        return this.nombre;
    }
    public String getContrasenia(String contrasenia){
        return this.contrasenia;
    }
    
   
    //Imprimir
    /*public static void Imprimir(){
        System.out.print("Ingrese usuario: ");
        nombre = leer.next();
        System.out.print("Ingrese contraseña: ");
        contrasenia = leer.next();
    }*/
}
