package fr.paris.lutece.plugins.workflow.modules.eudonetforms.business.rest.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EudoFont implements Serializable
{
    private static final long serialVersionUID = 727523520674351635L;

    private String _eot;
    private String _svg;
    private String _ttf;
    private String _woff;
    private String _woff2;
    private String _css;

    /**
     * @return the eot
     */
    public String getEot( )
    {
        return _eot;
    }

    /**
     * @param eot the eot to set
     */
    @JsonProperty("Eot")
    public void setEot( String eot )
    {
        _eot = eot;
    }

    /**
     * @return the svg
     */
    public String getSvg( )
    {
        return _svg;
    }

    /**
     * @param svg the svg to set
     */
    @JsonProperty("Svg")
    public void setSvg( String svg )
    {
        _svg = svg;
    }

    /**
     * @return the ttf
     */
    public String getTtf( )
    {
        return _ttf;
    }

    /**
     * @param ttf the ttf to set
     */
    @JsonProperty("Ttf")
    public void setTtf( String ttf )
    {
        _ttf = ttf;
    }

    /**
     * @return the woff
     */
    public String getWoff( )
    {
        return _woff;
    }

    /**
     * @param woff the woff to set
     */
    @JsonProperty("Woff")
    public void setWoff( String woff )
    {
        _woff = woff;
    }

    /**
     * @return the woff2
     */
    public String getWoff2( )
    {
        return _woff2;
    }

    /**
     * @param woff2 the woff2 to set
     */
    @JsonProperty("Woff2")
    public void setWoff2( String woff2 )
    {
        _woff2 = woff2;
    }

    /**
     * @return the css
     */
    public String getCss( )
    {
        return _css;
    }

    /**
     * @param css the css to set
     */
    @JsonProperty("Css")
    public void setCss( String css )
    {
        _css = css;
    }
    
}
