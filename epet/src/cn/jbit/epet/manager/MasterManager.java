package cn.jbit.epet.manager;

import java.util.Scanner;

import cn.jbit.epet.dao.MasterDao;
import cn.jbit.epet.dao.PetDao;
import cn.jbit.epet.dao.impl.MasterDaoMySQLImpl;
import cn.jbit.epet.dao.impl.PetDaoMySQLImpl;
import cn.jbit.epet.entity.Master;
import cn.jbit.epet.entity.Pet;

/**
 * ����ҵ���ࡣ
 */
public class MasterManager {
	public Master master=null; //����
	/**
	 * ���˵�¼��
	 */
	public void login() {
		// 1������������
		Scanner input = new Scanner(System.in);
		// 2����ӡ��ӭ��Ϣ
		System.out.println("---- ��ӭ���ٳ�����԰ ----");
		// 3����ȡ�û�����ĵ�¼��������
		System.out.print("�������¼����");
		String loginId = input.next();
		System.out.print("���������룺");
		String password = input.next();
		Master mas=new Master();
		mas.setName(loginId);
		mas.setPassword(password);
		// 4������¼���������Ƿ�Ϸ����������ʾ��Ϣ
		MasterDao masterDao = new MasterDaoMySQLImpl();
		master = masterDao.findMaster(mas);
		if (master!=null) {
			System.out.println("��¼�ɹ���");
		} else {
			System.out.println("�û�����������󣬵�¼ʧ�ܣ�");
		}
	}
	
	/**
	 * ������������
	 */
	public void adoptPet(){
		Scanner input = new Scanner(System.in);
		if(master==null){  //�ж������Ƿ��¼
			login();
			adoptPet();
		}else{
			PetTypeManager petTypeManager=new PetTypeManager();
			petTypeManager.showPetType(); //��ʾ��������
			String name=input.next().trim();
			int typeId=petTypeManager.findId(name);  //��ó������͵ı��
			if(typeId!=0){
				System.out.print("����������ǳƣ�");
				String petName=input.next();				
				Pet pet=new Pet();
				pet.setMasterId(master.getId());
				pet.setName(petName);
				pet.setTypeId(typeId);
				PetDao petDao=new PetDaoMySQLImpl();
				int result=petDao.save(pet); //��ӳ���
				if(result!=0)
					System.out.println("�����ɹ���");
			}else{
				System.out.println("����������������ʧ�ܣ�");
			}	
		}
	}
}
