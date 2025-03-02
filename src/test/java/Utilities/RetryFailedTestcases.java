package Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestcases implements IRetryAnalyzer {
private int count=1;
private int max_count=2;
	@Override
	public boolean retry(ITestResult result) {
		if(count<max_count) {
			count++;
			return true;
		}
		else
		return false;
	}
	

}
