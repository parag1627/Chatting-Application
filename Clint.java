import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Clint extends JFrame implements ActionListener {
    JTextField text;
    JPanel a1;
    Box vertical = Box.createVerticalBox();

    Clint() {
        // setting layout null bcz we will create our own layout
        setLayout(null);

        // creating top border panel
        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(7, 94, 8));
        panel1.setBounds(0, 0, 350, 50);
        panel1.setLayout(null);
        add(panel1); // adding it top of frame


        // back arrow image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        // setting i1 into label
        back.setBounds(4, 12, 18, 18);
        panel1.add(back);
        // back button listner
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(1);
            }
        });

        // profile image
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/2.png"));
        Image i5 = i4.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel profile = new JLabel(i6);
        // setting i6 into label
        profile.setBounds(35, 5, 40, 40);
        panel1.add(profile);


        // video call image
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel video = new JLabel(i9);
        // setting i7 into label
        video.setBounds(230, 15, 25, 25);
        panel1.add(video);

        // audio call image
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel videoCall = new JLabel(i12);
        // setting i12 into label
        videoCall.setBounds(280, 15, 25, 25);
        panel1.add(videoCall);

        // three dot image
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel threeIcon = new JLabel(i15);
        // setting i15 into label
        threeIcon.setBounds(320, 15, 5, 25);
        panel1.add(threeIcon);

        // name of profile
        JLabel name = new JLabel("Parag Bro");
        name.setBounds(90, 12, 100, 14);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 16));
        panel1.add(name);

        // status
        JLabel status = new JLabel("Active now");
        status.setBounds(90, 32, 100, 10);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERIF", Font.BOLD, 10));
        panel1.add(status);

        // new panel for chat domain
        a1 = new JPanel();
        a1.setBounds(1, 51, 350, 400);
        add(a1);

        // typing function
        text = new JTextField();
        text.setBounds(3, 453, 245, 45);
        text.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        add(text);

        // Button to send msg
        JButton send = new JButton("Send");
        send.setBounds(250, 453, 100, 45);
        send.setBackground(new Color(7, 94, 8));
        send.setForeground(Color.WHITE);
        send.addActionListener(this);
        send.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        add(send);

        // size of J frame
        setSize(350, 500);

        // where J frame should start visible
        setLocation(800, 50);

        setUndecorated(true);
        // to set the background color
        getContentPane().setBackground(Color.BLACK);

        // making j frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String out = text.getText();
        JPanel p2 = formatLabel(out);
        a1.setLayout(new BorderLayout());
        JPanel right = new JPanel(new BorderLayout());
        right.add(p2, BorderLayout.LINE_END);
        vertical.add(right);
        vertical.add(Box.createVerticalStrut(15));
        a1.add(vertical, BorderLayout.PAGE_START);
        text.setText("");
        repaint();
        invalidate();
        validate();
    }

    public static JPanel formatLabel(String out) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


        JLabel output = new JLabel("<html><p style =\"width: 120px\">" + out + "</p></html>");
        output.setFont(new Font("Tahoma", Font.PLAIN, 16));
        output.setBackground(new Color(37, 211, 102));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15, 15, 15, 50));
        panel.add(output);


        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));
        panel.add(time);
        return panel;
    }
}