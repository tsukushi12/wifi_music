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
    public void stop(){
        playflag = false;
        Thread.sleep(20);
    }
    class OtherPlayThread extends Thread {
        public void run() {
            byte[] buf = format.getSecondSize();
            try {
                while (playflag) {
                    buf = receiver.recvToPCM();
                    player.play(buf);
                }
                receiver.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}