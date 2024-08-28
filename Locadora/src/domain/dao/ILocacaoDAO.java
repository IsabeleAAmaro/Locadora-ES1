package domain.dao;

import domain.Locacao;

import java.sql.SQLException;
import java.util.List;

public interface ILocacaoDAO {

    void insert(Locacao locacao) throws SQLException;

    void update(Locacao locacao) throws SQLException;

    void delete(Locacao locacao) throws SQLException;

    List<LocacaoListagemDTO> findAll() throws SQLException;

    LocacaoListagemDTO findByCPF(Long cpf) throws SQLException;

    LocacaoListagemDTO findByPlaca(String placa) throws SQLException;
}
