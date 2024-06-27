public class BubbleSortNo_2 {

	public static void main(String[] args) {
		int array[] = { 4, 3, 2, 1, 6, 9, 10, 8, 7, 5 };
		
		System.out.println("Array sebelum diurutkan");
		printArray(array);

		doBubbleSort(array);

		System.out.println("\nArray sesudah diurutkan");
		printArray(array);

	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void doBubbleSort(int[] number) {
		int number_length = number.length;
		int temp = 0;
		//looping untuk melakukan pass
		for (int putaran = 1; putaran < number_length; putaran++) {
			System.out.println("\nPass Number " + (putaran));
			System.out.println("------");

			//looping untuk melakukan perbandingan setiap number 
			for (int number_array = number_length - 1; number_array >= putaran; number_array--) {
				System.out.println("Perbandingan " + number[number_array] + " dan " + number[number_array - 1]);

				// Memeriksa apakah index number_array - 1 lebih besar dibandingkan number_array berikutnya
				if (number[number_array - 1] > number[number_array]) {
					System.out.println(number[number_array - 1] + " lebih besar dari " + number[number_array]);
					// Jika lebih besar maka index number_array - 1 akan di temp
					temp = number[number_array - 1];
					// mengubah posisi index number_array akan berubah pada index number_array - 1
					number[number_array - 1] = number[number_array];
					// index number_array berada pada index number_array - 1
					number[number_array] = temp;
					System.out.println("Elemen ditukar: Array Baru Setelah Tukar");
					printArray(number);
				}
			}
			
			System.out.println("------");
			System.out.println("Array setelah pass " + (putaran) + ":");
			printArray(number);
		}
	}
}
