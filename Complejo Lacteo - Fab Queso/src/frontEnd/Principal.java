package frontEnd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import com.sun.javafx.scene.layout.region.Margins.Converter;
import com.sun.org.apache.bcel.internal.generic.LoadClass;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import com.sun.org.apache.xpath.internal.operations.Number;

import Animacion.Animacion;
import backEnd.Cheese;
import backEnd.CheeseCompany;
import backEnd.Client;
import backEnd.CylindriCheese;
import backEnd.HoleCheese;
import backEnd.Invoice;
import backEnd.SphereCheese;
import sun.util.resources.en.CurrencyNames_en_US;

import java.awt.CardLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;


public class Principal extends JFrame {

	private JPanel contentPane;
	private JPanel panelMenu;
	private JButton btnClose;
	private JButton btnMinimize;
	private JSeparator separator_2;

	private CheeseCompany myCompany;
	private JLabel lblIconLogo;
	private JLabel lbltxtSistemaVenta;
	private JLabel lblTituloQuesos;
	private JPanel panelTopBar;
	private JButton btnMenu;
	private JButton btnAgregar;
	private JSeparator separator_3;
	private JLabel lblClientes;
	private JButton button;
	private JButton button_1;
	private JPanel panelBackground;
	private JPanel panelBgHome;
	private JPanel panelAddCheese;
	private JLabel lblCode;
	private JTextField txtCode;
	private JPanel panelBgTypeCheese;
	private JLabel lblPrecioBase;
	private JLabel lblPrecioUnitario;
	private JLabel lblCantidad;
	private JTextField txtPriceUnit;
	private JPanel panelCylindricCheese;
	private JLabel lblLongitud;
	private JLabel lblRadioC;
	private JTextField txtLongitudC;
	private JTextField txtRadioC;
	private JButton btnEsfrico;
	private JButton btnCilndrico;
	private JButton btnHueco;
	private JLabel lblIconAddCheese;
	private JPanel panelEsfericoCheese;
	private JLabel lblRadio;
	private JTextField txtRadio;
	private JPanel panelHuecoCheese;
	private JLabel lblLongitudH;
	private JTextField txtLongitudHueco;
	private JLabel lblRadioExterior;
	private JTextField txtRadioExt;
	private JLabel lblRadioInterior;
	private JTextField txtRadioInter;
	private JButton btnCancelarCheese;
	private JPanel panelAddClient;
	private JLabel lblId;
	private JTextField txtID;
	private JLabel lblNombreCompleto;
	private JTextField txtName;
	private JLabel lblDireccin;
	private JTextField txtAddress;
	private JLabel lblTelefono;
	private JLabel lblIconAddClient;
	private JButton btnCancelarClient;
	private JButton btnRegistrarClient;
	private JButton btnRegistrarCheese;


	private static int typeCheeseIndex = 0 ; // 1 - Esferico, 2 - Cilindrico, 3 - Hueco
	private JFormattedTextField txtPriceBase;
	private JLabel lblCrdito;
	private JTextField txtCredito;
	private JButton btnQuesos;
	private JButton btnFacturar;
	private JLabel lblMenAdmin;
	private JPanel panelCheeses;
	private JScrollPane scrollPane;
	private JList<String> listCheeseProduct;
	private JLabel lblNewLabel;
	private JPanel panelFacturacion;
	private JLabel label_1;
	private JButton btnBuscar;
	private JLabel label_2;
	private JTextField txtNameCF;
	private JLabel label_3;
	private JTextField txtAddressCF;
	private JLabel label_4;
	private JLabel label_5;
	private JTextField txtCreditoCF;
	private JLabel lblBalance;
	private JTextField txtFacturaMonto;
	private JSeparator separator;
	private JLabel lblInformacinPesonal;
	private JSeparator separator_1;
	private JLabel lblInformacinMonetaria;
	private JButton btnAgregarProductos;
	private JButton btnClientes;
	private JFormattedTextField txtIdCF_1;
	private JButton btnComprarCheese;
	private JButton btnCancelar;
	private JButton btnAgregarCart;
	private JTextField txtcant;
	private JLabel lblCant;
	private JPanel panelCart;
	private JScrollPane scrollPane_1;
	private JList<String> listCart;
	private JFormattedTextField txtNumberFactura;

	private static ArrayList<Cheese> listTemporalCheeseBuy = new ArrayList<Cheese>();
	private JButton btnRemover;
	private JPanel panelProductosFact;
	private JScrollPane scrollPane_2;
	private JList<String> listProductFact;
	private JLabel label;
	private JLabel lblShoppingCart;
	private JLabel lblSub;
	private JFormattedTextField txtSubtotal;

	private float sumaFactura = 0.0f;
	private float deuda = 0.0f;
	private float pagado = 0.0f;
	private JLabel lblFacturas;
	private JButton btnPagar;
	private JLabel lblPagado;
	private JTextField txtPagado;
	private JLabel lblDeuda;
	private JTextField txtDeuda;
	private JSpinner txtAmountCheese;
	private JPanel panelClients;
	private JScrollPane scrollPane_3;
	private JList<String> listClients;
	
	private JFormattedTextField txtTelefono;

	private JTextField txtTelephoneF;
	private JPanel panelListFacturas;
	private JScrollPane scrollPane_4;
	private JTable tableFactura;
	
	private static DefaultTableModel model;
	private static JTable tableProduct;
	private static Object[] column;
	private JLabel label_6;
	private JLabel lblMenuDeslizante;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheeseCompany company = CheeseCompany.getInstance();
					Principal frame = new Principal(company);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws java.text.ParseException 
	 */
	public Principal(CheeseCompany company) throws java.text.ParseException {
		this.myCompany = company;

		setBackground(new Color(169, 169, 169));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1455, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		/** to adjust image at size of JLabel **/
		ImageIcon logo = new ImageIcon(getClass().getResource("/imagenes/icons8_cheese_50px.png"));

		btnMinimize = new JButton("");
		btnMinimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setExtendedState(ICONIFIED);
			}
		});
		btnMinimize.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/icons8_minimize_window_24px.png")));
		btnMinimize.setPreferredSize(new Dimension(100, 30));
		btnMinimize.setHideActionText(true);
		btnMinimize.setForeground(Color.WHITE);
		btnMinimize.setFont(new Font("Consolas", Font.BOLD, 20));
		btnMinimize.setBorder(null);
		btnMinimize.setBackground(new Color(4, 10, 20));
		btnMinimize.setActionCommand("Cancel");
		btnMinimize.setBounds(1401, 0, 26, 30);
		contentPane.add(btnMinimize);

		btnClose = new JButton("");
		btnClose.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/icons8_close_window_24px_1.png")));
		btnClose.setPressedIcon(new ImageIcon(Principal.class.getResource("/imagenes/icons8_close_sign_24px.png")));
		btnClose.setRolloverIcon(new ImageIcon(Principal.class.getResource("/imagenes/icons8_close_sign_24px.png")));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setPreferredSize(new Dimension(100, 30));
		btnClose.setHideActionText(true);
		btnClose.setForeground(new Color(4, 10, 20));
		btnClose.setFont(new Font("Consolas", Font.BOLD, 20));
		btnClose.setBorder(null);
		btnClose.setBackground(new Color(4, 10, 20));
		btnClose.setActionCommand("Cancel");
		btnClose.setBounds(1429, 0, 26, 30);
		contentPane.setBounds(1419, 0, 36, 30);
		contentPane.add(btnClose);

		panelTopBar = new JPanel();
		panelTopBar.setBounds(0, 0, 1455, 66);
		panelTopBar.setBackground(new Color(4, 10, 20));
		contentPane.add(panelTopBar);
		panelTopBar.setLayout(null);

		btnMenu = new JButton("");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int position = panelMenu.getX();
				if (position >= 0) {
					Animacion.mover_izquierda(0, -328, 3, 3, panelMenu);
					//		panelMenu.setVisible(false);
				}
				else {
					Animacion.mover_derecha(-328, 0	, 2, 2, panelMenu);
				}
			}
		});
		btnMenu.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/icons8_squared_menu_60px.png")));
		btnMenu.setPreferredSize(new Dimension(100, 30));
		btnMenu.setHideActionText(true);
		btnMenu.setForeground(Color.WHITE);
		btnMenu.setFont(new Font("Consolas", Font.BOLD, 20));
		btnMenu.setBorder(null);
		btnMenu.setBackground(new Color(4, 10, 20));
		btnMenu.setActionCommand("Cancel");
		btnMenu.setBounds(12, 0, 65, 66);
		panelTopBar.add(btnMenu);

		btnQuesos = new JButton("QUESOS");
		btnQuesos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBgHome.setVisible(false);
				panelAddCheese.setVisible(false);
				panelAddClient.setVisible(false);
				panelCheeses.setVisible(true);
				panelClients.setVisible(false);
				panelFacturacion.setVisible(false);
				panelListFacturas.setVisible(false);

				loadListCheeseProduct();

			}
		});
		btnQuesos.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/icons8_cheese_36px.png")));
		btnQuesos.setIconTextGap(10);
		btnQuesos.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnQuesos.setForeground(new Color(255, 255, 240));
		btnQuesos.setFont(new Font("Consolas", Font.BOLD, 22));
		btnQuesos.setBorder(null);
		btnQuesos.setBackground(new Color(8, 18, 30));
		btnQuesos.setBounds(329, 0, 170, 66);
		panelTopBar.add(btnQuesos);

		btnFacturar = new JButton("FACTURAR");
		btnFacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBgHome.setVisible(false);
				panelAddCheese.setVisible(false);
				panelAddClient.setVisible(false);
				panelCheeses.setVisible(false);
				panelClients.setVisible(false);
				panelListFacturas.setVisible(false);
				panelFacturacion.setVisible(true);

			}
		});
		btnFacturar.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/icons8_estimate_36px.png")));
		btnFacturar.setIconTextGap(10);
		btnFacturar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnFacturar.setForeground(new Color(255, 255, 240));
		btnFacturar.setFont(new Font("Consolas", Font.BOLD, 22));
		btnFacturar.setBorder(null);
		btnFacturar.setBackground(new Color(8, 18, 30));
		btnFacturar.setBounds(693, 0, 170, 66);
		panelTopBar.add(btnFacturar);

		lblMenAdmin = new JLabel("Men\u00FA Admin");
		lblMenAdmin.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblMenAdmin.setToolTipText("Desarrollador: Anthony Sakamoto");
		lblMenAdmin.setIconTextGap(20);
		lblMenAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenAdmin.setForeground(Color.WHITE);
		lblMenAdmin.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblMenAdmin.setBackground(Color.BLACK);
		lblMenAdmin.setBounds(106, 44, 123, 22);
		panelTopBar.add(lblMenAdmin);

		btnClientes = new JButton("CLIENTES");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelClients.setVisible(true);
				panelBgHome.setVisible(false);
				panelAddCheese.setVisible(false);
				panelAddClient.setVisible(false);
				panelCheeses.setVisible(false);
				panelFacturacion.setVisible(false);
				panelListFacturas.setVisible(false);
				loadListClients();

			}
		});
		btnClientes.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/icons8_client_management_36px.png")));
		btnClientes.setIconTextGap(10);
		btnClientes.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnClientes.setForeground(new Color(255, 255, 240));
		btnClientes.setFont(new Font("Consolas", Font.BOLD, 22));
		btnClientes.setBorder(null);
		btnClientes.setBackground(new Color(8, 18, 30));
		btnClientes.setBounds(511, 0, 170, 66);
		panelTopBar.add(btnClientes);

		panelBackground = new JPanel();
		panelBackground.setBackground(Color.WHITE);
		panelBackground.setBounds(330, 67, 1113, 670);
		contentPane.add(panelBackground);
		panelBackground.setLayout(new CardLayout(0, 0));

		panelBgHome = new JPanel();
		panelBgHome.setBackground(Color.WHITE);
		panelBackground.add(panelBgHome, "name_368693969433800");
		panelBgHome.setLayout(null);

		lblNewLabel = new JLabel("SISTEMA VENTA DE QUESOS");
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 30));
		lblNewLabel.setBounds(378, 309, 391, 31);
		panelBgHome.add(lblNewLabel);

		panelAddCheese = new JPanel();
		panelAddCheese.setBackground(Color.WHITE);
		panelBackground.add(panelAddCheese, "name_369367713910800");
		panelAddCheese.setLayout(null);

		lblCode = new JLabel("Code:");
		lblCode.setHorizontalAlignment(SwingConstants.LEFT);
		lblCode.setForeground(Color.BLACK);
		lblCode.setFont(new Font("Consolas", Font.PLAIN, 22));
		lblCode.setBounds(12, 13, 60, 31);
		panelAddCheese.add(lblCode);

		txtCode = new JTextField();
		txtCode.setEnabled(false);
		txtCode.setEditable(false);
		txtCode.setHorizontalAlignment(SwingConstants.CENTER);
		txtCode.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtCode.setDisabledTextColor(new Color(255, 69, 0));
		txtCode.setColumns(10);
		txtCode.setBounds(84, 13, 160, 30);
		panelAddCheese.add(txtCode);

		panelBgTypeCheese = new JPanel();
		panelBgTypeCheese.setVisible(false);
		panelBgTypeCheese.setBounds(84, 350, 940, 240);
		panelAddCheese.add(panelBgTypeCheese);
		panelBgTypeCheese.setLayout(new CardLayout(0, 0));

		panelCylindricCheese = new JPanel();
		panelCylindricCheese.setBackground(Color.WHITE);
		panelCylindricCheese.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Queso Cil\u00EDndrico", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCylindricCheese.setVisible(false);
		panelBgTypeCheese.add(panelCylindricCheese, "name_374839215966700");
		panelCylindricCheese.setLayout(null);

		lblLongitud = new JLabel("Longitud:");
		lblLongitud.setHorizontalAlignment(SwingConstants.LEFT);
		lblLongitud.setForeground(Color.BLACK);
		lblLongitud.setFont(new Font("Consolas", Font.PLAIN, 22));
		lblLongitud.setBounds(375, 44, 108, 31);
		panelCylindricCheese.add(lblLongitud);

		lblRadioC = new JLabel("Radio:");
		lblRadioC.setHorizontalAlignment(SwingConstants.LEFT);
		lblRadioC.setForeground(Color.BLACK);
		lblRadioC.setFont(new Font("Consolas", Font.PLAIN, 22));
		lblRadioC.setBounds(375, 141, 108, 31);
		panelCylindricCheese.add(lblRadioC);

		txtLongitudC = new JTextField();
		txtLongitudC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		txtLongitudC.setHorizontalAlignment(SwingConstants.CENTER);
		txtLongitudC.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtLongitudC.setEnabled(true);
		txtLongitudC.setEditable(true);
		txtLongitudC.setDisabledTextColor(Color.BLACK);
		txtLongitudC.setColumns(10);
		txtLongitudC.setBounds(375, 88, 160, 30);
		panelCylindricCheese.add(txtLongitudC);

		txtRadioC = new JTextField();
		txtRadioC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		txtRadioC.setHorizontalAlignment(SwingConstants.CENTER);
		txtRadioC.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtRadioC.setEnabled(true);
		txtRadioC.setEditable(true);
		txtRadioC.setDisabledTextColor(Color.BLACK);
		txtRadioC.setColumns(10);
		txtRadioC.setBounds(375, 185, 160, 30);
		panelCylindricCheese.add(txtRadioC);

		panelEsfericoCheese = new JPanel();
		panelEsfericoCheese.setBackground(Color.WHITE);
		panelBgTypeCheese.add(panelEsfericoCheese, "name_376245904401000");
		panelEsfericoCheese.setLayout(null);

		lblRadio = new JLabel("Radio:");
		lblRadio.setBounds(400, 82, 72, 27);
		lblRadio.setHorizontalAlignment(SwingConstants.LEFT);
		lblRadio.setForeground(Color.BLACK);
		lblRadio.setFont(new Font("Consolas", Font.PLAIN, 22));
		panelEsfericoCheese.add(lblRadio);

		txtRadio = new JTextField();
		txtRadio.setBounds(400, 119, 116, 30);
		txtRadio.setHorizontalAlignment(SwingConstants.CENTER);
		txtRadio.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtRadio.setEnabled(true);
		txtRadio.setEditable(true);
		txtRadio.setDisabledTextColor(Color.BLACK);
		txtRadio.setColumns(10);
		panelEsfericoCheese.add(txtRadio);

		panelHuecoCheese = new JPanel();
		panelHuecoCheese.setBorder(new TitledBorder(null, "Cil\u00EDndrico hueco", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBgTypeCheese.add(panelHuecoCheese, "name_376385964152000");
		panelHuecoCheese.setLayout(null);

		lblLongitudH = new JLabel("Longitud:");
		lblLongitudH.setHorizontalAlignment(SwingConstants.LEFT);
		lblLongitudH.setForeground(Color.BLACK);
		lblLongitudH.setFont(new Font("Consolas", Font.PLAIN, 22));
		lblLongitudH.setBounds(388, 43, 108, 31);
		panelHuecoCheese.add(lblLongitudH);

		txtLongitudHueco = new JTextField();
		txtLongitudHueco.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		txtLongitudHueco.setHorizontalAlignment(SwingConstants.CENTER);
		txtLongitudHueco.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtLongitudHueco.setEnabled(true);
		txtLongitudHueco.setEditable(true);
		txtLongitudHueco.setDisabledTextColor(Color.BLACK);
		txtLongitudHueco.setColumns(10);
		txtLongitudHueco.setBounds(388, 87, 180, 30);
		panelHuecoCheese.add(txtLongitudHueco);

		lblRadioExterior = new JLabel("Radio exterior:");
		lblRadioExterior.setHorizontalAlignment(SwingConstants.LEFT);
		lblRadioExterior.setForeground(Color.BLACK);
		lblRadioExterior.setFont(new Font("Consolas", Font.PLAIN, 22));
		lblRadioExterior.setBounds(200, 139, 180, 31);
		panelHuecoCheese.add(lblRadioExterior);

		txtRadioExt = new JTextField();
		txtRadioExt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		txtRadioExt.setHorizontalAlignment(SwingConstants.CENTER);
		txtRadioExt.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtRadioExt.setEnabled(true);
		txtRadioExt.setEditable(true);
		txtRadioExt.setDisabledTextColor(Color.BLACK);
		txtRadioExt.setColumns(10);
		txtRadioExt.setBounds(200, 183, 180, 30);
		panelHuecoCheese.add(txtRadioExt);

		lblRadioInterior = new JLabel("Radio interior:");
		lblRadioInterior.setHorizontalAlignment(SwingConstants.LEFT);
		lblRadioInterior.setForeground(Color.BLACK);
		lblRadioInterior.setFont(new Font("Consolas", Font.PLAIN, 22));
		lblRadioInterior.setBounds(580, 139, 180, 31);
		panelHuecoCheese.add(lblRadioInterior);

		txtRadioInter = new JTextField();
		txtRadioInter.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		txtRadioInter.setHorizontalAlignment(SwingConstants.CENTER);
		txtRadioInter.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtRadioInter.setEnabled(true);
		txtRadioInter.setEditable(true);
		txtRadioInter.setDisabledTextColor(Color.BLACK);
		txtRadioInter.setColumns(10);
		txtRadioInter.setBounds(580, 183, 180, 30);
		panelHuecoCheese.add(txtRadioInter);

		lblPrecioBase = new JLabel("Precio base:");
		lblPrecioBase.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioBase.setForeground(Color.BLACK);
		lblPrecioBase.setFont(new Font("Consolas", Font.PLAIN, 22));
		lblPrecioBase.setBounds(84, 93, 144, 31);
		panelAddCheese.add(lblPrecioBase);

		lblPrecioUnitario = new JLabel("Precio unitario:");
		lblPrecioUnitario.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioUnitario.setForeground(Color.BLACK);
		lblPrecioUnitario.setFont(new Font("Consolas", Font.PLAIN, 22));
		lblPrecioUnitario.setBounds(84, 137, 192, 31);
		panelAddCheese.add(lblPrecioUnitario);

		lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidad.setForeground(Color.BLACK);
		lblCantidad.setFont(new Font("Consolas", Font.PLAIN, 22));
		lblCantidad.setBounds(84, 181, 192, 31);
		panelAddCheese.add(lblCantidad);

		txtPriceUnit = new JTextField();
		txtPriceUnit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		txtPriceUnit.setHorizontalAlignment(SwingConstants.CENTER);
		txtPriceUnit.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtPriceUnit.setEnabled(true);
		txtPriceUnit.setEditable(true);
		txtPriceUnit.setDisabledTextColor(Color.BLACK);
		txtPriceUnit.setColumns(10);
		txtPriceUnit.setBounds(355, 137, 160, 30);
		panelAddCheese.add(txtPriceUnit);

		btnEsfrico = new JButton("Esf\u00E9rico");
		btnEsfrico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeCheeseIndex = 1;

				btnEsfrico.setEnabled(false);
				btnHueco.setEnabled(false);
				btnCilndrico.setEnabled(false);
				btnCancelarCheese.setEnabled(true);
				btnRegistrarCheese.setEnabled(true);

				panelBgTypeCheese.setVisible(true);
				panelCylindricCheese.setVisible(false);
				panelEsfericoCheese.setVisible(true);
				panelHuecoCheese.setVisible(false);

				txtCode.setText("QUE_ESF-"+CheeseCompany.generateCodeCheese);

			}
		});
		btnEsfrico.setIconTextGap(30);
		btnEsfrico.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnEsfrico.setForeground(new Color(255, 255, 240));
		btnEsfrico.setFont(new Font("Consolas", Font.BOLD, 17));
		btnEsfrico.setBorder(null);
		btnEsfrico.setBackground(new Color(4, 10, 20));
		btnEsfrico.setBounds(114, 279, 146, 30);
		panelAddCheese.add(btnEsfrico);

		btnCilndrico = new JButton("Cil\u00EDndrico");
		btnCilndrico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				typeCheeseIndex = 2;

				btnEsfrico.setEnabled(false);
				btnHueco.setEnabled(false);
				btnCilndrico.setEnabled(false);
				btnCancelarCheese.setEnabled(true);
				btnRegistrarCheese.setEnabled(true);

				panelBgTypeCheese.setVisible(true);
				panelCylindricCheese.setVisible(true);
				panelEsfericoCheese.setVisible(false);
				panelHuecoCheese.setVisible(false);

				txtCode.setText("QUE_CIL-"+CheeseCompany.generateCodeCheese);
			}
		});
		btnCilndrico.setIconTextGap(30);
		btnCilndrico.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCilndrico.setForeground(new Color(255, 255, 240));
		btnCilndrico.setFont(new Font("Consolas", Font.BOLD, 17));
		btnCilndrico.setBorder(null);
		btnCilndrico.setBackground(new Color(4, 10, 20));
		btnCilndrico.setActionCommand("btnArticulo");
		btnCilndrico.setBounds(478, 279, 146, 30);
		panelAddCheese.add(btnCilndrico);

		btnHueco = new JButton("Hueco");
		btnHueco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				typeCheeseIndex = 3;

				btnEsfrico.setEnabled(false);
				btnHueco.setEnabled(false);
				btnCilndrico.setEnabled(false);
				btnCancelarCheese.setEnabled(true);
				btnRegistrarCheese.setEnabled(true);

				panelBgTypeCheese.setVisible(true);
				panelCylindricCheese.setVisible(false);
				panelEsfericoCheese.setVisible(false);
				panelHuecoCheese.setVisible(true);

				txtCode.setText("QUE_HUE-"+CheeseCompany.generateCodeCheese);

			}
		});
		btnHueco.setIconTextGap(30);
		btnHueco.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnHueco.setForeground(new Color(255, 255, 240));
		btnHueco.setFont(new Font("Consolas", Font.BOLD, 17));
		btnHueco.setBorder(null);
		btnHueco.setBackground(new Color(4, 10, 20));
		btnHueco.setBounds(844, 279, 146, 30);
		panelAddCheese.add(btnHueco);

		lblIconAddCheese = new JLabel("");
		lblIconAddCheese.setToolTipText("Ventana para agregar quesos.");
		lblIconAddCheese.setBounds(712, 55, 219, 169);
		panelAddCheese.add(lblIconAddCheese);
		/** to adjust image at size of JLabel **/
		ImageIcon logoAddCheese = new ImageIcon(getClass().getResource("/imagenes/cheese_photo.png"));
		Icon CheeseAdd = new ImageIcon(logoAddCheese.getImage().getScaledInstance(lblIconAddCheese.getWidth(), lblIconAddCheese.getHeight(), Image.SCALE_SMOOTH));
		lblIconAddCheese.setIcon(CheeseAdd);

		btnCancelarCheese = new JButton("Cancelar");
		btnCancelarCheese.setEnabled(false);
		btnCancelarCheese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEsfrico.setEnabled(true);
				btnCilndrico.setEnabled(true);
				btnHueco.setEnabled(true);


				int option = JOptionPane.showConfirmDialog(null, "Esta seguro de cancelar?", "Cancelar - AVISO!", JOptionPane.WARNING_MESSAGE);

				if (option == JOptionPane.OK_OPTION) {
					cleanAddCheese();
					panelAddCheese.setVisible(false);
					panelBgHome.setVisible(true);
					panelBgTypeCheese.setVisible(false);
					btnCancelarCheese.setEnabled(false);
					btnRegistrarCheese.setEnabled(false);

				}

			}
		});
		btnCancelarCheese.setIconTextGap(30);
		btnCancelarCheese.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCancelarCheese.setForeground(new Color(255, 255, 240));
		btnCancelarCheese.setFont(new Font("Consolas", Font.BOLD, 17));
		btnCancelarCheese.setBorder(null);
		btnCancelarCheese.setBackground(new Color(4, 10, 20));
		btnCancelarCheese.setBounds(878, 613, 146, 30);
		panelAddCheese.add(btnCancelarCheese);

		btnRegistrarCheese = new JButton("Registrar");
		btnRegistrarCheese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/icons8_cheese_36px.png"));
				String[] options = {"Ok"};
				int cantidad = Integer.parseInt(txtAmountCheese.getValue().toString());

				if (!txtCode.getText().equalsIgnoreCase("") && !txtPriceBase.getText().equalsIgnoreCase("") && !txtPriceUnit.getText().equalsIgnoreCase("") && cantidad > 0) {
					String code = txtCode.getText();
					float precioBase = Float.parseFloat(txtPriceBase.getText());
					float precioUnit = Float.parseFloat(txtPriceUnit.getText());


					if (typeCheeseIndex == 1) {


						if (!txtRadio.getText().equalsIgnoreCase("")) {
							float radio = Float.parseFloat(txtRadio.getText());	
							Cheese addCheeseEsfe = new SphereCheese(code, precioBase, precioUnit, cantidad, radio);
							company.addCheese(addCheeseEsfe);
							JOptionPane.showOptionDialog(null, "Registro con exito!", "Aviso!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options);

							cleanAddCheese();
							panelBgTypeCheese.setVisible(false);
							btnCancelarCheese.setEnabled(false);
							btnRegistrarCheese.setEnabled(false);
							btnEsfrico.setEnabled(true);
							btnCilndrico.setEnabled(true);
							btnHueco.setEnabled(true);

						}
						else {
							JOptionPane.showMessageDialog(null, "Revise los campos!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);	
						}
					}
					else if (typeCheeseIndex == 2) {

						if (!txtRadioC.getText().equalsIgnoreCase("") && !txtLongitudC.getText().equalsIgnoreCase("")) {

							float radio = Float.parseFloat(txtRadioC.getText());
							float longitud = Float.parseFloat(txtLongitudC.getText());
							Cheese addCheeseCilin = new CylindriCheese(code, precioBase, precioUnit, cantidad, longitud, radio);
							company.addCheese(addCheeseCilin);


							JOptionPane.showOptionDialog(null, "Registro con exito!", "Aviso!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options);

							cleanAddCheese();
							panelBgTypeCheese.setVisible(false);
							btnCancelarCheese.setEnabled(false);
							btnRegistrarCheese.setEnabled(false);
							btnEsfrico.setEnabled(true);
							btnCilndrico.setEnabled(true);
							btnHueco.setEnabled(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "Revise los campos!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);	
						}
					}
					else if (typeCheeseIndex == 3) {


						if (!txtRadioExt.getText().equalsIgnoreCase("") && !txtRadioInter.getText().equalsIgnoreCase("") && !txtLongitudHueco.getText().equalsIgnoreCase("") ) {
							float radioExt = Float.parseFloat(txtRadioExt.getText());
							float radioInte = Float.parseFloat(txtRadioInter.getText());
							float longitud = Float.parseFloat(txtLongitudHueco.getText());

							if (longitud > 0 && radioExt > 0 && radioInte > 0) {
								if (radioInte < radioExt ) {
									Cheese addCheeseHueco = new HoleCheese(code, precioBase, precioUnit, cantidad, longitud, radioExt, radioInte);
									company.addCheese(addCheeseHueco);	

									JOptionPane.showOptionDialog(null, "Registro con exito!", "Aviso!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options);

									cleanAddCheese();
									panelBgTypeCheese.setVisible(false);
									btnCancelarCheese.setEnabled(false);
									btnRegistrarCheese.setEnabled(false);
									btnEsfrico.setEnabled(true);
									btnCilndrico.setEnabled(true);
									btnHueco.setEnabled(true);
								}
								else {
									JOptionPane.showMessageDialog(null, "El radio interior debe ser menor al radio exterior!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);	
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "La longitud y radios deben ser mayor a cero!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);	
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Revise los campos!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);	
						}
					}		
				}
				else {
					JOptionPane.showMessageDialog(null, "Revise los campos!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);	
				}

			}
		});
		btnRegistrarCheese.setIconTextGap(30);
		btnRegistrarCheese.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnRegistrarCheese.setForeground(new Color(255, 255, 240));
		btnRegistrarCheese.setFont(new Font("Consolas", Font.BOLD, 17));
		btnRegistrarCheese.setEnabled(false);
		btnRegistrarCheese.setBorder(null);
		btnRegistrarCheese.setBackground(new Color(4, 10, 20));
		btnRegistrarCheese.setBounds(720, 613, 146, 30);
		panelAddCheese.add(btnRegistrarCheese);


		txtPriceBase = new JFormattedTextField();
		txtPriceBase.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		txtPriceBase.setFont(new Font("Consolas", Font.BOLD, 20));
		txtPriceBase.setBounds(355, 98, 160, 30);
		panelAddCheese.add(txtPriceBase);

		txtAmountCheese = new JSpinner();
		txtAmountCheese.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		txtAmountCheese.setFont(new Font("Consolas", Font.ITALIC, 20));
		txtAmountCheese.setBounds(355, 182, 160, 30);
		panelAddCheese.add(txtAmountCheese);
		
		panelListFacturas = new JPanel();
		panelBackground.add(panelListFacturas, "name_604430406671400");
		panelListFacturas.setLayout(null);
		
		scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(12, 13, 1089, 555);
		panelListFacturas.add(scrollPane_4);
		
		tableFactura = new JTable();
		tableFactura.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CODIGO", "CEDULA CLIENTE", "TOTAL"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_4.setViewportView(tableFactura);


		panelAddClient = new JPanel();
		panelAddClient.setBackground(Color.WHITE);
		panelBackground.add(panelAddClient, "name_377471942343000");
		panelAddClient.setLayout(null);

		lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setForeground(Color.BLACK);
		lblId.setFont(new Font("Consolas", Font.PLAIN, 22));
		lblId.setBounds(119, 119, 60, 31);
		panelAddClient.add(lblId);

		txtID = new JFormattedTextField();
		try {
			txtID = new JFormattedTextField(new DefaultFormatterFactory(new MaskFormatter("###-#######-#"), new MaskFormatter("###-#######-#"), new MaskFormatter("###-#######-#")));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				btnRegistrarClient.setEnabled(true);
				btnCancelarClient.setEnabled(true);
			}
		});
		txtID.setDragEnabled(true);
		txtID.setDoubleBuffered(true);
		txtID.setHorizontalAlignment(SwingConstants.CENTER);
		txtID.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtID.setDisabledTextColor(new Color(255, 69, 0));
		txtID.setColumns(10);
		txtID.setBounds(119, 163, 228, 30);
		panelAddClient.add(txtID);

		lblNombreCompleto = new JLabel("Nombre completo:");
		lblNombreCompleto.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreCompleto.setForeground(Color.BLACK);
		lblNombreCompleto.setFont(new Font("Consolas", Font.PLAIN, 22));
		lblNombreCompleto.setBounds(119, 206, 192, 31);
		panelAddClient.add(lblNombreCompleto);

		txtName = new JTextField();
		txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtName.setEnabled(true);
		txtName.setEditable(true);
		txtName.setDisabledTextColor(Color.BLACK);
		txtName.setColumns(10);
		txtName.setBounds(119, 250, 450, 30);
		panelAddClient.add(txtName);

		lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setHorizontalAlignment(SwingConstants.LEFT);
		lblDireccin.setForeground(Color.BLACK);
		lblDireccin.setFont(new Font("Consolas", Font.PLAIN, 22));
		lblDireccin.setBounds(119, 293, 192, 31);
		panelAddClient.add(lblDireccin);

		txtAddress = new JTextField();
		txtAddress.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		txtAddress.setHorizontalAlignment(SwingConstants.CENTER);
		txtAddress.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtAddress.setEnabled(true);
		txtAddress.setEditable(true);
		txtAddress.setDisabledTextColor(Color.BLACK);
		txtAddress.setColumns(10);
		txtAddress.setBounds(119, 337, 450, 30);
		panelAddClient.add(txtAddress);

		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelefono.setForeground(Color.BLACK);
		lblTelefono.setFont(new Font("Consolas", Font.PLAIN, 22));
		lblTelefono.setBounds(119, 380, 192, 31);
		panelAddClient.add(lblTelefono);



		lblIconAddClient = new JLabel("");
		lblIconAddClient.setToolTipText("Ventana para agregar clientes.");
		lblIconAddClient.setBounds(798, 54, 241, 253);
		panelAddClient.add(lblIconAddClient);
		/** to adjust image at size of JLabel **/
		ImageIcon logoAddClient= new ImageIcon(getClass().getResource("/imagenes/client_logo.png"));
		Icon ClientAdd = new ImageIcon(logoAddClient.getImage().getScaledInstance(lblIconAddClient.getWidth(), lblIconAddClient.getHeight(), Image.SCALE_SMOOTH));
		lblIconAddClient.setIcon(ClientAdd);

		btnCancelarClient = new JButton("Cancelar");
		btnCancelarClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int option = JOptionPane.showConfirmDialog(null, "Esta seguro de cancelar?", "Cancelar - AVISO!", JOptionPane.WARNING_MESSAGE);

				if (option == JOptionPane.OK_OPTION) {
					cleanAddClient();
					panelAddCheese.setVisible(false);
					panelAddClient.setVisible(false);
					panelBgHome.setVisible(true);
					panelBgTypeCheese.setVisible(false);
					btnCancelarCheese.setEnabled(false);
					btnRegistrarCheese.setEnabled(false);

				}
			}
		});
		btnCancelarClient.setIconTextGap(30);
		btnCancelarClient.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCancelarClient.setForeground(new Color(255, 255, 240));
		btnCancelarClient.setFont(new Font("Consolas", Font.BOLD, 17));
		btnCancelarClient.setEnabled(false);
		btnCancelarClient.setBorder(null);
		btnCancelarClient.setBackground(new Color(4, 10, 20));
		btnCancelarClient.setBounds(893, 615, 146, 30);
		panelAddClient.add(btnCancelarClient);

		btnRegistrarClient = new JButton("Registrar");
		btnRegistrarClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtID.getText();
				String name = txtName.getText();
				String direccion = txtAddress.getText();
				String telefono = txtTelefono.getText();


				if (!id.equalsIgnoreCase("") && !name.equalsIgnoreCase("") && !direccion.equalsIgnoreCase("") && !telefono.equalsIgnoreCase("") && !txtCredito.getText().equalsIgnoreCase("")) {	
					float credito = Float.parseFloat(txtCredito.getText());
					Client addNewClient = new Client(id, name, direccion, telefono, credito);
					company.addClient(addNewClient);
					JOptionPane.showMessageDialog(null, "Registro con exito!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);	
					cleanAddClient();
					btnCancelarClient.setEnabled(false);
					btnRegistrarClient.setEnabled(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Revise los campos!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);	
				}

			}
		});
		btnRegistrarClient.setIconTextGap(30);
		btnRegistrarClient.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnRegistrarClient.setForeground(new Color(255, 255, 240));
		btnRegistrarClient.setFont(new Font("Consolas", Font.BOLD, 17));
		btnRegistrarClient.setEnabled(false);
		btnRegistrarClient.setBorder(null);
		btnRegistrarClient.setBackground(new Color(4, 10, 20));
		btnRegistrarClient.setBounds(735, 615, 146, 30);
		panelAddClient.add(btnRegistrarClient);

		lblCrdito = new JLabel("Cr\u00E9dito:");
		lblCrdito.setHorizontalAlignment(SwingConstants.LEFT);
		lblCrdito.setForeground(Color.BLACK);
		lblCrdito.setFont(new Font("Consolas", Font.PLAIN, 22));
		lblCrdito.setBounds(811, 349, 192, 31);
		panelAddClient.add(lblCrdito);

		txtCredito = new JTextField();
		txtCredito.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		txtCredito.setHorizontalAlignment(SwingConstants.CENTER);
		txtCredito.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtCredito.setEnabled(true);
		txtCredito.setEditable(true);
		txtCredito.setDisabledTextColor(Color.BLACK);
		txtCredito.setColumns(10);
		txtCredito.setBounds(811, 393, 228, 30);
		panelAddClient.add(txtCredito);


		txtTelefono = new JFormattedTextField(); 
		try {
			txtTelefono = new JFormattedTextField(new DefaultFormatterFactory(new MaskFormatter("(###) ### - ####"), new MaskFormatter("(###) ### - ####"), new MaskFormatter("(###) ### - ####")));

		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelefono.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtTelefono.setDragEnabled(true);
		txtTelefono.setDoubleBuffered(true);
		txtTelefono.setDisabledTextColor(new Color(255, 69, 0));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(318, 414, 251, 30);
		panelAddClient.add(txtTelefono);

		panelClients = new JPanel();
		panelBackground.add(panelClients, "name_594075047722100");
		panelClients.setLayout(null);

		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(12, 13, 1089, 644);
		panelClients.add(scrollPane_3);

		listClients = new JList<String>();
		listClients.setFont(new Font("Consolas", Font.PLAIN, 20));
		scrollPane_3.setViewportView(listClients);

		panelCheeses = new JPanel();
		panelBackground.add(panelCheeses, "name_458683856755200");
		panelCheeses.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 13, 1089, 579);
		panelCheeses.add(scrollPane);

		listCheeseProduct = new JList<String>();
		listCheeseProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (!listCheeseProduct.isSelectionEmpty()) {
					btnAgregarCart.setEnabled(true);
					btnRemover.setEnabled(true);
					btnComprarCheese.setEnabled(true);
					txtcant.setVisible(true);
					lblCant.setVisible(true);				
				}
		
	
	
				
				
			}
		});
		listCheeseProduct.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCheeseProduct.setFont(new Font("Consolas", Font.PLAIN, 20));


		scrollPane.setViewportView(listCheeseProduct);

		btnComprarCheese = new JButton("COMPRAR");
		btnComprarCheese.setEnabled(false);
		btnComprarCheese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int option = JOptionPane.showConfirmDialog(null, "Esta seguro de generar la factura?", "Facturación - AVISO!", JOptionPane.WARNING_MESSAGE);

				if (option == JOptionPane.OK_OPTION) {
					panelCheeses.setVisible(false);
					panelAddCheese.setVisible(false);
					panelAddClient.setVisible(false);
					panelBgHome.setVisible(false);
					panelFacturacion.setVisible(true);
					panelCart.setVisible(false);
					btnAgregarProductos.setVisible(false);
					btnPagar.setVisible(true);

					Client auxClient = myCompany.searchClientByID(txtIdCF_1.getText());
					Invoice addFactura = new Invoice(auxClient, listTemporalCheeseBuy);
					myCompany.addInvoice(addFactura);
					txtNumberFactura.setText("FA - " + CheeseCompany.generateCodeInvoice);
					addFactura.setCodigo(txtNumberFactura.getText());
					addFactura.setPrecioTotal(sumaFactura);
					txtFacturaMonto.setText(String.valueOf(sumaFactura));

					loadCheesesOnInvoice(addFactura.getListCheeseBuy());
					listTemporalCheeseBuy.removeAll(listTemporalCheeseBuy);

					sumaFactura = 0.0f;
					txtSubtotal.setText(String.valueOf(sumaFactura));

				}

			}

		});
		btnComprarCheese.setVisible(false);
		btnComprarCheese.setIconTextGap(30);
		btnComprarCheese.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnComprarCheese.setForeground(new Color(255, 255, 240));
		btnComprarCheese.setFont(new Font("Consolas", Font.BOLD, 22));
		btnComprarCheese.setBorder(null);
		btnComprarCheese.setBackground(new Color(4, 10, 20));
		btnComprarCheese.setBounds(960, 605, 141, 52);
		panelCheeses.add(btnComprarCheese);

		btnAgregarCart = new JButton("AGREGAR");
		btnAgregarCart.setEnabled(false);
		btnAgregarCart.setVisible(false);
		btnAgregarCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String codeCheese = listCheeseProduct.getSelectedValue().split("   ")[0];
				Cheese auxCheese = myCompany.searchCheeseByCode(codeCheese);
				Cheese cloneCheese = cloneCheese(auxCheese);
				Cheese cheeseCarito = searchTemporalCheeseByCode(cloneCheese.getCodigo());
				
				btnAgregarCart.setEnabled(false);
				btnRemover.setEnabled(false);
			//	btnComprarCheese.setEnabled(false);
				txtcant.setVisible(false);
				lblCant.setVisible(false);

				if (!txtcant.getText().equalsIgnoreCase("")) {

						if (myCompany.checkAmountCheese(cloneCheese)) {

							auxCheese.setCantidad(auxCheese.getCantidad() - Integer.parseInt(txtcant.getText()));

							if (cheeseCarito!= null) {

								cheeseCarito.setCantidad(cheeseCarito.getCantidad() + Integer.parseInt(txtcant.getText()));
							}
							else {
								listTemporalCheeseBuy.add(cloneCheese);
							}

							sumaFactura +=(cloneCheese.priceCheese()*cloneCheese.getCantidad());
						}
						else {
							JOptionPane.showConfirmDialog(null, "No hay disponible", "Aviso! - AVISO!", JOptionPane.WARNING_MESSAGE);
						}
						DecimalFormat decimalFormat = new DecimalFormat("#.00");
						txtSubtotal.setText(String.valueOf(decimalFormat.format(sumaFactura)));
						loadListProductCart();
						loadListCheeseProduct();
				}
			}
		});
		btnAgregarCart.setIconTextGap(30);
		btnAgregarCart.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAgregarCart.setForeground(new Color(255, 255, 240));
		btnAgregarCart.setFont(new Font("Consolas", Font.BOLD, 22));
		btnAgregarCart.setBorder(null);
		btnAgregarCart.setBackground(new Color(4, 10, 20));
		btnAgregarCart.setBounds(807, 605, 141, 52);
		panelCheeses.add(btnAgregarCart);

		txtcant = new JTextField();
		txtcant.setVisible(false);
		txtcant.setHorizontalAlignment(SwingConstants.CENTER);
		txtcant.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtcant.setDragEnabled(true);
		txtcant.setDoubleBuffered(true);
		txtcant.setDisabledTextColor(new Color(255, 69, 0));
		txtcant.setColumns(10);
		txtcant.setBounds(535, 627, 80, 30);
		panelCheeses.add(txtcant);

		lblCant = new JLabel("Cant:");
		lblCant.setVisible(false);
		lblCant.setHorizontalAlignment(SwingConstants.LEFT);
		lblCant.setForeground(Color.BLACK);
		lblCant.setFont(new Font("Consolas", Font.PLAIN, 22));
		lblCant.setBounds(463, 626, 60, 31);
		panelCheeses.add(lblCant);

		btnRemover = new JButton("REMOVER");
		btnRemover.setEnabled(false);
		btnRemover.setVisible(false);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codeCheese = listCart.getSelectedValue().split("  ~  ")[0];
				Cheese auxTempCheese = searchTemporalCheeseByCode(codeCheese);
				if (!txtcant.getText().equalsIgnoreCase("")) {
					if (checkAmountCheeseCart(auxTempCheese)) {

						auxTempCheese.setCantidad(auxTempCheese.getCantidad() - Integer.parseInt(txtcant.getText()));

						if (myCompany.searchCheeseByCode(auxTempCheese.getCodigo())!= null) {

							myCompany.searchCheeseByCode(auxTempCheese.getCodigo()).setCantidad(myCompany.searchCheeseByCode(auxTempCheese.getCodigo()).getCantidad() + Integer.parseInt(txtcant.getText()));
						}
						sumaFactura -=(auxTempCheese.priceCheese()*Integer.parseInt(txtcant.getText()));
					}
					else {
						JOptionPane.showConfirmDialog(null, "No existe cantidad en el carrito", "Aviso! - AVISO!", JOptionPane.WARNING_MESSAGE);
					}

					if (auxTempCheese.getCantidad() <= 0) {
						listTemporalCheeseBuy.remove(auxTempCheese);	
					}
					DecimalFormat decimalFormat = new DecimalFormat("#.00");
					txtSubtotal.setText(String.valueOf(decimalFormat.format(sumaFactura)));

					loadListProductCart();
					loadListCheeseProduct();
				}
			}
		});
		btnRemover.setIconTextGap(30);
		btnRemover.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnRemover.setForeground(new Color(255, 255, 240));
		btnRemover.setFont(new Font("Consolas", Font.BOLD, 22));
		btnRemover.setBorder(null);
		btnRemover.setBackground(new Color(4, 10, 20));
		btnRemover.setBounds(654, 605, 141, 52);
		panelCheeses.add(btnRemover);

		panelFacturacion = new JPanel();
		panelBackground.add(panelFacturacion, "name_462890828604800");
		panelFacturacion.setLayout(null);

		label_1 = new JLabel("ID:");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Consolas", Font.PLAIN, 22));
		label_1.setBounds(12, 13, 36, 31);
		panelFacturacion.add(label_1);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (btnBuscar.getText().equalsIgnoreCase("Buscar")) {

					Client auxClientFound = myCompany.searchClientByID(txtIdCF_1.getText());

					ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/icons8_client_management_36px.png"));
					String[] options = {"Ok"};	

					if (auxClientFound != null) {
						JOptionPane.showOptionDialog(null, "Cliente encontrado!", "Aviso!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options);
						txtIdCF_1.setText(auxClientFound.getId());
						txtIdCF_1.setEditable(false);
						txtNameCF.setText(auxClientFound.getName());
						txtAddressCF.setText(auxClientFound.getAddress());
						txtTelephoneF.setText(auxClientFound.getTelephone());
						txtCreditoCF.setText(String.valueOf(auxClientFound.getCredito()));

						btnBuscar.setEnabled(false);
						btnAgregarProductos.setVisible(true);		
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Cliente no encontrado!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);	

						btnBuscar.setText("Registrar");

						txtIdCF_1.setEditable(true);
						txtNameCF.setEditable(true);
						txtAddressCF.setEditable(true);
						txtTelephoneF.setEditable(true);
						txtCreditoCF.setEditable(true);				
					}
				}
				else 
				{
					String id = txtIdCF_1.getText();
					String name = txtNameCF.getText();
					String direccion = txtAddressCF.getText();
					String telefono = txtTelephoneF.getText();


					if (!name.isEmpty() && !name.equalsIgnoreCase("") && !direccion.equalsIgnoreCase("") && !telefono.isEmpty() && !txtCreditoCF.getText().equalsIgnoreCase("")) {

						float credito = Float.parseFloat(txtCreditoCF.getText());
						Client addNewClient = new Client(id, name, direccion, telefono, credito);
						company.addClient(addNewClient);
						JOptionPane.showMessageDialog(null, "Registro con exito!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);
						loadListClients();
						btnBuscar.setText("Buscar");
						btnBuscar.setEnabled(false);
						txtIdCF_1.setEditable(false);
						txtNameCF.setEditable(false);
						txtAddressCF.setEditable(false);
						txtTelephoneF.setEditable(false);
						txtCreditoCF.setEditable(false);
						btnAgregarProductos.setVisible(true);
					}
					else 
					{
						System.out.println("jajsjs");
						JOptionPane.showMessageDialog(null, "Revise los campos!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);	
					}

				}


			}
		});
		btnBuscar.setIconTextGap(30);
		btnBuscar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnBuscar.setForeground(new Color(255, 255, 240));
		btnBuscar.setFont(new Font("Consolas", Font.BOLD, 20));
		btnBuscar.setBorder(null);
		btnBuscar.setBackground(new Color(4, 10, 20));
		btnBuscar.setBounds(343, 14, 115, 30);
		panelFacturacion.add(btnBuscar);

		label_2 = new JLabel("Nombre completo:");
		label_2.setVerticalAlignment(SwingConstants.BOTTOM);
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Consolas", Font.PLAIN, 22));
		label_2.setBounds(12, 110, 192, 31);
		panelFacturacion.add(label_2);

		txtNameCF = new JTextField();
		txtNameCF.addKeyListener(new KeyAdapter() {
			//Restringir a solo letras.
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		txtNameCF.setHorizontalAlignment(SwingConstants.CENTER);
		txtNameCF.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtNameCF.setEditable(false);
		txtNameCF.setDisabledTextColor(Color.BLACK);
		txtNameCF.setColumns(10);
		txtNameCF.setBounds(216, 111, 450, 30);
		panelFacturacion.add(txtNameCF);

		label_3 = new JLabel("Direcci\u00F3n:");
		label_3.setVerticalAlignment(SwingConstants.BOTTOM);
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Consolas", Font.PLAIN, 22));
		label_3.setBounds(12, 154, 192, 31);
		panelFacturacion.add(label_3);

		txtAddressCF = new JTextField();
		txtAddressCF.setHorizontalAlignment(SwingConstants.CENTER);
		txtAddressCF.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtAddressCF.setEditable(false);
		txtAddressCF.setDisabledTextColor(Color.BLACK);
		txtAddressCF.setColumns(10);
		txtAddressCF.setBounds(216, 154, 450, 30);
		panelFacturacion.add(txtAddressCF);

		label_4 = new JLabel("Telefono:");
		label_4.setVerticalAlignment(SwingConstants.BOTTOM);
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Consolas", Font.PLAIN, 22));
		label_4.setBounds(12, 198, 192, 31);
		panelFacturacion.add(label_4);


		label_5 = new JLabel("Cr\u00E9dito:");
		label_5.setVerticalAlignment(SwingConstants.BOTTOM);
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Consolas", Font.PLAIN, 22));
		label_5.setBounds(753, 112, 96, 31);
		panelFacturacion.add(label_5);

		txtCreditoCF = new JTextField();
		txtCreditoCF.setHorizontalAlignment(SwingConstants.CENTER);
		txtCreditoCF.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtCreditoCF.setEditable(false);
		txtCreditoCF.setDisabledTextColor(Color.BLACK);
		txtCreditoCF.setColumns(10);
		txtCreditoCF.setBounds(861, 113, 228, 30);
		panelFacturacion.add(txtCreditoCF);

		lblBalance = new JLabel("Factura:");
		lblBalance.setVerticalAlignment(SwingConstants.BOTTOM);
		lblBalance.setHorizontalAlignment(SwingConstants.LEFT);
		lblBalance.setForeground(Color.BLACK);
		lblBalance.setFont(new Font("Consolas", Font.PLAIN, 22));
		lblBalance.setBounds(753, 156, 96, 31);
		panelFacturacion.add(lblBalance);

		txtFacturaMonto = new JTextField();
		txtFacturaMonto.setHorizontalAlignment(SwingConstants.CENTER);
		txtFacturaMonto.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtFacturaMonto.setEditable(false);
		txtFacturaMonto.setDisabledTextColor(Color.BLACK);
		txtFacturaMonto.setColumns(10);
		txtFacturaMonto.setBounds(861, 157, 228, 30);
		panelFacturacion.add(txtFacturaMonto);

		separator = new JSeparator();
		separator.setOpaque(true);
		separator.setBorder(null);
		separator.setBackground(new Color(4, 10, 20));
		separator.setBounds(12, 95, 654, 2);
		panelFacturacion.add(separator);

		lblInformacinPesonal = new JLabel("Informaci\u00F3n pesonal");
		lblInformacinPesonal.setVerticalAlignment(SwingConstants.BOTTOM);
		lblInformacinPesonal.setHorizontalAlignment(SwingConstants.LEFT);
		lblInformacinPesonal.setForeground(Color.BLACK);
		lblInformacinPesonal.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblInformacinPesonal.setBounds(22, 66, 192, 31);
		panelFacturacion.add(lblInformacinPesonal);

		separator_1 = new JSeparator();
		separator_1.setOpaque(true);
		separator_1.setBorder(null);
		separator_1.setBackground(new Color(4, 10, 20));
		separator_1.setBounds(753, 95, 336, 2);
		panelFacturacion.add(separator_1);

		lblInformacinMonetaria = new JLabel("Informaci\u00F3n monetaria");
		lblInformacinMonetaria.setVerticalAlignment(SwingConstants.BOTTOM);
		lblInformacinMonetaria.setHorizontalAlignment(SwingConstants.LEFT);
		lblInformacinMonetaria.setForeground(Color.BLACK);
		lblInformacinMonetaria.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblInformacinMonetaria.setBounds(763, 66, 228, 31);
		panelFacturacion.add(lblInformacinMonetaria);

		btnAgregarProductos = new JButton("Agregar productos");
		btnAgregarProductos.setVisible(false);
		btnAgregarProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelBgHome.setVisible(false);
				panelAddClient.setVisible(false);
				panelAddCheese.setVisible(false);
				panelFacturacion.setVisible(false);
				panelCheeses.setVisible(true);
				panelListFacturas.setVisible(false);
				panelProductosFact.setVisible(true);

				btnAgregarCart.setVisible(true);
				btnComprarCheese.setVisible(true);
				btnRemover.setVisible(true);
				lblSub.setEnabled(true);
				txtSubtotal.setEnabled(true);
				panelCart.setVisible(true);

				loadListCheeseProduct();
			}
		});
		btnAgregarProductos.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/icons8_shopping_cart_60px.png")));
		btnAgregarProductos.setIconTextGap(10);
		btnAgregarProductos.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAgregarProductos.setForeground(new Color(255, 255, 240));
		btnAgregarProductos.setFont(new Font("Consolas", Font.BOLD, 22));
		btnAgregarProductos.setBorder(null);
		btnAgregarProductos.setBackground(new Color(4, 10, 20));
		btnAgregarProductos.setBounds(390, 261, 307, 52);
		panelFacturacion.add(btnAgregarProductos);

		txtIdCF_1= new JFormattedTextField();
		try {
			txtIdCF_1 = new JFormattedTextField(new DefaultFormatterFactory(new MaskFormatter("###-#######-#"), new MaskFormatter("###-#######-#"), new MaskFormatter("###-#######-#")));
			txtIdCF_1.setFont(new Font("Consolas", Font.PLAIN, 16));
			txtIdCF_1.setHorizontalAlignment(SwingConstants.CENTER);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtIdCF_1.setBounds(60, 14, 247, 30);
		panelFacturacion.add(txtIdCF_1);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int option = JOptionPane.showConfirmDialog(null, "Esta seguro de cancelar?", "Cancelar - AVISO!", JOptionPane.WARNING_MESSAGE);

				if (option == JOptionPane.OK_OPTION) {
					btnBuscar.setEnabled(true);

					txtIdCF_1.setEditable(true);
					txtNameCF.setEditable(false);
					txtAddressCF.setEditable(false);
					txtTelephoneF.setEditable(false);
					txtCreditoCF.setEditable(false);

					btnBuscar.setText("Buscar");

					cleanAddClientCF();	
				}
			}
		});
		btnCancelar.setIconTextGap(30);
		btnCancelar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCancelar.setForeground(new Color(255, 255, 240));
		btnCancelar.setFont(new Font("Consolas", Font.BOLD, 20));
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(new Color(4, 10, 20));
		btnCancelar.setBounds(470, 14, 115, 30);
		panelFacturacion.add(btnCancelar);

		txtNumberFactura = new JFormattedTextField();
		txtNumberFactura.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumberFactura.setFont(new Font("Consolas", Font.BOLD, 20));
		txtNumberFactura.setEditable(false);
		txtNumberFactura.setBounds(842, 13, 247, 30);
		panelFacturacion.add(txtNumberFactura);

		panelProductosFact = new JPanel();
		panelProductosFact.setBounds(12, 326, 1089, 281);
		panelFacturacion.add(panelProductosFact);
		panelProductosFact.setLayout(null);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 1089, 281);
		panelProductosFact.add(scrollPane_2);

		listProductFact = new JList<String>();
		scrollPane_2.setViewportView(listProductFact);

		btnPagar = new JButton("PAGAR");
		btnPagar.setVisible(false);
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/icons8_paycheque_36px.png"));
				String[] options = {"Credito", "Efectivo"};	
				
				panelProductosFact.setVisible(false);

				int xOption	= JOptionPane.showOptionDialog(null, "Como desea pagar?", "Aviso!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, options, options);
				if (xOption == 0) {
					if (myCompany.checkCreditPayment(txtIdCF_1.getText(), txtNumberFactura.getText())) {
						ImageIcon icon0 = new ImageIcon(getClass().getResource("/imagenes/icons8_mastercard_credit_card_36px.png"));
						String montoInputCredito = (String) JOptionPane.showInputDialog(null, "Ingrese el monto a pagar"	, "Pago credito", JOptionPane.DEFAULT_OPTION, icon0, null, null);
						float montoCredito = Float.valueOf(montoInputCredito);
						pagado += montoCredito;
						deuda = Float.valueOf(txtFacturaMonto.getText()) - pagado;
						txtPagado.setText(String.valueOf(pagado));
						txtDeuda.setText(String.valueOf(deuda));

						btnRemover.setVisible(false);
						btnAgregarCart.setVisible(false);
						btnComprarCheese.setVisible(false);

						txtIdCF_1.setEditable(true);
						btnBuscar.setEnabled(true);
						btnAgregarProductos.setVisible(false);
						cleanAddClientCF();
					}
					else {
						JOptionPane.showOptionDialog(null, "No tiene suficientes credios!", "Aviso!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, null, null);
					}
				}
				else if (xOption == 1) {
					ImageIcon icon0 = new ImageIcon(getClass().getResource("/imagenes/icons8_cash_in_hand_36px.png"));
					String montoInputEfectivo = (String) JOptionPane.showInputDialog(null, "Ingrese el monto a pagar"	, "Pago credito", JOptionPane.DEFAULT_OPTION, icon0, null, null);
					float montoEfectivo = Float.valueOf(montoInputEfectivo);
					if (montoEfectivo > Float.valueOf(txtFacturaMonto.getText())) {
						JOptionPane.showOptionDialog(null,Float.valueOf(txtFacturaMonto.getText()) - montoEfectivo, "Aviso - Devuelta!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, null, null);
						pagado += montoEfectivo;
						deuda = Float.valueOf(txtFacturaMonto.getText()) - pagado;
						txtPagado.setText(String.valueOf(pagado));
						txtDeuda.setText(String.valueOf(deuda));

						btnRemover.setVisible(false);
						btnAgregarCart.setVisible(false);
						btnComprarCheese.setVisible(false);

						txtIdCF_1.setEditable(true);
						btnBuscar.setEnabled(true);
						btnAgregarProductos.setVisible(false);
						cleanAddClientCF();
					}
					else if (montoEfectivo == Float.valueOf(txtFacturaMonto.getText())) {
						JOptionPane.showOptionDialog(null, "Pago realizado!", "Aviso!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, null, null);	
						pagado += montoEfectivo;
						deuda = Float.valueOf(txtFacturaMonto.getText()) - pagado;
						txtPagado.setText(String.valueOf(pagado));
						txtDeuda.setText(String.valueOf(deuda));

						btnRemover.setVisible(false);
						btnAgregarCart.setVisible(false);
						btnComprarCheese.setVisible(false);

						txtIdCF_1.setEditable(true);
						btnBuscar.setEnabled(true);
						btnAgregarProductos.setVisible(false);
						cleanAddClientCF();

					}
					else {
						JOptionPane.showOptionDialog(null, "Tiene que pagar el monto total!", "Aviso!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, null, null);
					}
				}
			}
		});
		btnPagar.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/icons8_cash_in_hand_36px.png")));
		btnPagar.setIconTextGap(10);
		btnPagar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnPagar.setForeground(new Color(255, 255, 240));
		btnPagar.setFont(new Font("Consolas", Font.BOLD, 22));
		btnPagar.setBorder(null);
		btnPagar.setBackground(new Color(4, 10, 20));
		btnPagar.setBounds(915, 620, 186, 37);
		panelFacturacion.add(btnPagar);

		lblPagado = new JLabel("Pagado:");
		lblPagado.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPagado.setHorizontalAlignment(SwingConstants.LEFT);
		lblPagado.setForeground(Color.BLACK);
		lblPagado.setFont(new Font("Consolas", Font.PLAIN, 22));
		lblPagado.setBounds(753, 198, 96, 31);
		panelFacturacion.add(lblPagado);

		txtPagado = new JTextField();
		txtPagado.setHorizontalAlignment(SwingConstants.CENTER);
		txtPagado.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtPagado.setEditable(false);
		txtPagado.setDisabledTextColor(Color.BLACK);
		txtPagado.setColumns(10);
		txtPagado.setBounds(861, 198, 228, 30);
		panelFacturacion.add(txtPagado);

		lblDeuda = new JLabel("Deuda:");
		lblDeuda.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDeuda.setHorizontalAlignment(SwingConstants.LEFT);
		lblDeuda.setForeground(Color.BLACK);
		lblDeuda.setFont(new Font("Consolas", Font.PLAIN, 22));
		lblDeuda.setBounds(753, 242, 96, 31);
		panelFacturacion.add(lblDeuda);

		txtDeuda = new JTextField();
		txtDeuda.setForeground(Color.RED);
		txtDeuda.setHorizontalAlignment(SwingConstants.CENTER);
		txtDeuda.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtDeuda.setEditable(false);
		txtDeuda.setDisabledTextColor(Color.BLACK);
		txtDeuda.setColumns(10);
		txtDeuda.setBounds(861, 241, 228, 30);
		panelFacturacion.add(txtDeuda);


		txtTelephoneF = new JFormattedTextField(); 
		try {
			txtTelephoneF = new JFormattedTextField(new DefaultFormatterFactory(new MaskFormatter("(###) ### - ####"), new MaskFormatter("(###) ### - ####"), new MaskFormatter("(###) ### - ####")));

		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtTelephoneF.setHorizontalAlignment(SwingConstants.CENTER);
		txtTelephoneF.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtTelephoneF.setEditable(false);
		txtTelephoneF.setDisabledTextColor(Color.BLACK);
		txtTelephoneF.setColumns(10);
		txtTelephoneF.setBounds(408, 197, 258, 30);
		panelFacturacion.add(txtTelephoneF);


		panelMenu = new JPanel();
		panelMenu.setBounds(0, 67, 328, 683);
		contentPane.add(panelMenu);
		panelMenu.setBackground(new Color(4, 10, 20));
		panelMenu.setLayout(null);

		separator_2 = new JSeparator();
		separator_2.setOpaque(true);
		separator_2.setBorder(null);
		separator_2.setBackground(Color.WHITE);
		separator_2.setBounds(12, 606, 305, 4);
		panelMenu.add(separator_2);

		lblIconLogo = new JLabel("");
		lblIconLogo.setToolTipText("Sistema de ventas de queso.");
		lblIconLogo.setBounds(127, 41, 70, 65);
		panelMenu.add(lblIconLogo);
		Icon iconLogo = new ImageIcon(logo.getImage().getScaledInstance(lblIconLogo.getWidth(), lblIconLogo.getHeight(), Image.SCALE_SMOOTH));
		lblIconLogo.setIcon(iconLogo);

		lbltxtSistemaVenta = new JLabel("Sistema ventas de quesos");
		lbltxtSistemaVenta.setVerticalTextPosition(SwingConstants.BOTTOM);
		lbltxtSistemaVenta.setToolTipText("Desarrollador: Anthony Sakamoto");
		lbltxtSistemaVenta.setIconTextGap(20);
		lbltxtSistemaVenta.setHorizontalAlignment(SwingConstants.CENTER);
		lbltxtSistemaVenta.setForeground(Color.WHITE);
		lbltxtSistemaVenta.setFont(new Font("Consolas", Font.PLAIN, 20));
		lbltxtSistemaVenta.setBackground(Color.BLACK);
		lbltxtSistemaVenta.setBounds(0, 126, 329, 22);
		panelMenu.add(lbltxtSistemaVenta);

		lblTituloQuesos = new JLabel("QUESOS");
		lblTituloQuesos.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloQuesos.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/icons8_cheese_36px.png")));
		lblTituloQuesos.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblTituloQuesos.setOpaque(true);
		lblTituloQuesos.setIconTextGap(10);
		lblTituloQuesos.setForeground(Color.WHITE);
		lblTituloQuesos.setFont(new Font("Consolas", Font.BOLD, 20));
		lblTituloQuesos.setBackground(new Color(8, 18, 30));
		lblTituloQuesos.setBounds(12, 230, 304, 37);
		panelMenu.add(lblTituloQuesos);

		btnAgregar = new JButton("AGREGAR");
		btnAgregar.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/icons8_add_36px_1.png")));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBgHome.setVisible(false);
				panelAddClient.setVisible(false);
				panelCheeses.setVisible(false);
				panelAddCheese.setVisible(true);
				panelListFacturas.setVisible(false);
			}
		});
		btnAgregar.setIconTextGap(30);
		btnAgregar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAgregar.setHorizontalAlignment(SwingConstants.LEADING);
		btnAgregar.setForeground(new Color(255, 255, 240));
		btnAgregar.setFont(new Font("Consolas", Font.BOLD, 22));
		btnAgregar.setBorder(null);
		btnAgregar.setBackground(new Color(4, 10, 20));
		btnAgregar.setBounds(12, 280, 307, 37);
		panelMenu.add(btnAgregar);

		separator_3 = new JSeparator();
		separator_3.setOpaque(true);
		separator_3.setBorder(null);
		separator_3.setBackground(Color.WHITE);
		separator_3.setBounds(12, 185, 305, 2);
		panelMenu.add(separator_3);

		lblClientes = new JLabel("CLIENTES");
		lblClientes.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/icons8_client_management_36px.png")));
		lblClientes.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblClientes.setOpaque(true);
		lblClientes.setIconTextGap(10);
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setForeground(Color.WHITE);
		lblClientes.setFont(new Font("Consolas", Font.BOLD, 20));
		lblClientes.setBackground(new Color(8, 18, 30));
		lblClientes.setBounds(12, 330, 304, 37);
		panelMenu.add(lblClientes);

		button = new JButton("AGREGAR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBgHome.setVisible(false);
				panelAddCheese.setVisible(false);
				panelFacturacion.setVisible(false);
				panelCheeses.setVisible(false);
				panelAddClient.setVisible(true);
			//	panelListFacturas.setVisible(false);
			
				btnRegistrarClient.setEnabled(false);
				btnCancelarClient.setEnabled(false);
			}
		});
		button.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/icons8_add_36px_1.png")));
		button.setIconTextGap(30);
		button.setHorizontalTextPosition(SwingConstants.RIGHT);
		button.setHorizontalAlignment(SwingConstants.LEADING);
		button.setForeground(new Color(255, 255, 240));
		button.setFont(new Font("Consolas", Font.BOLD, 22));
		button.setBorder(null);
		button.setBackground(new Color(4, 10, 20));
		button.setBounds(12, 380, 307, 37);
		panelMenu.add(button);

		button_1 = new JButton("LISTAR");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTableFactura();
				panelListFacturas.setVisible(true);
				panelBgHome.setVisible(false);
				panelAddCheese.setVisible(false);
				panelFacturacion.setVisible(false);
				panelCheeses.setVisible(false);
				panelAddClient.setVisible(false);
			}
		});
		button_1.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/icons8_checklist_36px_1.png")));
		button_1.setIconTextGap(30);
		button_1.setHorizontalTextPosition(SwingConstants.RIGHT);
		button_1.setHorizontalAlignment(SwingConstants.LEADING);
		button_1.setForeground(new Color(255, 255, 240));
		button_1.setFont(new Font("Consolas", Font.BOLD, 22));
		button_1.setBorder(null);
		button_1.setBackground(new Color(4, 10, 20));
		button_1.setBounds(12, 480, 307, 37);
		panelMenu.add(button_1);

		lblFacturas = new JLabel("FACTURAS");
		lblFacturas.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/icons8_estimate_36px.png")));
		lblFacturas.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblFacturas.setOpaque(true);
		lblFacturas.setIconTextGap(10);
		lblFacturas.setHorizontalAlignment(SwingConstants.CENTER);
		lblFacturas.setForeground(Color.WHITE);
		lblFacturas.setFont(new Font("Consolas", Font.BOLD, 20));
		lblFacturas.setBackground(new Color(8, 18, 30));
		lblFacturas.setBounds(12, 430, 304, 37);
		panelMenu.add(lblFacturas);
		
		label_6 = new JLabel("Versi\u00F3n beta: 1.0");
		label_6.setVerticalTextPosition(SwingConstants.BOTTOM);
		label_6.setToolTipText("Desarrollador: Anthony Sakamoto");
		label_6.setIconTextGap(20);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Consolas", Font.PLAIN, 16));
		label_6.setBackground(Color.BLACK);
		label_6.setBounds(0, 626, 329, 22);
		panelMenu.add(label_6);
		
		lblMenuDeslizante = new JLabel("Menu deslizante.");
		lblMenuDeslizante.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblMenuDeslizante.setToolTipText("Desarrollador: Anthony Sakamoto");
		lblMenuDeslizante.setIconTextGap(20);
		lblMenuDeslizante.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuDeslizante.setForeground(Color.WHITE);
		lblMenuDeslizante.setFont(new Font("Consolas", Font.PLAIN, 16));
		lblMenuDeslizante.setBackground(Color.BLACK);
		lblMenuDeslizante.setBounds(0, 648, 329, 22);
		panelMenu.add(lblMenuDeslizante);

		panelCart = new JPanel();
		panelCart.setVisible(false);
		panelCart.setBounds(10, 248, 308, 365);
		contentPane.add(panelCart);
		panelCart.setLayout(null);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 13, 284, 255);
		panelCart.add(scrollPane_1);

		listCart = new JList<String>();
		listCart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (!listCheeseProduct.isSelectionEmpty()) {
					btnAgregarCart.setEnabled(true);
					btnRemover.setEnabled(true);
					btnComprarCheese.setEnabled(true);
					txtcant.setVisible(true);
					lblCant.setVisible(true);				
				}
				
				
			}
		});
		scrollPane_1.setViewportView(listCart);

		label = new JLabel("");
		label.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/icons8_shopping_cart_loaded_60px.png")));
		label.setToolTipText("Sistema de ventas de queso.");
		label.setBounds(122, 129, 80, 73);
		contentPane.add(label);

		lblShoppingCart = new JLabel("Shopping cart");
		lblShoppingCart.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblShoppingCart.setToolTipText("Desarrollador: Anthony Sakamoto");
		lblShoppingCart.setIconTextGap(20);
		lblShoppingCart.setHorizontalAlignment(SwingConstants.CENTER);
		lblShoppingCart.setForeground(Color.BLACK);
		lblShoppingCart.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblShoppingCart.setBackground(Color.BLACK);
		lblShoppingCart.setBounds(0, 215, 329, 22);
		contentPane.add(lblShoppingCart);

		lblSub = new JLabel("Sub-Total:");
		lblSub.setEnabled(false);
		lblSub.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSub.setHorizontalAlignment(SwingConstants.LEFT);
		lblSub.setForeground(Color.BLACK);
		lblSub.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblSub.setBounds(10, 659, 100, 31);
		contentPane.add(lblSub);

		txtSubtotal = new JFormattedTextField();
		txtSubtotal.setEditable(false);
		txtSubtotal.setEnabled(false);
		txtSubtotal.setBounds(122, 659, 196, 31);
		contentPane.add(txtSubtotal);

		loadListCheeseProduct();
		loadListClients();
		loadTableFactura();

	}

	/* Metodos */

	private void loadListClients() {

		DefaultListModel<String> listModelClient= new DefaultListModel<String>();
		listModelClient.add(0, "CEDULA"+ "      "+"NOMBRE COMPLETO"+"      "+"DIRECCION."+"     "+"TELEFONO"+"     "+"CREDITOS");

		for (int i = 0; i < myCompany.getListClient().size(); i++) {
			listModelClient.addElement(myCompany.getListClient().get(i).getId() + "   "+ myCompany.getListClient().get(i).getName() + "   " + myCompany.getListClient().get(i).getAddress() + "   "+ myCompany.getListClient().get(i).getTelephone() + "   " + myCompany.getListClient().get(i).getCredito());
		}
		listClients.setModel(listModelClient);
	}

	private void cleanAddCheese() {
		txtCode.setText("");
		txtPriceBase.setText("");
		txtPriceUnit.setText("");
		txtAmountCheese.setValue(Integer.parseInt("1"));
		txtLongitudC.setText("");
		txtLongitudHueco.setText("");
		txtRadio.setText("");
		txtRadioC.setText("");
		txtRadioExt.setText("");
		txtRadioInter.setText("");
	}

	private void cleanAddClient() {
		txtID.setText("");
		txtName.setText("");
		txtAddress.setText("");
		txtTelephoneF.setText("");
		txtCredito.setText("");

	}

	private void cleanAddClientCF() {
		txtIdCF_1.setText("");
		txtNameCF.setText("");
		txtAddressCF.setText("");
		txtTelephoneF.setText("");
		txtCreditoCF.setText("");

	}


	private void loadListCheeseProduct() {

		DefaultListModel<String> listModelCheese = new DefaultListModel<String>();
		listModelCheese.add(0, "CODIGO"+ "      "+"TIPO"+"      "+"CANT."+"     "+"PRECIO");

		for (int i = 0; i < myCompany.getListCheese().size(); i++) {
			listModelCheese.addElement(myCompany.getListCheese().get(i).getCodigo() + "   "+ myCompany.typeCheese(myCompany.getListCheese().get(i)) + "   " + myCompany.getListCheese().get(i).getCantidad() + "   "+ myCompany.getListCheese().get(i).priceCheese());
		}
		listCheeseProduct.setModel(listModelCheese);
	}


	private void loadListProductCart() {

		DefaultListModel<String> listModelCart = new DefaultListModel<String>();

		for (int i = 0; i < listTemporalCheeseBuy.size(); i++) {
			listModelCart.addElement(listTemporalCheeseBuy.get(i).getCodigo() + "  ~  " + listTemporalCheeseBuy.get(i).getCantidad() + "  ~  " + listTemporalCheeseBuy.get(i).priceCheese());
		}
		listCart.setModel(listModelCart);
	}

	private void loadCheesesOnInvoice(ArrayList<Cheese> cheeseFactura) {
		DefaultListModel<String> listModelFact = new DefaultListModel<String>();

		for (int i = 0; i < cheeseFactura.size(); i++) {
			listModelFact.addElement(cheeseFactura.get(i).getCodigo() + "  ~  " + cheeseFactura.get(i).getCantidad() + "  ~  " +cheeseFactura.get(i).priceCheese());
		}
		listProductFact.setModel(listModelFact);

	}


	private Cheese cloneCheese(Cheese auxCheese) {

		Cheese cloneCheese = null;

		if (auxCheese instanceof SphereCheese) {
			cloneCheese = new SphereCheese(auxCheese.getCodigo(), auxCheese.getPrecioBase(), auxCheese.getPrecioUnit(), Integer.parseInt(txtcant.getText()), ((SphereCheese) auxCheese).getRadio());	
		}
		else if (auxCheese instanceof CylindriCheese) {
			cloneCheese = new CylindriCheese(auxCheese.getCodigo(), auxCheese.getPrecioBase(), auxCheese.getPrecioUnit(), Integer.parseInt(txtcant.getText()), ((CylindriCheese) auxCheese).getLongitud(),((CylindriCheese) auxCheese).getRadio());
		}
		else if (auxCheese instanceof HoleCheese) {
			cloneCheese = new HoleCheese(auxCheese.getCodigo(), auxCheese.getPrecioBase(), auxCheese.getPrecioUnit(), Integer.parseInt(txtcant.getText()), ((HoleCheese) auxCheese).getLongitud(), ((HoleCheese) auxCheese).getRadio(), ((HoleCheese) auxCheese).getRadioInterior());
		}

		return cloneCheese;
	}


	private Cheese searchTemporalCheeseByCode(String codeCheese) {
		Cheese auxCheese = null;
		boolean found = false;
		int i = 0;

		while (!found && i < listTemporalCheeseBuy.size()) {
			if(listTemporalCheeseBuy.get(i).getCodigo().equalsIgnoreCase(codeCheese)) {
				found = true;
				auxCheese = listTemporalCheeseBuy.get(i);
			}
			i++;
		}
		return auxCheese; //Retorna el queso del codigo encontrado.
	}

	public Boolean checkAmountCheeseCart(Cheese cloneCheese) {
		boolean found = false;
		boolean available = false;
		int i=0;

		while(!found && i < listTemporalCheeseBuy.size()) {
			if(listTemporalCheeseBuy.get(i).getCodigo().equalsIgnoreCase(cloneCheese.getCodigo())) {
				found = true;
				if((cloneCheese.getCantidad() >= Integer.parseInt(txtcant.getText())) && Integer.parseInt(txtcant.getText())!=0) {
					available = true;
				}
			}
			i++;
		}
		return available;
	}
	
	
	public void loadTableFactura() {
		model = (DefaultTableModel) tableFactura.getModel();
		model.setRowCount(0);
		column = new Object[model.getColumnCount()];

		for (int i = 0; i < myCompany.getListInvoice().size(); i++) {
			column[0] = myCompany.getListInvoice().get(i).getCodigo();
			column[1] = myCompany.getListInvoice().get(i).getClient().getId();
			column[2] = myCompany.getListInvoice().get(i).getPrecioTotal();
			
				model.addRow(column);
			}

	}
}
