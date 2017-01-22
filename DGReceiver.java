import java.io.*;
import java.net.*;
public class DGReceiver{
    public String bindIp;
    public int port = 10100;
    public DatagramSocket sock;
    public static void main(String args[]){
        DGReceiver receiver = new DGReceiver();
        
    }
    DGReceiver(){
        try{
            sock = new DatagramSocket(port);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public String recv(){
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        sock.receive(packet);
        String message = new String(buf, 0, packet.getLength());
        return message;
    }
}