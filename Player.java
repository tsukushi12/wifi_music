import javax.sound.sampled.*;
import java.io.*;

public class Player {
    private static Player player = new Player();
    private AudioFormat af;
    private SourceDataLine line;

    private Player() {
    }

    public static Player getInstance() {
        return player;
    }

    public void setFormat(AudioFormat a) throws LineUnavailableException {
        af = a;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, af);
        line = (SourceDataLine) AudioSystem.getLine(info);
        line.open();
    }

    public void play(byte[] frame) {
        line.start();
        line.write(frame, 0, frame.length);
    }

    public void reset() {
        if (line.isRunning()) {
            line.flush();
        }
    }

    public void close() {
        line.stop();
        line.close();
    }
}