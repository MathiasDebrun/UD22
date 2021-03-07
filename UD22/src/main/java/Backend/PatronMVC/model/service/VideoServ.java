package Backend.PatronMVC.model.service;
import javax.swing.JOptionPane;

import Backend.PatronMVC.controller.ClienteController;
import Backend.PatronMVC.controller.VideoController;
import Backend.PatronMVC.model.dao.ClienteDao;
import Backend.PatronMVC.model.dao.VideoDao;
import Backend.PatronMVC.model.dto.Cliente;
import Backend.PatronMVC.model.dto.Video;
public class VideoServ {
	private VideoController VideoController; 
	public static boolean consultaVideo=false;
	public static boolean modificaVideo=false;

	//Metodo de vinculación con el controller principal
		public void setVideoController(VideoController VideoController) {
			this.setController(VideoController);		
		}

		//Metodo que valida los datos de Registro antes de pasar estos al DAO
		public void validarRegistro(Video miVideo) {
			VideoDao miVideoDao;
			if (miVideo.getId() > 99) {
				miVideoDao = new VideoDao();
				miVideoDao.registrarVideo(miVideo);						
			}else {
				JOptionPane.showMessageDialog(null,"El id del Video debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
				
			}
			
		}
		
		//Metodo que valida los datos de consulta antes de pasar estos al DAO
		public Video validarConsulta(String idVideo) {
			VideoDao miVideoDao;
			
			try {
				int id=Integer.parseInt(idVideo);	
				if (id > 99) {
					miVideoDao = new VideoDao();
					consultaVideo=true;
					return miVideoDao.buscarVideo(id);						
				}else{
					JOptionPane.showMessageDialog(null,"El documento del Video debe ser mas de 3 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
					consultaVideo=false;
				}
				
			}catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"Debe ingresar un dato numerico","Error",JOptionPane.ERROR_MESSAGE);
				consultaVideo=false;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Se ha presentado un Error","Error",JOptionPane.ERROR_MESSAGE);
				consultaVideo=false;
			}
						
			return null;
		}

		//Metodo que valida los datos de Modificación antes de pasar estos al DAO
		public void validarModificacion(Video miVideo) {
			VideoDao miVideoDao;
			if (miVideo.getTitulo().length()>5) {
				miVideoDao = new VideoDao();
				miVideoDao.modificarVideo(miVideo);	
				modificaVideo=true;
			}else{
				JOptionPane.showMessageDialog(null,"El nombre del Titulo debe ser mayor a 5 digitos","Advertencia",JOptionPane.WARNING_MESSAGE);
				modificaVideo=false;
			}
		}

		//Metodo que valida los datos de Eliminación antes de pasar estos al DAO
		public void validarEliminacion(String id) {
			VideoDao miVideoDao=new VideoDao();
			miVideoDao.eliminarVideo(id);
		}

		
		
		public VideoController getVideoController() {
			return VideoController;
		}

		public void setController(VideoController VideoController) {
			this.VideoController = VideoController;
		}

}
