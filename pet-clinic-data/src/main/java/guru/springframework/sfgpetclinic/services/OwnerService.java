package guru.springframework.sfgpetclinic.services;

import java.util.List;

import guru.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

	public Owner findByLastName(String lastName);
	
	public List<Owner> findAllByLastNameLike(String lastName);
	
	
}
