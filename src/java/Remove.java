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
 String id;   
 String block;   
 String room;   

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
 public void delete(){
      try {
              Dconnection obj = new Dconnection();
              Connection conn = obj.conMethod();
            PreparedStatement stmt=conn.prepareStatement("delete from info where id=?");
            stmt.setString(1, id);
            stmt.executeUpdate();  
        } catch(ClassNotFoundException | SQLException sqlException){
        }
 }  
}
