import java.io.*;

public class OtherPlayBack {
    public Format format;
    public Player player = Player.getInstance();
    public DGReceiver receiver;
    public boolean playflag = true;

    public static void main(String args[]) {

    }

    OtherPlayBack() {
    }

    public void setLine(Format f) throws Exception {
        format = f;
        player.setFormat(format.getAudioFormat());
        receiver = new DGReceiver(format.ip, format.getSecondSize());
    }

    class Play {
        public void run() {
            byte[] buf = format.getSecondSize();
            try {
                while (playflag) {
                    buf = receiver.recvToPCM();
                    player.play(buf);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}