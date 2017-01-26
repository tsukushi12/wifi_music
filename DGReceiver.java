import java.io.*;
import java.net.*;
import java.util.*;

public class DGReceiver {
    public String bindIp4 = "0.0.0.0";
    public String bindIp6 = "::";
    public InetAddress ip;
    public int port = 10100;
    public DatagramSocket sock;
    public byte[] buf = new byte[10000];
    public DatagramPacket packet = new DatagramPacket(buf, buf.length);

    public static void main(String args[]) {
        try {
            DGReceiver receiver = new DGReceiver();
            Format msg = receiver.recvToFormat();
            System.out.println(msg.toS());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    DGReceiver() {
        try {
            sock = new DatagramSocket(port, InetAddress.getByName(bindIp4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    DGReceiver(InetAddress i) throws SocketException {
        port = 10101;
        ip = i;
        sock = new DatagramSocket(port, ip);
    }

    public Format recvToFormat() throws IOException {
        recv();
        String message = new String(buf, 0, packet.getLength());
        Format format = new Format(message);
        format.setIp(packet.getAddress());
        format.setTime(new Date());
        return format;
    }

    public void recv() throws IOException {
        sock.receive(packet);
    }

    public byte[] recvToPCM() throws IOException{
        recv();
        return buf;
    }
}