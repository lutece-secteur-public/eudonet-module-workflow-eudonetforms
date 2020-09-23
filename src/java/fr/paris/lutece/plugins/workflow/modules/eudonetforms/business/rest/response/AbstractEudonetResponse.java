package fr.paris.lutece.plugins.workflow.modules.eudonetforms.business.rest.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractEudonetResponse<D> implements Serializable
{
    private static final long serialVersionUID = -439852082689037533L;

    private ResultInfos _resultInfos;
    protected D _resultData;

    /**
     * @return the resultInfos
     */
    public ResultInfos getResultInfos( )
    {
        return _resultInfos;
    }

    /**
     * @param resultInfos the resultInfos to set
     */
    @JsonProperty("ResultInfos")
    public void setResultInfos( ResultInfos resultInfos )
    {
        _resultInfos = resultInfos;
    }

    /**
     * @return the resultData
     */
    public D getResultData( )
    {
        return _resultData;
    }

    /**
     * @param resultData the resultData to set
     */
    public abstract void setResultData( D resultData );
}
