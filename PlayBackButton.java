import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class PlayBackButton extends JButton implements ActionListener{
    PlayBack player;
    PlayBackButton(String filename){
        setText(filename);
        setActionCommand(filename);
        addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        String filename = e.getActionCommand();
        player = new PlayBack(MusicFiles.getFilePath(filename));
        player.start();
    }
}