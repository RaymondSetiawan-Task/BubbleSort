import java.util.Scanner;

public class BubbleSortNo_4 {
	public static void main(String[] args) {
		//Penggunaan try untuk memastikan block scanner akan ditutup secara otomatis setelah 
		//digunakan dan tidak perlu menggunakan scanner.close();
		
		try (Scanner scanner = new Scanner(System.in)) {
			// Memasukan jumlah element sesuai inputan user
			System.out.print("Masukkan jumlah elemen array: ");
			int input_array = scanner.nextInt();

			// User harus input lebih besar dari 0
			if (input_array < 1) {
				System.out.println("Jumlah elemen harus lebih besar dari 0.");
				return;
			}

			int[] array = new int[input_array];

			System.out.println("Masukkan " + input_array + " elemen array:");
			scanner.nextLine();

			for (int i = 0; i < input_array; i++) {
				if (scanner.hasNextInt()) {
					//Memasukan number kedalam array length
					array[i] = scanner.nextInt();
					// Agar inputan user tidak dibaca spasi melainkan enter
					scanner.nextLine();
				} else {
					// User perlu memasukan angka bilangan bulat
					System.out.println("Input tidak valid. Silahkan masukan bilangan bulat!");
					// Untuk mengabaikan input yang tidak valid
					scanner.next();
					//Mengurangi variable i untuk mengurangi nilai dari variable loop i agar 
					//iterasi dapat diulang kembali
					i--;
					continue;
				}
			}

			System.out.println("\nArray sebelum diurutkan");
			printArray(array);

			doBubbleSort(array);

			System.out.println("\nArray sesudah diurutkan");
			printArray(array);

		}
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
		// variable untuk menandai petukaran elemen selama satu iterasi
		boolean pertukaran;
		
		//looping untuk melakukan pass
		for (int putaran = 1; putaran < number_length; putaran++) {
			pertukaran = false;
			System.out.println("\nPass Number " + (putaran));
			System.out.println("------");

			//looping untuk melakukan perbandingan setiap number 
			for (int number_array = number_length - 1; number_array >= putaran; number_array--) {

				System.out.println("Perbandingan " + number[number_array] + " dan " + number[number_array - 1]);

				// Memeriksa apakah index number_array - 1 lebih besar dibandingkan number_array
				// berikutnya
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
					// Terjadi pertukaran maka boolean petukaran akan menjadi true
					pertukaran = true;
				}
			}
			
			// Kondisi ketika tidak terjadi pertukaran pada pass tertentu berarti array telah berurutan
			// berfungsi untuk mengurangi iterasi yang tidak diperlukan 
			if (!pertukaran) {
				System.out.println("Susunan Array telah berurutan");
				break;
			}

			System.out.println("------");
			System.out.println("Array setelah pass " + (putaran) + ":");
			printArray(number);
		}
	}
}
