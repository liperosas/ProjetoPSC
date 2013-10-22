package negocios;

import java.util.Calendar;
import java.util.regex.Pattern;

import classes.Endereco;
import classes.Pessoa;

public class RNPessoa {

	private char[] aCpf;

	public RNPessoa() {
		// TODO Auto-generated constructor stub
	}

	public void validarInserir(Pessoa pessoa) throws Exception {

		if (pessoa.getNome().equals("") || pessoa.getNome() == null) {
			throw new Exception("Nome inválido");
		} else if (validaCpf(pessoa.getCpf()) == false) {
			throw new Exception("CPF Inválido");
		} else if (!validaTelefone(pessoa.getTelefone())) {
			throw new Exception("Telefone inválido");
		} else if (!validaTelefone(pessoa.getCelular())) {
			throw new Exception("Celular inválido");
		} else if (pessoa.getData_nasc().YEAR < 1900
				|| pessoa.getData_nasc().YEAR > Calendar.getInstance().YEAR) {
			throw new Exception("Data inválida");
		} else if (validarEndereco(pessoa.getEndereco())) {
			throw new Exception("Endereco inválido");
		}

	}

	public void validarAlterar(Pessoa pessoa) throws Exception {

		if (pessoa.getId() <= 0) {
			throw new Exception("ID Inválido");
		} else if (pessoa.getNome().equals("") || pessoa.getNome() == null) {
			throw new Exception("Nome inválido");
		} else if (validaCpf(pessoa.getCpf()) == false) {
			throw new Exception("CPF Inválido");
		} else if (!validaTelefone(pessoa.getTelefone())) {
			throw new Exception("Telefone inválido");
		} else if (!validaTelefone(pessoa.getCelular())) {
			throw new Exception("Celular inválido");
		} else if (pessoa.getData_nasc().YEAR < 1900
				|| pessoa.getData_nasc().YEAR > Calendar.getInstance().YEAR) {
			throw new Exception("Data inválida");
		} else if (validarEndereco(pessoa.getEndereco())) {
			throw new Exception("Endereco inválido");
		}

	}
	
	public void validarRemover(long id) throws Exception{
		if (id <= 0){
			throw new Exception("ID inválido");
		}
	}	

	public boolean validaTelefone(String telefone) {
		return telefone.matches("\\([0-9]{2}?\\)[0-9]{4}?\\-[0-9]{4}?");
	}

	public boolean validarEndereco(Endereco endereco) throws Exception {
		if (endereco.getBairro().equals("") || endereco.getBairro() == null) {
			throw new Exception("Bairro inválido");
		} else if (validaCpf(endereco.getCep()) == false
				|| endereco.getCep().equals("") || endereco.getCep() == null) {
			throw new Exception("Cep inválido");
		} else if (endereco.getCidade().equals("")
				|| endereco.getCidade() == null) {
			throw new Exception("Cidade inválida");
		} else if (endereco.getLogradouro().equals("")
				|| endereco.getLogradouro() == null) {
			throw new Exception("Logradouro inválido");
		} else if (endereco.getNumero().equals("")
				|| endereco.getNumero() == null) {
			throw new Exception("Número inválido");
		} else if (endereco.getUf().equals("") || endereco.getUf() == null) {
			throw new Exception("UF inválido");
		}
		return false;
	}

	public boolean validarCEP(String cep) {
		return cep.matches("\\[0-9]{5}?\\-[0-9]{3}?");
	}

	public boolean validaCpf(String cpf) {
		cpf = cpf.replaceAll(Pattern.compile("\\s").toString(), "");
		cpf = cpf.replaceAll(Pattern.compile("\\D").toString(), "");

		int soma = 0;

		if (cpf.length() != 11) {
			return false;
		}

		aCpf = cpf.toCharArray();

		// Verifica 1º digito
		for (int i = 0; i < 9; i++) {
			int j = (i + 1);
			int x = Integer.parseInt(Character.toString(aCpf[i]));
			soma += (j * x);
		}

		int d1 = (soma % 11);
		if (d1 == 10) {
			d1 = 0;
		}

		// Verifica o 2º digito
		soma = 0;
		int j = 0;
		for (int i = 9; i > 0; i--) {
			int x = Integer.parseInt(Character.toString(aCpf[j]));
			soma += (i * x);
			j++;
		}

		int d2 = (soma % 11);

		if (d2 == 10) {
			d2 = 0;
		}

		if (d1 == Integer.parseInt(Character.toString(aCpf[9]))
				&& d2 == Integer.parseInt(Character.toString(aCpf[10]))) {
			return true;
		} else {
			return false;
		}
	}

}
