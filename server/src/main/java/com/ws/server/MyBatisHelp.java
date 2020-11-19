package com.ws.server;

import org.apache.ibatis.session.SqlSession;

public final class MyBatisHelp {
	
	private MyBatisHelp()
	{
		
	}
	
	public static int doupdateOL(SqlSession sqlSession, String statementName)
	{
		int updateCount = sqlSession.update(statementName);
		
		return updateCount;
	}

}
