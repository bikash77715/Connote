# Connote
Connote number generator for FMCC

# Used technologies
- Maven
- Java 8
- Sprint boot (2.5.6)
  - Dependency: Spring web
- IntelliJ IDEA
- Postman
# Working
The application runs on Tomcat server.
The application has api accesspoint: /connoteApi/carrierAccount which accepts request body of following format:
{
  "carrierName":"FreightmateCourierco",
	"accountNumber":"123ABC",
	"digits":10,
	"lastUsedIndex":19604,
	"rangeStart":19000,
	"rangeEnd":20000
}

The respose will be of the following form:
  FMCC123ABC00000196051
  
The Connote number is generated by concatinating data of carrier account together in the correct order. 
As a part of this process the consignment index is incremented from last used index , and the new index must be within the provided range to be valid. 
The number is padded with 0's to make the index "digits" characters long. 19605 -> 0000019605 when "digits" is 10. The checksum is calculated by 
 - Adding every second number in the index from the right starting at the first element
  ( 5 + 6 + 1 + 0 + 0 = 12 )
 - Multiply that number by 3
  ( 12 * 3 = 36 )
 - Adding every second number in the index from the right starting at the second element
( 0 + 9 + 0 + 0 + 0 = 9 )
 - Multiply that number by 7
    ( 9 * 7 = 63)
 - Add the results of step 1 and step 2
  ( 63 + 36 = 99 )
 - Get the difference between that number and the next multiple of 10, this is our checksum
  ( 100 - 99 = 1 )
  
# Classes
CarrierAccount class represents the carrier account. 
ConnoteApplication class is the main class of the app.
ConnoteApplicationController is the rest-controller class.
ConnoteGenerator class helps to genrate the connote number.
ConsoleLogger is used to log system events on the console.


