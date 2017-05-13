package com.nucleoit.sis.service;

import com.nucleoit.sis.model.Cliente;
import com.nucleoit.sis.model.Cuenta;
import com.nucleoit.sis.model.ResponCod;

public interface ServiceAccesoCuenta {
	public ResponCod AccesoUser(Cuenta cuenta) throws Exception;
	public ResponCod CreateCliente(Cliente user) throws Exception;
	public ResponCod ExistenciEmailServis(String email) throws Exception;
}
