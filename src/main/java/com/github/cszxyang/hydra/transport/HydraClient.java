package com.github.cszxyang.hydra.transport;

import com.github.cszxyang.hydra.protocol.HydraRequest;
import com.github.cszxyang.hydra.protocol.HydraResponse;

/**
 * RPC transportation client
 *
 * @author cszxyang
 */
public interface HydraClient {

    /**
     * send a rpc request message asynchronously
     *
     * @param request the request message
     * @return the response
     */
    HydraResponse send(HydraRequest request);

}