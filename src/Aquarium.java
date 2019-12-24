import com.sun.xml.internal.ws.api.server.Adapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Aquarium extends JFrame {
    private Container cp;
    private Image img= Toolkit.getDefaultToolkit().getImage("海底世界3.png" );
    private JPanel jpn;
    private JPanel ctlPane =new JPanel(new GridLayout(1,3,1,1));
    private JButton add=new JButton("Add");
    private JButton feed=new JButton("Feed");
    private JButton exit=new JButton("Exit");
    private ArrayList<Fish> fishList=new ArrayList<Fish>();

public Aquarium(){
    init();
}

private void init(){
    cp=this.getContentPane();
    cp.setLayout(new BorderLayout(1,1));
    jpn=new JPanel(){
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img,0,0,null);
            this.repaint();
        }
    };
    jpn.setLayout(null);
    cp.add(jpn,BorderLayout.CENTER);
    pack();
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    this.setBounds(50,50,1200,700);
    this.setResizable(false);
    ctlPane.add(add);
    ctlPane.add(feed);
    ctlPane.add(exit);
    cp.add(ctlPane,BorderLayout.SOUTH);

    add.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Fish tmpFish =new Fish();
            fishList.add(tmpFish);
            jpn.add(tmpFish);
            tmpFish.run();
        }
    });
    exit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });
    feed.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });


}
}
