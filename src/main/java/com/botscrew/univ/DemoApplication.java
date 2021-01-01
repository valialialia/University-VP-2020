package com.botscrew.univ;

import com.botscrew.univ.models.enums.LectorDegreeEnum;
import com.botscrew.univ.models.impl.Department;
import com.botscrew.univ.models.impl.Lector;
import com.botscrew.univ.models.impl.LectorDegree;
import com.botscrew.univ.models.impl.LectorDepartment;
import com.botscrew.univ.repositories.DepartmentRepository;
import com.botscrew.univ.repositories.LectorDegreeRepository;
import com.botscrew.univ.repositories.LectorDepartmentRepository;
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
							 DepartmentRepository departmentRepository, LectorDepartmentRepository lectorDepartmentRepository) {
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

			Department departmentChemistry = new Department("Chemistry", lectorChris);
			Department departmentGeography = new Department("Geography", lectorTom);
			Department departmentMath = new Department("Math", lectorRobert);

			departmentRepository.save(departmentChemistry);
			departmentRepository.save(departmentGeography);
			departmentRepository.save(departmentMath);

			LectorDepartment lectorDepartment1 = new LectorDepartment(lectorTom, departmentGeography);
			LectorDepartment lectorDepartment2 = new LectorDepartment(lectorRobert, departmentMath);
			LectorDepartment lectorDepartment3 = new LectorDepartment(lectorRobert, departmentChemistry);
			LectorDepartment lectorDepartment4 = new LectorDepartment(lectorChris, departmentChemistry);
			LectorDepartment lectorDepartment5 = new LectorDepartment(lectorTom2, departmentMath);
			LectorDepartment lectorDepartment6 = new LectorDepartment(lectorTom2, departmentGeography);
			LectorDepartment lectorDepartment7 = new LectorDepartment(lectorMark, departmentGeography);
			LectorDepartment lectorDepartment8 = new LectorDepartment(lectorBen, departmentMath);
			LectorDepartment lectorDepartment9 = new LectorDepartment(lectorBen, departmentChemistry);
			LectorDepartment lectorDepartment10 = new LectorDepartment(lectorBen, departmentGeography);

			lectorDepartmentRepository.save(lectorDepartment1);
			lectorDepartmentRepository.save(lectorDepartment2);
			lectorDepartmentRepository.save(lectorDepartment3);
			lectorDepartmentRepository.save(lectorDepartment4);
			lectorDepartmentRepository.save(lectorDepartment5);
			lectorDepartmentRepository.save(lectorDepartment6);
			lectorDepartmentRepository.save(lectorDepartment7);
			lectorDepartmentRepository.save(lectorDepartment8);
			lectorDepartmentRepository.save(lectorDepartment9);
			lectorDepartmentRepository.save(lectorDepartment10);

		};
}

}
