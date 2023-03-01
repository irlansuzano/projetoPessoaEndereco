package com.marcillino.irlan.resources;

import com.marcillino.irlan.entities.Endereco;
import com.marcillino.irlan.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {

    @Autowired
    EnderecoService enderecoService;

    /**
     * Retorna todos os enderecos do sistema
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Endereco>> findAll(){
        List<Endereco> enderecos = enderecoService.findAll();
        return ResponseEntity.ok().body(enderecos);
    }

    /**
     * retorna um endereco pelo seu identificador
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable Long id){
        Endereco endereco = enderecoService.findById(id);
        return ResponseEntity.ok().body(endereco);
    }

}
