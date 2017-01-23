import java.awt.*;
import javax.swing.*;

public class CatchOthers extends JPanel {
    public static void main(String args[]) {

    }

    CatchOthers() {
        layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);
    }

    public void start() {

    }

    static class Catch extends Thread {
        static boolean flag = true;

        public void run() {
            try {
                while (flag) {
                    DGReceiver dgr = new DGReceiver();
                    msg = dgr.recvToFormat();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}