package fr.paris.lutece.plugins.workflow.modules.eudonetforms.business;

import fr.paris.lutece.plugins.workflow.modules.eudonetforms.service.task.EudonetRestTask;
import fr.paris.lutece.plugins.workflowcore.business.config.ITaskConfig;
import fr.paris.lutece.plugins.workflowcore.business.config.TaskConfig;

/**
 * {@link ITaskConfig} for {@link EudonetRestTask}
 */
public class EudonetRestTaskConfig extends TaskConfig
{
    private int _idTask;
    private int _idForm;
    private String _baseUrl;
    private String _subscriberLogin;
    private String _subscriberPassword;
    private String _baseName;
    private String _userLogin;
    private String _userPassword;
    private String _userLang;
    private String _productName;
    
    /**
     * @return the idTask
     */
    public int getIdTask( )
    {
        return _idTask;
    }
    /**
     * @param idTask the idTask to set
     */
    public void setIdTask( int idTask )
    {
        _idTask = idTask;
    }
    /**
     * @return the idForm
     */
    public int getIdForm( )
    {
        return _idForm;
    }
    /**
     * @param idForm the idForm to set
     */
    public void setIdForm( int idForm )
    {
        _idForm = idForm;
    }
    /**
     * @return the baseUrl
     */
    public String getBaseUrl( )
    {
        return _baseUrl;
    }
    /**
     * @param baseUrl the baseUrl to set
     */
    public void setBaseUrl( String baseUrl )
    {
        _baseUrl = baseUrl;
    }
    /**
     * @return the subscriberLogin
     */
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
