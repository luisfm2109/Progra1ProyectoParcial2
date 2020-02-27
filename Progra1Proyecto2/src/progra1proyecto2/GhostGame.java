
package progra1proyecto2;

import java.util.Scanner;

public class GhostGame {
    Scanner lea = new Scanner(System.in);
    static String tablero[][] = new String[6][6]; 
    
    static void TableroInicial(){
        for(int f=0;f<6;f++){
            for(int c=0;c<6;c++){
                if(c==0 || c==5 || (f==2 || f==3)){
                    System.out.print("[]");
                }else{
                    if(f<=1){
                        System.out.print("F2");
                    }else if(f>=4){
                        System.out.print("F1");
                    }
                
                }
            }
            System.out.print("\n");
        }
    
    
    
    }
    
}
