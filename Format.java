import javax.sound.sampled.*;
import java.io.*;
import java.lang.reflect.Executable;

public class Format {
    public AudioFormat format;
    public AudioFormat.Encoding encoding;
    public float samplerate;
    public int bitrate;
    public int channel;
    public boolean endian;
    public String title = "";
    public static void main(String args[]) {
        try {
            File testfile = new MusicFiles().getTestFile();
            AudioInputStream stream = AudioSystem.getAudioInputStream(testfile);
            AudioFormat format = stream.getFormat();
            System.out.println(format.toString());
            Format f = new Format(format);
            System.out.println(f.toS());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    Format(AudioFormat af){
        format = af;
        encoding = format.getEncoding();
        samplerate = format.getSampleRate();
        bitrate = format.getSampleSizeInBits();
        channel = format.getChannels();
        endian = format.isBigEndian();
    }
    Format(String format) {
        String values[] = format.split(",");
        encoding = toEncoding(values[0]);
        samplerate = toSampleRate(value[1]);
        bitrate = toBitRate(value[2]);
        channel = toChannel(value[3]);
        endian = toIsBigEndian(value[4]);
        title = value[5];
        format = new AudioFormat(encoding,
                                samplerate,
                                bitrate,
                                channel,
                                endian);
    }
    public String toS(){
        return encoding.toString() + "," +
                 String.valueOf(samplerate) + "," +
                 String.valueOf(bitrate) + "," +
                 String.valueOf(channel) + "," +
                 String.valueOf(endian) + "," +
                 title; 
    }
    public void addTitle(String t){
        title = t;
    }
    public int getMbyte(){
        return 4;
    }
    static AudioFormat.Encoding toEncoding(String encoding) {
        return new AudioFormat.Encoding(encoding);
    }
    static float toSampleRate(String sr){
        return (float)Integer.parseInt(sr);
    }
    static int toBitRate(String br){
        return Integer.parseInt(br);
    }
    static int toChannel(String c){
        return Integer.parseInt(c);
    }
    static boolean toIsBigEndian(String be){
        return Boolean.valueOf(be);
    }
    
}