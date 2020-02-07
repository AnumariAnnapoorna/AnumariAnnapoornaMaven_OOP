package newyeargift;
import java.util.*;

class Chocolate implements GiftInterface
{
	int weight=0;
	int price=0;
	Chocolate(int weight,int price)
	{
		this.weight=weight;
		this.price=price;
	}
	public int getWeight()
	{
		return this.weight;
	}
	public int getPrice()
	{
		return this.price;
	}
}

class Sweet implements GiftInterface
{
	int weight=0;
	int price=0;
	Sweet(int weight,int price)
	{
		this.weight=weight;
		this.price=price;
	}
	public int getWeight()
	{
		return this.weight;
	}
	public int getPrice()
	{
		return this.price;
	}
}

public class Gift extends Newyear{
	
	static Scanner sc=new Scanner(System.in);
	static ArrayList<Chocolate> chocolates=new ArrayList<Chocolate>();
	static ArrayList<Chocolate> candies=new ArrayList<Chocolate>();
	static ArrayList<Sweet> sweets=new ArrayList<Sweet>();
	static HashMap<String,Integer> nameToWeight=new HashMap<String,Integer>();
	static HashMap<String,Integer> nameToPrice=new HashMap<String,Integer>();
	public static void main(String args[])
	{
		Newyear ny=new Newyear();
		ny.display();
		chocolates();
		sweets();
		System.out.println("total weight of gift is:"+totalWeight());
		System.out.println("total price of gift is:"+totalPrice());
		
		System.out.println("Choose the way to sort(enter the number):1.By Price 2.By Weight");
		int sortType=sc.nextInt();
		if(sortType==1)
		{
			Comparator<Chocolate> compareByPrice=(Chocolate c1,Chocolate c2)->((Integer)c1.getPrice()).compareTo(c2.getPrice());
			
			Collections.sort(chocolates,compareByPrice);
		}
		else
		{
            Comparator<Chocolate> compareByWeight=(Chocolate c1,Chocolate c2)->((Integer)c1.getWeight()).compareTo(c2.getWeight());
			
			Collections.sort(chocolates,compareByWeight);
		}
		System.out.println("The sorted result:");
		for(Chocolate choco:chocolates)
		{
			System.out.println(choco.getPrice());
		}
		for(Sweet sweet:sweets)
		{
			System.out.println(sweet.getPrice());
		}
		calRange(sortType);
	}
	
	public static void chocolates() {
		System.out.println("Enter the no.of chocolates in gift:\n");
		int noofchocolates=sc.nextInt();
		for(int count=1;count<=noofchocolates;count++)
		{
			System.out.println("Enter the chocolate type:1.candy 2.Wafer");
			int chocoType=sc.nextInt();
			System.out.println("Enter the Weight of the chocolates");
			int chocoWeight=sc.nextInt();
			System.out.println("Enter the price of the chocolates");
			int chocoPrice=sc.nextInt();
			if(chocoType==1)
			{
				System.out.println("Enter the name of the candy");
				String candyName=sc.next();
				if(nameToWeight.containsKey(candyName))
				{
					nameToWeight.put(candyName,(int)nameToWeight.get(candyName)+chocoWeight);
				}
				else
				nameToWeight.put(candyName,chocoWeight);
				
				
				if(nameToPrice.containsKey(candyName))
				{
					nameToPrice.put(candyName,(int)nameToPrice.get(candyName)+chocoPrice);
				}
				else
				nameToPrice.put(candyName,chocoPrice);
			}
			Chocolate choco=new Chocolate(chocoWeight,chocoPrice);
			chocolates.add(choco);
			if(chocoType==1)
			{
				candies.add(choco);
			}	
		}
	}
	public static void sweets()
	{
		System.out.println("Enter the no.of Sweets in gift:\n");
		int numberOfSweets=sc.nextInt();
		for(int Count=1;Count<=numberOfSweets;Count++)
		{
			System.out.println("Enter the Weight of the sweet");
			int sweetWeight=sc.nextInt();
			System.out.println("Enter the Price of the sweet");
			int sweetPrice=sc.nextInt();
			System.out.println("Enter name of the sweet");
			String sweetname=sc.next();
			Sweet sweet=new Sweet(sweetWeight,sweetPrice);
			sweets.add(sweet);
		}
	}
	
	public static int totalWeight()
	{
		int totalWeight=0;
		for(Chocolate choco:chocolates)
		{
			totalWeight+=choco.getWeight();
		}
		for(Sweet sweet:sweets)
		{
			totalWeight+=sweet.getWeight();
		}
		return totalWeight;
	}
	public static int totalPrice()
	{
		int totalPrice=0;
		for(Chocolate choco:chocolates)
		{
			totalPrice+=choco.getPrice();
		}
		for(Sweet sweet:sweets)
		{
			totalPrice+=sweet.getPrice();
		}
		return totalPrice;
	}
	public static void calRange(int sortType)
	{
		System.out.println("Let's find the range:");
		int lowerLimit,higherLimit;
		if(sortType==1)
		{
			System.out.println("enter the lowerlimit of price");
			lowerLimit=sc.nextInt();
			System.out.println("enter the higherlimit of price");
			higherLimit=sc.nextInt();
			Set<Map.Entry<String,Integer>> candySet=nameToPrice.entrySet();
			Iterator<Map.Entry<String,Integer>> candyIterator=candySet.iterator();
			while(candyIterator.hasNext())
			{
				Map.Entry candyElement=(Map.Entry)candyIterator.next();
				int currentPrice=(int)candyElement.getValue();
				if(currentPrice>=lowerLimit && currentPrice<=higherLimit)
					System.out.println(candyElement.getKey());
			}
		}
		else
		{
			System.out.println("Enter the lowerlimit of weight:");
			lowerLimit=sc.nextInt();
			System.out.println("Enter the higher limit of weight:");
			higherLimit=sc.nextInt();
			Set<Map.Entry<String,Integer>> candySet=nameToWeight.entrySet();
			Iterator<Map.Entry<String,Integer>> candyIterator=candySet.iterator();
			while(candyIterator.hasNext())
			{
				Map.Entry candyelement=(Map.Entry)candyIterator.next();
				int currentWeight=(int)candyelement.getValue();
				if(currentWeight>=lowerLimit && currentWeight<=higherLimit)
					System.out.println(candyelement.getKey());
			}
		}
	}
}




