package frontEnd;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import backEnd.Almacen;
import backEnd.Empresa;


public class ListWarehouse extends JDialog {

	private final JPanel contentPanel = new JPanel();



	private JPanel panelBg;
	private JButton btnModify;
	private JButton btnDelete;
	private static Empresa myCompany;
	private String codeAlma;
	private JScrollPane scrollPane;
	private static DefaultTableModel model;
	private static JTable tableWarehouse;
	private static Object[] column;


	/**
	 * Create the dialog.
	 */
	public ListWarehouse(Empresa company) {
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
				cancelButton.setRolloverIcon(new ImageIcon(ListWarehouse.class.getResource("/imagenes/icons8_cancel_2_48px.png")));
				cancelButton.setPressedIcon(new ImageIcon(ListWarehouse.class.getResource("/imagenes/icons8_cancel_2_48px.png")));
				cancelButton.setFont(new Font("Consolas", Font.BOLD, 20));
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setHideActionText(true);
				cancelButton.setBackground(new Color(0, 0, 0));
				cancelButton.setBorder(null);
				cancelButton.setIcon(new ImageIcon(ListWarehouse.class.getResource("/imagenes/icons8_cancel_48px.png")));
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

			btnModify = new JButton("Modify");
			btnModify.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnModify.setEnabled(false);
			btnModify.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Almacen auxAlmacen = myCompany.searchAlmacenByCode(codeAlma);
					AddWarehouse registrarAlma = new AddWarehouse(myCompany, auxAlmacen);
					registrarAlma.setModal(true);
					registrarAlma.setVisible(true);

				}
			});

			btnModify.setRolloverIcon(new ImageIcon(ListWarehouse.class.getResource("/imagenes/icons8_edit_property_48px.png")));
			btnModify.setPressedIcon(new ImageIcon(ListWarehouse.class.getResource("/imagenes/icons8_edit_property_48px.png")));
			btnModify.setIcon(new ImageIcon(ListWarehouse.class.getResource("/imagenes/icons8_edit_48px.png")));
			btnModify.setPreferredSize(new Dimension(100, 30));
			btnModify.setOpaque(false);
			btnModify.setForeground(Color.WHITE);
			btnModify.setFont(new Font("Consolas", Font.BOLD, 20));
			btnModify.setBorder(null);
			btnModify.setBackground(new Color(255, 250, 250, 80));
			btnModify.setActionCommand("OK");
			btnModify.setBounds(624, 8, 186, 48);
			buttonPane.add(btnModify);

			btnDelete = new JButton("Delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int option = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el almacen: / "+ codeAlma, "Eliminar - AVISO!", JOptionPane.WARNING_MESSAGE);

					if (option == JOptionPane.OK_OPTION) {
						myCompany.deleteWarehouse(codeAlma);
						JOptionPane.showMessageDialog(null, "Eliminado correcto", "Alerta - Hecho!", JOptionPane.INFORMATION_MESSAGE);
						loadTableWarehouse();
						btnDelete.setEnabled(false);
						btnModify.setEnabled(false);
					}

				}
			});

			btnDelete.setEnabled(false);
			btnDelete.setRolloverIcon(new ImageIcon(ListWarehouse.class.getResource("/imagenes/icons8_eraser_48px.png")));
			btnDelete.setPressedIcon(new ImageIcon(ListWarehouse.class.getResource("/imagenes/icons8_eraser_48px.png")));
			btnDelete.setIcon(new ImageIcon(ListWarehouse.class.getResource("/imagenes/icons8_delete_forever_48px.png")));
			btnDelete.setPreferredSize(new Dimension(100, 30));
			btnDelete.setOpaque(false);
			btnDelete.setForeground(Color.WHITE);
			btnDelete.setFont(new Font("Consolas", Font.BOLD, 20));
			btnDelete.setBorder(null);
			btnDelete.setBackground(new Color(255, 250, 250, 80));
			btnDelete.setActionCommand("OK");
			btnDelete.setBounds(822, 8, 186, 48);
			buttonPane.add(btnDelete);
		}

		scrollPane = new JScrollPane();
	
		scrollPane.setBounds(0, 0, 1300, 815);
		panelBg.add(scrollPane);

		tableWarehouse = new JTable();
		tableWarehouse.setRowHeight(22);
		tableWarehouse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (tableWarehouse.getSelectedRow() >= 0) {
					int index = tableWarehouse.getSelectedRow();
					btnDelete.setEnabled(true);
					btnModify.setEnabled(true);
					codeAlma = (String) tableWarehouse.getModel().getValueAt(index, 0);

				}
			}
		});
		tableWarehouse.setBackground(new Color(255, 255, 255));
		tableWarehouse.setFont(new Font("Consolas", Font.PLAIN, 16));
		tableWarehouse.setSelectionBackground(new Color(220, 20, 60));

		tableWarehouse.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"C\u00F3digo", "Ciudad", "Municipio", "Area terreno (m^2)", "Capacidad (ton)"
				}
				) {
			Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableWarehouse.getColumnModel().getColumn(0).setResizable(false);
		tableWarehouse.getColumnModel().getColumn(1).setResizable(true);
		tableWarehouse.getColumnModel().getColumn(2).setResizable(true);
		tableWarehouse.getColumnModel().getColumn(3).setResizable(false);
		tableWarehouse.getColumnModel().getColumn(4).setResizable(false);
		scrollPane.setViewportView(tableWarehouse);

		loadTableWarehouse();


	}


	/******** Methods - Functions *******/
	public static void loadTableWarehouse() {
		model = (DefaultTableModel) tableWarehouse.getModel();
		model.setRowCount(0);
		column = new Object[model.getColumnCount()];

		for (int i = 0; i < myCompany.getCantAlmacen(); i++) {
			column[0] = myCompany.getListAlmacen()[i].getCodigo();
			column[1] = myCompany.getListAlmacen()[i].getCiudad();
			column[2] = myCompany.getListAlmacen()[i].getMunicipio();
			column[3] = myCompany.getListAlmacen()[i].getAreaTerreno();
			column[4] = myCompany.getListAlmacen()[i].getCapacidad();
			model.addRow(column);
		}
	}
}
