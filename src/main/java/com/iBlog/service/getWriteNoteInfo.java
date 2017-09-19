package com.iBlog.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iBlog.common._SqlSessionFactory;
import com.iBlog.entity.WriteNote;

@Controller
public class getWriteNoteInfo {
	private HashMap<Object, Object> result_Option = new HashMap<Object, Object>();
	private SqlSessionFactory sqlSessionFactory = _SqlSessionFactory
			._getSessionFactory();

	/**
	 * @Description: 用户鉴权接口，由于判断用户及返回用户信息
	 * @param UserInfo
	 *            : 用户信息 主要为username，password
	 * @return:Map Authentication Result
	 */
	@RequestMapping(value = "/getWriteNote", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<Object, Object> authentication(
			@RequestBody Map<String, String> UserInfo) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String getWriteNote = "getWriteNote";
		List<WriteNote> WriteNote_list = sqlSession.selectList(getWriteNote,
				UserInfo);
		if (WriteNote_list != null) {
			this.result_Option.put("retcode", "0");
			this.result_Option.put("writeNote", WriteNote_list);
		} else {
			this.result_Option.put("retcode", "-1");
		}
		sqlSession.close();
		return this.result_Option;
	}
}
