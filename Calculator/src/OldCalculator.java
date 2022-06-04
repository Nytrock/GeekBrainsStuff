import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class OldCalculator {
    int first1 = 0;
    int second2 = 0;
    int z = 0;
    String tmp = " ";
    String tmm = " ";

    private enum Action{
        PLUS, MINUS, MULTIPLY, DIVIDE, NONE
    }

    private static class Data{
        private Action whichButton = Action.NONE;
        public Action getWhichButton() {
            return whichButton;
        }
        public void setWhichButton(Action whichButton) {
            this.whichButton = whichButton;
        }
    }
    public void createGUI(){



        final Data buffer = new Data();
        // создание окна программы
        JFrame frame = new JFrame("Калькулятор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(310,440));
        frame.pack();
        frame.setVisible(true);

        // создание кнопок
        JTextField first = new JTextField(5);
        JTextField znak = new JTextField(5);
        JTextField second = new JTextField(5);
        JButton sbros = new JButton("Сброс");
        JButton involution = new JButton("x²");
        JButton cub = new JButton("x³");
        JButton none = new JButton("1/x");
        JButton koren = new JButton("√x");
        JButton otrich = new JButton("+/-");
        JButton addition = new JButton("+");
        JButton substraction = new JButton("-");
        JButton multiplication = new JButton("*");
        JButton division = new JButton("/");
        JButton equal = new JButton("=");
        JButton zero = new JButton("0");
        JButton one = new JButton("1");
        JButton two = new JButton("2");
        JButton three = new JButton("3");
        JButton four = new JButton("4");
        JButton five = new JButton("5");
        JButton six = new JButton("6");
        JButton seven = new JButton("7");
        JButton eight = new JButton("8");
        JButton nine = new JButton("9");

        // добавление кнопок в окно программы
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(6, 0, 5, 12);
        panel.setLayout(layout); // объявления метода расположения содержимого внутри окна
        JTextField field = new JTextField(5); //в параметре указывается кол-во символов, которое можно ввести
        panel.add(first);
        panel.add(znak);
        panel.add(second);
        panel.add(none);
        panel.add(koren);
        panel.add(involution);
        panel.add(cub);
        panel.add(division);
        panel.add(seven);
        panel.add(eight);
        panel.add(nine);
        panel.add(multiplication);
        panel.add(four);
        panel.add(five);
        panel.add(six);
        panel.add(substraction);
        panel.add(one);
        panel.add(two);
        panel.add(three);
        panel.add(addition);
        panel.add(sbros);
        panel.add(zero);
        panel.add(otrich);
        panel.add(equal);

        frame.setContentPane(panel); // добавление содержимого в саму программу

        // создание поля ввода

        ActionListener fieldListener = e -> {


        };

        field.addActionListener(fieldListener);

        zero.addActionListener(e -> {
            if(tmp.length() <= 5 && z == 0 && first1 != 0){
                if(first1 >= 0) {
                    tmp += "0";
                    first.setText(tmp);
                    first1 = first1 * 10;
                }else{
                    tmp += "0";
                    first.setText("-" + tmp);
                    first1 = first1 * 10;
                }
            }

            if(tmm.length() <= 5 && z == 1 && first1 != 0) {
                if (second2 >= 0) {
                    tmm += "0";
                    second.setText(tmm);
                    second2 = second2 * 10;
                } else {
                    tmm += "0";
                    second.setText("-" + tmm);
                    second2 = second2 * 10;
                }
            }
        });

        one.addActionListener(e -> {
            if(tmp.length() <= 5 && z == 0){
                if(first1 >= 0) {
                    tmp += "1";
                    first.setText(tmp);
                    first1 = first1 * 10 + 1;
                }else{
                    tmp += "1";
                    first.setText("-" + tmp);
                    first1 = first1 * 10 - 1;
                }
            }

            if(tmm.length() <= 5 && z == 1){
                if(second2 >= 0) {
                    tmm += "1";
                    second.setText(tmm);
                    second2 = second2 * 10 + 1;
                }else {
                    tmm += "1";
                    second.setText("-" + tmm);
                    second2 = second2 * 10 - 1;
                }
            }
        });

        two.addActionListener(e -> {
            if(tmp.length() <= 5 && z == 0){
                if(first1 >= 0) {
                    tmp += "2";
                    first.setText(tmp);
                    first1 = first1 * 10 + 2;
                }else{
                    tmp += "2";
                    first.setText("-" + tmp);
                    first1 = first1 * 10 - 2;
                }
            }

            if(tmm.length() <= 5 && z == 1){
                if(second2 >= 0) {
                    tmm += "2";
                    second.setText(tmm);
                    second2 = second2 * 10 + 2;
                }else {
                    tmm += "2";
                    second.setText("-" + tmm);
                    second2 = second2 * 10 - 2;
                }
            }
        });

        three.addActionListener(e -> {
            if(tmp.length() <= 5 && z == 0){
                if(first1 >= 0) {
                    tmp += "3";
                    first.setText(tmp);
                    first1 = first1 * 10 + 3;
                }else{
                    tmp += "3";
                    first.setText("-" + tmp);
                    first1 = first1 * 10 - 3;
                }
            }

            if(tmm.length() <= 5 && z == 1) {
                if (second2 >= 0) {
                    tmm += "3";
                    second.setText(tmm);
                    second2 = second2 * 10 + 3;
                } else {
                    tmm += "3";
                    second.setText("-" + tmm);
                    second2 = second2 * 10 - 3;
                }
            }
        });

        four.addActionListener(e -> {
            if(tmp.length() <= 5 && z == 0){
                if(first1 >= 0) {
                    tmp += "4";
                    first.setText(tmp);
                    first1 = first1 * 10 + 4;
                }else{
                    tmp += "4";
                    first.setText("-" + tmp);
                    first1 = first1 * 10 - 4;
                }
            }

            if(tmm.length() <= 5 && z == 1){
                if(second2 >= 0) {
                    tmm += "4";
                    second.setText(tmm);
                    second2 = second2 * 10 + 4;
                }else {
                    tmm += "4";
                    second.setText("-" + tmm);
                    second2 = second2 * 10 - 4;
                }
            }
        });

        five.addActionListener(e -> {
            if(tmp.length() <= 5 && z == 0){
                if(first1 >= 0) {
                    tmp += "5";
                    first.setText(tmp);
                    first1 = first1 * 10 + 5;
                }else{
                    tmp += "5";
                    first.setText("-" + tmp);
                    first1 = first1 * 10 - 5;
                }
            }

            if(tmm.length() <= 5 && z == 1){
                if(second2 >= 0) {
                    tmm += "5";
                    second.setText(tmm);
                    second2 = second2 * 10 + 5;
                }else {
                    tmm += "5";
                    second.setText("-" + tmm);
                    second2 = second2 * 10 - 5;
                }
            }
        });

        six.addActionListener(e -> {
            if(tmp.length() <= 5 && z == 0){
                if(first1 >= 0) {
                    tmp += "6";
                    first.setText(tmp);
                    first1 = first1 * 10 + 6;
                }else{
                    tmp += "6";
                    first.setText("-" + tmp);
                    first1 = first1 * 10 - 6;
                }
            }

            if(tmm.length() <= 5 && z == 1){
                if(second2 >= 0) {
                    tmm += "6";
                    second.setText(tmm);
                    second2 = second2 * 10 + 6;
                }else {
                    tmm += "6";
                    second.setText("-" + tmm);
                    second2 = second2 * 10 - 6;
                }
            }
        });

        seven.addActionListener(e -> {
            if(tmp.length() <= 5 && z == 0){
                if(first1 >= 0) {
                    tmp += "7";
                    first.setText(tmp);
                    first1 = first1 * 10 + 7;
                }else{
                    tmp += "7";
                    first.setText("-" + tmp);
                    first1 = first1 * 10 - 7;
                }
            }

            if(tmm.length() <= 5 && z == 1){
                if(second2 >= 0) {
                    tmm += "7";
                    second.setText(tmm);
                    second2 = second2 * 10 + 7;
                }else {
                    tmm += "7";
                    second.setText("-" + tmm);
                    second2 = second2 * 10 - 7;
                }
            }
        });

        eight.addActionListener(e -> {
            if(tmp.length() <= 5 && z == 0){
                if(first1 >= 0) {
                    tmp += "8";
                    first.setText(tmp);
                    first1 = first1 * 10 + 8;
                }else{
                    tmp += "8";
                    first.setText("-" + tmp);
                    first1 = first1 * 10 - 8;
                }
            }

            if(tmm.length() <= 5 && z == 1) {
                if (second2 >= 0) {
                    tmm += "8";
                    second.setText(tmm);
                    second2 = second2 * 10 + 8;
                } else {
                    tmm += "8";
                    second.setText("-" + tmm);
                    second2 = second2 * 10 - 8;
                }
            }
        });

        nine.addActionListener(e -> {
            if(tmp.length() <= 5 && z == 0){
                if(first1 >= 0) {
                    tmp += "9";
                    first.setText(tmp);
                    first1 = first1 * 10 + 9;
                }else{
                    tmp += "9";
                    first.setText("-" + tmp);
                    first1 = first1 * 10 - 9;
                }
            }

            if(tmm.length() <= 5 && z == 1){
                if(second2 >= 0) {
                    tmm += "9";
                    second.setText(tmm);
                    second2 = second2 * 10 + 9;
                }else {
                    tmm += "9";
                    second.setText("-" + tmm);
                    second2 = second2 * 10 - 9;
                }
            }
        });

        sbros.addActionListener(e -> {
            first1 = 0;
            second2 = 0;
            z = 0;
            tmp = " ";
            tmm = " ";
            first.setText("");
            znak.setText("");
            second.setText("");
        });

        involution.addActionListener(e -> {
            if(z < 2 && first1 != 0) {
                Integer result = first1 * first1;
                first.setText("Ответ:");
                znak.setText(String.valueOf(result));
                second.setText(" ");
                z = 3;
            }
            if(first1 * first1 > 999999999){
                first.setText("Ошибка - ");
                znak.setText("огромное");
                second.setText(" число");
                z = 3;
            }
        });

        cub.addActionListener(e -> {
            if(z < 2 && first1 != 0) {
                Integer result = first1 * first1 * first1;
                first.setText("Ответ:");
                znak.setText(String.valueOf(result));
                second.setText(" ");
                z = 3;
            }
            if(first1 * first1 * first1 > 999999999 || first1 * first1 * first1 < -999999999){
                first.setText("Ошибка - ");
                znak.setText("огромное");
                second.setText(" число");
                z = 3;
            }
        });

        koren.addActionListener(e -> {
            if(z < 2 && first1 != 0) {
                DecimalFormat decimalFormat = new DecimalFormat("#.#####");
                double result = Math.sqrt(first1);
                String i = decimalFormat.format(result);
                first.setText("Ответ:");
                znak.setText(i);
                second.setText(" ");
                z = 3;
            }
            if (first1 < 0){
                first.setText("Ошибка");
                znak.setText(" ");
                second.setText(" ");
                z = 3;
            }
            if(Math.sqrt(first1) > 999999999){
                first.setText("Ошибка - ");
                znak.setText("огромное");
                second.setText(" число");
                z = 3;
            }
        });

        otrich.addActionListener(e -> {
            if(z == 0){
                first1 = first1 * -1;
                if(first1 < 0){
                    first.setText("-" + tmp);
                } else{
                    first.setText(tmp);
                }
            }

            if(z == 1){
                second2 = second2 * -1;
                if(second2 < 0){
                    second.setText("-" + tmm);
                } else{
                    second.setText(tmm);
                }
            }
        });

        none.addActionListener(e -> {
            if(z < 2) {
                double a = 1;
                double b = first1;
                DecimalFormat decimalFormat = new DecimalFormat("#.#####");
                String i = decimalFormat.format(a / b);
                first.setText("Примерно:");
                znak.setText(i);
                second.setText(" ");
                z = 3;
            }
        });
        ActionListener buttonPlus = e -> {
            if(z < 2) {
                znak.setText("+");
                buffer.setWhichButton(Action.PLUS);
                z = 1;

                zero.addActionListener(e1 -> {
                });

                one.addActionListener(e12 -> {
                });

                two.addActionListener(e13 -> {
                });

                three.addActionListener(e14 -> {
                });

                four.addActionListener(e15 -> {
                });

                five.addActionListener(e16 -> {
                });

                six.addActionListener(e17 -> {
                });

                seven.addActionListener(e18 -> {
                });

                eight.addActionListener(e19 -> {
                });

                nine.addActionListener(e110 -> {
                });
            }
        };
        addition.addActionListener(buttonPlus);

        ActionListener buttonMinus = e -> {
            if(z < 2) {
                znak.setText("-");
                buffer.setWhichButton(Action.MINUS);
                z = 1;

                zero.addActionListener(e111 -> {
                });

                one.addActionListener(e112 -> {
                });

                two.addActionListener(e113 -> {
                });

                three.addActionListener(e114 -> {
                });

                four.addActionListener(e115 -> {
                });

                five.addActionListener(e116 -> {
                });

                six.addActionListener(e117 -> {
                });

                seven.addActionListener(e118 -> {
                });

                eight.addActionListener(e119 -> {
                });

                nine.addActionListener(e120 -> {
                });
            }
        };
        substraction.addActionListener(buttonMinus);

        ActionListener buttonDivide = e -> {
            if(z < 2) {
                znak.setText("/");
                buffer.setWhichButton(Action.DIVIDE);
                z = 1;

                zero.addActionListener(e121 -> {
                });

                one.addActionListener(e122 -> {
                });

                two.addActionListener(e123 -> {
                });

                three.addActionListener(e124 -> {
                });

                four.addActionListener(e125 -> {
                });

                five.addActionListener(e126 -> {
                });

                six.addActionListener(e127 -> {
                });

                seven.addActionListener(e128 -> {
                });

                eight.addActionListener(e129 -> {
                });

                nine.addActionListener(e130 -> {
                });
            }
        };
        division.addActionListener(buttonDivide);

        ActionListener buttonMultiply = e -> {
            if(z < 2) {
                znak.setText("*");
                buffer.setWhichButton(Action.MULTIPLY);
                z = 1;

                zero.addActionListener(e131 -> {
                });

                one.addActionListener(e132 -> {
                });

                two.addActionListener(e133 -> {
                });

                three.addActionListener(e134 -> {
                });

                four.addActionListener(e135 -> {
                });

                five.addActionListener(e136 -> {
                });

                six.addActionListener(e137 -> {
                });

                seven.addActionListener(e138 -> {
                });

                eight.addActionListener(e139 -> {
                });

                nine.addActionListener(e140 -> {
                });
            }
        };
        multiplication.addActionListener(buttonMultiply);

        ActionListener buttonEqaul = e -> {
            if(z < 2) {
                if (buffer.getWhichButton() == Action.PLUS) {
                    if(second2 != 0) {
                        Integer result = second2 + first1;
                        first.setText("Ответ:");
                        znak.setText(String.valueOf(result));
                        second.setText(" ");
                    }
                    if(second2 == 0){
                        Integer result = first1 + first1;
                        first.setText("Ответ:");
                        znak.setText(String.valueOf(result));
                        second.setText(" ");
                    }
                }

                if (buffer.getWhichButton() == Action.MINUS) {
                    if(second2 != 0) {
                        Integer result = second2 - first1;
                        first.setText("Ответ:");
                        znak.setText(String.valueOf(result));
                        second.setText(" ");
                    }
                    if(second2 == 0){
                        first.setText("Ответ:");
                        znak.setText("0");
                        second.setText(" ");
                    }
                }

                if (buffer.getWhichButton() == Action.MULTIPLY) {
                    if(second2 != 0) {
                        if(first1 * second2 > 999999999 || first1 * second2 < -999999999){
                            first.setText("Ошибка - ");
                            znak.setText("огромное");
                            second.setText(" число");
                        }
                        else {
                            Integer result = second2 * first1;
                            first.setText("Ответ:");
                            znak.setText(String.valueOf(result));
                            second.setText(" ");
                        }
                    }
                    if(second2 == 0){
                        Integer result = first1 * first1;
                        first.setText("Ответ:");
                        znak.setText(String.valueOf(result));
                        second.setText(" ");
                    }
                }

                if (buffer.getWhichButton() == Action.DIVIDE) {
                    if(second2 == 0){
                        first.setText("Ответ:");
                        znak.setText("1");
                    }
                    else if (first1 % second2 != 0) {
                        first.setText("Примерно:");
                        double i = first1;
                        double j = second2;
                        DecimalFormat decimalFormat = new DecimalFormat("#.#####");
                        String m = decimalFormat.format(i / j);
                        znak.setText(String.valueOf(m));
                    } else {
                        first.setText("Ответ:");
                        znak.setText(String.valueOf(first1 / second2));
                    }
                    second.setText(" ");
                }
                z++;
            }
        };
        equal.addActionListener(buttonEqaul);
    }


    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        javax.swing.SwingUtilities.invokeLater(() -> {
            OldCalculator main = new OldCalculator();
            main.createGUI();

        });
    }
}
