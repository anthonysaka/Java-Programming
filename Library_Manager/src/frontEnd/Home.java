package frontEnd;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backEnd.Article;
import backEnd.Book;
import backEnd.Library;
import backEnd.Magazine;
import backEnd.Publication;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;

import com.sun.javafx.scene.layout.region.Margins.Converter;

import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.CardLayout;
import javax.swing.table.DefaultTableModel;

public class Home extends JFrame {


	private JPanel contentPane;
	private JPanel panelLeft;
	private JLabel lblPanelLogo;
	private JLabel lblSistemaBiblioteca;
	private JButton btnClose;
	private JLabel lblConsultasTitle;
	private JSeparator separator;
	private JLabel lblPublicacionesTitle;
	private JSeparator separator_1;
	private JLabel lblPrestamosTitle;
	private JSeparator separator_2;
	private JButton btnAddPubli;
	private JPanel panel;
	private JPanel panelAddPublication;
	private JTextField txtIdPubli;
	private JLabel lblIDPublication;
	private JLabel lblTituloPublication;
	private JLabel lblMateriaPublication;
	private JLabel lblCantPublicacion;
	private JTextField txtTituloPubli;
	private JPanel panelPubli;
	private JComboBox cbxMateriaPubli;
	private JSpinner spnCantPubli;
	private JPanel panelAddTipo;
	private JLabel lblAutor;
	private JLabel lblEditorial;
	private JTextField txtAutor;
	private JSpinner spnYear;
	private JButton btnLibro;
	private JButton btnArticulo;
	private JButton btnRevista;
	private JLabel lblYear;
	private JLabel lblNmero;
	private JSpinner spnNumero;
	private JTextField txtEditorial;
	private JLabel label_1;
	private JButton btnInsertar;
	private JButton btnCancelar;
	private JButton btnMinimize;
	
	private static int typePublication = 0 ; // 1 - Book 2 - Article 3 - Magazine
	private JButton btnListaDePublicaciones;
	private JPanel panelListPublicaciones;
	private JScrollPane scrollPane;

	private Library myLibrary;
	private JComboBox cbxTipoVer;
	private JLabel lblTipoDePublicaciones;
	
	private JTable tablePublicaciones;
	private static DefaultTableModel model;
	private static Object[] column;
	private JPanel panel_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Library library = new Library();
					Home frame = new Home(library);
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
	public Home(Library library ) {
		setBackground(new Color(169, 169, 169));
		this.myLibrary = library;
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1455, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelLeft = new JPanel();
		panelLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				resetColor(btnAddPubli);
			}
		});
		panelLeft.setBounds(0, 0, 329, 750);
		panelLeft.setBackground(new Color(4, 10, 15));
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);
		
		btnAddPubli = new JButton("Insertar publicaci\u00F3n");
		btnAddPubli.setHorizontalAlignment(SwingConstants.LEADING);
		btnAddPubli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAddPublication.setVisible(true);
				panelPubli.setVisible(true);
			//	panelListPublicaciones.setVisible(false);
			}
		});
		btnAddPubli.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setColor(btnAddPubli);
			}
		});
		btnAddPubli.setIcon(new ImageIcon(Home.class.getResource("/imagenes/icons8_books_36px_1.png")));
		btnAddPubli.setIconTextGap(30);
		btnAddPubli.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAddPubli.setForeground(new Color(255, 255, 240));
		btnAddPubli.setFont(new Font("Consolas", Font.BOLD, 17));
		btnAddPubli.setBorder(null);
		btnAddPubli.setBackground(new Color(4,10,15));
		btnAddPubli.setBounds(10, 451, 307, 37);
		panelLeft.add(btnAddPubli);
		

		lblPanelLogo = new JLabel("New label");
		lblPanelLogo.setToolTipText("Sistema de Biblioteca.");
		lblPanelLogo.setBounds(104, 26, 120, 116);
		panelLeft.add(lblPanelLogo);
		/** to adjust image at size of JLabel **/
		ImageIcon logo = new ImageIcon(getClass().getResource("/imagenes/icons8_books_96px.png"));
		Icon iconLogo = new ImageIcon(logo.getImage().getScaledInstance(lblPanelLogo.getWidth(), lblPanelLogo.getHeight(), Image.SCALE_SMOOTH));
		lblPanelLogo.setIcon(iconLogo);
		
		lblSistemaBiblioteca = new JLabel("Sistema Biblioteca");
		lblSistemaBiblioteca.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblSistemaBiblioteca.setToolTipText("Desarrollador: Anthony Sakamoto");
		lblSistemaBiblioteca.setIconTextGap(20);
		lblSistemaBiblioteca.setHorizontalAlignment(SwingConstants.CENTER);
		lblSistemaBiblioteca.setForeground(Color.WHITE);
		lblSistemaBiblioteca.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblSistemaBiblioteca.setBackground(Color.BLACK);
		lblSistemaBiblioteca.setBounds(0, 155, 329, 22);
		panelLeft.add(lblSistemaBiblioteca);
		
		separator_1 = new JSeparator();
		separator_1.setOpaque(true);
		separator_1.setBorder(null);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(12, 434, 305, 4);
		panelLeft.add(separator_1);
		
		separator = new JSeparator();
		separator.setOpaque(true);
		separator.setBorder(null);
		separator.setBackground(Color.WHITE);
		separator.setBounds(12, 263, 305, 4);
		panelLeft.add(separator);
		
		separator_2 = new JSeparator();
		separator_2.setOpaque(true);
		separator_2.setBorder(null);
		separator_2.setBackground(Color.WHITE);
		separator_2.setBounds(12, 606, 305, 4);
		panelLeft.add(separator_2);
		
		lblPrestamosTitle = new JLabel("PRESTAMOS");
		lblPrestamosTitle.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblPrestamosTitle.setOpaque(true);
		lblPrestamosTitle.setIconTextGap(20);
		lblPrestamosTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrestamosTitle.setForeground(Color.WHITE);
		lblPrestamosTitle.setFont(new Font("Consolas", Font.BOLD, 20));
		lblPrestamosTitle.setBackground(new Color(4, 10, 15));
		lblPrestamosTitle.setBounds(0, 575, 329, 37);
		panelLeft.add(lblPrestamosTitle);
		
		lblConsultasTitle = new JLabel("CONSULTAS");
		lblConsultasTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultasTitle.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblConsultasTitle.setOpaque(true);
		lblConsultasTitle.setIconTextGap(20);
		lblConsultasTitle.setForeground(Color.WHITE);
		lblConsultasTitle.setFont(new Font("Consolas", Font.BOLD, 20));
		lblConsultasTitle.setBackground(new Color (4,10,15));
		lblConsultasTitle.setBounds(0, 232, 329, 37);
		panelLeft.add(lblConsultasTitle);
		
		lblPublicacionesTitle = new JLabel("PUBLICACIONES");
		lblPublicacionesTitle.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblPublicacionesTitle.setOpaque(true);
		lblPublicacionesTitle.setIconTextGap(20);
		lblPublicacionesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPublicacionesTitle.setForeground(Color.WHITE);
		lblPublicacionesTitle.setFont(new Font("Consolas", Font.BOLD, 20));
		lblPublicacionesTitle.setBackground(new Color(4, 10, 15));
		lblPublicacionesTitle.setBounds(0, 403, 329, 37);
		panelLeft.add(lblPublicacionesTitle);
		
		label_1 = new JLabel("Versi\u00F3n beta: 1.0");
		label_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		label_1.setToolTipText("Desarrollador: Anthony Sakamoto");
		label_1.setIconTextGap(20);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Consolas", Font.PLAIN, 16));
		label_1.setBackground(Color.BLACK);
		label_1.setBounds(0, 179, 329, 22);
		panelLeft.add(label_1);
		
		btnListaDePublicaciones = new JButton("Lista de publicaciones");
		btnListaDePublicaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAddPublication.setVisible(true);
				panelPubli.setVisible(false);
				panelListPublicaciones.setVisible(true);
			}
		});
		btnListaDePublicaciones.setHorizontalAlignment(SwingConstants.LEADING);
		btnListaDePublicaciones.setIcon(new ImageIcon(Home.class.getResource("/imagenes/icons8_list_36px.png")));
		btnListaDePublicaciones.setIconTextGap(30);
		btnListaDePublicaciones.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnListaDePublicaciones.setForeground(new Color(255, 255, 240));
		btnListaDePublicaciones.setFont(new Font("Consolas", Font.BOLD, 17));
		btnListaDePublicaciones.setBorder(null);
		btnListaDePublicaciones.setBackground(new Color(4, 10, 15));
		btnListaDePublicaciones.setBounds(10, 501, 307, 37);
		panelLeft.add(btnListaDePublicaciones);
		
		btnClose = new JButton("");
		btnClose.setIcon(new ImageIcon(Home.class.getResource("/imagenes/icons8_close_window_24px_1.png")));
		btnClose.setPressedIcon(new ImageIcon(Home.class.getResource("/imagenes/icons8_close_sign_24px.png")));
		btnClose.setRolloverIcon(new ImageIcon(Home.class.getResource("/imagenes/icons8_close_sign_24px.png")));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setPreferredSize(new Dimension(100, 30));
		btnClose.setHideActionText(true);
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Consolas", Font.BOLD, 20));
		btnClose.setBorder(null);
		btnClose.setBackground(new Color(255, 255, 255));
		btnClose.setActionCommand("Cancel");
		btnClose.setBounds(1429, 0, 26, 30);
		contentPane.setBounds(1419, 0, 36, 30);
		contentPane.add(btnClose);
		
		panelAddPublication = new JPanel();
		panelAddPublication.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				resetColor(btnArticulo);
				resetColor(btnLibro);
				resetColor(btnRevista);
			}
		});
		panelAddPublication.setBorder(null);
		panelAddPublication.setVisible(false);
		panelAddPublication.setBackground(new Color(255, 255, 255));
		panelAddPublication.setBounds(341, 43, 1102, 694);
		contentPane.add(panelAddPublication);
		panelAddPublication.setLayout(new CardLayout(0, 0));
		
		panelPubli = new JPanel();
		panelPubli.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n general", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelAddPublication.add(panelPubli, "name_1559519816924800");
		panelPubli.setLayout(null);
		
		txtIdPubli = new JTextField();
		txtIdPubli.setBounds(115, 45, 116, 30);
		panelPubli.add(txtIdPubli);
		txtIdPubli.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdPubli.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtIdPubli.setEnabled(false);
		txtIdPubli.setEditable(false);
		txtIdPubli.setDisabledTextColor(new Color(255, 69, 0));
		txtIdPubli.setColumns(10);
		
		lblIDPublication = new JLabel("ID:");
		lblIDPublication.setBounds(61, 44, 42, 31);
		panelPubli.add(lblIDPublication);
		lblIDPublication.setHorizontalAlignment(SwingConstants.LEFT);
		lblIDPublication.setForeground(new Color(0, 0, 0));
		lblIDPublication.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		
		lblTituloPublication = new JLabel("Titulo:");
		lblTituloPublication.setBounds(61, 131, 98, 31);
		panelPubli.add(lblTituloPublication);
		lblTituloPublication.setHorizontalAlignment(SwingConstants.LEFT);
		lblTituloPublication.setForeground(Color.BLACK);
		lblTituloPublication.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		
		lblMateriaPublication = new JLabel("Materia:");
		lblMateriaPublication.setBounds(495, 131, 98, 31);
		panelPubli.add(lblMateriaPublication);
		lblMateriaPublication.setHorizontalAlignment(SwingConstants.LEFT);
		lblMateriaPublication.setForeground(Color.BLACK);
		lblMateriaPublication.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		
		lblCantPublicacion = new JLabel("Cantidad de ejemplares:");
		lblCantPublicacion.setBounds(777, 131, 276, 31);
		panelPubli.add(lblCantPublicacion);
		lblCantPublicacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantPublicacion.setForeground(Color.BLACK);
		lblCantPublicacion.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		
		txtTituloPubli = new JTextField();
		txtTituloPubli.setBounds(61, 174, 356, 30);
		panelPubli.add(txtTituloPubli);
		txtTituloPubli.setHorizontalAlignment(SwingConstants.CENTER);
		txtTituloPubli.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtTituloPubli.setEnabled(true);
		txtTituloPubli.setEditable(true);
		txtTituloPubli.setDisabledTextColor(Color.BLACK);
		txtTituloPubli.setColumns(10);
		
		cbxMateriaPubli = new JComboBox();
		cbxMateriaPubli.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Programacion", "Fisica", "Calculo", "Informatica", "Literatura", "Quimica", "Redes informaticas", "Ciberseguridad"}));
		cbxMateriaPubli.setFont(new Font("Consolas", Font.ITALIC, 20));
		cbxMateriaPubli.setBounds(495, 172, 218, 30);
		panelPubli.add(cbxMateriaPubli);
		
		spnCantPubli = new JSpinner();
		spnCantPubli.setFont(new Font("Consolas", Font.ITALIC, 20));
		spnCantPubli.setBounds(918, 172, 135, 30);
		panelPubli.add(spnCantPubli);
		
		btnLibro = new JButton("Libro");
		btnLibro.setBounds(115, 270, 146, 30);
		panelPubli.add(btnLibro);
		btnLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setColor(btnLibro);
			}
		});
		btnLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typePublication = 1 ;
				
				btnLibro.setEnabled(false);
				btnArticulo.setEnabled(false);
				btnRevista.setEnabled(false);
				
				setColor(btnLibro);
				
				panelAddTipo.setVisible(true);
				panelAddTipo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n libro", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				lblAutor.setVisible(true);
				lblEditorial.setText("Editorial:");
				lblEditorial.setVisible(true);
				txtAutor.setVisible(true);
				txtEditorial.setVisible(true);
				
				lblNmero.setVisible(false);
				lblYear.setVisible(false);
				spnNumero.setVisible(false);
				spnYear.setVisible(false);
				
				btnInsertar.setVisible(true);
				btnCancelar.setVisible(true);
				
				txtIdPubli.setText("L-"+Library.generateIdBook);
				

				
				
				
			}
		});
		btnLibro.setIconTextGap(30);
		btnLibro.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnLibro.setForeground(new Color(255, 255, 240));
		btnLibro.setFont(new Font("Consolas", Font.BOLD, 17));
		btnLibro.setBorder(null);
		btnLibro.setBackground(new Color(4, 10, 15));
		
		btnArticulo = new JButton("Articulo");
		btnArticulo.setBounds(479, 270, 146, 30);
		panelPubli.add(btnArticulo);
		btnArticulo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setColor(btnArticulo);
			}
		});
		btnArticulo.setActionCommand("btnArticulo");
		btnArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				typePublication = 2;
				
				btnLibro.setEnabled(false);
				btnArticulo.setEnabled(false);
				btnRevista.setEnabled(false);
				
				setColor(btnArticulo);
				
				panelAddTipo.setVisible(true);
				panelAddTipo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n articulo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				lblAutor.setVisible(true);
				lblEditorial.setText("Arbitro:");
				lblEditorial.setVisible(true);
				txtAutor.setVisible(true);
				txtEditorial.setVisible(true);
				
				lblNmero.setVisible(false);
				lblYear.setVisible(false);
				spnNumero.setVisible(false);
				spnYear.setVisible(false);
				
				btnInsertar.setVisible(true);
				btnCancelar.setVisible(true);
				
				txtIdPubli.setText("A-"+Library.generateIdArticle);
			}
		});
		btnArticulo.setIconTextGap(30);
		btnArticulo.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnArticulo.setForeground(new Color(255, 255, 240));
		btnArticulo.setFont(new Font("Consolas", Font.BOLD, 17));
		btnArticulo.setBorder(null);
		btnArticulo.setBackground(new Color(4, 10, 15));
		
		btnRevista = new JButton("Revista");
		btnRevista.setBounds(845, 270, 146, 30);
		panelPubli.add(btnRevista);
		btnRevista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setColor(btnRevista);
			}
		});
		btnRevista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				typePublication = 3;
				
				btnLibro.setEnabled(false);
				btnArticulo.setEnabled(false);
				btnRevista.setEnabled(false);
				
				setColor(btnRevista);
				
				panelAddTipo.setVisible(true);
				panelAddTipo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n revista", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				lblAutor.setVisible(false);
				lblEditorial.setVisible(false);
				txtAutor.setVisible(false);
				txtEditorial.setVisible(false);
				
				lblNmero.setVisible(true);
				lblYear.setVisible(true);
				spnNumero.setVisible(true);
				spnYear.setVisible(true);
				
				btnInsertar.setVisible(true);
				btnCancelar.setVisible(true);
				
				txtIdPubli.setText("R-"+Library.generateIdMagazine);
				
				
			}
		});
		btnRevista.setIconTextGap(30);
		btnRevista.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnRevista.setForeground(new Color(255, 255, 240));
		btnRevista.setFont(new Font("Consolas", Font.BOLD, 17));
		btnRevista.setBorder(null);
		btnRevista.setBackground(new Color(4, 10, 15));
		
		panelAddTipo = new JPanel();
		panelAddTipo.setBounds(0, 376, 1102, 318);
		panelPubli.add(panelAddTipo);
		panelAddTipo.setVisible(false);
		panelAddTipo.setLayout(null);
		
		lblAutor = new JLabel("Autor:");
		lblAutor.setVisible(false);
		lblAutor.setHorizontalAlignment(SwingConstants.LEFT);
		lblAutor.setForeground(Color.BLACK);
		lblAutor.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblAutor.setBounds(509, 50, 98, 31);
		panelAddTipo.add(lblAutor);
		
		lblEditorial = new JLabel("Editorial:");
		lblEditorial.setVisible(false);
		lblEditorial.setHorizontalAlignment(SwingConstants.LEFT);
		lblEditorial.setForeground(Color.BLACK);
		lblEditorial.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblEditorial.setBounds(496, 137, 125, 31);
		panelAddTipo.add(lblEditorial);
		
		txtAutor = new JTextField();
		txtAutor.setVisible(false);
		txtAutor.setHorizontalAlignment(SwingConstants.CENTER);
		txtAutor.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtAutor.setEnabled(true);
		txtAutor.setEditable(true);
		txtAutor.setDisabledTextColor(Color.BLACK);
		txtAutor.setColumns(10);
		txtAutor.setBounds(360, 94, 396, 30);
		panelAddTipo.add(txtAutor);
		
		spnYear = new JSpinner();
		spnYear.setVisible(false);
		spnYear.setFont(new Font("Consolas", Font.ITALIC, 20));
		spnYear.setBounds(491, 181, 135, 30);
		panelAddTipo.add(spnYear);
		
		lblYear = new JLabel("A\u00F1o:");
		lblYear.setVisible(false);
		lblYear.setHorizontalAlignment(SwingConstants.LEFT);
		lblYear.setForeground(Color.BLACK);
		lblYear.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblYear.setBounds(509, 137, 98, 31);
		panelAddTipo.add(lblYear);
		
		lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNmero.setVisible(false);
		lblNmero.setHorizontalAlignment(SwingConstants.LEFT);
		lblNmero.setForeground(Color.BLACK);
		lblNmero.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
		lblNmero.setBounds(509, 50, 98, 31);
		panelAddTipo.add(lblNmero);
		
		spnNumero = new JSpinner();
		spnNumero.setVisible(false);
		spnNumero.setFont(new Font("Consolas", Font.ITALIC, 20));
		spnNumero.setBounds(491, 94, 135, 30);
		panelAddTipo.add(spnNumero);
		
		txtEditorial = new JTextField();
		txtEditorial.setVisible(false);
		txtEditorial.setHorizontalAlignment(SwingConstants.CENTER);
		txtEditorial.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 20));
		txtEditorial.setEnabled(true);
		txtEditorial.setEditable(true);
		txtEditorial.setDisabledTextColor(Color.BLACK);
		txtEditorial.setColumns(10);
		txtEditorial.setBounds(360, 181, 396, 30);
		panelAddTipo.add(txtEditorial);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(953, 262, 135, 43);
		panelAddTipo.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clean();
				btnArticulo.setEnabled(true);
				btnLibro.setEnabled(true);
				btnRevista.setEnabled(true);
				panelAddTipo.setVisible(false);
				
			}
		});
		btnCancelar.setRolloverIcon(new ImageIcon(Home.class.getResource("/imagenes/icons8_cancel_2_36px_7.png")));
		btnCancelar.setPressedIcon(new ImageIcon(Home.class.getResource("/imagenes/icons8_cancel_2_36px_7.png")));
		btnCancelar.setVisible(false);
		btnCancelar.setIcon(new ImageIcon(Home.class.getResource("/imagenes/icons8_cancel_36px_4.png")));
		btnCancelar.setIconTextGap(10);
		btnCancelar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCancelar.setForeground(new Color(0, 0, 0));
		btnCancelar.setFont(new Font("Consolas", Font.BOLD, 17));
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(new Color(192, 192, 192));
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.setBounds(806, 262, 135, 43);
		panelAddTipo.add(btnInsertar);
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtIdPubli.getText();
				String title = txtTituloPubli.getText();
				String autor = txtAutor.getText();
				String editorial = txtEditorial.getText();
				String materia = cbxMateriaPubli.getSelectedItem().toString();
				int cantEjemplares = Integer.parseInt(spnCantPubli.getValue().toString());
				int year = Integer.parseInt(spnYear.getValue().toString());
				int num = Integer.parseInt(spnNumero.getValue().toString());
				
				if (!title.equalsIgnoreCase("") && cbxMateriaPubli.getSelectedIndex() > 0 && cantEjemplares > 0) {
					if (typePublication == 1) {
						Book addBook = new Book(id, title, materia, cantEjemplares, autor, editorial);
						myLibrary.addPublication(addBook);
						
						JOptionPane.showMessageDialog(null, "Ingreso con exito!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);	
						System.out.println(myLibrary.getListPublication().get(0).getTitle());
						clean();
						panelAddTipo.setVisible(false);
						btnArticulo.setEnabled(true);
						btnLibro.setEnabled(true);
						btnRevista.setEnabled(true);
					}
					else if (typePublication == 2) { 
						String arbitro = editorial;
						Article addArticle = new Article(id, title, materia, cantEjemplares, arbitro, autor);
						myLibrary.addPublication(addArticle);
						JOptionPane.showMessageDialog(null, "Ingreso con exito!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);	
						System.out.println(myLibrary.getListPublication().get(0).getTitle());
						clean();
						panelAddTipo.setVisible(false);
						btnArticulo.setEnabled(true);
						btnLibro.setEnabled(true);
						btnRevista.setEnabled(true);
					}
					else if ( typePublication == 3) {
						Magazine addMagazine = new Magazine(id, title, materia, cantEjemplares, year, num);
						myLibrary.addPublication(addMagazine);
						JOptionPane.showMessageDialog(null, "Ingreso con exito!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);	
						System.out.println(myLibrary.getListPublication().get(0).getTitle());
						clean();
						panelAddTipo.setVisible(false);
						btnArticulo.setEnabled(true);
						btnLibro.setEnabled(true);
						btnRevista.setEnabled(true);
					}
						
				}
				else {
					JOptionPane.showMessageDialog(null, "Revise los campos!", "Aviso!", JOptionPane.INFORMATION_MESSAGE);	
					
				}
					
			}
		});
		btnInsertar.setRolloverIcon(new ImageIcon(Home.class.getResource("/imagenes/icons8_add_36px.png")));
		btnInsertar.setPressedIcon(new ImageIcon(Home.class.getResource("/imagenes/icons8_add_36px.png")));
		btnInsertar.setVisible(false);
		btnInsertar.setIcon(new ImageIcon(Home.class.getResource("/imagenes/icons8_add_book_36px.png")));
		btnInsertar.setIconTextGap(10);
		btnInsertar.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnInsertar.setForeground(new Color(0, 0, 0));
		btnInsertar.setFont(new Font("Consolas", Font.BOLD, 17));
		btnInsertar.setBorder(null);
		btnInsertar.setBackground(new Color(192, 192, 192));
		
		panel_1 = new JPanel();
		panel_1.setBounds(963, 55, 10, 10);
		panelPubli.add(panel_1);
		
//		panelListPublicaciones = new JPanel();
//		panelAddPublication.add(panelListPublicaciones, "name_1559529045801700");
//		panelListPublicaciones.setVisible(false);
//		panelListPublicaciones.setLayout(null);
//		
//		scrollPane = new JScrollPane();
//		scrollPane.setBounds(0, 77, 1102, 617);
//		panelListPublicaciones.add(scrollPane);
//		
//		tablePublicaciones = new JTable();
//		model = new DefaultTableModel();
//		
//		int selection = cbxTipoVer.getSelectedIndex();
//		
//		if (selection == 0) {
//			String [] header = {"ID", "Titulo", "Materia", "Ejemplares", "Estado"};
//			model.setColumnIdentifiers(header);
//			
//		}
//		else if (selection == 1) {
//			String [] header = {"ID", "Titulo", "Materia","Autor","Arbitro", "Ejemplares", "Estado"};
//			model.setColumnIdentifiers(header);	
//		}
//		else if (selection == 2) {
//			String [] header = {"ID", "Titulo", "Materia","Autor","Editorial", "Ejemplares", "Estado"};
//			model.setColumnIdentifiers(header);
//			
//		}
//		else if (selection == 3) {
//			String [] header = {"ID", "Titulo", "Materia","Numero","Año", "Ejemplares", "Estado"};
//			model.setColumnIdentifiers(header);
//			
//		}
//		tablePublicaciones.setModel(model);
//		
//		
//		tablePublicaciones.getColumnModel().getColumn(0).setResizable(false);
//		tablePublicaciones.getColumnModel().getColumn(2).setResizable(false);
//		tablePublicaciones.getColumnModel().getColumn(3).setResizable(false);
//		tablePublicaciones.getColumnModel().getColumn(4).setResizable(false);
//		scrollPane.setViewportView(tablePublicaciones);
//		
//		cbxTipoVer = new JComboBox();
//		cbxTipoVer.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Articulos", "Libros", "Revistas"}));
//		cbxTipoVer.setFont(new Font("Consolas", Font.ITALIC, 20));
//		cbxTipoVer.setBounds(288, 34, 218, 30);
//		panelListPublicaciones.add(cbxTipoVer);
//		
//		lblTipoDePublicaciones = new JLabel("Tipo de publicaciones:");
//		lblTipoDePublicaciones.setHorizontalAlignment(SwingConstants.LEFT);
//		lblTipoDePublicaciones.setForeground(Color.BLACK);
//		lblTipoDePublicaciones.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 22));
//		lblTipoDePublicaciones.setBounds(12, 33, 264, 31);
//		panelListPublicaciones.add(lblTipoDePublicaciones);
		
		btnMinimize = new JButton("");
		btnMinimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setExtendedState(ICONIFIED);
				
			}
		});
		btnMinimize.setIcon(new ImageIcon(Home.class.getResource("/imagenes/icons8_minimize_window_24px.png")));
		btnMinimize.setPreferredSize(new Dimension(100, 30));
		btnMinimize.setHideActionText(true);
		btnMinimize.setForeground(Color.WHITE);
		btnMinimize.setFont(new Font("Consolas", Font.BOLD, 20));
		btnMinimize.setBorder(null);
		btnMinimize.setBackground(Color.WHITE);
		btnMinimize.setActionCommand("Cancel");
		btnMinimize.setBounds(1401, 0, 26, 30);
		contentPane.add(btnMinimize);

		

		
	}
	
	private void setColor (JButton button) {
		button.setBackground(new Color(230,76,0));
	}
	
	private void resetColor (JButton button) {
		button.setBackground(new Color(4,10,15));
	}
	
	private void clean() {
		txtIdPubli.setText("");
		txtAutor.setText("");
		txtEditorial.setText("");
		txtTituloPubli.setText("");
		cbxMateriaPubli.setSelectedIndex(0);
		spnCantPubli.setValue(Integer.parseInt("0"));
		spnNumero.setValue(Integer.parseInt("0"));
		spnYear.setValue(Integer.parseInt("2012"));
	}
}
