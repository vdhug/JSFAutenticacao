package br.auth.controles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.auth.utils.DataConnect;

public class LoginDAO {
	
	public static boolean validate(String user, String password) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();
			ps = con.prepareStatement("SELECT username, password FROM Users WHERE username = ? AND password = ?");
			ps.setString(1, user);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Erro de conexão!! Mensagem: " + ex.getMessage());
			return false;
		} finally {
			DataConnect.close(con);
		}
		return false;
	}

}
