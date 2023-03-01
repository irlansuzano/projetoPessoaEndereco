package com.marcillino.irlan.services;

import com.marcillino.irlan.entities.Endereco;
import com.marcillino.irlan.entities.Pessoa;
import com.marcillino.irlan.reporitories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Classe de serviço do objeto pessoa
 *
 * @author Irlan
 */
@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    /**
     * método responsável pelo retorno de uma lista de pessoas
     *
     * @return List<Pessoa>
     */
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    /**
     * método que busca uma pessoa ou retorna vazio
     *
     * @param id
     * @return Optional<Pessoa>
     */
    public Pessoa findById(Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.get();
    }

    /**
     * método que registra uma Pessoa
     *
     * @param pessoa
     */
    public Pessoa insertPerson(Pessoa pessoa) {

        return pessoaRepository.save(pessoa);
    }

    /**
     * método que edita uma pessoa e cria ela, caso não exista
     *
     * @param pessoa
     */
    public Pessoa updatePerson(Long id, Pessoa pessoa) {
        Pessoa pessoaPesquisada = pessoaRepository.getReferenceById(id);
        this.updateMainAddressDefault(pessoa);
        this.updateData(pessoaPesquisada, pessoa);
        return pessoaRepository.save(pessoaPesquisada);
    }

    /**
     * atualiza o primeiro endereço inserido para o principal
     *
     * @param pessoa
     */
    private void updateMainAddressDefault(Pessoa pessoa) {
        if (!pessoa.getEnderecos().isEmpty() && Objects.isNull(pessoa.getEnderecoPrincipal())) {
            pessoa.setEnderecoPrincipal(pessoa.getEnderecos().get(0).getId());
        }
    }

    /**
     * método que atualiza os dados da pessoa
     *
     * @param pessoaPesquisada
     * @param pessoa
     */
    private void updateData(Pessoa pessoaPesquisada, Pessoa pessoa) {
        pessoaPesquisada.setNome(pessoa.getNome());
        pessoaPesquisada.setDataNascimento(pessoa.getDataNascimento());
        pessoaPesquisada.setEnderecoPrincipal(pessoa.getEnderecoPrincipal());
    }

    /**
     * método que busca todos os enderecos de uma pessoa
     *
     * @param pessoaId
     * @return
     */
    public List<Endereco> findAllAddress(Long pessoaId) {
        return pessoaRepository.findById(pessoaId).get().getEnderecos();
    }

    /**
     * método que define o endereço principal da pessoa
     *
     * @param idEndereco
     * @param id
     */
    public Pessoa saveMainAddress(Long id, Long idEndereco) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (!pessoa.get().getEnderecos().stream().anyMatch(endereco -> endereco.getId().equals(idEndereco))){
           return null;
        }
            pessoa.get().setEnderecoPrincipal(idEndereco);
        return pessoaRepository.save(pessoa.get());
    }

}
