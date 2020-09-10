package fr.paris.lutece.plugins.workflow.modules.eudonetforms.business.rest.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import fr.paris.lutece.plugins.workflow.modules.eudonetforms.business.EudonetRestTaskConfig;

public class AuthenticateRequest implements Serializable
{
    private static final long serialVersionUID = -5434443675944148371L;

    private String _subscriberLogin;
    private String _subscriberPassword;
    private String _baseName;
    private String _userLogin;
    private String _userPassword;
    private String _userLang;
    private String _productName;
    
    public static AuthenticateRequest fromEudonetRestTaskConfig( EudonetRestTaskConfig config )
    {
        AuthenticateRequest request = new AuthenticateRequest( );
        request.setSubscriberLogin( config.getSubscriberLogin( ) );
        request.setSubscriberPassword( config.getSubscriberPassword( ) );
        request.setBaseName( config.getBaseName( ) );
        request.setUserLogin( config.getUserLogin( ) );
        request.setUserPassword( config.getUserPassword( ) );
        request.setUserLang( config.getUserLang( ) );
        request.setProductName( config.getProductName( ) );
        return request;
    }

    /**
     * @return the subscriberLogin
     */
    @JsonProperty("SubscriberLogin")
    public String getSubscriberLogin( )
    {
        return _subscriberLogin;
    }

    /**
     * @param subscriberLogin the subscriberLogin to set
     */
    public void setSubscriberLogin( String subscriberLogin )
    {
        _subscriberLogin = subscriberLogin;
    }

    /**
     * @return the subscriberPassword
     */
    @JsonProperty("SubscriberPassword")
    public String getSubscriberPassword( )
    {
        return _subscriberPassword;
    }

    /**
     * @param subscriberPassword the subscriberPassword to set
     */
    public void setSubscriberPassword( String subscriberPassword )
    {
        _subscriberPassword = subscriberPassword;
    }

    /**
     * @return the baseName
     */
    @JsonProperty("BaseName")
    public String getBaseName( )
    {
        return _baseName;
    }

    /**
     * @param baseName the baseName to set
     */
    public void setBaseName( String baseName )
    {
        _baseName = baseName;
    }

    /**
     * @return the userLogin
     */
    @JsonProperty("UserLogin")
    public String getUserLogin( )
    {
        return _userLogin;
    }

    /**
     * @param userLogin the userLogin to set
     */
    public void setUserLogin( String userLogin )
    {
        _userLogin = userLogin;
    }

    /**
     * @return the userPassword
     */
    @JsonProperty("UserPassword")
    public String getUserPassword( )
    {
        return _userPassword;
    }

    /**
     * @param userPassword the userPassword to set
     */
    public void setUserPassword( String userPassword )
    {
        _userPassword = userPassword;
    }

    /**
     * @return the userLang
     */
    @JsonProperty("UserLang")
    public String getUserLang( )
    {
        return _userLang;
    }

    /**
     * @param userLang the userLang to set
     */
    public void setUserLang( String userLang )
    {
        _userLang = userLang;
    }

    /**
     * @return the productName
     */
    @JsonProperty("ProductName")
    public String getProductName( )
    {
        return _productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName( String productName )
    {
        _productName = productName;
    }
    
}
