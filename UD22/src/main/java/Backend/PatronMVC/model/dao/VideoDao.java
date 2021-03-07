package Backend.PatronMVC.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Backend.PatronMVC.model.conexion.Conexion;
import Backend.PatronMVC.model.dto.Cliente;
import Backend.PatronMVC.model.dto.Video;

public class VideoDao {

	public void registrarVideo (Video miVideo) {
Conexion conex= new Conexion();
		
		try {
			Statement st = conex.getConnection().createStatement();
			String sql="Insert into Video values("
                    +miVideo.getId()+","
                    +"\""+miVideo.getTitulo()+"\","
                    +"\""+miVideo.getDirector()+"\","
                    +"\""+miVideo.getId_cliente()+"\","
                    + ");";

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
	
	
	public Video buscarVideo(int id) 
	{
		Conexion conex= new Conexion();
		Video Video= new Video();
		boolean existe=false;
		try {
			String sql= "SELECT * FROM Video where id = ? ";
			PreparedStatement consulta = conex.getConnection().prepareStatement(sql);
			consulta.setInt(1, id);
			ResultSet res = consulta.executeQuery();
			while(res.next()){
				existe=true;
				Video.setId(Integer.parseInt(res.getString("id")));
				Video.setTitulo(res.getString("titulo"));
				Video.setDirector(res.getString("director"));
				Video.setId_cliente(Integer.parseInt(res.getString("id_cliente")));
			 }
			res.close();
			conex.desconectar();
			System.out.println(sql);
					
			} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Error, no se conecto");
					System.out.println(e);
			}
		
			if (existe) {
				return Video;
			}
			else return null;				
	}
	public void modificarVideo(Video miVideo) {
		
		Conexion conex= new Conexion();
		try{
			String consulta="UPDATE Video SET id= ? ,titulo = ? , director=? , id_cliente=? WHERE id= ? ";
			PreparedStatement estatuto = conex.getConnection().prepareStatement(consulta);
			
            estatuto.setInt(1, miVideo.getId());
            estatuto.setString(2, miVideo.getTitulo());
            estatuto.setString(3, miVideo.getDirector());
            estatuto.setInt(4, miVideo.getId_cliente());
            estatuto.executeUpdate();
            
          JOptionPane.showMessageDialog(null, " Se ha Modificado Correctamente ","Confirmación",JOptionPane.INFORMATION_MESSAGE);
          System.out.println(consulta);
         

        }catch(SQLException	 e){

            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al Modificar","Error",JOptionPane.ERROR_MESSAGE);

        }
	}

	public void eliminarVideo(String id)
	{
		Conexion conex= new Conexion();
		try {
			String sql= "DELETE FROM Video WHERE id='"+id+"'";
			Statement st = conex.getConnection().createStatement();
			st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, " Se ha Eliminado Correctamente","Información",JOptionPane.INFORMATION_MESSAGE);
            System.out.println(sql);
			st.close();
			conex.desconectar();
			
		} catch (SQLException e) {
            System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se Elimino");
		}
	}
}
	

