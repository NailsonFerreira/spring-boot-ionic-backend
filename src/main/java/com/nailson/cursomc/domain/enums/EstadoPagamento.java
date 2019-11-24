package com.nailson.cursomc.domain.enums;

public enum EstadoPagamento {
	
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"), 
	CANCELADO(3, "Cancelado");
	
	private int cod;
	private String descricao;
	

	private EstadoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return this.cod;
	}
	
	public String getString() {
		return this.descricao;
	}
	
}
