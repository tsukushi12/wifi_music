import java.awt.*;
import javax.swing.*;
public class MusicSelect extends JPanel{
    BoxLayout layout;
    String filenames[] = new MusicFiles().getFileNames();
    public static void main(String args[]){
        MainFrame frame = new MainFrame();
        CardPanel cpanel = new CardPanel();
        frame.addPane(cpanel, BorderLayout.CENTER);
        MusicSelect ms = new MusicSelect();
        cpanel.add(ms);
        //test
        ms.addMusicButtons();
        ms.addMediaButton();
    }
    MusicSelect(){
        layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);
    }
    public void addButton(PlayBackButton btn) {
        add(btn);
    }
    public void testmethod(){
        JButton btn = new JButton();
        btn.setText("test");
        add(btn);
    }
    public void addMusicButtons(){
        for (String filename: filenames){
            PlayBackButton btn = new PlayBackButton(filename);
            add(btn);
        }
    }
    public void addMediaButton(){
        MediaButton btn = new MediaButton();
        add(btn);
    }
}