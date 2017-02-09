/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg261semesterproject;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Brian Morehouse
 */
public class CourseView extends JPanel{
    private MenuPanel menuPanel;
    private AssignmentView assignView;
    private CourseView courseView;
    private AddAssignmentView addAssignView;
    private AddCourseView addCourseView;
    private JButton testingWork;
    
    CourseView()
    {
       super();
       
       testingWork= new JButton("CourseView test");
       add(testingWork);
       
    }
    
}
