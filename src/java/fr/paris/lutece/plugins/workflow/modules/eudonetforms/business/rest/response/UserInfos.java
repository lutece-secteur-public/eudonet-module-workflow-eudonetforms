package fr.paris.lutece.plugins.workflow.modules.eudonetforms.business.rest.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfos implements Serializable
{
    private static final long serialVersionUID = -5872454700904379061L;

    private String _userAvatarUrl;
    private int _userId;
    private int _groupId;
    private String _userDisplayName;

    /**
     * @return the userAvatarUrl
     */
    public String getUserAvatarUrl( )
    {
        return _userAvatarUrl;
    }

    /**
     * @param userAvatarUrl the userAvatarUrl to set
     */
    @JsonProperty("UserAvatarUrl")
    public void setUserAvatarUrl( String userAvatarUrl )
    {
        _userAvatarUrl = userAvatarUrl;
    }

    /**
     * @return the userId
     */
    public int getUserId( )
    {
        return _userId;
    }

    /**
     * @param userId the userId to set
     */
    @JsonProperty("UserId")
    public void setUserId( int userId )
    {
        _userId = userId;
    }

    /**
     * @return the groupId
     */
    public int getGroupId( )
    {
        return _groupId;
    }

    /**
     * @param groupId the groupId to set
     */
    @JsonProperty("GroupId")
    public void setGroupId( int groupId )
    {
        _groupId = groupId;
    }

    /**
     * @return the userDisplayName
     */
    public String getUserDisplayName( )
    {
        return _userDisplayName;
    }

    /**
     * @param userDisplayName the userDisplayName to set
     */
    @JsonProperty("UserDisplayName")
    public void setUserDisplayName( String userDisplayName )
    {
        _userDisplayName = userDisplayName;
    }
    
}
