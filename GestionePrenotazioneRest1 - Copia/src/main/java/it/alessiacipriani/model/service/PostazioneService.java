package it.alessiacipriani.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.alessiacipriani.model.Citta;
import it.alessiacipriani.model.Edificio;
import it.alessiacipriani.model.Postazione;
import it.alessiacipriani.model.TipoPostazione;
import it.alessiacipriani.model.User;
import it.alessiacipriani.model.repository.EdificioRepository;
import it.alessiacipriani.model.repository.PostazioneRepository;

@Service
public class PostazioneService {
	@Autowired
	private PostazioneRepository postazioneRepository;
	@Autowired
	EdificioRepository edificioRepository;
	
    public List<Postazione> allPostazione() {
        return postazioneRepository.findAll();
    }
    public Optional<Postazione> findPostazioneById(Long id) {
        return postazioneRepository.findById(id);
    }
    public void savePostazione(Postazione p) {
        postazioneRepository.save(p);
    }
    public List<Optional<Postazione>> findByTipo(TipoPostazione tipo, String city){
    	return postazioneRepository.findByTipo(tipo, city);
    }
    public Postazione getById(Long id) {
    	return postazioneRepository.getById(id);
    }
	public Postazione savePostazione(String codice, String descrizione, Integer numeroMassimo, TipoPostazione tipo,
			Long idEdificio) {
		
		return postazioneRepository.save(new Postazione(codice,descrizione,numeroMassimo,tipo,edificioRepository.getById(idEdificio)));
	}
	public Page<Postazione> findPostazionePage(Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Postazione> pagedResult = postazioneRepository.findAll(paging);
        if(pagedResult.hasContent()) {
      return pagedResult;
      } else {
          return null;
      }
        
    }
	  public List<Postazione> getAllPostazioneSorted() {
	        return postazioneRepository.findByOrderByNumeroMassimoOccupatiAsc();
	    }
	  public Page<Postazione> getPostazionePageable(Pageable pageable){
		  return postazioneRepository.findAll(pageable);
		  
	  }
}
