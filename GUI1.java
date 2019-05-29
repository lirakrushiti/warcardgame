/* Klasa GUI1 merret me paraqitjen ne dritaren grafike me ane te JFrame, JPanel , JButton dhe JLabel
 * duke perdorur metoda nga klase te tjera per te bere paraqitjen e deshiruar
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GUI1  {
	  Dimension scSize = Toolkit.getDefaultToolkit().getScreenSize(); //merr madhesine e ekranit
	 
      JFrame frame = new JFrame(); //korniza
      
      JPanel panel= new JPanel();  //paneli
      
      JButton deal = new JButton(); //butoni Deal qe hedh kartat nga te dy lojtaret
      JButton exit = new JButton(); //butoni exit qe e mbyll lojen 
      
      JLabel p1label = new JLabel();  //paraqitja grafike e kartes se lojtarit te pare
      JLabel p2label = new JLabel();  //paraqitja grafike e kartes se lojtarit te dyte
      JLabel p1Cardbg = new JLabel(); //formesimi i kartes se lojtarit 1
      JLabel p2Cardbg = new JLabel(); //formesimi i kartes se lojtarit 2
      JLabel winlabel = new JLabel("" , SwingConstants.CENTER);  // tekst per fituesin  e secilit rund
      JLabel bg = new JLabel();        //mbrapavija si foto
      JLabel p1Title = new JLabel("Player 1",SwingConstants.CENTER); //Emri i lojtarit te pare
      JLabel p2Title = new JLabel("Player 2",SwingConstants.CENTER); //Emri i lojtarit te dyte
      JLabel p1Stack = new JLabel();  //paraqitja grafike e kartave te kthyera mbrapsht te lojtarit te pare
      JLabel p2Stack = new JLabel(); //paraqitja grafike e kartave te kthyera mbrapsht te lojtarit te dyte
      JLabel logo = new JLabel();   //logoja e lojes ne mes
      JLabel p1num = new JLabel();  //numri i kartave te lojtarit te pare
      JLabel p2num = new JLabel();  //numri i kartave te lojtarit te dyte  
      private int width = scSize.width; //gjeresia e ekranit
      private int height = scSize.height; //gjatesia e ekranit
      Deck deck = new Deck();   //thirrja e klases deck 
      boolean pressed = false;     //a eshte shtypur butoni Deal
   	private Icon cardBg;    //fotoja per formesimin e kartave
      public GUI1()
      {
    	  //frame
    	  frame.setSize(width, height);
    	  frame.setResizable(false);   //dimensionet e dritares nuk mund te ndryshohet nga perdoruesi
    	  frame.setTitle("WarGame");
    	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //Fillon me gjeresi dhe gjatesi maksimale
    	  frame.setUndecorated(true);  //Paraqitja pa kornize te dukshme (Full screen)
    	//BackGround  
    	  try {
			bg.setIcon(new ImageIcon(ImageIO.read(new File("bg.png")))); //merr mbrapavijen nga folderi i projektit
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//  bg.setSize(1280,720);
    	  bg.setBounds(0,0,1366,768);  //pjesa ku paraqitet fotoja
    	  bg.setVisible(true);         
 
    	//panel  
 	  panel.setSize(width,height);
  	  panel.setLayout(null);   //vendosja e elementeve ne panel ne menyre manuale
  	
  	  //DealButton
   	  deal.setText("Deal");
	  deal.setForeground(Color.white);
   	  deal.setOpaque(false);
   	  deal.setContentAreaFilled(false);
 	  deal.setBounds(width/2-50, height-60, 100, 30); 	//pjesa ku paraqitet Butoni
 	  
 	  //Exit Button
 	  exit.setBackground(Color.darkGray);    //ngjyra e kutise se butonit
 	  exit.setForeground(Color.white);       //ngjyra e tekstit
 	  exit.setText("Exit");
 	  exit.setBounds(width-(width/10),height/20,60 , 20);  //pozicioni
 	  exit.addActionListener(new ActionListener(){         //tregon se qfare ndodhe kur te shtypet butoni Exit
 	  		public void actionPerformed(ActionEvent e) {
    	  	       System.exit(0);                        //mbyll programin
    	  	      
    	  	  		}
    	  	  		});
 	  
 	  warLogo();               //thirret logoja
        //ads - ketu shtohen te gjitha elementet ne panel ne menyre qe te paraqiten
 	  panel.add(p1label);
 	  panel.add(p2label);
 	  panel.add(p1Cardbg);
 	  panel.add(p2Cardbg);
	  panel.add(deal);
	  panel.add(p1Title);
	  panel.add(p2Title);
	  panel.add(p1Stack);
	  panel.add(p2Stack);
	  panel.add(exit);
	  panel.add(p1num);
	  panel.add(p2num);
	  panel.add(winlabel);
	  panel.add(logo);
	  panel.add(bg);
	  frame.add(panel);  //shton panelin ne frame qe te paraqitet;
      frame.setVisible(true);    //ben qe frami te shfaqet
      }

      public void player1Title(String s)   //paraqitja e emrit te lojtarit te pare si text
      {
    	  p1Title.setText(s);
    	  p1Title.setFont(new Font("Monospaced",Font.PLAIN,20));  //fonti dhe madhesia
    	  p1Title.setForeground(Color.white);                     //ngjyra e tekstit
    	  p1Title.setBounds(width/2-250,height/6+238,170, 30);    //pozicioni
    	  p1Title.setVisible(true);
    	  
      }
      public void player2Title(String s)   //paraqitja e emritte lojtarit te dyte si text
      {
    	  p2Title.setText(s);
    	  p2Title.setFont(new Font("Monospaced",Font.PLAIN,20));  // ndryshimi i fontit dhe madhesise 
    	  p2Title.setForeground(Color.white);                     //ngjyra e tekstit
    	  p2Title.setBounds(width/2+50,height/2-95,170, 30);      //pozicioni
    	  p2Title.setVisible(true);
    	  
      }
      public void player1Label(BufferedImage image,boolean test)   //paraqitja e kartes momentale te lojtarit te pare
      {   
    	  p1label.setIcon(new ImageIcon(image));              //merr foton
    	  p1label.setBounds(width/2-250,height/6, 170, 238);//pozicioni
          p1label.setVisible(test);
      }
    
      public void player2Label(BufferedImage image,boolean test)   //paraqitja e kartes momentale te lojtarit te dyte
      {   
    	  p2label.setIcon(new ImageIcon(image));                //merr foton
    	  p2label.setBounds(width/2+90,height/2-50, 170, 238);  //pozicioni  
          p2label.setVisible(test);
      }
      
      public void player1CardBg(boolean test )     //paraqitja e fotos qe e ben formesimin e kartes se lojtarit te pare
      {    
	try {
		 cardBg = new ImageIcon(ImageIO.read(new File("CardBg.png"))); // marrja e fotos
	} catch (IOException e) {
		e.printStackTrace();
	}
    	  p1Cardbg.setIcon(cardBg);                                    //vendosja e fotos
    	  p1Cardbg.setBounds(width/2-250-2,height/6-10, 176, 255);     //pozicioni
    	  p1Cardbg.setVisible(test);
    	  
    
      }
      public void player2CardBg(boolean test)   //paraqitja e fotos qe e ben formesimin e kartes se lojtarit te dyte
      {    
	try {
		 cardBg = new ImageIcon(ImageIO.read(new File("CardBg.png")));  //marrja e fotos
	} catch (IOException e) {
		e.printStackTrace();
	}
    	  p2Cardbg.setIcon(cardBg);                                     //vendosja e fotos
    	  p2Cardbg.setBounds(width/2+90-2,height/2-60, 176, 255);       //pozicioni
    	  p2Cardbg.setVisible(test);
    	  
      }
      public void warLogo()     //paraqitja e logos se lojes ne mes
      {
    	  try {
			logo.setIcon( new ImageIcon(ImageIO.read(new File("Logo.png"))));  //marrja dje vendosja e fotos
		} catch (IOException e) {
			e.printStackTrace();
		}
    	  
    	  logo.setBounds(width/2-200,height/2-200, 400, 400);      //pozicioni
      }
      
      public void p1CardsLabel(int n,boolean test)   //paraqitja e numrit te kartave te mbeture te lojtarit te pare si tekst
      {
    	  p1num.setText(n+" CARDS");                             
    	  p1num.setBounds(50, 500, 200, 100);                   //pozicioni
    	  p1num.setFont(new Font("Monospaced",Font.PLAIN,15));  //percaktimi i fontit dhe madhesia e tekstit
    	  p1num.setForeground(Color.white);                     //ngjyra e tekstit
    	  p1num.setVisible(test);
    	  
      }
         
      public void p2CardsLabel(int n,boolean test)    //paraqitja e numrit te kartave te mbeture te lojtarit te dyte si tekst
      {
    	  p2num.setText(n+" CARDS");
    	  p2num.setBounds(1200, 500, 200, 100);                 //pozicioni
    	  p2num.setFont(new Font("Monospaced",Font.PLAIN,15));  //percaktimi i fontit dhe madhesia e tekstit
    	  p2num.setForeground(Color.white);                     //ngjyra e tekstit
    	  p2num.setVisible(test);
      }
      
      public void p1StackLabel(int n)   //paraqitja e kartave te kthyera mbrapsht te lojtarit te pare
      { int i=0;
      //ben nderrimin e fotos ne baze te numrit te kartave qe jane te kthyera mbrapsht
      if (n>=40&&n<=52) i=5;         
      else if (n>=30&&n<40) i=4;
      else if (n>=20&&n<30) i=3;
      else if (n>=10&&n<20) i=2;
      else if (n>=0&&n<10) i=1;
    	  
    	
    	  try {
  			p1Stack.setIcon( new ImageIcon(ImageIO.read(new File(i+"p1Stack.png"))));  //marrja dhe vendosja e fotos
  		} catch (IOException e) {
  			e.printStackTrace();
  		}
      	  
      	  p1Stack.setBounds(0, 150, 400, 400);  //pozicione
      }
      public void p2StackLabel(int n)   //paraqitja e kartave te kthyera mbrapsht te lojtarit te dyte
      {
    	  
    	  int i=0;
    	//ben nderrimin e fotos ne baze te numrit te kartave qe jane te kthyera mbrapsht
          if (n>=40&&n<=52) i=5;
          else if (n>=30&&n<40) i=4;
          else if (n>=20&&n<30) i=3;
          else if (n>=10&&n<20) i=2;
          else if (n>=0&&n<10) i=1;

    	  try {
  			p2Stack.setIcon( new ImageIcon(ImageIO.read(new File(i+"p2Stack.png"))));  //marrja dhe vendosja e fotos
  		} catch (IOException e) {
  			e.printStackTrace();
  		}
      	  
      	  p2Stack.setBounds(width-340, 150, 400, 400);    //pozicioni
      }
      
      
      
      public void roundWinner(String s)   //paraqitja e fituesit te secilit rund si tekst
      {
    	  winlabel.setText(s);
    	  winlabel.setFont(new Font("Monospaced",Font.PLAIN,40));  //ndryshimi i fontit dhe madhesise se tekstit
    	  winlabel.setForeground(Color.white);    //ngjyra e tekstit
          winlabel.setBounds(0,height-150,width,100);   //pozicioni
    	  winlabel.setVisible(true);   
      }
      public boolean buttonPressed()  // kthen boolean se a eshte shtypur butoni deal apo jo
      {   
    	  pressed = false;

           deal.addActionListener(new ActionListener(){         //tregon se qfar ndodh kur te shtyper butoni Deal
      	  		public void actionPerformed(ActionEvent e) {
        	  	       pressed=true;
        	  	  		}
        	  	  		});
                return pressed;
           
      }
}
