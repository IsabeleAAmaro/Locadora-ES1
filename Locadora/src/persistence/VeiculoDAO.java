package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import domain.Veiculo;
import domain.dao.IVeiculoDAO;
import domain.dao.VeiculoDTO;


public class VeiculoDAO implements IVeiculoDAO {
    
    @Override
    public void insert (Veiculo veiculo) throws SQLException {

        try(var con = DBConnection.get();
            var stmt = con.prepareStatement("insert into veiculo values (?, ?, ?, ?, ?, ?)")){

                stmt.setString(1, veiculo.getId());
                stmt.setString(2, veiculo.getPlaca());
                stmt.setString(3, veiculo.getModelo());
                stmt.setInt(4, veiculo.getAnoFabricacao());
                stmt.setDouble(5, veiculo.getValorDiaria());
                stmt.setInt(6, veiculo.getQuilometragem());

                stmt.execute();
        }
    }

    @Override
    public void update (Veiculo veiculo) throws SQLException {
        try(var con = DBConnection.get();
            var stmt = con.prepareStatement("update veiculo set placa = ?, modelo = ?, anoFabricacao = ?, "
                                            + " valorDiaria = ?, quilometragem = ? where id = ?")){

                
                stmt.setString(1, veiculo.getPlaca());
                stmt.setString(2, veiculo.getModelo());
                stmt.setInt(3, veiculo.getAnoFabricacao());
                stmt.setDouble(4, veiculo.getValorDiaria());
                stmt.setInt(5, veiculo.getQuilometragem());
                stmt.setString(6, veiculo.getId());

                stmt.execute();
        }
    }

    @Override
	public void delete(Veiculo veiculo) throws SQLException {

		try (var conn = DBConnection.get(); 
			 var stmt = conn.prepareStatement("delete from veiculo where id = ?")) {
				
			stmt.setString(1, veiculo.getId());
				
			stmt.execute();
		}
	}
	
@Override
	public List<VeiculoDTO> findAll() throws SQLException  {
		
		try (var conn = DBConnection.get(); 
			 var stmt = conn.createStatement();
		     var rs = stmt.executeQuery("select * from veiculo")) {
				
			var mapper = new VeiculoMapper();
			var veiculos = new ArrayList<VeiculoDTO>();
			
			while (rs.next())
				veiculos.add(mapper.map(rs));
			
			return veiculos;
		}
	}	
	
	@Override
	public VeiculoDTO findByPlaca(String placa) throws SQLException  {
		
		try (var conn = DBConnection.get(); 
			 var stmt = conn.prepareStatement("select * from veiculo where placa = ?")) {

			stmt.setString(1, placa);
			
			try (var rs = stmt.executeQuery()) {
				var mapper = new VeiculoMapper();
				
				if (rs.next())
					return mapper.map(rs);
				
				return null;
			}
		}
    }
}
