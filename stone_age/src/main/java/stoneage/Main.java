package  stoneage ;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * Classe du lacement du Jeu .
 */
public class Main {
    public  static  final  void main(String[] args){

        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Partie partie = new Partie(2) ;
        partie.jouer() ;
    }
}