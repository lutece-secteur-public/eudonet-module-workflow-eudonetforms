package fr.paris.lutece.plugins.workflow.modules.eudonetforms.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.springframework.http.HttpMethod;

import fr.paris.lutece.plugins.workflow.modules.eudonetforms.business.EudonetRestTaskConfig;
import fr.paris.lutece.plugins.workflow.modules.eudonetforms.business.rest.request.AuthenticateRequest;
import fr.paris.lutece.plugins.workflow.modules.eudonetforms.business.rest.response.AbstractEudonetResponse;
import fr.paris.lutece.plugins.workflow.modules.eudonetforms.business.rest.response.MetaInfosListTabsResponse;
import fr.paris.lutece.plugins.workflow.modules.eudonetforms.business.rest.response.MetaTabLite;
import fr.paris.lutece.plugins.workflow.modules.eudonetforms.business.rest.response.ResultAuth;
import fr.paris.lutece.plugins.workflow.modules.eudonetforms.business.rest.response.ResultDisconnect;
import fr.paris.lutece.plugins.workflow.modules.eudonetforms.util.EudonetRestException;
import fr.paris.lutece.portal.service.util.AppLogService;

/**
 * Client to call the eudonet rest services
 */
public class EudonetClient
{
    private static final String ERROR_EUDONET = "Error Eudonet: ";
    
    // PATH
    private static final String PATH_AUTHENTICATE = "Authenticate";
    private static final String PATH_TOKEN = "Token";
    private static final String PATH_DISCONNECT = "Disconnect";
    private static final String PATH_META_INFOS = "MetaInfos";
    private static final String PATH_LIST_TABS = "ListTabs/";
    
    // HEADER
    private static final String HEADER_X_AUTH = "x-auth";
    
    private final Client _client;
    
    private String _token;
    
    public EudonetClient( )
    {
        _client = ClientBuilder.newClient();
    }
    
    /**
     * Ask the API to invalidate the given token
     * @param token
     * @return
     */
    public boolean disconnectToken( EudonetRestTaskConfig config )
    {
        WebTarget target = _client.target( config.getBaseUrl( ) ).path( PATH_AUTHENTICATE ).path( PATH_DISCONNECT );
        
        Map<String, String> headerMap = new HashMap<>( );
        headerMap.put( HEADER_X_AUTH, _token );
        
        try {
            sendRequest( target, ResultDisconnect.class, HttpMethod.DELETE, headerMap );
            _token = null;
            return true;
        }
        catch ( EudonetRestException e )
        {
            AppLogService.error( ERROR_EUDONET + e.getMessage( ) );
            return false; 
        }
    }
    
    /**
     * Rest call to the Authenticate API.
     * @param config
     * @return the authentication token give byt the API
     */
    public void createTokenAuthenticate( EudonetRestTaskConfig config )
    {
        WebTarget target = _client.target( config.getBaseUrl( ) ).path( PATH_AUTHENTICATE ).path( PATH_TOKEN );
        Entity<AuthenticateRequest> jsonRequest = Entity.json( AuthenticateRequest.fromEudonetRestTaskConfig( config ) );
        
        try {
            ResultAuth response = sendRequest( target, jsonRequest, ResultAuth.class, HttpMethod.POST );
            _token = response.getResultData( ).getToken( );
        }
        catch ( EudonetRestException e )
        {
            AppLogService.error( ERROR_EUDONET + e.getMessage( ) );
        }
    }
    
    private <T extends AbstractEudonetResponse<?>> T sendRequest( WebTarget target, Class<T> reponseDataClass, HttpMethod method, Map<String, String> headerMap ) throws EudonetRestException
    {
        return sendRequest( target, null, reponseDataClass, method, headerMap );
    }
    
    private <T extends AbstractEudonetResponse<?>> T sendRequest( WebTarget target, Entity<?> jsonRequest, Class<T> reponseDataClass, HttpMethod method ) throws EudonetRestException
    {
        return sendRequest( target, jsonRequest, reponseDataClass, method, new HashMap<>( ) );
    }
    
    private <T extends AbstractEudonetResponse<?>> T sendRequest( WebTarget target, Entity<?> jsonRequest, Class<T> reponseDataClass, HttpMethod method, Map<String, String> headerMap ) throws EudonetRestException
    {
        T response = null;
        Builder builder = target.request( MediaType.APPLICATION_JSON );
        for ( Entry<String, String> header : headerMap.entrySet( ) )
        {
            builder = builder.header( header.getKey( ), header.getValue( ) );
        }
        try {
            switch( method )
            {
                case POST:
                    response = builder.post( jsonRequest, reponseDataClass );
                    break;
                case DELETE:
                    response = builder.delete( reponseDataClass );
                    break;
                case GET:
                    response = builder.get( reponseDataClass );
                    break;
                default:
                    break;
            }
        }
        catch ( ProcessingException | WebApplicationException e )
        {
            throw new EudonetRestException( e );
        }
        if ( response == null )
        {
            throw new EudonetRestException( "Unknown error" );
        }
        if ( !response.getResultInfos( ).isSuccess( ) )
        {
            throw new EudonetRestException( response.getResultInfos( ).getErrorMessage( ) );
        }
        return response;
    }
    
    public boolean hasToken( )
    {
        return _token != null;
    }
    
    /**
     * Rest call to get the list of eudonet tables.
     * @param config
     * @param token
     * @return
     */
    public List<MetaTabLite> listEudonetTables( EudonetRestTaskConfig config )
    {
        WebTarget target = _client.target( config.getBaseUrl( ) ).path( PATH_META_INFOS ).path( PATH_LIST_TABS );
        
        Map<String, String> headerMap = new HashMap<>( );
        headerMap.put( HEADER_X_AUTH, _token );
        
        try {
            MetaInfosListTabsResponse response = sendRequest( target, MetaInfosListTabsResponse.class, HttpMethod.GET, headerMap );
            return response.getResultData( ).getMetaTabLites( );
        }
        catch ( EudonetRestException e )
        {
            AppLogService.error( ERROR_EUDONET + e.getMessage( ) );
            return new ArrayList<>( ); 
        }
    }
}
