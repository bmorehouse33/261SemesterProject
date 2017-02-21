/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg261semesterproject;

/**
 *
 * @author Brian Morehouse
 */
public class Assignment {
    String AssignmentTitle;
    String CourseName;
    String DueDate;
    String Time;

    public Assignment(){
        this.AssignmentTitle = AssignmentTitle;
        this.CourseName=CourseName;
        this.DueDate = CourseName;
        this.Time = Time;
      
    }

    
    public String getAssignmentTitle(){
        return AssignmentTitle;        
    }
    public String getCourseName(){
        return CourseName;        
    }
    public String getDueDate(){
        return DueDate;      
    }
    public String getTime(){
        return Time;      
    }
    public void setAssignmentTitle(String assignmentTitle){
        this.AssignmentTitle = AssignmentTitle;   
    }
    public void setCourseName(String courseName){
        this.CourseName=CourseName; 
    }
    public void setDueDate(String dueDate){
         this.DueDate = DueDate;  
    }
    public void setTime(String time){
        this.Time = Time;
    }

    
}
