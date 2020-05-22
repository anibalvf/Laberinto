package laberinto;

import java.util.Random;


public class Laberinto {
    public void mostrarLaberinto(char[][] laberinto){
        for(int i=0;i<laberinto.length;i++){
            for (int j = 0; j < laberinto[0].length; j++) {
                System.out.print(laberinto[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    public boolean escapado(char[][] laberinto,int[] posicion){
        boolean res=false;
        
            //salir por abajo
            if (posicion[0]==laberinto.length-1) {
            res = true;
        }
            //salir por arriba
            
           else if (posicion[0] == 0) {
            
               res = true;
        }
            
            //salir derecha
            
           else if (posicion[1]== laberinto[0].length-1) {
           
               res = true;
        }
           //salir izquierda
            else if (posicion[1]== 0) {
            
                res = true;
        }
   
        
        return res;
    }
    
    
    public void moverIzq(char[][] laberinto,int[] posicion){
        if (laberinto[posicion[0]][posicion[1]-1]!='#') {
           laberinto[posicion[0]][posicion[1]]=' ';
           laberinto[posicion[0]][posicion[1]-1]='O';
            
            
            
           
            posicion[0]= posicion[0];
            posicion[1]=posicion[1]-1;
            
                    
        }
    }
    
    public void moverDer(char[][] laberinto,int[] posicion){
         if (laberinto[posicion[0]][posicion[1]+1]!='#') {
           laberinto[posicion[0]][posicion[1]]=' ';
           laberinto[posicion[0]][posicion[1]+1]='O';
            
            
            
           
            posicion[0]= posicion[0];
            posicion[1]=posicion[1]+1;
         } 
                  
    }
    
    public void moverAbajo(char[][] laberinto,int[] posicion){
         if (laberinto[posicion[0]+1][posicion[1]]!='#') {
           laberinto[posicion[0]][posicion[1]]=' ';
           laberinto[posicion[0]+1][posicion[1]]='O';
            
            
            
           
            posicion[0]= posicion[0]+1;
            posicion[1]=posicion[1];
         }
                  
    }
    
    
    public void moverArriba(char[][] laberinto,int[] posicion){
         if (laberinto[posicion[0]-1][posicion[1]]!='#') {
           laberinto[posicion[0]][posicion[1]]=' ';
           laberinto[posicion[0]-1][posicion[1]]='O';
            
            
            
           
            posicion[0]= posicion[0]-1;
            posicion[1]=posicion[1];
         }         
    }
    
    
    public void movimiento(){
     System.out.println("seleccina el movimiento");
        System.out.println("5 Arriba");
        System.out.println("2 Abajo");
        System.out.println("1 Iquierda");
        System.out.println("3 derecha");
    
    
    }
    public int[] posicionAleatoria(char[][]laberinto){
    int[] posicion= new int[2];
    Random ra=new Random();
    
        do {
            posicion[0]= ra.nextInt(laberinto.length-2)+1;
            posicion[1]= ra.nextInt(laberinto[0].length-2)+1;
                    
        } while (laberinto[posicion[0]][posicion[1]]=='#');
       
    
    return posicion;
    }
    
    public void ponerPosicion(char[][]laberinto,int[]posicion){
    
    laberinto[posicion[0]][posicion[1]]='O';
    
    }
      
    
    
   public int[] escanearPosicion(char[][]matriz){
   int[] posicion= new int[2];
   boolean enc = false;
   int i=0;
   while(i<matriz.length && enc==false){
       int j=0;
               while(j<matriz[i].length && enc==false){
                   if (matriz[i][j]=='O') {
                     posicion[0]=i;
                     posicion[1]=j;
                     enc =true;
                   }
               j++;
               }
               i++;
      }
   
//       for (int i = 0; i < matriz.length; i++) {
//           for (int j = 0; j < matriz[i].length; j++) {
//               if (matriz[i][j]=='O') {
//                   posicion[0]=i;
//                   posicion[1]=j;
//               }
//           }
//       }
   
   return posicion;
   } 
    
   public void salida(boolean comprobar){
    if (comprobar==true) {
                            System.out.println(" _   _   _   _   _   _   _     _   _   _   _   _   _   _   _   _   _   _  \n" +
                            " / \\ / \\ / \\ / \\ / \\ / \\ / \\   / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ \n" +
                            "( S | A | L | I | S | T | E ) ( E | N | H | O | R | A | B | U | E | N | A )\n" +
                            " \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/   \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ ");
                                    }
        else {
            System.out.println("  _____   _____        ___    _   _   _____   ____       _      ____    _____   _____       ____    ___   _   _       __  __    ___   __     __  ___   __  __   ___   _____   _   _   _____    ___    ____  \n" +
" |_   _| | ____|      / _ \\  | | | | | ____| |  _ \\     / \\    / ___|  |_   _| | ____|     / ___|  |_ _| | \\ | |     |  \\/  |  / _ \\  \\ \\   / / |_ _| |  \\/  | |_ _| | ____| | \\ | | |_   _|  / _ \\  / ___| \n" +
"   | |   |  _|       | | | | | | | | |  _|   | | | |   / _ \\   \\___ \\    | |   |  _|       \\___ \\   | |  |  \\| |     | |\\/| | | | | |  \\ \\ / /   | |  | |\\/| |  | |  |  _|   |  \\| |   | |   | | | | \\___ \\ \n" +
"   | |   | |___      | |_| | | |_| | | |___  | |_| |  / ___ \\   ___) |   | |   | |___       ___) |  | |  | |\\  |     | |  | | | |_| |   \\ V /    | |  | |  | |  | |  | |___  | |\\  |   | |   | |_| |  ___) |\n" +
"   |_|   |_____|      \\__\\_\\  \\___/  |_____| |____/  /_/   \\_\\ |____/    |_|   |_____|     |____/  |___| |_| \\_|     |_|  |_|  \\___/     \\_/    |___| |_|  |_| |___| |_____| |_| \\_|   |_|    \\___/  |____/ \n" +
"                                                                                                                                                                                                            \n" +
"");
            
            
//            System.out.println("__________________________________________________ __________________________________________________ _______________________________\n" +
//"__________________________________________________ ________(¾@¾¾¾¾¾¾¾¾@h__________________________________________________ __________\n" +
//"__________________________________________________ __3¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾/__________________________________________________ ____\n" +
//"_______________________________________'!/(4R$/;%¾¾¾@@¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾@¾¾0__________________________________________________\n" +
//"______________________________`_d@¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾%3*11*1**11/1+%¾¾¾¾¾¾¾¾¾¾¾¾d______________________________________________\n" +
//"_________________________`¨`¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾1****111111111111@@¾¾¾¾¾¾¾¾¾@¾+_________________________________________\n" +
//"_____________________`__`¾¾¾¾¾¾¾¾¾¾@1`__________`_'6¾@@¾¾¾¾¾@**1*111111111///11(¾@¾¾¾¾¾¾¾¾¾¾¾(_____________________________________\n" +
//"______________________¾¾¾¾¾¾¾¾¾_`_______________________¾¾¾¾¾¾@*1*1111111111////////h¾¾¾@¾¾¾¾¾¾¾¾¾0'_______________________________\n" +
//"___________________`¾@@¾¾¾¾0______________________________#¾¾¾¾¾R11111111111///////++/+/0¾¾¾¾¾¾¾¾¾¾¾¾0_____________________________\n" +
//"__________________d¾¾¾¾@(__________________________________`(%¾¾@¾11111111111/////////+/))+))0¾¾¾¾¾¾¾¾¾____________________________\n" +
//"_________________¾¾¾¾¾(_____________________________________``¾¾¾¾¾@**1111111/////////++++++))))3)#¾¾¾¾¾R'_________________________\n" +
//"_______________!¾¾¾@@__________________________________________3¾¾¾¾@*1111111//////////+++++)))))33(¾¾¾¾¾!'________________________\n" +
//"______________`¾¾¾¾(_____________________________________________@¾¾@@1111111//////////+++++)))))3333¾¾¾¾@\"\"'______________________\n" +
//"______________¾¾¾@T_______________________________________________@@¾¾1111111/////////++++++)))))3333#¾¾¾¾¾!\"''____________________\n" +
//"_____________¾¾¾¾;`_______________________________________________`¾¾¾¾/11111/////////+++++++)33))333(@¾¾¾¾i__''___________________\n" +
//"____________!¾¾¾@_________________________________________________`@¾¾@)11111//////++%@¾¾¾¾¾¾¾¾@¾¾¾%@)(@¾¾¾¾;!_\"'__________________\n" +
//"____________¾¾¾¾`_`!¾¾@¾¾¾¾¾¾@d____________________________________`¾¾¾¾1/111//%¾@¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾@¾¾¾¾¾i;!_''_________________\n" +
//"__________`'¾¾¾%_¾@¾¾¾¾¾¾¾¾¾¾¾¾¾¾i`_________________________________¾¾¾¾*111@¾¾¾¾¾¾¾¾¾¾¾@#!_______!@¾¾¾¾¾¾¾¾3i!_\"'_________________\n" +
//"___________¾¾¾¾@¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾@``_______________________________1¾¾¾h*¾¾¾@¾¾¾¾@__________________@@¾¾¾¾¾¾i;!_\"'________________\n" +
//"__________`¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾T`______________________________`¾¾¾¾¾¾¾¾¾$________________________¾¾¾¾¾¾Ti;!_''_______________\n" +
//"___________¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾@¾¨_______________________________¾¾¾¾¾¾¾d___________________________@¾¾¾¾%Ti!_\"'_______________\n" +
//"__________6¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾`______________________________¾¾¾¾¾¾__________________%¾¾¾¾¾_____!¾¾¾¾¾Ti;!\"'_______________\n" +
//"__________@¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾@*______________________________¾¾¾¾¾_________________`¾¾¾¾¾¾¾¾_____¾¾¾¾¾@T;!_\"'______________\n" +
//"__________¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾______________________________¾¾¾¾`_________________`¾¾¾¾¾¾¾¾_____*¾¾¾¾¾Ti;!\"'______________\n" +
//"__________¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾_____________________________%¾¾¾'__________________`¾¾¾¾¾¾¾¾______@¾¾¾¾¾i;!_'______________\n" +
//"__________¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾@@_____________________________@¾¾¾____________________!¾¾¾¾¾¾h______¾¾¾¾@@Ti!_\"'_____________\n" +
//"__________@¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾@______________________________¾¾¾¾_______________________!;_________T¾¾¾¾¾¾T;!_''____________\n" +
//"__________¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾______________________________¾¾¾¾___________________________________¾¾¾¾¾¾ii;_\"'____________\n" +
//"_________T¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾@@``_____________________________¾¾¾¾___________________________________¾¾¾¾¾¾¾i;!_''___________\n" +
//"_________¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾@¾`_______________________________!¾¾¾¾__________________________________¾¾¾¾¾¾@Ti!_\"'___________\n" +
//"________`¾¾¾¾¾@¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾/__________________________________¾¾¾¾¾_________________________________%¾¾¾¾¾¾4T;!_''__________\n" +
//"_________¾¾¾@d;¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾@¨`___________________________________@¾¾¾¾¾`_______________________________i¾¾¾¾¾¾¾Ti!_\"'__________\n" +
//"________+¾¾¾¾*;!i@¾¾¾¾¾¾¾¾¾¾¾@¾¾¾#__________________________________@@¾¾¾¾¾@'______________________________`¾¾¾¾¾¾¾Ti;!\"'__________\n" +
//"________%¾¾¾¾;i;;i!;T¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾%¾¾%i`_`____________\"¾¾¾¾¾¾#¾@¾¾¾¾______________________________0¾¾¾¾¾¾*T;!_\"'_________\n" +
//"________¾¾¾¾¾i;iiiii;¾¾¾¾___1%¾@¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾0R33#%¾¾¾¾¾¾¾¾¾T__\"@¾¾¾¾¾@___________________________@¾¾¾¾¾¾RTi!_\"'_________\n" +
//"________¾@¾¾¾iiiiiiii¾¾¾¾________________';h@¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾h_______¾¾¾¾¾¾¾¾¾¾¾¾d1'____!3@¾¾¾¾4______¾¾¾¾¾¾¾@Ti;!\"'_________\n" +
//"________@¾¾¾¾iiiiiiii¾¾¾¾____________________)¾¾@¾h¾¾¾¾¾¾¾¾¾¾¾¾@___________¾¾¾¾¾¾¾¾¾¾¾¾¾¾@¾¾¾¾¾¾¾@¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾*i;!_\"'________\n" +
//"________%¾¾¾¾iiiiiiii¾¾¾¾____________________)¾¾¾¾_________________________¾¾¾¾____%¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾6¾¾¾¾¾*Ti!_\"'________\n" +
//"________1¾¾¾¾1iiiiiTT¾¾¾@____________________)¾¾¾¾_________________________¾¾¾¾____________________¾¾¾@0¾@%4444@¾¾¾@*Ti!_\"'________\n" +
//"_________¾¾¾¾%iiiiiii¾¾¾@____________________)¾¾¾¾_________________________¾¾¾¾____________________¾¾¾@$$$$4444¾¾¾¾%*Ti;_\"'________\n" +
//"_________@¾¾¾¾TiiTTTT@¾¾¾____________________)¾¾¾¾_________________________¾¾¾¾____________________¾¾¾@$$$$4446¾¾¾¾(*Ti;_\"'________\n" +
//"_________¾@¾¾¾TTTTTTT(¾¾¾#___________________)¾¾¾¾_________________________¾¾¾¾____________________¾¾¾¾$44444$¾¾¾¾¾/*Ti;_\"'________\n" +
//"_________`¾¾¾¾¾TTTTTTT@¾¾¾___________________)¾¾¾¾_________________________¾¾¾¾____________________¾¾¾¾$444444¾¾¾¾@/*Ti!_\"'________\n" +
//"__________¾¾¾¾¾TTTTTTT6¾¾¾¾__________________)¾¾¾¾_________________________¾¾¾¾____________________¾¾¾¾4444446¾¾¾¾%**Ti!_\"'________\n" +
//"___________¾¾¾¾RiTTTTT*¾@¾¾¾_________________)¾¾¾¾_________________________¾¾¾¾____________________¾¾¾¾444444¾¾¾¾¾11*i;!_\"'________\n" +
//"___________¾¾¾¾@TTTTTTT*@¾¾@¾________________)¾¾¾¾_________________________¾¾¾¾____________________¾¾¾@$4444@¾¾¾¾01*Ti;!\"'_________\n" +
//"____________¾¾¾¾¾**TT***T@@¾¾¾_______________)¾¾¾¾_________________________¾¾¾¾___________________!¾¾¾d44444¾¾¾¾@11*Ti!_\"'_________\n" +
//"____________1¾¾¾¾%*******1%@%¾¾$_____________)¾¾¾¾_________________________¾¾¾¾___________________#¾¾@44444@¾¾¾¾/11*i;!_\"__________\n" +
//"_____________¾¾¾¾¾(******i*4@¾¾@@____________)¾¾¾¾_________________________¾¾¾¾___________________¾¾¾¾$444@¾¾¾¾$11*Ti!_\"'__________\n" +
//"______________¾¾¾¾@(*******1*@¾¾¾d¾!_________)¾¾¾¾_________________________¾¾¾¾___________________¾¾¾¾446¾¾¾¾@311*Ti;!\"'___________\n" +
//"_______________¾¾¾¾@3********1+¾¾¾¾¾@)_______)¾¾¾¾_________________________¾¾¾¾__________________¾¾¾¾#4@¾¾¾¾¾+/1*Ti;!_\"'___________\n" +
//"________________¾¾¾¾@%*******1113¾@¾¾¾¾¾_____)¾¾¾¾_________________________¾¾¾¾_________________¾¾¾¾¾h@¾¾¾¾@/11**i;!_\"'____________\n" +
//"________________`@@¾¾@¾1*1111111111@@¾¾¾¾¾¾;_)¾¾¾¾_________________________¾¾¾¾________________¾¾¾¾¾¾¾¾¾¾¾d/11*Ti;!_\"'_____________\n" +
//"_________________`@¾¾¾@%*1111111111**(@¾¾¾¾¾@¾¾¾¾¾_________________________¾¾¾¾______________@¾¾@¾¾¾¾¾¾¾¾//11*Ti;!_\"'______________\n" +
//"__________________'R¾¾¾¾¾0111111111111//4¾¾¾¾¾¾¾¾¾_________________________¾¾¾¾___________¾@¾¾¾¾¾¾¾¾¾¾¾$1/**TTi;!_\"'_______________\n" +
//"___________________`¨¾¾¾¾@¾*1111111111///**d@¾¾¾¾¾_________________________¾¾¾@136%¾@¾¾¾¾¾¾¾¾¾¾%¾¾¾¾¾¾+/11*Ti;!_\"\"'________________\n" +
//"____________________``%¾¾¾¾¾%///11///////////6¾¾¾¾_________________________¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾@0(¾¾¾¾¾@)+11**Ti;!_\"''_________________\n" +
//"____________________```4¾¾¾¾¾¾+/1////////////6¾¾¾¾_________________________¾¾¾¾¾¾¾¾@¾¾¾@#44$R¾¾¾¾¾¾+111*Tii;__\"'___________________\n" +
//"______________________```@¾¾¾¾¾¾*////////////6¾¾¾¾_________________________¾¾¾¾(((($$$$$$$4h¾¾¾¾@0//1**Ti;!_\"'_____________________\n" +
//"_______________________``'¨¾¾¾¾¾¾@1//////////6¾¾¾¾_________________________¾¾¾¾(($$$$$$44$¾¾¾¾¾¾//11*Ti;!_\"\"'______________________\n" +
//"_________________________``¨/¾¾¾¾@¾@+////////6¾¾¾¾_________________________¾¾¾¾($$$$$$$$$¾¾¾¾¾@/+11*Ti;!_\"''_______________________\n" +
//"__________________________```'i@¾¾¾¾¾¾¾/+/+++6¾¾¾¾_________________________¾¾¾¾($$$$$$4h@¾¾¾¾R//1*TTi!!_\"'_________________________\n" +
//"____________________________``¨'4¾¾¾¾¾¾¾¾¾3/)6¾¾¾@___________________$@¾@¾¾¾¾¾¾$$$$444@¾¾¾¾¾1/11*Ti;!_\"\"'__________________________\n" +
//"_____________________________```¨'\"¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾$ $$4$4$¾¾¾¾@¾/+1**Ti;!_\"'____________________________\n" +
//"_______________________________``¨¨¨'_¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾@@@% %¾@¾¾¾¾¾¾//1**Ti;!_\"'_____________________________\n" +
//"________________________________````¨''\"_3@¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾¾ ¾¾¾¾¾@311**Ti;!_\"\"'______________________________\n" +
//"__________________________________````¨¨''\"\"\"!R@¾¾¾¾¾¾¾$111***1****TTTT*6¾¾¾¾¾¾¾¾¾¾¾ ¾¾11***Ti;!!_\"'________________________________\n" +
//"___________________________________``````¨'''\"__!!i;iiiiiTTTTTiiiiii;;iiiiiiTiiT*i*T* TTTTii;;!_\"''_________________________________"); 
    }
    }
    
    
}
