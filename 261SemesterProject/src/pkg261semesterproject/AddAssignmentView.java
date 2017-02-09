package pkg261semesterproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    JComboBox CourseName;
    JLabel DateLabel;
    JLabel TimeLabel;
    JTextField Date;
    JTextField Time;
    GridBagConstraints c = new GridBagConstraints();
    
    AddAssignmentView()
    {
        
        GridBagLayout grid = new GridBagLayout();
        setLayout(grid);
        
        c.insets = new Insets(20,20,10,20);
        
        AssignmentTitleLabel = new JLabel("Assignment Title:");
        c.weightx = 0;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        add(AssignmentTitleLabel, c);

        AssignmentTitle = new JTextField("                  ");
        c.gridx = 1;
        c.gridy = 0;
        add (AssignmentTitle, c);
        
        CourseNameLabel = new JLabel("Course Name:");
        c.weightx = 0;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 2;
        add(CourseNameLabel,c);
        
        CourseName = new JComboBox();
        c.gridx = 1;
        c.gridy = 2;      
        add(CourseName,c);
        
        DateLabel = new JLabel("Due Date:");
        c.weightx = 0;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 4;
        add(DateLabel,c);
        
        Date = new JTextField("                  ");
        c.gridx = 1;
        c.gridy = 4;       
        add (Date,c);
        
        TimeLabel = new JLabel("Time:");
        c.weightx = 0;
        c.weighty = 0.5;
        c.gridx = 0;
        c.gridy = 6;
        add(TimeLabel,c);
        
        Time = new JTextField("                  ");
        c.gridx = 1;
        c.gridy = 6;
        add (Time,c);
        
        
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