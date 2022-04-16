package ChainStore;
/**   
 * AnnualSale object class with all getter and setter methods
* @author  Mert Türker
* @author  Selin Baykal
*/
public class AnnualSale {
	
	    private ItemTransaction[] itemTransactionArray;
	    
	    public AnnualSale( ItemTransaction[] itemTransactionArray) {
			this.itemTransactionArray = itemTransactionArray;
		}

	    public ItemTransaction[] getItemTransactionArray() {
	        return itemTransactionArray;
	    }

	    public void setItemTransactionArray(ItemTransaction[] itemTransactionArray) {
	        this.itemTransactionArray = itemTransactionArray;
	    }

}

