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
            format.addTitle(testfile.toString());
            DGSender sender = new DGSender();
            sender.start();
            sender.sendAudioMeta(format.toS());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    DGSender() throws UnknownHostException {
        ip = InetAddress.getByName(ip4);
    }

    DGSender(int p) throws UnknownHostException {
        ip = InetAddress.getByName(ip4);
        port = p;
    }

    DGSender(String ipaddress) throws UnknownHostException {
        ip = InetAddress.getByName(ipaddress);
    }

    public void setPort(int p) {
        if (dest == null) {
            port = p;
        }
    }

    public void start() throws SocketException {
        dest = new InetSocketAddress(ip, port);
        sock = new DatagramSocket();
    }

    public void sendFrame(byte frame[]) throws IOException {
        packet = new DatagramPacket(frame, 0, frame.length, dest);
        sock.send(packet);
    }

    public void addMeta(String str) {
        meta = str;
        byte buf[] = meta.getBytes();
        packet = new DatagramPacket(buf, 0, buf.length, dest);
    }

    public void sendAudioMeta(String str) throws IOException {
        addMeta(str);
        sock.send(packet);
    }
}