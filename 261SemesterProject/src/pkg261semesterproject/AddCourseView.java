/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg261semesterproject;

import java.awt.Font;
import java.sql.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javafx.scene.paint.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Brian Morehouse
 */
public class AddCourseView extends JPanel implements ActionListener {
    
    JButton saveButton;
    JButton clearButton;
    JLabel CourseNameLabel;
    JTextField CourseName;
    JLabel CourseNumberLabel;
    JLabel SemesterLabel;
    JTextField CourseNumber;
    JTextField Semester;
    JLabel CourseTimeLabel;
    JTextField CourseTime;
    JLabel CourseDaysLabel;
    JTextField CourseDays;
    Font f;
    
    JLabel CourseNameHintLabel;
    JLabel CourseNumberHintLabel;
    JLabel SemesterHintLabel;
    JLabel CourseDaysHintLabel;
    JLabel CourseTimeHintLabel;
    
    GridBagConstraints c = new GridBagConstraints();
    
    AddCourseView()
    {
        GridBagLayout grid = new GridBagLayout();
        setLayout(grid);
        
        c.insets = new Insets(20,20,10,20);
        f = new Font("Times", Font.ITALIC, 14);
        
        CourseNameLabel = new JLabel("Course Name:");
        c.weightx = 0;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        add(CourseNameLabel, c);

        CourseName = new JTextField("");
        c.gridx = 1;
        c.gridy = 0;
        add (CourseName, c);
        
        CourseNameHintLabel = new JLabel("eg: IST 261");
        c.gridx = 2;
        c.gridy = 0;
        CourseNameHintLabel.setForeground(java.awt.Color.gray);
        CourseNameHintLabel.setFont(f);
        add(CourseNameHintLabel,c);
        
        CourseNumberLabel = new JLabel("Course Number:");
        c.weightx = 0;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 2;
        add(CourseNumberLabel,c);
        
        CourseNumber = new JTextField("");
        c.gridx = 1;
        c.gridy = 2;
        add(CourseNumber,c);
        
        CourseNumberHintLabel = new JLabel("eg: 62514");
        c.gridx = 2;
        c.gridy = 2;
        CourseNumberHintLabel.setForeground(java.awt.Color.gray);
        CourseNumberHintLabel.setFont(f);
        add(CourseNumberHintLabel,c);
        
        SemesterLabel = new JLabel("Semester:");
        c.weightx = 0;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 4;
        add(SemesterLabel,c);
        
        Semester = new JTextField("");
        c.gridx = 1;
        c.gridy = 4;
        add (Semester,c);
        
        SemesterHintLabel = new JLabel("eg: Spring 2017");
        c.gridx = 2;
        c.gridy = 4;
        SemesterHintLabel.setForeground(java.awt.Color.gray);
        SemesterHintLabel.setFont(f);
        add(SemesterHintLabel,c);
        
        CourseDaysLabel = new JLabel("Days of Week:");
        c.weightx = 0;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 6;
        add(CourseDaysLabel,c);
        
        CourseDays = new JTextField("");
        c.gridx = 1;
        c.gridy = 6;
        add (CourseDays,c);
        
        CourseDaysHintLabel = new JLabel("eg: Mon/Wed/Fri  OR  Tues/Thurs");
        c.gridx = 2;
        c.gridy = 6;
        CourseDaysHintLabel.setForeground(java.awt.Color.gray);
        CourseDaysHintLabel.setFont(f);
        add(CourseDaysHintLabel,c);
        
        CourseTimeLabel = new JLabel("Start time:");
        c.weightx = 0;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 8;
        add(CourseTimeLabel,c);
        
        CourseTime = new JTextField("");
        c.gridx = 1;
        c.gridy = 8;
        add (CourseTime,c);
        
        CourseTimeHintLabel = new JLabel("eg: hh:mm-hh:mm");
        c.gridx = 2;
        c.gridy = 8;
        CourseTimeHintLabel.setForeground(java.awt.Color.gray);
        CourseTimeHintLabel.setFont(f);
        add(CourseTimeHintLabel,c);
        
        saveButton = new JButton("Add");
        c.weightx = 2;
        c.weighty = 2;
        c.gridx = 1;
        c.gridy = 10;
        saveButton.addActionListener(this);
        add(saveButton,c);
        
        clearButton = new JButton("Clear");
        c.gridx = 2;
        c.gridy = 10;
        clearButton.addActionListener(this);
        add(clearButton,c);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton eventSource = (JButton)e.getSource();
        if (eventSource == saveButton){
          
            try
            {
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/DataTest",null,null);
           
                Statement stmt = con.createStatement();
                String Selectquery = "INSERT INTO COURSE values('"+CourseName.getText()+"','"+ CourseNumber.getText()+"','"+ Semester.getText()+"','"+ CourseDays.getText()+"','"+CourseTime.getText()+"')";
                stmt.execute(Selectquery);
                
                JOptionPane.showMessageDialog(null, "Add Course Folder Successfully");

        }
        catch(SQLException se)
        {
            JOptionPane.showMessageDialog(null, se.toString());
        }
            
        }
        else if (eventSource == clearButton){
             CourseName.setText("");
             CourseNumber.setText("");
             Semester.setText("");
             CourseTime.setText("");
             CourseDays.setText("");
        }
 
    }
   
}
