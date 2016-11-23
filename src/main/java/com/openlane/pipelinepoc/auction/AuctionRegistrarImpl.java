package com.openlane.pipelinepoc.auction;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Igor.Muntyan on 11/18/2016.
 */
@Component
public class AuctionRegistrarImpl implements AuctionRegistrar {

    Collection<Auction> auctions = new HashSet<>();
    Map<String, Auction> auctionMap = new HashMap<>();

    @Override
    public void addAuction(Auction auction) {
        auctions.add(auction);
        auctionMap.put(auction.getId(), auction);
    }

    @Override
    public void removeAuction(Auction auction) {
        auctions.remove(auction);
        auctionMap.remove(auction.getId());
    }

    @Override
    public int getAuctionCount() {
        return auctions.size();
    }

    @Override
    public Auction getAuction(String auctionId) {
        return auctionMap.get(auctionId);
    }

    @Override
    public Collection<Auction> getAuctions() {
        return auctions;
    }
}
