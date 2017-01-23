import java.io.*;
import java.net.*;
import javax.sound.sampled.*;

public class DGSender {
    static final String ip6 = "ff02::1";
    static final String ip4 = "255.255.255.255";
    public InetAddress ip;
    public int port = 10100;
    public DatagramSocket sock;
    public String meta;
    public DatagramPacket packet;
    public InetSocketAddress dest;

    public static void main(String args[]) {
        try {
            File testfile = new MusicFiles().getTestFile();
            AudioInputStream stream = AudioSystem.getAudioInputStream(testfile);
            AudioFormat af = stream.getFormat();
            Format format = new Format(af);
            DGSender sender = new DGSender();
            sender.start();
            sender.send(format.toS());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    DGSender() throws UnknownHostException {
        ip = InetAddress.getByName(ip4);
    }

    DGSender(String ipaddress) throws UnknownHostException {
        ip = InetAddress.getByName(ipaddress);
    }

    public void setPort(int p) {
        if (dest == null) {
            port = p;
        }
    }

    public void start() {
        try {
            dest = new InetSocketAddress(ip, port);
            sock = new DatagramSocket();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addMeta(String str) {
        meta = str;
        byte buf[] = meta.getBytes();
        packet = new DatagramPacket(buf, 0, buf.length, dest);
    }

    public void sendMetaAudio() {
        try {
            sock.send(packet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void send(String str) {
        addMeta(str);
        sendMetaAudio();
    }
}