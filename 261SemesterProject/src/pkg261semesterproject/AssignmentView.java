package pkg261semesterproject;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import pkg261semesterproject.AddAssignmentView;
import pkg261semesterproject.AddCourseView;
import pkg261semesterproject.Assignment;
import pkg261semesterproject.CourseView;
import pkg261semesterproject.MenuPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Brian Morehouse
 */
public class AssignmentView extends JPanel implements ActionListener{
    private MenuPanel menuPanel;
    private AssignmentView assignView;
    private Assignment assign;
    private CourseView courseView;
    private AddAssignmentView addAssignView;
    private AddCourseView addCourseView;
    private JButton DeleteButton;
   
    GridBagConstraints c = new GridBagConstraints();
    
    Vector rowData,columnNames;  
    JTable jt=null;  
    JScrollPane jsp=null;  
    PreparedStatement ps=null;  
    Connection con=null;  
    ResultSet rs=null;
    
    AssignmentView()
    {
        GridBagLayout grid = new GridBagLayout();
        setLayout(grid);
        
        DeleteButton = new JButton("Delete Assignments");
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.weighty = 0.5;
        DeleteButton.addActionListener(this);
        add(DeleteButton,c);
        
        
       jt = new JTable(rowData,columnNames);  
       jsp = new JScrollPane(jt);  
       c.gridx = 0;
       c.gridy = 1;
       add(jsp,c);  
       
       Update_table();
    }
    
    public void Update_table(){
        try {  
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/DataTest",null,null); 

                ps=con.prepareStatement("select * from Assignment order by AssignmentDueDate, AssignmentTime");  
                rs= ps.executeQuery(); 
                jt.setModel(DbUtils.resultSetToTableModel(rs));
                
                }
               catch (SQLException se) {  
               JOptionPane.showMessageDialog(null, se.toString());
            }
            } 

    public void Table(){
        columnNames=new Vector();  
        columnNames.add("Assignment Title");  
        columnNames.add("Course Number");  
        columnNames.add("Due Date");  
        columnNames.add("Time");  
        rowData = new Vector();
       
                try {  
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/DataTest",null,null); 

                ps=con.prepareStatement("select * from Assignment order by AssignmentDueDate, AssignmentTime");  
                rs= ps.executeQuery(); 

                while(rs.next()){  
                    
                    Vector hang=new Vector();  
                    hang.add(rs.getString(1));  
                    hang.add(rs.getString(2));  
                    hang.add(rs.getString(3));  
                    hang.add(rs.getString(4)); 
  
                    rowData.add(hang);  
                }
               
            } 
        catch (SQLException se) {  
               JOptionPane.showMessageDialog(null, se.toString());
            }
            Update_table();
        }
  
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton eventSource = (JButton)e.getSource();
        if (eventSource == DeleteButton)
        {
            DefaultTableModel model = (DefaultTableModel) jt.getModel();
            int SelectedRowIndex = jt.getSelectedRow();
            String title = (String)jt.getValueAt(SelectedRowIndex, 0);
            String coursename = (String)jt.getValueAt(SelectedRowIndex, 1);
            
            try
            {
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/DataTest",null,null);
                model.removeRow(SelectedRowIndex);
                
                Statement stmt = con.createStatement();
                String Selectquery = "Delete From Assignment WHERE AssignmentTitle= '"+title+"'AND coursename='"+coursename+"'" ;
                stmt.executeUpdate(Selectquery);
                
                JOptionPane.showMessageDialog(null, "Delete Assignment Successfully");

            }
            catch(SQLException se)
            {
            JOptionPane.showMessageDialog(null, se.toString());
            }
        }

    }
}
