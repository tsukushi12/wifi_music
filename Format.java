import javax.sound.sampled.*;
import java.io.*;
import java.util.*;
import java.net.*;
public class Format {
    final static int sec = 40;
    public AudioFormat format;
    public AudioFormat.Encoding encoding;
    public float samplerate;
    public int bitrate;
    public int channel;
    public boolean endian;
    public String title = "";
    public Date time;
    public InetAddress ip;
    public static void main(String args[]) {
        try {
            File testfile = new MusicFiles().getTestFile();
            AudioInputStream stream = AudioSystem.getAudioInputStream(testfile);
            AudioFormat format = stream.getFormat();
            System.out.println(format.toString());
            Format f = new Format(format);
            System.out.println(f.toS());
            f.addTitle("test");
            Format f2 = new Format(f.toS());
            System.out.println(f2.toS());
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
    Format(String f) {
        String values[] = f.split(",");
        encoding = toEncoding(values[0]);
        samplerate = toSampleRate(values[1]);
        bitrate = toBitRate(values[2]);
        channel = toChannel(values[3]);
        endian = toIsBigEndian(values[4]);
        title = values[5];
        format = new AudioFormat(
                                encoding,
                                samplerate,
                                bitrate,
                                channel,
                                bitrate * channel / 8,
                                samplerate,
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
    public String getTitle(){
        return title;
    }
    public int getMbyte(){
        return 4;
    }
    public AudioFormat getAudioFormat(){
        return format;
    }
    public InetAddress getSender(){
        return ip;
    }
    public void setTime(Date t){
        time = t;
    }
    public void setIp(InetAddress i){
        ip = i;
    }

    public byte[] getSecondSize(){
        int i = ((int)samplerate * bitrate * channel * Format.sec / 1000);
        return new byte[i];
    }
    static AudioFormat.Encoding toEncoding(String encoding) {
        return AudioFormat.Encoding.PCM_SIGNED;
    }
    static float toSampleRate(String sr){
        return Float.parseFloat(sr);
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