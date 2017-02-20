# AWS-EC2-Test
This repository shows how to run EC2 instances by java.

# Registration
First, you need to register an AWS account. If you are a student in University, you can register an AWS educate account, which contains 75 or 100 free credits. 75 credits register for a educate starter account. 100 credits need credit card when you register an account. Also 100 credits need more time to check your information.

Ok, now you can login.(URL: https://awseducate.qwiklabs.com)

When you open console, you can see lots of services. 

# Launch an instance in lab
In order to launch your EC2 instances, you should create a key pair first. Just click on a key pair, enter your the name of it and download it. Remember the location you save key pair.
Now, you can launch an instance in the lab, there are different Amazon Machine Image (AMI) you can choose. Just select the first one since it's free:) And you can see a free tier available for you account. Select it and click review and launch.(You can set more details at this step) Then you can see information about your instance. Click launch and choose the key pair which creates before. Then, congratulations!! Your instances are now launching!!

# Connect to your instance by commands
In the page of the instance, you can click actions and then connect. You can see the detail to teach you how to get access to your instance. Also you can see the connect documentation. (https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/AccessingInstances.html?icmpid=docs_ec2_console)

# Launch an instance by java
Download AWS SDK Toolkit for Eclipse

Follow the instructions under "Install the AWS Toolkit for Eclipse":
http://docs.aws.amazon.com/toolkit-for-eclipse/v1/user-guide/setup-install.html

If you finish this step, you can open your eclipse and create a project. Add library (AWS SDK for Java) and you can see a different version of it. If you cannot see it, don't worry about it. Eclipse need time to configure it and What you can do is to close the windows and wait for configuration.

Then write code to run your instance and test connection by print it.

If you can see details about instance description. Congratulations!!

