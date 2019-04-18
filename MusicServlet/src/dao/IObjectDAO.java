package dao;

import java.sql.ResultSet;

import javafx.util.Pair;
import sun.security.util.PropertyExpander.ExpandException;
import vo.GenericPair;
import vo.Song;

public interface IObjectDAO {
	public String initAlbumList() throws Exception;
	public String initAlbumCard(int album_id) throws Exception;
	public String resultSetToJson(ResultSet resultSet) throws Exception;
	public String initSongList(int al_id) throws Exception;
	public String initSongInfo(int so_id) throws Exception;
	public String initGrade(int so_id) throws Exception;
	public boolean addGrade(String info) throws Exception;
	public String getUserInfo(int u_id) throws Exception;
	public String getUserGradeList(int u_id) throws Exception;
	public String addFavUser(int u_id,int fav_u_id) throws Exception;
	public String addFavGrade(int u_id,int fav_g_id) throws Exception;
	public String initSingerInfo(int si_id) throws Exception;
	public Pair<String, Integer> searchSingleString(String str) throws Exception;
	public GenericPair<String, String> searchList(String[] strings) throws Exception;
	public String initStyleInfo(int st_id) throws Exception;
	public String getFavUserList(int u_id) throws Exception;
	public String initCompanyInfo(int co_id) throws Exception;
	public String getSongScores(int so_id) throws Exception;
	public String initSingerList() throws Exception;
	public String getFavGradeList(int u_id) throws Exception;
	public String cancelFavGrade(int u_id,int g_id) throws Exception;
	public String cancelFavUser(int u_id,int fav_u_id) throws Exception;
}
