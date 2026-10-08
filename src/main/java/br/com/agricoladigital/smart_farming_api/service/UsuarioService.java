package br.com.agricoladigital.smart_farming_api.service;

import br.com.agricoladigital.smart_farming_api.dto.request.AlterarSenhaRequest;
import br.com.agricoladigital.smart_farming_api.dto.request.AtualizarUsuarioRequest;
import br.com.agricoladigital.smart_farming_api.dto.request.CriarUsuarioRequest;
import br.com.agricoladigital.smart_farming_api.dto.response.UsuarioResponse;
import br.com.agricoladigital.smart_farming_api.entity.Usuario;
import br.com.agricoladigital.smart_farming_api.exception.ConflitoException;
import br.com.agricoladigital.smart_farming_api.exception.RecursoNaoEncontradoException;
import br.com.agricoladigital.smart_farming_api.exception.SenhaAtualInvalidaException;
import br.com.agricoladigital.smart_farming_api.repository.UsuarioRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UsuarioResponse criar(CriarUsuarioRequest request) {
        if (usuarioRepository.existsByEmail(request.email())) {
            throw new ConflitoException("Já existe um usuário cadastrado com este e-mail.");
        }

        Usuario usuario = new Usuario(
                request.nome(),
                request.email(),
                passwordEncoder.encode(request.senha()),
                request.perfil()
        );
        return paraResponse(usuarioRepository.save(usuario));
    }

    public List<UsuarioResponse> listar() {
        return usuarioRepository.findAll(Sort.by("nome"))
                .stream()
                .map(UsuarioService::paraResponse)
                .toList();
    }

    public UsuarioResponse buscar(Long id) {
        return paraResponse(encontrarUsuario(id));
    }

    @Transactional
    public UsuarioResponse atualizar(Long id, AtualizarUsuarioRequest request) {
        Usuario usuario = encontrarUsuario(id);
        if (!usuario.getEmail().equals(request.email()) && usuarioRepository.existsByEmail(request.email())) {
            throw new ConflitoException("Já existe um usuário cadastrado com este e-mail.");
        }
        usuario.atualizarDados(request.nome(), request.email(), request.perfil());
        return paraResponse(usuario);
    }

    @Transactional
    public void alterarSenha(Long id, AlterarSenhaRequest request) {
        Usuario usuario = encontrarUsuario(id);
        if (!passwordEncoder.matches(request.senhaAtual(), usuario.getSenhaHash())) {
            throw new SenhaAtualInvalidaException();
        }
        usuario.alterarSenha(passwordEncoder.encode(request.novaSenha()));
    }

    @Transactional
    public void excluir(Long id) {
        Usuario usuario = encontrarUsuario(id);
        try {
            usuarioRepository.delete(usuario);
            usuarioRepository.flush();
        } catch (DataIntegrityViolationException exception) {
            throw new ConflitoException("Não é possível excluir o usuário enquanto houver fazendas vinculadas.");
        }
    }

    private Usuario encontrarUsuario(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado: " + id));
    }

    private static UsuarioResponse paraResponse(Usuario usuario) {
        return new UsuarioResponse(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getPerfil());
    }
}
