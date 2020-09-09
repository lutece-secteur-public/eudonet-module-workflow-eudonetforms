package fr.paris.lutece.plugins.workflow.modules.eudonetforms.business;

import fr.paris.lutece.plugins.workflow.modules.eudonetforms.util.WorkflowEudonetFormsPlugin;
import fr.paris.lutece.plugins.workflowcore.business.config.ITaskConfigDAO;
import fr.paris.lutece.util.sql.DAOUtil;

public class EudonetRestTaskConfigDao implements ITaskConfigDAO<EudonetRestTaskConfig>
{
    private static final String QUERY_SELECT_ALL = "SELECT id_task, id_form, base_url, subscriber_login, subscriber_password, base_name, user_login, user_password, user_lang, product_name FROM workflow_task_eudonetforms_cf ";
    private static final String QUERY_SELECT = QUERY_SELECT_ALL + " WHERE id_task = ? ";
    private static final String QUERY_INSERT = "INSERT INTO workflow_task_eudonetforms_cf ( id_task, id_form, base_url, subscriber_login, subscriber_password, base_name, user_login, user_password, user_lang, product_name ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) ";
    private static final String QUERY_UPDATE = "UPDATE workflow_task_eudonetforms_cf SET id_task = ?, id_form = ?, base_url = ?, subscriber_login = ?, subscriber_password = ?, base_name = ?, user_login = ?, user_password = ?, user_lang = ?, product_name = ? WHERE id_task = ? ";
    private static final String QUERY_DELETE = "DELETE FROM workflow_task_eudonetforms_cf WHERE id_task = ? ";
            
    @Override
    public void insert( EudonetRestTaskConfig config )
    {
       try ( DAOUtil daoUtil = new DAOUtil( QUERY_INSERT, WorkflowEudonetFormsPlugin.getPlugin( ) ) )
       {
           int index = 0;
           daoUtil.setInt( ++index, config.getIdTask( ) );
           daoUtil.setInt( ++index, config.getIdForm( ) );
           daoUtil.setString( ++index, config.getBaseUrl( ) );
           daoUtil.setString( ++index, config.getSubscriberLogin( ) );
           daoUtil.setString( ++index, config.getSubscriberPassword( ) );
           daoUtil.setString( ++index, config.getBaseName( ) );
           daoUtil.setString( ++index, config.getUserLogin( ) );
           daoUtil.setString( ++index, config.getUserPassword( ) );
           daoUtil.setString( ++index, config.getUserLang( ) );
           daoUtil.setString( ++index, config.getProductName( ) );
           
           daoUtil.executeUpdate( );
       }
        
    }

    @Override
    public void store( EudonetRestTaskConfig config )
    {
        try ( DAOUtil daoUtil = new DAOUtil( QUERY_UPDATE, WorkflowEudonetFormsPlugin.getPlugin( ) ) )
        {
            int index = 0;
            daoUtil.setInt( ++index, config.getIdTask( ) );
            daoUtil.setInt( ++index, config.getIdForm( ) );
            daoUtil.setString( ++index, config.getBaseUrl( ) );
            daoUtil.setString( ++index, config.getSubscriberLogin( ) );
            daoUtil.setString( ++index, config.getSubscriberPassword( ) );
            daoUtil.setString( ++index, config.getBaseName( ) );
            daoUtil.setString( ++index, config.getUserLogin( ) );
            daoUtil.setString( ++index, config.getUserPassword( ) );
            daoUtil.setString( ++index, config.getUserLang( ) );
            daoUtil.setString( ++index, config.getProductName( ) );
            
            daoUtil.setInt( ++index, config.getIdTask( ) );
            daoUtil.executeUpdate( );
        }
        
    }

    @Override
    public EudonetRestTaskConfig load( int nIdTask )
    {
        EudonetRestTaskConfig config = null;
        try ( DAOUtil daoUtil = new DAOUtil( QUERY_SELECT, WorkflowEudonetFormsPlugin.getPlugin( ) ) )
        {
            int index = 0;
            daoUtil.setInt( ++index, nIdTask );
            
            daoUtil.executeQuery( );
            
            if ( daoUtil.next( ) )
            {
                config = dataToObject( daoUtil );
            }
        }
        return config;
    }

    @Override
    public void delete( int nIdTask )
    {
        try ( DAOUtil daoUtil = new DAOUtil( QUERY_DELETE, WorkflowEudonetFormsPlugin.getPlugin( ) ) )
        {
            int index = 0;
            daoUtil.setInt( ++index, nIdTask );
            
            daoUtil.executeUpdate( );
        }
    }

    private EudonetRestTaskConfig dataToObject( DAOUtil daoUtil )
    {
        int index = 0;
        
        EudonetRestTaskConfig config = new EudonetRestTaskConfig( );
        config.setIdTask( daoUtil.getInt( ++index ) );
        config.setIdForm( daoUtil.getInt( ++index ) );
        config.setBaseUrl( daoUtil.getString( ++index ) );
        config.setSubscriberLogin( daoUtil.getString( ++index ) );
        config.setSubscriberPassword( daoUtil.getString( ++index ) );
        config.setBaseName( daoUtil.getString( ++index ) );
        config.setUserLogin( daoUtil.getString( ++index ) );
        config.setUserPassword( daoUtil.getString( ++index ) );
        config.setUserLang( daoUtil.getString( ++index ) );
        config.setProductName( daoUtil.getString( ++index ) );
        return config;
    }
}
