/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg261semesterproject;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Brian Morehouse
 */
public class MenuPanel extends JPanel{
    
    private JButton assignmentsButton;
    private JButton coursesButton;
    private JButton addAssignmentsButton;
    private JButton addCoursesButton;
    
    
    MenuPanel(){
        super();
       
       //Buttons for Navigation
       assignmentsButton = new JButton("Assignments");
       coursesButton = new JButton("Courses");
       addAssignmentsButton = new JButton("Add Assignments");
       addCoursesButton = new JButton("Add Courses");
       
       add(assignmentsButton);
       add(coursesButton);
       add(addAssignmentsButton);
       add(addCoursesButton);
    }

   
    public JButton getAssignmentsButton() {
        return assignmentsButton;
    }

    public void setAssignmentsButton(JButton assignmentsButton) {
        this.assignmentsButton = assignmentsButton;
    }

    public JButton getCoursesButton() {
        return coursesButton;
    }

    public void setCoursesButton(JButton coursesButton) {
        this.coursesButton = coursesButton;
    }

    public JButton getAddAssignmentsButton() {
        return addAssignmentsButton;
    }

    public void setAddAssignmentsButton(JButton addAssignmentsButton) {
        this.addAssignmentsButton = addAssignmentsButton;
    }

    public JButton getAddCoursesButton() {
        return addCoursesButton;
    }

    public void setAddCoursesButton(JButton addCoursesButton) {
        this.addCoursesButton = addCoursesButton;
    }
    
    
}
