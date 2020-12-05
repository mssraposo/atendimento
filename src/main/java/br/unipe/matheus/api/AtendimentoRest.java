package br.unipe.matheus.api;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:4200")
public class AtendimentoRest {
	
	@Autowired
	private AtendimentoRepository _atendimentoRepository;

	
	@PostMapping("/atendimento")
	public Atendimento salvar(@RequestBody Atendimento atendimento){
		return _atendimentoRepository.save(atendimento);
		
	}
	
	@GetMapping("/atendimento/{id}")
	public ResponseEntity<Atendimento> getAtendimentoById(@PathVariable("id") Long id){
		Optional<Atendimento> atendimento = _atendimentoRepository.findById(id);
        return new ResponseEntity<Atendimento>(atendimento.get(), HttpStatus.OK);    
	}
	
	@GetMapping("/atendimento")
    public List<Atendimento> getAtendimento() {
		return _atendimentoRepository.findAll();
	}
	
	
	@DeleteMapping("/atendimento/{id}")
    public ResponseEntity<Object> deleteAtendimento(@PathVariable(value = "id") long id)
    {
        Optional<Atendimento> atendimento = _atendimentoRepository.findById(id);
        if(atendimento.isPresent()){
            _atendimentoRepository.delete(atendimento.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	/* @GetMapping("/atendimento")
    public List<Atendimento> getAtendimento() {
		
		Atendimento[] atendimentos  = new Atendimento[19];		
		Atendimento p = new Atendimento();
		p.setId(1l);
		p.setCoordenador("Felipe");
		p.setAssunto("Assunto");
		p.setDescricao("Descrição");
		p.setData("Data");
		atendimentos[0] = p;
		return (List<Atendimento>) Arrays.asList(atendimentos);
	} */
	

}
