import java.io.*;
import java.net.*;
public class DGReceiver{
    public String bindIp4 = "0.0.0.0";
    public String bindIp6 = "::";
    public int port = 10100;
    public DatagramSocket sock;
    public byte[] buf = new byte[10000];
    public DatagramPacket packet = new DatagramPacket(buf, buf.length);
    public static void main(String args[]){
        DGReceiver receiver = new DGReceiver();
        try{
            Format msg = receiver.recvToFormat();
            System.out.println(msg.toS());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    DGReceiver(){
        try{
            sock = new DatagramSocket(port, InetAddress.getByName(bindIp4));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public Format recvToFormat() throws IOException{
        return new Format(recv());
    }
    public String recv() throws IOException{
            sock.receive(packet);
            String message = new String(buf, 0, packet.getLength());
            return message;
    }
}