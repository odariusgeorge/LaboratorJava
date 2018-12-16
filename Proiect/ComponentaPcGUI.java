package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class ComponentaPcGUI extends JFrame {

	private JPanel contentPane;
	private JTextField lastNameTextField;

	private ComponentaPcDAO compDAO;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		ComponentaPc pc=new ComponentaPc();
		try {
			pc.whenSerializingAndDeserializing_ThenObjectisTheSame();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pc.whenSerializingAndDeserializing_ThenObjectisTheSame();
					ComponentaPcGUI frame = new ComponentaPcGUI();
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
	public ComponentaPcGUI() {
		try {
			compDAO = new ComponentaPcDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setTitle("Aplicatie Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblEnterLastName = new JLabel("Cod Produs");
		panel.add(lblEnterLastName);

		lastNameTextField = new JTextField();
		panel.add(lastNameTextField);
		lastNameTextField.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String cod = lastNameTextField.getText();
					System.out.println("ceva" + cod);
					List<ComponentaPc> componenta = null;
					if (cod != null && cod.trim().length() > 0) {
						int cod_produs = Integer.parseInt(cod);
						componenta = compDAO.searchComponente(cod_produs);
						System.out.println("ooo" + componenta.get(0).getMarca());
					} else {
						System.out.println("aici " + compDAO);
						componenta = compDAO.getAllComponenete();
						System.out.println("12" + componenta.get(0).getMarca());
					}

					ComponentaPcTableModel model = new ComponentaPcTableModel(componenta);
					table.setModel(model);

				} catch (Exception e) {
					System.out.println(e);
					JOptionPane.showMessageDialog(ComponentaPcGUI.this, "Error: " + e);
				}
			}
		});
		panel.add(btnSearch);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setColumnHeaderView(table);

		JPanel panel_1 = new JPanel();
		JButton addButton = new JButton("Adauga Componenta");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddComponenta dialog = new AddComponenta(ComponentaPcGUI.this, compDAO);
				dialog.setVisible(true);
			}
		});
		panel_1.add(addButton);
		contentPane.add(panel_1, BorderLayout.SOUTH);

		JButton updateButton = new JButton("Modificare Componenta");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row < 0) {
					JOptionPane.showMessageDialog(ComponentaPcGUI.this, "Trebuie selectat un produs", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				ComponentaPc tempComp = (ComponentaPc) table.getValueAt(row, ComponentaPcTableModel.OBJECT_COL);
				AddComponenta dialog = new AddComponenta(ComponentaPcGUI.this, compDAO, tempComp, true);
				dialog.setVisible(true);
			}
		});
		panel_1.add(updateButton);

		JButton deleteButton = new JButton("Stergere");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = table.getSelectedRow();
					if (row < 0) {
						JOptionPane.showMessageDialog(ComponentaPcGUI.this, "Trebuie selectat un produs", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					int raspuns = JOptionPane.showConfirmDialog(ComponentaPcGUI.this,
							"Doriti sa stergeti acest produs?", "Confirm", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);

					if (raspuns != JOptionPane.YES_OPTION) {
						return;
					}

					ComponentaPc tempComp = (ComponentaPc) table.getValueAt(row, ComponentaPcTableModel.OBJECT_COL);
					compDAO.deleteComponeneta(tempComp.getCod_produs());
					refreshComp();
					JOptionPane.showMessageDialog(ComponentaPcGUI.this, "Componenta a fost stearsa",
							"Componenenta stearsa", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(ComponentaPcGUI.this, "Eroare la stergere: " + e2.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel_1.add(deleteButton);

		JButton sellButton = new JButton("Vanzare Componenta");
		sellButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = table.getSelectedRow();
					if (row < 0) {
						JOptionPane.showMessageDialog(ComponentaPcGUI.this, "Trebuie selectat un produs", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					int raspuns = JOptionPane.showConfirmDialog(ComponentaPcGUI.this, "Doriti sa vindeti acest produs?",
							"Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (raspuns != JOptionPane.YES_OPTION) {
						return;
					}

					ComponentaPc tempComp = (ComponentaPc) table.getValueAt(row, ComponentaPcTableModel.OBJECT_COL);
					if (tempComp.getStoc() > 0) {
						compDAO.sellComponenta(tempComp.getCod_produs());
						refreshComp();
						JOptionPane.showMessageDialog(ComponentaPcGUI.this, "Componenta a fost vanduta",
								"Componenenta vanduta", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(ComponentaPcGUI.this, "Stocul este 0", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(ComponentaPcGUI.this, "Eroare la stergere: " + e2.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(sellButton);
	}

	public void refreshComp() {
		try {
			List<ComponentaPc> comp = compDAO.getAllComponenete();

			ComponentaPcTableModel model = new ComponentaPcTableModel(comp);

			table.setModel(model);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error: " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

}
