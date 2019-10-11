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

public class ViewLossProfit extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panelBg;

	private JLabel lblTitulo;
	private JLabel lblSelectAlmacen;
	private JComboBox cbxSelectAlmacen;
	private JTextField txtCodeAlmacen;
	private JButton btnSelect;
	private JSeparator separator;
	
	private Empresa myCompany;
	private JLabel lblPerdidaGananciaAlma;
	private JLabel lblPerdidaAl;
	private JSeparator separator_1;
	private JLabel lblPerdidaGananciaEmpre;
	private JLabel lblEmpresaDistribuidora;
	private JLabel lblPorAlmacnSeleccionado;
	private JLabel lblPerdidadEmpresa;

	/**
	 * Create the dialog.
	 */
	public ViewLossProfit(Empresa company) {
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

		lblTitulo = new JLabel("Consultas de perdidas de ganancias.");
		lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 34));
		lblTitulo.setBounds(318, 86, 665, 31);
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
					
					float perdidaAlmacen = (myCompany.estimateGrossProfitPerWarehouse(codeSelectAlmacen) - myCompany.estimateActualNetProfitPerWarehouse(codeSelectAlmacen));
					float perdidaEmpresa = myCompany.estimateActualLossProfitCompany();
					
					lblPerdidaGananciaAlma.setVisible(true);
					lblEmpresaDistribuidora.setVisible(true);
					lblPerdidaGananciaAlma.setVisible(true);
					lblPorAlmacnSeleccionado.setVisible(true);
			
					lblPerdidaAl.setText(Float.toString(perdidaAlmacen));
					lblPerdidadEmpresa.setText(Float.toString(perdidaEmpresa));
					lblPerdidaAl.setVisible(true);
					lblPerdidadEmpresa.setVisible(true);
					
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
		
		lblPerdidaAl = new JLabel("");
		lblPerdidaAl.setVisible(false);
		lblPerdidaAl.setBounds(754, 307, 385, 66);
		panelBg.add(lblPerdidaAl);
		lblPerdidaAl.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPerdidaAl.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblPerdidaAl.setForeground(new Color(255, 0, 0));
		lblPerdidaAl.setFont(new Font("Consolas", Font.BOLD, 28));
		
		lblPerdidaGananciaAlma = new JLabel("P\u00E9rdida de ganancia por productos vencidos:");
		lblPerdidaGananciaAlma.setVisible(false);
		lblPerdidaGananciaAlma.setToolTipText("Esta perdida es mas bien el monto que su empresa dejar\u00EDa de ganarse.");
		lblPerdidaGananciaAlma.setHorizontalAlignment(SwingConstants.LEFT);
		lblPerdidaGananciaAlma.setForeground(Color.WHITE);
		lblPerdidaGananciaAlma.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblPerdidaGananciaAlma.setBounds(185, 307, 516, 31);
		panelBg.add(lblPerdidaGananciaAlma);
		
		separator_1 = new JSeparator();
		separator_1.setOpaque(true);
		separator_1.setBorder(null);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(112, 504, 1059, 4);
		panelBg.add(separator_1);
		
		lblPerdidaGananciaEmpre = new JLabel("P\u00E9rdida de ganancia por productos vencidos:");
		lblPerdidaGananciaEmpre.setVisible(false);
		lblPerdidaGananciaEmpre.setHorizontalAlignment(SwingConstants.LEFT);
		lblPerdidaGananciaEmpre.setForeground(Color.WHITE);
		lblPerdidaGananciaEmpre.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblPerdidaGananciaEmpre.setBounds(185, 626, 527, 31);
		panelBg.add(lblPerdidaGananciaEmpre);
		
		lblEmpresaDistribuidora = new JLabel("Empresa - Distribuidora");
		lblEmpresaDistribuidora.setVisible(false);
		lblEmpresaDistribuidora.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(139, 0, 0), new Color(139, 0, 0)));
		lblEmpresaDistribuidora.setBackground(new Color(0, 0, 0));
		lblEmpresaDistribuidora.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmpresaDistribuidora.setForeground(Color.WHITE);
		lblEmpresaDistribuidora.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblEmpresaDistribuidora.setBounds(506, 538, 288, 31);
		panelBg.add(lblEmpresaDistribuidora);
		
		lblPorAlmacnSeleccionado = new JLabel("Por almac\u00E9n seleccionado");
		lblPorAlmacnSeleccionado.setVisible(false);
		lblPorAlmacnSeleccionado.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(139, 0, 0), new Color(139, 0, 0)));
		lblPorAlmacnSeleccionado.setHorizontalAlignment(SwingConstants.LEFT);
		lblPorAlmacnSeleccionado.setForeground(Color.WHITE);
		lblPorAlmacnSeleccionado.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblPorAlmacnSeleccionado.setBounds(506, 234, 292, 31);
		panelBg.add(lblPorAlmacnSeleccionado);
		
		lblPerdidadEmpresa = new JLabel("");
		lblPerdidadEmpresa.setVisible(false);
		lblPerdidadEmpresa.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblPerdidadEmpresa.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPerdidadEmpresa.setForeground(new Color(255, 0, 0));
		lblPerdidadEmpresa.setFont(new Font("Consolas", Font.BOLD, 28));
		lblPerdidadEmpresa.setBounds(754, 626, 385, 66);
		panelBg.add(lblPerdidadEmpresa);

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