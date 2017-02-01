import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class PlayBackButton extends JButton implements ActionListener {
    LinePlayBack lpb = LinePlayBack.getInstance();
    SendThread st = SendThread.getInstance();
    LinePlayBack.SelfPlayThread playThread;
    SendThread.Send sThread;

    PlayBackButton(String filename) {
        setText(filename);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setFont(new Font("メイリオ", Font.PLAIN, 16));
        setMaximumSize(new Dimension(4000, 40));
        setActionCommand(filename);
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String filename = e.getActionCommand();
        File audiofile = MusicFiles.getFilePath(filename);
        lpb.setLine(audiofile);
        if (playThread != null)
            playThread.end();
        playThread = lpb.new SelfPlayThread();
        playThread.start();
        if (sThread != null)
            sThread.end();
        sThread = st.new Send(lpb.getFormat().toS());
        sThread.start();
        try{
        playThread.join();
        }catch(Exception er){er.printStackTrace(); }
        sThread.end();
    }
}