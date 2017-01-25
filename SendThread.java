import java.io.*;

public class SendThread extends Thread {
    public LinePlayBack lpb = LinePlayBack.getInstance();
    public Player player = Player.getInstance();
    public Format format = lpb.getFormat();
    public DGSender sender;

    public static void main(String arg[]) {

    }

    public void run() {
        try {
            sender = new DGSender();
            while (lpb.isPlay()) {
                sender.start();
                sender.sendAudioMeta(format.toS());
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}