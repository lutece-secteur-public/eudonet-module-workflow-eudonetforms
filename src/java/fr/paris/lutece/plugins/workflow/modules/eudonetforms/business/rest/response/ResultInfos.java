package fr.paris.lutece.plugins.workflow.modules.eudonetforms.business.rest.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultInfos implements Serializable
{
    private static final long serialVersionUID = -3156756982472423742L;

    private boolean _success;
    private String _errorMessage;
    private String _apiMessage;
    private int _errorNumber;

    /**
     * @return the success
     */
    public boolean isSuccess( )
    {
        return _success;
    }

    /**
     * @param success the success to set
     */
    @JsonProperty("Success")
    public void setSuccess( boolean success )
    {
        _success = success;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage( )
    {
        return _errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    @JsonProperty("ErrorMessage")
    public void setErrorMessage( String errorMessage )
    {
        _errorMessage = errorMessage;
    }

    /**
     * @return the apiMessage
     */
    public String getApiMessage( )
    {
        return _apiMessage;
    }

    /**
     * @param apiMessage the apiMessage to set
     */
    @JsonProperty("ApiMessage")
    public void setApiMessage( String apiMessage )
    {
        _apiMessage = apiMessage;
    }

    /**
     * @return the errorNumber
     */
    public int getErrorNumber( )
    {
        return _errorNumber;
    }

    /**
     * @param errorNumber the errorNumber to set
     */
    @JsonProperty("ErrorNumber")
    public void setErrorNumber( int errorNumber )
    {
        _errorNumber = errorNumber;
    }
    
}
