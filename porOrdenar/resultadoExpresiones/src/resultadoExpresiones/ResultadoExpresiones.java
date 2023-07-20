package resultadoExpresiones;

public class ResultadoExpresiones {
	
	
	public static void main(String[] args) {
		
		int exp1 = Math.addExact(-16, 32)/4;
		int exp2 = Math.addExact(48,-7)%11;
		int exp3 = Math.addExact(18,2)/Math.addExact(17,-12);
		int exp4 = Math.addExact((17-Math.multiplyExact((18/6),3)),(11%4));
		
		System.out.println("El resultado de la expresión 1 es " + exp1);
		System.out.println("El resultado de la expresión 2 es " + exp2);
		System.out.println("El resultado de la expresión 3 es " + exp3);
		System.out.println("El resultado de la expresión 4 es " + exp4);
        
    }

}
