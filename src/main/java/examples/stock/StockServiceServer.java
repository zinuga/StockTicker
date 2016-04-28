package examples.stock;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.logging.Logger;
import java.util.HashMap;
import java.io.BufferedReader;
import java.text.ParseException;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Map;



/**
 * Server that manages startup/shutdown of a {@code Greeter} server.
 */

public class StockServiceServer {
  private static final Logger logger = Logger.getLogger(StockServiceServer.class.getName());

  /* The port on which the server should run */
  private int port = 50051;
  private Server server;
  private static HashMap stockmap;

  private void start() throws IOException {
    server = ServerBuilder.forPort(port)
        .addService(StockServiceGrpc.bindService(new StockServiceImpl()))
        .build()
        .start();
    logger.info("Server started, listening on " + port);
    
   	 
   Runtime.getRuntime().addShutdownHook(new Thread() {
      //@Override
      public void run() {
        // Use stderr here since the logger may have been reset by its JVM shutdown hook.
        System.err.println("*** shutting down gRPC server since JVM is shutting down");
        StockServiceServer.this.stop();
        System.err.println("*** server shut down");
      }
    });
  }

  private void stop() {
    if (server != null) {
      server.shutdown();
    }
  }

  /**
   * Await termination on the main thread since the grpc library uses daemon threads.
   */
  private void blockUntilShutdown() throws InterruptedException {
    if (server != null) {
      server.awaitTermination();
    }
  }


/* Simple Map Implementation */
private void initializeSimpleMap() throws ParseException, IOException{

    BufferedReader br = new BufferedReader(new FileReader("symbols.csv"));
    String line =  null;
    stockmap = new HashMap<String,String>();
    String symbolString = " ";
    String priceString = " ";

    while((line=br.readLine())!=null){
        String[] lineString = line.split(",");
        if (lineString.length > 1){
		symbolString = lineString[0];
        	priceString = lineString[1];
        }
	//System.out.println("Reading Symbol: " + symbolString);
        //System.out.println("Reading Value : " + priceString);
        stockmap.put(symbolString,priceString);
        }
 System.out.println(stockmap);   
}



  /**
   * Main launches the server from the command line.
   */
  public static void main(String[] args) throws IOException, ParseException, InterruptedException {
    final StockServiceServer server = new StockServiceServer();
    server.initializeSimpleMap();
    server.start();
    server.blockUntilShutdown();
    server.writetoFile(stockmap);	
}

  public void writetoFile(HashMap<String, Integer> map) throws IOException {
	
	try
	{

	File file = new File("symbols.csv");
	FileWriter fw = new FileWriter(file.getAbsoluteFile());
	BufferedWriter bw = new BufferedWriter(fw);
	Iterator it = stockmap.entrySet().iterator();
	while (it.hasNext())
	{
		Map.Entry pair = (Map.Entry)it.next();
		bw.write(pair.getKey() + "," + pair.getValue().toString());
		bw.write ('\n');
	}
	
	bw.close();

  	} catch (Exception e)
	{
		System.err.println(e.getMessage());

	}

}

  private class StockServiceImpl implements StockServiceGrpc.StockService {

    //@Override
  public void getLastStockPrice(examples.stock.StockRequest request,
        io.grpc.stub.StreamObserver<examples.stock.StockReply> responseObserver) {
        String companyName = request.getSymbol();
	System.out.println("Received symbol :" + companyName);
	//System.out.println(stockmap.containsKey(companyName));
	String priceString = (String)stockmap.get(companyName);
	System.out.println("value of stock is: " + priceString);
	int stockvalue = Integer.parseInt(priceString);
	StockReply reply = StockReply.newBuilder().setPrice(stockvalue).build();
      responseObserver.onNext(reply);
      responseObserver.onCompleted();
    }
  
}

}
