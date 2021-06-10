package guru.springframework.sfgpetclinic.services;

import java.util.Set;

import guru.springframework.sfgpetclinic.model.Owner;

public interface OwnerService {

	public Owner findByLastName(String lastName);
	
	public Owner findById(Long id);
	
	public Owner save(Owner owner);
	
	Set<Owner> findAll();
}
