### Instructions to run the automation suite:

1. Used below test user accounts to create test data sets:
	- username:	@testuse56945177	(test_user_1)
	- password:	testuser@123
	- username:	@testuse66883556	(test_user_2)
	- password:	testuser@321

2. Download “Twitter_Phase_1”project in to your local machine.

3. Before running the project please make sure your local machine is ready with below requirements:
	- Install latest version of java.
	- install latest version of maven.

4. Download and copy latest chrome and firfox drivers to below locations:
	- Twitter_Phase_1\drivers\chromedriver\chromedriver.exe
	- Twitter_Phase_1\drivers\geckodriver\geckodriver.exe

5. If you intended to run the suite in firefox browser, go to“config.properties”file under“com.twitter.qa.config”directory and change the“browser”property to “firefox".

6. Using window command prompt, go to directory where you downloaded the local copy of the project.

7. Type "mvn install".

8. After the test execution, go inside “test-output” folder in the project directory, open the “index.html” file from a web browser.