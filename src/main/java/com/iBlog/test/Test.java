package com.iBlog.test;

import java.text.SimpleDateFormat;

import com.iBlog.service.UserInfoService;

public class Test {
	public static void main(String[] args) {
		SimpleDateFormat ss= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(ss.format(1499133256000l).toString());
	}
}
