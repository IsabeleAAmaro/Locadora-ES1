package domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import domain.dao.VeiculoDTO;
import domain.dao.IVeiculoDAO;

public class VeiculoRepository implements Repository{
    
    private final IVeiculoDAO dao;

    public VeiculoRepository(IVeiculoDAO dao){
        this.dao = dao;
    }

    public List<Veiculo> findAll() throws SQLException  
    {

        var dtos = dao.findAll();    
        var veiculos = new ArrayList<Veiculo>();
            
        for (var dto : dtos)
            veiculos.add(create(dto));
            
        return veiculos;
    }
        
        
    public Veiculo findByPlaca(String placa) throws SQLException  
    {
        
        var dto = dao.findByPlaca(placa);

        if (dto != null)
            return create(dto);
        
        return null;
    }
        
    public void add(Veiculo veiculo) throws SQLException  
    {
            
        if (veiculo.getId() == null) 
        {
            veiculo.setId(UUID.randomUUID().toString());
            dao.insert(veiculo);
        }
        else
            dao.update(veiculo);
    }
        
    public void remove(Veiculo veiculo) throws SQLException  
    {
            
        if (veiculo.getId() != null) 
        {
            dao.delete(veiculo);	
            veiculo.setId(null);
        }
    }
        

    private Veiculo create(VeiculoDTO dto) 
    {
            var resultado = new VeiculoBuilder()
                    .withPlaca(dto.placa())
                    .withModelo(dto.modelo())
                    .withAnoFabr(dto.anoFabricacao())
                    .withDiaria(dto.valorDiaria())
                    .withKM(dto.quilometragem())
                    .build();
            
            var veiculos = resultado.valor;
            
            veiculos.setId(dto.id());
            
            return veiculos;
    }
}
