package project;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ComponentaPcDAO {

	private Connection myConn;

	public ComponentaPcDAO() throws Exception {
		Properties props = new Properties();
		props.load(new FileInputStream("demo.properties"));

		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String url = props.getProperty("url");

		myConn = DriverManager.getConnection(url, user, password);
		System.out.println("connection");
	}

	public List<ComponentaPc> getAllComponenete() throws Exception {
		System.out.println("aici12");
		List<ComponentaPc> list = new ArrayList<>();
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from componente_pc");

			while (myRs.next()) {
				ComponentaPc comp = converter(myRs);
				System.out.println("selectie" + comp.getMarca());
				list.add(comp);
			}
			return list;
		} finally {
			close(myStmt, myRs);
		}
	}

	public List<ComponentaPc> searchComponente(int cod_produs) throws Exception {
		List<ComponentaPc> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRS = null;

		try {
			myStmt = myConn.prepareStatement("select * from componente_pc where cod_produs=?");
			myStmt.setInt(1, cod_produs);
			myRS = myStmt.executeQuery();

			while (myRS.next()) {
				ComponentaPc comp = converter(myRS);
				list.add(comp);
			}
			return list;
		} finally {
			close(myStmt, myRS);
		}
	}

	public void addComponenta(ComponentaPc comp) throws Exception {
		PreparedStatement myStmt = null;
		try {
			myStmt = myConn.prepareStatement("insert into componente_pc "
					+ "(pret, marca, an_fabricatie, garantie, producator, tara_provenienta, stoc)"
					+ " values(?, ?, ?, ?, ?, ?, ?)");

			myStmt.setString(1, comp.getPret());
			myStmt.setString(2, comp.getMarca());
			myStmt.setString(3, comp.getAn_fabricatie());
			myStmt.setString(4, comp.getGarantie());
			myStmt.setString(5, comp.getGarantie());
			myStmt.setString(6, comp.getTara_provenienta());
			myStmt.setInt(7, comp.getStoc());
			System.out.println(comp.getStoc());
			myStmt.executeUpdate();
		} finally {
			close(myStmt);
		}
	}

	public void modifyComponeneta(ComponentaPc comp) throws Exception {
		PreparedStatement myStmt = null;
		try {
			myStmt = myConn.prepareStatement("update componente_pc "
					+ " set pret=?, marca=?, an_fabricatie=?, garantie=?, producator=?, tara_provenienta=?, stoc=?"
					+ " where cod_produs=?");

			myStmt.setString(1, comp.getPret());
			myStmt.setString(2, comp.getMarca());
			myStmt.setString(3, comp.getAn_fabricatie());
			myStmt.setString(4, comp.getGarantie());
			myStmt.setString(5, comp.getGarantie());
			myStmt.setString(6, comp.getTara_provenienta());
			myStmt.setInt(7, comp.getStoc());
			myStmt.setInt(8, comp.getCod_produs());
			System.out.println(comp.getStoc());
			myStmt.executeUpdate();
		} finally {
			close(myStmt);
		}
	}

	public void deleteComponeneta(int cod) throws SQLException {
		PreparedStatement myStmt = null;

		try {
			myStmt = myConn.prepareStatement("delete from componente_pc where cod_produs=?");
			myStmt.setInt(1, cod);
			myStmt.executeUpdate();
		} finally {
			close(myStmt);
		}
	}

	public void sellComponenta(int cod) throws SQLException {
		PreparedStatement myStmt = null;
		try {
			myStmt = myConn.prepareStatement("update componente_pc set stoc=stoc-1 where cod_produs=?");
			myStmt.setInt(1, cod);
			myStmt.executeUpdate();
		} finally {
			close(myStmt);
		}
	}

	private void close(PreparedStatement myStmt) throws SQLException {
		close(null, myStmt, null);
	}

	private ComponentaPc converter(ResultSet myRs) throws SQLException {

		int cod_produs = myRs.getInt("cod_produs");
		String pret = myRs.getString("pret");
		String marca = myRs.getString("marca");
		String an_fabricatie = myRs.getString("an_fabricatie");
		String garantie = myRs.getString("garantie");
		String producator = myRs.getString("producator");
		String tara_provenienta = myRs.getString("tara_provenienta");
		int stoc = myRs.getInt("stoc");

		ComponentaPc com = new ComponentaPc(cod_produs, pret, marca, an_fabricatie, garantie, producator,
				tara_provenienta, stoc);

		return com;

	}

	private static void close(Connection myConn, Statement myStmt, ResultSet myRs) throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {

		}

		if (myConn != null) {
			myConn.close();
		}
	}

	private void close(Statement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);
	}

	public static void main(String[] args) throws Exception {
		ComponentaPc pc=new ComponentaPc();
		pc.whenSerializingAndDeserializing_ThenObjectisTheSame();
		ComponentaPcDAO com = new ComponentaPcDAO();
		System.out.println(com.searchComponente(1).get(0).getAn_fabricatie());
		System.out.println(com.getAllComponenete());
	}

}
