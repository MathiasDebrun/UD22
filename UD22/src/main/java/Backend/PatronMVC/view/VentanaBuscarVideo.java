package Backend.PatronMVC.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Backend.PatronMVC.controller.VideoController;
import Backend.PatronMVC.model.dto.Video;
import Backend.PatronMVC.model.service.VideoServ;

public class VentanaBuscarVideo extends JFrame implements ActionListener{
private static final long serialVersionUID = 1L;
	
	private VideoController VideoController; //objeto ClienteController que permite la relacion entre esta clase y la clase ClienteController
	private JLabel labelTitulo;
	private JTextField textId,texttitulo,textdirector,textid_cliente;
	private JLabel id,titulo,director,id_cliente;
	private JButton botonGuardar,botonCancelar,botonBuscar,botonModificar,botonEliminar;
	
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de busqueda
	 */
	public VentanaBuscarVideo()  {

		botonGuardar = new JButton();
		botonGuardar.setBounds(50, 220, 120, 25);
		botonGuardar.setText("Guardar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(190, 250, 120, 25);
		botonCancelar.setText("Cancelar");
		
		botonBuscar = new JButton();
		botonBuscar.setBounds(170, 80, 62, 25);
		botonBuscar.setText("Ok");
		
		botonEliminar = new JButton();
		botonEliminar.setBounds(330, 220, 120, 25);
		botonEliminar.setText("Eliminar");
		
		botonModificar = new JButton();
		botonModificar.setBounds(190, 220, 120, 25);
		botonModificar.setText("Modificar");

		labelTitulo = new JLabel();
		labelTitulo.setText("ADMINISTRAR Videos");
		labelTitulo.setBounds(120, 20, 380, 30);
		labelTitulo.setFont(new java.awt.Font("Verdana", 1, 18));

		id=new JLabel();
		id.setText("Id");
		id.setBounds(20, 80, 80, 25);
		getContentPane().add(id);
		
		titulo=new JLabel();
		titulo.setText("Nombre");
		titulo.setBounds(20, 120, 80, 25);
		getContentPane().add(titulo);

		director=new JLabel();
		director.setText("Apellido");
		director.setBounds(278, 160, 80, 25);
		getContentPane().add(director);
		
		id_cliente=new JLabel();
		id_cliente.setText("Direccion");
		id_cliente.setBounds(20, 160, 80, 25);
		getContentPane().add(id_cliente);
	
		textId=new JTextField();
		textId.setBounds(80, 80, 80, 25);
		getContentPane().add(textId);
		
		texttitulo=new JTextField();
		texttitulo.setBounds(80, 120, 190, 25);
		getContentPane().add(texttitulo);

		textdirector=new JTextField();
		textdirector.setBounds(340, 160, 80, 25);
		getContentPane().add(textdirector);
		
		textid_cliente=new JTextField();
		textid_cliente.setBounds(80, 160, 190, 25);
		getContentPane().add(textid_cliente);
		
		
		botonModificar.addActionListener(this);
		botonEliminar.addActionListener(this);
		botonBuscar.addActionListener(this);
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);

		getContentPane().add(botonCancelar);
		getContentPane().add(botonBuscar);
		getContentPane().add(botonModificar);
		getContentPane().add(botonEliminar);
		getContentPane().add(botonGuardar);
		getContentPane().add(labelTitulo);
		limpiar();
				
		setSize(480, 320);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel fecha = new JLabel("Fecha");
		fecha.setBounds(278, 85, 70, 15);
		getContentPane().add(fecha);
		
		

	}


	public void setCoordinador(VideoController VideoController) {
		this.VideoController=VideoController;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				Video miVideo=new Video();
				miVideo.setId(Integer.parseInt(textId.getText()));
				miVideo.setTitulo(texttitulo.getText());
				miVideo.setDirector(textdirector.getText());
				miVideo.setId_cliente(Integer.parseInt(textid_cliente.getText()));
				

				VideoController.modificarVideo(miVideo);
				
				if (VideoServ.modificaVideo==true) {
					habilita(true, false, false, false, false, false, true, true);	
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (e.getSource()==botonBuscar)
		{
			Video miVideo=VideoController.buscarVideo(textId.getText());
			if (miVideo!=null)
			{
				muestraVideo(miVideo);
			}
			else if(VideoServ.consultaVideo==true){
				JOptionPane.showMessageDialog(null, "El Videono Existe","Advertencia",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if (e.getSource()==botonModificar)
		{
			habilita(false, true, true, true, false, true, false, false);
			
		}
		
		if (e.getSource()==botonEliminar)
		{
			if (!textId.getText().equals(""))
			{
				int respuesta = JOptionPane.showConfirmDialog(this,
						"Esta seguro de eliminar el Video?", "Confirmación",
						JOptionPane.YES_NO_OPTION);
				if (respuesta == JOptionPane.YES_NO_OPTION)
				{
					VideoController.eliminarVideo(textId.getText());
					limpiar();
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Ingrese un numero de Documento", "Información",JOptionPane.WARNING_MESSAGE);
			}
			
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}

	}



	/**
	 * permite cargar los datos de la Cliente consultada
	 * @param miCliente
	 */
	private void muestraVideo(Video miVideo) {
		texttitulo.setText(miVideo.getTitulo()+"");
		textdirector.setText(miVideo.getDirector()+"");
		textid_cliente.setText(miVideo.getId_cliente()+"");
		habilita(true, false, false, false,false, false, true, true);
	}


	/**
	 * Permite limpiar los componentes
	 */
	public void limpiar()
	{
		textId.setText("");
		texttitulo.setText("");
		textdirector.setText("");
		textid_cliente.setText("");
		habilita(true, false, false, false, false, false, true, true);
	}


	/**
	 * Permite habilitar los componentes para establecer una modificacion
	 * @param codigo
	 * @param nombre
	 * @param Dni
	 * @param tel
	 * @param direccion
	 * @param cargo
	 * @param bBuscar
	 * @param bGuardar
	 * @param bModificar
	 * @param bEliminar
	 */
	public void habilita(boolean id, boolean titulo, boolean Director, boolean id_cliente,	 boolean bBuscar, boolean bGuardar, boolean bModificar, boolean bEliminar)
	{
		textId.setEditable(id);
		texttitulo.setEditable(titulo);
		textdirector.setEditable(Director);
		textid_cliente.setEditable(id_cliente);
		botonGuardar.setEnabled(bGuardar);
		botonModificar.setEnabled(bModificar);
		botonEliminar.setEnabled(bEliminar);
	}
}
