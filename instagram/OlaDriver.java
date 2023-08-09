import java.util.Scanner;
class Ola
{
	double basePrice = 10;
	Scanner sc = new Scanner(System.in);
	//System.out.println(" how many kilometer your location");
	double Km = sc.nextDouble();
    double perKm = 1;
	void totalBill()
	{
		System.out.println("Total Bill: "+(Km * perKm));
	}

	void display() {
		System.out.println("Total bill: "+basePrice);
	}

	Ola() {
		this.Km = Km;
	}

}
class Mini extends Ola
{
	double perKm = 7;
	void display() {
		super.totalBill();
	}
	Mini() {
	
	}
}

class OlaDriver
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Ola o ;

		System.out.println("\n---------OLA---------");
		System.out.println("*********************");
		System.out.println("Welcome To Ola");
		System.out.println("where are going?");
		String loction = sc.nextLine();
		System.out.println("how many kilometer your location");
		double Km = sc.nextDouble();
		

		o = new Mini();
		if (o instanceof Mini)
		{
			Mini m = (Mini) o;
			m.display();
		}

	}
}


