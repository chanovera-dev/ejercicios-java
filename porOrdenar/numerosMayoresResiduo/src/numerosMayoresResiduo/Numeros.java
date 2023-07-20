package numerosMayoresResiduo;

public class Numeros {
	
	double num1 = 0, num2 = 0, num3 = 0, numeroMayor = 0, numeroMenor = 0, numeroMedio = 0, division = 0;
	
	// método set
	void setNum1(double num1) {
		this.num1 = num1;
	}
	
	void setNum2(double num2) {
		this.num2 = num2;
	}
	
	void setNum3(double num3) {
		this.num3 = num3;
	}
	
	void setNumeroMayor(double numeroMayor) {
		this.numeroMayor = numeroMayor;
	}
	
	void setNumeroMenor(double numeroMenor) {
		this.numeroMenor = numeroMenor;
	}
	
	void setNumeroMedio(double numeroMedio) {
		this.numeroMedio = numeroMedio;
	}
	
	void setDivision(double division) {
		this.division = division;
	}
	
	// método get
	public double getNum1() {
		return num1;
	}
	
	public double getNum2() {
		return num2;
	}
	
	public double getNum3() {
		return num3;
	}
	
	public double getNumeroMayor() {
		return numeroMayor;
	}
	
	public double getNumeroMenor() {
		return numeroMenor;
	}
	
	public double getNumeroMedio() {
		return numeroMedio;
	}
	
	public double getDivision() {
		return division;
	}
	
	public void operaciones() {
		// operaciones
		numeroMayor = Math.max(num1, Math.max(num2, num3));
		
		numeroMenor = Math.min(num1, Math.min(num2, num3));
		numeroMedio = (num1 + num2 + num3) - (Math.max(num1, Math.max(num2, num3)) + Math.min(num1, Math.min(num2, num3)));
		
	     
	     division = numeroMayor / numeroMedio;
	}
}
