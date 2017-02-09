/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg261semesterproject;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Brian Morehouse
 */
public class AddCourseView extends JPanel implements ActionListener {
    
    JButton saveButton;
    JLabel CourseNameLabel;
    JTextField CourseName;
    JLabel CourseNumberLabel;
    JLabel SemesterLabel;
    JTextField CourseNumber;
    JTextField Semester;
    JLabel CourseTimeLabel;
    JTextField CourseTime;
    JComboBox CourseDays;
    
    GridBagConstraints c = new GridBagConstraints();
    
    AddCourseView()
    {
        GridBagLayout grid = new GridBagLayout();
        setLayout(grid);
        
        c.insets = new Insets(20,20,10,20);
        
        CourseNameLabel = new JLabel("Course Name:");
        c.weightx = 0;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        add(CourseNameLabel, c);

        CourseName = new JTextField("                  ");
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth=2;
        add (CourseName, c);
        
        CourseNumberLabel = new JLabel("Course Number:");
        c.weightx = 0;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 2;
        add(CourseNumberLabel,c);
        
        CourseNumber = new JTextField();
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth=2;
        add(CourseNumber,c);
        
        SemesterLabel = new JLabel("Semester:");
        c.weightx = 0;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 4;
        add(SemesterLabel,c);
        
        Semester = new JTextField("                  ");
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth=2;
        add (Semester,c);
        
        CourseTimeLabel = new JLabel("Time:");
        c.weightx = 0;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 6;
        add(CourseTimeLabel,c);
        
        CourseDays = new JComboBox();
        c.gridwidth=1;
        c.gridx = 1;
        c.gridy = 6;
        c.gridwidth=1;
        add (CourseDays,c);
        
        CourseTime = new JTextField("                  ");
        c.gridx = 2;
        c.gridy = 6;
        c.gridwidth=1;
        add (CourseTime,c);
        
        
        saveButton = new JButton("Add");
        c.weightx = 2;
        c.weighty = 2;
        c.gridx = 1;
        c.gridy = 9;
        saveButton.addActionListener(this);
        add(saveButton,c);
        
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton eventSource = (JButton)e.getSource();
        if (eventSource == saveButton)
        {
          
        }
        
    }
}
