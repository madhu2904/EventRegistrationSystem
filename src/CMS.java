import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border.*;
import java.awt.*;
import java.sql.*;

class OMS{
    JFrame frame1;//main page frame
    JFrame frame2;//customer frame
    JFrame frame3;//for event register page of customer

    //the main page
    public void hello(){

    frame1=new JFrame("Role selection");
    JPanel panel1=new JPanel(){
        @Override
        protected void paintComponent(Graphics g)
        {
            ImageIcon imageIcon=new ImageIcon("event.jpg");
            Image image=imageIcon.getImage();
            g.drawImage(image,0,0,getWidth(),getHeight(),this);

        }
    };

    //panel creation and background image

    
    JButton btn1=new JButton("CUSTOMER");
    JButton btn2=new JButton("ADMIN");
    Font btnFont=new Font("Arial",Font.BOLD,20);
    
    //button creation
    btn1.setBorder(BorderFactory.createBevelBorder(20));
    btn1.setPreferredSize(new Dimension(250, 100)); // Set preferred size
    btn2.setPreferredSize(new Dimension(250, 100));
    
    // set color to buttons
    //btn operations
    btn1.setBackground(Color.PINK);
    btn1.setForeground(Color.BLACK);
    btn1.setFont(btnFont);
    btn1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            customer();
        }
    });

    btn2.setFont(btnFont);
    btn2.setBackground(Color.PINK);
   
    btn2.setForeground(Color.BLACK);
    //panel

    //panel layout
    panel1.setLayout(new FlowLayout(FlowLayout.CENTER,20,500));
    panel1.add(btn1);
    panel1.add(btn2);
    frame1.setSize(1000,1000);
   
    frame1.setVisible(true);
    frame1.add(panel1);
  
    
    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
    
}
//customer function
public void customer()
{

    frame1.setVisible(false);
    frame2=new JFrame("welcome customer");
    frame2.setSize(1000,1000);
    frame2.setVisible(true);
    //creating JPanel adding bg
    
    JPanel panel2=new JPanel();
    panel2.setBackground(new Color(220,208,255));
    panel2.setLayout(new BorderLayout());
    //creating button panel
   
    JLabel eventname=new JLabel("SELECT EVENT PREFERRED LOCATION");
   eventname.setHorizontalAlignment(SwingConstants.CENTER);
   eventname.setForeground(Color.BLACK);
    //font style for label and buttons
    Font myFont=new Font("SansSerif",Font.BOLD,30);
    
    //set font for label and buttons
    eventname.setFont(myFont);
    //panel for button
JPanel btnpanel=new JPanel(new FlowLayout(FlowLayout.CENTER,20,400)){
    @Override
        protected void paintComponent(Graphics g)
        {
            ImageIcon imageIcon=new ImageIcon("event.jpg");
            Image image=imageIcon.getImage();
            g.drawImage(image,0,0,getWidth(),getHeight(),this);

        }
    
};
    //create buttons
    JButton btn1=new JButton("Taj_hotel");
    JButton btn2=new JButton("The_Park");
    JButton btn3=new JButton("Chola");
//btn styling
    btn1.setPreferredSize(new Dimension(250, 100)); // Set preferred size
    btn2.setPreferredSize(new Dimension(250, 100));
    btn3.setPreferredSize(new Dimension(250,100));
    btn1.setBackground(Color.PINK);
    btn2.setBackground(Color.PINK);
    btn3.setBackground(Color.PINK);
    btn1.setFont(new Font("Arial",Font.ITALIC,30));
    btn2.setFont(new Font("Arial",Font.ITALIC,30));
    btn3.setFont(new Font("Arial",Font.ITALIC,30));

    //adding action listeners to buttons 
    btn1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            taj_hotel();
        }
    });
    btn2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            the_park();
        }
    });
    btn3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            taj_hotel();
        }
    });
  


    frame2.add(panel2);
    btnpanel.add(btn1);
    btnpanel.add(btn2);
    btnpanel.add(btn3);
   panel2.add(eventname,BorderLayout.NORTH);
   panel2.add(btnpanel,BorderLayout.CENTER);
    frame2.setVisible(true);
    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
public void taj_hotel(){
    JPanel panel=new JPanel();
frame2.setVisible(false);
frame3=new JFrame();
frame3.setSize(1000,1000);
frame3.setLayout(null);
panel.setBounds(0, 0, 1000, 1000);
panel.setLayout(null);
//
JLabel title=new JLabel("PLEASE ENTER YOUR DETAILS");
title.setFont(new Font("Arial",Font.BOLD,25));
title.setBounds(250,100,500,50);
JLabel username=new JLabel("USERNAME");
JTextField usertext=new JTextField();
username.setFont(new Font("Arial",Font.BOLD,15));
username.setBounds(300,200,100,100);
usertext.setBounds(500,220,150,50);
panel.setBackground(new Color(220,208,255));
JLabel eventtype=new JLabel("EVENT TYPE");
JTextField eventtext=new JTextField();
eventtype.setFont(new Font("Arial",Font.BOLD,15));
eventtype.setBounds(300,300,100,100);
eventtext.setBounds(500,320,150,50);
JLabel mobilenumber=new JLabel("PHONE NUMBER");
JTextField mobiletext=new JTextField();
mobilenumber.setFont(new Font("Arial",Font.BOLD,15));
mobilenumber.setBounds(300,400,100,100);
mobiletext.setBounds(500,420,150,50);
JLabel eventday=new JLabel("EVENT DAY");
JTextField daytext=new JTextField();
eventday.setFont(new Font("Arial",Font.BOLD,15));
eventday.setBounds(300,500,100,100);
daytext.setBounds(500,520,150,50);
JButton submit=new JButton("SUBMIT");
submit.setBounds(400,600,200,50);

submit.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){

String name=usertext.getText();
String eventName=eventtext.getText();
String mobileNo=mobiletext.getText();
String day=daytext.getText();
//connection to db
Connection myConn=null;
PreparedStatement myStmt=null;


try{
    myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/madhu","root","madhu@mysql123");
    myStmt=myConn.prepareStatement("insert into taj_hotel values(?,?,?,?)");
    myStmt.setString(1,name);
    myStmt.setString(2,eventName);
    myStmt.setString(3,mobileNo);
    myStmt.setString(4, day);
    myStmt.executeUpdate();
    JOptionPane.showMessageDialog(null, "EVENT REGISTERED WE WILL CONTACT YOU SHORTLY");
    frame3.setVisible(false);
    frame2.setVisible(true);
    


}

catch(Exception ex){
ex.printStackTrace();
}


    }
});



//adding in panel
panel.add(title);
panel.add(username);
panel.add(usertext);
panel.add(eventtype);
panel.add(eventtext);
panel.add(mobilenumber);
panel.add(mobiletext);
panel.add(eventday);
panel.add(daytext);
panel.add(submit);
frame3.add(panel);
frame3.setVisible(true);

}

 


public void the_park(){
    JPanel panel=new JPanel();
    frame2.setVisible(false);
    frame3=new JFrame();
    frame3.setSize(1000,1000);
    frame3.setLayout(null);
    panel.setBounds(0, 0, 1000, 1000);
    panel.setLayout(null);
    //
    JLabel title=new JLabel("PLEASE ENTER YOUR DETAILS");
    title.setFont(new Font("Arial",Font.BOLD,25));
    title.setBounds(250,100,500,50);
    JLabel username=new JLabel("USERNAME");
    JTextField usertext=new JTextField();
    username.setFont(new Font("Arial",Font.BOLD,15));
    username.setBounds(300,200,100,100);
    usertext.setBounds(500,220,150,50);
    panel.setBackground(new Color(220,208,255));
    JLabel eventtype=new JLabel("EVENT TYPE");
    JTextField eventtext=new JTextField();
    eventtype.setFont(new Font("Arial",Font.BOLD,15));
    eventtype.setBounds(300,300,100,100);
    eventtext.setBounds(500,320,150,50);
    JLabel mobilenumber=new JLabel("PHONE NUMBER");
    JTextField mobiletext=new JTextField();
    mobilenumber.setFont(new Font("Arial",Font.BOLD,15));
    mobilenumber.setBounds(300,400,100,100);
    mobiletext.setBounds(500,420,150,50);
    JLabel eventday=new JLabel("EVENT DAY");
    JTextField daytext=new JTextField();
    eventday.setFont(new Font("Arial",Font.BOLD,15));
    eventday.setBounds(300,500,100,100);
    daytext.setBounds(500,520,150,50);
    JButton submit=new JButton("SUBMIT");
    submit.setBounds(400,600,200,50);
    
    submit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
    
            String name=usertext.getText();
            String eventName=eventtext.getText();
            String mobileNo=mobiletext.getText();
            String day=daytext.getText();
            //connection to db
            Connection myConn=null;
            PreparedStatement myStmt=null;
            
            
            try{
                myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/madhu","root","madhu@mysql123");
                myStmt=myConn.prepareStatement("insert into park_hotel values(?,?,?,?)");
                myStmt.setString(1,name);
                myStmt.setString(2,eventName);
                myStmt.setString(3,mobileNo);
                myStmt.setString(4, day);
                myStmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "EVENT REGISTERED WE WILL CONTACT YOU SHORTLY");
                frame3.setVisible(false);
                frame2.setVisible(true);
                
            
            
            }
            
            catch(Exception ex){
            ex.printStackTrace();
            }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        }
    });
    
    
    
    //adding in panel
    panel.add(title);
    panel.add(username);
    panel.add(usertext);
    panel.add(eventtype);
    panel.add(eventtext);
    panel.add(mobilenumber);
    panel.add(mobiletext);
    panel.add(eventday);
    panel.add(daytext);
    panel.add(submit);
    frame3.add(panel);
    frame3.setVisible(true);
    
    }

public void chola(){

    JPanel panel=new JPanel();
    frame2.setVisible(false);
    frame3=new JFrame();
    frame3.setSize(1000,1000);
    frame3.setLayout(null);
    panel.setBounds(0, 0, 1000, 1000);
    panel.setLayout(null);
    //
    JLabel title=new JLabel("PLEASE ENTER YOUR DETAILS");
    title.setFont(new Font("Arial",Font.BOLD,25));
    title.setBounds(250,100,500,50);
    JLabel username=new JLabel("USERNAME");
    JTextField usertext=new JTextField();
    username.setFont(new Font("Arial",Font.BOLD,15));
    username.setBounds(300,200,100,100);
    usertext.setBounds(500,220,150,50);
    panel.setBackground(new Color(220,208,255));
    JLabel eventtype=new JLabel("EVENT TYPE");
    JTextField eventtext=new JTextField();
    eventtype.setFont(new Font("Arial",Font.BOLD,15));
    eventtype.setBounds(300,300,100,100);
    eventtext.setBounds(500,320,150,50);
    JLabel mobilenumber=new JLabel("PHONE NUMBER");
    JTextField mobiletext=new JTextField();
    mobilenumber.setFont(new Font("Arial",Font.BOLD,15));
    mobilenumber.setBounds(300,400,100,100);
    mobiletext.setBounds(500,420,150,50);
    JLabel eventday=new JLabel("EVENT DAY");
    JTextField daytext=new JTextField();
    eventday.setFont(new Font("Arial",Font.BOLD,15));
    eventday.setBounds(300,500,100,100);
    daytext.setBounds(500,520,150,50);
    JButton submit=new JButton("SUBMIT");
    submit.setBounds(400,600,200,50);
    
    submit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
    
            String name=usertext.getText();
            String eventName=eventtext.getText();
            String mobileNo=mobiletext.getText();
            String day=daytext.getText();
            //connection to db
            Connection myConn=null;
            PreparedStatement myStmt=null;
            
            
            try{
                myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/madhu","root","madhu@mysql123");
                myStmt=myConn.prepareStatement("insert into chola_hotel values(?,?,?,?)");
                myStmt.setString(1,name);
                myStmt.setString(2,eventName);
                myStmt.setString(3,mobileNo);
                myStmt.setString(4, day);
                myStmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "EVENT REGISTERED WE WILL CONTACT YOU SHORTLY");
                frame3.setVisible(false);
                frame2.setVisible(true);
                
            
            
            }
            
            catch(Exception ex){
            ex.printStackTrace();
            }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        }
    });
    
    
    
    //adding in panel
    panel.add(title);
    panel.add(username);
    panel.add(usertext);
    panel.add(eventtype);
    panel.add(eventtext);
    panel.add(mobilenumber);
    panel.add(mobiletext);
    panel.add(eventday);
    panel.add(daytext);
    panel.add(submit);
    frame3.add(panel);
    frame3.setVisible(true);








}





    
}




public  class CMS
{public static void main(String args[])
{
   OMS obj=new OMS();
   obj.hello();  
}
}

