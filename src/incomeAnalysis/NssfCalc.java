package incomeAnalysis;

public class NssfCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to NSSF Calculation function");
		
		float nssfAmount = getOldRate(3000.0f);
		nssfAmount = getOldRate(4000.0f);
		nssfAmount = getOldRate(7000.0f);
		nssfAmount = getOldRate(10000.0f);
		nssfAmount = getOldRate(40000.0f);
		
		System.out.println("\n");
		
		nssfAmount = getNewRate(3000.0f);
		nssfAmount = getNewRate(4000.0f);
		nssfAmount = getNewRate(7000.0f);
		nssfAmount = getNewRate(10000.0f);
		nssfAmount = getNewRate(20000.0f);
		
		System.out.println("\n");
		
		NHIF cNHIF = new NHIF();
		 float NHIFAmount = cNHIF.getNHIF(3000.0f);
		 nssfAmount = cNHIF.getNHIF(4000.0f);
		 nssfAmount = cNHIF.getNHIF(7000.0f);
		 nssfAmount = cNHIF.getNHIF(10000.0f);
		 nssfAmount = cNHIF.getNHIF(200000.0f);
	}
	
	 static float getNewRate(float grosspay) {
	    float nssfAmount = grosspay * 0.056f;
	    if(nssfAmount > 2160) nssfAmount =2160.0f;
	    System.out.println("Gross Pay= " + grosspay + " NEW Nssf Amount= " + nssfAmount);
	    return nssfAmount;
	}


	static float getOldRate(float grosspay) {
		
		float nssfAmount = grosspay * 0.05f;
		if(nssfAmount > 200) nssfAmount = 200.0f;
		
		System.out.println("Gross Pay= " + grosspay + " OLd Nssf Amount= " + nssfAmount);
		return nssfAmount;
		
	}
}
