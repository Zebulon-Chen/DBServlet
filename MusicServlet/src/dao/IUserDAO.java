package dao;

import javafx.util.Pair;
import vo.User;

public interface IUserDAO {
    /**
     * 用户登录验证
     * @param user 传入vo对象
     * @return 验证操作结果
     * @throws Exception
     */
    public Pair<Boolean, Integer> findLogin(User user) throws Exception;
    public int signUp(User user) throws Exception;
}
