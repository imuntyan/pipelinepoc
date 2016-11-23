package com.openlane.pipelinepoc.auction;

import java.util.Collection;

/**
 * Created by Igor.Muntyan on 11/18/2016.
 */
public interface AuctionRegistrar {
    void addAuction(Auction auction);
    void removeAuction(Auction auction);
    int getAuctionCount();
    Auction getAuction(String auctionId);
    Collection<Auction> getAuctions();
}
