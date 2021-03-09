package Backend.PatronMVC.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import Backend.PatronMVC.model.conexion.Conexion;
import Backend.PatronMVC.model.dto.Cientifico;



/**
 * Clase que permite el acceso a la base de datos
 * CRUD
 *
 */
public class CientificoDao
{

	public void registrarCientifico(Cientifico cientifico)
	{
		Conexion conex= new Conexion();
		
		try {
			Statement st = conex.getConnection().createStatement();
			String sql= "INSERT INTO Cientificos VALUES ('"+cientifico.getDNI()+"', '"
					+cientifico.getNomApels()+"');";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Información",JOptionPane.INFORMATION_MESSAGE);
			System.out.println(sql);
			st.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro");
		}
	}

	public Cientifico buscarCientifico(String dni) 
	{
		Conexion conex= new Conexion();
		Cientifico cientifico= new Cientifico();
		boolean existe=false;
		try {
			String sql= "SELECT * FROM Cientificos where dni = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			consulta.setString(1, dni);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				cientifico.setDNI(res.getString("DNI"));
				cientifico.setNomApels(res.getString("nomApels"));
			 }
			
			res.close();
			conex.desconectar();
			System.out.println(sql);
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return cientifico;
			}
			else return null;				
	}

	public void modificarCientifico(Cientifico cientifico) {
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE Cientificos SET DNI= ? ,nomApels = ? WHERE DNI= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setString(1, cientifico.getDNI());
            estatuto.setString(2, cientifico.getNomApels());
            estatuto.setString(3, cientifico.getDNI());
    
            estatuto.executeUpdate();
            
          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
          System.out.println(consulta);
         

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}

	public void eliminarCientifico(String dni)
	{
		Conexion conex= new Conexion();
		try {
			String sql= "DELETE FROM Cientificos WHERE DNI='"+dni+"'";
			Statement st = conex.getConnection().createStatement();
			st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);
            System.out.println(sql);
			st.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Eliminó");
		}
	}

}