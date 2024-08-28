package persistence;

import domain.dao.LocacaoListagemDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocacaoMapper {

    public LocacaoListagemDTO map(ResultSet rs) throws SQLException {

        //TODO: Msm coisa do dao i guess

        var df = DateTimeFormatter.ofPattern("ddMMyyyyHHmm", Locale.getDefault());

        return new LocacaoListagemDTO(rs.getString("id"),
                rs.getLong("cpf"),
                rs.getString("nome"),
                rs.getString("placa"),
                rs.getString("modelo"),
                LocalDateTime.from(df.parse(rs.getString("data_hora"))));
    }

}
