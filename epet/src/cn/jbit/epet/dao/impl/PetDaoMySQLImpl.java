package cn.jbit.epet.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import cn.jbit.epet.dao.BaseDao;
import cn.jbit.epet.dao.PetDao;
import cn.jbit.epet.entity.Pet;
/**
 * PetDao针对MySQL数据库的实现类。
 */
public class PetDaoMySQLImpl extends BaseDao implements PetDao{
	public int update(Pet pet) {	
		String sql="update pet set status=0 where id=?";
		Object[] param={pet.getId()};
		int result=this.exceuteUpdate(sql, param);
		return result;
	}

	@Override
	public List<Pet> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pet getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Pet> findByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Pet pet) {
		String sql="insert pet(master_id,name,type_id) values(?,?,?)";
		Object[]param={pet.getMasterId(),pet.getName(),pet.getTypeId()};
		return exceuteUpdate(sql, param);
	}

	@Override
	public int del(Pet pet) {
		// TODO Auto-generated method stub
		return 0;
	}
}
