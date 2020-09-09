package fr.paris.lutece.plugins.workflow.modules.eudonetforms.business;

import fr.paris.lutece.plugins.workflowcore.business.config.ITaskConfigDAO;
import fr.paris.lutece.test.LuteceTestCase;

public class EudonetRestTaskConfigBusinessTest extends LuteceTestCase
{
    private ITaskConfigDAO<EudonetRestTaskConfig> _dao = new EudonetRestTaskConfigDao( );
    
    public void testCRUD( )
    {
        EudonetRestTaskConfig config = new EudonetRestTaskConfig( );
        config.setIdTask( 1 );
        config.setIdForm( 2 );
        config.setBaseUrl( "url" );
        config.setSubscriberLogin( "slogin" );
        config.setSubscriberPassword( "spwd" );
        config.setBaseName( "base" );
        config.setUserLogin( "ulogin" );
        config.setUserPassword( "upwd" );
        config.setUserLang( "ulang" );
        config.setProductName( "product" );
        
        _dao.insert( config );
        
        EudonetRestTaskConfig loaded = _dao.load( 1 );
        assertEquals( config.getIdTask( ), loaded.getIdTask( ) );
        assertEquals( config.getIdForm( ), loaded.getIdForm( ) );
        assertEquals( config.getBaseUrl( ), loaded.getBaseUrl( ) );
        assertEquals( config.getSubscriberLogin( ), loaded.getSubscriberLogin( ) );
        assertEquals( config.getSubscriberPassword( ), loaded.getSubscriberPassword( ) );
        assertEquals( config.getBaseName( ), loaded.getBaseName( ) );
        assertEquals( config.getUserLogin( ), loaded.getUserLogin( ) );
        assertEquals( config.getUserPassword( ), loaded.getUserPassword( ) );
        assertEquals( config.getUserLang( ), loaded.getUserLang( ) );
        assertEquals( config.getProductName( ), loaded.getProductName( ) );
        
        config.setIdForm( 22 );
        config.setBaseUrl( "url2" );
        config.setSubscriberLogin( "slogin2" );
        config.setSubscriberPassword( "spwd2" );
        config.setBaseName( "base2" );
        config.setUserLogin( "ulogin2" );
        config.setUserPassword( "upwd2" );
        config.setUserLang( "ulang2" );
        config.setProductName( "product2" );
        
        _dao.store( config );
        
        loaded = _dao.load( 1 );
        assertEquals( config.getIdTask( ), loaded.getIdTask( ) );
        assertEquals( config.getIdForm( ), loaded.getIdForm( ) );
        assertEquals( config.getBaseUrl( ), loaded.getBaseUrl( ) );
        assertEquals( config.getSubscriberLogin( ), loaded.getSubscriberLogin( ) );
        assertEquals( config.getSubscriberPassword( ), loaded.getSubscriberPassword( ) );
        assertEquals( config.getBaseName( ), loaded.getBaseName( ) );
        assertEquals( config.getUserLogin( ), loaded.getUserLogin( ) );
        assertEquals( config.getUserPassword( ), loaded.getUserPassword( ) );
        assertEquals( config.getUserLang( ), loaded.getUserLang( ) );
        assertEquals( config.getProductName( ), loaded.getProductName( ) );
        
        _dao.delete( 1 );
        
        loaded = _dao.load( 1 );
        assertNull( loaded );
    }
}
