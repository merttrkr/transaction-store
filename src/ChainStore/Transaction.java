package ChainStore;
public class Transaction {
	
	    private double purchasePrice;
	    private double salePrice;
	    private double numberOfSales;

	    public Transaction(double purchasePrice, double salePrice, double numberOfSales) {

	        this.purchasePrice = purchasePrice;
	        this.salePrice = salePrice;
	        this.numberOfSales = numberOfSales;
	    }
	    


	    public double getPurchasePrice() {
	        return purchasePrice;
	    }

	    public double getSalePrice() {
	        return salePrice;
	    }

	    public double getNumberOfSales() {
	        return numberOfSales;
	    }


}
