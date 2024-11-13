package com.bcc.gestao.bluevelvet.model.vo;

import com.bcc.gestao.bluevelvet.model.Product;
import com.bcc.gestao.bluevelvet.model.vo.ProductVO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductVOTest {

	@Test
	public void testToEntity() {
		// Criação de um ProductVO
		ProductVO productVO = new ProductVO(1L, "Produto 1", 10.0);

		// Conversão para Product
		Product product = productVO.toEntity();

		// Verificação de que os dados do ProductVO foram corretamente convertidos para o Product
		assertEquals(productVO.getId(), product.getId());
		assertEquals(productVO.getName(), product.getName());
		assertEquals(productVO.getPrice(), product.getPrice());
	}
}
