import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SelectModePanel extends JPanel {

    CardPanel card = CardPanel.getInstance();
    String[] cards = CardPanel.cards;
    public static void main(String args[]) {
        MainFrame frame = new MainFrame();
        CardPanel card = CardPanel.getInstance();
        SelectModePanel smp = new SelectModePanel();
        frame.addPane(card, BorderLayout.CENTER);
        card.addCard(smp, CardPanel.cards[0]);
    }

    SelectModePanel() {
        setLayout(new GridLayout(0, 2));
        add(new ModeButton(cards[1]));
        add(new ModeButton(cards[2]));
    }

    class ModeButton extends JButton implements ActionListener {
        ModeButton(String txt) {
            setText(txt);
            setActionCommand(txt);
            setBackground(Color.BLACK);
            setForeground(Color.WHITE);
            addActionListener(this);
        }

        public void actionPerformed(ActionEvent e) {
            String mode = e.getActionCommand();
        }
    }
}