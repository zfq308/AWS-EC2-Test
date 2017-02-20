import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.ec2.model.RunInstancesResult;

public class EC2Commands {
	static AmazonEC2 amazonEC2Client;
	static String keyName = "aws-test";
	static String sgName = "default";
	
	public static void main(String[] args) {
		amazonEC2Client = AmazonEC2ClientBuilder.standard().withRegion("us-west-2").build();
		createInstance();
	}
	static void createInstance(){
		RunInstancesRequest run = new RunInstancesRequest();
		run.withImageId("ami-f173cc91").withInstanceType("t2.micro").withMinCount(1).withMaxCount(1).withKeyName(keyName).withSecurityGroups(sgName);
		
		RunInstancesResult result = amazonEC2Client.runInstances(run);
		System.out.println("Instance Description:"+result.toString());
		
	}
}
