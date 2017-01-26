import java.awt.*;
import javax.swing.*;
import java.util.*;

public class CatchOthers extends JPanel {
    static Map<String, Format> others = new HashMap<String, Format>();
    public JLabel label;

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame frame = new MainFrame();
                CatchOthers coPanel = new CatchOthers();
                frame.addPane(coPanel, BorderLayout.CENTER);
            }
        });
    }

    CatchOthers() {
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);
        label = new JLabel("0");
        label.setMaximumSize(new Dimension(4000, 30));
        label.setBackground(Color.GRAY);
        label.setOpaque(true);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("メイリオ", Font.PLAIN, 16));
        label.setHorizontalAlignment(JLabel.CENTER);
        setBackground(Color.GRAY);
        add(label);
        Catch c = new Catch();
        c.start();
    }

    public void start() {

    }

    class Catch extends Thread {
        boolean flag = true;

        public void run() {
            try {
                DGReceiver dgr = new DGReceiver();
                while (flag) {
                    try {
                        Format format = dgr.recvToFormat();
                        if (CatchOthers.others.get(format.getTitle()) == null) {
                            CatchOthers.others.put(format.getTitle(), format);
                            SwingUtilities.invokeLater(new Runnable() {
                                public void run() {
                                    OtherPlayBackButton opbutton = new OtherPlayBackButton(format.getTitle());
                                    add(opbutton);
                                    validate();
                                }
                            });
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}