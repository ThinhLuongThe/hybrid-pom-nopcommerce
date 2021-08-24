#!/bin/sh
echo "------ Step 01: Set project path to variable -------"
project_path="/Users/thinhluong/Downloads/LEARNING/Automation/hybrid-pom-nopcommerce"
echo "------ Step 02: Go to project path folder -------"
cd "$project_path"
echo $project_path
echo "------ Step 03: Run the testcases -------"
java -javaagent:"$project_path/logLibraries/Allure Report 2.13.5/aspectjweaver-1.8.10.jar" -classpath "$project_path/bin:$project_path/logLibraries/Allure Report 2.13.5/*:$project_path/logLibraries/Extent Report V4/*:$project_path/logLibraries/*:$project_path/libraries/*:$project_path/logLibraries/ReportNG/*:$project_path/browserDrivers/WebDriverManager4.2.0/*" org.testng.TestNG "$project_path/resources/runLiveguru99.xml"
echo "------ Step 04: Load allure command line setting -------"
source ~/.bash_profile
echo "------ Step 05: Generate Allure HTML Report -------"
allure serve ./allure-json/