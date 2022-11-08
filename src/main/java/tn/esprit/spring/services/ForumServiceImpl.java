package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Forum;
import tn.esprit.spring.repositories.FroumRepository;
@Service
public class ForumServiceImpl implements IServiceForum {


@Autowired
FroumRepository froumRepository;

	@Override
	public List<Forum> retrieveAllForum() {
		
	return (List<Forum>) froumRepository.findAll();
	}

	@Override
	public Forum addForum(Forum f) {
		 return froumRepository.save(f);
	}

	@Override
	public void deleteForum(int id) {
		froumRepository.deleteById(id);

	}

	@Override
	public Forum updateForum(Forum f) {
		
		return froumRepository.save(f);
	}

	@Override
	public Forum retrieveForum(int id) {
		Forum F = froumRepository.findById(id).get();
		return F;
	}

}
