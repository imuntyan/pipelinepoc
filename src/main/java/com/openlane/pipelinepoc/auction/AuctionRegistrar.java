package com.openlane.pipelinepoc.auction;

/**
 * Created by Igor.Muntyan on 11/18/2016.
 */
public interface AuctionRegistrar {
    String addAuction(Auction auction);
    void removeAuction(Auction auction);
    int getAuctionCount();
    Auction getAuction(String auctionId);
}
