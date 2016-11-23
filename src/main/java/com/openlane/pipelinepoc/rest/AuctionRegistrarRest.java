package com.openlane.pipelinepoc.rest;

import com.openlane.pipelinepoc.auction.Auction;
import com.openlane.pipelinepoc.auction.AuctionRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/auctionList")
public class AuctionRegistrarRest {


        @Autowired
        private AuctionRegistrar auctionRegistrar;


        @RequestMapping(method = RequestMethod.GET)
        public ResponseEntity<?> auctionList() {

                HttpHeaders httpHeaders = new HttpHeaders();

                /* - Uncomment to add some additional headers.
                httpHeaders.setLocation(ServletUriComponentsBuilder
                                .fromCurrentRequest().path("/{id}")
                                .buildAndExpand(bids.getId()).toUri());
                */

                Collection<Auction> auctions = auctionRegistrar.getAuctions();

                return new ResponseEntity<Collection<Auction>>(auctions, httpHeaders, HttpStatus.OK);
        }
}
