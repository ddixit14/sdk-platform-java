/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/audit/audit_log.proto

package com.google.cloud.audit;

public final class AuditLogProto {
  private AuditLogProto() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_audit_AuditLog_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_audit_AuditLog_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_audit_AuthenticationInfo_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_audit_AuthenticationInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_audit_AuthorizationInfo_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_audit_AuthorizationInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_audit_RequestMetadata_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_audit_RequestMetadata_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n\"google/cloud/audit/audit_log.proto\022\022go"
          + "ogle.cloud.audit\032\034google/api/annotations"
          + ".proto\032\031google/protobuf/any.proto\032\034googl"
          + "e/protobuf/struct.proto\032\027google/rpc/stat"
          + "us.proto\"\324\003\n\010AuditLog\022\024\n\014service_name\030\007 "
          + "\001(\t\022\023\n\013method_name\030\010 \001(\t\022\025\n\rresource_nam"
          + "e\030\013 \001(\t\022\032\n\022num_response_items\030\014 \001(\003\022\"\n\006s"
          + "tatus\030\002 \001(\0132\022.google.rpc.Status\022C\n\023authe"
          + "ntication_info\030\003 \001(\0132&.google.cloud.audi"
          + "t.AuthenticationInfo\022A\n\022authorization_in"
          + "fo\030\t \003(\0132%.google.cloud.audit.Authorizat"
          + "ionInfo\022=\n\020request_metadata\030\004 \001(\0132#.goog"
          + "le.cloud.audit.RequestMetadata\022(\n\007reques"
          + "t\030\020 \001(\0132\027.google.protobuf.Struct\022)\n\010resp"
          + "onse\030\021 \001(\0132\027.google.protobuf.Struct\022*\n\014s"
          + "ervice_data\030\017 \001(\0132\024.google.protobuf.Any\""
          + "-\n\022AuthenticationInfo\022\027\n\017principal_email"
          + "\030\001 \001(\t\"J\n\021AuthorizationInfo\022\020\n\010resource\030"
          + "\001 \001(\t\022\022\n\npermission\030\002 \001(\t\022\017\n\007granted\030\003 \001"
          + "(\010\"H\n\017RequestMetadata\022\021\n\tcaller_ip\030\001 \001(\t"
          + "\022\"\n\032caller_supplied_user_agent\030\002 \001(\tBb\n\026"
          + "com.google.cloud.auditB\rAuditLogProtoP\001Z"
          + "7google.golang.org/genproto/googleapis/c"
          + "loud/audit;auditb\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.google.api.AnnotationsProto.getDescriptor(),
              com.google.protobuf.AnyProto.getDescriptor(),
              com.google.protobuf.StructProto.getDescriptor(),
              com.google.rpc.StatusProto.getDescriptor(),
            });
    internal_static_google_cloud_audit_AuditLog_descriptor =
        getDescriptor().getMessageTypes().get(0);
    internal_static_google_cloud_audit_AuditLog_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_audit_AuditLog_descriptor,
            new java.lang.String[] {
              "ServiceName",
              "MethodName",
              "ResourceName",
              "NumResponseItems",
              "Status",
              "AuthenticationInfo",
              "AuthorizationInfo",
              "RequestMetadata",
              "Request",
              "Response",
              "ServiceData",
            });
    internal_static_google_cloud_audit_AuthenticationInfo_descriptor =
        getDescriptor().getMessageTypes().get(1);
    internal_static_google_cloud_audit_AuthenticationInfo_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_audit_AuthenticationInfo_descriptor,
            new java.lang.String[] {
              "PrincipalEmail",
            });
    internal_static_google_cloud_audit_AuthorizationInfo_descriptor =
        getDescriptor().getMessageTypes().get(2);
    internal_static_google_cloud_audit_AuthorizationInfo_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_audit_AuthorizationInfo_descriptor,
            new java.lang.String[] {
              "Resource", "Permission", "Granted",
            });
    internal_static_google_cloud_audit_RequestMetadata_descriptor =
        getDescriptor().getMessageTypes().get(3);
    internal_static_google_cloud_audit_RequestMetadata_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_audit_RequestMetadata_descriptor,
            new java.lang.String[] {
              "CallerIp", "CallerSuppliedUserAgent",
            });
    com.google.api.AnnotationsProto.getDescriptor();
    com.google.protobuf.AnyProto.getDescriptor();
    com.google.protobuf.StructProto.getDescriptor();
    com.google.rpc.StatusProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
