package Oracle.com.breadcrumb;

import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VarifyBreadCrumb {
static{
	System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
      }
	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://www-stage.oracle.com/storage/nas/storage-appliance-encryption/index.html");
	                                  try{
	                               Thread.sleep(3000);}
	                               catch( InterruptedException e )
	                                    {
		                                  }
	
	String sB[]={".//div[@class='u03 u03v0']//a",".//div[@class='u03 u03v1']//a",".//div[@class='u03 u03v2']//a",".//div[@class='u03 u03v3']//a",".//div[@class='u03 u03v4']//a"};
	            
	                                int k=0;
	            
	                                for(int b=0;b<=sB.length;b++){
	                                try{
		                            List<WebElement> BCb=driver.findElements(By.xpath(sB[b]));
		                            int size= BCb.size();
		                            String BreadcrumbLinks[] =new String[size];
		                            k=1;
		                            for(int i=0;i<=size-1;i++){
		                        	BreadcrumbLinks[i]= BCb.get(i).getAttribute("href");
		                        	
		                   
		                           }
		                           for(int j=0;j<=size-1;j++){
		                        	driver.navigate().to(BreadcrumbLinks[j]);  
		                        	String cUforBC= driver.getCurrentUrl();
		                        	System.out.println(cUforBC); 
		                            String titleBC= driver.getTitle();
		                        	          if(cUforBC.contains("index.html")){
		                        	        	  System.out.println(titleBC+"              301 does Not redirected");
		                        	          }
		                        	          else{
		                        	        	  System.out.println(titleBC+"              301 is redirect successful");
		                        	          }
		                           }
		                           }
	
	                             catch(NoSuchElementException e){
		                         System.out.println("NO Bread Crumb Available");
	                               }
	                               if(k==1){
	                               break;  }
	                               else{
	                            	   
	                                   }
	                               }
	                           driver.close(); 

	                                    }

                                        }
