import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class PlayBackButton extends JButton implements ActionListener{
    PlayBack player;
    PlayBackButton(String filename){
        setText(filename);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setFont(new Font("メイリオ", Font.PLAIN, 16));
        setMaximumSize(new Dimension(4000, 40));
        setActionCommand(filename);
        addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        String filename = e.getActionCommand();
        if(player != null){
            player.fdestruct();
        }
        player = new PlayBack(MusicFiles.getFilePath(filename));
        player.start();
    }
}