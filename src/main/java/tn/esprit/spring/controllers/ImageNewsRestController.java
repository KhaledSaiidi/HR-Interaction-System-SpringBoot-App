package tn.esprit.spring.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


public class ImageNewsRestController {
	/*@Autowired
	private ImageNewsServiceImpl usix;
	  
	@Autowired
	IImageNewsService iusx;
	
	// http://localhost:9092/SpringMVC/servlet/uploaded
			@PostMapping("/uploadedn")
			public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		    String message = "";
		    try {
		    usix.addImage(file);
		    message = "Uploaded the file successfully: " + file.getOriginalFilename();
		    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		    }catch (Exception e) {
		    message = "Could not upload the file: " + file.getOriginalFilename() + "!";
		    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		    }
			}
		  
			// http://localhost:9091/SpringMVC/servlet/affect-image-to-user
			@PostMapping("/affect-image-to-news/{idimage}/{idnews}")
			@ResponseBody
			public void affectationImageToNews(@PathVariable("idimage") int idimage,@PathVariable("idnews")long idNe) throws IOException{
			usix.affectationImageToNews(idimage, idNe);
			}
			
			// http://localhost:9091/SpringMVC/servlet/retreive-all-image
			//@PreAuthorize("hasAuthority('ADMINISTRATOR')")
			@GetMapping ("/retreive-all-image-n")
			@ResponseBody
			public Iterable<ImageNews> retreiveAllImage(){
				return iusx.retreiveAllImage();
			
			}
}*/

}
