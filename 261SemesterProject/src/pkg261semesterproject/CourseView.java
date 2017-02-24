/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg261semesterproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;



/**
 *
 * @author Brian Morehouse
 */
public class CourseView extends JPanel implements ActionListener {
   
    private JComboBox CourseName;
    private JLabel CourseLabel;
    private JButton ConfirmButton;

    GridBagConstraints c = new GridBagConstraints();
    Vector rowData,columnNames;  
    JTable table;  
    JScrollPane scrollPane; 
    PreparedStatement ps=null;  
    Connection con=null;  
    ResultSet rs=null;

    CourseView()
    {
        GridBagLayout grid = new GridBagLayout();
        setLayout(grid);
        c.insets = new Insets(20,20,10,20);
        
        CourseLabel = new JLabel("Choose a Course:");
        c.weightx = 0;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth=1;        
        add(CourseLabel, c);
        
        CourseName = new JComboBox();
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth=1;
        add (CourseName, c);
        
        
        ConfirmButton = new JButton("OK");
        c.gridx = 2;
        c.gridy = 0;
        c.gridwidth=1;
        ConfirmButton.addActionListener(this);
        add (ConfirmButton, c);
                
        columnNames=new Vector();  
        columnNames.add("Assignment Title");  
        columnNames.add("Course Number");  
        columnNames.add("Due Date");  
        columnNames.add("Time"); 
        rowData = new Vector();
        table = new JTable(rowData,columnNames);  
        scrollPane = new JScrollPane(table); 
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth=3;
        add(scrollPane,c);
        
        Update_ComboBox();
    }
    
    public DefaultComboBoxModel Update_ComboBox(){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        String Selectquery = "SELECT * FROM COURSE";
        try
        {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/DataTest",null,null);
            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery (Selectquery);   
            
            while(rs.next()){
                String courseName = rs.getString(1);
                model.addElement(courseName);
            }
            return model;
        }
        catch(SQLException se)
        {
            JOptionPane.showMessageDialog(null, se.toString());
        }
        return null;
    }
    
    public void ComboBox(){
        DefaultComboBoxModel dm = Update_ComboBox();
        CourseName.setModel(dm);
    }
    
    @Override 
    public void actionPerformed(ActionEvent e) {
        JButton eventSource = (JButton)e.getSource();
        if (eventSource == ConfirmButton){
           try {  
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/DataTest",null,null); 
                ps=con.prepareStatement("select * from Assignment order by AssignmentDueDate, AssignmentTime");  
                rs= ps.executeQuery(); 
                table.setModel(DbUtils.resultSetToTableModel(rs));
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
            String query = CourseName.getSelectedItem().toString();
            filter(query);
        }
        }
    
    public void filter(String query){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
          try
          {
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/DataTest",null,null);
            
            TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
            table.setRowSorter(tr);            
            tr.setRowFilter(RowFilter.regexFilter(query));

            
          }
        catch(SQLException se)
        {
            JOptionPane.showMessageDialog(null, se.toString());
        }
    }


}
