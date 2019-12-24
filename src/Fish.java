import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Fish extends JLabel implements Runnable {
    private ImageIcon icons[] = new ImageIcon[4];
    private Timer t;
    private Boolean flag = false;
    int x, y, z;

    public Fish() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        icons[0] = new ImageIcon("傑尼龜.png");
        icons[1] = new ImageIcon("水水獺.png");
        icons[2] = new ImageIcon("蓋歐卡.png");
        icons[3] = new ImageIcon("帕路奇犽.png");

        x = random.nextInt(1000) + 50;
        y = random.nextInt(1000) + 50;
        z = random.nextInt(4);

        this.setBounds(x, y, 500, 150);
        this.setIcon(icons[z]);

        Image image = icons[0].getImage();
        Image image1 = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        icons[0].setImage(image1);

        Image images = icons[1].getImage();
        Image images1 = images.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        icons[1].setImage(images1);

        Image imagess = icons[2].getImage();
        Image images2 = imagess.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        icons[2].setImage(images2);

        Image imagess11 = icons[3].getImage();
        Image imagess22 = imagess11.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        icons[3].setImage(imagess22);

        t = new Timer((random.nextInt(1) + 1) * 15, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (flag) {
                    if (x + 10 >= 1100) {
                        flag = false;
                    } else {
                        x += 10;
                    }
                } else {
                    if (x -10 < 0) {
                        flag = true;
                    } else {
                        x -= 10;
                    }
                }
                Fish.this.setLocation(x, y);
            }
        });
    }


        public void run() {
        t.start();
        }
    }
