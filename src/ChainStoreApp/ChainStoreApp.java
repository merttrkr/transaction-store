package ChainStoreApp;
import java.io.IOException;
import ChainStore.StoreQuery;

public class ChainStoreApp {
    public static void main(String args[]) throws IOException{
        StoreQuery query = new StoreQuery();

        System.out.println("Most profitable item for the whole year : "+ query.mostProfitableItem());;
        System.out.println("Most profitable category for the whole year: "+ query.mostProfitableCategory());
        System.out.println("Least profitable item for the whole year: " + query.leastProfitableItem());
        System.out.println("Least profitable category for the whole year: "+ query.leastProfitableCategory());
        System.out.println("Most profitable item for a single sale: "+ query.mostProfitableItemsingleSale());
        System.out.println("Best-selling item for the whole year: " +query.bestsellingItem());
        System.out.println("Most profitable store for each month:");
        String[] results = query.mostProfitablestore(); 
        for (int i = 0; i < results.length; i++) {
            System.out.println((i+1) +" - " +  results[i]);
        }

}
}
