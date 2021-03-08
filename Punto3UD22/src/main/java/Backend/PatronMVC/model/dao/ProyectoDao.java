package Backend.PatronMVC.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Backend.PatronMVC.model.conexion.Conexion;
import Backend.PatronMVC.model.dto.Proyecto;


public class ProyectoDao {

	public void registrarProyecto(Proyecto proyecto)
	{
		Conexion conex= new Conexion();
		
		try {
			Statement st = conex.getConnection().createStatement();
			String sql= "INSERT INTO Proyectos VALUES ("+proyecto.getId()+", "
					+proyecto.getNombre()+","+proyecto.getHoras()+");";
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

	public Proyecto buscarProyecto(String id) 
	{
		Conexion conex= new Conexion();
		Proyecto proyecto= new Proyecto();
		boolean existe=false;
		try {
			String sql= "SELECT * FROM Proyectos where id = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			consulta.setString(1, id);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				proyecto.setId(res.getString("id"));
				proyecto.setNombre(res.getString("nombre"));
				proyecto.setHoras(Integer.parseInt(res.getString("horas")));
			 }
			
			res.close();
			conex.desconectar();
			System.out.println(sql);
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return proyecto;
			}
			else return null;				
	}

	public void modificarProyecto(Proyecto proyecto) {
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE Proyectos SET nombre = ?, horas = ? WHERE id= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setString(1, proyecto.getNombre());
            estatuto.setInt(2, proyecto.getHoras());
            estatuto.setString(3, proyecto.getId());
    
            estatuto.executeUpdate();
            
          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
          System.out.println(consulta);
         

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}

	public void eliminarProyecto(String id)
	{
		Conexion conex= new Conexion();
		try {
			String sql= "DELETE FROM Proyectos WHERE id='"+id+"'";
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
