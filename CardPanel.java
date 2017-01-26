import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class CardPanel extends JPanel {
    final static String cards[] = { "modeselect", "send", "receive" };
    public CardLayout layout;
    private static CardPanel card = new CardPanel();

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame frame = new MainFrame();
                frame.addPane(CardPanel.getInstance(), BorderLayout.CENTER);
            }
        });
    }

    private CardPanel() {
        layout = new CardLayout();
        setLayout(layout);
        SelectModePanel smp = new SelectModePanel();
        MusicSelect ms = new MusicSelect();
        CatchOthers co = new CatchOthers();

        add(smp, CardPanel.cards[0]);
        add(ms, CardPanel.cards[1]);
        add(co, CardPanel.cards[2]);
    }

    public static CardPanel getInstance() {
        return card;
    }

    public CardLayout getLayout() {
        return layout;
    }

    public void next() {
        layout.next(this);
    }

    public void addCard(Component comp, Object constraints) {
        add(comp, constraints);
    }

    public void show(String card) {
        layout.show(this, card);
    }
}