package project;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ComponentaPcTableModel extends AbstractTableModel {
	public static final int OBJECT_COL = -1;
	private static final int PRET = 0;
	private static final int MARCA = 1;
	private static final int AN_FABRICATIE = 2;
	private static final int GARANTIE = 3;
	private static final int PRODUCATOR = 4;
	private static final int TARA_PROVENIENTA = 5;
	private static final int STOC = 6;

	private String[] columnNames = { "Pret", "Marca", "An Fabricatie", "Garantie", "Producator", "Tara Provenienta",
			"Stoc" };
	private List<ComponentaPc> componente;

	public ComponentaPcTableModel(List<ComponentaPc> componente) {
		this.componente = componente;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return componente.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		ComponentaPc comp = componente.get(row);

		switch (col) {
		case PRET:
			return comp.getPret();
		case MARCA:
			return comp.getMarca();
		case AN_FABRICATIE:
			return comp.getAn_fabricatie();
		case GARANTIE:
			return comp.getGarantie();
		case PRODUCATOR:
			return comp.getProducator();
		case TARA_PROVENIENTA:
			return comp.getTara_provenienta();
		case STOC:
			return comp.getStoc();
		case OBJECT_COL:
			return comp;
		default:
			return comp.getMarca();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
