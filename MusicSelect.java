import java.awt.*;
import javax.swing.*;
public class MusicSelect extends JPanel{
    BoxLayout layout;
    public static void main(String args[]){
        MainFrame frame = new MainFrame();
        CardPanel cpanel = new CardPanel();
        frame.addPane(cpanel, BorderLayout.CENTER);
        MusicSelect ms = new MusicSelect();
        cpanel.add(ms);
        //test
        ms.testmethod();
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
}