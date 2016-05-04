package polytech.si3.requests;

import java.io.Serializable;

/**
 * An empty request
 * 
 * @author Gunther
 *
 */
public interface Request extends Serializable {

    public RequestType requestType();
}
