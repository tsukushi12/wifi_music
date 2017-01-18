import javax.sound.sampled.*;
import java.io.*;

public class PlayBack extends Thread {
    byte frame[] = new byte[1600];
    boolean playflag = true;
    AudioInputStream stream;
    AudioFormat format;
    DataLine.Info info;
    SourceDataLine line;

    public static void main(String args[]) {
        File audiofile = new File("/wifi_music/music/musicbox.wav");
        PlayBack player = new PlayBack(audiofile);
        player.play();
        player.dest();
    }

    PlayBack(File audiofile) {
        try {
            stream = AudioSystem.getAudioInputStream(audiofile);
            format = stream.getFormat();
            info = new DataLine.Info(SourceDataLine.class, format);
            line = (SourceDataLine) AudioSystem.getLine(info);
            line.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    PlayBack() {
        try {
            info = new DataLine.Info(SourceDataLine.class, format);
            line = (SourceDataLine) AudioSystem.getLine(info);
            line.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void run() {
        play();
    }
    public void play() {
        try {
            while (line.isOpen()) {
                while (playflag) {
                    line.start();
                    if (stream.read(frame, 0, frame.length) == -1)
                        {
                            dest();
                        }
                    line.write(frame, 0, frame.length);
                }
                Thread.sleep(500);
            }
            dest();
        } catch (Exception e) {
            e.printStackTrace();
            line.close();
        }
    }
    //media
    public void backTo(){
    }
    public void dest(){
        playflag = false;
        line.drain();
        line.stop();
        line.close();
    }
    public void fdestruct() {
        playflag = false;
        line.stop();
        line.flush();
        line.close();
    }
    public void playOrPause(){
        playflag = !playflag;
    }
}