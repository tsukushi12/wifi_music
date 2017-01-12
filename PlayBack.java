import javax.sound.sampled.*;
import java.io.*;
public class PlayBack {
    final byte frame[] = new byte[1600];
    AudioInputStream stream;
    AudioFormat format;
    DataLine.Info info;
    SourceDataLine line;
    public static void main(String args[]){

    }
    PlayBack(File audiofile){
         stream = new AudioInputAtream(audiofile);
         format = stream.getFormat();
         info = new DataLine.Info();
    }
    public int getDataSize(){
        format.getProperty();
    }
    public void play(){

    }
}