import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.context.FacesContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class Asign {
  String fname;
  String lname;
  String gender;
   String id;
    String block;
     String room;
String dep;

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
     
    public void add() throws ClassNotFoundException{
       Dconnection con=new Dconnection();
        try{
            Connection conn=con.conMethod();
            String sql1="select count(*) from info where ROOM=?";
            PreparedStatement psmt=conn.prepareStatement(sql1);
              psmt.setString(1, room);
        ResultSet res=psmt.executeQuery();
        res.next();
        int room1=res.getInt(1);
      if(room1<2){
            String sql="insert into info(ID,NAME,LASTNAME,DEPARTMENT,BLOCK,ROOM,GENDER) values(?,?,?,?,?,?,?)";
           PreparedStatement ps=conn.prepareStatement(sql);
           ps.setString(1, id);
            ps.setString(2, fname);
             ps.setString(3, lname);
               ps.setString(4, dep);
                 ps.setString(5, block);
                   ps.setString(6, room);
                     ps.setString(7, gender);
           ps.executeUpdate();
      }
       else
        {
         FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "sorry the room is full",
                            ""));
        }
        }
        catch(SQLException ex)
        {
         FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect block and Passowrd",
                            ""));
        }
    } 
}
