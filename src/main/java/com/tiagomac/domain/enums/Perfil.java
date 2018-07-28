package com.tiagomac.domain.enums;

import java.util.Arrays;

public enum Perfil {

	//o framework exige o nome "role".
	ADMIN(1, "ROLE_ADMIN"),
	CLIENTE(2, "ROLE_CLINETE");

	private int cod;
	private String descricao;

	private Perfil(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return this.cod;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public static Perfil toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		return Arrays.stream(Perfil.values()).filter(x -> x.getCod() == cod).findAny().orElse(null);
	}

}
