/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg261semesterproject;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author Brian Morehouse
 */
public class MainPanelView extends JPanel {
    
    private MenuPanel menuPanel;
    private AddAssignmentView addAssignView;
    private AddCourseView addCourseView;
    private AssignmentView assignView;
    private CourseView courseView;
    private Login login;
    
    MainPanelView()
    {
        super();
       setLayout(new BorderLayout());
       
       menuPanel = new MenuPanel();
       
       
       add(menuPanel, BorderLayout.NORTH);
      
    }
    
    public void addLogin(Login login)
    {
        this.login= login;
        add(login);
        revalidate();
        repaint();
    }
    
    public void removeLogin()
    {
        if(this.login != null)
        {
            remove(this.login);
        }
    }
    
    public void addAssignmentPanel(AssignmentView assignView)
    {
        this.assignView= assignView;
        add(assignView, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    
    public void removeAssignmentPanel()
    {
        if(this.assignView != null)
        {
            remove(this.assignView);
        }
    }
    public void addCoursePanel(CourseView courseView)
    {
        this.courseView= courseView;
        add(courseView, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    
    public void removeCoursePanel()
    {
        if(this.courseView != null)
        {
            remove(this.courseView);
        }
    }
    public void addAddAssignmentPanel(AddAssignmentView addAssignView)
    {
        this.addAssignView= addAssignView;
        add(addAssignView, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    
    public void removeAddAssignmentPanel()
    {
        if(this.addAssignView != null)
        {
            remove(this.addAssignView);
        }
    }
    public void addAddCoursePanel(AddCourseView addCourseView)
    {
        this.addCourseView= addCourseView;
        add(addCourseView, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    
    public void removeAddCoursePanel()
    {
        if(this.addCourseView != null)
        {
            remove(this.addCourseView);
        }
    }
    
    //add another for authentication screen when there
    public MenuPanel getMenuPanel() 
    {
        return menuPanel;
    }



}



