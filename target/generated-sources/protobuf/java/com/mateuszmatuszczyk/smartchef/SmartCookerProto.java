// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: cooker.proto

package com.mateuszmatuszczyk.smartchef;

public final class SmartCookerProto {
  private SmartCookerProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_smartchef_CookerStatus_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_smartchef_CookerStatus_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014cooker.proto\022\tsmartchef\032\033google/protob" +
      "uf/empty.proto\"K\n\014CookerStatus\022\023\n\013status" +
      "OnOff\030\001 \001(\010\022\021\n\tstatusMsg\030\002 \001(\t\022\023\n\013temper" +
      "ature\030\003 \001(\0052\330\002\n\013SmartCooker\022=\n\010switchOn\022" +
      "\026.google.protobuf.Empty\032\027.smartchef.Cook" +
      "erStatus\"\000\022>\n\tswitchOff\022\026.google.protobu" +
      "f.Empty\032\027.smartchef.CookerStatus\"\000\022A\n\014co" +
      "okerStatus\022\026.google.protobuf.Empty\032\027.sma" +
      "rtchef.CookerStatus\"\000\022C\n\014startHeating\022\026." +
      "google.protobuf.Empty\032\027.smartchef.Cooker" +
      "Status\"\0000\001\022B\n\013stopHeating\022\026.google.proto" +
      "buf.Empty\032\027.smartchef.CookerStatus\"\0000\001B5" +
      "\n\037com.mateuszmatuszczyk.smartchefB\020Smart" +
      "CookerProtoP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.EmptyProto.getDescriptor(),
        }, assigner);
    internal_static_smartchef_CookerStatus_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_smartchef_CookerStatus_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_smartchef_CookerStatus_descriptor,
        new java.lang.String[] { "StatusOnOff", "StatusMsg", "Temperature", });
    com.google.protobuf.EmptyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
