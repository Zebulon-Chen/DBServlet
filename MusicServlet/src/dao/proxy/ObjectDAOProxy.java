package dao.proxy;

import java.sql.ResultSet;

import dao.IObjectDAO;
import dao.impl.*;
import dbc.DatabaseConnection;
import javafx.util.Pair;
import vo.GenericPair;

public class ObjectDAOProxy implements IObjectDAO {

    private DatabaseConnection dbc = null;
    private IObjectDAO dao = null;
    
    public ObjectDAOProxy() {
        try {
            this.dbc = new DatabaseConnection();    // 连接数据库
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.dao = new ObjectDAOImpl(this.dbc.getConnection());  //实例化真实主题类
	}

	@Override
	public String resultSetToJson(ResultSet resultSet) throws Exception {
		return this.dao.resultSetToJson(resultSet);
	}


	@Override
	public String initAlbumList() throws Exception {
		String str="";
		try {
			str=this.dao.initAlbumList();
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
		return str;
	}


	@Override
	public String initAlbumCard(int album_id) throws Exception {
		String str="";
		try {
			str=this.dao.initAlbumCard(album_id);
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
		return str;
	}


	@Override
	public String initSongList(int al_id) throws Exception {
		String str="";
		try {
			str=this.dao.initSongList(al_id);
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
		return str;
	}

	@Override
	public String initSongInfo(int so_id) throws Exception {
		String str="";
		try {
			str=this.dao.initSongInfo(so_id);
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
		return str;
	}

	@Override
	public String initGrade(int so_id) throws Exception {
		String str="";
		try {
			str=this.dao.initGrade(so_id);
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
		return str;
	}

	@Override
	public boolean addGrade(String info) throws Exception {
		boolean flag;
		try {
			flag=this.dao.addGrade(info);
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
		return flag;
	}

	@Override
	public String getUserInfo(int u_id) throws Exception {
		String str="";
		try {
			str=this.dao.getUserInfo(u_id);
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
		return str;
	}

	@Override
	public String getUserGradeList(int u_id) throws Exception {
		String str="";
		try {
			str=this.dao.getUserGradeList(u_id);
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
		return str;
	}

	@Override
	public String addFavUser(int u_id, int fav_u_id) throws Exception {
		String str="";
		try {
			str=this.dao.addFavUser(u_id, fav_u_id);
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
		return str;
	}

	@Override
	public String addFavGrade(int u_id, int fav_g_id) throws Exception {
		String str="";
		try {
			str=this.dao.addFavGrade(u_id, fav_g_id);
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
		return str;
	}

	@Override
	public String initSingerInfo(int si_id) throws Exception {
		String str="";
		try {
			str=this.dao.initSingerInfo(si_id);
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
		return str;
	}

	@Override
	public Pair<String, Integer> searchSingleString(String str) throws Exception {
		Pair<String, Integer> pair;
		try {
			pair=this.dao.searchSingleString(str);
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
		return pair;
	}

	@Override
	public GenericPair<String, String> searchList(String[] strings) throws Exception {
		GenericPair<String, String> pair;
		try {
			pair=this.dao.searchList(strings);
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
		return pair;
	}


	@Override
	public String initStyleInfo(int st_id) throws Exception {
		String str="";
		try {
			str=this.dao.initStyleInfo(st_id);
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
		return str;
	}

	@Override
	public String getFavUserList(int u_id) throws Exception {
		String str="";
		try {
			str=this.dao.getFavUserList(u_id);
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
		return str;
	}

	@Override
	public String initCompanyInfo(int co_id) throws Exception {
		String str="";
		try {
			str=this.dao.initCompanyInfo(co_id);
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
		return str;
	}

	@Override
	public String getSongScores(int so_id) throws Exception {
		String str="";
		try {
			str=this.dao.getSongScores(so_id);
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
		return str;
	}

	@Override
	public String initSingerList() throws Exception {
		String str="";
		try {
			str=this.dao.initSingerList();
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
		return str;
	}

	@Override
	public String getFavGradeList(int u_id) throws Exception {
		String str="";
		try {
			str=this.dao.getFavGradeList(u_id);
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
		return str;
	}

	@Override
	public String cancelFavGrade(int u_id, int g_id) throws Exception {
		String str="";
		try {
			str=this.dao.cancelFavGrade(u_id, g_id);
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
		return str;
	}

	@Override
	public String cancelFavUser(int u_id, int fav_u_id) throws Exception {
		String str="";
		try {
			str=this.dao.cancelFavUser(u_id, fav_u_id);
		} catch (Exception e) {
			throw e;
		}finally {
			dbc.close();
		}
		return str;
	}

}
