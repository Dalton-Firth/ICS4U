package firth;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] simpleIntArray = {5, 3, 4, 6, 9, 10, 15, 14, 16, 2, 1, 23, 13,-5};
		double[] simpleDoubleArray = {5.0, 3.0, 4.0, 6.0, 9.0, 10.0, 15.0, 14.0, 16.0, 12.0, 1.0, 23.0, 13.0, -5.0};
		String[] simpleStringArray = {"Apple", "Peanut", "Bar", "Dog", "Cobra","xanadu"};
		
		
//		for(int i =0; i<simpleIntArray.length;i++)
//			System.out.println(simpleIntArray[i]);
//		
//		sort.selection(simpleIntArray);
//		
//		System.out.println("");
//		
//		for(int j =0; j<simpleIntArray.length;j++)
//			System.out.println(simpleIntArray[j]);
//		
//		
//		
//		for(int i =0; i<simpleDoubleArray.length;i++)
//			System.out.println(simpleDoubleArray[i]);
//		
//		sort.selection(simpleDoubleArray);
//		
//		System.out.println("");
//		
//		for(int j =0; j<simpleDoubleArray.length;j++)
//			System.out.println(simpleDoubleArray[j]);
//		
//		
//		
//		for(int i =0; i<simpleStringArray.length;i++)
//			System.out.println(simpleStringArray[i]);
//		
//		sort.selection(simpleStringArray);
//		
//		System.out.println("");
//		
//		for(int j =0; j<simpleStringArray.length;j++)
//			System.out.println(simpleStringArray[j]);
		
		
		for(int i =0; i<simpleIntArray.length;i++)
			System.out.println(simpleIntArray[i]);
		
		sort.insertion(simpleIntArray);
		
		System.out.println("");
		
		for(int j =0; j<simpleIntArray.length;j++)
			System.out.println(simpleIntArray[j]);
		
		
		
		for(int i =0; i<simpleDoubleArray.length;i++)
			System.out.println(simpleDoubleArray[i]);
		
		sort.insertion(simpleDoubleArray);
		
		System.out.println("");
		
		for(int j =0; j<simpleDoubleArray.length;j++)
			System.out.println(simpleDoubleArray[j]);
		
		
		
		for(int i =0; i<simpleStringArray.length;i++)
			System.out.println(simpleStringArray[i]);
		
		sort.insertion(simpleStringArray);
		
		System.out.println("");
		
		for(int j =0; j<simpleStringArray.length;j++)
			System.out.println(simpleStringArray[j]);
		

	}

}
