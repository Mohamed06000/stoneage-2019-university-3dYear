package  stoneage ;

import stoneage.partie.Partie;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * Classe du lacement du Jeu
 */
public class Main {
    public  static  final  void main(String[] args){

        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


       // Partie partie = new Partie(2) ;
        //partie.jouer() ;

        Partie partie;
        partie = new Partie(2,false) ;
        partie.jouer() ;

  //      System.out.println("Simulation 500 parties");
  //      for (int i = 0; i < 500; i++) {
   //         partie = new Partie(2, false);
   //         partie.jouer();
    //    }
    }
}