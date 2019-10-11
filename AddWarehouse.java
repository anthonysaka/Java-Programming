package frontEnd;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import backEnd.Almacen;
import backEnd.Empresa;
import javax.swing.SwingConstants;


public class AddWarehouse extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblCodigo;
	private JComboBox cbxCiudad;
	private JSpinner spnTerreno;
	private JPanel panelBg;
	private JLabel lblCiudad;
	private JLabel lblMunicipio;
	private JLabel lblDimensinTerreno;
	private JTextField txtCodigoAlmacen;
	private JComboBox cbxMunicipio;
	
	private Empresa myCompany;
	private Almacen myWarehouse = null;
	private JSpinner spnCapacidad;
	private JLabel lblCapacidad;

	/**
	 * Create the dialog.
	 */
	public AddWarehouse(Empresa company, Almacen warehouse) {
		this.myCompany = company;
		this.myWarehouse = warehouse;

		getContentPane().setBackground(new Color(128, 128, 128));
		setBackground(new Color(255, 250, 250));
		setResizable(false);
		setUndecorated(true);
		setBounds(543, 66, 1300, 900);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 1300, 900);
		contentPanel.setBackground(new Color(20, 10, 15));
		contentPanel.setBorder(new LineBorder(new Color(255, 255, 255), 3, true));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		panelBg = new JPanel();
		panelBg.setBounds(0, 0, 1300, 900);
		contentPanel.add(panelBg);
		panelBg.setBackground(new Color(0, 0, 0));
		panelBg.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 0, 0));
			buttonPane.setBounds(12, 817, 1300, 83);
			panelBg.add(buttonPane);
			buttonPane.setBorder(null);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton();

				
				if (myWarehouse == null) {
					okButton.setText("Registrar");
					okButton.setPressedIcon(new ImageIcon(AddWarehouse.class.getResource("/imagenes/icons8_warehouse_48px.png")));
					okButton.setRolloverIcon(new ImageIcon(AddWarehouse.class.getResource("/imagenes/icons8_warehouse_48px.png")));
					okButton.setIcon(new ImageIcon(AddWarehouse.class.getResource("/imagenes/icons8_add_48px_1.png")));
				} 
				else
				{
					okButton.setText("Guardar");
					okButton.setRolloverIcon(new ImageIcon(AddWarehouse.class.getResource("/imagenes/icons8_save_close_48px.png")));
					okButton.setPressedIcon(new ImageIcon(AddWarehouse.class.getResource("/imagenes/icons8_save_close_48px.png")));
					okButton.setIcon(new ImageIcon(AddWarehouse.class.getResource("/imagenes/icons8_save_48px_1.png")));
				}
				
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String codigo = txtCodigoAlmacen.getText();
						String ciudad = cbxCiudad.getSelectedItem().toString();
						String municipio = cbxMunicipio.getSelectedItem().toString();
						int areaTerreno = Integer.parseInt(spnTerreno.getValue().toString());
						int capacidad = Integer.parseInt(spnCapacidad.getValue().toString());
						
						if (myWarehouse == null) {
							
							if ((cbxCiudad.getSelectedIndex()>0) && (cbxMunicipio.getSelectedIndex()>0) && (areaTerreno >0) && (capacidad >0) && myCompany.cantAlmacen < 3) {
								Almacen auxAlmacen = new Almacen(codigo, ciudad, municipio, capacidad, areaTerreno);
								myCompany.addAlmacen(auxAlmacen);
								JOptionPane.showMessageDialog(null, "Registro con exito!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);	
								clean();
								
							}
							else if(myCompany.cantAlmacen >= 3) {
								JOptionPane.showMessageDialog(null, "No se puede registrar mas de 3 almacenes", "Aviso!", JOptionPane.WARNING_MESSAGE);
								clean();
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Revisar los campos!", "Aviso!", JOptionPane.WARNING_MESSAGE);
							}
							
						}
						else {
							myWarehouse.setCodigo(codigo);
							myWarehouse.setCiudad(ciudad);
							myWarehouse.setMunicipio(municipio);
							myWarehouse.setAreaTerreno(areaTerreno);
							myWarehouse.setCapacidad(capacidad);
							myCompany.updateWarehouse(myWarehouse);
							JOptionPane.showMessageDialog(null, "Modificado con exito!", "Alerta - Hecho!", JOptionPane.INFORMATION_MESSAGE);
							dispose();
							ListWarehouse.loadTableWarehouse();
						}
					}
				});
				
				
				okButton.setFont(new Font("Consolas", Font.BOLD, 20));
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setOpaque(false);
				okButton.setBackground(new Color(255, 250, 250, 80));
				okButton.setBorder(null);
				okButton.setBounds(778, 8, 186, 48);
				okButton.setPreferredSize(new Dimension(100, 30));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			

				lblCodigo = new JLabel("Código:");
				lblCodigo.setVerticalTextPosition(SwingConstants.BOTTOM);
				lblCodigo.setVerticalAlignment(SwingConstants.BOTTOM);
				lblCodigo.setHorizontalAlignment(SwingConstants.LEFT);
				lblCodigo.setBounds(12, 18, 98, 35);
				panelBg.add(lblCodigo);
				lblCodigo.setForeground(new Color(255, 255, 255));
				lblCodigo.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 26));

				cbxCiudad = new JComboBox();
				cbxCiudad.setBounds(492, 182, 341, 35);
				panelBg.add(cbxCiudad);
				cbxCiudad.setFont(new Font("Consolas", Font.ITALIC, 20));
				cbxCiudad.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Santiago de los caballeros"}));

				spnTerreno = new JSpinner();
				spnTerreno.setBounds(492, 502, 341, 35);
				panelBg.add(spnTerreno);
				spnTerreno.setFont(new Font("Consolas", Font.ITALIC, 20));
				spnTerreno.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
				

			}
			{

				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setRolloverIcon(new ImageIcon(AddWarehouse.class.getResource("/imagenes/icons8_cancel_2_48px.png")));
				cancelButton.setPressedIcon(new ImageIcon(AddWarehouse.class.getResource("/imagenes/icons8_cancel_2_48px.png")));
				cancelButton.setFont(new Font("Consolas", Font.BOLD, 20));
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setHideActionText(true);
				cancelButton.setBackground(new Color(0, 0, 0));
				cancelButton.setBorder(null);
				cancelButton.setIcon(new ImageIcon(AddWarehouse.class.getResource("/imagenes/icons8_cancel_48px.png")));
				cancelButton.setBounds(1020, 8, 186, 48);
				cancelButton.setPreferredSize(new Dimension(100, 30));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setHorizontalAlignment(SwingConstants.LEFT);
		lblCiudad.setForeground(Color.WHITE);
		lblCiudad.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 26));
		lblCiudad.setBounds(492, 134, 341, 35);
		panelBg.add(lblCiudad);
		
		lblMunicipio = new JLabel("Municipio:");
		lblMunicipio.setHorizontalAlignment(SwingConstants.LEFT);
		lblMunicipio.setForeground(Color.WHITE);
		lblMunicipio.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 26));
		lblMunicipio.setBounds(492, 285, 341, 35);
		panelBg.add(lblMunicipio);
		
		lblDimensinTerreno = new JLabel("Dimensi\u00F3n terreno (m^2):");
		lblDimensinTerreno.setHorizontalAlignment(SwingConstants.LEFT);
		lblDimensinTerreno.setForeground(Color.WHITE);
		lblDimensinTerreno.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 26));
		lblDimensinTerreno.setBounds(492, 454, 341, 35);
		panelBg.add(lblDimensinTerreno);
		
		txtCodigoAlmacen = new JTextField();
		txtCodigoAlmacen.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoAlmacen.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtCodigoAlmacen.setEnabled(false);
		txtCodigoAlmacen.setDisabledTextColor(Color.BLACK);
		txtCodigoAlmacen.setColumns(10);
		txtCodigoAlmacen.setBounds(122, 18, 164, 35);
		
		if(myWarehouse==null && Empresa.cantAlmacen < 2){
			txtCodigoAlmacen.setText("ALM-" +(Almacen.generateCode));
		}
		else {
			txtCodigoAlmacen.setText("ALM-" +(Almacen.generateCode));
		}
		
		panelBg.add(txtCodigoAlmacen);
		
		cbxMunicipio = new JComboBox();
		cbxMunicipio.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Santiago", "Licey", "Tamboril", "San Jose de las matas", "Villa Gonz\u00E1lez"}));
		cbxMunicipio.setFont(new Font("Consolas", Font.ITALIC, 20));
		cbxMunicipio.setBounds(492, 333, 341, 35);
		panelBg.add(cbxMunicipio);
		
		spnCapacidad = new JSpinner();
		spnCapacidad.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		spnCapacidad.setFont(new Font("Consolas", Font.ITALIC, 20));
		spnCapacidad.setBounds(492, 667, 341, 35);
		panelBg.add(spnCapacidad);
		
		lblCapacidad = new JLabel("Capacidad (tonelada):");
		lblCapacidad.setHorizontalAlignment(SwingConstants.LEFT);
		lblCapacidad.setForeground(Color.WHITE);
		lblCapacidad.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 26));
		lblCapacidad.setBounds(492, 619, 341, 35);
		panelBg.add(lblCapacidad);
		
		loadWarehouse();
	}
	

	/******** Methods - Functions *******/

	private void clean() {
		txtCodigoAlmacen.setText("ALM-"+(Almacen.generateCode));
		cbxCiudad.setSelectedIndex(0);
		cbxMunicipio.setSelectedIndex(0);
		spnCapacidad.setValue(Integer.parseInt("0"));
		spnTerreno.setValue(Integer.parseInt("0"));
	}
	
	private void loadWarehouse() {
		if (myWarehouse!=null) {
			txtCodigoAlmacen.setText(myWarehouse.getCodigo());
			cbxCiudad.setSelectedItem(myWarehouse.getCiudad().toString());
			cbxMunicipio.setSelectedItem(myWarehouse.getMunicipio().toString());
			spnCapacidad.setValue(myWarehouse.getCapacidad());
			spnTerreno.setValue(myWarehouse.getAreaTerreno());
		}
	}
}
