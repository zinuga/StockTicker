Framework of exercise
Take a sample Stock Ticker project and do the following exercise in Java. 

Install gRPC runtime of your language of choice (Java, Go or Python) by studying grpc.io and github.com/grpc/grpc-java
Set up protoc and protoc plugin of your language and have dev environment set up. Use gradle or maven for Java.
Understand the Stock Ticker Proto.
Proto is available at https://github.com/zinuga/StockTicker/blob/master/src/main/proto/stock.proto


Stock Ticker App Exercise Steps
The exercise would involve the following steps in one of the three languages. (Java/Go/Python)
Simple application which has the following services (feel free to add)
Step 1: Get Stock Price given a Stock Symbol
Step 2: Add a Stock Symbol: Implement this
Step 3: Run GetStockPrice on newly added symbols
Step 4: Add a streaming method to get a stream of all symbols and prices
Step 5: Make the GetStockPrice a secure call so only allowed clients can call it.

Detailed Java Exercise Steps
Step 1. 
Configure your build for your project. 
Set up gradle. ./gradlew; ./gradlew init
Follow docs to include gRPC dependencies in build.gradle
Basic Proto already exists in src/main/proto
Run ./gradlew build
Run ./gradlew installDist to generate binaries
Run server: ./build/install/java/bin/stock-server-start to run server
Run client: get stock values for GOOG and TSL
Step 2
Edit proto to add a method to add stock symbols
Implement on server side to save it.
Do all steps to rebuild and rerun addstock successfully
Step 3:
Run getStock price for newly added symbol in step 2
Step 4:
Add a streaming method to proto to get a stream of stock symbols and prices
Implement streaming method on server side
Step 5:
Make the getPrice call secure so you only an authenticated client with certs can call


