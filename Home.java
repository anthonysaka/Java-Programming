package frontEnd;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backEnd.Almacen;
import backEnd.Empresa;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {
	
	private Empresa myCompany;

	private JPanel contentPaneBackground;
	private Dimension dimention;
	private JPanel panelMenuLeft;
	private JLabel lblLogoIcon;
	private JSeparator separator;
	private JLabel lblAlmacen;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JLabel lblProducto;
	private JLabel lblD;
	private JLabel lblVersinBeta;
	private JButton btnRegistrarAlmacen;
	private JButton btnListaDeAlmacenes;
	private JButton btnClose;
	private JButton btnRegistrarProducto;
	private JButton btnListaDeProductos;
	private JSeparator separator_3;
	private JLabel lblAdministrador;
	private JButton btnConsultas;
	private JButton btnDespachar;
	private JPanel panel;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Empresa company = new Empresa();
					Home frame = new Home(company);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home(Empresa company) {
		this.myCompany = company;
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1455, 740);
		dimention = super.getToolkit().getScreenSize();
		super.setSize(dimention.width, (dimention.height-50));
		setLocationRelativeTo(null);
		
		contentPaneBackground = new JPanel();
		contentPaneBackground.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				resetColor(btnConsultas);
				resetColor(btnDespachar);
				resetColor(btnRegistrarAlmacen);
				resetColor(btnListaDeAlmacenes);
				resetColor(btnRegistrarProducto);
				resetColor(btnListaDeProductos);
			}
		});
		contentPaneBackground.setBackground(Color.BLACK);
		contentPaneBackground.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneBackground);
		contentPaneBackground.setLayout(null);
		
		panelMenuLeft = new JPanel();
		panelMenuLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				resetColor(btnConsultas);
				resetColor(btnDespachar);
				resetColor(btnRegistrarAlmacen);
				resetColor(btnListaDeAlmacenes);
				resetColor(btnRegistrarProducto);
				resetColor(btnListaDeProductos);
			}
				
		});
		panelMenuLeft.setBackground(new Color(2,5,5,50));
		panelMenuLeft.setBounds(0, 0, 490, 1030);
		contentPaneBackground.add(panelMenuLeft);
		panelMenuLeft.setLayout(null);
		
		lblLogoIcon = new JLabel();
		lblLogoIcon.setToolTipText("Sistema de almacen.");
		lblLogoIcon.setBounds(156, 54, 171, 161);
		panelMenuLeft.add(lblLogoIcon);
		/** to adjust image at size of JLabel **/
		ImageIcon logo = new ImageIcon(getClass().getResource("/imagenes/logoDistribuidora.png"));
		Icon iconLogo = new ImageIcon(logo.getImage().getScaledInstance(lblLogoIcon.getWidth(), lblLogoIcon.getHeight(), Image.SCALE_SMOOTH));
		lblLogoIcon.setIcon(iconLogo);
		
		separator = new JSeparator();
		separator.setBounds(483, 13, 4, 1004);
		panelMenuLeft.add(separator);
		separator.setOpaque(true);
		separator.setBorder(null);
		separator.setBackground(Color.WHITE);
		
		separator_1 = new JSeparator();
		separator_1.setOpaque(true);
		separator_1.setBorder(null);
		separator_1.setBackground(new Color(255, 255, 255));
		separator_1.setBounds(12, 585, 459, 6);
		panelMenuLeft.add(separator_1);
		
		lblAlmacen = new JLabel("ALMACEN");
		lblAlmacen.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblAlmacen.setIconTextGap(20);
		lblAlmacen.setIcon(new ImageIcon(Home.class.getResource("/imagenes/icons8_warehouse_1_48px_1.png")));
		lblAlmacen.setOpaque(true);
		lblAlmacen.setForeground(Color.WHITE);
		lblAlmacen.setFont(new Font("Consolas", Font.BOLD, 26));
		lblAlmacen.setBackground(new Color(0, 0, 0));
		lblAlmacen.setBounds(12, 532, 459, 59);
		panelMenuLeft.add(lblAlmacen);
		
		separator_2 = new JSeparator();
		separator_2.setOpaque(true);
		separator_2.setBorder(null);
		separator_2.setBackground(Color.WHITE);
		separator_2.setBounds(12, 827, 459, 6);
		panelMenuLeft.add(separator_2);
		
		lblProducto = new JLabel("PRODUCTO");
		lblProducto.setIcon(new ImageIcon(Home.class.getResource("/imagenes/icons8_bulleted_list_48px.png")));
		lblProducto.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblProducto.setOpaque(true);
		lblProducto.setIconTextGap(20);
		lblProducto.setForeground(Color.WHITE);
		lblProducto.setFont(new Font("Consolas", Font.BOLD, 26));
		lblProducto.setBackground(new Color(0, 0, 0));
		lblProducto.setBounds(12, 774, 459, 59);
		panelMenuLeft.add(lblProducto);
		
		lblVersinBeta = new JLabel("Versi\u00F3n beta: 1.0");
		lblVersinBeta.setToolTipText("Desarrollador: Anthony Sakamoto");
		lblVersinBeta.setHorizontalAlignment(SwingConstants.CENTER);
		lblVersinBeta.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblVersinBeta.setIconTextGap(20);
		lblVersinBeta.setForeground(Color.WHITE);
		lblVersinBeta.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblVersinBeta.setBackground(new Color(0, 0, 0));
		lblVersinBeta.setBounds(12, 228, 459, 59);
		panelMenuLeft.add(lblVersinBeta);
		
		btnRegistrarAlmacen = new JButton("Registrar almacen");
		btnRegistrarAlmacen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddWarehouse addAlmacen = new AddWarehouse(myCompany,null);
				btnClose.setEnabled(false);
				addAlmacen.setModal(true);
				addAlmacen.setVisible(true);
				btnClose.setEnabled(true);
			}
		});
		btnRegistrarAlmacen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setColor(btnRegistrarAlmacen);
				resetColor(btnConsultas);
				resetColor(btnDespachar);
				resetColor(btnListaDeAlmacenes);
				resetColor(btnRegistrarProducto);
				resetColor(btnListaDeProductos);

				
			}
		});
		btnRegistrarAlmacen.setHorizontalAlignment(SwingConstants.LEADING);
		btnRegistrarAlmacen.setIcon(new ImageIcon(Home.class.getResource("/imagenes/icons8_add_48px_3.png")));
		btnRegistrarAlmacen.setIconTextGap(30);
		btnRegistrarAlmacen.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnRegistrarAlmacen.setForeground(new Color(255, 255, 240));
		btnRegistrarAlmacen.setFont(new Font("Consolas", Font.BOLD, 20));
		btnRegistrarAlmacen.setBorder(null);
		btnRegistrarAlmacen.setBackground(Color.BLACK);
		btnRegistrarAlmacen.setBounds(12, 619, 459, 53);
		panelMenuLeft.add(btnRegistrarAlmacen);
		
		btnListaDeAlmacenes = new JButton("Lista de almacenes");
		btnListaDeAlmacenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListWarehouse listAlmacen = new ListWarehouse(myCompany);
				btnClose.setEnabled(false);
				listAlmacen.setModal(true);
				listAlmacen.setVisible(true);
				btnClose.setEnabled(true);
			}
		});
		btnListaDeAlmacenes.setIcon(new ImageIcon(Home.class.getResource("/imagenes/icons8_list_48px.png")));
		btnListaDeAlmacenes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setColor(btnListaDeAlmacenes);
				resetColor(btnConsultas);
				resetColor(btnDespachar);
				resetColor(btnRegistrarAlmacen);
				resetColor(btnRegistrarProducto);
				resetColor(btnListaDeProductos);
			}
		});
		btnListaDeAlmacenes.setHorizontalAlignment(SwingConstants.LEADING);
		btnListaDeAlmacenes.setIconTextGap(30);
		btnListaDeAlmacenes.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnListaDeAlmacenes.setForeground(new Color(255, 255, 240));
		btnListaDeAlmacenes.setFont(new Font("Consolas", Font.BOLD, 20));
		btnListaDeAlmacenes.setBorder(null);
		btnListaDeAlmacenes.setBackground(Color.BLACK);
		btnListaDeAlmacenes.setBounds(12, 685, 459, 53);
		panelMenuLeft.add(btnListaDeAlmacenes);
		
		btnRegistrarProducto = new JButton("Registrar producto");
		btnRegistrarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddProduct producAdd = new AddProduct(myCompany, null);
				btnClose.setEnabled(false);
				producAdd.setModal(true);
				producAdd.setVisible(true);
				btnClose.setEnabled(true);
			}
		});
		btnRegistrarProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setColor(btnRegistrarProducto);
				resetColor(btnConsultas);
				resetColor(btnDespachar);
				resetColor(btnRegistrarAlmacen);
				resetColor(btnListaDeAlmacenes);
				resetColor(btnListaDeProductos);
				
			}
		});
		btnRegistrarProducto.setIcon(new ImageIcon(Home.class.getResource("/imagenes/icons8_add_48px_3.png")));
		btnRegistrarProducto.setIconTextGap(30);
		btnRegistrarProducto.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnRegistrarProducto.setHorizontalAlignment(SwingConstants.LEADING);
		btnRegistrarProducto.setForeground(new Color(255, 255, 240));
		btnRegistrarProducto.setFont(new Font("Consolas", Font.BOLD, 20));
		btnRegistrarProducto.setBorder(null);
		btnRegistrarProducto.setBackground(Color.BLACK);
		btnRegistrarProducto.setBounds(12, 863, 459, 53);
		panelMenuLeft.add(btnRegistrarProducto);
		
		btnListaDeProductos = new JButton("Lista de productos");
		btnListaDeProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListProduct listProducto = new ListProduct(myCompany);
				btnClose.setEnabled(false);
				listProducto.setModal(true);
				listProducto.setVisible(true);
				btnClose.setEnabled(true);
			}
		});
		btnListaDeProductos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setColor(btnListaDeProductos);
				resetColor(btnDespachar);
				resetColor(btnDespachar);
				resetColor(btnRegistrarAlmacen);
				resetColor(btnListaDeAlmacenes);
				resetColor(btnRegistrarProducto);
			}
		});
		btnListaDeProductos.setIcon(new ImageIcon(Home.class.getResource("/imagenes/icons8_list_48px.png")));
		btnListaDeProductos.setIconTextGap(30);
		btnListaDeProductos.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnListaDeProductos.setHorizontalAlignment(SwingConstants.LEADING);
		btnListaDeProductos.setForeground(new Color(255, 255, 240));
		btnListaDeProductos.setFont(new Font("Consolas", Font.BOLD, 20));
		btnListaDeProductos.setBorder(null);
		btnListaDeProductos.setBackground(Color.BLACK);
		btnListaDeProductos.setBounds(12, 929, 459, 53);
		panelMenuLeft.add(btnListaDeProductos);
		
		separator_3 = new JSeparator();
		separator_3.setOpaque(true);
		separator_3.setBorder(null);
		separator_3.setBackground(Color.WHITE);
		separator_3.setBounds(12, 353, 459, 6);
		panelMenuLeft.add(separator_3);
		
		lblAdministrador = new JLabel("ADMINISTRADOR");
		lblAdministrador.setIcon(new ImageIcon(Home.class.getResource("/imagenes/icons8_manager_48px_1.png")));
		lblAdministrador.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblAdministrador.setOpaque(true);
		lblAdministrador.setIconTextGap(20);
		lblAdministrador.setForeground(Color.WHITE);
		lblAdministrador.setFont(new Font("Consolas", Font.BOLD, 26));
		lblAdministrador.setBackground(Color.BLACK);
		lblAdministrador.setBounds(12, 300, 459, 59);
		panelMenuLeft.add(lblAdministrador);
		
		btnConsultas = new JButton("Consultas");
		btnConsultas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setColor(btnConsultas);
				resetColor(btnDespachar);
				resetColor(btnRegistrarAlmacen);
				resetColor(btnListaDeAlmacenes);
				resetColor(btnRegistrarProducto);
				resetColor(btnListaDeProductos);
			}
		});
		btnConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultAdministrador admin = new ConsultAdministrador(myCompany);
				btnClose.setEnabled(false);
				admin.setModal(true);
				admin.setVisible(true);
				btnClose.setEnabled(true);
			}
		});
		btnConsultas.setIcon(new ImageIcon(Home.class.getResource("/imagenes/icons8_search_property_48px.png")));
		btnConsultas.setIconTextGap(30);
		btnConsultas.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnConsultas.setHorizontalAlignment(SwingConstants.LEADING);
		btnConsultas.setForeground(new Color(255, 255, 240));
		btnConsultas.setFont(new Font("Consolas", Font.BOLD, 20));
		btnConsultas.setBorder(null);
		btnConsultas.setBackground(Color.BLACK);
		btnConsultas.setBounds(12, 387, 459, 53);
		panelMenuLeft.add(btnConsultas);
		
		btnDespachar = new JButton("Despachar");
		btnDespachar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewDispatch despacho = new ViewDispatch(myCompany);
				btnClose.setEnabled(false);
				despacho.setModal(true);
				despacho.setVisible(true);
				btnClose.setEnabled(true);
			}
		});
		btnDespachar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setColor(btnDespachar);
				resetColor(btnConsultas);
				resetColor(btnRegistrarAlmacen);
				resetColor(btnListaDeAlmacenes);
				resetColor(btnRegistrarProducto);
				resetColor(btnListaDeProductos);
			}
		});
		btnDespachar.setIcon(new ImageIcon(Home.class.getResource("/imagenes/icons8_in_transit_48px.png")));
		btnDespachar.setIconTextGap(30);
		btnDespachar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnDespachar.setHorizontalAlignment(SwingConstants.LEADING);
		btnDespachar.setForeground(new Color(255, 255, 240));
		btnDespachar.setFont(new Font("Consolas", Font.BOLD, 20));
		btnDespachar.setBorder(null);
		btnDespachar.setBackground(Color.BLACK);
		btnDespachar.setBounds(12, 453, 459, 53);
		panelMenuLeft.add(btnDespachar);

		
		lblD = new JLabel("");
		lblD.setToolTipText("Ventana principal.");
		lblD.setIcon(new ImageIcon(Home.class.getResource("/imagenes/fondoDistribuidora.png")));
		lblD.setBounds(844, 183, 814, 658);
		contentPaneBackground.add(lblD);
		
		btnClose = new JButton("");
		btnClose.setPressedIcon(new ImageIcon(Home.class.getResource("/imagenes/icons8_close_sign_48px.png")));
		btnClose.setRolloverIcon(new ImageIcon(Home.class.getResource("/imagenes/icons8_close_sign_48px.png")));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setIcon(new ImageIcon(Home.class.getResource("/imagenes/icons8_close_window_48px_1.png")));
		btnClose.setPreferredSize(new Dimension(100, 30));
		btnClose.setHideActionText(true);
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Consolas", Font.BOLD, 20));
		btnClose.setBorder(null);
		btnClose.setBackground(Color.BLACK);
		btnClose.setActionCommand("Cancel");
		btnClose.setBounds(1849, 13, 59, 48);
		contentPaneBackground.add(btnClose);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		contentPaneBackground.add(panel);
		/*********************************/		
	}
	
	private void setColor (JButton button) {
		button.setBackground(new Color(213,30,30));
	}
	
	private void resetColor (JButton button) {
		button.setBackground(new Color(0,0,0));
	}
}
