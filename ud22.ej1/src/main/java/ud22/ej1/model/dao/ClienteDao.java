package ud22.ej1.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ud22.ej1.model.conexion.Conexion;
import ud22.ej1.model.dto.ClienteDto;



public class ClienteDao {

	public void registrarCliente(ClienteDto miCliente)
	{
		Conexion conex= new Conexion();
		
		try {
			Statement st = conex.getConnection().createStatement();
			String sql= "INSERT INTO Cliente(nombre,apellido,direccion,DNI,fecha) VALUES ('"+miCliente.getNombreCliente()+"', '"
					+miCliente.getApellidoCliente()+"', '"+miCliente.getDireccionCliente()+"', '"
					+miCliente.getDniCliente()+"', '"+miCliente.getFechaCliente()+"');";
			st.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente","Informaci�n",JOptionPane.INFORMATION_MESSAGE);
			System.out.println(sql);
			st.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Registro");
		}
	}

	public ClienteDto buscarCliente(int codigo) 
	{
		Conexion conex= new Conexion();
		ClienteDto cliente= new ClienteDto();
		boolean existe=false;
		try {
			String sql= "SELECT * FROM Cliente where id = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			consulta.setInt(1, codigo);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				
				cliente.setIdCliente(Integer.parseInt(res.getString("id")));
				cliente.setNombreCliente(res.getString("nombre"));
				cliente.setApellidoCliente(res.getString("apellido"));
				cliente.setDireccionCliente(res.getString("direccion"));
				cliente.setDniCliente(Integer.parseInt(res.getString("DNI")));
				cliente.setFechaCliente(res.getString("fecha"));
				existe=true;
				
			 }
			res.close();
			conex.desconectar();
			System.out.println(sql);
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return cliente;
			}
			else return null;				
	}

	public void modificarCliente(ClienteDto miCliente) {
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE Cliente SET nombre = ? , apellido=? , direccion=? , DNI= ? , fecha = ? WHERE id= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setString(1, miCliente.getNombreCliente());
            estatuto.setString(2, miCliente.getApellidoCliente());
            estatuto.setString(3, miCliente.getDireccionCliente());
            estatuto.setInt(4,miCliente.getDniCliente());
            estatuto.setString(5, miCliente.getFechaCliente());
            estatuto.setInt(6, miCliente.getIdCliente());
            estatuto.executeUpdate();
            
          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmaci�n",JOptionPane.INFORMATION_MESSAGE);
          System.out.println(consulta);
         

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}

	public void eliminarCliente(String codigo)
	{
		Conexion conex= new Conexion();
		try {
			
			String sql= "DELETE FROM Cliente WHERE id='"+codigo+"'";
			Statement st = conex.getConnection().createStatement();
			st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","Informaci�n",JOptionPane.INFORMATION_MESSAGE);
            System.out.println(sql);
			st.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Elimino");
		}
	}
	
	public ArrayList<Integer> getIds() 
	{
		Conexion conex= new Conexion();
		ArrayList<Integer> ids = new ArrayList<Integer>();
		boolean existe=false;
		try {
			String sql= "SELECT id FROM Cliente;";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				ids.add(Integer.parseInt(res.getString("id")));
				existe = true;
			 }
			res.close();
			conex.desconectar();
			System.out.println(sql);
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return ids;
			}
			else return null;				
	}

}
