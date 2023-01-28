
import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.context.FacesContext;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/*import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
*/

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author YOU
 */
@ManagedBean
@SessionScoped
public class Login {
 private String usern;
private String pass;

    public String getUsern() {
        return usern;
    }

    public void setUsern(String usern) {
        this.usern = usern;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
      public String method1() throws SQLException, ClassNotFoundException {
        boolean num = Kanu(usern, pass);
        if (num) {
              Dconnection dbcon = new Dconnection();
              Connection con = dbcon.conMethod();
            PreparedStatement ps = con.prepareStatement("select FNAME from INFORMATION where FNAME=?");
            ps.setString(1, usern);       
            ResultSet rs = ps.executeQuery();
            rs.next();
            String userType =rs.getString(1);
            if ("kanu".equals(userType)) {
                return "Admin";
            } else {
                return "user";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            ""));
            return "admin";
        }
    }


 public static boolean Kanu(String name, String password) {
        boolean status = false;
        try {
            Dconnection obj = new Dconnection();
            Connection conn = obj.conMethod();
            PreparedStatement ps = conn.prepareStatement("select * from INFORMATION where FNAME=? and PASSWORD=?");
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
         
        }
        return status;
    }
}


