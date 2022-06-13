import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class NewCalculator {
    String firstNumber = "";
    String symbol = "";
    String secondNumber = "";
    boolean OnSecondNumber = false;
    boolean ReplaceNumber = false;
    boolean Error = false;
    JTextField text = new JTextField();
    MyButton mod = new MyButton("%");
    MyButton delete_num = new MyButton("CE");
    MyButton delete_all = new MyButton("C");
    MyButton delete_symbol = new MyButton("⌫");
    MyButton div_one = new MyButton("1/x");
    MyButton square = new MyButton("x²");
    MyButton rooting = new MyButton("√x");
    MyButton division = new MyButton("÷");
    MyButton seven = new MyButton("7");
    MyButton eight = new MyButton("8");
    MyButton nine = new MyButton("9");
    MyButton multiplication = new MyButton("×");
    MyButton four = new MyButton("4");
    MyButton five = new MyButton("5");
    MyButton six = new MyButton("6");
    MyButton subtraction = new MyButton("-");
    MyButton one = new MyButton("1");
    MyButton two = new MyButton("2");
    MyButton three = new MyButton("3");
    MyButton addition = new MyButton("+");
    MyButton change_sign = new MyButton("+/-");
    MyButton zero = new MyButton("0");
    MyButton dot = new MyButton(",");
    MyButton equal = new MyButton("=");

    static class MyButton extends JButton {

        private final Color hoverBackgroundColor = new Color(76, 76, 76);
        private final Color pressedBackgroundColor = new Color(96, 96, 96);

        public MyButton(String text) {
            super(text);
            super.setContentAreaFilled(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (getModel().isPressed()) {
                g.setColor(pressedBackgroundColor);
            } else if (getModel().isRollover()) {
                g.setColor(hoverBackgroundColor);
            } else {
                g.setColor(getBackground());
            }
            g.fillRect(0, 0, getWidth(), getHeight());
            super.paintComponent(g);
        }

        @Override
        public void setContentAreaFilled(boolean b) {
        }

    }

    public void Operation(String NewSymbol) {
        symbol = NewSymbol;
        OnSecondNumber = true;
        if (Objects.equals(firstNumber, ""))
            firstNumber = "0";
        text.setText(firstNumber + symbol + secondNumber);
    }

    public void MakeError() {
        Error = true;
        mod.setEnabled(false);
        div_one.setEnabled(false);
        square.setEnabled(false);
        rooting.setEnabled(false);
        division.setEnabled(false);
        multiplication.setEnabled(false);
        subtraction.setEnabled(false);
        addition.setEnabled(false);
        change_sign.setEnabled(false);
        dot.setEnabled(false);
        firstNumber = "";
        secondNumber = "";
        symbol = "";
        OnSecondNumber = false;
    }

    public void FixError() {
        Error = false;
        mod.setEnabled(true);
        div_one.setEnabled(true);
        square.setEnabled(true);
        rooting.setEnabled(true);
        division.setEnabled(true);
        multiplication.setEnabled(true);
        subtraction.setEnabled(true);
        addition.setEnabled(true);
        change_sign.setEnabled(true);
        dot.setEnabled(true);
        firstNumber = "0";
    }

    public void ButtonNumber(String Number) {
        if (Error)
            FixError();

        if (OnSecondNumber) {
            if (!Objects.equals(secondNumber, "0") && !ReplaceNumber)
                secondNumber += Number;
            else
                secondNumber = Number;
        } else {
            if (!Objects.equals(firstNumber, "0") && !ReplaceNumber)
                firstNumber += Number;
            else
                firstNumber = Number;
        }
        ReplaceNumber = false;
        text.setText(firstNumber + symbol + secondNumber);
    }

    public void createGUI() {
        int text_size = 15;

        JFrame frame = new JFrame("Калькулятор");
        frame.getContentPane().setBackground(new Color(39, 39, 39));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(320, 430));
        frame.pack();
        frame.setVisible(true);

        Container pane = frame.getContentPane();

        GridBagConstraints grid = new GridBagConstraints();
        pane.setLayout(new GridBagLayout());

        grid.fill = GridBagConstraints.BOTH;
        grid.gridwidth = 4;
        grid.weightx = 0.5;
        grid.weighty = 1;
        grid.insets = new Insets(1, 1, 1, 1);

        text.setFont(new Font("Arial", Font.PLAIN, text_size + 10));
        text.setBackground(new Color(39, 39, 39));
        text.setBorder(BorderFactory.createLineBorder(Color.decode("#242424")));
        text.setForeground(Color.WHITE);
        text.setHorizontalAlignment(JTextField.RIGHT);
        text.setText("0");
        pane.add(text, grid);

        grid.gridwidth = 1;
        grid.weighty = 0.5;

        MyButton[] grayButtons = new MyButton[]{mod, delete_num, delete_symbol, delete_all, div_one, square, rooting, division, multiplication, addition, subtraction, equal};
        for (MyButton button : grayButtons) {
            button.setFont(new Font("Ar", Font.PLAIN, text_size));
            button.setBackground(new Color(28, 28, 28, 100));
            button.setBorder(BorderFactory.createLineBorder(Color.decode("#1c1c1c")));
            button.setForeground(Color.WHITE);
        }
        MyButton[] blackButtons = new MyButton[]{zero, one, two, three, four, five, six, seven, eight, nine, dot, change_sign};
        for (MyButton button : blackButtons) {
            button.setFont(new Font("Arial", Font.PLAIN, text_size));
            button.setBackground(new Color(7, 7, 7));
            button.setBorder(BorderFactory.createLineBorder(Color.decode("#070707")));
            button.setForeground(Color.WHITE);
        }

        ArrayList<MyButton[]> listOLists = new ArrayList<>();
        listOLists.add(new MyButton[]{mod, delete_num, delete_all, delete_symbol});
        listOLists.add(new MyButton[]{div_one, square, rooting, division});
        listOLists.add(new MyButton[]{seven, eight, nine, multiplication});
        listOLists.add(new MyButton[]{four, five, six, subtraction});
        listOLists.add(new MyButton[]{one, two, three, addition});
        listOLists.add(new MyButton[]{change_sign, zero, dot, equal});
        for (int y = 0; y < 6; y++) {
            grid.gridy = y + 1;
            for (int x = 0; x < 4; x++) {
                grid.gridx = x;
                pane.add(listOLists.get(y)[x], grid);
            }
        }

        frame.pack();
        frame.setVisible(true);

        zero.addActionListener(e -> ButtonNumber("0"));

        one.addActionListener(e -> ButtonNumber("1"));

        two.addActionListener(e -> ButtonNumber("2"));

        three.addActionListener(e -> ButtonNumber("3"));

        four.addActionListener(e -> ButtonNumber("4"));

        five.addActionListener(e -> ButtonNumber("5"));

        six.addActionListener(e -> ButtonNumber("6"));

        seven.addActionListener(e -> ButtonNumber("7"));

        eight.addActionListener(e -> ButtonNumber("8"));

        nine.addActionListener(e -> ButtonNumber("9"));

        delete_num.addActionListener(e -> {
            if (Error)
                FixError();

            if (OnSecondNumber)
                secondNumber = "0";
            else
                firstNumber = "0";
            text.setText(firstNumber + symbol + secondNumber);
        });

        delete_all.addActionListener(e -> {
            if (Error)
                FixError();
            firstNumber = "";
            secondNumber = "";
            symbol = "";
            OnSecondNumber = false;
            text.setText("0");
        });

        delete_symbol.addActionListener(e -> {
            if (Error)
                FixError();
            if (!ReplaceNumber) {
                if (OnSecondNumber) {
                    if (!Objects.equals(secondNumber, "")) {
                        secondNumber = secondNumber.substring(0, secondNumber.length() - 1);
                        if (secondNumber.equals(""))
                            secondNumber = "0";
                    }
                } else {
                    if (!Objects.equals(firstNumber, "")) {
                        firstNumber = firstNumber.substring(0, firstNumber.length() - 1);
                        if (firstNumber.equals(""))
                            firstNumber = "0";
                    } else {
                        firstNumber = "0";
                    }
                }
            }
            text.setText(firstNumber + symbol + secondNumber);
        });

        div_one.addActionListener(e -> {
            if (OnSecondNumber) {
                if (Objects.equals(secondNumber, "") || Objects.equals(secondNumber, "0")) {
                    MakeError();
                } else {
                    if (Objects.equals(secondNumber, ""))
                        secondNumber = firstNumber;
                    float num = Float.parseFloat(secondNumber.replace(",", "."));
                    num = 1 / num;
                    secondNumber = Float.toString(num).replace(".", ",");
                    ReplaceNumber = true;
                }
            } else {
                if (Objects.equals(firstNumber, "") || Objects.equals(firstNumber, "0")) {
                    MakeError();
                } else {
                    float num = Float.parseFloat(firstNumber.replace(",", "."));
                    num = 1 / num;
                    firstNumber = Float.toString(num).replace(".", ",");
                    ReplaceNumber = true;
                }
            }
            if (Error)
                text.setText("Ошибка");
            else
                text.setText(firstNumber + symbol + secondNumber);
        });

        square.addActionListener(e -> {
            if (OnSecondNumber) {
                if (Objects.equals(secondNumber, ""))
                    secondNumber = firstNumber;
                float num = Float.parseFloat(secondNumber.replace(",", "."));
                num = num * num;
                secondNumber = Float.toString(num).replace(".", ",");
            } else {
                if (Objects.equals(firstNumber, ""))
                    firstNumber = "0";
                float num = Float.parseFloat(firstNumber.replace(",", "."));
                num = num * num;
                firstNumber = Float.toString(num).replace(".", ",");
            }
            ReplaceNumber = true;
            text.setText(firstNumber + symbol + secondNumber);
        });

        rooting.addActionListener(e -> {
            if (OnSecondNumber) {
                if (secondNumber.contains("-")) {
                    MakeError();
                } else {
                    if (Objects.equals(secondNumber, ""))
                        secondNumber = firstNumber;
                    double num = Double.parseDouble(secondNumber.replace(",", "."));
                    num = Math.sqrt(num);
                    secondNumber = Double.toString(num).replace(".", ",");
                    ReplaceNumber = true;
                }
            } else {
                if (firstNumber.contains("-")) {
                    MakeError();
                } else {
                    if (firstNumber.equals(""))
                        firstNumber = "0";
                    double num = Double.parseDouble(firstNumber.replace(",", "."));
                    num = Math.sqrt(num);
                    firstNumber = Double.toString(num).replace(".", ",");
                    ReplaceNumber = true;
                }
            }
            if (Error)
                text.setText("Ошибка");
            else
                text.setText(firstNumber + symbol + secondNumber);
        });

        division.addActionListener(e -> Operation("÷"));

        multiplication.addActionListener(e -> Operation("×"));

        subtraction.addActionListener(e -> Operation("-"));

        addition.addActionListener(e -> Operation("+"));

        mod.addActionListener(e -> Operation("%"));

        change_sign.addActionListener(e -> {
            if (OnSecondNumber) {
                if (Objects.equals(secondNumber, ""))
                    secondNumber = firstNumber;
                if (!Objects.equals(secondNumber, "0"))
                    if (!secondNumber.contains("-"))
                        secondNumber = "-" + secondNumber;
                    else
                        secondNumber = secondNumber.substring(1);
            } else {
                if (!Objects.equals(firstNumber, "0"))
                    if (!firstNumber.contains("-"))
                        firstNumber = "-" + firstNumber;
                    else
                        firstNumber = firstNumber.substring(1);
            }
            text.setText(firstNumber + symbol + secondNumber);
        });

        dot.addActionListener(e -> {
            if (OnSecondNumber) {
                if (Objects.equals(secondNumber, ""))
                    secondNumber += "0";
                if (!secondNumber.contains(","))
                    secondNumber += ",";
            } else {
                if (Objects.equals(firstNumber, ""))
                    firstNumber += "0";
                if (!firstNumber.contains(","))
                    firstNumber += ",";
            }
            text.setText(firstNumber + symbol + secondNumber);
        });

        equal.addActionListener(e -> {
            if (!Objects.equals(symbol, "")) {
                if (Objects.equals(secondNumber, ""))
                    secondNumber = firstNumber;

                float FirstNum = Float.parseFloat(firstNumber.replace(",", "."));
                float SecondNum = Float.parseFloat(secondNumber.replace(",", "."));
                float result = 0f;
                if (Objects.equals(symbol, "+")) {
                    result = FirstNum + SecondNum;
                } else if (Objects.equals(symbol, "-")) {
                    result = FirstNum - SecondNum;
                } else if (Objects.equals(symbol, "×")) {
                    result = FirstNum * SecondNum;
                } else if (Objects.equals(symbol, "÷")) {
                    if (SecondNum == 0)
                        MakeError();
                    else
                        result = FirstNum / SecondNum;
                } else if (Objects.equals(symbol, "%")) {
                    if (SecondNum == 0)
                        MakeError();
                    else
                        result = FirstNum % SecondNum;
                }
                OnSecondNumber = false;
                symbol = "";
                secondNumber = "";
                if (Error) {
                    text.setText("Ошибка");
                } else {
                    ReplaceNumber = true;
                    firstNumber = Float.toString(result).replace(".", ",");
                    text.setText(firstNumber + symbol + secondNumber);
                }
            }
        });
    }


    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        javax.swing.SwingUtilities.invokeLater(() -> {
            NewCalculator main = new NewCalculator();
            main.createGUI();
        });
    }
}
