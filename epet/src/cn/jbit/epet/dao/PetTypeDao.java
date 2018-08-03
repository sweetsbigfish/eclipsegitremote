package cn.jbit.epet.dao;

import java.util.List;

import cn.jbit.epet.entity.PetType;

public interface PetTypeDao {
	List<PetType> findPetType(); //查询宠物类型
	int findIdByTypeName(String name); //根据类型名称查询类型编号
	int save(PetType petType);
}
