package cn.jbit.epet.dao;

import java.util.List;

import cn.jbit.epet.entity.Master;
/**
 * ����Dao�ӿڡ�
 */
public interface MasterDao {
	/**
	 * ����������Ϣ��
	 * @param master ����
	 */
	int save(Master master);
	
	/**
	 * ɾ��������Ϣ��
	 * @param master ����
	 */
	int del(Master master);
	
	/**
	 * ����������Ϣ��
	 * @param master ����
	 */
	int update(Master master);
	
	/**
	 * ����ָ����¼�������������
	 * @param master Ҫ���ҵ�����
	 * @return ����
	 */
	Master findMaster(Master master);
}
