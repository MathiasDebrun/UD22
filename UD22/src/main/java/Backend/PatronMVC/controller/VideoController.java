package Backend.PatronMVC.controller;
import Backend.PatronMVC.model.dto.Cliente;
import Backend.PatronMVC.model.dto.Video;
import Backend.PatronMVC.model.service.ClienteServ;
import Backend.PatronMVC.model.service.VideoServ;
import Backend.PatronMVC.view.VentanaBuscar;
import Backend.PatronMVC.view.VentanaBuscarVideo;
import Backend.PatronMVC.view.VentanaPrincipal;
import Backend.PatronMVC.view.VentanaPrincipalVideo;
import Backend.PatronMVC.view.VentanaRegistro;
import Backend.PatronMVC.view.VentanaRegistroVideo;
public class VideoController {
	private VideoServ VideoServ;
	private VentanaPrincipalVideo miVentanaPrincipalVideo;
	private VentanaRegistroVideo miVentanaRegistroVideo;
	private VentanaBuscarVideo miVentanaBuscarVideo;
	
	//Metodos getter Setters de vistas
		public VentanaPrincipalVideo getMiVentanaPrincipaVideol() {
			return miVentanaPrincipalVideo;
		}
		public void setMiVentanaPrincipalVideo(VentanaPrincipalVideo miVentanaPrincipalVideo) {
			this.miVentanaPrincipalVideo = miVentanaPrincipalVideo;
		}
		public VentanaRegistroVideo getMiVentanaRegistroVideo() {
			return miVentanaRegistroVideo;
		}
		public void setMiVentanaRegistroVideo(VentanaRegistroVideo miVentanaRegistroVideo) {
			this.miVentanaRegistroVideo = miVentanaRegistroVideo;
		}
		public VentanaBuscarVideo getMiVentanaBuscarVideo() {
			return miVentanaBuscarVideo;
		}
		public void setMiVentanaBuscarVideo(VentanaBuscarVideo miVentanaBuscarVideo) {
			this.miVentanaBuscarVideo = miVentanaBuscarVideo;
		}
		public VideoServ getVideoServ() {
			return VideoServ;
		}
		public void setVideoServ(VideoServ VideoServ) {
			this.VideoServ = VideoServ;
		}
		
		//Hace visible las vistas de Registro y Consulta
		public void mostrarVentanaRegistroVideo() {
			miVentanaRegistroVideo.setVisible(true);
		}
		public void mostrarVentanaConsultaVideo() {
			miVentanaBuscarVideo.setVisible(true);
		}
		
		
		//Llamadas a los metodos CRUD de la capa service para validar los datos de las vistas
		public void registrarVideo(Video miVideo) {
			VideoServ.validarRegistro(miVideo);
		}
		
		public Video buscarVideo(String idVideo) {
			return VideoServ.validarConsulta(idVideo);
		}
		
		public void modificarVideo(Video miVideo) {
			VideoServ.validarModificacion(miVideo);
		}
		
		public void eliminarVideo(String id) {
			VideoServ.validarEliminacion(id);
		}


	}

