package br.app.gestaotec.demo_park_api.repository.projection;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public interface ClienteVagaProjection {
    String getClienteCpf();

    String getRecibo();

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    LocalDateTime getDataEntrada();

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    LocalDateTime getDataSaida();

    String getVagaCodigo();

    BigDecimal getValor();

    BigDecimal getDesconto();

    String getPlaca();

    String getMarca();

    String getModelo();

    String getCor();
}
