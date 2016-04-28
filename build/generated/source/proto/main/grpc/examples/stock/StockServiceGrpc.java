package examples.stock;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;

@javax.annotation.Generated("by gRPC proto compiler")
public class StockServiceGrpc {

  private StockServiceGrpc() {}

  public static final String SERVICE_NAME = "stock.StockService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi
  public static final io.grpc.MethodDescriptor<examples.stock.StockRequest,
      examples.stock.StockReply> METHOD_GET_LAST_STOCK_PRICE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "stock.StockService", "GetLastStockPrice"),
          io.grpc.protobuf.ProtoUtils.marshaller(examples.stock.StockRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(examples.stock.StockReply.getDefaultInstance()));

  public static StockServiceStub newStub(io.grpc.Channel channel) {
    return new StockServiceStub(channel);
  }

  public static StockServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StockServiceBlockingStub(channel);
  }

  public static StockServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StockServiceFutureStub(channel);
  }

  public static interface StockService {

    public void getLastStockPrice(examples.stock.StockRequest request,
        io.grpc.stub.StreamObserver<examples.stock.StockReply> responseObserver);
  }

  public static interface StockServiceBlockingClient {

    public examples.stock.StockReply getLastStockPrice(examples.stock.StockRequest request);
  }

  public static interface StockServiceFutureClient {

    public com.google.common.util.concurrent.ListenableFuture<examples.stock.StockReply> getLastStockPrice(
        examples.stock.StockRequest request);
  }

  public static class StockServiceStub extends io.grpc.stub.AbstractStub<StockServiceStub>
      implements StockService {
    private StockServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StockServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StockServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StockServiceStub(channel, callOptions);
    }

    @java.lang.Override
    public void getLastStockPrice(examples.stock.StockRequest request,
        io.grpc.stub.StreamObserver<examples.stock.StockReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_LAST_STOCK_PRICE, getCallOptions()), request, responseObserver);
    }
  }

  public static class StockServiceBlockingStub extends io.grpc.stub.AbstractStub<StockServiceBlockingStub>
      implements StockServiceBlockingClient {
    private StockServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StockServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StockServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StockServiceBlockingStub(channel, callOptions);
    }

    @java.lang.Override
    public examples.stock.StockReply getLastStockPrice(examples.stock.StockRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_LAST_STOCK_PRICE, getCallOptions(), request);
    }
  }

  public static class StockServiceFutureStub extends io.grpc.stub.AbstractStub<StockServiceFutureStub>
      implements StockServiceFutureClient {
    private StockServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StockServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StockServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StockServiceFutureStub(channel, callOptions);
    }

    @java.lang.Override
    public com.google.common.util.concurrent.ListenableFuture<examples.stock.StockReply> getLastStockPrice(
        examples.stock.StockRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_LAST_STOCK_PRICE, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_LAST_STOCK_PRICE = 0;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StockService serviceImpl;
    private final int methodId;

    public MethodHandlers(StockService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_LAST_STOCK_PRICE:
          serviceImpl.getLastStockPrice((examples.stock.StockRequest) request,
              (io.grpc.stub.StreamObserver<examples.stock.StockReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static io.grpc.ServerServiceDefinition bindService(
      final StockService serviceImpl) {
    return io.grpc.ServerServiceDefinition.builder(SERVICE_NAME)
        .addMethod(
          METHOD_GET_LAST_STOCK_PRICE,
          asyncUnaryCall(
            new MethodHandlers<
              examples.stock.StockRequest,
              examples.stock.StockReply>(
                serviceImpl, METHODID_GET_LAST_STOCK_PRICE)))
        .build();
  }
}
