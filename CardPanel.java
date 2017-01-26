import java.awt.*;
import javax.swing.*;
public class CardPanel extends JPanel {
    final static String cards[] = {"modeselect", "send", "receive"};
    public CardLayout layout;
    private static CardPanel card = new CardPanel();
    public static void main(String args[]) {
        MainFrame frame = new MainFrame();
        frame.addPane(CardPanel.getInstance(), BorderLayout.CENTER);
    }
    private CardPanel() {
        layout = new CardLayout();
        setLayout(layout);
    }
    public static CardPanel getInstance(){
        return card;
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

    public void show(String card){
        layout.show(this, card);
    }
}