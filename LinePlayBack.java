import javax.sound.sampled.*;
import java.io.*;

public class LinePlayBack {
    public boolean isplay = false;
    public Player player = Player.getInstance();
    public byte frame[];
    public Format format;
    public AudioInputStream stream;
    public DGSender sender;
    private static LinePlayBack linePlayBack = new LinePlayBack();

    public static void main(String args[]) {
        File testfile = new MusicFiles().getTestFile();
        LinePlayBack lpb = LinePlayBack.getInstance();
        lpb.setLine(testfile);
        SelfPlayThread pThread = lpb.new SelfPlayThread();
        pThread.start();
    }

    private LinePlayBack() {
        try{
            sender = new DGSender(10101);
            sender.start();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static LinePlayBack getInstance() {
        return linePlayBack;
    }

    public void setLine(File audiofile) {
        try {
            isplay = true;
            stream = AudioSystem.getAudioInputStream(audiofile);
            AudioFormat af = stream.getFormat();
            player.setFormat(af);
            player.reset();
            format = new Format(af);
            format.addTitle(audiofile.getName());
            frame = format.getSecondSize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clear() {
        player.reset();
    }

    public boolean isPlay() {
        return isplay;
    }

    public Format getFormat() {
        return format;
    }

    class SelfPlayThread extends Thread {
        public boolean isend = true;
        public void run() {
            try {
                while (isend) {
                    while (isplay && isend) {
                        if (stream.read(frame, 0, frame.length) == -1) {
                            isend = false;
                        }
                        player.play(frame);
                        sender.sendFrame(frame);
                        Thread.sleep(18);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public void end(){
            isend = false;
        }
    }
}