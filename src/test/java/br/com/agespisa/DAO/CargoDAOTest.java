package br.com.agespisa.DAO;

import org.junit.Test;

import br.com.agespisa.entidade.Cargo;

public class CargoDAOTest {

 
	@Test
	public void salvar() {
	   CargoDAO cargoDAO = new CargoDAO();
	   Cargo cargo = new  Cargo();
	   cargo.setNome("ADMIN");
		cargo.setObs("TESTE");
		cargoDAO.salvar(cargo);
	   
  }
  }

