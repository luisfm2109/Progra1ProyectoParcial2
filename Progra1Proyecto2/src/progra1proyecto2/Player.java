
package progra1proyecto2;
import java.util.Scanner;

/*
    NOTA: SE UTILIZA LA VARIABLE "lea" PARA EL SCANNER
    */
public class Player {
    static Scanner lea = new Scanner(System.in).useDelimiter("\n");
    
    String jugador;
    String contraseña;
    int conteo;
    
    Player(String jugador, String contraseña){
        this.jugador = jugador;
        this.contraseña = contraseña;
    }
    
    static void IniciarSesion(){
        
    }
    
    static void UltimasPartidas(){
        
    }
    
    static void EliminarCuenta(){
        
    }
    
    static void ModificarNombre(){
        
    }
    
    static void ModificarContraseña(){
        
    }
    
    static void ModificarDatos(){
        char opciondatos;
        
        do{
            System.out.println("a. Modificar Username\nb. Modificar contraseña\nc. Cancelar");
            opciondatos= lea.next().toLowerCase().charAt(0);
            
            switch(opciondatos){
               case 'a': ModificarNombre();
                   break;
               case 'b': ModificarContraseña();
                   break;
               case 'c': break;
               default: System.out.println("Opcion no valida");
           }
       }while(opciondatos!='c');
    }
    static void MenuMiPerfil(){
        char opcionmiperfil;
        
        do{
            System.out.println("a. Ver mis datos\nb. Modificar mis datos\nc. Eliminar mi cuenta\nd. Volver al menu principal");
            opcionmiperfil= lea.next().toLowerCase().charAt(0);
            
            switch(opcionmiperfil){
               case 'a': 
                   break;
               case 'b': ModificarDatos();
                   break;
               case 'c':
                   break;
               case 'd': break;
               default: System.out.println("Opcion no valida");
           }
       }while(opcionmiperfil!='d');
    }
    static void DescripcionUltimos10(){
        
    }
    
    static void Ranking(){
        
    }
    
    static void Reportes(){
        char opcionreportes;
        
        do{
            System.out.println("a. Descripcion de mis ultimos 10 juegos\nb. Ranking de jugadores\nc. Volver al menu principal");
            opcionreportes= lea.next().toLowerCase().charAt(0);
            
            switch(opcionreportes){
               case 'a': DescripcionUltimos10();
                   break;
               case 'b': Ranking();
                   break;
               case 'c':break;
               default: System.out.println("Opcion no valida");
           }
       }while(opcionreportes!='c');
    }
}
