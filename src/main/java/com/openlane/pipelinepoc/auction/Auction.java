package com.openlane.pipelinepoc.auction;

/**
 * Created by Igor.Muntyan on 11/18/2016.
 */
public interface Auction {

    void placeBid(Integer bid) throws BidRejectedException;

    String getId();
}
