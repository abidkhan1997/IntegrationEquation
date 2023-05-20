public class Integration {

	public static double E = 2.7182818;

	public static void main(String[] args) {
		
        // Function 1 with dx = 0.1
		Trapezoid(0,1,0.1,1);
		RandomNumber(0,1,0.1,1);
		Midpoint(0,1,0.1,1);
		Simpson(0,1,0.1,1);
		
		// Function 1 with dx = 0.5
		Trapezoid(0,1,0.5,1);
		RandomNumber(0,1,0.5,1);
		Midpoint(0,1,0.5,1);
		Simpson(0,1,0.5,1);
		
		// Function 2 with dx = 0.1
		Trapezoid(2,5,0.1,2);
		RandomNumber(2,5,0.1,2);
		Midpoint(2,5,0.1,2);
		Simpson(2,5,0.1,2);
		
		// Function 2 with dx = 0.5
		Trapezoid(2,5,0.5,2);
		RandomNumber(2,5,0.5,2);
		Midpoint(2,5,0.5,2);
		Simpson(2,5,0.5,2);
		
		// Function 3 with dx = 0.1
		Trapezoid(1,4,0.1,3);
		RandomNumber(1,4,0.1,3);
		Midpoint(1,4,0.1,3);
		Simpson(1,4,0.1,3);
		
		// Function 3 with dx = 0.5
		Trapezoid(1,4,0.5,3);
		RandomNumber(1,4,0.5,3);
		Midpoint(1,4,0.5,3);
		Simpson(1,4,0.5,3);
		
		// Function 4 with dx = 0.1
		Trapezoid(E,E+1,0.1,4);
		RandomNumber(E,E+1,0.1,4);
		Midpoint(E,E+1,0.1,4);
		Simpson(E,E+1,0.1,4);
		
		// Function 4 with dx = 0.5
		Trapezoid(E,E+1,0.5,4);
		RandomNumber(E,E+1,0.5,4);
		Midpoint(E,E+1,0.5,4);
		Simpson(E,E+1,0.5,4);
	}
	
    public static double Function(double x, int index) {
		double result = 0.0;
		switch(index) 
		{
		case 1:
        result = 4/(1+x*x);
			break;
		case 2:
        result = 3*x+1;
			break;
		case 3:
        result = (5*x*x + 2*x - 4);
			break;
		case 4:
        result = 1/(x*Math.log(x));
			break;
		}
		return result;
	}
	
    //random number method
	
	public static double RandomNumber(double a, double b, double dx, int index) {
		double result = 0;
		int count =  (int)((b-a) / dx);
		for(int i = 0; i < count; i++) {
			result = result + (Function(a+i*dx+dx,index) + Function(a+i*dx,index))*dx/2;
		}
		System.out.println("RandomNumber For Function "+index+" dx = "+dx+" : " + result);
		return result;
	}
	
	//trapezoid method
	
	public static double Trapezoid(double a, double b, double dx, int index) {
		double result = 0;
		int count =  (int)((b-a) / dx);
		for(int i = 0; i < count; i++) {
			result = result + (Function(a+i*dx,index)+Function(a+(i+1)*dx,index))*dx/2;
		}
		System.out.println("Trapezoid For Function "+index+" dx = "+dx+" : " + result);
		return result;
	}
	
	//midpoint method
	
	public static double Midpoint(double a, double b, double dx, int index) {
		double result = 0;
		int count =  (int)((b-a) / dx);
		for(int i = 0; i < count; i++) {
			result = result + Function(a+dx*0.5+dx*i,index)*dx;
		}
		System.out.println("Midpoint For Function "+index+" dx = "+dx+" : " + result);
		return result;
	}
	
	//simpson method
	
	public static double Simpson(double a, double b, double dx, int index) {
		 	double x, sum4x, sum2x;
		    double simpson = 0.0;
		    sum4x = 0.0;
		    sum2x = 0.0;
		    int n = (int) ((b-a) / dx);
		    // 4/3 terms
		    for (int i = 1; i < n; i += 2) {
		        x = a + i * dx;
		        sum4x += Function(x, index);
		    }

		    // 2/3 terms
		    for (int i = 2; i < n-1; i += 2) {
		        x = a + i * dx;
		        sum2x += Function(x,index);
		    }
		    simpson = Function(a,index) + Function(b,index);
		    simpson = (dx / 3)*(simpson + 4 * sum4x + 2 * sum2x);
		    
			System.out.println("Simpson For Function "+index+" dx = "+dx+" : " + simpson);
		    return simpson;
	}


}