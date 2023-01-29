import jakarta.faces.bean.ManagedBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author YOU
 */
@ManagedBean
public class Remove {
 String fname; 
 String std;   
    
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
    }
    
 public void delete(){
      try {
              Dconnection obj = new Dconnection();
              Connection conn = obj.conMethod();
            PreparedStatement stmt=conn.prepareStatement("delete from info1 where STUDID=?");
            stmt.setString(1, std);
            stmt.executeUpdate();  
        } catch(ClassNotFoundException | SQLException sqlException){
        }
 }  
}
