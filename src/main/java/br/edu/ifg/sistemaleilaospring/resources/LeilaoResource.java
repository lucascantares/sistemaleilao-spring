package br.edu.ifg.sistemaleilaospring.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.Vector;
import java.util.stream.Stream;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.edu.ifg.sistemaleilaospring.domain.Leilao;

@RestController
@RequestMapping("leiloes")
public class LeilaoResource {

	private static List<Leilao> leiloes = new Vector<>();
	static {
		leiloes.add(new Leilao(1L,"iPhone 12", "25/01/2022",5000.00,5000.00, "27/01/2022", "Ativo"));
		leiloes.add(new Leilao(2L,"iPhone 13", "25/01/2022",10000.00,10000.00, "27/01/2022", "Ativo"));
		leiloes.add(new Leilao(3L,"Mac", "20/01/2022",10000.00,10000.00, "21/01/2022", "Finalizado"));
	}
	
	@GetMapping
	public List<Leilao> lista(){
		return leiloes;
	}
	
	
	@GetMapping("/{codLeilao}")
	public Leilao obtem(@PathVariable long codLeilao) {
		Optional<Leilao>opLeilao = leiloes.stream().filter(leilao -> leilao.getCodLeilao()==codLeilao).findFirst();
		return opLeilao.get();
	}
	
	@GetMapping("/situacao")
	public Stream<Leilao> leilaoPorSituacao(@RequestParam String sit) {
		Stream<Leilao>opLeilao = leiloes.stream().filter(leilao -> leilao.getSituacao().equals(sit));
		return opLeilao;
	}
	
	@PostMapping
	public ResponseEntity<Leilao> gravar(@RequestBody Leilao leilao, UriComponentsBuilder uriBuilder){
		
		leilao.setCodLeilao((long)leiloes.size()+1);
		leiloes.add(leilao);
		URI uri = uriBuilder.path("/leiloes/{codLeilao}").buildAndExpand(leilao.getCodLeilao()).toUri();
		return ResponseEntity.created(uri).body(leilao);
	}
	
	
	/*
	 * @PutMapping("/{codLeilao}") public Leilao alterar(@PathVariable long
	 * codLeilao) { Optional<Leilao>opLeilao = leiloes.stream().filter(leilao ->
	 * leilao.getCodLeilao()==codLeilao).findFirst(); return opLeilao.get(); }
	 */
}
