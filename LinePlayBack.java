import javax.sound.sampled.*;
import java.io.*;

public class LinePlayBack {
    public boolean isplay = true;
    public boolean isend = true;
    public Player player = Player.getInstance();
    public byte frame[] = new byte[1600];
    public Format format;
    public AudioInputStream stream;
    private static LinePlayBack linePlayBack = new LinePlayBack();

    public static void main(String args[]) {
        File testfile = new MusicFiles().getTestFile();
        LinePlayBack lpb = LinePlayBack.getInstance();
        lpb.setLine(testfile);
        SelfPlayThread pThread = lpb.new SelfPlayThread();
        pThread.start();
    }

    private LinePlayBack() {
    }

    public static LinePlayBack getInstance() {
        return linePlayBack;
    }

    public void setLine(File audiofile) {
        try {
            isend = true;
            isplay = true;
            stream = AudioSystem.getAudioInputStream(audiofile);
            AudioFormat af = stream.getFormat();
            player.setFormat(af);
            player.reset();
            format = new Format(af);
            format.addTitle(audiofile.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clear(){
        isend = false;
        player.reset();
    }
    class SelfPlayThread extends Thread {
        public void run() {
            try {
                while (isend) {
                    while (isplay && isend) {
                        if (stream.read(frame, 0, frame.length) == -1) {
                            isend = false;
                        }
                        player.play(frame);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}