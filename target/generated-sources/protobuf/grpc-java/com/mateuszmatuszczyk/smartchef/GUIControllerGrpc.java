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
 * The GUI Controller service definition
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.19.0)",
    comments = "Source: controller.proto")
public final class GUIControllerGrpc {

  private GUIControllerGrpc() {}

  public static final String SERVICE_NAME = "smartchef.GUIController";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.mateuszmatuszczyk.smartchef.ControllerStatus> getSwitchOnMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "switchOn",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.mateuszmatuszczyk.smartchef.ControllerStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.mateuszmatuszczyk.smartchef.ControllerStatus> getSwitchOnMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.mateuszmatuszczyk.smartchef.ControllerStatus> getSwitchOnMethod;
    if ((getSwitchOnMethod = GUIControllerGrpc.getSwitchOnMethod) == null) {
      synchronized (GUIControllerGrpc.class) {
        if ((getSwitchOnMethod = GUIControllerGrpc.getSwitchOnMethod) == null) {
          GUIControllerGrpc.getSwitchOnMethod = getSwitchOnMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.mateuszmatuszczyk.smartchef.ControllerStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smartchef.GUIController", "switchOn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mateuszmatuszczyk.smartchef.ControllerStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new GUIControllerMethodDescriptorSupplier("switchOn"))
                  .build();
          }
        }
     }
     return getSwitchOnMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.mateuszmatuszczyk.smartchef.ControllerStatus> getSwitchOffMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "switchOff",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.mateuszmatuszczyk.smartchef.ControllerStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.mateuszmatuszczyk.smartchef.ControllerStatus> getSwitchOffMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.mateuszmatuszczyk.smartchef.ControllerStatus> getSwitchOffMethod;
    if ((getSwitchOffMethod = GUIControllerGrpc.getSwitchOffMethod) == null) {
      synchronized (GUIControllerGrpc.class) {
        if ((getSwitchOffMethod = GUIControllerGrpc.getSwitchOffMethod) == null) {
          GUIControllerGrpc.getSwitchOffMethod = getSwitchOffMethod = 
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.mateuszmatuszczyk.smartchef.ControllerStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "smartchef.GUIController", "switchOff"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.mateuszmatuszczyk.smartchef.ControllerStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new GUIControllerMethodDescriptorSupplier("switchOff"))
                  .build();
          }
        }
     }
     return getSwitchOffMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GUIControllerStub newStub(io.grpc.Channel channel) {
    return new GUIControllerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GUIControllerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GUIControllerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GUIControllerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GUIControllerFutureStub(channel);
  }

  /**
   * <pre>
   * The GUI Controller service definition
   * </pre>
   */
  public static abstract class GUIControllerImplBase implements io.grpc.BindableService {

    /**
     */
    public void switchOn(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.ControllerStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getSwitchOnMethod(), responseObserver);
    }

    /**
     */
    public void switchOff(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.ControllerStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getSwitchOffMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSwitchOnMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.mateuszmatuszczyk.smartchef.ControllerStatus>(
                  this, METHODID_SWITCH_ON)))
          .addMethod(
            getSwitchOffMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.mateuszmatuszczyk.smartchef.ControllerStatus>(
                  this, METHODID_SWITCH_OFF)))
          .build();
    }
  }

  /**
   * <pre>
   * The GUI Controller service definition
   * </pre>
   */
  public static final class GUIControllerStub extends io.grpc.stub.AbstractStub<GUIControllerStub> {
    private GUIControllerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GUIControllerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GUIControllerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GUIControllerStub(channel, callOptions);
    }

    /**
     */
    public void switchOn(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.ControllerStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSwitchOnMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void switchOff(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.ControllerStatus> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSwitchOffMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The GUI Controller service definition
   * </pre>
   */
  public static final class GUIControllerBlockingStub extends io.grpc.stub.AbstractStub<GUIControllerBlockingStub> {
    private GUIControllerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GUIControllerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GUIControllerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GUIControllerBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.mateuszmatuszczyk.smartchef.ControllerStatus switchOn(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getSwitchOnMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.mateuszmatuszczyk.smartchef.ControllerStatus switchOff(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getSwitchOffMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The GUI Controller service definition
   * </pre>
   */
  public static final class GUIControllerFutureStub extends io.grpc.stub.AbstractStub<GUIControllerFutureStub> {
    private GUIControllerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GUIControllerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GUIControllerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GUIControllerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mateuszmatuszczyk.smartchef.ControllerStatus> switchOn(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getSwitchOnMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.mateuszmatuszczyk.smartchef.ControllerStatus> switchOff(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getSwitchOffMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SWITCH_ON = 0;
  private static final int METHODID_SWITCH_OFF = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GUIControllerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GUIControllerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SWITCH_ON:
          serviceImpl.switchOn((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.ControllerStatus>) responseObserver);
          break;
        case METHODID_SWITCH_OFF:
          serviceImpl.switchOff((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.mateuszmatuszczyk.smartchef.ControllerStatus>) responseObserver);
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

  private static abstract class GUIControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GUIControllerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.mateuszmatuszczyk.smartchef.GUIControllerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GUIController");
    }
  }

  private static final class GUIControllerFileDescriptorSupplier
      extends GUIControllerBaseDescriptorSupplier {
    GUIControllerFileDescriptorSupplier() {}
  }

  private static final class GUIControllerMethodDescriptorSupplier
      extends GUIControllerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GUIControllerMethodDescriptorSupplier(String methodName) {
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
      synchronized (GUIControllerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GUIControllerFileDescriptorSupplier())
              .addMethod(getSwitchOnMethod())
              .addMethod(getSwitchOffMethod())
              .build();
        }
      }
    }
    return result;
  }
}
