package Backend.PatronMVC.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Backend.PatronMVC.model.conexion.Conexion;
import Backend.PatronMVC.model.dto.Cientifico_Proyecto;


public class Cientifico_ProyectoDao {
	
	public void registrarC_P(Cientifico_Proyecto cP)
	{
		Conexion conex= new Conexion();
		
		try {
			Statement st = conex.getConnection().createStatement();
			String sql= "INSERT INTO cientifico_proyecto VALUES ('"+cP.getDniC_fk()+"', '"
					+cP.getIdP_fk()+");";
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

	public Cientifico_Proyecto buscarC_P(String dniC) 
	{
		Conexion conex= new Conexion();
		Cientifico_Proyecto cP= new Cientifico_Proyecto();
		boolean existe=false;
		try {
			String sql= "SELECT * FROM cientifico_proyecto where  dniC_fk= ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			consulta.setString(1, dniC);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				cP.setDniC_fk(res.getString("dniC_fk"));
				cP.setIdP_fk(res.getString("idP_fk"));
			 }
			
			res.close();
			conex.desconectar();
			System.out.println(sql);
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return cP;
			}
			else return null;				
	}

	public void modificarC_P(Cientifico_Proyecto cP) {
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE cientifico_proyecto SET idP_fk = ? WHERE dniC_fk= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setString(1, cP.getIdP_fk());
            estatuto.setString(2, cP.getDniC_fk());

            estatuto.executeUpdate();
            
          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
          System.out.println(consulta);
         

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}

	public void eliminarC_P(String dniC)
	{
		Conexion conex= new Conexion();
		try {
			String sql= "DELETE FROM cientifico_proyecto WHERE dniC_fk='"+dniC+"'";
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
