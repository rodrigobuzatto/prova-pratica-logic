package classes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TransporteTest {
	
	List<Transportadora> melhorOpcao = new ArrayList<>();
	List<Transportadora> resultado = new ArrayList<>();	

	@Test
	void solicitaTransportadoraMelhorPrecoAereoTest() throws Exception{
		resultado.add(new Transportadora(1, 67812.5, 30.0));
		Transporte spAm = new Transporte("São Paulo - SP", "Manaus - AM", 3875, 1, "preco");
		melhorOpcao = spAm.solicitaTransportadora();
		assertEquals(melhorOpcao.toString(), resultado.toString());
	}
	
	@Test 
	void solicitaTransportadoraMelhorPrecoTerrestreTest() throws Exception{
		resultado.add(new Transportadora(2, 3810.0, 60.0));
		Transporte flCa = new Transporte("Florianopolis - SC", "Campinas - SP", 762, 2, "preco");
		melhorOpcao = flCa.solicitaTransportadora();
		assertEquals(melhorOpcao.toString(), resultado.toString());
	}

	@Test 
	void solicitaTransportadoraMelhorTempoTest() throws Exception{
		resultado.add(new Transportadora(0, 35315.0, 30.0));
		Transporte saBe = new Transporte("Salvador - BA", "Belem - PA", 2018, "tempo");
		melhorOpcao = saBe.solicitaTransportadora();
		assertEquals(melhorOpcao.toString(), resultado.toString());
	}
  
	
	@Test 
	void solicitaTransportadoraMelhorPrecoTest() throws Exception{
		resultado.add(new Transportadora(2, 6750.0, 60.0));
		Transporte spAs = new Transporte("São Paulo - SP", "Assuncao - PAR", 1350, "preco");
		melhorOpcao = spAs.solicitaTransportadora();
		assertEquals(melhorOpcao.toString(), resultado.toString());
	}	

	@Test 
	void solicitaTransportadoraMelhorTempoTerrestreTest() throws Exception{
		resultado.add(new Transportadora(2, 10867.5, 59.0));
		Transporte saBr = new Transporte("Salvador - BA", "Brasilia - DF", 1449, 2, "tempo");
		melhorOpcao = saBr.solicitaTransportadora();
		assertEquals(melhorOpcao.toString(), resultado.toString());
	}
  
	@Test 
	void solicitaTransportadoraMelhorTempoAereoTest() throws Exception{
		resultado.add(new Transportadora(1, 25357.5, 30.0));
		Transporte saBr = new Transporte("Salvador - BA", "Brasilia - DF", 1449, 1,	"tempo");
		melhorOpcao = saBr.solicitaTransportadora();
		assertEquals(melhorOpcao.toString(), resultado.toString());
	}	
}
