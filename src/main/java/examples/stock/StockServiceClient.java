package examples.stock;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A simple client that requests a greeting from the {@link HelloWorldServer}.
 */

public class StockServiceClient {
  private static final Logger logger = Logger.getLogger(StockServiceClient.class.getName());

  private final ManagedChannel channel;
  private final StockServiceGrpc.StockServiceBlockingStub blockingStub;

  /** Construct client connecting to HelloWorld server at {@code host:port}. */
  public StockServiceClient(String host, int port) {
    channel = ManagedChannelBuilder.forAddress(host, port)
        .usePlaintext(true)
        .build();
    blockingStub = StockServiceGrpc.newBlockingStub(channel);
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  /** Say hello to server. */
  public void askPrice(String symbol) {
    logger.info("Will try to get stock price for " + symbol + " ...");
    StockRequest request = StockRequest.newBuilder().setSymbol(symbol).build();
    StockReply response;
    try {
      response = blockingStub.getLastStockPrice(request);
    } catch (StatusRuntimeException e) {
      logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
      return;
    }
    logger.info("Price is: " + response.getPrice());
  }



  /**
   * Greet server. If provided, the first element of {@code args} is the name to use in the
   * greeting.
   */
  public static void main(String[] args) throws Exception {
    StockServiceClient client = new StockServiceClient("localhost", 50051);
    try {
      /* Access a service running on the local machine on port 50051 */
      String symbol = "VARUN";
      String value = "testing";	
      if (args.length > 0) {
        if(args[0].compareTo("get") == 0){
		symbol = args[1];
		System.out.println("Calling ask price");
		client.askPrice(symbol);
	}
      }
      
        }
	//client.askPrice(symbol);
    finally {
      client.shutdown();
    }
  }
}

