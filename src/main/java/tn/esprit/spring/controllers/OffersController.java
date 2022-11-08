package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tn.esprit.spring.entities.Articles;
import tn.esprit.spring.entities.Offers;
import tn.esprit.spring.services.IServiceOffers;

@EnableSwagger2
@Api(tags = "Offers Management")
@RestController
@RequestMapping("/api/offers")
public class OffersController {
@Autowired
IServiceOffers serviceOffers;

@PostMapping("/add-Offers")
@ResponseBody
public Offers addOffers(@RequestBody Offers o)
{
Offers of= serviceOffers.addOffers(o);
return of;
}
@DeleteMapping("/remove-Offers/{Offers-id}")
@ResponseBody
public void removeArticle(@PathVariable("Offers-id") int idOffer) {
	serviceOffers.deleteOffers(idOffer);
}

@ResponseBody
@GetMapping("/showOffers")
public List<Offers>getOffers() {
	List<Offers> listOffers = serviceOffers.retrieveAllOffers();
return listOffers;
}
@GetMapping("/showOffers/{offers-id}")
@ResponseBody
public Offers retrieveOffers(@PathVariable("offers-id") int idOffer) {
return serviceOffers.retrieveOffers(idOffer);
}
@PutMapping("/modify-article")
@ResponseBody
public Offers modifyOffers(@RequestBody Offers o) {
return serviceOffers.updateOffers(o);

}
@GetMapping("/affectOffers/{idOffer}/{idPartnership}")
public Offers affecterOffersPartnership( @PathVariable int idOffer,@PathVariable int idPartnership) {
	return serviceOffers.affecterOffersPartnership(idOffer, idPartnership);
}
@GetMapping("/bestOfferType")
public String bestOffType(){
	return serviceOffers.bestOffType();
}
@GetMapping("/modtUsedType")
public String mostUsedOff(){

	return serviceOffers.mostUsedOff();
}
}
