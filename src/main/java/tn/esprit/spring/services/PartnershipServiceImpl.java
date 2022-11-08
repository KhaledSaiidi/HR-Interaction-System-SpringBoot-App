package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Events;
import tn.esprit.spring.entities.Partnership;
import tn.esprit.spring.repositories.PartnershipRepository;
@Service
public class PartnershipServiceImpl implements IServicePartnership {
@Autowired
PartnershipRepository partnershipRepository;
	@Override
	public List<Partnership> retrieveAllPartnership() {
		
		return (List<Partnership>)partnershipRepository.findAll();
	}

	@Override
	public Partnership addPartnership(Partnership p) {
		return partnershipRepository.save(p);
	}

	@Override
	public void deletePartnership(int id) {
		partnershipRepository.deleteById(id);

	}

	@Override
	public Partnership updatePartnership(Partnership p) {
		return partnershipRepository.save(p);
	}

	@Override
	public Partnership retrievePartnership(int id) {
	Partnership P = partnershipRepository.findById(id).get();
		return P;
	}

	public String bestAtt(){
		List<Partnership> partners = (List<Partnership>) partnershipRepository.findAll();
		Partnership partMax = null;
		int max = -1;
		for (Partnership p : partners){
			if(p.getEvents().size() > max){
				max = p.getEvents().size();
				partMax = p;
			}
		}
		return partMax.getNamePartnership();
		//WHO GOT MAX EVENTS
	}


}
