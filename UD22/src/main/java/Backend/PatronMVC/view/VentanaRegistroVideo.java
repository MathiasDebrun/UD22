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

public class VentanaRegistroVideo extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private VideoController VideoController; //objeto ClienteController que permite la relacion entre esta clase y la clase ClienteController
	private JLabel labelTitulo;
	private JTextField textId,texttitulo,textdirector,textid_cliente;
	private JLabel id,titulo,director,id_cliente;
	private JButton botonGuardar,botonCancelar;
	
	/**
	 * constructor de la clase donde se inicializan todos los componentes
	 * de la ventana de registro
	 */
	public VentanaRegistroVideo() {

		botonGuardar = new JButton();
		botonGuardar.setBounds(110, 220, 120, 25);
		botonGuardar.setText("Registrar");
		
		botonCancelar = new JButton();
		botonCancelar.setBounds(250, 220, 120, 25);
		botonCancelar.setText("Cancelar");

		labelTitulo = new JLabel();
		labelTitulo.setText("REGISTRO DE ClienteS");
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
		director.setBounds(290, 80, 80, 25);
		getContentPane().add(director);
		
		id_cliente=new JLabel();
		id_cliente.setText("Dni");
		id_cliente.setBounds(290, 120, 80, 25);
		getContentPane().add(id_cliente);
		
		textId=new JTextField();
		textId.setBounds(80, 80, 80, 25);
		getContentPane().add(textId);
		
		texttitulo=new JTextField();
		texttitulo.setBounds(80, 120, 190, 25);
		getContentPane().add(texttitulo);

		textdirector=new JTextField();
		textdirector.setBounds(353, 80, 80, 25);
		getContentPane().add(textdirector);
		

		textid_cliente=new JTextField();
		textid_cliente.setBounds(340, 120, 80, 25);
		getContentPane().add(textid_cliente);
		
		
		botonGuardar.addActionListener(this);
		botonCancelar.addActionListener(this);
		getContentPane().add(botonCancelar);
		getContentPane().add(botonGuardar);
		getContentPane().add(labelTitulo);
		limpiar();
		setSize(480, 300);
		setTitle("Patron de Diseño/MVC");
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

	}


	private void limpiar() 
	{
		textId.setText("");
		textNombre.setText("");
		textDni.setText("");
		textapellido.setText("");
		textDireccion.setText("");
	}


	public void setCoordinador(ClienteController ClienteController) {
		this.ClienteController=ClienteController;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==botonGuardar)
		{
			try {
				Video miVideo=new Video();
				miVideo.setIdCliente(Integer.parseInt(textId.getText()));
				miVideo.setNombreCliente(textNombre.getText());
				miVideo.setApellidoCliente(textapellido.getText());
				miVideo.setDniCliente(Integer.parseInt(textDni.getText()));
				miVideo.setDireccionCliente(textDireccion.getText());
				miVideo.setFechaCliente();
				
				ClienteController.registrarCliente(miCliente);	
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,"Error en el Ingreso de Datos","Error",JOptionPane.ERROR_MESSAGE);
				System.out.println(ex);
			}
		}
		if (e.getSource()==botonCancelar)
		{
			this.dispose();
		}
	}
	
	

}
