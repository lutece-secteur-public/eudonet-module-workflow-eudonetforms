package fr.paris.lutece.plugins.workflow.modules.eudonetforms.service;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import fr.paris.lutece.plugins.workflow.modules.eudonetforms.business.EudonetRestTaskConfig;
import fr.paris.lutece.plugins.workflow.modules.eudonetforms.business.rest.response.MetaTabLite;
import fr.paris.lutece.portal.service.i18n.I18nService;
import fr.paris.lutece.portal.service.util.AppLogService;
import fr.paris.lutece.util.ReferenceList;

public class EudonetService implements IEudonetService
{
    // Messages
    private static final String MESSAGE_TEST_OK = "module.workflow.eudonetforms.task.eudonetRest.config.test.ok";
    private static final String MESSAGE_TEST_KO = "module.workflow.eudonetforms.task.eudonetRest.config.test.ko";
    
    @Inject
    private IEudonetRestService _eudonetRestService;
    
    @Override
    public String testRestConnection( EudonetRestTaskConfig config, Locale locale )
    {
        String testMessage;
        EudonetClient client = _eudonetRestService.authenticate( config );
        if ( client.hasToken( ) )
        {
            testMessage = I18nService.getLocalizedString( MESSAGE_TEST_OK, locale );
            disconnect( client, config );
        }
        else
        {
            testMessage = I18nService.getLocalizedString( MESSAGE_TEST_KO, locale );
        }
        return testMessage;
    }
    
    @Override
    public ReferenceList getListEudonetTables( EudonetRestTaskConfig config )
    {
        ReferenceList list = new ReferenceList( );
        list.addItem( -1, "" );
        
        EudonetClient client = _eudonetRestService.authenticate( config );
        if ( !client.hasToken( ) )
        {
            return list;
        }
        
        List<MetaTabLite> listRest = _eudonetRestService.listTabs( client, config );
        for ( MetaTabLite tab : listRest )
        {
            list.addItem( tab.getDescId( ), tab.getLabel( ) );
        }
        disconnect( client, config );
        return list;
    }
    
    private void disconnect( EudonetClient client, EudonetRestTaskConfig config )
    {
        if ( !_eudonetRestService.disconnect( client, config ) )
        {
            AppLogService.info( "Token not invalidated" );
        }
    }
}
