package com.mapeak.smis.handler;

import java.sql.ResultSet;
import java.util.List;

//��������������淶��������
public interface IResultSetHandler<T> {
	//��������
	//T ��ʾδ֪���ͣ���������������Ǹ����ͼ��ϣ����������ɷ�����������ָ��
	T handle(ResultSet rs) throws Exception;
}
