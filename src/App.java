import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.ArrayList;

public class App extends JFrame {

    JTabbedPane jtp = new JTabbedPane();
    JTextArea left = new JTextArea();
    JTextArea right = new JTextArea();
    JButton toRight = new JButton(">");
    JButton toLeft = new JButton("<");

    App() {
        super("Hmmmm");
        getContentPane().add(jtp);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());

        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(5, 1));
        JLabel point = new JLabel("");

        String path = "blow_up.jpg";
        URL imgURL = App.class.getResource(path);
        ImageIcon blowUp = new ImageIcon(imgURL);

        path = "lalalala.jpg";
        imgURL = App.class.getResource(path);
        ImageIcon lala = new ImageIcon(imgURL);

        path = "cake.jpg";
        imgURL = App.class.getResource(path);
        ImageIcon cake = new ImageIcon(imgURL);

        path = "end_of_suffering.jpg";
        imgURL = App.class.getResource(path);
        ImageIcon suffering = new ImageIcon(imgURL);

        JRadioButton jrb1 = new JRadioButton("Если я не поем, я взорвусь", blowUp);
        JRadioButton jrb2 = new JRadioButton("Ля-ля-ля-ля-ля", lala);
        JRadioButton jrb3 = new JRadioButton("Главное, чтобы я поел тортик", cake);
        JRadioButton jrb4 = new JRadioButton("Мечтаю, чтобы в Землю врезалась комета и прекратила мои страдания", suffering);

        jrb1.setToolTipText("Николай Петрович и Галина Ивановна");
        jrb2.setToolTipText("Да-да, тарелка на голове");
        jrb3.setToolTipText("Тортик - это вкусно");
        jrb4.setToolTipText("О, небеса");

        ButtonGroup bg = new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);
        bg.add(jrb3);
        bg.add(jrb4);

        panel2.add(jrb1);
        panel2.add(jrb2);
        panel2.add(jrb3);
        panel2.add(jrb4);
        panel2.add(point);
        panel2.setBorder(new TitledBorder("А КАКОЙ НИКОЛАЙ ПЕТРОВИЧ СЕГОДНЯ ТЫ?"));

        jrb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                point.setText("Тогда сходи покушай)");
            }
        });
        jrb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                point.setText("Звони в скорую)");
            }
        });
        jrb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                point.setText("Тогда сходи и купи тортик)");
            }
        });
        jrb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                point.setText("Как я тебя понимаю!))00))))0)00)))");
            }
        });

        left.setColumns(10);
        right.setColumns(10);

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(6, 1));
        center.add(toRight);
        center.add(new JPanel());
        center.add(new JPanel());
        center.add(new JPanel());
        center.add(new JPanel());
        center.add(toLeft);

        panel1.add(right, BorderLayout.EAST);
        panel1.add(left, BorderLayout.WEST);
        panel1.add(center, BorderLayout.CENTER);

        jtp.addTab("Task 1", panel1);
        jtp.addTab("Task 2", panel2);


        toRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rightText = right.getText();
                String leftText = left.getText();
                String selectedText = left.getSelectedText();
                if(selectedText != null) {
                    if (!rightText.equals("")) {
                        rightText += "\n";
                    }
                    rightText += selectedText;
                    int a = leftText.indexOf(selectedText);
                    int b = a + selectedText.length();
                    String leftT = "";
                    if(leftText.equals(selectedText)) {
                        left.setText("");
                    } else {
                        if(a != 0) {
                            leftT = leftText.substring(0, a);
                        }
                        if(!leftText.endsWith(selectedText)) {
                            leftT += leftText.substring(b + 1);
                        }
                        left.setText(leftT);
                    }
                    right.setText(rightText);
                }
            }
        });

        toLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rightText = right.getText();
                String leftText = left.getText();
                String selectedText = right.getSelectedText();
                if(selectedText != null) {
                    if (!leftText.equals("")) {
                        leftText += "\n";
                    }
                    leftText += selectedText;
                    int a = rightText.indexOf(selectedText);
                    int b = a + selectedText.length();
                    String rightT = "";
                    if(rightText.equals(selectedText)) {
                        right.setText("");
                    } else {
                        if(a != 0) {
                            rightT = rightText.substring(0, a);
                        }
                        if(!rightText.endsWith(selectedText)) {
                            rightT += rightText.substring(b + 1);
                        }
                        right.setText(rightT);
                    }
                    left.setText(leftText);
                }
            }
        });

        setSize(500, 700);
        setVisible(true);
    }
}