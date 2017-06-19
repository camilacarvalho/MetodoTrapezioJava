package fisicaTrabalho;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Trapezio {

	//Metodo que recebe um numero e uma funcao definida em termos de "x"(f(x)), calcula e retorna f(numero)
	public static double funcao(double numero, String funcao){
		Expression e = new ExpressionBuilder(funcao)
				.variable("r")
				.build()
				.setVariable("r", numero);
			return e.evaluate();
	}
	
	
	public static double calculaIntegral(double a, double b, double n, String expressao){

		double h = (b-a)/n; //Altura.
		double resultado = 0; //Resultado. Sera retornado no final como a soma da area de todas as particoes
		double x = a; //Variavel de incremento usada para calcular o f(x), que serao as bases de cada trapezio.
		
		
		//Soma das areas de todos os trapezios. O calculo das bases dos trapezios e dado em funcao do x.
		for (int i = 0; i < n; i++){
			resultado += (funcao(x, expressao) + funcao(x+h, expressao)) * h/2; //
			x = x + h;
		}
		
		return resultado;	
		
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(calculaIntegral(2,4,2000,"r3((1-(r/4))^(1/7))"));
		
	}
}
