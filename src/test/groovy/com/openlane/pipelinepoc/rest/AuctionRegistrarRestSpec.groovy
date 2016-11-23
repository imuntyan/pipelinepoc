package com.openlane.pipelinepoc.rest

import com.openlane.pipelinepoc.auction.Auction
import com.openlane.pipelinepoc.auction.AuctionImpl
import com.openlane.pipelinepoc.auction.AuctionRegistrar


/**
 * Created by Igor.Muntyan on 11/18/2016.
 */
import spock.lang.Specification

class AuctionRegistrarRestSpec extends Specification {

    AuctionRegistrar auctionRegistrar = Mock (AuctionRegistrar)
    AuctionRegistrarRest rest = new AuctionRegistrarRest()

    void setup() {

        auctionRegistrar.addAuction(new AuctionImpl(10000,100))

        // watch this - it can set the private field >:O
        rest.auctionRegistrar = auctionRegistrar
    }


    def "test auction list rest endpoint is calling the right method"() {

        when:
        rest.auctionList()

        then:
        1 * auctionRegistrar.getAuctions()
    }
}