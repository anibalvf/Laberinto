package laberinto;

import java.util.Scanner;

public class PrincipalLaberinto{
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        Laberinto juego=new Laberinto();
        int selec;
        int[] posicion_jugador=new int[2];
        int movimientos=40;
        int movimientos2=50;
        

        
        char[][] laberinto1={{'#','#','#','#','#','#','#','#','#','#'},
                            {'#',' ',' ',' ','#',' ',' ',' ',' ','#'},
                            {'#',' ','#',' ',' ',' ','#',' ',' ','#'},
                            {'#',' ','#','#',' ','#','#','#',' ','#'},
                            {'#',' ',' ','#',' ',' ','#',' ',' ','#'},
                            {'#',' ','#','#','#',' ','#',' ',' ','#'},
                            {'#',' ','#',' ','#',' ',' ','#',' ','#'},
                            {'#',' ','#',' ','#','#','#',' ',' ','#'},
                            {'#',' ','#',' ',' ',' ',' ',' ','#','#'},
                            {'#','#','#','#','#',' ','#','#','#','#'},
                                                                    };
        
        
        //escanea la posicion del jugador para no tener que meter la posicion a mano
        //pone aleatoria mente al jugador en una posicion asi cada partida sera diferente
        posicion_jugador=juego.posicionAleatoria(laberinto1);
        juego.ponerPosicion(laberinto1, posicion_jugador);
        posicion_jugador=juego.escanearPosicion(laberinto1);
                
        
        char[][] laberinto2={{'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
                             {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
                             {'#',' ','#',' ','#',' ',' ',' ','#','#',' ','#',' ','#','#','#','#',' ','#','#','#'},
                             {'#',' ','#',' ','#','#','#',' ',' ','#',' ',' ',' ','#',' ',' ','#',' ','#',' ','#'},
                             {'#',' ','#','#','#',' ','#','#',' ','#',' ','#','#','#',' ',' ',' ',' ',' ',' ','#'},
                             {'#',' ',' ',' ',' ',' ',' ','#',' ',' ',' ','#',' ','#','#','#','#','#',' ','#','#'},
                             {'#',' ','#',' ','#','#','#','#',' ','#',' ',' ',' ',' ',' ','#',' ','#',' ',' ','#'},
                             {'#','#','#',' ','#',' ',' ',' ',' ','#',' ','#','#','#',' ','#',' ','#','#',' ','#'},
                             {'#',' ',' ',' ',' ',' ','#','#',' ','#','#','#',' ',' ',' ','#',' ',' ','#',' ','#'},
                             {'#','#',' ','#','#',' ','#',' ',' ',' ',' ','#','#','#','#','#',' ',' ','#',' ','#'},
                             {'#',' ',' ','#',' ',' ','#','#',' ','#','#','#',' ',' ','#',' ',' ','#','#',' ','#'},
                             {'#',' ','#','#',' ','#','#',' ',' ','#',' ','#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
                             {'#',' ',' ','#',' ',' ','#','#',' ','#',' ',' ',' ','#','#','#','#',' ','#','#','#'},
                             {'#','#',' ','#',' ',' ',' ','#',' ',' ',' ','#',' ','#',' ',' ','#',' ','#',' ','#'},
                             {'#',' ',' ','#','#',' ','#','#',' ','#',' ','#',' ','#','#',' ','#','#','#',' ','#'},
                             {'#','#',' ',' ','#',' ','#',' ','#','#',' ',' ',' ',' ','#',' ','#',' ',' ',' ','#'},
                             {'#',' ',' ',' ',' ',' ','#',' ',' ',' ',' ','#',' ',' ','#',' ',' ',' ','#',' ','#'},
                             {'#','#','#','#','#','#','#',' ','#','#',' ','#','#','#',' ','#','#',' ','#','#','#'},
                             {'#',' ',' ',' ',' ',' ',' ',' ','#',' ',' ','#',' ',' ',' ','#',' ',' ',' ','#','#'},
                             {'#',' ','#',' ','#',' ','#',' ','#',' ',' ',' ',' ','#',' ',' ',' ','#',' ',' ','#'},
                             {'#','#','#',' ','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}};
                                                                                                                 
                
         juego.mostrarLaberinto(laberinto1);
         System.out.println("numero de movimientos disponibles "+ movimientos);
         
        //Escapar del primer laberinto
   
         
         
         do { 
             juego.movimiento();
             selec= teclado.nextInt();
             switch(selec){
                 case 5:
                     juego.moverArriba(laberinto1, posicion_jugador);
                      juego.mostrarLaberinto(laberinto1);
                     break;
                 case 2:
                     juego.moverAbajo(laberinto1, posicion_jugador);
                      juego.mostrarLaberinto(laberinto1);
                     break;
                 case 1:
                     juego.moverIzq(laberinto1, posicion_jugador);
                      juego.mostrarLaberinto(laberinto1);
                     break;
                 case 3:
                     juego.moverDer(laberinto1, posicion_jugador);
                      juego.mostrarLaberinto(laberinto1);
                     break;    
             
                 default:System.out.println("movimiento no valido, cuidado la proxima has desperdiciado un movimiento");
             }
                 movimientos--;  
                 System.out.println("Movimientos restantes: "+movimientos);
        } while (juego.escapado(laberinto1, posicion_jugador)!=true && movimientos>0);

            
         
        //dibujo final
         juego.salida(juego.escapado(laberinto1, posicion_jugador));
       
        
          //Escapar del segundo laberinto
        if (juego.escapado(laberinto1, posicion_jugador)==true) {
            System.out.println("FASE 2 DESBLOQUEADA");
            
            
            posicion_jugador=juego.posicionAleatoria(laberinto2);
            juego.ponerPosicion(laberinto2, posicion_jugador);
            posicion_jugador=juego.escanearPosicion(laberinto2);
            
            
            
        
       
        juego.mostrarLaberinto(laberinto2);
        
        System.out.println("numero de movimientos disponibles "+ movimientos2+" Y acumulas los anteriores movimientos no gastados "+ movimientos
        +"un total de"+ (movimientos+movimientos2));
        movimientos2= movimientos2+movimientos;
    
    
         do { 
             juego.movimiento();
             selec = teclado.nextInt();
             switch(selec){
                 case 5:
                     juego.moverArriba(laberinto2, posicion_jugador);
                      juego.mostrarLaberinto(laberinto2);
                     break;
                 case 2:
                     juego.moverAbajo(laberinto2, posicion_jugador);
                      juego.mostrarLaberinto(laberinto2);
                     break;
                 case 1:
                     juego.moverIzq(laberinto2, posicion_jugador);
                      juego.mostrarLaberinto(laberinto2);
                     break;
                 case 3:
                     juego.moverDer(laberinto2, posicion_jugador);
                      juego.mostrarLaberinto(laberinto2);
                     break;    
             
                 default:System.out.println("movimiento no valido, cuidado la proxima has desperdiciado un movimiento");
             }
                 movimientos2--;  
                 System.out.println("Movimientos restantes: "+movimientos2);
        } while (juego.escapado(laberinto2, posicion_jugador)!=true && movimientos2>0);

    
    
    
     juego.salida(juego.escapado(laberinto2, posicion_jugador));
    
    }
    
    }
    
    
    
}
