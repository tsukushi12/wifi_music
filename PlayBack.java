import javax.sound.sampled.*;
import java.io.*;
public class PlayBack extends Thread {
    byte frame[] = new byte[1600];
    AudioInputStream stream;
    AudioFormat format;
    DataLine.Info info;
    static SourceDataLine line;
    public static void main(String args[]){
        File audiofile = new File("/wifi_music/music/musicbox.wav");
        PlayBack player = new PlayBack(audiofile);
        player.play();
        player.dest();
    }
    PlayBack(File audiofile){
        try{
            stream = AudioSystem.getAudioInputStream(audiofile);
            format = stream.getFormat();
            info = new DataLine.Info(SourceDataLine.class, format);
            line = (SourceDataLine)AudioSystem.getLine(info);
            line.open();
         }catch(Exception e){
            e.printStackTrace();
        }
    }
    PlayBack(){
        try{
            info = new DataLine.Info(SourceDataLine.class, format);
            line = (SourceDataLine)AudioSystem.getLine(info);
            line.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setAudioFile(){

    }
    public void run() {
        play();
    }
    public void play(){
        try {
            line.start();
        while(line.isOpen())
           {
               if(stream.read(frame, 0, frame.length) == -1)
                    break;
               line.write(frame, 0, frame.length);
           }
           line.drain();
           line.stop();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //media
    public void dest(){
        line.close();
    }
    static boolean getStatus(){
        return line.isRunning();
    }
}