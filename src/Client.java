import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Client implements ActionListener {
    JTextField textField;
    static JPanel a1;
    //    ek ke niche ek msg uske liye use BOX ka
    static Box vertical = Box.createVerticalBox();
    static   JFrame f = new JFrame();
    static DataOutputStream dos;
    Client(){
        f.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(7,94,84));
        panel.setBounds(0,0,450,70);
        panel.setLayout(null);
        f.add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image image = imageIcon.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon  image1  = new ImageIcon(image);
        JLabel label = new JLabel(image1);
        label.setBounds(5,20,25,25);
        panel.add(label);

        label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                System.exit(0);
            }
        });



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bunty.jpeg"));
        Image image3 = i1.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon  image2  = new ImageIcon(image3);
        JLabel label1 = new JLabel(image2);
        label1.setBounds(40,10,50,50);
        panel.add(label1);


        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image image4 = i2.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        ImageIcon  image5  = new ImageIcon(image4);
        JLabel label2 = new JLabel(image5);
        label2.setBounds(300,20,30,30);
        panel.add(label2);


        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image image7 = i3.getImage().getScaledInstance(35,30,Image.SCALE_DEFAULT);
        ImageIcon  image6  = new ImageIcon(image7);
        JLabel label3 = new JLabel(image6);
        label3.setBounds(360,20,35,30);
        panel.add(label3);


        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
        Image image9 = i4.getImage().getScaledInstance(10,25,Image.SCALE_DEFAULT);
        ImageIcon  image8  = new ImageIcon(image9);
        JLabel label4 = new JLabel(image8);
        label4.setBounds(420,20,10,25);
        panel.add(label4);



        JLabel label5 = new JLabel("Brother");
        label5.setBounds(110,15,170,18);
        label5.setForeground(Color.WHITE);
        label5.setFont(new Font("SAN_SERIF" , Font.BOLD, 18));
        panel.add(label5);


        JLabel status = new JLabel("Active Now");
        status.setBounds(110,35,100,18);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERIF" , Font.BOLD, 14));
        panel.add(status);


        a1 = new JPanel();
        a1.setBounds(5,75,440,458);
        f.add(a1);


        textField = new JTextField();
        textField.setBounds(5,538,310,40);
        textField.setFont(new Font("SAN_SERIF" , Font.PLAIN, 16));
        f.add(textField);

        JButton button = new JButton("Send");
        button.setBounds(320,538,123,40);
        button.setBackground(new Color(7,94,84));
        button.addActionListener(this);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("SAN_SERIF" , Font.PLAIN, 16));
        f.add(button);



        f.setSize(450,580);
        f.setLocation(700,70);
        f.setUndecorated(true);
        f.getContentPane().setBackground(Color.white);


        f.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String output = textField.getText();
            JPanel p2 = formatLabel(output);
            a1.setLayout(new BorderLayout());
//
            JPanel right = new JPanel(new BorderLayout());
            right.add(p2, BorderLayout.LINE_END);
            vertical.add(right);
            vertical.add(Box.createVerticalStrut(15));
            a1.add(vertical, BorderLayout.PAGE_START);

            dos.writeUTF(output);
            textField.setText("");
            f.repaint();
            f.invalidate();
            f.validate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static JPanel formatLabel(String out){
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        JLabel output = new JLabel("<html><p style=\"width: 150px\">" + out + "</p></html>");
        output.setFont(new Font("Tahoma" , Font.PLAIN , 16));
        output.setBackground(new Color(37,211,102));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15,15,15,50));
        p.add(output);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));
        p.add(time);
        return p;
    }

    public static void main(String[] args) {
        new Client();

        try{
//            socket ki halp se server se connect
            Socket s = new Socket("127.0.0.1" , 6001);
             dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());

            while (true){
                a1.setLayout(new BorderLayout());
                String msg = dis.readUTF();
                JPanel panel = formatLabel(msg);

                JPanel left = new JPanel(new BorderLayout());
                left.add(panel, BorderLayout.LINE_START);

                vertical.add(left);

                vertical.add(Box.createVerticalStrut(15));
                a1.add(vertical, BorderLayout.PAGE_START);
                f.validate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
