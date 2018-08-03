package cn.jbit.epet.test;

import cn.jbit.epet.dao.PetDao;
import cn.jbit.epet.dao.impl.PetDaoMySQLImpl;
import cn.jbit.epet.entity.Pet;

/**
 * ≤‚ ‘¿‡°£
 */
public class Test {
	public static void main(String[] args) {
         PetDao petDao = new PetDaoMySQLImpl();
         Pet pet = new Pet();
         pet.setId(1);
         petDao.update(pet);
	}
}
