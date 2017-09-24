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

@Controller
public class UserInfoService {
	private SqlSessionFactory sqlSessionFactory = _SqlSessionFactory
			._getSessionFactory();
	private HashMap<Object, Object> result_Option = new HashMap<Object, Object>();

	/**
	 * @Description: 增加用户接口
	 * @param UserInfo
	 * @return:是否成功 0 成功，-1失败
	 */
	@RequestMapping(value = "/AddUserInfo", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<Object, Object> addUserInfo(
			@RequestBody Map<Object, Object> UserInfo) {
		this.result_Option.clear();
		long currentTime = new Date().getTime();
		UserInfo.put("createTime", new Timestamp(currentTime));
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String insert = "addUserInfo";
		try {
			sqlSession.insert(insert, UserInfo);
			sqlSession.commit();
			sqlSession.close();
			this.result_Option.put("retcode", "0");
			this.result_Option.put("retmsg", "Add Userinfo Success");
		} catch (Exception e) {
			this.result_Option.put("retcode", "-1");
			this.result_Option.put("errormsg", "Add Userinfo Failure");
		}
		return this.result_Option;
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
		this.result_Option.clear();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String authentication = "authentication";
		try {
			Map<Object, Object> userInfo_Result = sqlSession.selectOne(
					authentication, UserInfo);
			if (userInfo_Result != null) {
				this.result_Option.put("retcode", "0");
				this.result_Option.put("userinfo", userInfo_Result);
			} else {
				this.result_Option.put("retcode", "-1");
			}
		} catch (Exception e) {
			this.result_Option.put("retcode", "-1");
			this.result_Option.put("errormsg", e.getMessage());
		}
		sqlSession.close();
		return this.result_Option;
	}
}
