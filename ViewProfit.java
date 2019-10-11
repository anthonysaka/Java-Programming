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

public class ViewProfit extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panelBg;

	private JLabel lblTitulo;
	private JLabel lblSelectAlmacen;
	private JComboBox cbxSelectAlmacen;
	private JTextField txtCodeAlmacen;
	private JButton btnSelect;
	private JSeparator separator;
	
	private Empresa myCompany;
	private JLabel lblGananciaBrutaEstimada;
	private JLabel lblBruta;
	private JLabel lblGananciaNetaActual;
	private JLabel lblNeta;

	/**
	 * Create the dialog.
	 */
	public ViewProfit(Empresa company) {
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

		lblTitulo = new JLabel("Consultas de ganancias.");
		lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 34));
		lblTitulo.setBounds(432, 86, 437, 31);
		panelBg.add(lblTitulo);

		lblSelectAlmacen = new JLabel("- Seleccione un almac\u00E9n:");
		lblSelectAlmacen.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelectAlmacen.setForeground(Color.WHITE);
		lblSelectAlmacen.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblSelectAlmacen.setBounds(135, 173, 288, 31);
		panelBg.add(lblSelectAlmacen);

		cbxSelectAlmacen = new JComboBox();
		cbxSelectAlmacen.setFont(new Font("Consolas", Font.ITALIC, 20));
		cbxSelectAlmacen.setBounds(452, 173, 260, 31);
		panelBg.add(cbxSelectAlmacen);

		txtCodeAlmacen = new JTextField();
		txtCodeAlmacen.setEnabled(false);
		txtCodeAlmacen.setEditable(false);
		txtCodeAlmacen.setFont(new Font("Consolas", Font.ITALIC, 20));
		txtCodeAlmacen.setColumns(10);
		txtCodeAlmacen.setBounds(772, 173, 160, 31);
		panelBg.add(txtCodeAlmacen);

		btnSelect = new JButton();
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbxSelectAlmacen.getSelectedIndex()>0) {
					String codeSelectAlmacen = cbxSelectAlmacen.getSelectedItem().toString();
					txtCodeAlmacen.setText(codeSelectAlmacen);
					
					float gananciaEstimadBruta = myCompany.estimateGrossProfitPerWarehouse(codeSelectAlmacen);
					float gananciaEstimaNeta = myCompany.estimateActualNetProfitPerWarehouse(codeSelectAlmacen);
					
					lblGananciaBrutaEstimada.setVisible(true);
					lblBruta.setText(Float.toString(gananciaEstimadBruta));
					lblBruta.setVisible(true);
					lblGananciaNetaActual.setVisible(true);
					lblNeta.setText(Float.toString(gananciaEstimaNeta));
					lblNeta.setVisible(true);
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
		
		lblBruta = new JLabel("");
		lblBruta.setVisible(false);
		lblBruta.setBounds(754, 307, 385, 66);
		panelBg.add(lblBruta);
		lblBruta.setVerticalAlignment(SwingConstants.BOTTOM);
		lblBruta.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblBruta.setForeground(new Color(0, 128, 0));
		lblBruta.setFont(new Font("Consolas", Font.BOLD, 28));
		
		lblGananciaBrutaEstimada = new JLabel("Ganancia bruta estimada: ");
		lblGananciaBrutaEstimada.setVisible(false);
		lblGananciaBrutaEstimada.setToolTipText("Ganancia bruta estimada. Est ganancia no se considera el estado de vecimiento de los productos, esta hace referencia a la ganancia m\u00E1xima que se puede esperar.");
		lblGananciaBrutaEstimada.setHorizontalAlignment(SwingConstants.LEFT);
		lblGananciaBrutaEstimada.setForeground(Color.WHITE);
		lblGananciaBrutaEstimada.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblGananciaBrutaEstimada.setBounds(185, 307, 300, 31);
		panelBg.add(lblGananciaBrutaEstimada);
		
		lblGananciaNetaActual = new JLabel("Ganancia neta estimada actual:");
		lblGananciaNetaActual.setVisible(false);
		lblGananciaNetaActual.setToolTipText("Ganancia neta estimada actual, seg\u00FAn el estado de vencimiento de los productos.");
		lblGananciaNetaActual.setHorizontalAlignment(SwingConstants.LEFT);
		lblGananciaNetaActual.setForeground(Color.WHITE);
		lblGananciaNetaActual.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblGananciaNetaActual.setBounds(185, 409, 360, 31);
		panelBg.add(lblGananciaNetaActual);
		
		lblNeta = new JLabel("");
		lblNeta.setVisible(false);
		lblNeta.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNeta.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNeta.setForeground(new Color(0, 128, 0));
		lblNeta.setFont(new Font("Consolas", Font.BOLD, 28));
		lblNeta.setBounds(754, 409, 385, 66);
		panelBg.add(lblNeta);

		loadAvailableWarehouse();

	}

	/******** Methods - Functions *******/

	private void loadAvailableWarehouse() {
		cbxSelectAlmacen.removeAllItems();
		
		for (int i = 0; i < myCompany.getCantAlmacen(); i++) {
			cbxSelectAlmacen.addItem(new String(myCompany.getListAlmacen()[i].getCodigo()));
		}
		cbxSelectAlmacen.insertItemAt(new String("<Seleccionar>"), 0);
		cbxSelectAlmacen.setSelectedIndex(0);
		
	}
}