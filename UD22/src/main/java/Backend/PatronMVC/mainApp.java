package Backend.PatronMVC;

import Backend.PatronMVC.controller.ClienteController;
import Backend.PatronMVC.controller.VideoController;
import Backend.PatronMVC.model.service.ClienteServ;
import Backend.PatronMVC.view.VentanaBuscar;
import Backend.PatronMVC.view.VentanaPrincipal;
import Backend.PatronMVC.view.VentanaRegistro;
import Backend.PatronMVC.model.service.VideoServ;
import Backend.PatronMVC.view.VentanaBuscarVideo;
import Backend.PatronMVC.view.VentanaPrincipalVideo;
import Backend.PatronMVC.view.VentanaRegistroVideo;

public class mainApp {
	
	ClienteServ miClienteServ;
	VentanaPrincipal miVentanaPrincipal;
	VentanaBuscar miVentanaBuscar;
	VentanaRegistro miVentanaRegistro;
	ClienteController ClienteController;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		mainApp miPrincipal=new mainApp();
		miPrincipal.iniciar();
	}

	/**
	 * Permite instanciar todas las clases con las que trabaja
	 * el sistema
	 */
	private void iniciar() {
		/*Se instancian las clases*/
		miVentanaPrincipal=new VentanaPrincipal();
		miVentanaRegistro=new VentanaRegistro();
		miVentanaBuscar= new VentanaBuscar();
		miClienteServ=new ClienteServ();
		ClienteController= new ClienteController();
		
		/*Se establecen las relaciones entre clases*/
		miVentanaPrincipal.setCoordinador(ClienteController);
		miVentanaRegistro.setCoordinador(ClienteController);
		miVentanaBuscar.setCoordinador(ClienteController);
		miClienteServ.setclienteController(ClienteController);
		
		/*Se establecen relaciones con la clase coordinador*/
		ClienteController.setMiVentanaPrincipal(miVentanaPrincipal);
		ClienteController.setMiVentanaRegistro(miVentanaRegistro);
		ClienteController.setMiVentanaBuscar(miVentanaBuscar);
		ClienteController.setClienteServ(miClienteServ);
				
		miVentanaPrincipal.setVisible(true);
		
		VentanaPrincipalVideo miVentanaPrincipalVideo = new VentanaPrincipalVideo();
		VentanaRegistroVideo miVentanaRegistroVideo = new VentanaRegistroVideo();
		VentanaBuscarVideo miVentanaBuscarVideo = new VentanaBuscarVideo();
		VideoServ miVideoServ = new VideoServ();
		VideoController VideoController = new VideoController();
		
		/*Se establecen las relaciones entre clases*/
		miVentanaPrincipalVideo.setCoordinador(VideoController);
		miVentanaRegistroVideo.setCoordinador(VideoController);
		miVentanaBuscarVideo.setCoordinador(VideoController);
		miVideoServ.setVideoController(VideoController);
		
		/*Se establecen relaciones con la clase coordinador*/
		VideoController.setMiVentanaPrincipalVideo(miVentanaPrincipalVideo);
		VideoController.setMiVentanaRegistroVideo(miVentanaRegistroVideo);
		VideoController.setMiVentanaBuscarVideo(miVentanaBuscarVideo);
		
		VideoController.setVideoServ(miVideoServ);
				
		miVentanaPrincipalVideo.setVisible(true);
		
	}

}
