package cn.jbit.epet.entity;

import java.io.Serializable;

public class PetType implements Serializable {
	private static final long serialVersionUID = 25874444741572L;
	private int id;
	private String name;
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
}
