package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.dao.VeiculoDTO;

public class VeiculoMapper {

    public VeiculoDTO map(ResultSet rs) throws SQLException {
		
		return new VeiculoDTO(rs.getString("id"), 
	                          rs.getString("placa"), 
	                          rs.getString("modelo"),
	                          rs.getInt("anoFabricacao"),
	                          rs.getDouble("valorDiaria"),
	                          rs.getInt("quilometragem"));
	}
    
}
