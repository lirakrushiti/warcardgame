/* Klasa main (controller) e cila nderlidhe klaset e tjera te programit si p.sh.
 * paraqitja grafike dhe logjika e lojes 
 */

import javax.swing.JOptionPane;
public class WarGame{

public static void main(String[] args)

    {
            WarLogic game = new WarLogic();   //thirrja e klases WarLogic
            GUI1 gui = new GUI1();            //thirrja e klases gui
            
         //  gui.GUI1();
            gui.p1StackLabel(26);      //numri i kartave qe shkruhet ne fillim lojtari i pare
           	gui.p2StackLabel(26);      //numri i kartave qe shkruhet ne fillim lojtari i dyte
           	
           	//kerkimi nga perdoruesi me dritare interaktive emrin e lojtarit te pare dhe te dyte
            String p1String = JOptionPane.showInputDialog("Jepni emrin e lojtarit te pare : ","Player 1").toUpperCase();
            String p2String = JOptionPane.showInputDialog("Jepni emrin e lojtarit te dyte : ","Player 2").toUpperCase();
          
            while(!game.gameOver()) {    //perderisa nuk ka perfunduar loja
            	if(gui.buttonPressed())  //luhet nje rund ne momentin kur shtypet butoni Deal
            	{
            		game.playHand(p1String,p2String);     //Jep emrin e lojtareve dhe e zhvillon logjiken e lojes
            		gui.roundWinner(game.roundWinner());  //Jep emrin e fituesit te secilit rund 
            		
               	gui.player1CardBg(true);   //aktivizon paraqitjen e metodes qe ben formesimin  e kartave te lojtarit te pare
               	gui.player2CardBg(true);   //aktivizon paraqitjen e metodes qe ben formesimin  e kartave te lojtarit te dyte
               	
               	gui.player1Label(game.p1Card.getCardImage(),true);   //aktivizon paraqitjen e kartes momentale te lojtarit te pare
               	gui.player2Label(game.p2Card.getCardImage(),true);   //aktivizon paraqitjen e kartes momentale te lojtarit te dyte
               	
               	gui.p1StackLabel(game.getP1size());  //aktivizon paraqitjen  e kartave te kthyera mbrapsht te lojtarit te pare
               	gui.p2StackLabel(game.getP2size());  //aktivizon paraqitjen e kartave te kthyera mbrapsht te lojtarit te dyte
               	
               	gui.p1CardsLabel(game.getP1size(),true);   //aktivizon paraqitjen  numrit te kartave te mbetura te lojtarit te pare
               	gui.p2CardsLabel(game.getP2size(),true);   //aktivizon paraqitjen numrit te kartave te mbetura te lojtarit te dyte
               	 
               	gui.player1Title(p1String);    //aktivizon paraqitjen e emrit te lojtarit te pare
               	gui.player2Title(p2String);    //aktivizon paraqitjen e emrit te lojtarit te dyte
               	
                //ben qe kur shtypet butoni te kryhet vetem nje rund pershkak se while zhvillohet shum shpejt
               	try {
   					Thread.sleep(10);
               	 	} catch (InterruptedException e) {
   					e.printStackTrace();
   				     }
            	 }
            }
           //nese shtypet butoni per her te fundit
            boolean test = true;
           
          //paraqet mesazhin se kush ka fituar i heq elementet e panevojshme dhe e perfundon lojen
            while(test) {
            	if(gui.buttonPressed())
            {
            
            System.out.printf("The winner is %s%n", game.getWinner());
        	gui.player1Label(game.p1Card.getCardImage(),false);   //deaktivizon paraqitjen e kartes momentale te lojtarit te pare
           	gui.player2Label(game.p2Card.getCardImage(),false);   //deaktivizon paraqitjen e kartes momentale te lojtarit te dyte
           	gui.p1CardsLabel(game.getP1size(),false);   //deaktivizon paraqitjen  numrit te kartave te mbetura te lojtarit te pare
           	gui.p2CardsLabel(game.getP2size(),false);   //deaktivizon paraqitjen  numrit te kartave te mbetura te lojtarit te dyte
           	gui.player1CardBg(false); //deaktivizon paraqitjen e fotos formesuese te lojtarit te pare
        	gui.player2CardBg(false); //deaktivizon paraqitjen e fotos formesuese te lojtarit te pare
           	JOptionPane.showMessageDialog(null,game.getWinner().toUpperCase()+" WINS");  //paraqet mesazhin
           	test = false;
           	
           	System.exit(0);  //perfundon lojen
           	
            
            }
            }
            
    }
}