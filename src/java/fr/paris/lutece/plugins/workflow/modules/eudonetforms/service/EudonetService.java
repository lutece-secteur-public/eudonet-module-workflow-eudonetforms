package fr.paris.lutece.plugins.workflow.modules.eudonetforms.service;

import java.util.Locale;

import javax.inject.Inject;

import fr.paris.lutece.plugins.workflow.modules.eudonetforms.business.EudonetRestTaskConfig;
import fr.paris.lutece.portal.service.i18n.I18nService;
import fr.paris.lutece.portal.service.util.AppLogService;

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
            if ( !_eudonetRestService.disconnect( client, config ) )
            {
                AppLogService.info( "Token not invalidated" );
            }
        }
        else
        {
            testMessage = I18nService.getLocalizedString( MESSAGE_TEST_KO, locale );
        }
        return testMessage;
    }
}
