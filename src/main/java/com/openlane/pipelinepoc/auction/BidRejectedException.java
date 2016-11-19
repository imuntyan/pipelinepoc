package com.openlane.pipelinepoc.auction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Igor.Muntyan on 11/18/2016.
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BidRejectedException extends Exception {
    public static enum RejectionReason {
        BELOW_MINIMUM, INVALID_INCREMENT
    }


    RejectionReason reason;
}
