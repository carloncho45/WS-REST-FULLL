package com.nucleoit.sis.dao;

import com.nucleoit.sis.model.Cliente;
import com.nucleoit.sis.model.Cuenta;
import com.nucleoit.sis.model.ResponCod;

public interface LoginCuenta {
	public ResponCod AccesoUser(Cuenta cuenta);
	public ResponCod CreateCliente(Cliente cliente) throws Exception;
	public int ExistenciaEmail(String email) throws Exception;
}
