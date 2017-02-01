import java.io.*;

public class SendThread {
    public DGSender sender;
    private static SendThread sendThread = new SendThread();
    public LinePlayBack lpb = LinePlayBack.getInstance();

    public static void main(String arg[]) {
        SendThread st = SendThread.getInstance();

    }

    private SendThread() {
        try {
            sender = new DGSender();
            sender.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SendThread getInstance() {
        return sendThread;
    }

    class Send extends Thread {
        public boolean isend = true;
        public String format;

        Send(String s) {
            format = s;
        }

        public void run() {
            try {
                while (this.isend) {
                    sender.sendAudioMeta(format);
                    Thread.sleep(3000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void end() {
            isend = false;
        }
    }
}