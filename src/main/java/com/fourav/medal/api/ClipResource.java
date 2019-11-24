package com.fourav.medal.api;

import com.fourav.medal.conf.FourAVException;
import com.fourav.medal.service.ClipService;
import com.fourav.medal.util.ResponseObject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping("/api")
@CrossOrigin( origins = "*")
public class ClipResource {

    @Autowired
    ClipService clipService;

    private final Logger logger = getLogger(ClipResource.class);

    @GetMapping("/medalkey")
    public ResponseEntity<ResponseObject> getMedalKey() {
        try {
            logger.info( "Received for Request for Medal Key" );
            return new ResponseEntity<ResponseObject>(ResponseObject.success( clipService.getMedalKey()) , HttpStatus.OK );
        } catch (FourAVException e) {
            e.printStackTrace();
            return new ResponseEntity<ResponseObject>(ResponseObject.failure( e.getMessage() ) , HttpStatus.BAD_REQUEST );
        }
    }

    @GetMapping(value = "/videolink/{userId}")
    public ResponseEntity<ResponseObject> getVideoLink(@PathVariable("userId") String userId) {
        try {
            return new ResponseEntity<ResponseObject>(ResponseObject.success( clipService.getFeaturedVideo(userId)) , HttpStatus.OK );
        } catch (FourAVException e) {
            return new ResponseEntity<ResponseObject>(ResponseObject.failure( e.getMessage() ) , HttpStatus.BAD_REQUEST );
        }
    }
}
