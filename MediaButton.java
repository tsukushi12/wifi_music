import java.awt.*;
import java.util.EventListener;


import javax.swing.*;
import javax.swing.ebent.*;
public class MediaButton extends JButton implements EventListener{
    final public String pause = "pause";
    final public String play = "play";
    public static void main(String args[]){

    }
    MediaButton(){
        buttonStatus();
    }
    public void buttonStatus(){
        if(PlayBack.getStatus()){
            setText(pause);
        }else{
            setText(play);
        }
    }
    public void actionPerformed(ActionEvent e){
        
    }
}