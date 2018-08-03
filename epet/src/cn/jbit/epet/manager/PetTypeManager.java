package cn.jbit.epet.manager;

import java.util.List;

import cn.jbit.epet.dao.PetTypeDao;
import cn.jbit.epet.dao.impl.PetTypeMySQLImpl;
import cn.jbit.epet.entity.PetType;

public class PetTypeManager {
	/**
	 * ��ʾ��������
	 */
	public void showPetType(){
		PetTypeDao pTypeDao=new PetTypeMySQLImpl();
		List<PetType> list=pTypeDao.findPetType();
		System.out.println("��ѡ��������ͣ�");
		for(PetType petType:list){
			System.out.print(petType.getName()+" | ");
		}
		System.out.println();
	}
	
	public int findId(String name){
		PetTypeDao pTypeDao=new PetTypeMySQLImpl();
		return pTypeDao.findIdByTypeName(name);
	}
}
