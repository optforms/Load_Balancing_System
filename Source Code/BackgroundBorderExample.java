import java.awt.*;
import java.io.*;
import java.net.URL;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.*;
 
public class BackgroundBorderExample {
    public static void main(String[] args) throws IOException {
        JFrame.setDefaultLookAndFeelDecorated(true);
 
        final JPanel cp = new JPanel(new BorderLayout());
        JFrame f = new JFrame("BackgroundBorderExample");
        f.setContentPane(cp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600,400);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
 
        String url = "bg1.gif";
       // Border bkgrnd = new Border(ImageIO.read(new URL(url)));
        Runnable r = new Runnable() {
            public void run() {
                //cp.setBorder(bkgrnd);
                cp.repaint();
            }
        };
        SwingUtilities.invokeLater(r);
    }
}

