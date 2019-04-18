package factory;

import dao.IObjectDAO;
import dao.IUserDAO;
import dao.proxy.ObjectDAOProxy;
import dao.proxy.UserDAOProxy;

public class DAOFactory  {
	
    public static IUserDAO getIUserDAOInstance(){      // ȡ��DAOʵ��
        return new UserDAOProxy();       // ���ش���ʵ��
    }
    
    public static IObjectDAO getIObjectDAOInstance() {
		return new ObjectDAOProxy();
	}

}