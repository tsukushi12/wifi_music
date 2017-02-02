import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class OtherPlayBackButton extends JButton implements ActionListener {
    public OtherPlayBack opb;
    public OtherPlayBack.OtherPlayThread playThread;

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame frame = new MainFrame();
                CatchOthers coPanel = new CatchOthers();
                coPanel.add(new OtherPlayBackButton("test"));
                frame.addPane(coPanel, BorderLayout.CENTER);
            }
        });
    }

    OtherPlayBackButton(String filename) {
        setText(filename);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setFont(new Font("メイリオ", Font.PLAIN, 40));
        setMaximumSize(new Dimension(4000, 70));
        setActionCommand(filename);
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String othername = e.getActionCommand();
            Format format = CatchOthers.others.get(othername);
            opb = new OtherPlayBack();
            opb.setLine(format);
            if (playThread != null)
                playThread.end();
            playThread = opb.new OtherPlayThread();
            playThread.start();
        } catch (Exception er) {
            er.printStackTrace();
        }
    }
}