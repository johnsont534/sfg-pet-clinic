package guru.springframework.sfgpetclinic.services.map;

import java.util.Set;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.CrudService;

public class PetServiceMap extends AbstractMapService<Pet, Long> 
	implements CrudService<Pet, Long> {

	@Override
	public Set<Pet> findAll() {
		return super.findAll();
	}
	
	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Pet save(Pet object) {
		return super.save(object.getId(), object);
	}
	
	public void delete(Pet object) {
		super.delete(object);
	}
	
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}