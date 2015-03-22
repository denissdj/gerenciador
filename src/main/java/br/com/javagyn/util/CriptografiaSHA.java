package br.com.javagyn.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <p>
 * <b>Title:</b> CriptografiaSHA
 * </p>
 * 
 * <p>
 * <b>Description:</b> CriptografiaSHA
 * </p>
 * 
 * <p>
 * <b>Company: </b> Fábrica de Software - JavaGyn
 * </p>
 * 
 * @author Denis
 * 
 * @version 1.0.0
 */
public class CriptografiaSHA {

	/**
	 * Método responsável por criptografar uma senha
	 * 
	 * @author Denis
	 * 
	 * @param senha
	 * @return
	 */
	public static String senhaCriptografada(final String senha) {

		// codigo abaixo representa a senha 123
		// a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3

		try {

			MessageDigest md;

			md = MessageDigest.getInstance("SHA-256");

			md.update(senha.getBytes());

			final byte byteData[] = md.digest();

			final StringBuffer sb = new StringBuffer();

			for (final byte b : byteData) {

				sb.append(Integer.toString(( b & 0xff ) + 0x100, 16).substring(1));
			}

			return sb.toString();

		} catch (final NoSuchAlgorithmException e) {

			e.getMessage();

			return null;
		}
	}
}
