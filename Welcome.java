/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package loginscreen;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;


/**
 *
 * @author Jyotish
 */
class Welcome extends JFrame {

    JButton Login,SignUp;
    JLabel User_Name,Password;
    JTextField User_Name_t;
   JPasswordField Password_t;
    JLabel background,logo,welcome;
    JCheckBox show;
 Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    public Welcome() {
        
        try {
    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
            UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }
} catch (Exception e) {
    // If Nimbus is not available, you can set the GUI to another look and feel.
}
        
        
        setTitle("Welcome");
        
        
        
        final Font font1=new Font("Monotype Corsiva",Font.TRUETYPE_FONT,18);
         final Font logofont=new Font("Monotype Corsiva",Font.TRUETYPE_FONT,45);
        welcome=new JLabel("Welcome");
        background=new JLabel(new ImageIcon("C:\\Users\\Jyotish\\Documents\\NetBeansProjects\\LoginScreen\\src\\loginscreen\\login.jpg"));
        ImageIcon imageIcon1 = new ImageIcon(new ImageIcon("C:\\Users\\Jyotish\\Documents\\NetBeansProjects\\LoginScreen\\src\\loginscreen\\wlogo.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
         logo=new JLabel();
         logo.setBounds(70,0,150,150);
         logo.setIcon(imageIcon1);
         add(logo);
         
         welcome.setBounds(180,70,150,40);
         welcome.setFont(logofont);
         welcome.setForeground(Color.white);
         add(welcome);
        
        
        //labels
            User_Name=new JLabel("User Name");
            Password=new JLabel("Password");
            // textfields
            
            User_Name_t=new JTextField();
            
            //JPasswordfield
            
            Password_t=new JPasswordField();
            
            //Jbuttons
            
            
            Login=new JButton("Login");
              SignUp=new JButton("SignUp");
            
            
            add(background);    //adding background image to frame
            
            
          //checkbox
            show=new JCheckBox("Show Password");
            show.setBounds(350,180,130,30);
            show.setForeground(new Color(0,119,204));
            show.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            
           background. add(show);
            
        User_Name.setBounds(100,120,150,30);    //setting the alighnments
        Password.setBounds(100,170,150,30);      
        
        
        User_Name_t.setBounds(200,120,150,30);
        
        
        
        
        
        
        
         User_Name_t.setFont(font1);        //styling fonts
         User_Name_t.setForeground(Color.black);     
        Password_t.setBounds(200,170,150,30);
         Password_t.setFont(font1);
          Password_t.setForeground(Color.black);
        User_Name.setForeground(Color.white);
        Password.setFont(font1);
        Password.setForeground(Color.white);
        User_Name.setFont(font1);
        Login.setBounds(300,220,100,30); 
        Login.setFont(font1);//alignment of buttons
       SignUp.setBounds(440,20,100,30);
       SignUp.setFont(font1);
        Login.setBackground(new Color(59, 89, 182));
        Login.setForeground(Color.WHITE);
         SignUp.setBackground(new Color(210,71,38));
             SignUp.setForeground(Color.WHITE);
        
       
    /*   
        Login.setFont(font1);
        
        Quit.setBackground(new Color(210,71,38));
             Quit.setForeground(Color.WHITE);
                 Quit.setFont(font1); */
        
         background.add(User_Name_t);
         background.add(Password);
          background.add(Password_t);
        background.add(User_Name);
        background.add(Login);
           background.add(SignUp);
        
        
    background.setLayout(null);
    
    
    //adding actions
    
    
     try
{
Class.forName("oracle.jdbc.OracleDriver");
   System.out.println("cONNECTED");
}catch(ClassNotFoundException ex)
{
   
JOptionPane.showMessageDialog(null,ex.getMessage());
}  
            
    
    
    SignUp.addActionListener(new ActionListener()
    
    {
    public void actionPerformed(ActionEvent e)
    {
    
    String user_name=User_Name_t.getText();
    String password=Password_t.getText().toString().trim();
    
    if(user_name.equals("")||password.equals(""))
    {
       
    JOptionPane.showMessageDialog(null,"Please Enter Name and password");
    
    }
    else
    {
           try
{
    
Class.forName("oracle.jdbc.OracleDriver");
   System.out.println("CONNECTED");
}catch(ClassNotFoundException ex)
{
    System.out.println("WRONG");

}  
            
        
        
      try
{

String uname=User_Name_t.getText();
String pass=Password_t.getText();
Class.forName("oracle.jdbc.OracleDriver"); 


con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123654");

String sql="INSERT INTO WELCOME VALUES('"+ uname +"','"+ pass +"')";   
pst=con.prepareStatement(sql);
 rs=pst.executeQuery();
 JOptionPane.showMessageDialog(null,"Sucessfully SignUp");

}catch(Exception ex)
{
JOptionPane.showMessageDialog(null,ex.getMessage());
}
 finally
 {
 if(con!=null)
 {
     try {
         con.close();
     } catch (SQLException ex) {
        
     }
 
 }
 if(rs!=null)
 {
     try {
         rs.close();
     } catch (SQLException ex) {
         
     }
 
 }
 if(pst!=null)
 {
     try {
         pst.close();
     } catch (SQLException ex) {
        
     }
 
 }
 }      
        
        
        
        
        
 
    
    }
    
    
    
    }
    
    
    
    
    }
    
    );
    
    Login.addActionListener(new ActionListener()
            
    {
        public   boolean exist=false;
    
    public void actionPerformed(ActionEvent e)
    {
    try
    {
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","123654");
     String name=User_Name_t.getText();  
       String pass=Password_t.getText();  
    String sql="SELECT NAME ,PASSWORD FROM WELCOME";
pst=con.prepareStatement(sql);
 rs=pst.executeQuery();
while(rs.next())
{
if(name.equals(rs.getString("NAME"))&&pass.equals(rs.getString("PASSWORD")))
{

 JOptionPane.showMessageDialog(null,"Success");
exist=true;

}
 

}

if(exist!=true)
{
JOptionPane.showMessageDialog(null,"Check your name and password");


}

}catch(Exception ex)
{
JOptionPane.showMessageDialog(null, ex.getMessage());

}
 finally
 {
 if(con!=null)
 {
     try {
         con.close();
     } catch (SQLException ex) {
        Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
     }
 
 }
 if(rs!=null)
 {
     try {
         rs.close();
     } catch (SQLException ex) {
         Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);         
     }
 
 }
 if(pst!=null)
 {
     try {
         pst.close();
     } catch (SQLException ex) {
         Logger.getLogger(Welcome.class.getName()).log(Level.SEVERE, null, ex);
        
     }
 
 }
 }      
    
    
    
    }
    
    
    
    }
            
            
            
            
            
            );
    
    
    
    
    
    
    
    
    SignUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    
    Login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    
    show.addActionListener(new ActionListener()
    {
    
    public void actionPerformed(ActionEvent e)
    {
        
if(show.isSelected())
{
Password_t.setEchoChar((char) 0);


}
else
{
Password_t.setEchoChar('*');
}
    }
    
    
    }
            
            
            );
    
 
    setVisible(true);
    setSize(600,400);
   setResizable(false);
    setLocation(400,200);
    
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        
        
        
        
        
    }
    
}
