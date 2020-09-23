package fr.paris.lutece.plugins.workflow.modules.eudonetforms.business.rest.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaTabLiteLst implements Serializable
{
    private static final long serialVersionUID = 994173063244852522L;
    
    private List<MetaTabLite> _metaTabLites;

    /**
     * @return the metaTabLites
     */
    public List<MetaTabLite> getMetaTabLites( )
    {
        return _metaTabLites;
    }

    /**
     * @param metaTabLites the metaTabLites to set
     */
    @JsonProperty("Tables")
    public void setMetaTabLites( List<MetaTabLite> metaTabLites )
    {
        _metaTabLites = metaTabLites;
    }
}
