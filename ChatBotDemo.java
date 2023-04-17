import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Desktop;

class Chatbot extends JFrame {

    /**
     *
     */
//    private static final long serialVersionUID = 1L;
    private JTextArea ca= new JTextArea();
    private JTextField cf=new JTextField();
    private JButton b=new JButton();
    private JLabel l=new JLabel();

    Chatbot(){                                                // Layout and Properties defined in Constructer

        JFrame f=new JFrame();
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setResizable(false);
        f.setLayout(null);
        f.setSize(400,400);
        f.getContentPane().setBackground(Color.yellow);
        f.setTitle("ChatBot");
        f.add(ca);
        f.add(cf);
        ca.setSize(390,300);
        ca.setLocation(1, 1);
        ca.setBackground(Color.BLACK);
        cf.setSize(300,20);
        cf.setLocation(1,320);
        f.add(b);
        l.setText("SEND");
        b.add(l);
        b.setSize(90,20);
        b.setLocation(300,320);

        b.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if(e.getSource()==b) {                           // Message sents on Click button

                    String text=cf.getText().toLowerCase();
                    ca.setForeground(Color.white);
                    ca.append("You-->"+text+"\n");
                    cf.setText("");

                    if(text.contains("hi") || text.contains("hello")) {                         // input Checking
                        reply("How can i help you");
                        reply("1.Education");
                        reply("2.Health");
                        reply("3.city You Want to visit");

                    } else if(text.contains("1")) {
                        reply("Have You Completed Your Intermediate");
                    } else if (text.contains("yes")) {
                        reply("In which Field You Are Intersted");
                    } else if (text.contains("no")) {
                        reply("Complete Your intermediate First");

                    } else if(text.contains("2")) {
                        reply("How are you felling");
                    }
                    else if(text.contains("3")){
                        reply("Which city you want to visit");
                        reply("UP");
                        reply("Bihar");
                        reply("Chhatisghar");
                    } else if (text.contains("bihar")) {
                        reply("Welcome TO bihar");
                    }
                    else if(text.contains("up")){
                        reply("Welcome to UP");
                    }
                    else if(text.contains("chhatisghar")){
                        reply("Welcome to Chhatisghar");
                        JLabel linkLabel = new JLabel("<html><a href=\"https://www.example.com\">Visit Example.com</a></html>");

                        // Add a mouse listener to the label
                        linkLabel.addMouseListener(new MouseAdapter() {
                            public void mouseClicked(MouseEvent e) {
                                try {
                                    // Open the link in a browser
                                    Desktop.getDesktop().browse(new java.net.URI("https://www.example.com"));
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }
                        });
                        f.add(linkLabel);add(f);

                    }
                    else {
                        int rand = (int) (Math.random() * 3 + 1);
                        if (rand == 1) {
                            reply("I don't understand");
                        } else if (rand==2) {
                            reply("I Can't Understand");
                        } else if (rand==3) {
                            reply("Please come Later");
                        }


                    }
                }

            }

        });

    }
    public void reply(String s) {                          // Reply Method
        ca.append("Arrya-->"+s+"\n");
    }


}
public class ChatBotDemo {                                     //Driver Class

    public static void main(String[] args) {             //main class

        Chatbot x=new Chatbot();
        x.setVisible(true);// instantiation
    }

}