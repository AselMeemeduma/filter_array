package filter_lists;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.sun.org.apache.regexp.internal.recompile;

public class Executer {
	
	

	public static void main(String[] args) {
		Executer executer = new Executer();
		
		ArrayList<Hotel> hotels = executer.hotelsGenerator();
		ArrayList<HotelsDisplay> displays = new ArrayList<HotelsDisplay>();
		HotelsDisplay display = new HotelsDisplay();
		display.setHotelName("TEST HOTEL 01");
		
		HotelsDisplay display1 = new HotelsDisplay();
		display1.setHotelName("TEST HOTEL 02");
		displays.add(display);
		displays.add(display1);
		
		ArrayList<Hotel> filtered_results = new ArrayList<Hotel>();
		Set<String> added_hotels = new HashSet<>();
		
		
		
		

		
		for(Hotel result_item : hotels) {
			for(HotelsDisplay cart_item : displays) {
				 boolean contains_carted_item = false;
				 if(result_item.getHotelName().equals(cart_item.getHotelName()) && added_hotels.isEmpty()) {
					 added_hotels.add(result_item.getHotelName());
					 contains_carted_item = true;
				 }else if(!added_hotels.isEmpty()) {
					 
					 added_hotels.add(cart_item.getHotelName());
					 
					 if(added_hotels.contains(result_item.getHotelName())) {
						 contains_carted_item = true;
					 }else {
						 contains_carted_item = false; 
					 }

				 }
				 
				 
				 if(!contains_carted_item) {
					 filtered_results.add(result_item);
					 break;
				 } 
			 }				 
		 }
		
		//filtered_results.stream().filter(Objects::nonNull).collect(Collectors.toList());
		
		System.out.println("hotels size " + hotels.size());
		System.out.println("filtered_results size()"+ filtered_results.size());
	}

	
	private ArrayList<Hotel> hotelsGenerator(){
		ArrayList<Hotel> hotels = new ArrayList<Hotel>();
		for(int i = 1; i<11; i++) {
			Hotel hotel = new Hotel();
			hotel.setHotelName("TEST HOTEL 0"+ i);
			hotels.add(hotel);
		}
		
		return hotels;
	}
	
	
	
}
