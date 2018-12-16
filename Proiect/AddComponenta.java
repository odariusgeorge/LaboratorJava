package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddComponenta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField pretField;
	private JTextField marcaField;
	private JTextField an_fabricatieField;
	private JTextField garantieField;
	private JTextField producatorField;
	private JTextField tara_provenientaField;
	private JTextField stocField;

	private ComponentaPcDAO compDAO;

	private ComponentaPcGUI compGUI;

	private ComponentaPc precedentaComp = null;

	private boolean update = false;

	public AddComponenta(ComponentaPcGUI gui, ComponentaPcDAO dao, ComponentaPc comp, boolean updateM) {
		this();
		compDAO = dao;
		compGUI = gui;
		precedentaComp = comp;
		update = updateM;

		if (update) {
			setTitle("Modificare Componenta");

			populateGUI(precedentaComp);
		}
	}

	private void populateGUI(ComponentaPc precedentaComp) {
		pretField.setText(precedentaComp.getPret());
		marcaField.setText(precedentaComp.getMarca());
		garantieField.setText(precedentaComp.getGarantie());
		an_fabricatieField.setText(precedentaComp.getAn_fabricatie());
		producatorField.setText(precedentaComp.getProducator());
		tara_provenientaField.setText(precedentaComp.getTara_provenienta());
		stocField.setText("" + precedentaComp.getStoc());
	}

	public AddComponenta(ComponentaPcGUI gui, ComponentaPcDAO dao) {
		this();
		compDAO = dao;
		compGUI = gui;
	}

	/**
	 * Create the dialog.
	 */
	public AddComponenta() {
		setTitle("Adaugare Componenta");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblPret = new JLabel("Pret");
			lblPret.setBounds(2, 14, 30, 14);
			contentPanel.add(lblPret);
		}
		{
			pretField = new JTextField();
			pretField.setBounds(100, 11, 329, 20);
			contentPanel.add(pretField);
			pretField.setColumns(10);
		}
		{
			JLabel lblMarca = new JLabel("Marca");
			lblMarca.setBounds(2, 40, 50, 14);
			contentPanel.add(lblMarca);
		}
		{
			marcaField = new JTextField();
			marcaField.setBounds(100, 37, 329, 20);
			contentPanel.add(marcaField);
			marcaField.setColumns(10);
		}
		{
			JLabel lblAnFabricatie = new JLabel("An fabricatie");
			lblAnFabricatie.setBounds(2, 66, 80, 14);
			contentPanel.add(lblAnFabricatie);
		}
		{
			an_fabricatieField = new JTextField();
			an_fabricatieField.setBounds(100, 63, 329, 20);
			contentPanel.add(an_fabricatieField);
			an_fabricatieField.setColumns(10);
		}
		{
			JLabel lblGarantie = new JLabel("Garantie");
			lblGarantie.setBounds(2, 92, 80, 14);
			contentPanel.add(lblGarantie);
		}
		{
			garantieField = new JTextField();
			garantieField.setBounds(100, 89, 329, 20);
			contentPanel.add(garantieField);
			garantieField.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Producator");
			lblNewLabel.setBounds(2, 118, 80, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			producatorField = new JTextField();
			producatorField.setBounds(100, 115, 329, 20);
			contentPanel.add(producatorField);
			producatorField.setColumns(10);
		}
		{
			JLabel lblTaraProvenienta = new JLabel("Tara provenienta");
			lblTaraProvenienta.setBounds(2, 144, 100, 14);
			contentPanel.add(lblTaraProvenienta);
		}
		{
			tara_provenientaField = new JTextField();
			tara_provenientaField.setBounds(100, 141, 329, 20);
			contentPanel.add(tara_provenientaField);
			tara_provenientaField.setColumns(10);
		}
		{
			JLabel lblStoc = new JLabel("Stoc");
			lblStoc.setBounds(2, 170, 80, 14);
			contentPanel.add(lblStoc);
		}
		{
			stocField = new JTextField();
			stocField.setBounds(100, 167, 329, 20);
			contentPanel.add(stocField);
			stocField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("SAVE");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						saveComponenta();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						dispose();
					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}

	protected void saveComponenta() {
		String pret = pretField.getText();
		String marca = marcaField.getText();
		String an_fabricatie = an_fabricatieField.getText();
		String garantie = garantieField.getText();
		String producator = producatorField.getText();
		String tara = tara_provenientaField.getText();
		String stocs = stocField.getText();
		int stoc = Integer.parseInt(stocs);

		ComponentaPc tempComp = null;
		if (update) {
			tempComp = precedentaComp;
			tempComp.setAn_fabricatie(an_fabricatie);
			tempComp.setGarantie(garantie);
			tempComp.setMarca(marca);
			tempComp.setPret(pret);
			tempComp.setProducator(producator);
			tempComp.setStoc(stoc);
			tempComp.setTara_provenienta(tara);
		} else {
			tempComp = new ComponentaPc(pret, marca, an_fabricatie, garantie, producator, tara, stoc);
			System.out.println(tempComp.getPret());
		}
		try {
			if (update) {
				compDAO.modifyComponeneta(tempComp);
			} else {
				compDAO.addComponenta(tempComp);
			}
			setVisible(false);
			dispose();

			compGUI.refreshComp();

			JOptionPane.showMessageDialog(compGUI, "Componenta adauga", "Adauga", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(compGUI, "Error: " + e.getMessage(), "Error: ", JOptionPane.ERROR_MESSAGE);
		}
	}
}
