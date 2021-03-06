import java.awt.*;
import javax.swing.*;

public class MusicSelect extends JPanel {
    BoxLayout layout;
    String filenames[] = new MusicFiles().getFileNames();

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame frame = new MainFrame();
                MusicSelect ms = new MusicSelect();
                frame.addPane(ms, BorderLayout.CENTER);
                ms.addMusicButtons();
            }
        });

    }

    MusicSelect() {
        layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);
        setBackground(Color.GRAY);
        JLabel label = new JLabel("再生リスト");
        label.setMaximumSize(new Dimension(4000, 60));
        label.setBackground(Color.GRAY);
        label.setOpaque(true);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("メイリオ", Font.PLAIN, 40));
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label);
    }

    public void addButton(PlayBackButton btn) {
        add(btn);
    }

    public void testmethod() {
        JButton btn = new JButton();
        btn.setText("test");
        add(btn);
    }

    public void addMusicButtons() {
        for (String filename : filenames) {
            PlayBackButton btn = new PlayBackButton(filename);
            add(btn);
        }
    }

    public void addMediaButton() {
        //      MediaButton btn = new MediaButton();
        //      add(btn);
    }
}