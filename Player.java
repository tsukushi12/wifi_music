import javax.sound.sampled.*;

import java.beans.MetaData.StaticFieldsPersistenceDelegate;
import java.io.*;

public class Player {
    private static Player player = new Player();
    private Format format;
    private SourceDataLine line;

    private Player() {}

    public static Player getInstance() {
        return player;
    }

    public void setFormat(AudioFormat af) {
        format = af;
        info = new DataLine.Info(SourceDataLine.class, format);
        line = (SourceDataLine) AudioSystem.getLine(info);
        line.open();
    }
    public void play(byte[] frame){
        line.start();
        line.write(frame, 0, frame.length);
    }
    public reset(){
        line.flush();
    }
    public close(){
        line.stop();
        line.close();
    }
}