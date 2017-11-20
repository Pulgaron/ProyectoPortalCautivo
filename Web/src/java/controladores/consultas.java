package controladores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class consultas extends conexion{
    //user va a ser la matricula y pass, pues la contraseña
    public boolean autenticacion(String matricula,String passw){
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            //La consulta se hizo de esta manera para evitar SQL injection
            String consulta = "SELECT * FROM Persona WHERE matricula = ?"; //Teoricamente iniciar sesion
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, matricula);
            rs = pst.executeQuery();
            //String privilegio = "";
            if(rs.absolute(1)){
                return true;
            }
        }catch (Exception e){
            System.err.println("Error:" + e);
        }
        finally{
            try{
                if(getConexion() != null)
                    getConexion().close();
                if(pst != null)
                    pst.close();
                if(rs != null)
                    rs.close();
            } catch(Exception e){
                System.err.println("Error:" + e);
            }
        }
        return false;
    }
    //Hay que configurar esto para que registre segun la bd
    public boolean registrar(String matricula, String passw, String nombres, String apellidos, int id_jerarquia, int id_area, String correo){
        
        PreparedStatement pst = null;
        try{
            String consulta = "insert into usuarios(matricula,passw,nombres,apellidos,id_jerarquia,id_area,correo) values(?,?,?,?,?,?,?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, matricula);
            pst.setString(2, passw);
            pst.setString(3, nombres);
            pst.setString(4, apellidos);
            pst.setInt(5, id_jerarquia);
            pst.setInt(6, id_area);
            pst.setString(7, correo);
            
            if(pst.executeUpdate()==1){
                return true;
            }
        } catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        finally{
            try{
                if(getConexion() != null)
                    getConexion().close();
                if(pst != null)
                    pst.close();
            }
            catch(Exception e){
                System.err.println("Error:" + e);
            }

        }
        
        return false;
    }
    //Esta fue la prueba para comprobar que funcionase
   /*public static void main(String[] args){
        consultas co = new consultas();
        co.registrar("s14001383","acredit01","Jesus Eduardo","Lara Ortiz",1,1,"jesusxd96@gmail.com");
    }*/
    //Configurar esto para que consulte los datos
    public boolean consultar(String matricula, String passw, String nombres, String apellidos, int id_jerarquia, int id_area, String correo){
        
        PreparedStatement pst = null;
        try{
            String consulta = "SELECT nombres,apellidos,id_jerarquia,id_area,correo FROM usuarios WHERE matricula = ?";
           // String consulta = "insert into usuarios(matricula,passw,nombres,apellidos,id_jerarquia,id_area,correo) values(?,?,?,?,?,?,?)";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, matricula);
            pst.setString(2, passw);
            pst.setString(3, nombres);
            pst.setString(4, apellidos);
            pst.setInt(5, id_jerarquia);
            pst.setInt(6, id_area);
            pst.setString(7, correo);
            if(pst.executeUpdate()==1){
                return true;
            }
        } catch(Exception ex){
            System.err.println("Error:" + ex);
        }
        finally{
            try{
                if(getConexion() != null)
                    getConexion().close();
                if(pst != null)
                    pst.close();
            }
            catch(Exception e){
                System.err.println("Error:" + e);
            }

        }
        
        return false;
    }
}