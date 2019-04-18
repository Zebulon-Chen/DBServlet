package dao.proxy;

import dao.IUserDAO;
import dao.impl.UserDAOImpl;
import dbc.DatabaseConnection;
import javafx.util.Pair;
import vo.User;

public class UserDAOProxy implements IUserDAO {
    private DatabaseConnection dbc = null;
    private IUserDAO dao = null;
    
    //构造器，实现数据库的连接，同时作为factory类实际调用的类
    public UserDAOProxy() {       //构造方法，实例化连接，同时实例化dao对象
        try {
            this.dbc = new DatabaseConnection();    // 连接数据库
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.dao = new UserDAOImpl(this.dbc.getConnection());  //实例化真实主题类
    }
    
    @Override
    public Pair<Boolean, Integer> findLogin(User user) throws Exception{  // 实现接口中的方法。
        Pair<Boolean, Integer> pair=new Pair<Boolean, Integer>(false, 0);
        try{
        	pair = this.dao.findLogin(user);  // 调用真实主题
        }catch(Exception e){
            throw e;                           //向上抛出异常
        }finally{
            this.dbc.close();
        }
        return pair; //返回标记
    }
	@Override
	public int signUp(User user) throws Exception {
		int res;
		try{
            res=this.dao.signUp(user);  // 调用真实主题
        }catch(Exception e){
            throw e;                           //向上抛出异常
        }finally{
            this.dbc.close();
        }
		return res;
	}
}
