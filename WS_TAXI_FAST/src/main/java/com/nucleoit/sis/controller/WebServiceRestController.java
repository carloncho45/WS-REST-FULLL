package com.nucleoit.sis.controller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nucleoit.sis.constantes.Constantes;
import com.nucleoit.sis.model.Cliente;
import com.nucleoit.sis.model.Cuenta;
import com.nucleoit.sis.model.ResponCod;
import com.nucleoit.sis.model.Usuario;
import com.nucleoit.sis.model.beanBusquedaServicio;
import com.nucleoit.sis.model.beanExistenciaEmail;
import com.nucleoit.sis.model.beanServicio;
import com.nucleoit.sis.service.ServiceAccesoCuenta;

@Controller
public class WebServiceRestController {
	private static final Logger logger = LoggerFactory.getLogger(WebServiceRestController.class);
	
	//Map to store employees, ideally we should use database
	// Map<Integer, Employee> empData = new HashMap<Integer, Employee>();
	
	@Autowired
	ServiceAccesoCuenta serviceACCES;	
	
		@RequestMapping(value = Constantes.DUMMY_EMP, method = RequestMethod.GET)
		public @ResponseBody List<Usuario>  getDataPrueba() {
			logger.info("Start getDummyEmployee");			     
			List<Usuario> list=new ArrayList<Usuario>();
			Usuario row=null;
			for(int i=0;i<10;i++){
				row=new Usuario();
				row.setName("Usuario"+" "+String.valueOf(i));
				row.setIdUsuario(String.valueOf(i));
				row.setApaterno("xpater"+" "+String.valueOf(i));
				row.setAmaterno("xmater"+" "+String.valueOf(i));
				list.add(row);
			}
			return list;
			
		}
		@RequestMapping(value = Constantes.GET_USER, method = RequestMethod.GET)
		public @ResponseBody Usuario getUsuario(){
			Usuario user=new Usuario();
			user.setName("carlos");
			user.setApaterno("lopez");
			user.setAmaterno("acaro");
			user.setIdUsuario("1");
		return user;
		}
		
		@RequestMapping(value = Constantes.ACCES_CUENTA, method = RequestMethod.POST)
		public @ResponseBody ResponCod AccesCuenta(@RequestBody Cuenta cuenta) {
			System.out.println(cuenta.toString());
			ResponCod cod=null;
			try{				
				cod=serviceACCES.AccesoUser(cuenta);				
			}catch(Exception e){
				System.out.println("mensajeError: "+e.getMessage());			
			}
			
			return cod;
		}
	
		
		@RequestMapping(value=Constantes.CREATE_CLIENTE,method =RequestMethod.POST)
		public @ResponseBody ResponCod CreateCliente(@RequestBody Cliente cliente){	
			System.out.println(cliente.getName());
		
			ResponCod row=null;
			try{
				row=serviceACCES.CreateCliente(cliente);
				//cod=serviceAccesoCuenta.ExistenciEmailServis(cliente.getEmail());
				System.out.println("codigo-->"+row.getId()+"---email"+cliente.getUsrCuenta());
			}catch(Exception e){
				
			}
			 
			
			return row;
		}
		
		@RequestMapping(value=Constantes.EXISTE_EMAIL,method=RequestMethod.POST)
		public @ResponseBody ResponCod ExiseEmail(@RequestBody beanExistenciaEmail email){
		
			ResponCod row=null;
			try {				
				row=serviceACCES.ExistenciEmailServis(email.getEmail());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return row;
		}
		
//		@RequestMapping(value=Constantes.SERVICIO,method =RequestMethod.GET)
//		public @ResponseBody ResponCod ExtraerServicio(@PathVariable("name") String name){
//			ResponCod cod=null;
//			if(name.length()!=0){
//				cod=new ResponCod();
//				cod.setId("8000");
//				cod.setMensaje(name);
//			}
//			return cod;
//		}
		
		@RequestMapping(value=Constantes.SERVICIO,method =RequestMethod.POST)
		public @ResponseBody List<beanServicio> ListarServicios(@RequestBody beanBusquedaServicio busqueda){
			
			return null;
		}
		
		
		
		
//		@RequestMapping(
//				value = Constantes.SAVE_PHOTO, 
//				method = RequestMethod.POST,
//				headers="",
//				consumes="")
//		public @ResponseBody ResponCod   uploadPhoto(File file){
//			
//			return null;
//		}

}
class beanPrueba{
	private String email;
	private String pass;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
