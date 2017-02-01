import java.io.*;

public class OtherPlayBack {
    public Format format;
    public Player player = Player.getInstance();
    public DGReceiver receiver;

    public static void main(String args[]) {

    }

    OtherPlayBack() {
    }

    public void setLine(Format f) throws Exception{
        format = f;
        if (receiver != null)
            receiver.close();
        player.setFormat(format.getAudioFormat());
        receiver = new DGReceiver(format.ip, format.getSecondSize());
    }

    class OtherPlayThread extends Thread {
        public boolean playflag = true;

        public void run() {
            byte[] buf = format.getSecondSize();
            try {
                while (playflag) {
                    buf = receiver.recvToPCM();
                    System.out.println(buf);
                    player.play(buf);
                }
                receiver.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void end() {
            playflag = false;
        }
    }
}