package fr.paris.lutece.plugins.workflow.modules.eudonetforms.business.rest.response;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class ResultAuth extends AbstractEudonetResponse<ResultDataAuth>
{
    private static final long serialVersionUID = 1386799247600057458L;

    @Override
    @JsonProperty("ResultData")
    public void setResultData( ResultDataAuth resultData )
    {
        _resultData = resultData;
    }
}
