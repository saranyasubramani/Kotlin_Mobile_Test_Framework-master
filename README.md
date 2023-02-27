# Kotlin_Mobile_Test_Framework
This Framework for mobile testing using android and ios real devices.
I used:
1. Kotlin - programming language
2. Maven - for dependencies
3. Selenide - library with good implicit/explicit waits and understandable assertions
4. Guice - the library for quick page initialization
5. Allure - for creating test execution reports that are clear to everyone in the team
6. TestNG - Testing framework
7. Appium - driver for mobile testing

# How to execute tests:
Run in terminal(mac os)
1. appium start: appium --allow-insecure=get_server_logs - we need it for log generation
2. execute all tests: mvn clean test  
3. generate allure report: mvn allure:serve. Please install Allure using the guidelines from the link: https://www.swtestacademy.com/allure-report-testng/
4. execute 1 test - just to press the debug button near some test
