package guru.springframework.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Specialty;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialtyService specialtyService;
	private final VisitService visitService;
	
	public DataLoader(OwnerService ownerService, VetService vetService,
			PetTypeService petTypeService,
			SpecialtyService specialtyService,
			VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
		this.visitService = visitService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		int count = petTypeService.findAll().size();
		
		if (count == 0) {
			loadData();
		}


	}
	
	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		dog.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		Specialty radiology = new Specialty();
		radiology.setDescription("radiology");
		Specialty savedRadiology = specialtyService.save(radiology);
		
		Specialty dentistry = new Specialty();
		dentistry.setDescription("dentistry");
		Specialty savedDentistry = specialtyService.save(dentistry);
		
		Specialty surgery = new Specialty();
		surgery.setDescription("surgery");
		Specialty savedSurgery = specialtyService.save(surgery);
		
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
	    mikesPet.setOwner(owner1);
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
	    fionasPet.setOwner(owner2);
	    owner2.getPets().add(fionasPet);
	    ownerService.save(owner2);
	     
	    System.out.println("Loaded owners");
	    
	    Visit catVisit = new Visit();
	    catVisit.setPet(fionasPet);
	    catVisit.setDate(LocalDate.now());
	    catVisit.setDescription("Sneezy kitty");
	    
	    visitService.save(catVisit);
	     
	    Vet vet1 = new Vet();
	    vet1.setFirstName("Sam");
	    vet1.setLastName("Axe");
	    vet1.getSpecialties().add(savedRadiology);

	    vetService.save(vet1);

	    Vet vet2 = new Vet();
	    vet2.setFirstName("Jessie");
	    vet2.setLastName("Porter");
	    vet2.getSpecialties().add(savedSurgery);

	    vetService.save(vet2);

	    System.out.println("Loaded Vets....");
	}

}
