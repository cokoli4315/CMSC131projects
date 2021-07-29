package foodManagement;

/**
 * A SortedListOfImmutables represents a sorted collection of immutable objects
 * that implement the Listable interface.
 * 
 * An array of references to Listable objects is used internally to represent
 * the list.
 * 
 * The items in the list are always kept in alphabetical order based on the
 * names of the items. When a new item is added into the list, it is inserted
 * into the correct position so that the list stays ordered alphabetically by
 * name.
 */
public class SortedListOfImmutables {
	private Listable[] items;

	/**
	 * This constructor creates an empty list by creating an internal array of
	 * size 0
	 */
	public SortedListOfImmutables() {
		items = new Listable[0];

	}

	/**
	 * Copy constructor. The current object will become a copy of the list that
	 * the parameter refers to.
	 * 
	 * Copies the items of the other list into the initial list of items
	 * 
	 * @param other this is copy of the items
	 */
	public SortedListOfImmutables(SortedListOfImmutables other) {
		items = new Listable[other.items.length];
		for (int index = 0; index < other.items.length; index++) {
			items[index] = other.items[index];
		}
	}

	/**
	 * Returns the number of items in the list.
	 * 
	 * @return number of items in the list
	 */
	public int getSize() {
		return items.length;

	}

	/**
	 * Returns a reference to the item in the ith position in the list.
	 * (Indexing is 0-based, so the first element is element 0).
	 * 
	 * @param i index of item requested
	 * @return reference to the ith item in the list
	 */
	public Listable get(int i) {
		return items[i];
	}

	/**
	 * Adds an item to the list. This method assumes that the list is already
	 * sorted in alphabetical order based on the names of the items in the list.
	 * 
	 * The new item will be inserted into the list in the appropriate place so
	 * that the list will remain alphabetized by names.
	 * 
	 * @param itemToAdd refers to a Listable item to be added to this list add
	 *                  method sorts a list of food items that are sorted
	 *                  according to alphabetical order
	 */
	public void add(Listable itemToAdd) {
		Listable[] adds = new Listable[items.length + 1];
		for (int index = 0; index < items.length; index++) {
			adds[index] = items[index];
		}
		adds[adds.length - 1] = itemToAdd;
		if (items.length == 0) {
			adds[0] = itemToAdd;
		} else {
			for (int i = 0; i < adds.length; i++) {
				for (int j = i + 1; j < adds.length; j++) {
					if (adds[i].getName().compareTo(adds[j].getName()) > 0) {
						itemToAdd = adds[i];
						adds[i] = adds[j];
						adds[j] = itemToAdd;
					}
				}
			}
		}
		// Assigning the the list of items the same length as the new adds array
		// created
		items = new Listable[adds.length];
		for (int u = 0; u < adds.length; u++) {
			// assign the values of the items to the new array adds
			items[u] = adds[u];
		}

	}

	/**
	 * Adds an entire list of items to the current list, maintaining the
	 * alphabetical ordering of the list by the names of the items.
	 * 
	 * @param listToAdd a list of items that are to be added to the current
	 *                  object
	 */
	public void add(SortedListOfImmutables listToAdd) {
		for (int index = 0; index < listToAdd.items.length; index++) {
			this.add(listToAdd.items[index]);
		}

	}

	/**
	 * Removes an item from the list.
	 * 
	 * If the list contains the same item that the parameter refers to, it will
	 * be removed from the list.Only return one instance of the itemTORemove
	 * indicated else if the item to remove indicated is not in the list then
	 * the method doesn't remove anything
	 * 
	 * @param itemToRemove refers to the item that is to be removed from the
	 *                     list
	 */
	public void remove(Listable itemToRemove) {
		int axis = 0;
		int back = 0;
		for (int index = 0; index < items.length; index++) {
			if (items[index] == itemToRemove) {
				axis = index;
				back++;
			}
		}
		if (back > 0) {
			Listable remove[] = new Listable[items.length - 1];
			for (int index = 0; index < remove.length; index++) {
				if (index < axis) {
					remove[index] = items[index];
				} else {
					remove[index] = items[index + 1];
				}
			}
			items = new Listable[remove.length];
			for (int index = 0; index < remove.length; index++) {
				items[index] = remove[index];
			}
		}

	}

	/**
	 * Removes an entire list of items from the current list. Any items in the
	 * parameter that appear in the current list are removed; any items in the
	 * parameter that do not appear in the current list are ignored.
	 * 
	 * @param listToRemove list of items that are to be removed from this list
	 */
	public void remove(SortedListOfImmutables listToRemove) {
		for (int index = 0; index < listToRemove.items.length; index++) {
			this.remove(listToRemove.items[index]);
		}
	}

	/**
	 * Returns the sum of the wholesale costs of all items in the list.
	 * 
	 * @return sum of the wholesale costs of all items in the list
	 */
	public int getWholesaleCost() {
		int totalWholeSaleCost = 0;
		for (int index = 0; index < items.length; index++) {
			totalWholeSaleCost = totalWholeSaleCost
					+ items[index].getWholesaleCost();
		}
		return totalWholeSaleCost;
	}

	/**
	 * Returns the sum of the retail values of all items in the list.
	 * 
	 * @return sum of the retail values of all items in the list
	 */
	public int getRetailValue() {
		int totalRetailValue = 0;
		for (int index = 0; index < items.length; index++) {
			totalRetailValue = totalRetailValue + items[index].getRetailValue();
		}
		return totalRetailValue;

	}

	/**
	 * This method Checks to see if a particular item is in the list.
	 * 
	 * @param itemToFind item to look for
	 * @return true if the item is found in the list, false otherwise
	 */
	public boolean checkAvailability(Listable itemToFind) {
		for (int index = 0; index < items.length; index++) {
			if (items[index].equals(itemToFind)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if a list of items is contained in the current list. (In other
	 * words, this method will return true if ALL of the items in the parameter
	 * are contained in the current list. If anything is missing, then the
	 * return value will be false.)
	 * 
	 * @param listToCheck list of items that may or may not be a subset of the
	 *                    current list
	 * @return true if the parameter is a subset of the current list; false
	 *         otherwise
	 */
	public boolean checkAvailability(SortedListOfImmutables listToCheck) {
		Listable[] check = new Listable[items.length];
		for (int index = 0; index < items.length; index++) {
			check[index] = items[index];
		}
		int pair = 0;
		for (int index = 0; index < listToCheck.items.length; index++) {
			if (this.checkAvailability(listToCheck.items[index]) == true) {
				this.remove(listToCheck.items[index]);
				pair++;
			}
		}
		items = new Listable[check.length];
		for (int index = 0; index < check.length; index++) {
			items[index] = check[index];
		}
		if (pair == listToCheck.items.length) {
			// returns true if items in the parameter are contained in the
			// current list
			return true;
		} else {
			// returns if false if there if the list doesn't match parameter
			return false;
		}
	}

	public String toString() {
		String retValue = "[ ";
		for (int i = 0; i < items.length; i++) {
			if (i != 0) {
				retValue += ", ";
			}
			retValue += items[i];
		}
		retValue += " ]";
		return retValue;
	}
}
