import java.io.*;
import java.net.*;
public class DGSender{
    public String ip;
    public int port = 10100;
    public DatagramSocket sock;
    public String meta;
    public DatagramPacket packet;
    public InetSocketAddress dest;
    public static void main(String args[]){
        
    }
    DGSender(){
        getSocket();
        dest = new InetSocketAddress("ff02::1", port);
    }
    DGSender(String ipaddress){
        ip = ipaddress;
        dest = new InetSocketAddress(ip, port);
        getSocket();
    }
    public void addMeta(String str){
        meta = str;
        byte buf[] = meta.getBytes();
        packet = new DatagramPacket(buf, 0, buf.length, dest);
    }
    public void sendMetaAudio(){
        try{
            sock.send(packet);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void send(String str){
        addMeta(str);
        sendMetaAudio();
    }
    public void getSocket(){
        try{
            sock = new DatagramSocket();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}