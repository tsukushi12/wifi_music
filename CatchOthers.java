import java.awt.*;
import javax.swing.*;
import java.util.*;

public class CatchOthers extends JPanel {
    static Map<String, Format> others = new HashMap<String, Format>();
    public static void main(String args[]) {

    }

    CatchOthers() {
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);
        Catch c = new Catch();
    }

    public void start() {

    }

    class Catch extends Thread {
        boolean flag = true;

        public void run() {
            try {
                while (flag) {
                    DGReceiver dgr = new DGReceiver();
                    Format format = dgr.recvToFormat();
                    CatchOthers.others.put(format.getTitle(), format);

                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            setBackground(Color.BLACK);
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}