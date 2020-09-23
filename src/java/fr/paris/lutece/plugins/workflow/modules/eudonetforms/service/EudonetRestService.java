package fr.paris.lutece.plugins.workflow.modules.eudonetforms.service;

import java.util.List;

import fr.paris.lutece.plugins.workflow.modules.eudonetforms.business.EudonetRestTaskConfig;
import fr.paris.lutece.plugins.workflow.modules.eudonetforms.business.rest.response.MetaTabLite;

public class EudonetRestService implements IEudonetRestService
{
    
    @Override
    public EudonetClient authenticate( EudonetRestTaskConfig config )
    {
        EudonetClient client = new EudonetClient( );
        client.createTokenAuthenticate( config );
        return client;
    }

    @Override
    public boolean disconnect( EudonetClient client, EudonetRestTaskConfig config )
    {
        return client.disconnectToken( config );
    }

    @Override
    public List<MetaTabLite> listTabs( EudonetClient client, EudonetRestTaskConfig config )
    {
        return client.listEudonetTables( config );
    }
}
