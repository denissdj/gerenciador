package br.com.javagyn.util;

import javax.inject.Inject;

import br.com.javagyn.dao.UsuarioDAO;
import br.com.javagyn.model.Usuario;

public class CriaLancamentos {
	
	@Inject
	private static UsuarioDAO usuarioDAO;

	public static void main(String[] args) {
//		EntityManager manager = JpaUtil.getEntityManager();
//		EntityTransaction trx = manager.getTransaction();
//		trx.begin();
		
		Usuario usuarioMaster = new Usuario();
		usuarioMaster.setNome("Denis Souto de Jesus");
		usuarioMaster.setLogin("denissdj");
		usuarioMaster.setSenha(CriptografiaSHA.senhaCriptografada("123"));
		usuarioDAO.inserir(usuarioMaster);
		
		
//		INSERT INTO usuarios(
//	            id, dt_cadastro, status_entidade, login, nome, senha)
//	    VALUES ('9999', '2014-08-20', 'ATIVO', 'user', 'Usuario Master', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3');

		
//		Usuario usuarioMaster = new Usuario();
//		usuarioMaster.setNome("Denis Souto de Jesus");
//		usuarioMaster.setLogin("denissdj");
//		usuarioMaster.setSenha(CriptografiaSHA.senhaCriptografada("123"));
//		
//		Calendar dataVencimento1 = Calendar.getInstance();
//		dataVencimento1.set(2013, 10, 1, 0, 0, 0);
//		Calendar dataVencimento2 = Calendar.getInstance();
//		dataVencimento2.set(2013, 12, 10, 0, 0, 0);
//		Pessoa cliente = new Pessoa();
//		cliente.setNome("WWW Indústria de Alimentos");
//		Pessoa fornecedor = new Pessoa();
//		fornecedor.setNome("SoftBRAX Treinamentos");
//		Lancamento lancamento1 = new Lancamento();
//		lancamento1.setDescricao("Venda de licença de software");
//		lancamento1.setPessoa(cliente);
//		lancamento1.setDataVencimento(dataVencimento1.getTime());
//		lancamento1.setDataPagamento(dataVencimento1.getTime());
//		lancamento1.setValor(new BigDecimal(103_000));
//		lancamento1.setTipo(EnumTipoLancamento.RECEITA);
//		Lancamento lancamento2 = new Lancamento();
//		lancamento2.setDescricao("Venda de suporte anual");
//		lancamento2.setPessoa(cliente);
//		lancamento2.setDataVencimento(dataVencimento1.getTime());
//		lancamento2.setDataPagamento(dataVencimento1.getTime());
//		lancamento2.setValor(new BigDecimal(15_000));
//		lancamento2.setTipo(EnumTipoLancamento.RECEITA);
//		Lancamento lancamento3 = new Lancamento();
//		lancamento3.setDescricao("Treinamento da equipe");
//		lancamento3.setPessoa(fornecedor);
//		lancamento3.setDataVencimento(dataVencimento2.getTime());
//		lancamento3.setValor(new BigDecimal(68_000));
//		lancamento3.setTipo(EnumTipoLancamento.DESPESA);
//		
//		manager.persist(usuarioMaster);
//		manager.persist(cliente);
//		manager.persist(fornecedor);
//		manager.persist(lancamento1);
//		manager.persist(lancamento2);
//		manager.persist(lancamento3);
//		trx.commit();
//		manager.close();
	}

}
