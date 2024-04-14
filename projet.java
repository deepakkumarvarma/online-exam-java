import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
class OnlineTest extends JFrame implements ActionListener  
{  
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    OnlineTest(String s)  
    {  
        super(s);  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Next");  
        b2=new JButton("Bookmark");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        add(b1);add(b2);  
        set();  
        l.setBounds(30,40,450,20);  
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);  
    }  
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Bookmark"))  
        {  
            JButton bk=new JButton("Bookmark"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
                b2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Bookmark"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            //System.out.println("correct ans="+count);  
            JOptionPane.showMessageDialog(this,"correct ans="+count);  
            System.exit(0);  
        }  
    }  
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Q.1 The largest gulf in the world is");  
            jb[0].setText("Gulf of Mexico");jb[1].setText("Persian Gulf ");jb[2].setText("Gulf of Carpentaria");jb[3].setText(" Gulf of Mannar");   
        }  
        if(current==1)  
        {  
            l.setText("Q.2 The hunting and gathering economy can support only");  
            jb[0].setText("1 person per sq. km");jb[1].setText("3 persons per sq. km");jb[2].setText(" 5 persons per sq. km");jb[3].setText(" 7 persons per sq. km ");  
        }  
        if(current==2)  
        {  
            l.setText("The import of crude oil and petroleum done from national oil companies of producer countries, which have a net exportable surplus of oil is by");  
            jb[0].setText(" term contracts");jb[1].setText("term tenders");jb[2].setText("monthly tenders");jb[3].setText(" All the above");  
        }  
        if(current==3)  
        {  
            l.setText("Que4: Capital of Uttar Pradesh ?");  
            jb[0].setText(" Lucknow");jb[1].setText("Delhi");jb[2].setText("Varanasi");jb[3].setText(" Mumbai");  
        }  
        if(current==4)  
        {  
            l.setText("Que5: who was 1st prime Minister of India?");  
            jb[0].setText("Rajendra Pradesh");jb[1].setText("Pt.Nehru");jb[2].setText("Sardar Patel");jb[3].setText("M.K Gandhi");  
        }  
        if(current==5)  
        {  
            l.setText("Que6: Capital of India ?");  
            jb[0].setText("Delhi");jb[1].setText("Lucknow");jb[2].setText("varanasi");jb[3].setText("Mumbai");  
        }  
        if(current==6)  
        {  
            l.setText("Que7: Which one different");  
            jb[0].setText("car");jb[1].setText("bus");jb[2].setText(" Truck");  
                        jb[3].setText("Book");  
        }  
        if(current==7)  
        {  
            l.setText("Que8: which one different?");  
            jb[0].setText("Biscute");jb[1].setText("pen");jb[2].setText("cake");  
                        jb[3].setText("Chocklet");         
        }  
        if(current==8)  
        {  
            l.setText("Que9:when Gandhi ji  was born ?");  
            jb[0].setText("2");jb[1].setText("4");jb[2].setText("5");jb[3].setText("6");  
        }  
        if(current==9)  
        {  
            l.setText("Que10: Current Pm of India?");  
            jb[0].setText("Rahul gandhi ");jb[1].setText("Modi ");jb[2].setText("Amit Sah");  
                        jb[3].setText("Yogi Adityanath");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[0].isSelected());  
        if(current==1)  
            return(jb[0].isSelected());  
        if(current==2)  
            return(jb[0].isSelected());  
        if(current==3)  
            return(jb[0].isSelected());  
        if(current==4)  
            return(jb[1].isSelected());  
        if(current==5)  
            return(jb[0].isSelected());  
        if(current==6)  
            return(jb[3].isSelected());  
        if(current==7)  
            return(jb[1].isSelected());  
        if(current==8)  
            return(jb[0].isSelected());  
        if(current==9)  
            return(jb[1].isSelected());  
        return false;  
    }  
    public static void main(String s[])  
    {  
        new OnlineTest("Online Test Of Java");  
    }  
}  
