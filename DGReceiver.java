import java.io.*;
import java.net.*;
import java.util.*;

public class DGReceiver {
    public String bindIp4 = "0.0.0.0";
    public String bindIp6 = "::";
    public InetAddress ip;
    public int port = 10100;
    public DatagramSocket sock;
    public byte[] buf;
    public DatagramPacket packet;

    public static void main(String args[]) {
        try {
            //////////////////////////////////////////////////////
            //            DGReceiver receiver = new DGReceiver();
            //            Format msg = receiver.recvToFormat();
            //            System.out.println(msg.toS());
            //////////////////////////////////////////////////////////////////
            DGReceiver recv = new DGReceiver(InetAddress.getByName("0.0.0.0"), new byte[1000]);
            byte[] a = recv.recvToPCM();
            System.out.println(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    DGReceiver() {
        try {
            sock = new DatagramSocket(port, InetAddress.getByName(bindIp4));
            buf = new byte[10000];
            packet = new DatagramPacket(buf, buf.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    DGReceiver(InetAddress i, byte[] b) throws Exception {
        port = 10101;
        ip = i;
        buf = b;
        sock = new DatagramSocket(port, InetAddress.getByName("0.0.0.0"));
        packet = new DatagramPacket(buf, buf.length);
        //   sock.connect(ip, port);
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

    public byte[] recvToPCM() throws IOException {
        recv();
        return buf;
    }

    public void close() {
        if (sock.isClosed())
            sock.close();
    }
}