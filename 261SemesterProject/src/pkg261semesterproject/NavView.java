/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg261semesterproject;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Brian Morehouse
 */
public class NavView extends JFrame{
    
    private NavModel navModel;
    private MainPanelView mainPanelView;
    
    NavView(NavModel navModel) //Setting standards for Frame
    {
        super("Assignment Planner");
        this.navModel = navModel;
        
        setSize(500,600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        mainPanelView = new MainPanelView();
        add(mainPanelView);  
    }
    
    public void switchToAssignmentPanel(AssignmentView assignmentView)
    {
        //add remove authentication when ready
        
        mainPanelView.removeCoursePanel();
        mainPanelView.removeAddAssignmentPanel();
        mainPanelView.removeAddCoursePanel();
        mainPanelView.addAssignmentPanel(assignmentView);
    }
    
    public void switchToCoursePanel(CourseView courseView)
    {
        //add remove authentication when ready
        
        mainPanelView.removeAssignmentPanel();
        mainPanelView.removeAddAssignmentPanel();
        mainPanelView.removeAddCoursePanel();
        mainPanelView.addCoursePanel(courseView);
    }
    
    public void switchToAddAssignmentPanel(AddAssignmentView addAssignmentView)
    {
        //add remove authentication when ready
        
        mainPanelView.removeCoursePanel();
        mainPanelView.removeAssignmentPanel();
        mainPanelView.removeAddCoursePanel();
        mainPanelView.addAddAssignmentPanel(addAssignmentView);
    }
    
    public void switchToAddCoursePanel(AddCourseView addCourseView)
    {
        //add remove authentication when ready
        
        mainPanelView.removeCoursePanel();
        mainPanelView.removeAddAssignmentPanel();
        mainPanelView.removeAssignmentPanel();
        mainPanelView.addAddCoursePanel(addCourseView);
    }
    
    public void addAssignmentButtonListener(ActionListener al)
    {
        mainPanelView.getMenuPanel().getAssignmentsButton().addActionListener(al);
    }
    public void addCourseButtonListener(ActionListener al)
    {
        mainPanelView.getMenuPanel().getCoursesButton().addActionListener(al);
    }
    
    public void addAddAssignmentButtonListener(ActionListener al)
    {
        mainPanelView.getMenuPanel().getAddAssignmentsButton().addActionListener(al);
    }


    public void addAddCourseButtonListener(ActionListener al)
    {
        mainPanelView.getMenuPanel().getAddCoursesButton().addActionListener(al);
    }
    
}
