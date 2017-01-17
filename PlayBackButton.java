import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
public class PlayBackButton extends JButton implements ActionListener{
    PlayBack player;
    Thread threads[];
    PlayBackButton(String filename){
        setText(filename);
        setActionCommand(filename);
        addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(player != null)
            player.dest();
        String filename = e.getActionCommand();
        player = new PlayBack(MusicFiles.getFilePath(filename));
        player.start();
    }
}