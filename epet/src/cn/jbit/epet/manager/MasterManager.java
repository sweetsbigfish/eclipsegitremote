package cn.jbit.epet.manager;

import java.util.Scanner;

import cn.jbit.epet.dao.MasterDao;
import cn.jbit.epet.dao.PetDao;
import cn.jbit.epet.dao.impl.MasterDaoMySQLImpl;
import cn.jbit.epet.dao.impl.PetDaoMySQLImpl;
import cn.jbit.epet.entity.Master;
import cn.jbit.epet.entity.Pet;

/**
 * 主人业务类。
 */
public class MasterManager {
	public Master master=null; //主人
	/**
	 * 主人登录。
	 */
	public void login() {
		// 1、获得输入对象
		Scanner input = new Scanner(System.in);
		// 2、打印欢迎信息
		System.out.println("---- 欢迎光临宠物乐园 ----");
		// 3、获取用户输入的登录名、密码
		System.out.print("请输入登录名：");
		String loginId = input.next();
		System.out.print("请输入密码：");
		String password = input.next();
		Master mas=new Master();
		mas.setName(loginId);
		mas.setPassword(password);
		// 4、检查登录名、密码是否合法，并输出提示信息
		MasterDao masterDao = new MasterDaoMySQLImpl();
		master = masterDao.findMaster(mas);
		if (master!=null) {
			System.out.println("登录成功！");
		} else {
			System.out.println("用户名或密码错误，登录失败！");
		}
	}
	
	/**
	 * 主人领养宠物
	 */
	public void adoptPet(){
		Scanner input = new Scanner(System.in);
		if(master==null){  //判断主人是否登录
			login();
			adoptPet();
		}else{
			PetTypeManager petTypeManager=new PetTypeManager();
			petTypeManager.showPetType(); //显示宠物类型
			String name=input.next().trim();
			int typeId=petTypeManager.findId(name);  //获得宠物类型的编号
			if(typeId!=0){
				System.out.print("请输入宠物昵称：");
				String petName=input.next();				
				Pet pet=new Pet();
				pet.setMasterId(master.getId());
				pet.setName(petName);
				pet.setTypeId(typeId);
				PetDao petDao=new PetDaoMySQLImpl();
				int result=petDao.save(pet); //添加宠物
				if(result!=0)
					System.out.println("领养成功！");
			}else{
				System.out.println("宠物类型有误，领养失败！");
			}	
		}
	}
}
