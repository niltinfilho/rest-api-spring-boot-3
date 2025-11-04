package br.app.gestaotec.demo_park_api.service;

import br.app.gestaotec.demo_park_api.entity.Cliente;
import br.app.gestaotec.demo_park_api.exception.CpfUniqueViolationException;
import br.app.gestaotec.demo_park_api.exception.EntityNotFoundException;
import br.app.gestaotec.demo_park_api.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(Cliente cliente) {
        try {
            return clienteRepository.save(cliente);
        } catch (DataIntegrityViolationException e) {
            throw new CpfUniqueViolationException(
                    String.format("CPF '%s' não pode ser cadastrado, ja existe no sistema", cliente.getCpf())
            );
        }
    }

    @Transactional(readOnly = true)
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Cliente 'id=%s' nao encontrado no sistema", id))
        );
    }
}
