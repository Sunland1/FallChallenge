import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {


	/*On teste si la recette est faisable et est aventageuse en Rubis*/
    public static void recetteAventageuse(ArrayList<ArrayList<Integer>> recette , ArrayList<Integer> tab_inv){
        ArrayList<Integer> max = new ArrayList<Integer>(2) ;
        max.add(0,-1) ; 
        max.add(1,-1) ; 
        for(int i = 0; i< recette.size() - 1 ; i++ ){
            int j = 0 ; 
            while( j < 4  && tab_inv.get(j) - recette.get(i).get(j) >= 0 ){
                j++ ; 
            }
            if( j == 4 && max.get(0) < recette.get(i).get(4) ) {
                max.set(0, recette.get(i).get(4)) ;
                max.set(1, recette.get(i).get(5)) ; 
            }
        }
        System.out.println("BREW " + max.get(1) );





    }



    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> tab_inv = new ArrayList<Integer>(4);
        // game loop
        while (true) {
            int actionCount = in.nextInt(); // the number of spells and recipes in play
            ArrayList<ArrayList<Integer>> recette = new ArrayList<ArrayList<Integer>>(actionCount);
            for (int i = 0; i < actionCount; i++) {
                ArrayList<Integer> tab = new ArrayList<Integer>(6);
                int actionId = in.nextInt(); // the unique ID of this spell or recipe

                String actionType = in.next(); // in the first league: BREW; later: CAST, OPPONENT_CAST, LEARN, BREW

                int delta0 = in.nextInt(); // tier-0 ingredient change
                int delta1 = in.nextInt(); // tier-1 ingredient change
                int delta2 = in.nextInt(); // tier-2 ingredient change
                int delta3 = in.nextInt(); // tier-3 ingredient change
		
		/*Stockage des recette */
                int price = in.nextInt(); // the price in rupees if this is a potion
                tab.add(0,delta0) ; 
                tab.add(1,delta1) ; 
                tab.add(2,delta2) ; 
                tab.add(3,delta3) ;
                tab.add(4,price) ; 
                tab.add(5,actionId) ;  

                recette.add(tab) ; 


                int tomeIndex = in.nextInt(); // in the first two leagues: always 0; later: the index in the tome if this is a tome spell, equal to the read-ahead tax; For brews, this is the value of the current urgency bonus
                int taxCount = in.nextInt(); // in the first two leagues: always 0; later: the amount of taxed tier-0 ingredients you gain from learning this spell; For brews, this is how many times you can still gain an urgency bonus
                boolean castable = in.nextInt() != 0; // in the first league: always 0; later: 1 if this is a castable player spell
                boolean repeatable = in.nextInt() != 0; // for the first two leagues: always 0; later: 1 if this is a repeatable player spell
            }
            for (int i = 0; i < 2; i++) {
                
                tab_inv = new ArrayList<Integer>(4) ;
                int inv0 = in.nextInt(); // tier-0 ingredients in inventory
                int inv1 = in.nextInt();
                int inv2 = in.nextInt();
                int inv3 = in.nextInt();
                int score = in.nextInt(); // amount of rupees
                
                /*Stockage de l'inventaire */
                tab_inv.add(0, inv0 ); 
                tab_inv.add(1, inv1 );
                tab_inv.add(2, inv2 );
                tab_inv.add(3, inv3 );
            

            }
            
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // in the first league: BREW <id> | WAIT; later: BREW <id> | CAST <id> [<times>] | LEARN <id> | REST | WAIT
	    /*Methode qui ma fais passer Bois 1*/
            Player.recetteAventageuse(recette, tab_inv);
        }
    }
}