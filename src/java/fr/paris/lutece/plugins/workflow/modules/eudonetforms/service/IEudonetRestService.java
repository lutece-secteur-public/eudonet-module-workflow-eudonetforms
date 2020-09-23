package fr.paris.lutece.plugins.workflow.modules.eudonetforms.service;

import fr.paris.lutece.plugins.workflow.modules.eudonetforms.business.EudonetRestTaskConfig;

public interface IEudonetRestService
{
    /**
     * Ask an authentication token to the rest service. 
     * @param config
     * @return the client containing the token
     */
    EudonetClient authenticate( EudonetRestTaskConfig config );
    
    /**
     * Ask to revoke the token contained in the client
     * @param token
     */
    boolean disconnect( EudonetClient client, EudonetRestTaskConfig config );
}
