package fr.paris.lutece.plugins.workflow.modules.eudonetforms.business.rest.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultDataAuth implements Serializable
{
    private static final long serialVersionUID = 7156576024151645395L;

    private String _expirationDate;
    private String _serverDate;
    private String _token;
    private UserInfos _userInfos;
    private EudoFont _eudoFont;

    /**
     * @return the expirationDate
     */
    public String getExpirationDate( )
    {
        return _expirationDate;
    }

    /**
     * @param expirationDate
     *            the expirationDate to set
     */
    @JsonProperty( "ExpirationDate" )
    public void setExpirationDate( String expirationDate )
    {
        _expirationDate = expirationDate;
    }

    /**
     * @return the serverDate
     */
    public String getServerDate( )
    {
        return _serverDate;
    }

    /**
     * @param serverDate
     *            the serverDate to set
     */
    @JsonProperty( "ServerDate" )
    public void setServerDate( String serverDate )
    {
        _serverDate = serverDate;
    }

    /**
     * @return the token
     */
    public String getToken( )
    {
        return _token;
    }

    /**
     * @param token
     *            the token to set
     */
    @JsonProperty( "Token" )
    public void setToken( String token )
    {
        _token = token;
    }

    /**
     * @return the userInfos
     */
    public UserInfos getUserInfos( )
    {
        return _userInfos;
    }

    /**
     * @param userInfos
     *            the userInfos to set
     */
    @JsonProperty( "UserInfos" )
    public void setUserInfos( UserInfos userInfos )
    {
        _userInfos = userInfos;
    }

    /**
     * @return the eudoFont
     */
    public EudoFont getEudoFont( )
    {
        return _eudoFont;
    }

    /**
     * @param eudoFont
     *            the eudoFont to set
     */
    @JsonProperty( "EudoFont" )
    public void setEudoFont( EudoFont eudoFont )
    {
        _eudoFont = eudoFont;
    }

}
