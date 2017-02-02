import java.awt.*;
import javax.swing.*;
public class MainFrame extends JFrame{
    //title
    final String title = "MGO";
    //frame size
    final int width = 500;
    final int height = 1000;
    //todo
    //frame position
    final int x = 50;
    final int y = 0;
    //@variable
    public Container cpane;
    public static void main(String args[]){
        MainFrame frame = new MainFrame();
    }
    MainFrame(){
         setVisible(true);
         setTitle(title);
         setBounds(50, 0, width, height);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         cpane = getContentPane();
    }
    public void addPane(Component comp, Object constraints){
        cpane.add(comp, constraints);
    }

}