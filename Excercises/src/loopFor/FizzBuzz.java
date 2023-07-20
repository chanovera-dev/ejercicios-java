package loopFor;

public class FizzBuzz {

	public static void main(String[] args) {
		
		
		for (int i = 1; i < 101; i++) {
			
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.print(i + " FizzBuzz, ");
			} else if (i % 3 == 0) {
				System.out.print(i + " Fizz, ");
			} else if (i % 5 == 0) {
				System.out.print(i + " Buzz, ");
			} else {
				System.out.print(i + ", ");
			}
			
			if (i % 20 == 0) {
				System.out.println();
			}
			
		}
		
		System.out.println();
		
		// Sin usar el %
		int fizz = 0;
        int buzz = 0;
        int salto = 0;

        for (int i = 1; i <= 100; i++) {
            fizz++;
            buzz++;
            salto++;

            if (fizz == 3) {
                fizz = 0;
                if (buzz == 5) {
                    buzz = 0;
                    System.out.print(i + " FizzBuzz, ");
                } else {
                    System.out.print(i + " Fizz, ");
                }
            } else if (buzz == 5) {
                buzz = 0;
                System.out.print(i + " Buzz, ");
            } else {
                System.out.print(i + ", ");
            }
            
            if (salto == 20) {
            	salto = 0;
            	System.out.println();
            }
        }
	}
}
