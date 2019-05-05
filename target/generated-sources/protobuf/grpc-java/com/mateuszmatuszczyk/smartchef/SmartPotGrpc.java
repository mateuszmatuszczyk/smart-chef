package com.mateuszmatuszczyk.smartchef;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * The SmartPot service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.19.0)",
    comments = "Source: pot.proto")
public final class SmartPotGrpc {

  private SmartPotGrpc() {}

  public static final String SERVICE_NAME = "smartchef.SmartPot";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.mateuszmatuszczyk.smartchef.PotStatus> getSwitchOnMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "switchOn",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.mateuszmatuszczyk.smartchef.PotStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.mateuszmatuszczyk.smartchef.PotStatus> getSwitchOnMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.mateuszmatuszczyk.smartchef.PotStatus> getSwitchOnMethod;
    if ((getSwitchOnMethod = SmartPotGrpc.getSwitchOnMethod) == null) {
      synchronized (SmartPotGrpc.class) {
        if ((getSwitchOnMethod = SmartPotGrpc.getSwitchOnMethod) == null) {
          SmartPotGrpc.getSwitchOnMethod = getSwitchOnMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.mateuszmatuszczyk.smartchef.PotStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smartchef.SmartPot", "switchOn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mateuszmatuszczyk.smartchef.PotStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartPotMethodDescriptorSupplier("switchOn"))
                  .build();
          }
        }
     }
     return getSwitchOnMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.mateuszmatuszczyk.smartchef.PotStatus> getSwitchOffMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "switchOff",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.mateuszmatuszczyk.smartchef.PotStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.mateuszmatuszczyk.smartchef.PotStatus> getSwitchOffMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.mateuszmatuszczyk.smartchef.PotStatus> getSwitchOffMethod;
    if ((getSwitchOffMethod = SmartPotGrpc.getSwitchOffMethod) == null) {
      synchronized (SmartPotGrpc.class) {
        if ((getSwitchOffMethod = SmartPotGrpc.getSwitchOffMethod) == null) {
          SmartPotGrpc.getSwitchOffMethod = getSwitchOffMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.mateuszmatuszczyk.smartchef.PotStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smartchef.SmartPot", "switchOff"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mateuszmatuszczyk.smartchef.PotStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartPotMethodDescriptorSupplier("switchOff"))
                  .build();
          }
        }
     }
     return getSwitchOffMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.mateuszmatuszczyk.smartchef.PotStatus> getPotStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "potStatus",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.mateuszmatuszczyk.smartchef.PotStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.mateuszmatuszczyk.smartchef.PotStatus> getPotStatusMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.mateuszmatuszczyk.smartchef.PotStatus> getPotStatusMethod;
    if ((getPotStatusMethod = SmartPotGrpc.getPotStatusMethod) == null) {
      synchronized (SmartPotGrpc.class) {
        if ((getPotStatusMethod = SmartPotGrpc.getPotStatusMethod) == null) {
          SmartPotGrpc.getPotStatusMethod = getPotStatusMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.mateuszmatuszczyk.smartchef.PotStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smartchef.SmartPot", "potStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mateuszmatuszczyk.smartchef.PotStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartPotMethodDescriptorSupplier("potStatus"))
                  .build();
          }
        }
     }
     return getPotStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.mateuszmatuszczyk.smartchef.PotStatus> getAddWaterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addWater",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.mateuszmatuszczyk.smartchef.PotStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.mateuszmatuszczyk.smartchef.PotStatus> getAddWaterMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.mateuszmatuszczyk.smartchef.PotStatus> getAddWaterMethod;
    if ((getAddWaterMethod = SmartPotGrpc.getAddWaterMethod) == null) {
      synchronized (SmartPotGrpc.class) {
        if ((getAddWaterMethod = SmartPotGrpc.getAddWaterMethod) == null) {
          SmartPotGrpc.getAddWaterMethod = getAddWaterMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.mateuszmatuszczyk.smartchef.PotStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smartchef.SmartPot", "addWater"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mateuszmatuszczyk.smartchef.PotStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartPotMethodDescriptorSupplier("addWater"))
                  .build();
          }
        }
     }
     return getAddWaterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.mateuszmatuszczyk.smartchef.PotStatus> getCoverWithLidMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "coverWithLid",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.mateuszmatuszczyk.smartchef.PotStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.mateuszmatuszczyk.smartchef.PotStatus> getCoverWithLidMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.mateuszmatuszczyk.smartchef.PotStatus> getCoverWithLidMethod;
    if ((getCoverWithLidMethod = SmartPotGrpc.getCoverWithLidMethod) == null) {
      synchronized (SmartPotGrpc.class) {
        if ((getCoverWithLidMethod = SmartPotGrpc.getCoverWithLidMethod) == null) {
          SmartPotGrpc.getCoverWithLidMethod = getCoverWithLidMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.mateuszmatuszczyk.smartchef.PotStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smartchef.SmartPot", "coverWithLid"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mateuszmatuszczyk.smartchef.PotStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartPotMethodDescriptorSupplier("coverWithLid"))
                  .build();
          }
        }
     }
     return getCoverWithLidMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SmartPotStub newStub(io.grpc.Channel channel) {
    return new SmartPotStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SmartPotBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SmartPotBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SmartPotFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SmartPotFutureStub(channel);
  }

  /**
   * <pre>
   * The SmartPot service definition.
   * </pre>
   */
  public static abstract class SmartPotImplBase implements io.grpc.BindableService {

    /**
     */
    public void switchOn(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.PotStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getSwitchOnMethod(), responseObserver);
    }

    /**
     */
    public void switchOff(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.PotStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getSwitchOffMethod(), responseObserver);
    }

    /**
     */
    public void potStatus(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.PotStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getPotStatusMethod(), responseObserver);
    }

    /**
     */
    public void addWater(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.PotStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getAddWaterMethod(), responseObserver);
    }

    /**
     */
    public void coverWithLid(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.PotStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getCoverWithLidMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSwitchOnMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.mateuszmatuszczyk.smartchef.PotStatus>(
                  this, METHODID_SWITCH_ON)))
          .addMethod(
            getSwitchOffMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.mateuszmatuszczyk.smartchef.PotStatus>(
                  this, METHODID_SWITCH_OFF)))
          .addMethod(
            getPotStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.mateuszmatuszczyk.smartchef.PotStatus>(
                  this, METHODID_POT_STATUS)))
          .addMethod(
            getAddWaterMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.mateuszmatuszczyk.smartchef.PotStatus>(
                  this, METHODID_ADD_WATER)))
          .addMethod(
            getCoverWithLidMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.mateuszmatuszczyk.smartchef.PotStatus>(
                  this, METHODID_COVER_WITH_LID)))
          .build();
    }
  }

  /**
   * <pre>
   * The SmartPot service definition.
   * </pre>
   */
  public static final class SmartPotStub extends io.grpc.stub.AbstractStub<SmartPotStub> {
    private SmartPotStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartPotStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartPotStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartPotStub(channel, callOptions);
    }

    /**
     */
    public void switchOn(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.PotStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSwitchOnMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void switchOff(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.PotStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSwitchOffMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void potStatus(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.PotStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPotStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addWater(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.PotStatus> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getAddWaterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void coverWithLid(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.PotStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCoverWithLidMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The SmartPot service definition.
   * </pre>
   */
  public static final class SmartPotBlockingStub extends io.grpc.stub.AbstractStub<SmartPotBlockingStub> {
    private SmartPotBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartPotBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartPotBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartPotBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.mateuszmatuszczyk.smartchef.PotStatus switchOn(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getSwitchOnMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.mateuszmatuszczyk.smartchef.PotStatus switchOff(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getSwitchOffMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.mateuszmatuszczyk.smartchef.PotStatus potStatus(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getPotStatusMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.mateuszmatuszczyk.smartchef.PotStatus> addWater(
        com.google.protobuf.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getAddWaterMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.mateuszmatuszczyk.smartchef.PotStatus coverWithLid(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getCoverWithLidMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The SmartPot service definition.
   * </pre>
   */
  public static final class SmartPotFutureStub extends io.grpc.stub.AbstractStub<SmartPotFutureStub> {
    private SmartPotFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartPotFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartPotFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartPotFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mateuszmatuszczyk.smartchef.PotStatus> switchOn(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getSwitchOnMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mateuszmatuszczyk.smartchef.PotStatus> switchOff(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getSwitchOffMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mateuszmatuszczyk.smartchef.PotStatus> potStatus(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getPotStatusMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mateuszmatuszczyk.smartchef.PotStatus> coverWithLid(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getCoverWithLidMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SWITCH_ON = 0;
  private static final int METHODID_SWITCH_OFF = 1;
  private static final int METHODID_POT_STATUS = 2;
  private static final int METHODID_ADD_WATER = 3;
  private static final int METHODID_COVER_WITH_LID = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SmartPotImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SmartPotImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SWITCH_ON:
          serviceImpl.switchOn((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.PotStatus>) responseObserver);
          break;
        case METHODID_SWITCH_OFF:
          serviceImpl.switchOff((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.PotStatus>) responseObserver);
          break;
        case METHODID_POT_STATUS:
          serviceImpl.potStatus((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.PotStatus>) responseObserver);
          break;
        case METHODID_ADD_WATER:
          serviceImpl.addWater((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.PotStatus>) responseObserver);
          break;
        case METHODID_COVER_WITH_LID:
          serviceImpl.coverWithLid((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.PotStatus>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SmartPotBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SmartPotBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.mateuszmatuszczyk.smartchef.SmartPotProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SmartPot");
    }
  }

  private static final class SmartPotFileDescriptorSupplier
      extends SmartPotBaseDescriptorSupplier {
    SmartPotFileDescriptorSupplier() {}
  }

  private static final class SmartPotMethodDescriptorSupplier
      extends SmartPotBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SmartPotMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SmartPotGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SmartPotFileDescriptorSupplier())
              .addMethod(getSwitchOnMethod())
              .addMethod(getSwitchOffMethod())
              .addMethod(getPotStatusMethod())
              .addMethod(getAddWaterMethod())
              .addMethod(getCoverWithLidMethod())
              .build();
        }
      }
    }
    return result;
  }
}
