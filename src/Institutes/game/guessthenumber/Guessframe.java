package Institutes.game.guessthenumber;
/**
 * Guess(猜数字)版本9：
 * <p>
 * 增加功能：游戏计时、游戏关卡
 *
 * 2018年12月5日(说)：
 * 今天，在翻阅oneDrive的时候看到了一个名称为Guess.jar文件；打开后发现原来是一个写于2014年8月30日的猜数字游戏代码。
 * 那个时候我已经毕业且工作有近2年的时间，也是也是我自学Java的开始。
 * 在oneDrive中翻阅到了猜数字游戏的源码，很明显是一段学习的时候的代码；因为程序从开始到结束都写在了一个主方法里。
 * 能翻到自己在很久以前写的东西是一件感到特别幸福的事情；因为它使你看到了自己的过去。
 * 同时更想表达的一点就是感谢"微软"这家伟大的公司，帮助我保留了自己都已经遗忘掉的过去。
 * 还记得14年的时候各种"云盘"可谓是百花齐发，但多年后的今年真正实现为我保留过去记录的(并且没有删除我数据)只有微软。

 *
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JTextField;//随机函数
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.awt.Panel;
import java.awt.Color;
import java.awt.Canvas;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import javax.swing.ImageIcon;//显示xAxB


/**
 * 时钟

 */

import java.util.Timer;
import java.util.TimerTask;

public class Guessframe {

    private JFrame frame;

    private JFrame frame2;

    private JButton btnNewButton;

    private JButton btnNewButton_1;

    private JLabel lblNewLabel;

    private int Buttoncount = 0;

    private Random rad; //随机函数

    private int radx;//存放水机数

    private JTextField textField; //文本框

    /*a\b\c\d分别用来存储随机产生数种的四个数字 */

    private String suijizf;//将随机数处理成字符

    private String a;

    private String b;

    private String c;

    private String d;

    /*a1/b1/c1/d1分别用来存储用户输入的数字*/

    private String importzf;


    private int Slcount = 0;//胜利次数

    private String a1;

    private String b1;

    private String c1;

    private String d1;

    private JTextArea textArea;//显示文本

    private JLabel label;

    private JLabel label_1;

    private JLabel label_2;

    private JTextArea textArea2;//用来显示游戏规则

    private JMenuItem mntmNewMenuItem_1;

    private JMenuItem mntmNewMenuItem;


    private JLabel lblNewLabel_1;

    private int sj = 180;

    //public static Timertest timer=null;

    /**
     * Launch the application.
     */

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {

                    System.out.println("游戏开始！");

                    Guessframe window = new Guessframe();

                    window.frame.setVisible(true);

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }

        });

    }

    /**
     * Create the application.
     */

    public Guessframe() {

        initialize();

    }

    /**
     * Initialize the contents of the frame.
     */

    private void initialize() {

        frame = new JFrame();

        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("./image/***.png"));

        frame.getContentPane().setBackground(Color.CYAN);

        frame.setBounds(700, 300, 371, 461);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setResizable(false);//锁定窗体

        frame.setTitle("Guess(猜数字)");

        frame.getContentPane().setLayout(null);

        btnNewButton = new JButton("猜数字");

        btnNewButton.setBackground(Color.CYAN);

        btnNewButton.setFont(new Font("楷体", Font.PLAIN, 16));

        btnNewButton.setEnabled(false);

        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                Buttoncount++; //通过变量统计button点击次数

                //textArea.append(String.valueOf(Buttoncount)+"    "); //文本框换行显示

                if (Buttoncount >= 10) {

                    btnNewButton.setEnabled(false); //只能猜10次

                    JOptionPane.showMessageDialog(btnNewButton, "错误次数已达上限", "信息", 1);

                    lblNewLabel.setText(String.valueOf(radx)); //在标签中显示

                }

                /*

                 * 下面要数字猜的是否正确

                 * 1、做字符处理

                 */

                /* 分别获取随机数中的1234位*/

                suijizf = String.valueOf(radx);

                a = String.valueOf(suijizf.charAt(0));//取随机数的第一位

                b = String.valueOf(suijizf.charAt(1));

                c = String.valueOf(suijizf.charAt(2));

                d = String.valueOf(suijizf.charAt(3));

                /* 分别获取存储数中的1234位*/

                importzf = textField.getText();

                if (importzf.equals("") || textField.getText().length() <= 3) {

                    JOptionPane.showMessageDialog(mntmNewMenuItem, "请输入内容", "信息", 1);


                } else {

                    a1 = String.valueOf(importzf.charAt(0));

                    b1 = String.valueOf(importzf.charAt(1));

                    c1 = String.valueOf(importzf.charAt(2));

                    d1 = String.valueOf(importzf.charAt(3));

                    if (a.equals(a1) & b.equals(b1) & c.equals(c1) & d.equals(d1)) {

                        lblNewLabel.setText(String.valueOf(radx)); //在标签中显示

                        JOptionPane.showMessageDialog(btnNewButton, "恭喜您！用" + Buttoncount + "次，就猜对数字了！", "胜利", 1);

                        Slcount++; //每胜利一次，胜利变量就自动+1

                    } else if (b.equals(b1) & c.equals(c1) & d.equals(d1)) {

                        int count = 10 - Buttoncount;

                        if (count > 0) {

                            JOptionPane.showMessageDialog(btnNewButton, "您还有" + count + "次猜测机会！", "信息", 1);

                        }

                        textArea.append(importzf + "第二位、第三位和第四位答对了！" + "    ");//文本框换行显示

                    } else if (a.equals(a1) & c.equals(c1) & d.equals(d1)) {

                        int count = 10 - Buttoncount;

                        if (count > 0) {

                            JOptionPane.showMessageDialog(btnNewButton, "您还有" + count + "次猜测机会！", "信息", 1);

                        }

                        textArea.append(importzf + "第一位、第三位和第四位答对了！" + "    ");

                    } else if (a.equals(a1) & b.equals(b1) & c.equals(c1)) {

                        int count = 10 - Buttoncount;

                        if (count > 0) {

                            JOptionPane.showMessageDialog(btnNewButton, "您还有" + count + "次猜测机会！", "信息", 1);

                        }

                        textArea.append(importzf + "第一位、第二位和第三位答对了！" + "    ");


                    } else if (a.equals(a1) & b.equals(b1) & d.equals(d1)) {

                        int count = 10 - Buttoncount;

                        if (count > 0) {

                            JOptionPane.showMessageDialog(btnNewButton, "您还有" + count + "次猜测机会！", "信息", 1);

                        }

                        textArea.append(importzf + "第一位、第二位和第四位答对了！" + "    ");

                    } else if (c.equals(c1) & d.equals(d1)) {

                        int count = 10 - Buttoncount;

                        if (count > 0) {

                            JOptionPane.showMessageDialog(btnNewButton, "您还有" + count + "次猜测机会！", "信息", 1);

                        }

                        textArea.append(importzf + "第三位和第四位答对了！" + "    ");

                    } else if (b.equals(b1) & d.equals(d1)) {

                        int count = 10 - Buttoncount;

                        if (count > 0) {

                            JOptionPane.showMessageDialog(btnNewButton, "您还有" + count + "次猜测机会！", "信息", 1);

                        }

                        textArea.append(importzf + "第二位和第四位答对了！" + "    ");

                    } else if (b.equals(b1) & c.equals(c1)) {

                        int count = 10 - Buttoncount;

                        if (count > 0) {

                            JOptionPane.showMessageDialog(btnNewButton, "您还有" + count + "次猜测机会！", "信息", 1);

                        }

                        textArea.append(importzf + "第二位和第三位答对了！" + "    ");

                    } else if (a.equals(a1) & d.equals(d1)) {

                        int count = 10 - Buttoncount;

                        if (count > 0) {

                            JOptionPane.showMessageDialog(btnNewButton, "您还有" + count + "次猜测机会！", "信息", 1);

                        }

                        textArea.append(importzf + "第一位和第四位答对了！" + "    ");

                    } else if (a.equals(a1) & c.equals(c1)) {

                        int count = 10 - Buttoncount;

                        if (count > 0) {

                            JOptionPane.showMessageDialog(btnNewButton, "您还有" + count + "次猜测机会！", "信息", 1);

                        }

                        textArea.append(importzf + "第一位和第三位答对了！" + "    ");

                    } else if (a.equals(a1) & b.equals(b1)) {

                        int count = 10 - Buttoncount;

                        if (count > 0) {

                            JOptionPane.showMessageDialog(btnNewButton, "您还有" + count + "次猜测机会！", "信息", 1);

                        }

                        textArea.append(importzf + "第一位和第二位答对了！" + "    ");

                    } else if (d.equals(d1)) {

                        int count = 10 - Buttoncount;

                        if (count > 0) {

                            JOptionPane.showMessageDialog(btnNewButton, "您还有" + count + "次猜测机会！", "信息", 1);

                        }

                        textArea.append(importzf + "第四位答对了！" + "    ");

                    } else if (c.equals(c1)) {

                        int count = 10 - Buttoncount;

                        if (count > 0) {

                            JOptionPane.showMessageDialog(btnNewButton, "您还有" + count + "次猜测机会！", "信息", 1);

                        }

                        textArea.append(importzf + "第三位答对了！" + "    ");

                    } else if (b.equals(b1)) {

                        int count = 10 - Buttoncount;

                        if (count > 0) {

                            JOptionPane.showMessageDialog(btnNewButton, "您还有" + count + "次猜测机会！", "信息", 1);

                        }

                        textArea.append(importzf + "第二位答对了！" + "    ");

                    } else if (a.equals(a1)) {

                        int count = 10 - Buttoncount;

                        if (count > 0) {

                            JOptionPane.showMessageDialog(btnNewButton, "您还有" + count + "次猜测机会！", "信息", 1);

                        }

                        textArea.append(importzf + "第一位答对了！" + "    ");

                    } else {

                        int count = 10 - Buttoncount;

                        if (count > 0) {

                            JOptionPane.showMessageDialog(btnNewButton, "您还有" + count + "次猜测机会！", "信息", 1);

                        }

                        textArea.append(importzf + "未猜对，请继续！" + "    ");

                    }

                }

                //System.out.println(importzf);

                //System.out.println(Buttoncount);

            }

        });

        btnNewButton.setBounds(208, 171, 143, 28);

        frame.getContentPane().add(btnNewButton);

        btnNewButton_1 = new JButton();

        btnNewButton_1.setBackground(Color.CYAN);

        btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 16));

        btnNewButton_1.setText("开始游戏");

        btnNewButton_1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                /*

                 * 加个计时功能

                 */

                lblNewLabel_1.setEnabled(true);

                final Timer timerout = new Timer();

                timerout.schedule(new TimerTask() {

                    @Override

                    public void run() {

                // TODO Auto-generated method stub

                        sj = sj - 1;

                        lblNewLabel_1.setText(String.valueOf(sj));

                        if (sj == 0) {

                            btnNewButton.setEnabled(false);

                            timerout.cancel(); //计时器停止。

                            lblNewLabel_1.setEnabled(false);

                            JOptionPane.showMessageDialog(btnNewButton, "游戏结束", "提示", 1, null);

                            //Slcount

                            JOptionPane.showMessageDialog(btnNewButton, "您总共胜利" + Slcount + "次");

                        }

                        //通关

                        if (Slcount == 1) {

                            JOptionPane.showMessageDialog(btnNewButton, "恭喜！" + "\n" + "通过了（牛刀小试）！");

                            timerout.cancel(); //计时器停止。

                        } else if (Slcount == 2) {

                            JOptionPane.showMessageDialog(btnNewButton, "恭喜！" + "\n" + "通过了（初出茅庐）！");

                            timerout.cancel(); //计时器停止。

                        } else if (Slcount == 3) {

                            JOptionPane.showMessageDialog(btnNewButton, "哇！" + "\n" + "你是开挂了！该游戏您已经不用再玩了！");

                            timerout.cancel(); //计时器停止。

                        }

                    }

                }, 0, 1000);


                btnNewButton.setEnabled(true);

                lblNewLabel.setText("null"); //标签为null

                textField.setText("");//文本为空

                Buttoncount = 0;//计数为0

                textArea.setText("");

                rad = new Random();//加载随机数

                //radx= (int)(Math.random()*9000+1000);//产生随机数1000~9999

                int s1 = rad.nextInt(8) + 1;

                int s2 = rad.nextInt(10);

                int s3 = rad.nextInt(10);

                int s4 = rad.nextInt(10);

                if (s1 != s2 & s1 != s3 & s1 != s4 & s2 != s3 & s2 != s4 & s3 != s4) {

                    String x1 = String.valueOf(s1);

                    String x2 = String.valueOf(s2);

                    String x3 = String.valueOf(s3);

                    String x4 = String.valueOf(s4);

                    radx = Integer.valueOf(x1 + x2 + x3 + x4);

                    //lblNewLabel.setText(String.valueOf(radx)); //在标签中显示

                } else {

                    /*

                     * 得修复随机数重复的问题？？？？？？？？？？？

                     */

                    int s5 = rad.nextInt(6) + 1;//四位数的首位不能超过数字7

                    int rady = rad.nextInt(6);//判断随机数

                    if (rady == 0) {

                        String x5 = String.valueOf(s5);

                        radx = Integer.valueOf(x5 + "7" + "8" + "9");

                    } else if (rady == 1) {

                        String x5 = String.valueOf(s5);

                        radx = Integer.valueOf(x5 + "7" + "9" + "8");

                    } else if (rady == 2) {

                        String x5 = String.valueOf(s5);

                        radx = Integer.valueOf(x5 + "8" + "9" + "7");

                    } else if (rady == 3) {

                        String x5 = String.valueOf(s5);

                        radx = Integer.valueOf(x5 + "9" + "7" + "8");

                    } else if (rady == 4) {

                        String x5 = String.valueOf(s5);

                        radx = Integer.valueOf(x5 + "8" + "7" + "9");

                    } else {

                        String x5 = String.valueOf(s5);

                        radx = Integer.valueOf(x5 + "9" + "8" + "7");

                    }

                    //lblNewLabel.setText(String.valueOf(radx)); //在标签中显示

                }

            }

        });

        btnNewButton_1.setBounds(208, 80, 143, 28);

        frame.getContentPane().add(btnNewButton_1);

        /*        lblNewLabel 标签是用来显示随机产生的数字         */

        lblNewLabel = new JLabel("0000");

        lblNewLabel.setForeground(Color.RED);

        lblNewLabel.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 18));

        lblNewLabel.setBounds(53, 80, 120, 23);

        frame.getContentPane().add(lblNewLabel);

        /*        textField 文本框是用来输入猜的数字的         */

        textField = new JTextField();

        textField.setFont(new Font("Buxton Sketch", Font.PLAIN, 25));

        textField.setBounds(53, 172, 120, 28);

        frame.getContentPane().add(textField);

        textField.setColumns(10);

        /*

         * 设置文本框中不能不能输入字符

         */

        textField.addKeyListener(new KeyListener() {


            @Override

            public void keyPressed(KeyEvent e) {

            // TODO Auto-generated method stub


            }


            @Override

            public void keyReleased(KeyEvent e) {

            // TODO Auto-generated method stub


            }


            @Override

            public void keyTyped(KeyEvent e) {

            // TODO Auto-generated method stub

                Object o = e.getSource();

                if (o instanceof JTextField) {

                    char keyCh = e.getKeyChar();

                    if ((keyCh < '0') || (keyCh > '9') || textField.getText().length() > 3) { //不能输入字符，同事字符长度不能大于4个

                        if (keyCh != '') //回车字符

                            e.setKeyChar('\0');

                    }

                }

            }

        });

        /*        显示xAxB */

        textArea = new JTextArea();

        textArea.setFont(new Font("黑体", Font.PLAIN, 15));

        textArea.setBackground(new Color(224, 255, 255));

        textArea.setEditable(false);

        textArea.setBounds(15, 269, 336, 131);

        frame.getContentPane().add(textArea);

        textArea.setLineWrap(true);//自动换行


        label = new JLabel("\u6B63\u786E\u7B54\u6848\uFF1A");

        label.setFont(new Font("微软雅黑", Font.BOLD, 18));

        label.setBounds(15, 50, 102, 21);

        frame.getContentPane().add(label);


        label_1 = new JLabel("\u7ADE\u731C\u6570\u5B57\uFF1A");

        label_1.setFont(new Font("微软雅黑", Font.BOLD, 18));

        label_1.setBounds(15, 136, 102, 21);

        frame.getContentPane().add(label_1);


        label_2 = new JLabel("\u7ADE\u731C\u5206\u6790\uFF1A");

        label_2.setFont(new Font("微软雅黑", Font.BOLD, 18));

        label_2.setBounds(15, 233, 102, 21);

        frame.getContentPane().add(label_2);


        JMenuBar menuBar = new JMenuBar();

        menuBar.setBackground(Color.CYAN);

        menuBar.setBounds(0, 0, 365, 31);

        frame.getContentPane().add(menuBar);


        JMenu mnNewMenu = new JMenu("Help");

        mnNewMenu.setFont(new Font("Comic Sans MS", Font.BOLD, 22));

        menuBar.add(mnNewMenu);


        mntmNewMenuItem = new JMenuItem("Game Rules");//游戏规则

        mntmNewMenuItem.setIcon(new ImageIcon("./image/***.png"));

        mntmNewMenuItem.setFont(new Font("Buxton Sketch", Font.BOLD, 18));

        mntmNewMenuItem.setBackground(Color.CYAN);

        mnNewMenu.add(mntmNewMenuItem);

        /*

         * 游戏规则的事件侦听

         */

        mntmNewMenuItem.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent e) {

                // TODO Auto-generated method stub

                //System.out.print("-----");

                frame2 = new JFrame();

                frame2.setBounds(700, 300, 371, 461);//新窗口的大小

                frame2.setDefaultCloseOperation(frame2.DISPOSE_ON_CLOSE);//DISPOSE_ON_CLOSE 仅仅关闭当前窗口

                frame2.setVisible(true);

                frame2.setTitle("Game Rules");

                frame2.setResizable(false);//窗口锁定

                frame2.setIconImage(Toolkit.getDefaultToolkit().getImage("./image/***.png"));//窗体2的iocn

                //frame.getContentPane().add(btnNewButton);

                textArea2 = new JTextArea();

                textArea2.setFont(new Font("微软雅黑", Font.BOLD, 15));

                frame2.getContentPane().add(textArea2);

                textArea2.setBounds(700, 300, 371, 461);

                textArea2.setEditable(false);

                textArea2.setLineWrap(true);//自动换行

                textArea2.append("游戏规则:" + "\n" + "    电脑出一个四位数字，如果用户在规定时间内输入一个四位与电脑给出的四位相同，则竞猜成功。"

                        + "\n" + "\n" + "操作规则:" + "\n" + "    1、点击“开始游戏”后，程序会随机产生一个不重复四位的数字。"

                        + "\n" + "    2、用户可以在“竞猜框中”输入一个四位数字，进行竞猜。"

                        + "\n" + "    3、每次竞猜，程序会自动帮您分析您每次猜数的具体正确个数。"

                        + "\n" + "    4、每次竞猜用户只有10次机会。"

                        + "\n" + "    5、如果竞猜数与电脑数相同，则用户竞猜成功。"

                );

            }

        });

        mntmNewMenuItem_1 = new JMenuItem("About game");//关于游戏

        mntmNewMenuItem_1.setIcon(new ImageIcon("./image/***.png"));

        mntmNewMenuItem_1.setBackground(Color.CYAN);

        mntmNewMenuItem_1.setFont(new Font("Buxton Sketch", Font.BOLD, 18));

        mnNewMenu.add(mntmNewMenuItem_1);


        lblNewLabel_1 = new JLabel("");

        lblNewLabel_1.setFont(new Font("幼圆", Font.PLAIN, 40));

        lblNewLabel_1.setBounds(208, 216, 143, 38);

        frame.getContentPane().add(lblNewLabel_1);

        lblNewLabel_1.setText("计时器");

        lblNewLabel_1.setEnabled(false);

        //lblNewLabel_1.setHorizontalTextPosition(JLabel.CENTER);//lblNewLabel_1内容居中显示


        //timer=new Timertest();//加载时间


        //JOptionPane 关于对话框

        mntmNewMenuItem_1.addActionListener(new ActionListener() {

            @Override

            public void actionPerformed(ActionEvent arg0) {

            // TODO Auto-generated method stub

                Icon smallicon = new ImageIcon("./image/logo.png");//插入iocn

                JOptionPane.showMessageDialog(mntmNewMenuItem, "版本：0.0.9" + "\n" + "日期：20140828" + "\n" + "制作：小松鼠易易" + "\n" + "说明：本游戏仅供小伙伴娱乐", "About game", 1, smallicon); //有自定义图标的对话框

            }

        });

    }

}

