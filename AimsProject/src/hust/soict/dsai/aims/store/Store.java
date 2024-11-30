package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	private DigitalVideoDisc[] dvdsInStore; // Array to store DVDs in the store
    private int currentCount; // Tracks the current number of DVDs in the store
    private int maxCapacity;  // Maximum capacity of the store

    // Constructor: Initializes the store with the given maximum capacity
    public Store(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.dvdsInStore = new DigitalVideoDisc[maxCapacity]; // Initialize the array
        this.currentCount = 0; // Initially, the store is empty
    }

    // Add a DVD to the store
    public void addDVD(DigitalVideoDisc dvd) {
        if (currentCount < maxCapacity) {
            dvdsInStore[currentCount] = dvd;
            currentCount++;
            System.out.println("DVD added to the store: " + dvd.getTitle());
        } else {
            System.out.println("The store is full. Cannot add more DVDs.");
        }
    }

    // Remove a DVD from the store by its title
    public void removeDVD(String title) {
        boolean removed = false;
        for (int i = 0; i < currentCount; i++) {
            if (dvdsInStore[i] != null && dvdsInStore[i].getTitle().equalsIgnoreCase(title)) {
                // Shift the remaining DVDs to fill the gap
                for (int j = i; j < currentCount - 1; j++) {
                    dvdsInStore[j] = dvdsInStore[j + 1];
                }
                dvdsInStore[currentCount - 1] = null; // Clear the last slot
                currentCount--;
                System.out.println("DVD removed from the store: " + title);
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("No DVD found with title: " + title);
        }
    }

    // Display all DVDs in the store
    public void displayStore() {
        System.out.println("******************STORE******************");
        if (currentCount == 0) {
            System.out.println("The store is empty.");
        } else {
            for (int i = 0; i < currentCount; i++) {
                if (dvdsInStore[i] != null) {
                    System.out.println((i + 1) + ". " + dvdsInStore[i]); // Assumes toString() is implemented in DigitalVideoDisc
                }
            }
        }
        System.out.println("****************************************");
    }
}
