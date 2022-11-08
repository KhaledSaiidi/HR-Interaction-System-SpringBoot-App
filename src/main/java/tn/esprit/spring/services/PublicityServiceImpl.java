package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Publicity;
import tn.esprit.spring.repositories.PublicityRepository;
@Service
public class PublicityServiceImpl implements IServicePublicity {
@Autowired
PublicityRepository publicityRepository; 
	@Override
	public List<Publicity> retrieveAllPublicity() {
		return (List<Publicity>) publicityRepository.findAll();
	}

	@Override
	public Publicity addPublicity(Publicity pub) {
		return publicityRepository.save(pub);
	}

	@Override
	public void deletePublicity(int id) {
publicityRepository.deleteById(id);
	}

	@Override
	public Publicity updatePublicity(Publicity pub) {
		return publicityRepository.save(pub); 
	}

	@Override
	public Publicity retrievePublicity(int id) {
		Publicity pub = publicityRepository.findById(id).get();
		return pub; 
	}

}
