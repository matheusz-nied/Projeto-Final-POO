import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestAcademia {

	@Test
	public void test1() {
		Professor pf3 = new Professor("Jose", "Azul", 0, 100.0);
		
		pf3.setQuantidadeAulas(2);
		
		assertEquals(0, pf3.getSalario(), 200);
		
		System.out.println("Passou Teste 1 - primeira");
	}

	@Test
	public void test2() {
		Aluno a1 = new Aluno("Matheus", "Roxa", 3);
		a1.aumentaQuantidadeGraus();
		
		assertEquals(0, a1.getQuantidade_graus(), 4);
		assertEquals(a1.getFaixa(), "Roxa");
		
		a1.aumentaQuantidadeGraus();
		
		assertEquals(a1.getFaixa(), "Marrom");

		System.out.println("Passou Teste 2 - segundo");
	}

	@BeforeClass
	public static void inicializaClass() {
		System.out.println("iniciou série de teste");
	}

	@AfterClass
	public static void finalizaClass() {
		System.out.println("Finalizou série de teste");
	}
}