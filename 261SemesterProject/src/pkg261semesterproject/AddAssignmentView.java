package pkg261semesterproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Brian Morehouse
 */
public class AddAssignmentView extends JPanel implements ActionListener {
    
    
    JButton saveButton;
    JLabel AssignmentTitleLabel;
    JTextField AssignmentTitle;
    JLabel CourseNameLabel;
    JComboBox CourseName = new JComboBox();;
    JLabel DateLabel;
    JLabel TimeLabel;
    JTextField Date;
    JTextField Time;
    GridBagConstraints c = new GridBagConstraints();
    
    Font f;
    
    JLabel DueDateHintLabel;
    JLabel TimeHintLabel;
    Assignment assignment;
    
    AddAssignmentView()
    {
        assignment= new Assignment();
        
        GridBagLayout grid = new GridBagLayout();
        setLayout(grid);
        
        c.insets = new Insets(20,20,10,20);
        f = new Font("Times", Font.ITALIC, 14);
        
        AssignmentTitleLabel = new JLabel("Assignment Title:");
        c.weightx = 0;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        add(AssignmentTitleLabel, c);

        AssignmentTitle = new JTextField("                  ");
        c.gridwidth=2;
        c.gridx = 1;
        c.gridy = 0;
        add (AssignmentTitle, c);
        
        CourseNameLabel = new JLabel("Course Name:");
        c.weightx = 0;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 2;
        add(CourseNameLabel,c);
        
         try
        {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/DataTest",null,null);
            
            Statement stmt = con.createStatement();
            String Selectquery = "SELECT * FROM COURSE";
            ResultSet rs=stmt.executeQuery (Selectquery);   
            
            while(rs.next()){
                CourseName.addItem(rs.getString(1));
            }
        }
        catch(SQLException se)
        {
            JOptionPane.showMessageDialog(null, se.toString());
        }

        c.gridx = 1;
        c.gridy = 2; 
        c.gridwidth=2;
        add(CourseName,c);
        
        DateLabel = new JLabel("Due Date:");
        c.weightx = 0;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 4;
        add(DateLabel,c);
        
        Date = new JTextField("                  ");
        c.gridwidth=1;
        c.gridx = 1;
        c.gridy = 4;       
        add (Date,c);
        
        DueDateHintLabel = new JLabel ("eg: YYYY-MM-DD");
        DueDateHintLabel.setForeground(java.awt.Color.gray);
        DueDateHintLabel.setFont(f);
        c.gridwidth=1;
        c.gridx = 2;
        c.gridy = 4;       
        add (DueDateHintLabel,c);
        
        TimeLabel = new JLabel("Time:");
        c.weightx = 0;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 6;
        add(TimeLabel,c);
        
        Time = new JTextField("                  ");
        c.gridwidth=1;
        c.gridx = 1;
        c.gridy = 6;
        add (Time,c);
        
        TimeHintLabel = new JLabel ("eg: hh:mm");
        TimeHintLabel.setForeground(java.awt.Color.gray);
        TimeHintLabel.setFont(f);
        c.gridwidth=1;
        c.gridx = 2;
        c.gridy = 6;       
        add (TimeHintLabel,c);
        
        
        saveButton = new JButton("Add");
        c.weightx = 2;
        c.weighty = 2;
        c.gridx = 1;
        c.gridy = 9;
        c.gridwidth=1;
        
        saveButton.addActionListener(this);
        add(saveButton,c);
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton eventSource = (JButton)e.getSource();
        if (eventSource == saveButton)
        {
            
           try
            {
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/DataTest",null,null);
           
                Statement stmt = con.createStatement();
                String Selectquery = "INSERT INTO ASSIGNMENT values('"+AssignmentTitle.getText()+"','"+ CourseName.getSelectedItem()+"','"+ Date.getText()+"','"+Time.getText()+"')";
                stmt.execute(Selectquery);

                JOptionPane.showMessageDialog(null, "Add Assignment Successfully");

            }
            catch(SQLException se)
            {
            JOptionPane.showMessageDialog(null, se.toString());
            }
        }
        
    }
}