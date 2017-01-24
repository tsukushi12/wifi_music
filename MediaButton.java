import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class MediaButton extends JButton implements ActionListener{
    final public String pause = "pause";
    final public String play = "play";
    public static void main(String args[]){

    }
    MediaButton(){
        getT();
        buttonStatus();
    }
    public void buttonStatus(){

        addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        getT();
    }
    public void getT(){
        if(PlayBack.getStatus()){
            setText(pause);
        }else{
            setText(play);
        }
    }
}