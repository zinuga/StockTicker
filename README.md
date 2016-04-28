Framework of Stock Price exercise
-------------------------------

Installation and SetUp
-------------------------------
Install gRPC runtime of your language of choice (Java, Go or Python) by studying grpc.io and github.com/grpc/grpc-java
Set up protoc and protoc plugin of your language and have dev environment set up. Use gradle or maven for Java.
Understand the Stock Ticker Proto.
Proto is available at https://github.com/zinuga/StockTicker/blob/master/src/main/proto/stock.proto


Stock Ticker App Exercise Steps
--------------------------------------

The exercise would involve the following steps in one of the three languages. (Java/Go/Python)
Simple application which has the following services (feel free to add)
Step 1: Get Stock Price given a Stock Symbol
Step 2: Add a Stock Symbol: Implement this
Step 3: Run GetStockPrice on newly added symbols
Step 4: Add a streaming method to get a stream of all symbols and prices
Step 5: Make the GetStockPrice a secure call so only allowed clients can call it.

Detailed Java Exercise Steps
----------------------------------
1. Configure your build for your project. 
..1. Set up gradle. ./gradlew; ./gradlew init
..2. Follow docs to include gRPC dependencies in build.gradle
..3. Basic Proto already exists in src/main/proto
..4. Run ./gradlew build
..5. Run ./gradlew installDist to generate binaries
..6. Run server: ./build/install/java/bin/stock-server-start to run server
..7. Run client: get stock values for GOOG and TSL

2. Edit proto to add a method to add stock symbols
...Implement on server side to save it.
...Do all steps to rebuild and rerun addstock successfully

3. Run getStock price for newly added symbol in step 2
Step 4:
Add a streaming method to proto to get a stream of stock symbols and prices
Implement streaming method on server side
Step 5:
Make the getPrice call secure so you only an authenticated client with certs can call


