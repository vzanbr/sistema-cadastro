package br.com.sistemacadastro.controller;

import br.com.sistemacadastro.exception.UsuarioCadastradoException;
import br.com.sistemacadastro.model.entity.Usuario;
import br.com.sistemacadastro.model.repository.UsuarioRepository;
import br.com.sistemacadastro.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/salvar/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Usuario usuario){
        try{
            service.salvar(usuario);
        }catch (UsuarioCadastradoException e){
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, e.getMessage() );
        }
    }

//    @GetMapping("cliente/{id}")
//    public Cliente acharId(@PathVariable Integer id) {
//        return repository.findById(id)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
//    }
//
//    @GetMapping("clientes")
//    public List<Cliente> clientes () {
//       return repository.findAll();
//    }
//
//    @DeleteMapping("/deletar/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deletarId(@PathVariable Integer id) {
//        repository.findById(id)
//                .map(cliente -> {
//                    repository.delete(cliente);
//                    return Void.TYPE;
//                })
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
//    }
//
//    @PutMapping("/atualizar/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void atualizar(@PathVariable Integer id, @RequestBody Cliente clienteAtualizado) {
//        repository.findById(id)
//                .map(cliente -> {
//                    cliente.setNome(clienteAtualizado.getNome());
//                    cliente.setCpf(clienteAtualizado.getCpf());
//                    return repository.save(cliente);
//                })
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
//    }
}
