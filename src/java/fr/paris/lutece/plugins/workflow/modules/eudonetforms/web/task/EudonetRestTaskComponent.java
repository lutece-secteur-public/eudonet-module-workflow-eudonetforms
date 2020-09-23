package fr.paris.lutece.plugins.workflow.modules.eudonetforms.web.task;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import fr.paris.lutece.plugins.forms.business.FormHome;
import fr.paris.lutece.plugins.workflow.modules.eudonetforms.business.EudonetRestTaskConfig;
import fr.paris.lutece.plugins.workflow.modules.eudonetforms.service.IEudonetService;
import fr.paris.lutece.plugins.workflow.web.task.AbstractTaskComponent;
import fr.paris.lutece.plugins.workflowcore.service.task.ITask;
import fr.paris.lutece.portal.service.template.AppTemplateService;
import fr.paris.lutece.util.bean.BeanUtil;
import fr.paris.lutece.util.html.HtmlTemplate;

public class EudonetRestTaskComponent extends AbstractTaskComponent
{
    // Mark
    private static final String MARK_FORM_LIST = "form_list";
    private static final String MARK_CONFIG = "config";
    private static final String MARK_TEST_MSG = "test_message";
    
    // Parameters 
    private static final String PARAMETER_ACTION = "apply";
    
    // Actions
    private static final String ACTION_TEST = "test_config";
    
    // Templates
    private static final String TEMPLATE_TASK_EUDONET_REST_CONFIG = "admin/plugins/workflow/modules/eudonetforms/task_eudonetfoms_rest_config.html";

    @Inject
    private IEudonetService _eudonetService;
    
    private EudonetRestTaskConfig _config;
    
    private String _testMessage = null;
    
    @Override
    public String getDisplayTaskForm( int nIdResource, String strResourceType, HttpServletRequest request, Locale locale, ITask task )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getDisplayConfigForm( HttpServletRequest request, Locale locale, ITask task )
    {
        _config = getTaskConfigService( ).findByPrimaryKey( task.getId( ) );
        if ( _config == null )
        {
            _config = new EudonetRestTaskConfig( );
        }
        
        Map<String, Object> model = new HashMap<>( );
        model.put( MARK_FORM_LIST, FormHome.getFormsReferenceList( ) );
        model.put( MARK_CONFIG, _config );
        model.put( MARK_TEST_MSG, _testMessage );
        
        HtmlTemplate template = AppTemplateService.getTemplate( TEMPLATE_TASK_EUDONET_REST_CONFIG, locale, model );
        return template.getHtml( );
    }

    @Override
    public String getDisplayTaskInformation( int nIdHistory, HttpServletRequest request, Locale locale, ITask task )
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getTaskInformationXml( int nIdHistory, HttpServletRequest request, Locale locale, ITask task )
    {
        return null;
    }

    @Override
    public String doValidateTask( int nIdResource, String strResourceType, HttpServletRequest request, Locale locale, ITask task )
    {
        // TODO Auto-generated method stub
        return null;
    } 

    @Override
    public String doSaveConfig( HttpServletRequest request, Locale locale, ITask task )
    {
        String action = request.getParameter( PARAMETER_ACTION );
        if ( ACTION_TEST.equals( action ) )
        {
            EudonetRestTaskConfig config = new EudonetRestTaskConfig( );
            BeanUtil.populate( config, request );
            _testMessage = _eudonetService.testRestConnection( config, locale );
            return null;
        }
        return super.doSaveConfig( request, locale, task );
    }
}
