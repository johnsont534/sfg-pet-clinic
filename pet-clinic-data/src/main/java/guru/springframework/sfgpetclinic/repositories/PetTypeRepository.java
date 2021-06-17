package guru.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.sfgpetclinic.model.Pet;

public interface PetTypeRepository extends CrudRepository<Pet, Long> {

}
