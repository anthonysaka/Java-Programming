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
import javax.swing.DefaultComboBoxModel;

public class ViewAmountProduct extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panelBg;

	private JLabel lblTitulo;
	private JLabel lblSelectType;
	private JComboBox cbxSelectTypes;
	private JTextField txtTypeSelect;
	private JButton btnSelect;
	private JSeparator separator;
	
	private Empresa myCompany;
	private JLabel lblCantidadTitulo;
	private JLabel lblResultStock;
	private JLabel lblCantidadEncontrada;
	private JLabel lblResultCantidad;

	/**
	 * Create the dialog.
	 */
	public ViewAmountProduct(Empresa company) {
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
				cancelButton.setRolloverIcon(new ImageIcon(ViewProfit.class.getResource("/imagenes/icons8_cancel_2_48px.png")));
				cancelButton.setPressedIcon(new ImageIcon(ViewProfit.class.getResource("/imagenes/icons8_cancel_2_48px.png")));
				cancelButton.setFont(new Font("Consolas", Font.BOLD, 20));
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setHideActionText(true);
				cancelButton.setBackground(new Color(0, 0, 0));
				cancelButton.setBorder(null);
				cancelButton.setIcon(new ImageIcon(ViewProfit.class.getResource("/imagenes/icons8_cancel_48px.png")));
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

		lblTitulo = new JLabel("Consultas de cantidad de producto por tipo.");
		lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 34));
		lblTitulo.setBounds(234, 86, 833, 31);
		panelBg.add(lblTitulo);

		lblSelectType = new JLabel("- Seleccione un tipo:");
		lblSelectType.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelectType.setForeground(Color.WHITE);
		lblSelectType.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblSelectType.setBounds(135, 173, 288, 31);
		panelBg.add(lblSelectType);

		cbxSelectTypes = new JComboBox();
		cbxSelectTypes.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Atuendos", "Electronicos", "Comestibles"}));
		cbxSelectTypes.setFont(new Font("Consolas", Font.ITALIC, 20));
		cbxSelectTypes.setBounds(424, 173, 300, 31);
		panelBg.add(cbxSelectTypes);

		txtTypeSelect = new JTextField();
		txtTypeSelect.setEnabled(false);
		txtTypeSelect.setEditable(false);
		txtTypeSelect.setFont(new Font("Consolas", Font.ITALIC, 20));
		txtTypeSelect.setColumns(10);
		txtTypeSelect.setBounds(765, 173, 180, 31);
		panelBg.add(txtTypeSelect);

		btnSelect = new JButton();
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (cbxSelectTypes.getSelectedIndex()>0) {
					String tipoSelect= cbxSelectTypes.getSelectedItem().toString();
					txtTypeSelect.setText(tipoSelect);
					
					int stockRealEncontrada = myCompany.StockRealProductoByTipoAllAlmacenes(tipoSelect);
					int cantidadEncontrada = myCompany.cantProductoByTipoAllAlmacenes(tipoSelect);
					lblCantidadTitulo.setVisible(true);
					lblCantidadEncontrada.setVisible(true);
					lblResultStock.setText(Integer.toString(stockRealEncontrada));
					lblResultStock.setVisible(true);
					lblResultCantidad.setText(Integer.toString(cantidadEncontrada));
					lblResultCantidad.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Seleccion un almacen!", "Aviso!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnSelect.setText("Seleccionar");
		btnSelect.setPreferredSize(new Dimension(100, 30));
		btnSelect.setForeground(Color.BLACK);
		btnSelect.setFont(new Font("Consolas", Font.BOLD, 20));
		btnSelect.setBorder(null);
		btnSelect.setBackground(new Color(220, 20, 60));
		btnSelect.setActionCommand("OK");
		btnSelect.setBounds(992, 173, 147, 31);
		panelBg.add(btnSelect);
		
		separator = new JSeparator();
		separator.setOpaque(true);
		separator.setBorder(null);
		separator.setBackground(Color.WHITE);
		separator.setBounds(112, 217, 1059, 4);
		panelBg.add(separator);
		
		lblResultStock = new JLabel("");
		lblResultStock.setVisible(false);
		lblResultStock.setBounds(729, 307, 385, 66);
		panelBg.add(lblResultStock);
		lblResultStock.setVerticalAlignment(SwingConstants.BOTTOM);
		lblResultStock.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblResultStock.setForeground(new Color(0, 128, 0));
		lblResultStock.setFont(new Font("Consolas", Font.BOLD, 30));
		
		lblCantidadTitulo = new JLabel("Stock real disponible:");
		lblCantidadTitulo.setVisible(false);
		lblCantidadTitulo.setToolTipText("Stock real disponible en la empresa.");
		lblCantidadTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidadTitulo.setForeground(Color.WHITE);
		lblCantidadTitulo.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblCantidadTitulo.setBounds(224, 307, 300, 31);
		panelBg.add(lblCantidadTitulo);
		
		lblResultCantidad = new JLabel("");
		lblResultCantidad.setVisible(false);
		lblResultCantidad.setHorizontalAlignment(SwingConstants.LEFT);
		lblResultCantidad.setForeground(new Color(0, 128, 0));
		lblResultCantidad.setFont(new Font("Consolas", Font.BOLD, 30));
		lblResultCantidad.setBounds(729, 522, 385, 66);
		panelBg.add(lblResultCantidad);
		
		lblCantidadEncontrada = new JLabel("Cantidad encontrada:");
		lblCantidadEncontrada.setVisible(false);
		lblCantidadEncontrada.setToolTipText("Cantidad del tipo de producto encontrado. Esto hace referencia a que tantos productos del mismo tipo dispone la empresa.");
		lblCantidadEncontrada.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidadEncontrada.setForeground(Color.WHITE);
		lblCantidadEncontrada.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblCantidadEncontrada.setBounds(224, 522, 288, 31);
		panelBg.add(lblCantidadEncontrada);

	}

}