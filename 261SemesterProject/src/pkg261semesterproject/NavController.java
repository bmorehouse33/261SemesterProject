/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg261semesterproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Brian Morehouse
 */
public class NavController {
    private NavView navView;
    private NavModel navModel;
    private MainPanelView mainPanelView;
    private AssignmentView assignView;
    private CourseView courseView;
    private AddAssignmentView addAssignView;
    private AddCourseView addCourseView;
    
    
    NavController(NavView navView, NavModel navModel)
    {
        this.navModel = navModel;
        this.navView = navView;
        
        assignView = new AssignmentView();
        courseView = new CourseView();
        addAssignView = new AddAssignmentView();
        addCourseView = new AddCourseView();
        
        navView.addAddCourseButtonListener(new AddCourseButtonListener());
        navView.addAddAssignmentButtonListener(new AddAssignmentButtonListener());
        navView.addAssignmentButtonListener(new AssignmentButtonListener());
        navView.addCourseButtonListener(new CourseButtonListener());
        

    }
    
    class AddCourseButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {     
            navView.switchToAddCoursePanel(addCourseView);
        }
    }
    class AddAssignmentButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {     
            navView.switchToAddAssignmentPanel(addAssignView);
        }
    }
    
    class AssignmentButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {     
            navView.switchToAssignmentPanel(assignView);
        }
    }
    class CourseButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {     
            navView.switchToCoursePanel(courseView);
        }
    }
    
    
        
}
