import java.io.*;

public class OtherPlayBack{
    public Format format;
    public Player prayer = Player.getInstance();
    DGReceiver receiver;
    playflag = true;
  public static void main(String args[]){

  }  
  OtherPlayBack(){
  }
    public void setLine(Format f){
        format = f;
        prayer.setFormat(format.getAudioFormat());
        receiver = new DGReceiver(format.ip, format.getSecondSize());
    }
    class Play{
        run(){
            byte[] buf;
            while(playflag){
                buf = receiver.recvToPCM();
                player.play(buf);
            }
        }
    }
}