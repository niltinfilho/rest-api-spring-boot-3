package br.app.gestaotec.demo_park_api.service;

import br.app.gestaotec.demo_park_api.entity.Vaga;
import br.app.gestaotec.demo_park_api.exception.CodigoUniqueViolationException;
import br.app.gestaotec.demo_park_api.exception.EntityNotFoundException;
import br.app.gestaotec.demo_park_api.exception.VagaDisponivelException;
import br.app.gestaotec.demo_park_api.repository.VagaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VagaService {

    private final VagaRepository vagaRepository;

    @Transactional
    public Vaga salvar(Vaga vaga) {
        try {
            return vagaRepository.save(vaga);
        } catch (DataIntegrityViolationException e) {
            throw new CodigoUniqueViolationException("Vaga", vaga.getCodigo());
        }
    }

    @Transactional(readOnly = true)
    public Vaga buscarPorCodigo(String codigo) {
        return vagaRepository.findByCodigo(codigo).orElseThrow(
                () -> new EntityNotFoundException("Vaga", codigo)
        );
    }

    @Transactional(readOnly = true)
    public Vaga buscarPorVagaLivre() {
        return vagaRepository.findFirstByStatus(Vaga.StatusVaga.LIVRE).orElseThrow(
                () -> new VagaDisponivelException("Nenhuma vaga livre foi encontrada")
        );
    }
}
