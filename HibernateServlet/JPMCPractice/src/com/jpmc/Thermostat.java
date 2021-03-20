package com.jpmc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Thermostat {
	
	private String color;
	private int size;
	private double price;
	
	

	public Thermostat(String color, int size, double price) {
		super();
		this.color = color;
		this.size = size;
		this.price = price;
	}

	

	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public int getSize() {
		return size;
	}



	public void setSize(int size) {
		this.size = size;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}
	
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + size;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Thermostat other = (Thermostat) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (size != other.size)
			return false;
		return true;
	}

	

	@Override
	public String toString() {
		return "Thermostat [color=" + color + ", size=" + size + ", price=" + price + "]";
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thermostat ther1 = new Thermostat("blue", 1, 35.99);
		Thermostat ther2 = new Thermostat("yellow", 2, 45.99);
		Thermostat ther3 = new Thermostat("red", 3, 55.99);
		Thermostat ther4 = new Thermostat("white", 2, 36.99);
		Thermostat ther5 = new Thermostat("blue", 3, 25.99);
		Thermostat ther6 = new Thermostat("pink", 1, 45.99);
		Thermostat ther7 = new Thermostat("green", 3, 15.99);
		Thermostat ther8 = new Thermostat("green", 2, 55.99);
		
		List<Thermostat> therList = Arrays.asList(ther1, ther2, ther3, ther4, ther5, ther6, ther7, ther8);
		
		System.out.println(listOfGreen(therList).toString());
		
		System.out.println(therList.size());
		
		System.out.println(first5(therList));
		
		System.out.println(distinctColor(therList, "green").toString());
		
		String[] strArray = {"green", "green", "red", "black", "red"};
		List<String> list = Arrays.asList(strArray);
		
		System.out.println(list.stream().map(s -> s.contains("green")).collect(Collectors.toList()).toString());
		System.out.println(list.stream().filter(s -> s.contains("e")).collect(Collectors.toList()).toString());
		
	}
	
	static List<Thermostat> listOfGreen(List<Thermostat> therList) {
		return therList.stream().filter(t -> t.getColor().equals("green")).collect(Collectors.toList());
		
	}
	
	static List<Thermostat> first5(List<Thermostat> therList) {
		return therList.stream().limit(1).collect(Collectors.toList());
	
	}
	
	static List<Thermostat> distinctColor(List<Thermostat> therList, String str) {
		return therList.stream().filter(t -> !t.getColor().equals(str)).collect(Collectors.toList());
		//return therList.stream().map(Thermostat::getColor).collect(Collectors.toList());
		
	}

}
