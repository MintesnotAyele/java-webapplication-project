import jakarta.faces.bean.ManagedBean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.sql.PreparedStatement;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author YOU
 */
@ManagedBean(name="viewstudent")
public class Rertive {
    String id1;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    
    
    
    
    
    public List <use> arrayList;
    public List <use> getstudentlist(){
    arrayList = new ArrayList<>();
    
    try{
    Dconnection gettin=new Dconnection();
        Connection con=gettin.conMethod();
       PreparedStatement ps=con.prepareStatement("select * from info1 where id=?");
        ps.setString(1, id1);
        ResultSet results=ps.executeQuery();
        while(results.next()){
        String username=results.getString("ID");
        String passw=results.getString("NAME");
        String email=results.getString("LASTNAME");
        String creditCardno=results.getString("DEPARTMENT");
        String address=results.getString("BLOCK");
        String gender=results.getString("ROOM");
        String phoneno=results.getString("GENDER");
      
        arrayList.add(new use(username,passw,email,creditCardno,address,gender,phoneno));
        }
        
    }
    catch(Exception e){}
        return arrayList;
    }
    
    
    
     public List <use> arrayList1;
     public List <use> getadSerch(){
    arrayList1 = new ArrayList<>();
    
    try{
    Dconnection gettin=new Dconnection();
        Connection con=gettin.conMethod();
       PreparedStatement ps=con.prepareStatement("select * from info1 ");
     
        ResultSet results=ps.executeQuery();
        while(results.next()){
        String username=results.getString("ID");
        String passw=results.getString("NAME");
        String email=results.getString("LASTNAME");
        String creditCardno=results.getString("DEPARTMENT");
        String address=results.getString("BLOCK");
        String gender=results.getString("ROOM");
        String phoneno=results.getString("GENDER");
      
        arrayList1.add(new use(username,passw,email,creditCardno,address,gender,phoneno));
        }
        
    }
    catch(Exception e){}
        return arrayList1;
    }
}
