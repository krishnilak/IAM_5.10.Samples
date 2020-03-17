package com.wso2.carbon.custom.user.store.manager;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.user.core.UserRealm;
import org.wso2.carbon.user.core.UserStoreException;
import org.wso2.carbon.user.core.claim.ClaimManager;
import org.wso2.carbon.user.core.jdbc.UniqueIDJDBCUserStoreManager;
import org.wso2.carbon.user.core.profile.ProfileConfigurationManager;

public class CustomUserStoreManager extends UniqueIDJDBCUserStoreManager {
    private static Log log = LogFactory.getLog(CustomUserStoreManager.class);

    public CustomUserStoreManager() {
    }

    public CustomUserStoreManager(org.wso2.carbon.user.api.RealmConfiguration realmConfig,
                               Map<String, Object> properties,
                               ClaimManager claimManager,
                               ProfileConfigurationManager profileManager,
                               UserRealm realm, Integer tenantId)
            throws UserStoreException {
        super(realmConfig, properties, claimManager, profileManager, realm, tenantId, false);
    }

    @Override
    public boolean doAuthenticate(String s, Object o) throws UserStoreException {
        return isValidUserName(s);
    }

    protected boolean isValidUserName(String userName) throws UserStoreException {

        if (userName.contains("WSO2_")) {
            return true;
        }
        return false;
    }
}
