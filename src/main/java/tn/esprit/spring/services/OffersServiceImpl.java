package tn.esprit.spring.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Events;
import tn.esprit.spring.entities.OfferType;
import tn.esprit.spring.entities.Offers;
import tn.esprit.spring.entities.Partnership;
import tn.esprit.spring.repositories.OfferRepository;
import tn.esprit.spring.repositories.PartnershipRepository;
@Service
@Slf4j
public class OffersServiceImpl implements IServiceOffers {
@Autowired
OfferRepository offerRepository;
@Autowired
PartnershipRepository partnershipRepository; 
	@Override
	public List<Offers> retrieveAllOffers() {
		
		return (List<Offers>)offerRepository.findAll();
	}

	@Override
	public Offers addOffers(Offers o) {
		
		return offerRepository.save(o); 
	}

	@Override
	public void deleteOffers(int id) {
		offerRepository.deleteById(id);

	}

	@Override
	public Offers updateOffers(Offers o) {
		
		return offerRepository.save(o);
	}

	@Override
	public Offers retrieveOffers(int id) {
		Offers O = offerRepository.findById(id).get();
		return O;
	}

	@Override
	public Offers affecterOffersPartnership(int idOffer, int idPartnership) {
		
		   Offers ev=offerRepository.findById(idOffer).get();
		    Partnership us=partnershipRepository.findById(idPartnership).get();
		    ev.setPartnerships(us);;

		    return offerRepository.save(ev);
	}


	public String bestOffType() {
		List<Offers> offers = (List<Offers>) offerRepository.findAll();
		List<OfferType> types = new ArrayList<>();
		for (Offers o : offers) {
			types.add(o.getOfferType());
		}
		HashMap hm = new HashMap();
		hm.put("Black_Friday", types.stream().filter(t -> t.equals("Black_Friday")).count());
		hm.put("Happy_hours", types.stream().filter(t -> t.equals("Happy_hours")).count());
		hm.put("Happy_Days", types.stream().filter(t -> t.equals("Happy_Days")).count());
		hm.put("Weekend_OFFERS", types.stream().filter(t -> t.equals("Weekend_OFFERS")).count());
		List<Integer> values = new ArrayList<>();
		Collection off = hm.values();
		for (Object i : off) {
			values.add((Integer) hm.get(i));
		}
		Collections.sort(values);
		String offerTyp = null;
		for (Object key : hm.keySet()) {
			if (hm.get(key) == values.get(0)) {
				offerTyp = (String) key;
			}
		}
		return offerTyp;
	}


	public String mostUsedOff(){
		List<Offers> offers = (List<Offers>) offerRepository.findAll();
		Offers offerMax = null;
		int max = -1;
		for (Offers o : offers){
			if(o.getUsers().size() > max){
				max = o.getUsers().size();
				offerMax = o;
			}
		}
		return offerMax.getNameOffer();
	}





// @Override
	
//@Scheduled(cron = "*/30 * * * * *")
	
/*	public void OfferNumberPerPartner() {
			log.info("--- Black_Friday Offers :"  + offerRepository.numberByOffer(OfferType.Black_Friday));
			log.info("--- Happy_hours Offers : " + offerRepository.numberByOffer(OfferType.Happy_hours));
			log.info("--- Happy_Days Offers : " + offerRepository.numberByOffer(OfferType.Happy_Days));
			log.info("--- Weekend_OFFERS Offers : " + offerRepository.numberByOffer(OfferType.Weekend_OFFERS));

		}	*/
	
	
	}


