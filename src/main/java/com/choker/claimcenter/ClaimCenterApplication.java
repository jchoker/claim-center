package com.choker.claimcenter;

import com.choker.claimcenter.model.Patient;
import com.choker.claimcenter.repository.HospitalRepository;
import com.choker.claimcenter.repository.PatientRepository;
import com.choker.claimcenter.repository.PhysicianRepository;
import com.choker.claimcenter.model.Gender;
import com.choker.claimcenter.model.Hospital;
import com.choker.claimcenter.model.Physician;
import com.choker.claimcenter.repository.ClaimCenterRepositoryImpl;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = ClaimCenterRepositoryImpl.class)
@OpenAPIDefinition(info = @Info(title = "Claim Center API", version = "1.0", description = "Claim Center Information System"))
public class ClaimCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClaimCenterApplication.class, args);
	}

	// set-up data
	@Bean
	public CommandLineRunner loadPatients(PatientRepository repository) {
		return args -> {
			// if patient table is empty then create 2 sample rows
			if(repository.count() == 0) {
				{
					var patient = new Patient();
					patient.setName("First Last 1");
					patient.setCardNumber("abcdef0123456789");
					patient.setDob(LocalDate.of(1990, Month.JANUARY, 1));
					patient.setGender(Gender.MALE);
					repository.save(patient);
				}
				{
					var patient = new Patient();
					patient.setName("First Last 2");
					patient.setCardNumber("rstuvw0123456789");
					patient.setDob(LocalDate.of(2000, Month.JUNE, 1));
					patient.setGender(Gender.FEMALE);
					repository.save(patient);
				}
			}
		};
	}

	@Bean
	public CommandLineRunner loadHospitals(HospitalRepository repository) {
		return args -> {
			// if hospital table is empty then create 2 sample rows
			if(repository.count() == 0) {
				{
					var hospital = new Hospital();
					hospital.setName("ABC Hospital");
					repository.save(hospital);
				}
				{
					var hospital = new Hospital();
					hospital.setName("XYZ Hospital");
					repository.save(hospital);
				}
			}
		};
	}

	@Bean
	public CommandLineRunner loadPhysicians(PhysicianRepository repository) {
		return args -> {
			// if physician table is empty then create 2 sample rows
			if(repository.count() == 0) {
				{
					var physician = new Physician();
					physician.setName("Physician 1");
					repository.save(physician);
				}
				{
					var physician = new Physician();
					physician.setName("Physician 2");
					repository.save(physician);
				}
			}
		};
	}
}
