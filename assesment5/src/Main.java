import java.util.List;
import java.util.Scanner;

import com.assesment.dao.StockDAO;
import com.assesment.modal.StockModule;

public class Main {

	
		public static void main(String[] args) {
			 int option = 0;
			
		        Scanner s = new Scanner(System.in);
	            StockDAO f=new StockDAO();
			 
			  do{
		            System.out.println("\nMENU");
		           
		            System.out.println("1. Add item in inventory");
		            System.out.println("2. Update item in inventory ");
		            System.out.println("3. Delete item from inventory ");
		            System.out.println("4. Print item from inventory");
		            System.out.println("Option:");
		            option=s.nextInt();
		            switch (option){
	                case 1:
	                	
	                     f.addStocks(); 
	                    break;
	                case 2:
	                	System.out.println("Name of the product to update:");
	                	String name=s.next();
	                	
	                	f.updateProduct(name);
	                    break;
	                case 3:
	                	System.out.println("Name of the product to delete:");
	                	String name1=s.next();
	                
	                	f.deleteStockModule(name1);
	                	break;
	                	
	                case 4:
	                    List<StockModule> sm=f.printStockModule();
	                    for(StockModule i:sm)
	                    {
	                    	System.out.println(i);
	                    }
	                    break;
	 
	                default:
	                	option=5;
	                	break;
	            }
	        }while ( option !=5);	

		}

}
