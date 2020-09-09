package fr.paris.lutece.plugins.workflow.modules.eudonetforms.service.task;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.paris.lutece.plugins.workflowcore.service.task.Task;
import fr.paris.lutece.portal.service.i18n.I18nService;

public class EudonetRestTask extends Task 
{

    @Override
    public void processTask( int nIdResourceHistory, HttpServletRequest request, Locale locale )
    {
        // TODO Auto-generated method stub
    }

    @Override
    public String getTitle( Locale locale )
    {
        return I18nService.getLocalizedString( getTaskType( ).getTitleI18nKey( ), locale );
    }

    @Override
    public Map<String, String> getTaskFormEntries( Locale locale )
    {
        return null;
    }

    @Override
    public void init( )
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void doRemoveTaskInformation( int nIdHistory )
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void doRemoveConfig( )
    {
        // TODO Auto-generated method stub
    }

}
