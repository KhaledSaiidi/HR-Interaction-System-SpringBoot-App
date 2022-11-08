package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Subjects;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.SubjectsRepository;
@Service
public class SubjectsServiceImpl implements IServiceSubjects {
@Autowired
SubjectsRepository subjectRepository; 
	@Override
	public List<Subjects> retrieveAllSubjects() {
		return  (List<Subjects>) subjectRepository.findAll();
	}

	@Override
	public Subjects addSubjects(Subjects s) {
		return subjectRepository.save(s);
	}

	@Override
	public void deleteSubjects(Subjects subjects) {
		subjectRepository.delete(subjects);
	}

	@Override
	public Subjects updateSubjects(Subjects s) {
		return subjectRepository.save(s); 
	}

	@Override
	public Subjects retrieveSubjects(int id) {
		Subjects s = subjectRepository.findById(id).get();
		return s;
	}

}
