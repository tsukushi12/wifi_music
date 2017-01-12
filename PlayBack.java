import javax.sound.sampled.*;
import java.io.*;
public class PlayBack {
    final byte frame[] = new byte[1600];
    AudioInputStream stream;
    AudioFormat format;
    DataLine.Info info;
    SourceDataLine line;
    public static void main(String args[]){
        File audiofile = new File("/wifi_music/music/musicbox.wav");
        PlayBack player = new PlayBack(audiofile);
        player.play();
    }
    PlayBack(File audiofile){
        try{
            stream = AudioSystem.getAudioInputStream(audiofile);
            format = stream.getFormat();
            info = new DataLine.Info(SourceDataLine.class, format);
            line = (SourceDataLine)AudioSystem.getLine(info);
         }catch(Exception e){
            e.printStackTrace();
        }
    }
    public int getDataSize(){
        return 4;
    }
    public void play(){
        try {
        line.open(format);
        line.start();
        while(true)
           {
               if(stream.read(frame, 0, frame.length) == -1)
                    break;
               line.write(frame, 0, frame.length);
           }
           line.drain();
           line.stop();
           line.close();
           }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void forceStop(){
        line.stop();
    }
}