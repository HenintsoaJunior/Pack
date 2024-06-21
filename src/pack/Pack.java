package pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.Connexion;

public class Pack{
	String id_pack;
	String ville;
	int nombre_hotels;
	int nombre_attractions;
	int nombre_transports;
	int nombre_guides;
	String nom_pack;
	double prix_total;


	public Pack() throws Exception {
	}

	public Pack(String id_pack, String ville, int nombre_hotels, int nombre_attractions, int nombre_transports, int nombre_guides, String nom_pack,double prix_total) throws Exception {
		this.id_pack = id_pack;
		this.ville = ville;
		this.nombre_hotels = nombre_hotels;
		this.nombre_attractions = nombre_attractions;
		this.nombre_transports = nombre_transports;
		this.nombre_guides = nombre_guides;
		this.nom_pack = nom_pack;
		this.prix_total = prix_total;
	}

	public void setId_pack(String newId_pack) throws Exception {
		this.id_pack = newId_pack;
	}

	public void setville(String newville) throws Exception {
		this.ville = newville;
	}

	public void setNombre_hotels(int newNombre_hotels) throws Exception {
		this.nombre_hotels = newNombre_hotels;
	}

	public void setNombre_attractions(int newNombre_attractions) throws Exception {
		this.nombre_attractions = newNombre_attractions;
	}

	public void setNombre_transports(int newNombre_transports) throws Exception {
		this.nombre_transports = newNombre_transports;
	}

	public void setNombre_guides(int newNombre_guides) throws Exception {
		this.nombre_guides = newNombre_guides;
	}

	public void setNom_pack(String newNom_pack) throws Exception {
		this.nom_pack = newNom_pack;
	}
	public void setPrix_total(double newPrix_total) throws Exception {
		this.prix_total = newPrix_total;
	}

	public String getId_pack(){
		return this.id_pack;
	}

	public String getVille(){
		return this.ville;
	}

	public int getNombre_hotels(){
		return this.nombre_hotels;
	}

	public int getNombre_attractions(){
		return this.nombre_attractions;
	}

	public int getNombre_transports(){
		return this.nombre_transports;
	}

	public int getNombre_guides(){
		return this.nombre_guides;
	}

	public String getNom_pack(){
		return this.nom_pack;
	}

	public double getPrix_total(){
		return this.prix_total;
	}

	public List<Pack> getAll() throws Exception {
		List<Pack> suggestions_par_budgets = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = Connexion.getConnection();
			String query = "SELECT * FROM Suggestions_par_budget where id_pack IS NOT NULL";
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Pack obj = new Pack(
					resultSet.getString("id_pack"),
					resultSet.getString("ville"),
					resultSet.getInt("nombre_hotels"),
					resultSet.getInt("nombre_attractions"),
					resultSet.getInt("nombre_transports"),
					resultSet.getInt("nombre_guides"),
					resultSet.getString("nom_pack"),
					resultSet.getDouble("prix_total")
					);
				suggestions_par_budgets.add(obj);
			}
		} catch (SQLException e) {
			throw new Exception("Error while finding all Suggestions_par_budgets: " + e.getMessage());
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new Exception("Error while closing resources: " + e.getMessage());
			}
		}
		return suggestions_par_budgets;
	}

	public List<Pack> getAllByBudgetsOrVille(Double budget, String ville) throws Exception {
		List<Pack> suggestionsParBudgets = new ArrayList<>();
		StringBuilder query = new StringBuilder("SELECT * FROM suggestions_par_budget WHERE id_pack IS NOT NULL");
	
		if (budget != null) {
			query.append(" AND prix_total <= ?");
		}
		if (ville != null && !ville.isEmpty()) {
			query.append(" AND ville LIKE ?");
		}
	
		try (Connection connection = Connexion.getConnection();
			 PreparedStatement statement = connection.prepareStatement(query.toString())) {
	
			int parameterIndex = 1;
			if (budget != null) {
				statement.setDouble(parameterIndex++, budget);
			}
			if (ville != null && !ville.isEmpty()) {
				statement.setString(parameterIndex++, "%" + ville + "%");
			}
	
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					Pack obj = new Pack(
						resultSet.getString("id_pack"),
						resultSet.getString("ville"),
						resultSet.getInt("nombre_hotels"),
						resultSet.getInt("nombre_attractions"),
						resultSet.getInt("nombre_transports"),
						resultSet.getInt("nombre_guides"),
						resultSet.getString("nom_pack"),
						resultSet.getDouble("prix_total")
					);
					suggestionsParBudgets.add(obj);
				}
			}
		} catch (SQLException e) {
			throw new Exception("Error while finding all Suggestions_par_budgets: " + e.getMessage(), e);
		}
	
		return suggestionsParBudgets;
	}
}
