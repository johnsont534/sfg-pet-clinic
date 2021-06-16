package guru.springframework.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	
	public DataLoader(OwnerService ownerService, VetService vetService,
			PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		dog.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		Owner owner1 = new Owner();
	    owner1.setFirstName("Michael");
	    owner1.setLastName("Weston");
	    owner1.setAddress("123 Road Str.");
	    owner1.setCity("Manorville");
	    owner1.setTelephone("5555555555");
	    Pet mikesPet = new Pet();
	    mikesPet.setName("Tipsy");
	    mikesPet.setPetType(savedDogPetType);
	    mikesPet.setBirthDate(LocalDate.now());
	    owner1.getPets().add(mikesPet);
	     
	    ownerService.save(owner1);

	    Owner owner2 = new Owner();
	    owner2.setFirstName("Fiona");
	    owner2.setLastName("Glenanne");
	    owner2.setAddress("20 Shady View Xing.");
	    owner2.setCity("Manorville");
	    owner2.setTelephone("5555566666");
	    Pet fionasPet = new Pet();
	    fionasPet.setName("Devil Cat");
	    fionasPet.setPetType(savedCatPetType);
	    fionasPet.setBirthDate(LocalDate.now());
	    owner2.getPets().add(fionasPet);
	   
	    ownerService.save(owner2);
	     
	    System.out.println("Loaded owners");
	     
	    Vet vet1 = new Vet();
	    vet1.setFirstName("Sam");
	    vet1.setLastName("Axe");

	    vetService.save(vet1);

	    Vet vet2 = new Vet();
	    vet2.setFirstName("Jessie");
	    vet2.setLastName("Porter");

	    vetService.save(vet2);

	    System.out.println("Loaded Vets....");


	}

}
