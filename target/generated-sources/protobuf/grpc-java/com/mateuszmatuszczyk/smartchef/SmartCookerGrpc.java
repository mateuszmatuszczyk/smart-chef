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
 * The greeting service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.19.0)",
    comments = "Source: cooker.proto")
public final class SmartCookerGrpc {

  private SmartCookerGrpc() {}

  public static final String SERVICE_NAME = "smartchef.SmartCooker";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.mateuszmatuszczyk.smartchef.CookerStatus> getSwitchOnMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "switchOn",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.mateuszmatuszczyk.smartchef.CookerStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.mateuszmatuszczyk.smartchef.CookerStatus> getSwitchOnMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.mateuszmatuszczyk.smartchef.CookerStatus> getSwitchOnMethod;
    if ((getSwitchOnMethod = SmartCookerGrpc.getSwitchOnMethod) == null) {
      synchronized (SmartCookerGrpc.class) {
        if ((getSwitchOnMethod = SmartCookerGrpc.getSwitchOnMethod) == null) {
          SmartCookerGrpc.getSwitchOnMethod = getSwitchOnMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.mateuszmatuszczyk.smartchef.CookerStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smartchef.SmartCooker", "switchOn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mateuszmatuszczyk.smartchef.CookerStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartCookerMethodDescriptorSupplier("switchOn"))
                  .build();
          }
        }
     }
     return getSwitchOnMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.mateuszmatuszczyk.smartchef.CookerStatus> getSwitchOffMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "switchOff",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.mateuszmatuszczyk.smartchef.CookerStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.mateuszmatuszczyk.smartchef.CookerStatus> getSwitchOffMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.mateuszmatuszczyk.smartchef.CookerStatus> getSwitchOffMethod;
    if ((getSwitchOffMethod = SmartCookerGrpc.getSwitchOffMethod) == null) {
      synchronized (SmartCookerGrpc.class) {
        if ((getSwitchOffMethod = SmartCookerGrpc.getSwitchOffMethod) == null) {
          SmartCookerGrpc.getSwitchOffMethod = getSwitchOffMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.mateuszmatuszczyk.smartchef.CookerStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smartchef.SmartCooker", "switchOff"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mateuszmatuszczyk.smartchef.CookerStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartCookerMethodDescriptorSupplier("switchOff"))
                  .build();
          }
        }
     }
     return getSwitchOffMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.mateuszmatuszczyk.smartchef.CookerStatus> getCookerStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "cookerStatus",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.mateuszmatuszczyk.smartchef.CookerStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.mateuszmatuszczyk.smartchef.CookerStatus> getCookerStatusMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.mateuszmatuszczyk.smartchef.CookerStatus> getCookerStatusMethod;
    if ((getCookerStatusMethod = SmartCookerGrpc.getCookerStatusMethod) == null) {
      synchronized (SmartCookerGrpc.class) {
        if ((getCookerStatusMethod = SmartCookerGrpc.getCookerStatusMethod) == null) {
          SmartCookerGrpc.getCookerStatusMethod = getCookerStatusMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.mateuszmatuszczyk.smartchef.CookerStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smartchef.SmartCooker", "cookerStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mateuszmatuszczyk.smartchef.CookerStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartCookerMethodDescriptorSupplier("cookerStatus"))
                  .build();
          }
        }
     }
     return getCookerStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.mateuszmatuszczyk.smartchef.CookerStatus> getStartHeatingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "startHeating",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.mateuszmatuszczyk.smartchef.CookerStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.mateuszmatuszczyk.smartchef.CookerStatus> getStartHeatingMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.mateuszmatuszczyk.smartchef.CookerStatus> getStartHeatingMethod;
    if ((getStartHeatingMethod = SmartCookerGrpc.getStartHeatingMethod) == null) {
      synchronized (SmartCookerGrpc.class) {
        if ((getStartHeatingMethod = SmartCookerGrpc.getStartHeatingMethod) == null) {
          SmartCookerGrpc.getStartHeatingMethod = getStartHeatingMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.mateuszmatuszczyk.smartchef.CookerStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smartchef.SmartCooker", "startHeating"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mateuszmatuszczyk.smartchef.CookerStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartCookerMethodDescriptorSupplier("startHeating"))
                  .build();
          }
        }
     }
     return getStartHeatingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.mateuszmatuszczyk.smartchef.CookerStatus> getStopHeatingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "stopHeating",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.mateuszmatuszczyk.smartchef.CookerStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.mateuszmatuszczyk.smartchef.CookerStatus> getStopHeatingMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.mateuszmatuszczyk.smartchef.CookerStatus> getStopHeatingMethod;
    if ((getStopHeatingMethod = SmartCookerGrpc.getStopHeatingMethod) == null) {
      synchronized (SmartCookerGrpc.class) {
        if ((getStopHeatingMethod = SmartCookerGrpc.getStopHeatingMethod) == null) {
          SmartCookerGrpc.getStopHeatingMethod = getStopHeatingMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.mateuszmatuszczyk.smartchef.CookerStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "smartchef.SmartCooker", "stopHeating"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mateuszmatuszczyk.smartchef.CookerStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartCookerMethodDescriptorSupplier("stopHeating"))
                  .build();
          }
        }
     }
     return getStopHeatingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SmartCookerStub newStub(io.grpc.Channel channel) {
    return new SmartCookerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SmartCookerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SmartCookerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SmartCookerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SmartCookerFutureStub(channel);
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static abstract class SmartCookerImplBase implements io.grpc.BindableService {

    /**
     */
    public void switchOn(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.CookerStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getSwitchOnMethod(), responseObserver);
    }

    /**
     */
    public void switchOff(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.CookerStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getSwitchOffMethod(), responseObserver);
    }

    /**
     */
    public void cookerStatus(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.CookerStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getCookerStatusMethod(), responseObserver);
    }

    /**
     */
    public void startHeating(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.CookerStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getStartHeatingMethod(), responseObserver);
    }

    /**
     */
    public void stopHeating(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.CookerStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getStopHeatingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSwitchOnMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.mateuszmatuszczyk.smartchef.CookerStatus>(
                  this, METHODID_SWITCH_ON)))
          .addMethod(
            getSwitchOffMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.mateuszmatuszczyk.smartchef.CookerStatus>(
                  this, METHODID_SWITCH_OFF)))
          .addMethod(
            getCookerStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.mateuszmatuszczyk.smartchef.CookerStatus>(
                  this, METHODID_COOKER_STATUS)))
          .addMethod(
            getStartHeatingMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.mateuszmatuszczyk.smartchef.CookerStatus>(
                  this, METHODID_START_HEATING)))
          .addMethod(
            getStopHeatingMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.mateuszmatuszczyk.smartchef.CookerStatus>(
                  this, METHODID_STOP_HEATING)))
          .build();
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class SmartCookerStub extends io.grpc.stub.AbstractStub<SmartCookerStub> {
    private SmartCookerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartCookerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartCookerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartCookerStub(channel, callOptions);
    }

    /**
     */
    public void switchOn(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.CookerStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSwitchOnMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void switchOff(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.CookerStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSwitchOffMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cookerStatus(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.CookerStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCookerStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void startHeating(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.CookerStatus> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStartHeatingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void stopHeating(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.CookerStatus> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStopHeatingMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class SmartCookerBlockingStub extends io.grpc.stub.AbstractStub<SmartCookerBlockingStub> {
    private SmartCookerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartCookerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartCookerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartCookerBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.mateuszmatuszczyk.smartchef.CookerStatus switchOn(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getSwitchOnMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.mateuszmatuszczyk.smartchef.CookerStatus switchOff(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getSwitchOffMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.mateuszmatuszczyk.smartchef.CookerStatus cookerStatus(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getCookerStatusMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.mateuszmatuszczyk.smartchef.CookerStatus> startHeating(
        com.google.protobuf.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getStartHeatingMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.mateuszmatuszczyk.smartchef.CookerStatus> stopHeating(
        com.google.protobuf.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getStopHeatingMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class SmartCookerFutureStub extends io.grpc.stub.AbstractStub<SmartCookerFutureStub> {
    private SmartCookerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartCookerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartCookerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartCookerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mateuszmatuszczyk.smartchef.CookerStatus> switchOn(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getSwitchOnMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mateuszmatuszczyk.smartchef.CookerStatus> switchOff(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getSwitchOffMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mateuszmatuszczyk.smartchef.CookerStatus> cookerStatus(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getCookerStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SWITCH_ON = 0;
  private static final int METHODID_SWITCH_OFF = 1;
  private static final int METHODID_COOKER_STATUS = 2;
  private static final int METHODID_START_HEATING = 3;
  private static final int METHODID_STOP_HEATING = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SmartCookerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SmartCookerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SWITCH_ON:
          serviceImpl.switchOn((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.CookerStatus>) responseObserver);
          break;
        case METHODID_SWITCH_OFF:
          serviceImpl.switchOff((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.CookerStatus>) responseObserver);
          break;
        case METHODID_COOKER_STATUS:
          serviceImpl.cookerStatus((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.CookerStatus>) responseObserver);
          break;
        case METHODID_START_HEATING:
          serviceImpl.startHeating((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.CookerStatus>) responseObserver);
          break;
        case METHODID_STOP_HEATING:
          serviceImpl.stopHeating((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.CookerStatus>) responseObserver);
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

  private static abstract class SmartCookerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SmartCookerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.mateuszmatuszczyk.smartchef.SmartCookerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SmartCooker");
    }
  }

  private static final class SmartCookerFileDescriptorSupplier
      extends SmartCookerBaseDescriptorSupplier {
    SmartCookerFileDescriptorSupplier() {}
  }

  private static final class SmartCookerMethodDescriptorSupplier
      extends SmartCookerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SmartCookerMethodDescriptorSupplier(String methodName) {
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
      synchronized (SmartCookerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SmartCookerFileDescriptorSupplier())
              .addMethod(getSwitchOnMethod())
              .addMethod(getSwitchOffMethod())
              .addMethod(getCookerStatusMethod())
              .addMethod(getStartHeatingMethod())
              .addMethod(getStopHeatingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
