import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class OtherPlayBackButton extends JButton implements ActionListener {
    public OtherPlayBack opb;

    OtherPlayBackButton(String filename) {
        setText(filename);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setFont(new Font("メイリオ", Font.PLAIN, 16));
        setMaximumSize(new Dimension(4000, 40));

        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if(opb != null)
                opb.stop();
            opb = new OtherPlayBack();
            String othername = e.getActionCommand();
            Format format = CatchOthers.others.get(othername);
            opb.setLine(format);
            OtherPlayBack.OtherPlayThread otherPlayThread = opb.new OtherPlayThread();
            otherPlayThread.start();
        } catch (Exception er) {
            er.printStackTrace();
        }
    }
}