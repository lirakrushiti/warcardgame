/* Klasa WarLogic permban logjiken e lojes duke perfshire edhe metodat e ndryshme get dhe set
 * dhe gjithashtu metoda te tjera te nevojshme
 * 
 */
import java.awt.image.BufferedImage;
import java.util.ArrayList;
   
public class WarLogic {
     private ArrayList<Card> p1Hand, p2Hand;   //Arraylistat e secilit lojtare
     private Deck deck = new Deck();           //inicializimi i Deck-ut
     String rWinner="";                        //Stringu qe percakton fituesin
     Card p1Card;                              //Karta e lojtarit te pare qe largohet nga ArrayListi
     Card p2Card;                              //Karta e lojtarit te pare qe largohet nga ArrayListi                     
     boolean isWar = false;                    //Vlere qe ndyshon ne baze se a eshte War apo jo
     int p1Handsize;                           //sa karta ka lojtari i pare;
     int p2Handsize;                           //sa karta ka lojtari i pare;
     public WarLogic()
     {
        p1Hand = new ArrayList<>();
        p2Hand = new ArrayList<>();
         
        deck = new Deck();
        
        dealCards();
     }
     
    
     public Card getP1Card()     //kthen karten  qe largohet nga lojtari i pare
     {     
    	p1Card = p1Hand.remove(0);
    	return p1Card;   
     }
     
     public Card getP2Card()    //kthen karten  qe largohet nga lojtari i dyte
     {     
    	p2Card = p2Hand.remove(0);
    	return p2Card; 
     }
     public String roundWinner() // kthen si string fituesin e secilit rund
     {
    	 return rWinner;
     }
     
     private void dealCards()   //ndan Deck-un ne karta per te dy lojtaret
     {
        for (int i=0; i<52; i++)
        {
            if (i%2 == 0)
                p1Hand.add(deck.dealTopCard());
            else
                p2Hand.add(deck.dealTopCard());             
        }
     }
     
     public int getP1size()  // kthen numrin e kartave te lojtarit te pare
     {
    	 return p1Handsize;
     }
     public int getP2size() // kthen numrin e kartave te lojtarit te dyte
     {
    	 return p2Handsize;
     }
     
     public String getWinner() // kthen fituesin e lojes
     {
         if (p1Hand.isEmpty())
             return "player 2";
         else 
             return "player 1";
     }
     
     public boolean gameOver() //kthehet true kur perfundon loja(njeri nga lojtaret mbet pa karta)
     {
         return p1Hand.isEmpty() || p2Hand.isEmpty();
     }

     public void playHand(String p1 , String p2) //logjika e lojes
     {  
        if (!gameOver())
        {   
           p1Card =getP1Card();
           p2Card = getP2Card();

            rWinner = "";
            p1Handsize = p1Hand.size()+1;
            p2Handsize = p2Hand.size()+1;
            System.out.printf("Player 1: %s total cards: %d\t\tPlayer 2: %s total cards: %d%n", p1Card, p1Hand.size()+1, p2Card, p2Hand.size()+1);
            
            if (p1Card.getCardValue() > p2Card.getCardValue())  //merr kartat ne tavoline lojtari i pare
            { 
            	
                p1Hand.add(p1Card);
                p1Hand.add(p2Card);
                rWinner = p1 +" WINS THIS ROUND" ;
                isWar = false;
                
                
            }
            else if (p2Card.getCardValue() > p1Card.getCardValue()) //merr kartat ne tavoline lojtari i dyte
            {
                p2Hand.add(p1Card);
                p2Hand.add(p2Card); 
                System.out.println("p2 wins this round");
                rWinner = p2 +" WINS THIS ROUND" ;
                isWar=false;
                
            }
            else   //vlera e kartave te te dyve eshte e njejte keshtu qe eshte lufte , dhe vazhdojme me logjiken tjeter
            {
            	isWar = true;
               System.out.printf("%n%n~~~~~~~~~~~~ WAR ~~~~~~~~~~~~~~~ %n%n");
                ArrayList<Card> warPile = new ArrayList<>();
                warPile.add(p1Card);
                warPile.add(p2Card);
                playWarHand(warPile,p1,p2);
                
                rWinner = "WAR";
                
            } 
        }         
        
     }
    
     public boolean isWar() // kthen se a eshte War apo jo
     {
    	 return isWar;
     }
     private void playWarHand(ArrayList<Card> warPile,String p1,String p2)    //logjika e lojes kur behet War         
     {
         if (p1Hand.size() < 3)  //a ka karta te mjaftueshme per lojtarin e pare
         {
             p2Hand.addAll(p1Hand);
             p1Hand.removeAll(p1Hand);
         }
         else if (p2Hand.size() < 3) //a ka karta te mjaftueshme per lojtarin e dyte
         {
             p1Hand.addAll(p2Hand);
             p2Hand.removeAll(p2Hand);
         }
         else   //te dy lojtaret kan karta te mjaftueshme
         {
             warPile.add(p1Hand.remove(0));
             warPile.add(p1Hand.remove(0));
             warPile.add(p2Hand.remove(0));
             warPile.add(p2Hand.remove(0));
             
             Card p1Card = p1Hand.remove(0);
             Card p2Card = p2Hand.remove(0);
             
             if (p1Card.getCardValue() > p2Card.getCardValue())   //merr kartat ne tavoline lojtari i pare
            {
                p1Hand.add(p1Card);
                p1Hand.add(p2Card);
                p1Hand.addAll(warPile);
                rWinner = p1 +" WINS THIS ROUND" ;
            }
            else if (p2Card.getCardValue() > p1Card.getCardValue())  //merr kartat ne tavoline lojtari i dyte
            {
                p2Hand.add(p1Card);
                p2Hand.add(p2Card);    
                p2Hand.addAll(warPile);
                rWinner = p2 +" WINS THIS ROUND" ;
            }
            else   //eshte luft dhe kthehemi perseri tek playWarHand.
            {
                warPile.add(p1Card);
                warPile.add(p2Card);
                playWarHand(warPile,p1,p2); 
                rWinner = "WAR";
            }
        }
    }
}
