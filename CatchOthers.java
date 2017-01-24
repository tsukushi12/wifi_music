import java.awt.*;
import javax.swing.*;
import java.util.*;

public class CatchOthers extends JPanel {
    public static void main(String args[]) {

    }

    CatchOthers() {
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);
    }

    public void start() {

    }

    static class Catch extends Thread {
        static boolean flag = true;
        static Map<String, Format> others = new HashMap<String, Format>();

        public void run() {
            try {
                while (Catch.flag) {
                    DGReceiver dgr = new DGReceiver();
                    Format format = dgr.recvToFormat();
                    Catch.others.put(format.getTitle(), format);

                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {

                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}