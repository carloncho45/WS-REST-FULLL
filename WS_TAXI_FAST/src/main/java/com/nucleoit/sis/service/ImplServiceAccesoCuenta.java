package com.nucleoit.sis.service;

import java.sql.CallableStatement;
import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nucleoit.sis.dao.LoginCuenta;
import com.nucleoit.sis.model.Cliente;
import com.nucleoit.sis.model.Cuenta;
import com.nucleoit.sis.model.ResponCod;


@Service
public class ImplServiceAccesoCuenta implements ServiceAccesoCuenta {
	@Autowired
	LoginCuenta loginCuenta;
	
	@Override
	public ResponCod AccesoUser(Cuenta cuenta) throws Exception {
		// TODO Auto-generated method stub
		ResponCod row=loginCuenta.AccesoUser(cuenta);
		return row;
	}

	@Override
	public ResponCod CreateCliente(Cliente user) throws Exception {
		// TODO Auto-generated method stub
		ResponCod row=loginCuenta.CreateCliente(user);
		return row;
	}

	@Override
	public ResponCod ExistenciEmailServis(String email) throws Exception {
		// TODO Auto-generated method stub
		ResponCod row=null;
		try{
			row=new ResponCod();
			 int cod =loginCuenta.ExistenciaEmail(email);
			 switch(cod){
			 case 0:
				 ///
				 break;
			 case 1:
				 row.setId(String.valueOf(cod));
				 row.setMensaje("Email no registrado");
				 break;
			 case 2:
				 row.setId(String.valueOf(cod));
				 row.setMensaje("Email ya esta registrado");
				 break;
				 
				}
		}catch(Exception e){
			row.setId("0");
			row.setMensaje(e.getMessage());
			
		}
		
		return row;
	}
}
