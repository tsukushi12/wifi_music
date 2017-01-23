import java.io.*;
import java.net.*;
public class DGReceiver{
    public String bindIp4 = "0.0.0.0";
    public String bindIp6 = "::";
    public int port = 10100;
    public DatagramSocket sock;
    public byte[] buf = new byte[1024];
    public DatagramPacket packet = new DatagramPacket(buf, buf.length);
    public static void main(String args[]){
        DGReceiver receiver = new DGReceiver();
        try{
            String msg = receiver.recv();
            System.out.println(msg);
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
    public String recv() throws IOException{
            sock.receive(packet);
            String message = new String(buf, 0, packet.getLength());
            return message;
    }
}