package cn.jbit.epet.dao;

import java.util.List;

import cn.jbit.epet.entity.PetType;

public interface PetTypeDao {
	List<PetType> findPetType(); //��ѯ��������
	int findIdByTypeName(String name); //�����������Ʋ�ѯ���ͱ��
	int save(PetType petType);
}
