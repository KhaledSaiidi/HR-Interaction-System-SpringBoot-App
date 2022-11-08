package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Subjects;

public interface IServiceSubjects {


	List<Subjects> retrieveAllSubjects();

	Subjects addSubjects (Subjects s);

	void deleteSubjects (Subjects id);

	Subjects updateSubjects (Subjects s);

	Subjects retrieveSubjects (int id);
}
