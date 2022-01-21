package br.com.sistema.domain.enums;

public enum TipoUsuario {
	ADMIN(1,"ROLE_ADMIN"),
	CLIENTE(2,"ROLE_CLIENTE");
	
	private int cod;
	private String descricao;
	
	private TipoUsuario(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	//tipo enums tem que importar somente os gettes, para não haver modificação nos campos
	
	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	//criar um metodo do tipo estatico , e do tipo static pois permitir ser estanciado 
	//fazer uma operacao que receber o cod e retornar uma operacao do tipo cliente, desejado
	
	public static TipoUsuario toEnum(Integer cod) {
		//teste de verificação
		if(cod == null) {
			return null;
		}
		//forEach uma buscar 
		for(TipoUsuario x : TipoUsuario.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		//lançado minha exerceção caso não encontre o id correspondente
		throw new IllegalArgumentException("Id invalido"+cod);
	}
}
