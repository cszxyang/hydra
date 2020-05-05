package com.github.cszxyang.hydra.protocol;

import lombok.Data;

/**
 * response of rpc service
 *
 * @author cszxyang
 * @since 2020-04-17
 */
@Data
public class HydraResponse {

    /** the id of the corresponding request message **/
    private String requestId;
    /** to receive the exception thrown by the server **/
    private Throwable throwable;
    /** the return value of the remote invocation interface **/
    private Object result;

}
