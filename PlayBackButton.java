import java.awt.*;
import javax.swing.*;
public class PlayBackButton extends JButton implements ActionListener{
    
    PlayBackButton(String filename, Dimension size){
        setText(filename);
        setActionCommand(filename);
        setPreferredSize(size);
        btn.addActionListener(this);
    }
    public void actionPerfrmed(ActionEvent e){
        String filename = e.getActionCommand();
    }
}