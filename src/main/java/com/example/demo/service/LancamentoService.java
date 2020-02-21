package com.example.demo.service;


import com.example.demo.model.Lancamento;
import com.example.demo.model.Pessoa;
import com.example.demo.repository.LancamentoRepository;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.service.exception.PessoaInexistenteouInativaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LancamentoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public Lancamento salvar(Lancamento lancamento) {
        Pessoa pessoa = this.pessoaRepository.findById(lancamento.getPessoa().getCodigo()).orElse(null);
        if(pessoa ==null || pessoa.isInativo()){
            throw new PessoaInexistenteouInativaException();
        }
        return lancamentoRepository.save(lancamento);
    }
}


