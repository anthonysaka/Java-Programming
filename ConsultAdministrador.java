package frontEnd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
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

import javax.swing.JFormattedTextField;
import java.awt.Cursor;

public class ConsultAdministrador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panelBg;

	private JLabel lblTitulo;
	private JButton btnGanancia;
	private JButton btnPerdida;
	private JLabel lblGanancia;
	private JLabel lblPerdida;
	private JLabel lblCantidadDeProductos;
	private JButton btnCantProduct;
	private Empresa myCompany;

	/**
	 * Create the dialog.
	 * @return 
	 */
	public ConsultAdministrador(Empresa company) {
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
				cancelButton.setRolloverIcon(new ImageIcon(ConsultAdministrador.class.getResource("/imagenes/icons8_cancel_2_48px.png")));
				cancelButton.setPressedIcon(new ImageIcon(ConsultAdministrador.class.getResource("/imagenes/icons8_cancel_2_48px.png")));
				cancelButton.setFont(new Font("Consolas", Font.BOLD, 20));
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setHideActionText(true);
				cancelButton.setBackground(new Color(0, 0, 0));
				cancelButton.setBorder(null);
				cancelButton.setIcon(new ImageIcon(ConsultAdministrador.class.getResource("/imagenes/icons8_cancel_48px.png")));
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

		lblTitulo = new JLabel("Administrar distribuidora (Consultas).");
		lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 34));
		lblTitulo.setBounds(289, 86, 722, 31);
		panelBg.add(lblTitulo);

		btnGanancia = new JButton("");
		btnGanancia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGanancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewProfit ganancia = new ViewProfit(myCompany);
				ganancia.setModal(true);
				ganancia.setVisible(true);

			}
		});
		btnGanancia.setIcon(new ImageIcon(ConsultAdministrador.class.getResource("/imagenes/icons8_bullish_96px.png")));
		btnGanancia.setIconTextGap(30);
		btnGanancia.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnGanancia.setHorizontalAlignment(SwingConstants.LEADING);
		btnGanancia.setForeground(new Color(255, 255, 240));
		btnGanancia.setFont(new Font("Consolas", Font.BOLD, 26));
		btnGanancia.setBorder(null);
		btnGanancia.setBackground(Color.BLACK);
		btnGanancia.setBounds(246, 316, 106, 91);
		panelBg.add(btnGanancia);

		btnPerdida = new JButton("");
		btnPerdida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPerdida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewLossProfit perdida = new ViewLossProfit(myCompany);
				perdida.setModal(true);
				perdida.setVisible(true);

			}
		});
		btnPerdida.setIcon(new ImageIcon(ConsultAdministrador.class.getResource("/imagenes/icons8_bearish_96px.png")));
		btnPerdida.setIconTextGap(30);
		btnPerdida.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnPerdida.setHorizontalAlignment(SwingConstants.LEADING);
		btnPerdida.setForeground(new Color(255, 255, 240));
		btnPerdida.setFont(new Font("Consolas", Font.BOLD, 26));
		btnPerdida.setBorder(null);
		btnPerdida.setBackground(Color.BLACK);
		btnPerdida.setBounds(586, 316, 106, 91);
		panelBg.add(btnPerdida);

		lblGanancia = new JLabel("Estimar ganancias:");
		lblGanancia.setHorizontalAlignment(SwingConstants.LEFT);
		lblGanancia.setForeground(Color.WHITE);
		lblGanancia.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		lblGanancia.setBounds(200, 430, 198, 31);
		panelBg.add(lblGanancia);

		lblPerdida = new JLabel("Estimar p\u00E9rdidas:");
		lblPerdida.setHorizontalAlignment(SwingConstants.LEFT);
		lblPerdida.setForeground(Color.WHITE);
		lblPerdida.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		lblPerdida.setBounds(546, 430, 187, 31);
		panelBg.add(lblPerdida);
		
		lblCantidadDeProductos = new JLabel("Cantidad de productos:");
		lblCantidadDeProductos.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidadDeProductos.setForeground(Color.WHITE);
		lblCantidadDeProductos.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		lblCantidadDeProductos.setBounds(856, 430, 242, 31);
		panelBg.add(lblCantidadDeProductos);
		
		btnCantProduct = new JButton("");
		btnCantProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAmountProduct cantidadProduct = new ViewAmountProduct(myCompany);
				
				cantidadProduct.setModal(true);
				cantidadProduct.setVisible(true);
			}
		});
		btnCantProduct.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCantProduct.setIcon(new ImageIcon(ConsultAdministrador.class.getResource("/imagenes/icons8_ingredients_96px.png")));
		btnCantProduct.setIconTextGap(30);
		btnCantProduct.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCantProduct.setHorizontalAlignment(SwingConstants.LEADING);
		btnCantProduct.setForeground(new Color(255, 255, 240));
		btnCantProduct.setFont(new Font("Consolas", Font.BOLD, 26));
		btnCantProduct.setBorder(null);
		btnCantProduct.setBackground(Color.BLACK);
		btnCantProduct.setBounds(924, 316, 106, 91);
		panelBg.add(btnCantProduct);

	}


}