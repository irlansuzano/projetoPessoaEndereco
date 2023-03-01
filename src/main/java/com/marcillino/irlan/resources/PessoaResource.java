package com.marcillino.irlan.resources;

import com.marcillino.irlan.entities.Endereco;
import com.marcillino.irlan.entities.Pessoa;
import com.marcillino.irlan.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * classe de recurso da entidade Pessoa
 *
 * @author Irlan
 */
@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    /**
     * método GET que busca pessoas
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {
        List<Pessoa> pessoas = pessoaService.findAll();

        return ResponseEntity.ok().body(pessoas);
    }

    /**
     * método GET que busca uma pessoa
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Long id) {
        Pessoa pessoa = pessoaService.findById(id);
        return ResponseEntity.ok().body(pessoa);
    }

    /**
     * método que salva uma pessoa
     *
     * @param pessoa
     * @return
     */
    @PostMapping(value = "/salvar")
    public ResponseEntity<Pessoa> savePerson(@RequestBody Pessoa pessoa) {
        pessoa = pessoaService.insertPerson(pessoa);
        return ResponseEntity.ok().body(pessoa);
    }

    /**
     * método que altera uma pessoa
     *
     * @param id
     * @param pessoa
     * @return
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<Pessoa> updatePerson(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        pessoa = pessoaService.updatePerson(id, pessoa);
        return ResponseEntity.ok().body(pessoa);
    }

    /**
     * método que encontra todos os enderecos da pessoa
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}/enderecos")
    public ResponseEntity<List<Endereco>> findAllAddressByPersonId(@PathVariable Long id) {
        List<Endereco> enderecos = pessoaService.findAllAddress(id);
        return ResponseEntity.ok().body(enderecos);
    }

    /**
     * método que troca o endereco principal
     *
     * @param id
     * @param numero
     * @return
     */
    @PutMapping(value = "/{id}/endereco_principal")
    public ResponseEntity<Pessoa> updateMainAddress(@PathVariable Long id, @RequestBody Long numero) {
        Pessoa pessoa = pessoaService.saveMainAddress(id, numero);
        return ResponseEntity.ok().body(pessoa);
    }
}
