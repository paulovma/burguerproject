package br.com.entelgy.burguerproject.realizarpedido;

import java.math.BigDecimal;

public class TipoPaoDTOHelper {

	public static TipoPaoDTO build() {
		return new TipoPaoDTO(1L, "desricao", BigDecimal.ONE);
	}

}
