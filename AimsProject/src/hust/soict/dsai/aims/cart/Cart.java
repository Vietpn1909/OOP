package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] =
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	public int qtyOrdered = 0;
	public final int MAX_LIMIT = 20;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
	    if (qtyOrdered < MAX_LIMIT) {
	        itemsOrdered[qtyOrdered] = disc;
	        qtyOrdered++;
	        System.out.println("The disc has been added.");
	        
	        if (qtyOrdered == MAX_LIMIT) {
	            System.out.println("The cart is now full.");
	        }
	    } else {
	        System.out.println("The cart is already full. Cannot add more items.");
	    }
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] discs) {
		for(DigitalVideoDisc disc : discs) {
		if (qtyOrdered < MAX_LIMIT) {
	        itemsOrdered[qtyOrdered] = disc;
	        qtyOrdered++;
	        System.out.println("The disc has been added.");
	        
	        if (qtyOrdered == MAX_LIMIT) {
	            System.out.println("The cart is now full.");
	        }
	    } else {
	        System.out.println("The cart is already full. Cannot add more items.");
	    }
		}	
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
		//add disc 1
		if (qtyOrdered < MAX_LIMIT) {
	        itemsOrdered[qtyOrdered] = disc1;
	        qtyOrdered++;
	        System.out.println("The first disc has been added.");
	        
	        if (qtyOrdered == MAX_LIMIT) {
	            System.out.println("The cart is now full.");
	        }
	    } else {
	        System.out.println("The cart is already full. Cannot add more items.");
	    }
		//add disc 2
		if (qtyOrdered < MAX_LIMIT) {
	        itemsOrdered[qtyOrdered] = disc2;
	        qtyOrdered++;
	        System.out.println("The second disc has been added.");
	        
	        if (qtyOrdered == MAX_LIMIT) {
	            System.out.println("The cart is now full.");
	        }
	    } else {
	        System.out.println("The cart is already full. Cannot add more items.");
	    }
	}
	
	public void printCart() {
        if (qtyOrdered == 0) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Cart contents:");
            for (int i = 0; i < qtyOrdered; i++) {
                System.out.println(itemsOrdered[i]);
            }
        }
    }
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		boolean find = false;
		for(int i = 0; i < qtyOrdered;i++) {
			if(itemsOrdered[i] == disc) {
				find = true;
				for(int j = i; j < qtyOrdered;j++) {
					itemsOrdered[j] = itemsOrdered[j+1];
				}
				itemsOrdered[qtyOrdered-1] = null;
				qtyOrdered--;
				System.out.println("The disc has been removed.");
			}
			if(find == false) {
				System.out.println("The disc was not found in the cart.");
			}
		}
	}
	public float totalCost() {
		float total = 0.0f;
		for(int i = 0;i < qtyOrdered;i++) {
			total += itemsOrdered[i].getCost();
		}
		return total;
	}
	public void print() {
		System.out.println("******************CART******************");
        System.out.println("Ordered Items:");
        float totalCost = 0;
        for (DigitalVideoDisc disc : itemsOrdered) {
            if (disc != null) { // Check for null before accessing properties
                System.out.println(disc); // Assumes toString() is properly implemented in DigitalVideoDisc
                totalCost += disc.getCost();
            }
        }
        System.out.println("****************************************");
        System.out.println("Total cost: " + totalCost + " $");
	}
	
	// Search DVDs by ID
    public void searchById(int id) {
        boolean found = false;

        for (DigitalVideoDisc disc : itemsOrdered) { // Loop through the list/array
            if (disc != null && disc.getID() == id) { // Add a null check before accessing getId()
                System.out.println("Found: " + disc); // Assumes toString() is implemented in DigitalVideoDisc
                found = true;
                break; // Exit loop after finding the match
            }
        }

        if (!found) {
            System.out.println("No DVD found with ID: " + id);
        }
    }
    // Search DVDs by title
    public void searchByTitle(String title) {
        boolean found = false;

        for (DigitalVideoDisc disc : itemsOrdered) { // Loop through the list/array
            if (disc != null && disc.getTitle().equalsIgnoreCase(title)) { // Check for null and compare titles (case-insensitive)
                System.out.println("Found: " + disc); // Print details of the matched DVD
                found = true;
            }
        }

        if (!found) {
            System.out.println("No DVD found with title: " + title);
        }
    }
}


