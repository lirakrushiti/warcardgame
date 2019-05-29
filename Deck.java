/* Klasa Deck ka per detyre formimin e arraylistit te tipit Card , dhe gjithashtu lidhjen e seciles karte
 * me karten perkatese
 * 
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.imageio.ImageIO;

public class Deck {
    private ArrayList<Card> deck;  //ArrayList per te mbajtur kartat ne Deck
    BufferedImage deckImage ;      //Fotoja e madhe e te gjitha kartave
    BufferedImage deckSubImage ;   // Fotoja e seciles karte e prere nga fotoja e madhe
  
    
    public Deck() 
    {           
    	        deck = new ArrayList<>();
                String [] cFacesA = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
                ArrayList<String> cFaces = new ArrayList<String>(Arrays.asList(cFacesA));
                String [] cSuitA = {"Diamonds","Clubs","Hearts","Spades"};
                ArrayList<String> cSuit = new ArrayList<String>(Arrays.asList(cSuitA));
                
                final int rows = 4;
                final int column = 13;
                
                try {
					deckImage = ImageIO.read(new File("card_deckblood2.png"));  //Marrja e fotos nga folderi i projektit
				} catch (IOException e) {
					e.printStackTrace();
				}
                final int cWidth = (int)(deckImage.getWidth()/13);  //gjeresia e kartes qe perdoret gjate prerjes
                final int cHeight = (int)(deckImage.getHeight()/4);  // gjatesia e kartes qe perdoret gjate prerjes
                              
                for(int suit = 0;suit<rows;suit++)
                {
                	for(int face = 0;face<column;face++)
                	{
                		deckSubImage= deckImage.getSubimage(face*cWidth, suit*cHeight, cWidth, cHeight); //subimage(koordinata x , koordinata y , gjeresia , gjatesia)
                		deck.add(new Card(cFaces.get(face),cSuit.get(suit),face+2,deckSubImage));
                	}
                }
                shuffle();
       
    }

    public void displayCards()   //paraqet kartat ne konsole (testim)
    {
    	for(int i=0 ; i<52;i++)
    	{   
    		System.out.println(deck.get(i)+ " , ");
    	}
    }
    public Card getCard(int index) // merr karten ne indeksin e caktuar
    {
    	return deck.get(index);
    }
    
    public ArrayList<Card> shuffle() // ben perzierjen  e kartave 
    {   
    	Collections.shuffle(deck);
    	return deck;
    }
    public int getSizeOfDeck()  // merr madhesine e ArrayListit te Deck-ut
    {
    	return deck.size();
    }
    public Card dealTopCard()   //Merr karten e pare dhe e largon nga ArrayListi
    {
        if (deck.size()>0)
            return deck.remove(0);
        return null;
    }	
}
