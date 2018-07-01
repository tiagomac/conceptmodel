package com.tiagomac.domain.enums;

import java.util.Arrays;

public enum EstadoPagamento {

	PENDENTE(1, "Pendente"), QUITADO(2, "Quitado"), CANCELADO(3, "Cancelado");

	private int cod;
	private String descricao;

	private EstadoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return this.cod;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public static EstadoPagamento toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		return Arrays.stream(EstadoPagamento.values()).filter(x -> x.getCod() == cod).findAny().orElse(null);
	}

}
