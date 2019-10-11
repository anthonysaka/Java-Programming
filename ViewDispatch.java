package frontEnd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import backEnd.Empresa;

import javax.swing.border.EtchedBorder;
import javax.swing.JDesktopPane;

public class ViewDispatch extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panelBg;

	private JLabel lblTitulo;
	private JLabel lblSelectAlmacen;
	private JComboBox cbxSelectCodigoProduct;
	private JButton btnBuscar;
	private JSeparator separator;
	
	private Empresa myCompany;
	private JLabel lblDisponible;
	private JSeparator separator_1;
	private JLabel lblEmpresaDistribuidora;
	private JLabel lblPorAlmacnSeleccionado;
	private JLabel lblAlmacen;
	private JSpinner spnCantidad;
	private JLabel lblCantidad;

	/**
	 * Create the dialog.
	 */
	public ViewDispatch(Empresa company) {
		this.myCompany = company;

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
			buttonPane.setBounds(0, 817, 1300, 83);
			panelBg.add(buttonPane);
			buttonPane.setBorder(null);
			buttonPane.setLayout(null);
			{

				JButton cancelButton = new JButton("Cancel");
				cancelButton.setRolloverIcon(new ImageIcon(ViewLossProfit.class.getResource("/imagenes/icons8_cancel_2_48px.png")));
				cancelButton.setPressedIcon(new ImageIcon(ViewLossProfit.class.getResource("/imagenes/icons8_cancel_2_48px.png")));
				cancelButton.setFont(new Font("Consolas", Font.BOLD, 20));
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setHideActionText(true);
				cancelButton.setBackground(new Color(0, 0, 0));
				cancelButton.setBorder(null);
				cancelButton.setIcon(new ImageIcon(ViewLossProfit.class.getResource("/imagenes/icons8_cancel_48px.png")));
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

		lblTitulo = new JLabel("Buscar disponibilidad para despachar.");
		lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 34));
		lblTitulo.setBounds(298, 85, 704, 31);
		panelBg.add(lblTitulo);

		lblSelectAlmacen = new JLabel("- Seleccione c\u00F3digo producto:");
		lblSelectAlmacen.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelectAlmacen.setForeground(Color.WHITE);
		lblSelectAlmacen.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblSelectAlmacen.setBounds(157, 161, 348, 31);
		panelBg.add(lblSelectAlmacen);

		cbxSelectCodigoProduct = new JComboBox();
		cbxSelectCodigoProduct.setFont(new Font("Consolas", Font.ITALIC, 20));
		cbxSelectCodigoProduct.setBounds(157, 205, 348, 31);
		panelBg.add(cbxSelectCodigoProduct);

		btnBuscar = new JButton();
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cantidad = Integer.parseInt(spnCantidad.getValue().toString());
				String codiProduct = cbxSelectCodigoProduct.getSelectedItem().toString();
				
				if ((cbxSelectCodigoProduct.getSelectedIndex() > 0) && (cantidad > 0)) {
					String almacenDisponible = myCompany.dispatchProduct(codiProduct, cantidad);
					
					if (almacenDisponible!=null) {
						lblDisponible.setText("Esta disponible!");
						lblAlmacen.setText(almacenDisponible);
					}
					else {
						lblDisponible.setText("NO disponible para despachar, Stock menor a 10% del Stock inicial!");
						lblAlmacen.setText("");
					}

				}
				else {
					JOptionPane.showMessageDialog(null, "Revise los campos!", "Aviso!", JOptionPane.WARNING_MESSAGE);
				}

			}
		});

		btnBuscar.setText("Buscar");
		btnBuscar.setPreferredSize(new Dimension(100, 30));
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.setFont(new Font("Consolas", Font.BOLD, 20));
		btnBuscar.setBorder(null);
		btnBuscar.setBackground(new Color(220, 20, 60));
		btnBuscar.setActionCommand("OK");
		btnBuscar.setBounds(961, 205, 178, 31);
		panelBg.add(btnBuscar);
		
		separator = new JSeparator();
		separator.setOpaque(true);
		separator.setBorder(null);
		separator.setBackground(Color.WHITE);
		separator.setBounds(112, 249, 1059, 4);
		panelBg.add(separator);
		
		lblDisponible = new JLabel("");
		lblDisponible.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisponible.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDisponible.setBounds(112, 359, 1059, 66);
		panelBg.add(lblDisponible);
		lblDisponible.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDisponible.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblDisponible.setForeground(new Color(0, 128, 0));
		lblDisponible.setFont(new Font("Consolas", Font.BOLD, 28));
		
		separator_1 = new JSeparator();
		separator_1.setOpaque(true);
		separator_1.setBorder(null);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(112, 504, 1059, 4);
		panelBg.add(separator_1);
		
		lblEmpresaDistribuidora = new JLabel("Disponible en:");
		lblEmpresaDistribuidora.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(139, 0, 0), new Color(139, 0, 0)));
		lblEmpresaDistribuidora.setBackground(new Color(0, 0, 0));
		lblEmpresaDistribuidora.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmpresaDistribuidora.setForeground(Color.WHITE);
		lblEmpresaDistribuidora.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblEmpresaDistribuidora.setBounds(561, 538, 178, 31);
		panelBg.add(lblEmpresaDistribuidora);
		
		lblPorAlmacnSeleccionado = new JLabel("Disponibilidad:");
		lblPorAlmacnSeleccionado.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(139, 0, 0), new Color(139, 0, 0)));
		lblPorAlmacnSeleccionado.setHorizontalAlignment(SwingConstants.LEFT);
		lblPorAlmacnSeleccionado.setForeground(Color.WHITE);
		lblPorAlmacnSeleccionado.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblPorAlmacnSeleccionado.setBounds(558, 275, 184, 31);
		panelBg.add(lblPorAlmacnSeleccionado);
		
		lblAlmacen = new JLabel("");
		lblAlmacen.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAlmacen.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlmacen.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblAlmacen.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAlmacen.setForeground(new Color(0, 128, 0));
		lblAlmacen.setFont(new Font("Consolas", Font.BOLD, 28));
		lblAlmacen.setBounds(347, 626, 606, 66);
		panelBg.add(lblAlmacen);
		
		spnCantidad = new JSpinner();
		spnCantidad.setFont(new Font("Consolas", Font.ITALIC, 20));
		spnCantidad.setBounds(665, 203, 220, 35);
		panelBg.add(spnCantidad);
		
		lblCantidad = new JLabel("- Cantidad:");
		lblCantidad.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblCantidad.setBounds(665, 161, 220, 31);
		panelBg.add(lblCantidad);

		loadAvailableProduct();

	}

	/******** Methods - Functions *******/

	private void loadAvailableProduct() {
		cbxSelectCodigoProduct.removeAllItems();
		
		for (int i = 0; i < myCompany.getCantAlmacen(); i++) {
			for (int k = 0; k < myCompany.getListAlmacen()[i].getCantProducto(); k++) {
				cbxSelectCodigoProduct.addItem(new String(myCompany.getListAlmacen()[i].getListProducto()[k].getCodigo()));
			}
		}
		cbxSelectCodigoProduct.insertItemAt(new String("<Seleccionar>"), 0);
		cbxSelectCodigoProduct.setSelectedIndex(0);
		
	}
}