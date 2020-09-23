package fr.paris.lutece.plugins.workflow.modules.eudonetforms.service;

import java.util.Locale;

import fr.paris.lutece.plugins.workflow.modules.eudonetforms.business.EudonetRestTaskConfig;

public interface IEudonetService
{
    /**
     * Test if the configured connection works.
     * @param config
     * @param locale
     * @return 
     */
    String testRestConnection( EudonetRestTaskConfig config, Locale locale );
}
