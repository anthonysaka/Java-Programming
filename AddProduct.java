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
import backEnd.Producto;

import javax.swing.SwingConstants;


public class AddProduct extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblCodigo;
	private JSpinner spnPrecioCompra;
	private JPanel panelBg;
	private JLabel lblNombre;
	private JLabel lblTipo;
	private JLabel lblDimensinTerreno;
	private JTextField txtCodigoProducto;
	private JComboBox cbxTipo;
	
	//private Almacen myWarehouse;
	private Empresa myCompany;
	private Producto myProduct = null;
	
	private JSpinner spnPrecioVenta;
	private JLabel lblCapacidad;
	private JTextField txtNombre;
	private JLabel lblStockInicial;
	private JLabel lblStockReal;
	private JSpinner spnStockInicial;
	private JSpinner spnStockReal;
	private JLabel lblDasVencimiento;
	private JSpinner spnDiasVenci;
	private JLabel lblAlmacen;
	private JComboBox cbxAlmacenList;

	/**
	 * Create the dialog.
	 */
	public AddProduct(Empresa company, Producto producto) {
		this.myCompany = company;
		this.myProduct = producto;

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

				if (myProduct == null) {
					okButton.setText("Registrar");
					okButton.setPressedIcon(new ImageIcon(AddProduct.class.getResource("/imagenes/icons8_warehouse_48px.png")));
					okButton.setRolloverIcon(new ImageIcon(AddProduct.class.getResource("/imagenes/icons8_warehouse_48px.png")));
					okButton.setIcon(new ImageIcon(AddProduct.class.getResource("/imagenes/icons8_add_48px_1.png")));
				} 
				else
				{
					okButton.setText("Guardar");
					okButton.setRolloverIcon(new ImageIcon(AddProduct.class.getResource("/imagenes/icons8_save_close_48px.png")));
					okButton.setPressedIcon(new ImageIcon(AddProduct.class.getResource("/imagenes/icons8_save_close_48px.png")));
					okButton.setIcon(new ImageIcon(AddProduct.class.getResource("/imagenes/icons8_save_48px_1.png")));
				}
				
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String nombre = txtNombre.getText();
						String codigo = txtCodigoProducto.getText();
						String tipo = cbxTipo.getSelectedItem().toString();
						Almacen almacenList = myCompany.searchAlmacenByCode(cbxAlmacenList.getSelectedItem().toString());
						int diasVenci = Integer.parseInt(spnDiasVenci.getValue().toString());
						float precioCompra = Float.parseFloat(spnPrecioCompra.getValue().toString());
						float precioVenta = Float.parseFloat(spnPrecioVenta.getValue().toString());
						int stockInicial = Integer.parseInt(spnStockInicial.getValue().toString());
						int stockReal = Integer.parseInt(spnStockReal.getValue().toString());
						
						if (myProduct == null) {
							
							if ((!nombre.equalsIgnoreCase("")) && (cbxTipo.getSelectedIndex() > 0) && (cbxAlmacenList.getSelectedIndex() > 0) && (diasVenci > 0) && (precioCompra > 0) && (precioVenta >= precioCompra) && (stockInicial > 0) && (stockReal <= stockInicial)) {
								Producto  auxProduct = new Producto(codigo, almacenList.getCodigo(), nombre, tipo, precioCompra, precioVenta, stockReal, stockInicial, diasVenci);
								almacenList.addProduct(auxProduct);
								JOptionPane.showMessageDialog(null, "Registro con exito!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);	
								clean();
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Revisar los campos!", "Aviso!", JOptionPane.WARNING_MESSAGE);
							}
						} 
						else
						{
							myProduct.setCodigo(codigo);
							myProduct.setNombre(nombre);
							myProduct.setTipo(tipo);
							myProduct.setDiasCadu(diasVenci);
							myProduct.setPrecioCompra(precioCompra);
							myProduct.setPrecioVenta(precioVenta);
							myProduct.setStockIni(stockInicial);
							myProduct.setStockReal(stockReal);
							myProduct.setCodigoAlmacen(almacenList.getCodigo());
							almacenList.updateProduct(myProduct);
							JOptionPane.showMessageDialog(null, "Modificado con exito!", "Alerta - Hecho!", JOptionPane.INFORMATION_MESSAGE);
							dispose();
							ListProduct.loadTableProduct();
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

				spnPrecioCompra = new JSpinner();
				spnPrecioCompra.setBounds(799, 480, 341, 35);
				panelBg.add(spnPrecioCompra);
				spnPrecioCompra.setFont(new Font("Consolas", Font.ITALIC, 20));
				spnPrecioCompra.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(1)));
				

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
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 26));
		lblNombre.setBounds(186, 211, 341, 35);
		panelBg.add(lblNombre);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 26));
		lblTipo.setBounds(186, 321, 341, 35);
		panelBg.add(lblTipo);
		
		lblDimensinTerreno = new JLabel("Precio compra:");
		lblDimensinTerreno.setHorizontalAlignment(SwingConstants.LEFT);
		lblDimensinTerreno.setForeground(Color.WHITE);
		lblDimensinTerreno.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 26));
		lblDimensinTerreno.setBounds(799, 435, 341, 35);
		panelBg.add(lblDimensinTerreno);
		
		txtCodigoProducto = new JTextField();
		txtCodigoProducto.setEnabled(false);
		txtCodigoProducto.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigoProducto.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtCodigoProducto.setDisabledTextColor(Color.BLACK);
		txtCodigoProducto.setColumns(10);
		txtCodigoProducto.setBounds(122, 18, 164, 35);
		
		if(myProduct==null){
			txtCodigoProducto.setText("PRO-" +(Producto.generateCode));
		}
		
		panelBg.add(txtCodigoProducto);
		
		cbxTipo = new JComboBox();
		cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Comestibles", "Electronicos", "Atuendos"}));
		cbxTipo.setFont(new Font("Consolas", Font.ITALIC, 20));
		cbxTipo.setBounds(186, 369, 341, 35);
		panelBg.add(cbxTipo);
		
		spnPrecioVenta = new JSpinner();
		spnPrecioVenta.setModel(new SpinnerNumberModel(new Float(0), null, null, new Float(1)));
		spnPrecioVenta.setFont(new Font("Consolas", Font.ITALIC, 20));
		spnPrecioVenta.setBounds(799, 596, 341, 35);
		panelBg.add(spnPrecioVenta);
		
		lblCapacidad = new JLabel("Precio venta:");
		lblCapacidad.setHorizontalAlignment(SwingConstants.LEFT);
		lblCapacidad.setForeground(Color.WHITE);
		lblCapacidad.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 26));
		lblCapacidad.setBounds(799, 548, 341, 35);
		panelBg.add(lblCapacidad);
		
		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombre.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtNombre.setEnabled(true);
		txtNombre.setEditable(true);
		txtNombre.setDisabledTextColor(Color.BLACK);
		txtNombre.setColumns(10);
		txtNombre.setBounds(186, 259, 341, 35);
		panelBg.add(txtNombre);
		
		lblStockInicial = new JLabel("Stock inicial:");
		lblStockInicial.setHorizontalAlignment(SwingConstants.LEFT);
		lblStockInicial.setForeground(Color.WHITE);
		lblStockInicial.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 26));
		lblStockInicial.setBounds(799, 211, 341, 35);
		panelBg.add(lblStockInicial);
		
		lblStockReal = new JLabel("Stock real:");
		lblStockReal.setHorizontalAlignment(SwingConstants.LEFT);
		lblStockReal.setForeground(Color.WHITE);
		lblStockReal.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 26));
		lblStockReal.setBounds(799, 321, 341, 35);
		panelBg.add(lblStockReal);
		
		spnStockInicial = new JSpinner();
		spnStockInicial.setFont(new Font("Consolas", Font.ITALIC, 20));
		spnStockInicial.setBounds(799, 259, 341, 35);
		panelBg.add(spnStockInicial);
		
		spnStockReal = new JSpinner();
		spnStockReal.setFont(new Font("Consolas", Font.ITALIC, 20));
		spnStockReal.setBounds(799, 369, 341, 35);
		panelBg.add(spnStockReal);
		
		lblDasVencimiento = new JLabel("D\u00EDas vencimiento:");
		lblDasVencimiento.setHorizontalAlignment(SwingConstants.LEFT);
		lblDasVencimiento.setForeground(Color.WHITE);
		lblDasVencimiento.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 26));
		lblDasVencimiento.setBounds(186, 548, 341, 35);
		panelBg.add(lblDasVencimiento);
		
		spnDiasVenci = new JSpinner();
		spnDiasVenci.setFont(new Font("Consolas", Font.ITALIC, 20));
		spnDiasVenci.setBounds(186, 596, 341, 35);
		panelBg.add(spnDiasVenci);
		
		lblAlmacen = new JLabel("Almacen:");
		lblAlmacen.setHorizontalAlignment(SwingConstants.LEFT);
		lblAlmacen.setForeground(Color.WHITE);
		lblAlmacen.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 26));
		lblAlmacen.setBounds(186, 435, 341, 35);
		panelBg.add(lblAlmacen);
		
		cbxAlmacenList = new JComboBox();
		cbxAlmacenList.setFont(new Font("Consolas", Font.ITALIC, 20));
		cbxAlmacenList.setBounds(186, 480, 341, 35);
		panelBg.add(cbxAlmacenList);
		
		loadAvailableWarehouse();
		loadProduct();
	}
	

	/******** Methods - Functions *******/

	private void clean() {
		txtCodigoProducto.setText("PRO-"+(Producto.generateCode));
		txtNombre.setText("");
		cbxAlmacenList.setSelectedIndex(0);
		cbxTipo.setSelectedIndex(0);
		spnPrecioVenta.setValue(Integer.parseInt("0"));
		spnPrecioCompra.setValue(Integer.parseInt("0"));
		spnDiasVenci.setValue(Integer.parseInt("0"));
		spnStockInicial.setValue(Integer.parseInt("0"));
		spnStockReal.setValue(Integer.parseInt("0"));
	}
	
	private void loadProduct() {
		if (myProduct!=null) {
			txtCodigoProducto.setText(myProduct.getCodigo());
			txtNombre.setText(myProduct.getNombre());
			cbxTipo.setSelectedItem(myProduct.getTipo().toString());
			cbxAlmacenList.setSelectedItem(myProduct.getCodigoAlmacen().toString());
			spnDiasVenci.setValue(myProduct.getDiasCadu());
			spnPrecioCompra.setValue(myProduct.getPrecioCompra());
			spnPrecioVenta.setValue(myProduct.getPrecioVenta());
			spnStockInicial.setValue(myProduct.getStockIni());
			spnStockReal.setValue(myProduct.getStockReal());
			
		}
	}
	
	
	private void loadAvailableWarehouse() {
		cbxAlmacenList.removeAllItems();
		
		for (int i = 0; i < myCompany.getCantAlmacen(); i++) {
			cbxAlmacenList.addItem(new String(myCompany.getListAlmacen()[i].getCodigo()));
		}
		cbxAlmacenList.insertItemAt(new String("<Seleccionar>"), 0);
		cbxAlmacenList.setSelectedIndex(0);
		
	}
}
