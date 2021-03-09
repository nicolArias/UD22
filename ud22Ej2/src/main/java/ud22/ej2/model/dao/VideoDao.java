package ud22.ej2.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ud22.ej2.model.conexion.Conexion;
import ud22.ej2.model.dto.ClienteDto;
import ud22.ej2.model.dto.VideoDto;



public class VideoDao {

	public void registrarVideo(VideoDto miVideo)
	{
		Conexion conex= new Conexion();
		
		try {
			Statement st = conex.getConnection().createStatement();
			String sql= "INSERT INTO Videos(title, director, cli_id) VALUES ('"+miVideo.getTitleVideo()+"', '"
					+miVideo.getDirectorVideo()+"', '"+miVideo.getCli_idVideo()+"');";
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

	public VideoDto buscarVideo(int codigo) 
	{
		Conexion conex= new Conexion();
		VideoDto video= new VideoDto();
		boolean existe=false;
		try {
			String sql= "SELECT * FROM Videos where id = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			consulta.setInt(1, codigo);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				
				video.setIdVideo(Integer.parseInt(res.getString("id")));
				video.setTitleVideo(res.getString("title"));
				video.setDirectorVideo(res.getString("director"));
				video.setCli_idVideo(Integer.parseInt(res.getString("cli_id")));
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
				return video;
			}
			else return null;				
	}

	public void modificarVideo(VideoDto miVideo) {
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE Videos SET title = ? , director=? , cli_id=? WHERE id= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setString(1, miVideo.getTitleVideo());
            estatuto.setString(2, miVideo.getDirectorVideo());
            estatuto.setInt(3, miVideo.getCli_idVideo());
            
            estatuto.setInt(6, miVideo.getIdVideo());
            estatuto.executeUpdate();
            
          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmaci�n",JOptionPane.INFORMATION_MESSAGE);
          System.out.println(consulta);
         

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}

	public void eliminarVideo(String codigo)
	{
		Conexion conex= new Conexion();
		try {
			
			String sql= "DELETE FROM Videos WHERE id='"+codigo+"'";
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
			String sql= "SELECT id FROM Videos;";
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
