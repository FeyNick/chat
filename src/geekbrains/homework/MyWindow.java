package geekbrains.homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class MyWindow extends JFrame {
    public MyWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 430, 400);
        setVisible(true);
        setLayout(null);
        JPanel[] jp = new JPanel[2];
        for (int i = 0; i < jp.length; i++) {
            jp[i] = new JPanel();
            add(jp[i]);
            jp[i].setBackground(new Color(250 - i * 40, 250 - i * 40, 250 - i * 40));
        }


        jp[0].setBounds(0, 0, 430, 300);

        jp[0].setLayout(new BorderLayout());
        JTextArea dialog = new JTextArea();
        JScrollPane jsp = new JScrollPane(dialog);
        jp[0].add(jsp);

        jp[1].setBounds(0, 300, 430, 100);

        jp[1].setLayout(null);
        JTextArea textField = new JTextArea();
        jp[1].add(textField);
        textField.setBounds(10, 10, 310, 30);
        JButton button = new JButton("Enter");
        jp[1].add(button);
        button.setBounds(330, 10, 70, 30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date date = new Date();
                String str = dialog.getText() + "\n" + date.toString() + ":         "  + textField.getText();
                dialog.setText(str);
                textField.setText(null);
            }
        });

        textField.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 13){
                    Date date = new Date();
                    String str = dialog.getText() + "\n" + date.toString() + ":         "  + textField.getText();
                    dialog.setText(str);
                    textField.setText(null);
                }
            }

        });

    }
}
