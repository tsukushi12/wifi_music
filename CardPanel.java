import java.awt.*;
import javax.swing.*;
public class CardPanel extends JPanel {
    CardLayout layout;
    public static void main(String args[]) {
        MainFrame frame = new MainFrame();
        frame.addPane(new CardPanel(), BorderLayout.CENTER);
    }
    CardPanel() {
        setBackground(Color.BLACK);
        layout = new CardLayout();
        setLayout(layout);
    }
    public CardLayout getLayout(){
        return layout;
    }
    public void next(){
        layout.next(this);
    }
    public void addCard(Component comp, Object constraints){
        add(comp, constraints);
    }
}