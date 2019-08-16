package Institutes.changefilename.window;

import Institutes.changefilename.Kernel.DiskScan;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.ArrayList;

/**
 * 类：toolwindow
 * 作用：变更文件名的窗口程序
 */

public class toolwindow {

    private JFrame frame;
    private final String filePath="./Filedirectory";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    toolwindow window = new toolwindow();
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
    public toolwindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setTitle("小工具");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBounds(12, 12, 150, 246);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 12, 127, 222);
        panel.add(scrollPane);

        JTextArea textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(269, 12, 169, 246);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(12, 12, 145, 222);
        panel_1.add(scrollPane_1);

        JTextArea textArea_1 = new JTextArea();
        scrollPane_1.setViewportView(textArea_1);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(174, 12, 83, 246);
        frame.getContentPane().add(panel_2);
        panel_2.setLayout(null);

        JButton btnNewButton = new JButton("Start");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<String> oldnameList=new ArrayList<String>();

                String[] stroldName = textArea.getText().split("\n");
                for (String str : stroldName) {
                    oldnameList.add(str);

                }

                System.out.println(oldnameList);

                List<String> newnameList=new ArrayList<String>();
                String[] strnewName = textArea_1.getText().split("\n");
                for (String str : strnewName) {
                    newnameList.add(str);

                }

                System.out.println(newnameList);

                //开始替换
                for(int i=0;i<oldnameList.size();i++) {
                    DiskScan.renameFile(filePath,oldnameList.get(i),newnameList.get(i));

                }
                JOptionPane.showMessageDialog(null, "改名成功");

            }
        });
        btnNewButton.setBounds(0, 116, 83, 23);
        panel_2.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("read");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText(DiskScan.getFileName(new File(filePath)));
            }
        });
        btnNewButton_1.setBounds(0, 81, 83, 23);
        panel_2.add(btnNewButton_1);
    }
}