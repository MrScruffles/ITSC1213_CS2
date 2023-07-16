import java.util.ArrayList;

/**
 * The PetStoreSpecification interface defines the required functionalities for a pet store.
 * 
 * It includes methods for performing adoption drives and calculating the inventory value.
 * 
 * Classes implementing this interface must provide concrete implementations for these methods.
 * 
 * This interface is designed to be implemented by the PetStore class or its subclasses.
 * 
 * @author Ash
 */
interface PetStoreSpecification {
    
    /**
     * Performs an adoption drive for the given list of pets.
     * 
     * This method is responsible for handling the adoption of pets from the store.
     * It takes a list of pets as input and performs the adoption process.
     * 
     * @param pets the list of pets to be adopted
     */
    void adoptionDrive(ArrayList<Object> pets);

    /**
     * Calculates the inventory value of the pet store.
     * 
     * This method calculates the total value of all available pets in the store.
     * It returns the calculated inventory value as a double.
     * 
     * @return the inventory value of the pet store
     */
    double inventoryValue();
}
