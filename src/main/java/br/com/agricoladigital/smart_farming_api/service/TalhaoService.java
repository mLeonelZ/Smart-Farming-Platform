package br.com.agricoladigital.smart_farming_api.service;

import br.com.agricoladigital.smart_farming_api.dto.request.TalhaoRequest;
import br.com.agricoladigital.smart_farming_api.dto.response.TalhaoResponse;
import br.com.agricoladigital.smart_farming_api.entity.Fazenda;
import br.com.agricoladigital.smart_farming_api.entity.Talhao;
import br.com.agricoladigital.smart_farming_api.exception.ConflitoException;
import br.com.agricoladigital.smart_farming_api.exception.RecursoNaoEncontradoException;
import br.com.agricoladigital.smart_farming_api.repository.FazendaRepository;
import br.com.agricoladigital.smart_farming_api.repository.TalhaoRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TalhaoService {
    private final TalhaoRepository talhaoRepository;
    private final FazendaRepository fazendaRepository;

    public TalhaoService(TalhaoRepository talhaoRepository, FazendaRepository fazendaRepository) {
        this.talhaoRepository = talhaoRepository;
        this.fazendaRepository = fazendaRepository;
    }

    @Transactional
    public TalhaoResponse criar(Long fazendaId, TalhaoRequest request) {
        Fazenda fazenda = encontrarFazenda(fazendaId);
        Talhao talhao = new Talhao(
                request.identificacao(),
                request.areaHectares(),
                request.geometria(),
                fazenda
        );
        return paraResponse(talhaoRepository.save(talhao));
    }

    public List<TalhaoResponse> listarPorFazenda(Long fazendaId) {
        encontrarFazenda(fazendaId);
        return talhaoRepository.findAllByFazenda_Id(fazendaId)
                .stream()
                .map(TalhaoService::paraResponse)
                .toList();
    }

    public TalhaoResponse buscar(Long fazendaId, Long talhaoId) {
        return paraResponse(encontrarTalhao(fazendaId, talhaoId));
    }

    @Transactional
    public TalhaoResponse atualizar(Long fazendaId, Long talhaoId, TalhaoRequest request) {
        Talhao talhao = encontrarTalhao(fazendaId, talhaoId);
        talhao.atualizar(request.identificacao(), request.areaHectares(), request.geometria());
        return paraResponse(talhao);
    }

    @Transactional
    public void excluir(Long fazendaId, Long talhaoId) {
        Talhao talhao = encontrarTalhao(fazendaId, talhaoId);
        try {
            talhaoRepository.delete(talhao);
            talhaoRepository.flush();
        } catch (DataIntegrityViolationException exception) {
            throw new ConflitoException("Não é possível excluir o talhão enquanto houver dispositivos vinculados.");
        }
    }

    private Fazenda encontrarFazenda(Long fazendaId) {
        return fazendaRepository.findById(fazendaId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Fazenda não encontrada: " + fazendaId));
    }

    private Talhao encontrarTalhao(Long fazendaId, Long talhaoId) {
        encontrarFazenda(fazendaId);
        return talhaoRepository.findByIdAndFazenda_Id(talhaoId, fazendaId)
                .orElseThrow(() -> new RecursoNaoEncontradoException(
                        "Talhão não encontrado na fazenda informada: " + talhaoId
                ));
    }

    private static TalhaoResponse paraResponse(Talhao talhao) {
        return new TalhaoResponse(
                talhao.getId(),
                talhao.getIdentificacao(),
                talhao.getAreaHectares(),
                talhao.getGeometria(),
                talhao.getFazenda().getId()
        );
    }
}
