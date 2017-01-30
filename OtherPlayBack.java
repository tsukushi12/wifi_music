import java.io.*;

public class OtherPlayBack {
    public Format format;
    public Player player = Player.getInstance();
    public DGReceiver receiver;
    public boolean playflag = true;
    private static OtherPlayBack otherPlayBack = new OtherPlayBack();
    public static void main(String args[]) {

    }

    private OtherPlayBack() {
    }
    public static OtherPlayBack getInstance(){
        return otherPlayBack;
    }

    public void setLine(Format f) throws Exception {
        format = f;
        player.setFormat(format.getAudioFormat());
        receiver = new DGReceiver(format.ip, format.getSecondSize());
    }

    class OtherPlayThread extends Thread {
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