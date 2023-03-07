package incomeAnalysis;

import java.util.LinkedHashMap;

public class NHIF {
	public float getNHIF(float grosspay) {
		float NHIFAmount = 150.0f;
		
		LinkedHashMap<Float, Float> NHIFRates = new LinkedHashMap<Float, Float>();
		
		NHIFRates.put(6000.0f, 300.0f);
		NHIFRates.put(8000.0f, 400.0f);
		NHIFRates.put(12000.0f, 500.0f);
		NHIFRates.put(15000.0f, 600.0f);
		NHIFRates.put(20000.0f, 750.0f);
		NHIFRates.put(25000.0f, 850.0f);
		NHIFRates.put(30000.0f, 900.0f);
		NHIFRates.put(35000.0f, 950.0f);
		NHIFRates.put(40000.0f, 1000.0f);
		NHIFRates.put(45000.0f, 1100.0f);
		NHIFRates.put(50000.0f, 1200.0f);
		NHIFRates.put(60000.0f, 1300.0f);
		NHIFRates.put(70000.0f, 1400.0f);
		NHIFRates.put(80000.0f, 1500.0f);
		NHIFRates.put(90000.0f, 1600.0f);
		NHIFRates.put(100000.0f, 1700.0f);
		
		for(float rMax: NHIFRates.keySet()) {
				if(grosspay >= rMax) NHIFAmount = NHIFRates.get(rMax);
		}
		
		System.out.println("Gross Pay= " + grosspay + " NHIF Amount= " + NHIFAmount);
				return NHIFAmount;
				
		
	}
}
