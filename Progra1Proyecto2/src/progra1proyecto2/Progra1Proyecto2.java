
package progra1proyecto2;
import java.util.Scanner;

public class Progra1Proyecto2 {
/*
    NOTA: SE UTILIZA LA VARIABLE "lea" PARA EL SCANNER
    */
    static Scanner lea = new Scanner(System.in);
    
    /* 
        Menu Principal
        Se accesa este menu por medio del menu de incio opcion 1
    */
    public static void MenuLogin(){
        int menuprincipal=0;
        
       do{
            System.out.println("1. Jugar Ghosts\n2. Configuracion\n3. Reportes\n4. Mi Perfil\n5. Cerrar sesion");
            menuprincipal = lea.nextInt();
            switch(menuprincipal){
                case 1: GhostGame.TableroInicial();
                    break;
                case 2: GhostGame.Configuracion();
                    break;
                case 3: Player.Reportes();
                    break;
                case 4: Player.MenuMiPerfil();
                    break;
                case 5: break;
                default: System.out.println("Opcion no valida");
                                }
       }while(menuprincipal!=5);
    }
    
    public static void main(String[] args) {
       int menudeinicio = 0;
       
       do{
       System.out.println("1. Login\n2. Crear Player\n3. Salir");
       menudeinicio = lea.nextInt();
       switch(menudeinicio){
           case 1: MenuLogin();
               break;
           case 2:
               break;
           case 3:break;
           default: System.out.println("Opcion no valida");
       }
       }while(menudeinicio!=3);
       
       
    }
    
}
