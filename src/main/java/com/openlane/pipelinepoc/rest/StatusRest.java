package com.openlane.pipelinepoc.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusRest {



        @RequestMapping(method = RequestMethod.GET)
        public ResponseEntity<?> auctionList() {

                HttpHeaders httpHeaders = new HttpHeaders();

                httpHeaders.setContentType(MediaType.TEXT_PLAIN);

                /* - Uncomment to add some additional headers.
                httpHeaders.setLocation(ServletUriComponentsBuilder
                                .fromCurrentRequest().path("/{id}")
                                .buildAndExpand(bids.getId()).toUri());
                */
                return new ResponseEntity<String>("OK", httpHeaders, HttpStatus.OK);
        }
}
