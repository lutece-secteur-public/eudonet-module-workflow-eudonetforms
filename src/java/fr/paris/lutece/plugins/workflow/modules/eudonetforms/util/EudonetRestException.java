package fr.paris.lutece.plugins.workflow.modules.eudonetforms.util;

public class EudonetRestException extends Exception
{
    private static final long serialVersionUID = 8536880164691802869L;

    public EudonetRestException( String message )
    {
        super( message );
    }
    
    public EudonetRestException( Throwable cause )
    {
       super( cause );
    }
}
