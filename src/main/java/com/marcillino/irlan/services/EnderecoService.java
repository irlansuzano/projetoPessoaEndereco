package com.marcillino.irlan.services;

import com.marcillino.irlan.entities.Endereco;
import com.marcillino.irlan.reporitories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    /**
     * método que salva um endereço
     * @param endereco
     */
    public Endereco saveAddress(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> findAll(){
        return enderecoRepository.findAll();
    }

    public Endereco findById(Long id){
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        return endereco.get();
    }
}
