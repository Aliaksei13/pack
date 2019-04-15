set projectLocation=C:\Users\anduser\IdeaProjects\indiegogo

cd %projectLocation%

set classpath=%projectLocation%\target\test-classes;%projectLocation%\lib\*

java org.testng.TestNG %projectLocation%\src\test\java\Suite.xml

pause

