package com.botscrew.univ;

import com.botscrew.univ.models.enums.LectorDegreeEnum;
import com.botscrew.univ.models.impl.Departament;
import com.botscrew.univ.models.impl.Lector;
import com.botscrew.univ.models.impl.LectorDegree;
import com.botscrew.univ.models.impl.LectorDepartament;
import com.botscrew.univ.repositories.DepartamentRepository;
import com.botscrew.univ.repositories.LectorDegreeRepository;
import com.botscrew.univ.repositories.LectorDepartamentRepository;
import com.botscrew.univ.repositories.LectorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

@Bean
	CommandLineRunner runner(LectorDegreeRepository lectorDegreeRepository, LectorRepository lectorRepository,
							 DepartamentRepository departamentRepository, LectorDepartamentRepository lectorDepartamentRepository) {
		return args -> {
			LectorDegree assistantLectorDegree = new LectorDegree(LectorDegreeEnum.ASSISTANT.toString());
			LectorDegree associateProfessorLectorDegree = new LectorDegree(LectorDegreeEnum.ASSOCIATE_PROFESSOR.toString());
			LectorDegree professorLectorDegree = new LectorDegree(LectorDegreeEnum.PROFESSOR.toString());

			lectorDegreeRepository.save(assistantLectorDegree);
			lectorDegreeRepository.save(associateProfessorLectorDegree);
			lectorDegreeRepository.save(professorLectorDegree);

			Lector lectorTom = new Lector("Tom", "Holland", assistantLectorDegree, 12000);
			Lector lectorRobert = new Lector("Robert","Downey", associateProfessorLectorDegree, 15000);
			Lector lectorChris = new Lector("Chris", "Hemsworth", professorLectorDegree, 18000);
			Lector lectorTom2 = new Lector("Tom", "Hiddleston", assistantLectorDegree, 13000);
			Lector lectorMark = new Lector("Mark", "Ruffalo", professorLectorDegree, 16000);
			Lector lectorBen = new Lector("Ben", "Cumberbatch", associateProfessorLectorDegree, 17000);

			lectorRepository.save(lectorTom);
			lectorRepository.save(lectorRobert);
			lectorRepository.save(lectorChris);
			lectorRepository.save(lectorTom2);
			lectorRepository.save(lectorMark);
			lectorRepository.save(lectorBen);

			Departament departamentChemistry = new Departament("Chemistry", lectorChris);
			Departament departamentGeography = new Departament("Geography", lectorTom);
			Departament departamentMath = new Departament("Math", lectorRobert);

			departamentRepository.save(departamentChemistry);
			departamentRepository.save(departamentGeography);
			departamentRepository.save(departamentMath);

			LectorDepartament lectorDepartament1 = new LectorDepartament(lectorTom, departamentGeography);
			LectorDepartament lectorDepartament2 = new LectorDepartament(lectorRobert, departamentMath);
			LectorDepartament lectorDepartament3 = new LectorDepartament(lectorRobert, departamentChemistry);
			LectorDepartament lectorDepartament4 = new LectorDepartament(lectorChris, departamentChemistry);
			LectorDepartament lectorDepartament5 = new LectorDepartament(lectorTom2, departamentMath);
			LectorDepartament lectorDepartament6 = new LectorDepartament(lectorTom2, departamentGeography);
			LectorDepartament lectorDepartament7 = new LectorDepartament(lectorMark, departamentGeography);
			LectorDepartament lectorDepartament8 = new LectorDepartament(lectorBen, departamentMath);
			LectorDepartament lectorDepartament9 = new LectorDepartament(lectorBen, departamentChemistry);
			LectorDepartament lectorDepartament10 = new LectorDepartament(lectorBen, departamentGeography);

			lectorDepartamentRepository.save(lectorDepartament1);
			lectorDepartamentRepository.save(lectorDepartament2);
			lectorDepartamentRepository.save(lectorDepartament3);
			lectorDepartamentRepository.save(lectorDepartament4);
			lectorDepartamentRepository.save(lectorDepartament5);
			lectorDepartamentRepository.save(lectorDepartament6);
			lectorDepartamentRepository.save(lectorDepartament7);
			lectorDepartamentRepository.save(lectorDepartament8);
			lectorDepartamentRepository.save(lectorDepartament9);
			lectorDepartamentRepository.save(lectorDepartament10);

		};
}

}
