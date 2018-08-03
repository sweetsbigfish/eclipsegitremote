package cn.jbit.epet.entity;
/**
 * 宠物主人类。
 */
public class Master {

	private int id;// 主人id
	private String name;// 登录名
	private String password; // 登录密码

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
