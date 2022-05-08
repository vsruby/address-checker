# Address Checker

## Setup
1. Make sure that both Java 17 and maven are installed
2. Add the csv to be checked into the `src/main/resources/csvs` directory
3. Copy the `.env.sample` into a new file called `.env` and fill in the values
   1. The `ADDRESS_VERIFICATION_API_KEY` is used for the api key provided by the Address Validator
   2. The `CSV_TO_CHECK` is used for the filename that will be checked
      1. If left empty the system will fallback to `addresses.csv`

## Build and Run
1. Make sure you have navigated to the root of the project
2. Run the command `mvn clean package`
3. Run the command `java -jar target/address-checker-1.0.0-SNAPSHOT-spring-boot.jar`