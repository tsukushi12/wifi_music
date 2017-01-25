import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class OtherPlayBackButton extends JButton implements ActionListener{
    PlayBack player;
    LinePlayBack lpb = LinePlayBack.getInstance();
    OtherPlayBackButton(String filename){
        setText(filename);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setFont(new Font("メイリオ", Font.PLAIN, 16));
        setMaximumSize(new Dimension(4000, 40));
        setActionCommand(filename);
        addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){

    }
}