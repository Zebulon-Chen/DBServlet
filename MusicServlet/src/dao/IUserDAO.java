package dao;

import javafx.util.Pair;
import vo.User;

public interface IUserDAO {
    /**
     * �û���¼��֤
     * @param user ����vo����
     * @return ��֤�������
     * @throws Exception
     */
    public Pair<Boolean, Integer> findLogin(User user) throws Exception;
    public int signUp(User user) throws Exception;
}
