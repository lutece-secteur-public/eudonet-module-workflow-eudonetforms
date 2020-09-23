package fr.paris.lutece.plugins.workflow.modules.eudonetforms.business.rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetaInfosListTabsResponse extends AbstractEudonetResponse<MetaTabLiteLst> 
{
    private static final long serialVersionUID = -1255395347044636951L;

    @Override
    @JsonProperty("ResultMetaData")
    public void setResultData( MetaTabLiteLst resultData )
    {
        _resultData = resultData;
    }

}
