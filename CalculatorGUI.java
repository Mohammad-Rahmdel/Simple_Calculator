import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class CalculatorGUI {
    JFrame calcFrame;
    JTextArea display;
    ActionListener al;
    CalcKeyAdapter calcKeyAdapter;

    public ArrayList<String> memory;
    public int wait = 0;

    public CalculatorGUI() {

        memory = new ArrayList<>();

        calcFrame = new JFrame();
        calcFrame.setTitle("Calculator");
        calcFrame.setSize(500, 350);
        calcFrame.setLocation(100, 200);
        calcFrame.setLayout(new BoxLayout(calcFrame.getContentPane(), BoxLayout.Y_AXIS));

        display = new JTextArea();
        display.setToolTipText("This is a simple calculator");
        display.setEditable(false);
        display.setMaximumSize(new Dimension(1000, 1000));
        calcFrame.add(display);

        JScrollPane scrollPane = new JScrollPane(display);
        scrollPane.setPreferredSize(new Dimension(200, 100));
        scrollPane.setLocation(50, 20);
        calcFrame.getContentPane().add(scrollPane);

        JPanel simpleKeys = new JPanel();
        simpleKeys.setLayout(new GridLayout(5, 4));


        calcKeyAdapter = new CalcKeyAdapter();
        //calcFrame.addKeyListener(calcKeyAdapter);


        JMenuBar menu = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                System.exit(0);
            }
        });
        exitItem.setMnemonic('x');
        fileMenu.add(exitItem);

        menu.add(fileMenu);
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.ALT_MASK)); // alt + x
        calcFrame.setJMenuBar(menu);



//        ActionListener al = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//
//            }
//        }
//        al = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//
//            }
//        }
//        display.a;


        JButton btn7 = new JButton();
        btn7.setText("7");
        simpleKeys.add(btn7);
        btn7.addKeyListener(calcKeyAdapter);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = display.getText() + btn7.getText();
                display.setText(x);
            }
        });

        JButton btn8 = new JButton();
        btn8.setText("8");
        simpleKeys.add(btn8);
        btn8.addKeyListener(calcKeyAdapter);
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = display.getText() +btn8.getText();
                display.setText(x);
            }
        });

        JButton btn9 = new JButton();
        btn9.setText("9");
        simpleKeys.add(btn9);
        btn9.addKeyListener(calcKeyAdapter);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = display.getText() + btn9.getText();
                display.setText(x);
            }
        });


        JButton divBtn = new JButton();
        divBtn.setText("/");
        simpleKeys.add(divBtn);
        divBtn.addKeyListener(calcKeyAdapter);
        divBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                memory.add(display.getText());
                check();
                display.setText("");
                memory.add("/");
                wait ++;
            }
        });

        JButton btn4 = new JButton();
        btn4.setText("4");
        simpleKeys.add(btn4);
        btn4.addKeyListener(calcKeyAdapter);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = display.getText() +btn4.getText();
                display.setText(x);
            }
        });

        JButton btn5 = new JButton();
        btn5.setText("5");
        simpleKeys.add(btn5);
        btn5.addKeyListener(calcKeyAdapter);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = display.getText() +btn5.getText();
                display.setText(x);
            }
        });

        JButton btn6 = new JButton();
        btn6.setText("6");
        simpleKeys.add(btn6);
        btn6.addKeyListener(calcKeyAdapter);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = display.getText() +btn6.getText();
                display.setText(x);
            }
        });

        JButton mulBtn = new JButton();
        mulBtn.setText("*");
        simpleKeys.add(mulBtn);
        mulBtn.addKeyListener(calcKeyAdapter);
        mulBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                memory.add(display.getText());
                check();
                display.setText("");
                memory.add("*");
                wait++;
            }
        });

        JButton btn1 = new JButton();
        btn1.setText("1");
        simpleKeys.add(btn1);
        btn1.addKeyListener(calcKeyAdapter);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = display.getText() + btn1.getText();
                display.setText(x);
            }
        });

        JButton btn2 = new JButton();
        btn2.setText("2");
        simpleKeys.add(btn2);
        btn2.addKeyListener(calcKeyAdapter);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = display.getText() + btn2.getText();
                display.setText(x);
            }
        });


        JButton btn3 = new JButton();
        btn3.setText("3");
        simpleKeys.add(btn3);
        btn3.addKeyListener(calcKeyAdapter);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = display.getText() + btn3.getText();
                display.setText(x);
            }
        });

        JButton subBtn = new JButton();
        subBtn.setText("-");
        simpleKeys.add(subBtn);
        subBtn.addKeyListener(calcKeyAdapter);
        subBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (memory.isEmpty()){
                    if(display.getText().equals("")) {
                        display.setText("-");
                    }
                    else {
                        String x = display.getText();
                        memory.add(x);
                        check();
                        display.setText("-");
                    }
                }
                else if((memory.get(memory.size() - 1).equals("t") ||
                        memory.get(memory.size() - 1).equals("s") ||
                            memory.get(memory.size() - 1).equals("c")) &&
                                display.getText().substring(display.getText().length() - 1).equals("-")){
                    String x = display.getText() + "-";
                    display.setText(x);
                }
                else if((memory.get(memory.size() - 1).equals("t") ||
                            memory.get(memory.size() - 1).equals("s") ||
                                memory.get(memory.size() - 1).equals("c")) && (
                        (display.getText().length() == 4) || (display.getText().length() == 5))){
                    display.setText(display.getText() + "-");
                }
                else {
                    String x = display.getText();
                    memory.add(x);
                    check();
                    display.setText("-");
                }

            }
        });

        JButton pointBtn = new JButton();
        pointBtn.setText(".");
        simpleKeys.add(pointBtn);
        pointBtn.addKeyListener(calcKeyAdapter);
        pointBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = display.getText() + ".";
                display.setText(x);
            }
        });

        JButton zeroBtn= new JButton();
        zeroBtn.setText("0");
        simpleKeys.add(zeroBtn);
        zeroBtn.addKeyListener(calcKeyAdapter);
        zeroBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = display.getText() + zeroBtn.getText();
                display.setText(x);
            }
        });

        JButton doBtn = new JButton();
        doBtn.setText("=");
        simpleKeys.add(doBtn);
        doBtn.addKeyListener(calcKeyAdapter);
        doBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!(memory.get(memory.size() - 1).equals("t") ||
                        memory.get(memory.size() - 1).equals("s") ||
                        memory.get(memory.size() - 1).equals("c"))) {
                    String x = display.getText();
                    memory.add(x);
                }

                check();
                display.setText(calculate());


            }
        });


        JButton sumBtn = new JButton();
        sumBtn.setText("+");
        simpleKeys.add(sumBtn);
        sumBtn.addKeyListener(calcKeyAdapter);
        sumBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String x = display.getText();
                //System.out.println(x);
                memory.add(x);
                check();
                //memory.add("+");
                display.setText("");
            }
        });


        JButton btnSin = new JButton();
        btnSin.setText("Sin");
        simpleKeys.add(btnSin);
        btnSin.addKeyListener(calcKeyAdapter);
        btnSin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(display.getText().equals(""))
                    display.setText("Sin ");
                else
                    display.setText("-Sin ");
                memory.add("s");
                memory.add("s");
                wait++;
            }
        });


        JButton btnCos = new JButton();
        btnCos.setText("Cos");
        simpleKeys.add(btnCos);
        btnCos.addKeyListener(calcKeyAdapter);
        btnCos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(display.getText().equals(""))
                    display.setText("Cos ");
                else
                    display.setText("-Cos ");
                memory.add("c");
                memory.add("c");
                wait++;
            }
        });

        JButton btnTan = new JButton();
        btnTan.setText("Tan");
        simpleKeys.add(btnTan);
        btnTan.addKeyListener(calcKeyAdapter);
        btnTan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(display.getText().equals(""))
                    display.setText("Tan ");
                else
                    display.setText("-Tan ");
                memory.add("t");
                memory.add("t");
                wait++;
            }
        });

        JButton btnClr = new JButton();
        btnClr.setText("Clear");
        simpleKeys.add(btnClr);
        btnClr.addKeyListener(calcKeyAdapter);
        btnClr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                display.setText("");
                memory.removeAll(memory);
                wait = 0;
            }
        });



        try {
            for (UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())){
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Nimbus theme failed!");
        }

        JTabbedPane tabs = new JTabbedPane();
        tabs.setBounds(50, 50, 200, 200);
        tabs.add("simple", simpleKeys);
        calcFrame.add(tabs);
        calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calcFrame.setVisible(true);

//        ButtonListener btnLst = new ButtonListener();
//        CaclKeyAdapter kLst = new CaclKeyAdapter();
//        JButton aBtn = new JButton();
//        aBtn.setText("+");
//        aBtn.addActionListener(btnLst);
//        aBtn.addKeyListener(kLst);


    }


    public void check(){
        while (wait > 0){
            String operand = memory.remove(memory.size() - 1);
            String operator = memory.remove(memory.size() - 1);
            if(operator.equals("*")){
                String operand2 = memory.remove(memory.size() - 1);
                //System.out.println(operand2);
                double result = Double.parseDouble(operand) * Double.parseDouble(operand2);
                memory.add(String.valueOf(result));
            }
            else if(operator.equals("/")){
                String operand2 = memory.remove(memory.size() - 1);
                double result = Double.parseDouble(operand2) / Double.parseDouble(operand);
                memory.add(String.valueOf(result));

            }
            else if(operator.equals("t")){
                double arg;
                if(operand.equals("t")){
                    if(display.getText().substring(0,1).equals("T"))
                        arg = (Double.parseDouble(display.getText().substring(4)) * Math.PI)/180;
                    else
                        arg = -(Double.parseDouble(display.getText().substring(5)) * Math.PI)/180;
                    memory.add(String.valueOf(Math.tan(arg)));
                }
                else {
                    memory.remove(memory.size()-1);
                    if(display.getText().substring(0,1).equals("T")) {
                        operand = operand.substring(4);
                        arg = (Double.parseDouble(operand) * Math.PI) / 180;
                    }
                    else {
                        operand = operand.substring(5);
                        arg = -(Double.parseDouble(operand) * Math.PI) / 180;
                    }
                    memory.add(String.valueOf(Math.tan(arg)));
                }

            }
            else if(operator.equals("s")){
                double arg;
                if(operand.equals("s")){
                    if(display.getText().substring(0,1).equals("S"))
                        arg = (Double.parseDouble(display.getText().substring(4)) * Math.PI)/180;
                    else
                        arg = -(Double.parseDouble(display.getText().substring(5)) * Math.PI)/180;
                    memory.add(String.valueOf(Math.sin(arg)));
                }
                else {
                    memory.remove(memory.size()-1);
                    if(display.getText().substring(0,1).equals("S")) {
                        operand = operand.substring(4);
                        arg = (Double.parseDouble(operand) * Math.PI) / 180;
                    }
                    else {
                        operand = operand.substring(5);
                        arg = -(Double.parseDouble(operand) * Math.PI) / 180;
                    }
                    memory.add(String.valueOf(Math.sin(arg)));
                }

            }
            else if(operator.equals("c")){
                double arg;
                if(operand.equals("c")){
//                    memory.add(String.valueOf(Math.cos(arg)));
                    if(display.getText().substring(0,1).equals("C")) {
                        arg = (Double.parseDouble(display.getText().substring(4)) * Math.PI) / 180;
                        memory.add(String.valueOf(Math.cos(arg)));
                    }
                    else {
                        arg = -(Double.parseDouble(display.getText().substring(5)) * Math.PI) / 180;
                        memory.add(String.valueOf(-Math.cos(arg)));
                    }

                }
                else {
                    memory.remove(memory.size()-1);
                    if(display.getText().substring(0,1).equals("C")) {
                        operand = operand.substring(4);
                        arg = (Double.parseDouble(operand) * Math.PI) / 180;
                    }
                    else {
                        operand = operand.substring(5);
                        arg = -(Double.parseDouble(operand) * Math.PI) / 180;
                    }
                    memory.add(String.valueOf(Math.cos(arg)));
                }

            }

            wait--;
        }
    }

    public String calculate(){
        double result = 0;
        for(String nums : memory)
            result += Double.parseDouble(nums);

        memory.removeAll(memory);
        //memory.add(String.valueOf(result));

        if(Math.abs(result) < 0.00000001)
            result = 0;


        return String.valueOf(result);
    }



    private class CalcKeyAdapter implements KeyListener {
        public void keyReleased(KeyEvent e) {
            int kReleased = e.getKeyCode();
            //System.out.println("A key was released: " + kReleased);
            String num = "";
            switch (kReleased) {
                case KeyEvent.VK_0: {
                    num = display.getText();
                    display.setText(num + "0");
                    break;
                }
                case KeyEvent.VK_1: {
                    num = display.getText();
                    display.setText(num + "1");
                    break;
                }
                case KeyEvent.VK_2: {
                    num = display.getText();
                    display.setText(num + "2");
                    break;
                }
                case KeyEvent.VK_3: {
                    num = display.getText();
                    display.setText(num + "3");
                    break;
                }
                case KeyEvent.VK_4: {
                    num = display.getText();
                    display.setText(num + "4");
                    break;
                }
                case KeyEvent.VK_5: {
                    num = display.getText();
                    display.setText(num + "5");
                    break;
                }
                case KeyEvent.VK_6: {
                    num = display.getText();
                    display.setText(num + "6");
                    break;
                }
                case KeyEvent.VK_7: {
                    num = display.getText();
                    display.setText(num + "7");
                    break;
                }
                case KeyEvent.VK_8: {
                    num = display.getText();
                    display.setText(num + "8");
                    break;
                }
                case KeyEvent.VK_9: {
                    num = display.getText();
                    display.setText(num + "9");
                    break;
                }

                case KeyEvent.VK_EQUALS: {
                    if(!(memory.get(memory.size() - 1).equals("t") ||
                            memory.get(memory.size() - 1).equals("s") ||
                            memory.get(memory.size() - 1).equals("c"))) {
                        String x = display.getText();
                        memory.add(x);
                    }

                    check();
                    display.setText(calculate());
                    break;
                }

                case KeyEvent.VK_C: { // cos
                    if(display.getText().equals(""))
                        display.setText("Cos ");
                    else
                        display.setText("-Cos ");
                    memory.add("c");
                    memory.add("c");
                    wait++;
                    break;
                }

                case KeyEvent.VK_S: { // sin
                    if(display.getText().equals(""))
                        display.setText("Sin ");
                    else
                        display.setText("-Sin ");
                    memory.add("s");
                    memory.add("s");
                    wait++;
                    break;
                }

                case KeyEvent.VK_T: { // tan
                    if(display.getText().equals(""))
                        display.setText("Tan ");
                    else
                        display.setText("-Tan ");
                    memory.add("t");
                    memory.add("t");
                    wait++;
                    break;
                }

                case KeyEvent.VK_ENTER: { // Enter = clear
                    display.setText("");
                    memory.removeAll(memory);
                    wait = 0;
                    break;
                }

                case KeyEvent.VK_PERIOD: {
                    String x = display.getText() + ".";
                    display.setText(x);
                    break;
                }
                case KeyEvent.VK_MINUS: {
                    if (memory.isEmpty()){
                        if(display.getText().equals("")) {
                            display.setText("-");
                        }
                        else {
                            String x = display.getText();
                            memory.add(x);
                            check();
                            display.setText("-");
                        }
                    }
                    else if((memory.get(memory.size() - 1).equals("t") ||
                            memory.get(memory.size() - 1).equals("s") ||
                            memory.get(memory.size() - 1).equals("c")) &&
                            display.getText().substring(display.getText().length() - 1).equals("-")){
                        String x = display.getText() + "-";
                        display.setText(x);
                    }
                    else if((memory.get(memory.size() - 1).equals("t") ||
                            memory.get(memory.size() - 1).equals("s") ||
                            memory.get(memory.size() - 1).equals("c")) && (
                            (display.getText().length() == 4) || (display.getText().length() == 5))){
                        display.setText(display.getText() + "-");
                    }
                    else {
                        String x = display.getText();
                        memory.add(x);
                        check();
                        display.setText("-");
                    }
                    break;
                }

                default:
                    break;

            }

        }

        @Override
        public void keyTyped(KeyEvent e) { // Some code
        }

        @Override
        public void keyPressed(KeyEvent e) { // Some code
        }

    }


}

