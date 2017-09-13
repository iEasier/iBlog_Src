package com.iBlog.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iBlog.common._SqlSessionFactory;
import com.iBlog.entity.UserInfo;
import com.iBlog.entity.WriteNote;

@Controller
public class UserInfoService {
	private SqlSessionFactory sqlSessionFactory = _SqlSessionFactory
			._getSessionFactory();
	private HashMap<Object, Object> result_Option = new HashMap<Object, Object>();

	@RequestMapping(value = "/getUserInfoByUserName", method = RequestMethod.POST)
	@ResponseBody
	public String getPassWordByUserName(String UserName) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String select = "getUserInfoByUserName";// 映射sql的标识字符串
		String password = (String) sqlSession.selectOne(select, UserName);
		sqlSession.close();
		return password;
	}

	@RequestMapping(value = "/AddUserInfo", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<Object, Object> addUserInfo(
			@RequestBody Map<Object, Object> UserInfo) {
		long currentTime = new Date().getTime();
		UserInfo.put("create_time", new Timestamp(currentTime));
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String insert = "addUserInfo";
		sqlSession.insert(insert, UserInfo);
		sqlSession.commit();
		sqlSession.close();
		result_Option.put("retcode", 0);
		return result_Option;
	}

	public void updateUser(UserInfo user) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String updateUserInfo = "updateUserInfo";
		sqlSession.update(updateUserInfo, user);
		sqlSession.commit();
		sqlSession.close();
	}

	/**
	 * @Description: 用户鉴权接口，由于判断用户及返回用户信息
	 * @param UserInfo
	 *            : 用户信息 主要为username，password
	 * @return:Map Authentication Result
	 */
	@RequestMapping(value = "/Authentication", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<Object, Object> authentication(
			@RequestBody Map<String, String> UserInfo) {
		System.out.println("UserInfo");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String authentication = "authentication";
		String getNote_Content = "getNote_Content";
		Map<Object, Object> userInfo_Result = sqlSession.selectOne(
				authentication, UserInfo);
		WriteNote writeNote_Result = sqlSession.selectOne(getNote_Content,
				userInfo_Result);
		if (userInfo_Result != null) {
			this.result_Option.put("userinfo", userInfo_Result);
			this.result_Option.put("writeNote", writeNote_Result);
		} else {
			this.result_Option.put("status", false);
		}
		sqlSession.close();
		this.result_Option.put("retcode", "0");
		return this.result_Option;
	}
}
