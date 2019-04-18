package factory;

import dao.IObjectDAO;
import dao.IUserDAO;
import dao.proxy.ObjectDAOProxy;
import dao.proxy.UserDAOProxy;

public class DAOFactory  {
	
    public static IUserDAO getIUserDAOInstance(){      // 取得DAO实例
        return new UserDAOProxy();       // 返回代理实例
    }
    
    public static IObjectDAO getIObjectDAOInstance() {
		return new ObjectDAOProxy();
	}

}