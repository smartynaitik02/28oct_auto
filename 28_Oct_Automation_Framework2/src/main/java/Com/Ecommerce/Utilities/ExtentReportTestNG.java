package Com.Ecommerce.Utilities;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import freemarker.template.SimpleDate;
import net.bytebuddy.utility.RandomString;

public class ExtentReportTestNG {

	

	static ExtentReports extents;
	
	public static ExtentReports getReportObject()
	{
	
		String Timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		String Name = "ExtentReport --"+Timestamp;
		
		Path resourceDirectory = Paths.get("src","test","resources");
		
		String absolutePath = resourceDirectory.toFile().getAbsolutePath();
		
		System.out.println(absolutePath);
		
		String Path = absolutePath+"/Reports/"+Name+""+".html";
		
		ExtentHtmlReporter reporter =new ExtentHtmlReporter(Path);
		
		reporter.config().setReportName("28March Framework extent report");
		reporter.config().setDocumentTitle("28March Framework execution result");

		extents= new ExtentReports();
		
		extents.attachReporter(reporter);
		
		extents.setSystemInfo("Name", "Ranjeet Kendre");
		extents.setSystemInfo("Suite Name", "Regression/Smoke");

       return extents;
	}
	   
	 
	 
}
