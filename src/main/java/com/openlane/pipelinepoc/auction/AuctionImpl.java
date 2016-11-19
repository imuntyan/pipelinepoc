package com.openlane.pipelinepoc.auction;

import lombok.Data;

import java.util.UUID;

/**
 * Created by Igor.Muntyan on 11/18/2016.
 */
@Data
public class AuctionImpl implements Auction {

    private Integer startBid;
    private Integer currentBid;
    private final Integer increment;
    private final String id;



    public AuctionImpl(Integer startBid, Integer increment) throws BidRejectedException {
        if (startBid % increment > 0)
            throw new BidRejectedException(BidRejectedException.RejectionReason.INVALID_INCREMENT);
        this.startBid = startBid;
        this.increment = increment;
        this.id = UUID.randomUUID().toString();
    }

    public AuctionImpl(Integer startPrice) throws BidRejectedException {
        this(startPrice, 100);
    }



    @Override
    public synchronized void placeBid(Integer bid) throws BidRejectedException {
        if (bid > getCurrentBid())
            throw new BidRejectedException(BidRejectedException.RejectionReason.BELOW_MINIMUM);

        if (bid % getIncrement() > 0)
            throw new BidRejectedException(BidRejectedException.RejectionReason.INVALID_INCREMENT);

        setStartBid(getStartBid() + getIncrement());
    }

    @Override
    public String getId() {
        return id;
    }
}
