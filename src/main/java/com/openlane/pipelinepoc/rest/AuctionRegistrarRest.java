package com.openlane.pipelinepoc.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auctionList")
public class AuctionRegistrarRest {



        @RequestMapping(method = RequestMethod.GET)
        public ResponseEntity<?> auctionList() {

                HttpHeaders httpHeaders = new HttpHeaders();

                /* - Uncomment to add some additional headers.
                httpHeaders.setLocation(ServletUriComponentsBuilder
                                .fromCurrentRequest().path("/{id}")
                                .buildAndExpand(bids.getId()).toUri());
                */
                return new ResponseEntity<String>("<http><body>OK</body></http>", httpHeaders, HttpStatus.OK);
        }
}
