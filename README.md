
# How to Setup & Run the project:-
These are ways:

* Step 1: Download the code from repository and import in the eclipse
<p align="center">
<img width="250" height="250" src="Image/importFile.png"><br />
</p>


* Step 2: Click on Directory and Navigate to source code folder you have dowloaded. Select the Folder & Click on Select Folder Button
<p align="center">
<img width="250" height="250" src="Image/clickondirectory.png"><br />
</p>

<p align="center">
<img width="250" height="250" src="Image/selectFolder.png"><br />
</p>

* Step 3: Click on checkbox and click on Finish button
<p align="center">
<img width="250" height="250" src="Image/clickcheckboxandfinishbtn.png"><br />
</p>

* Step 4: Wait for the dependencies to be loaded
<p align="center">
<img width="300" height="250" src="Image/waitforprojecttoloaddependencies.png"><br />
</p>


* Step 5: Before we run the test this mandatory step as we have some special chars in page title. Right Click Project Weighwatchers->Properties. Under Resources select Other and from drop-down select UTF-8. Click Apply and Close button
<p align="center">
<img width="250" height="250" src="Image/settingpropertiespart1.png"><br />
</p>

<p align="center">
<img width="250" height="250" src="Image/settingpropertiespart2.png"><br />
</p>


* Step 6: Run test from testng.xml
<p align="center">
<img width="250" height="250" src="Image/runasTESTNGfromtestngxml.png"><br />
</p>


* Step 7: You will notice in Eclipse Console TestNG will start 
<p align="center">
<img width="300" height="250" src="Image/consolepart1.png"><br />
</p>


* Step 7: You will notice in Eclipse Console WebDriver will initiate ChomeDriver Session 
<p align="center">
<img width="700" height="250" src="Image/chromerdriverinitated.png"><br />
</p>

* Step 8: You will notice ChromeDriver will launch Chromer browser and all steps will execute in priority
<p align="center">
<img width="700" height="250" src="Image/chromeBrowserlaunched.png"><br />
</p>

OR You can execute at Class level

* Step 1: Right Click on WeightWatchersTest.java->Run As->TestNG Test
<p align="center">
<img width="300" height="250" src="Image/runtestfromclass.png"><br />
</p>

OR You can execute from Command line as Maven

* Step 1: Open the Project Folder root folder in Command Prompt
<p align="center">
<img width="700" height="250" src="Image/runasmvncommandine.png"><br />
</p>

```
   mvn clean install
```

* Step 2: You will notice it will download dependencies for the first time
<p align="center">
<img width="700" height="250" src="Image/runasmvncommandine.png"><br />
</p>


* Step 3: You will see it will execute test and test report number of test executed passed failed . Also it will print out the meetings details
<p align="center">
<img width="300" height="250" src="Image/commandlineoutputmvn.png"><br />
</p>
