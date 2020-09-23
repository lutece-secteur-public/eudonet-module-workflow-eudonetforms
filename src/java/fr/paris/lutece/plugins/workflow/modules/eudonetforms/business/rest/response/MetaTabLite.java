package fr.paris.lutece.plugins.workflow.modules.eudonetforms.business.rest.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaTabLite implements Serializable
{

    private static final long serialVersionUID = -3581340682704589292L;
    
    private int _descId;
    private int _ednType;
    private String _label;
    
    /**
     * @return the descId
     */
    public int getDescId( )
    {
        return _descId;
    }
    
    /**
     * @param descId the descId to set
     */
    @JsonProperty("DescId")
    public void setDescId( int descId )
    {
        _descId = descId;
    }
    
    /**
     * @return the ednType
     */
    public int getEdnType( )
    {
        return _ednType;
    }
    
    /**
     * @param ednType the ednType to set
     */
    @JsonProperty("EdnType")
    public void setEdnType( int ednType )
    {
        _ednType = ednType;
    }
    
    /**
     * @return the label
     */
    public String getLabel( )
    {
        return _label;
    }
    
    /**
     * @param label the label to set
     */
    @JsonProperty("Label")
    public void setLabel( String label )
    {
        _label = label;
    }
    
}
