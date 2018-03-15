
export MAVEN_OPTS="-Djavax.xml.accessExternalSchema=all"

# this is used to set the path of jUnit file
junitFilePath="**/target/surefire-reports/*.xml"

# this is used to set the path of jUnit file
htmlFilePath="**/target/surefire-reports/*.html"

# this is used to set the path of testNG file
testNGFilePath="**/target/surefire-reports/testng-results.xml"

# this is used to set the recipient list to send email notification
emailRecipientList="Kinjal_Rathod@intuit.com,Krystal_Le@intuit.com"

# this is used to set the path of target.zip
targetArchivePath="target.zip"

#Assigning the default value to the parameters if empty

: ${junitFilePath:="target/test-reports/*.xml"}
: ${testNGFilePath:="**/target/testng-results.xml"}
: ${targetArchivePath:="target.zip"}


# This will create a properties file and it will have all the paramerets required for post build actions

echo "Creating jenkins.properties file..."
rm -rf jenkins.properties
echo "junitFilePath=$junitFilePath" >> jenkins.properties
echo "testNGFilePath=$testNGFilePath" >> jenkins.properties
echo "emailRecipientList=$emailRecipientList" >> jenkins.properties
echo "targetArchivePath=$targetArchivePath" >> jenkins.properties
echo "htmlFilePath=$htmlFilePath" >> jenkins.properties


#Printing the jenkins.properties file on console for verification
echo "***************  jenkins.properties start  ******************"
cat jenkins.properties
echo "***************  jenkins.properties end  ********************"


cd sample-UI
mvn clean test 

rm -rf ../target.zip;
zip -r ../target.zip target;

targetArchivePath="target.zip"
