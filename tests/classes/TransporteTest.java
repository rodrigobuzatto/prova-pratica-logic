package classes;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TransporteTest {
	
	List<Transportadora> melhorOpcao = new ArrayList<>();
	List<Transportadora> resultado = new ArrayList<>();
	Connection con = null;
	ConexaoPostgreSQL conexao = new ConexaoPostgreSQL();

	@Test
	void solicitaTransportadoraMelhorPrecoAereoTest() throws Exception{
		resultado.add(new Transportadora(2, 21312.5, 65.0));
		Transporte spAm = new Transporte("São Paulo - SP", "Manaus - AM", 3875, 1, "preco");
		con = conexao.conectar();
		melhorOpcao = spAm.solicitaTransportadora();
		assertEquals(melhorOpcao.toString(), resultado.toString());
	}
	
	/*
	 * @Test void solicitaTransportadoraMelhorPrecoTerrestreTest() throws Exception{
	 * Transporte flCa = new Transporte("Florianopolis - SC", "Campinas - SP", 762,
	 * 2, "preco"); con = conexao.conectar(); melhorOpcao =
	 * flCa.solicitaTransportadora(); assertEquals(melhorOpcao.size(), 1); }
	 * 
	 * @Test void solicitaTransportadoraMelhorTempoTest() throws Exception{
	 * Transporte saBe = new Transporte("Salvador - BA", "Belem - PA", 2018,
	 * "tempo"); con = conexao.conectar(); melhorOpcao =
	 * saBe.solicitaTransportadora(); assertEquals(melhorOpcao.size(), 2); }
	 * 
	 * @Test void solicitaTransportadoraMelhorPrecoTest() throws Exception{
	 * Transporte spAs = new Transporte("São Paulo - SP", "Assuncao - PAR", 1350,
	 * "preco"); con = conexao.conectar(); melhorOpcao =
	 * spAs.solicitaTransportadora(); assertEquals(melhorOpcao.size(), 1); }
	 * 
	 * @Test void solicitaTransportadoraMelhorTempoTerrestreTest() throws Exception{
	 * Transporte saBr = new Transporte("Salvador - BA", "Brasilia - DF", 1449, 2,
	 * "tempo"); con = conexao.conectar(); melhorOpcao =
	 * saBr.solicitaTransportadora(); assertEquals(melhorOpcao.size(), 2); }
	 * 
	 * @Test void solicitaTransportadoraMelhorTempoAereoTest() throws Exception{
	 * Transporte saBr = new Transporte("Salvador - BA", "Brasilia - DF", 1449, 1,
	 * "tempo"); con = conexao.conectar(); melhorOpcao =
	 * saBr.solicitaTransportadora(); assertEquals(melhorOpcao.size(), 2); }
	 * 
	 * @Test void solicitaTransportadoraExceptionTest() throws Exception{ con =
	 * conexao.conectar(); Exception e = assertThrows(Exception.class, () -> {
	 * Transporte saBr = new Transporte("Salvador - BA", "Brasilia - DF", 1449, 2,
	 * "tempo"); saBr.solicitaTransportadora(); }); assertEquals(e.getMessage(),
	 * "Não foram encontradas transportadoras disponíveis"); }
	 */

}
