class Program{
	public static void bubbleSort(int[] a){
		int j = 0;
		for (int i = a.length - 1;i > 0;i-- ) {
			for (int k = 0; k < a.length - j-1;k++ ) {
				if (a[k] > a[k+1]) {
					int val = a[k];
					a[k] = a[k+1];
					a[k+1] = val;
				}
			}
			j++;
		}
	}
	public static void main(String[] args) {
		int[] x = {5,4,2,7};
		int[] y = {1,3,5,9,2};

		bubbleSort(x);
		bubbleSort(y);

		for(int i : x){
			System.out.print(i + " ");
		}
		System.out.println();
		for(int i : y){
			System.out.print(i + " ");

		}
		
		

	}
}