/*Klasa Card e krijon nje karte me parametrat e nevojshem
 * te cilet me vone do te percaktohen ne klaset e tjera
 */
import java.awt.image.BufferedImage;


public class Card  {
    private String cardName; //Emri
    private String cardSuit; //Lloji
    private int cardValue ; // vlera e kartes si int
    private BufferedImage cardImage;  // fotoja qe di ti percaktohet seciles karte


    public Card(String cName , String cSuit , int cValue , BufferedImage cImage)
    {
        cardName = cName;
        cardSuit = cSuit;
        cardValue=cValue;
        cardImage = cImage;
    }
    public String toString()  //kthen emrin dhe llojin e kartes , kryesisht perdoret per testim
    {
        return cardName + " of "+ cardSuit;
    }
    public int getCardValue()   // Kthen vleren e kartes
    {
        return cardValue;
    }
    public BufferedImage getCardImage()  //kthen foton qe e ka karta
    {
        return cardImage;
    }
   
}

