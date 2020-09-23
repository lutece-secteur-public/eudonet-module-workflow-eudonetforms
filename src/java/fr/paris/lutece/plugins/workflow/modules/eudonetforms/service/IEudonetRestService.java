package fr.paris.lutece.plugins.workflow.modules.eudonetforms.service;

import java.util.List;

import fr.paris.lutece.plugins.workflow.modules.eudonetforms.business.EudonetRestTaskConfig;
import fr.paris.lutece.plugins.workflow.modules.eudonetforms.business.rest.response.MetaTabLite;

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
    
    /**
     * Get the list of tables
     * @param config
     * @param client
     * @return
     */
    List<MetaTabLite> listTabs( EudonetClient client, EudonetRestTaskConfig config);
}
