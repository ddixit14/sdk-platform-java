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
// source: google/api/label.proto

package com.google.api;

/**
 *
 *
 * <pre>
 * A description of a label.
 * </pre>
 *
 * Protobuf type {@code google.api.LabelDescriptor}
 */
public final class LabelDescriptor extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.api.LabelDescriptor)
    LabelDescriptorOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use LabelDescriptor.newBuilder() to construct.
  private LabelDescriptor(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private LabelDescriptor() {
    key_ = "";
    valueType_ = 0;
    description_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new LabelDescriptor();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private LabelDescriptor(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10:
            {
              java.lang.String s = input.readStringRequireUtf8();

              key_ = s;
              break;
            }
          case 16:
            {
              int rawValue = input.readEnum();

              valueType_ = rawValue;
              break;
            }
          case 26:
            {
              java.lang.String s = input.readStringRequireUtf8();

              description_ = s;
              break;
            }
          default:
            {
              if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.google.api.LabelProto.internal_static_google_api_LabelDescriptor_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.api.LabelProto.internal_static_google_api_LabelDescriptor_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.api.LabelDescriptor.class, com.google.api.LabelDescriptor.Builder.class);
  }

  /**
   *
   *
   * <pre>
   * Value types that can be used as label values.
   * </pre>
   *
   * Protobuf enum {@code google.api.LabelDescriptor.ValueType}
   */
  public enum ValueType implements com.google.protobuf.ProtocolMessageEnum {
    /**
     *
     *
     * <pre>
     * A variable-length string. This is the default.
     * </pre>
     *
     * <code>STRING = 0;</code>
     */
    STRING(0),
    /**
     *
     *
     * <pre>
     * Boolean; true or false.
     * </pre>
     *
     * <code>BOOL = 1;</code>
     */
    BOOL(1),
    /**
     *
     *
     * <pre>
     * A 64-bit signed integer.
     * </pre>
     *
     * <code>INT64 = 2;</code>
     */
    INT64(2),
    UNRECOGNIZED(-1),
    ;

    /**
     *
     *
     * <pre>
     * A variable-length string. This is the default.
     * </pre>
     *
     * <code>STRING = 0;</code>
     */
    public static final int STRING_VALUE = 0;
    /**
     *
     *
     * <pre>
     * Boolean; true or false.
     * </pre>
     *
     * <code>BOOL = 1;</code>
     */
    public static final int BOOL_VALUE = 1;
    /**
     *
     *
     * <pre>
     * A 64-bit signed integer.
     * </pre>
     *
     * <code>INT64 = 2;</code>
     */
    public static final int INT64_VALUE = 2;

    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static ValueType valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static ValueType forNumber(int value) {
      switch (value) {
        case 0:
          return STRING;
        case 1:
          return BOOL;
        case 2:
          return INT64;
        default:
          return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<ValueType> internalGetValueMap() {
      return internalValueMap;
    }

    private static final com.google.protobuf.Internal.EnumLiteMap<ValueType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<ValueType>() {
          public ValueType findValueByNumber(int number) {
            return ValueType.forNumber(number);
          }
        };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }

    public final com.google.protobuf.Descriptors.EnumDescriptor getDescriptorForType() {
      return getDescriptor();
    }

    public static final com.google.protobuf.Descriptors.EnumDescriptor getDescriptor() {
      return com.google.api.LabelDescriptor.getDescriptor().getEnumTypes().get(0);
    }

    private static final ValueType[] VALUES = values();

    public static ValueType valueOf(com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException("EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private ValueType(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:google.api.LabelDescriptor.ValueType)
  }

  public static final int KEY_FIELD_NUMBER = 1;
  private volatile java.lang.Object key_;
  /**
   *
   *
   * <pre>
   * The label key.
   * </pre>
   *
   * <code>string key = 1;</code>
   *
   * @return The key.
   */
  public java.lang.String getKey() {
    java.lang.Object ref = key_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      key_ = s;
      return s;
    }
  }
  /**
   *
   *
   * <pre>
   * The label key.
   * </pre>
   *
   * <code>string key = 1;</code>
   *
   * @return The bytes for key.
   */
  public com.google.protobuf.ByteString getKeyBytes() {
    java.lang.Object ref = key_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      key_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int VALUE_TYPE_FIELD_NUMBER = 2;
  private int valueType_;
  /**
   *
   *
   * <pre>
   * The type of data that can be assigned to the label.
   * </pre>
   *
   * <code>.google.api.LabelDescriptor.ValueType value_type = 2;</code>
   *
   * @return The enum numeric value on the wire for valueType.
   */
  public int getValueTypeValue() {
    return valueType_;
  }
  /**
   *
   *
   * <pre>
   * The type of data that can be assigned to the label.
   * </pre>
   *
   * <code>.google.api.LabelDescriptor.ValueType value_type = 2;</code>
   *
   * @return The valueType.
   */
  public com.google.api.LabelDescriptor.ValueType getValueType() {
    @SuppressWarnings("deprecation")
    com.google.api.LabelDescriptor.ValueType result =
        com.google.api.LabelDescriptor.ValueType.valueOf(valueType_);
    return result == null ? com.google.api.LabelDescriptor.ValueType.UNRECOGNIZED : result;
  }

  public static final int DESCRIPTION_FIELD_NUMBER = 3;
  private volatile java.lang.Object description_;
  /**
   *
   *
   * <pre>
   * A human-readable description for the label.
   * </pre>
   *
   * <code>string description = 3;</code>
   *
   * @return The description.
   */
  public java.lang.String getDescription() {
    java.lang.Object ref = description_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      description_ = s;
      return s;
    }
  }
  /**
   *
   *
   * <pre>
   * A human-readable description for the label.
   * </pre>
   *
   * <code>string description = 3;</code>
   *
   * @return The bytes for description.
   */
  public com.google.protobuf.ByteString getDescriptionBytes() {
    java.lang.Object ref = description_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      description_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;

  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
    if (!getKeyBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, key_);
    }
    if (valueType_ != com.google.api.LabelDescriptor.ValueType.STRING.getNumber()) {
      output.writeEnum(2, valueType_);
    }
    if (!getDescriptionBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, description_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getKeyBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, key_);
    }
    if (valueType_ != com.google.api.LabelDescriptor.ValueType.STRING.getNumber()) {
      size += com.google.protobuf.CodedOutputStream.computeEnumSize(2, valueType_);
    }
    if (!getDescriptionBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, description_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof com.google.api.LabelDescriptor)) {
      return super.equals(obj);
    }
    com.google.api.LabelDescriptor other = (com.google.api.LabelDescriptor) obj;

    if (!getKey().equals(other.getKey())) return false;
    if (valueType_ != other.valueType_) return false;
    if (!getDescription().equals(other.getDescription())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + KEY_FIELD_NUMBER;
    hash = (53 * hash) + getKey().hashCode();
    hash = (37 * hash) + VALUE_TYPE_FIELD_NUMBER;
    hash = (53 * hash) + valueType_;
    hash = (37 * hash) + DESCRIPTION_FIELD_NUMBER;
    hash = (53 * hash) + getDescription().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.api.LabelDescriptor parseFrom(java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.api.LabelDescriptor parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.api.LabelDescriptor parseFrom(com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.api.LabelDescriptor parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.api.LabelDescriptor parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.api.LabelDescriptor parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.api.LabelDescriptor parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.api.LabelDescriptor parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.api.LabelDescriptor parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.api.LabelDescriptor parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.api.LabelDescriptor parseFrom(com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.api.LabelDescriptor parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() {
    return newBuilder();
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(com.google.api.LabelDescriptor prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   *
   *
   * <pre>
   * A description of a label.
   * </pre>
   *
   * Protobuf type {@code google.api.LabelDescriptor}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.api.LabelDescriptor)
      com.google.api.LabelDescriptorOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.api.LabelProto.internal_static_google_api_LabelDescriptor_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.api.LabelProto.internal_static_google_api_LabelDescriptor_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.api.LabelDescriptor.class, com.google.api.LabelDescriptor.Builder.class);
    }

    // Construct using com.google.api.LabelDescriptor.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {}
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      key_ = "";

      valueType_ = 0;

      description_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.api.LabelProto.internal_static_google_api_LabelDescriptor_descriptor;
    }

    @java.lang.Override
    public com.google.api.LabelDescriptor getDefaultInstanceForType() {
      return com.google.api.LabelDescriptor.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.api.LabelDescriptor build() {
      com.google.api.LabelDescriptor result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.api.LabelDescriptor buildPartial() {
      com.google.api.LabelDescriptor result = new com.google.api.LabelDescriptor(this);
      result.key_ = key_;
      result.valueType_ = valueType_;
      result.description_ = description_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }

    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return super.setField(field, value);
    }

    @java.lang.Override
    public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }

    @java.lang.Override
    public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }

    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }

    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.api.LabelDescriptor) {
        return mergeFrom((com.google.api.LabelDescriptor) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.api.LabelDescriptor other) {
      if (other == com.google.api.LabelDescriptor.getDefaultInstance()) return this;
      if (!other.getKey().isEmpty()) {
        key_ = other.key_;
        onChanged();
      }
      if (other.valueType_ != 0) {
        setValueTypeValue(other.getValueTypeValue());
      }
      if (!other.getDescription().isEmpty()) {
        description_ = other.description_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.google.api.LabelDescriptor parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.google.api.LabelDescriptor) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object key_ = "";
    /**
     *
     *
     * <pre>
     * The label key.
     * </pre>
     *
     * <code>string key = 1;</code>
     *
     * @return The key.
     */
    public java.lang.String getKey() {
      java.lang.Object ref = key_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        key_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * The label key.
     * </pre>
     *
     * <code>string key = 1;</code>
     *
     * @return The bytes for key.
     */
    public com.google.protobuf.ByteString getKeyBytes() {
      java.lang.Object ref = key_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        key_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * The label key.
     * </pre>
     *
     * <code>string key = 1;</code>
     *
     * @param value The key to set.
     * @return This builder for chaining.
     */
    public Builder setKey(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      key_ = value;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The label key.
     * </pre>
     *
     * <code>string key = 1;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearKey() {

      key_ = getDefaultInstance().getKey();
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The label key.
     * </pre>
     *
     * <code>string key = 1;</code>
     *
     * @param value The bytes for key to set.
     * @return This builder for chaining.
     */
    public Builder setKeyBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      key_ = value;
      onChanged();
      return this;
    }

    private int valueType_ = 0;
    /**
     *
     *
     * <pre>
     * The type of data that can be assigned to the label.
     * </pre>
     *
     * <code>.google.api.LabelDescriptor.ValueType value_type = 2;</code>
     *
     * @return The enum numeric value on the wire for valueType.
     */
    public int getValueTypeValue() {
      return valueType_;
    }
    /**
     *
     *
     * <pre>
     * The type of data that can be assigned to the label.
     * </pre>
     *
     * <code>.google.api.LabelDescriptor.ValueType value_type = 2;</code>
     *
     * @param value The enum numeric value on the wire for valueType to set.
     * @return This builder for chaining.
     */
    public Builder setValueTypeValue(int value) {
      valueType_ = value;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The type of data that can be assigned to the label.
     * </pre>
     *
     * <code>.google.api.LabelDescriptor.ValueType value_type = 2;</code>
     *
     * @return The valueType.
     */
    public com.google.api.LabelDescriptor.ValueType getValueType() {
      @SuppressWarnings("deprecation")
      com.google.api.LabelDescriptor.ValueType result =
          com.google.api.LabelDescriptor.ValueType.valueOf(valueType_);
      return result == null ? com.google.api.LabelDescriptor.ValueType.UNRECOGNIZED : result;
    }
    /**
     *
     *
     * <pre>
     * The type of data that can be assigned to the label.
     * </pre>
     *
     * <code>.google.api.LabelDescriptor.ValueType value_type = 2;</code>
     *
     * @param value The valueType to set.
     * @return This builder for chaining.
     */
    public Builder setValueType(com.google.api.LabelDescriptor.ValueType value) {
      if (value == null) {
        throw new NullPointerException();
      }

      valueType_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The type of data that can be assigned to the label.
     * </pre>
     *
     * <code>.google.api.LabelDescriptor.ValueType value_type = 2;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearValueType() {

      valueType_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object description_ = "";
    /**
     *
     *
     * <pre>
     * A human-readable description for the label.
     * </pre>
     *
     * <code>string description = 3;</code>
     *
     * @return The description.
     */
    public java.lang.String getDescription() {
      java.lang.Object ref = description_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        description_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * A human-readable description for the label.
     * </pre>
     *
     * <code>string description = 3;</code>
     *
     * @return The bytes for description.
     */
    public com.google.protobuf.ByteString getDescriptionBytes() {
      java.lang.Object ref = description_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        description_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * A human-readable description for the label.
     * </pre>
     *
     * <code>string description = 3;</code>
     *
     * @param value The description to set.
     * @return This builder for chaining.
     */
    public Builder setDescription(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      description_ = value;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * A human-readable description for the label.
     * </pre>
     *
     * <code>string description = 3;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearDescription() {

      description_ = getDefaultInstance().getDescription();
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * A human-readable description for the label.
     * </pre>
     *
     * <code>string description = 3;</code>
     *
     * @param value The bytes for description to set.
     * @return This builder for chaining.
     */
    public Builder setDescriptionBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      description_ = value;
      onChanged();
      return this;
    }

    @java.lang.Override
    public final Builder setUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }

    // @@protoc_insertion_point(builder_scope:google.api.LabelDescriptor)
  }

  // @@protoc_insertion_point(class_scope:google.api.LabelDescriptor)
  private static final com.google.api.LabelDescriptor DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.api.LabelDescriptor();
  }

  public static com.google.api.LabelDescriptor getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LabelDescriptor> PARSER =
      new com.google.protobuf.AbstractParser<LabelDescriptor>() {
        @java.lang.Override
        public LabelDescriptor parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new LabelDescriptor(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<LabelDescriptor> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LabelDescriptor> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.api.LabelDescriptor getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
