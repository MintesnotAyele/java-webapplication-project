
import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
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
@RequestScoped
public class Update {
    String fname;
  String lname;
  String gender;
 int id;
    int block;
    int room;
String dep;
String std;

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }
    Dconnection con=new Dconnection();
    public void update1() throws ClassNotFoundException{
         try{
            Connection conn=con.conMethod();
            String sql2="select GENDER1 from BLOCK where BLOCKNUMBER=?";
            PreparedStatement psmt1=conn.prepareStatement(sql2);
              psmt1.setInt(1, block);
        ResultSet res1=psmt1.executeQuery();
           res1.next();
            String gen=res1.getString("GENDER1");
            if(gender == null ? gen == null : gender.equals(gen)){
              add1();  
            }
            else{
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "sorry this is not "+gender+" block",
                            ""));
            }}
         catch(SQLException ex)
        {
         FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect block and Passowrd",
                            ""));
        }
        
    }
      public void add1() throws ClassNotFoundException, SQLException{
      try{  Connection conn1=con.conMethod();
            String sql1="select count(*) from info1 where ROOM=? and BLOCK=?";
            PreparedStatement psmt=conn1.prepareStatement(sql1);
              psmt.setInt(1, room);
              psmt.setInt(2, block);
        ResultSet res=psmt.executeQuery();
        res.next();
        int room1=res.getInt(1);
      if(room1<=6){
            String sql="update info1 set NAME=?,LASTNAME=?,DEPARTMENT=?,BLOCK=?,ROOM=?,GENDER=?,id=? where STUDID=?";
           PreparedStatement ps=conn1.prepareStatement(sql);
           ps.setInt(7, id);
            ps.setString(1, fname);
             ps.setString(2, lname);
               ps.setString(3, dep);
                 ps.setInt(4, block);
                   ps.setInt(5, room);
                     ps.setString(6, gender);
                     ps.setString(8, std);
           ps.executeUpdate();
      }
       else
        {
         FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "sorry the room is full",
                            ""));
        }}
       catch(SQLException ex)
        {
         FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "sorry",
                            ""));
        }
    }
}
