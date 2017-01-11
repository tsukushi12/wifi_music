import javax.sound.sampled.*;
import java.io.*;
public class sound {
    public static void main(String args[]){
        try{
           File audioFile = new File("musicbox.wav");
           AudioInputStream stream = AudioSystem.getAudioInputStream(audioFile);
           byte buffer[] = new byte[1600];
           AudioFormat format = stream.getFormat();
           
           System.out.println(format.getProperty());
//ソースデータライン取得
           DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
           SourceDataLine line = (SourceDataLine)AudioSystem.getLine(info);
//ソースデータラインをオープン
           line.open(format);
           line.start();
           while(true)
           {
               if(stream.read(buffer, 0, buffer.length) == -1)
                    break;
               line.write(buffer, 0, buffer.length);
           }
           line.drain();
           line.stop();
           line.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}