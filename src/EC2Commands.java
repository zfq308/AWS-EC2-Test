import java.util.List;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.ec2.model.RunInstancesResult;
import com.amazonaws.services.ec2.model.StopInstancesRequest;
import com.amazonaws.services.ec2.model.StopInstancesResult;
import com.amazonaws.services.ec2.model.TerminateInstancesRequest;
import com.amazonaws.services.ec2.model.TerminateInstancesResult;
import com.amazonaws.services.lightsail.model.StopInstanceRequest;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.util.Base64;

public class EC2Commands {
	static AmazonEC2 amazonEC2Client;
	static AmazonS3 s3Client;
	static String keyName = "aws-test";
	static String sgName = "default";
	
	public static void main(String[] args) {
		amazonEC2Client = AmazonEC2ClientBuilder.standard().withRegion("us-west-2").build();
		s3Client = new AmazonS3Client();
//		createInstance();
//		stopInstance();
//		createBucket();
//		putObject();
//		terminateInstance();
		listInstances();
	}
	
	static void createBucket(){
		String bucketName = ""; //Your bucket name
		Bucket bucket = s3Client.createBucket(bucketName);
		System.out.println("Create bucket:"+bucket.toString());
	}
	
	static void listBucket(){
		List<Bucket> buckets = s3Client.listBuckets();
		for( Bucket b : buckets){
			System.out.println(b.getName());
		}	
	}
	
	static void putObject(){
		String bucket = ""; //Your bucket name
		String key = ""; //Your key
		s3Client.putObject(bucket, key, "test content"); //Your content
	}
	static void createInstance(){
		RunInstancesRequest run = new RunInstancesRequest();
 	    run.withImageId("ami-f173cc91").withInstanceType("t2.micro").withMinCount(1).withMaxCount(1).withKeyName(keyName).withSecurityGroups(sgName);
		RunInstancesResult result = amazonEC2Client.runInstances(run);
		System.out.println("Instance Description:"+result.toString());
		
//		String userData = "#!/bin/bash\n mkdir jorge";
//		String formattedString = Base64.encodeAsString(userData.getBytes());
//		RunInstancesRequest run = new RunInstancesRequest();
//		
//		run.withImageId("ami-f173cc91").withInstanceType("t2.micro").withMinCount(1).withMaxCount(1).withKeyName(keyName).withSecurityGroups(sgName).withUserData(userData);
//		RunInstancesResult result = amazonEC2Client.runInstances(run);
//		System.out.println("Instance Description:"+result.toString());
		
	}
	static void stopInstance(){
		StopInstancesRequest stop = new StopInstancesRequest();
		stop.withInstanceIds(""); //Your instance ID
		StopInstancesResult result = amazonEC2Client.stopInstances(stop);
		System.out.println("Stop instance:"+result.toString());
	}
	
	static void terminateInstance(){
		TerminateInstancesRequest terminate = new TerminateInstancesRequest();
		terminate.withInstanceIds(""); //Your instance ID
		TerminateInstancesResult result = amazonEC2Client.terminateInstances(terminate);
		System.out.println("Terminate instance:"+result.toString());
	}
	static void listInstances(){
		System.out.println("list Instances");
		DescribeInstancesResult result = amazonEC2Client.describeInstances();
		result.getReservations(); //group instances
		List<Reservation> listReservation = result.getReservations();
		for(Reservation res: listReservation){
			List<Instance> listIntances = res.getInstances();
			for(Instance i: listIntances){
				System.out.println("Instance description:"+i.toString());
			}
		}
	}
	
}
