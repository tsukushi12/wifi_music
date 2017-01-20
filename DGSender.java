import java.io.*;
import packet.DGSocket;
public class DGSender{
    public String ip;
    public int port = 10100;
    public DGSocket sock;
    public static void main(String args[]){

    }
    DGSender(String ipaddress){
        ip = ipaddress;
        sock = new DGSocket(ip, port);
    }
    public void addMeta(){

    }
    public void sendMetaAudio(){
    }
}