package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Publicity;

public interface IServicePublicity {

	List<Publicity> retrieveAllPublicity();

	Publicity addPublicity (Publicity pub);

	void deletePublicity (int id);

	Publicity updatePublicity (Publicity pub);

	Publicity retrievePublicity (int id);
}