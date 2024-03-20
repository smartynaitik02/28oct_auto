package Com.Ecommerce.Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	int count =0;
	
	int RetrLimit= 0;  //2<2
	
	public boolean retry(ITestResult result) {

		if(count<RetrLimit) {
			count++;
			return true;
		}
		return false;
	}

}
