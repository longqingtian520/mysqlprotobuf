// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: uav_flydata_bag.proto

package net.cc.luffy.entity.proto;

public final class UavFlyDataBagProto {
	private UavFlyDataBagProto() {
	}

	public static void registerAllExtensions(com.github.os72.protobuf351.ExtensionRegistryLite registry) {
	}

	public static void registerAllExtensions(com.github.os72.protobuf351.ExtensionRegistry registry) {
		registerAllExtensions((com.github.os72.protobuf351.ExtensionRegistryLite) registry);
	}

	public interface UavFlyDataBagOrBuilder extends
			// @@protoc_insertion_point(interface_extends:net.cc.luffy.entity.proto.UavFlyDataBag)
			com.github.os72.protobuf351.MessageOrBuilder {

		/**
		 * <code>map&lt;string, string&gt; data = 1;</code>
		 */
		int getDataCount();

		/**
		 * <code>map&lt;string, string&gt; data = 1;</code>
		 */
		boolean containsData(java.lang.String key);

		/**
		 * Use {@link #getDataMap()} instead.
		 */
		@java.lang.Deprecated
		java.util.Map<java.lang.String, java.lang.String> getData();

		/**
		 * <code>map&lt;string, string&gt; data = 1;</code>
		 */
		java.util.Map<java.lang.String, java.lang.String> getDataMap();

		/**
		 * <code>map&lt;string, string&gt; data = 1;</code>
		 */

		java.lang.String getDataOrDefault(java.lang.String key, java.lang.String defaultValue);

		/**
		 * <code>map&lt;string, string&gt; data = 1;</code>
		 */

		java.lang.String getDataOrThrow(java.lang.String key);
	}

	/**
	 * <pre>
	 * 飞参数据挂载
	 * </pre>
	 *
	 * Protobuf type {@code net.cc.luffy.entity.proto.UavFlyDataBag}
	 */
	public static final class UavFlyDataBag extends com.github.os72.protobuf351.GeneratedMessageV3 implements
			// @@protoc_insertion_point(message_implements:net.cc.luffy.entity.proto.UavFlyDataBag)
			UavFlyDataBagOrBuilder {
		private static final long serialVersionUID = 0L;

		// Use UavFlyDataBag.newBuilder() to construct.
		private UavFlyDataBag(com.github.os72.protobuf351.GeneratedMessageV3.Builder<?> builder) {
			super(builder);
		}

		private UavFlyDataBag() {
		}

		@java.lang.Override
		public final com.github.os72.protobuf351.UnknownFieldSet getUnknownFields() {
			return this.unknownFields;
		}

		private UavFlyDataBag(com.github.os72.protobuf351.CodedInputStream input,
				com.github.os72.protobuf351.ExtensionRegistryLite extensionRegistry)
				throws com.github.os72.protobuf351.InvalidProtocolBufferException {
			this();
			if (extensionRegistry == null) {
				throw new java.lang.NullPointerException();
			}
			int mutable_bitField0_ = 0;
			com.github.os72.protobuf351.UnknownFieldSet.Builder unknownFields = com.github.os72.protobuf351.UnknownFieldSet
					.newBuilder();
			try {
				boolean done = false;
				while (!done) {
					int tag = input.readTag();
					switch (tag) {
					case 0:
						done = true;
						break;
					case 10: {
						if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
							data_ = com.github.os72.protobuf351.MapField
									.newMapField(DataDefaultEntryHolder.defaultEntry);
							mutable_bitField0_ |= 0x00000001;
						}
						com.github.os72.protobuf351.MapEntry<java.lang.String, java.lang.String> data__ = input
								.readMessage(DataDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
						data_.getMutableMap().put(data__.getKey(), data__.getValue());
						break;
					}
					default: {
						if (!parseUnknownFieldProto3(input, unknownFields, extensionRegistry, tag)) {
							done = true;
						}
						break;
					}
					}
				}
			} catch (com.github.os72.protobuf351.InvalidProtocolBufferException e) {
				throw e.setUnfinishedMessage(this);
			} catch (java.io.IOException e) {
				throw new com.github.os72.protobuf351.InvalidProtocolBufferException(e).setUnfinishedMessage(this);
			} finally {
				this.unknownFields = unknownFields.build();
				makeExtensionsImmutable();
			}
		}

		public static final com.github.os72.protobuf351.Descriptors.Descriptor getDescriptor() {
			return net.cc.luffy.entity.proto.UavFlyDataBagProto.internal_static_net_cc_luffy_entity_proto_UavFlyDataBag_descriptor;
		}

		@SuppressWarnings({ "rawtypes" })
		@java.lang.Override
		protected com.github.os72.protobuf351.MapField internalGetMapField(int number) {
			switch (number) {
			case 1:
				return internalGetData();
			default:
				throw new RuntimeException("Invalid map field number: " + number);
			}
		}

		@java.lang.Override
		protected com.github.os72.protobuf351.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
			return net.cc.luffy.entity.proto.UavFlyDataBagProto.internal_static_net_cc_luffy_entity_proto_UavFlyDataBag_fieldAccessorTable
					.ensureFieldAccessorsInitialized(net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag.class,
							net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag.Builder.class);
		}

		public static final int DATA_FIELD_NUMBER = 1;

		private static final class DataDefaultEntryHolder {
			static final com.github.os72.protobuf351.MapEntry<java.lang.String, java.lang.String> defaultEntry = com.github.os72.protobuf351.MapEntry.<java.lang.String, java.lang.String>newDefaultInstance(
					net.cc.luffy.entity.proto.UavFlyDataBagProto.internal_static_net_cc_luffy_entity_proto_UavFlyDataBag_DataEntry_descriptor,
					com.github.os72.protobuf351.WireFormat.FieldType.STRING, "",
					com.github.os72.protobuf351.WireFormat.FieldType.STRING, "");
		}

		private com.github.os72.protobuf351.MapField<java.lang.String, java.lang.String> data_;

		private com.github.os72.protobuf351.MapField<java.lang.String, java.lang.String> internalGetData() {
			if (data_ == null) {
				return com.github.os72.protobuf351.MapField.emptyMapField(DataDefaultEntryHolder.defaultEntry);
			}
			return data_;
		}

		public int getDataCount() {
			return internalGetData().getMap().size();
		}

		/**
		 * <code>map&lt;string, string&gt; data = 1;</code>
		 */

		public boolean containsData(java.lang.String key) {
			if (key == null) {
				throw new java.lang.NullPointerException();
			}
			return internalGetData().getMap().containsKey(key);
		}

		/**
		 * Use {@link #getDataMap()} instead.
		 */
		@java.lang.Deprecated
		public java.util.Map<java.lang.String, java.lang.String> getData() {
			return getDataMap();
		}

		/**
		 * <code>map&lt;string, string&gt; data = 1;</code>
		 */

		public java.util.Map<java.lang.String, java.lang.String> getDataMap() {
			return internalGetData().getMap();
		}

		/**
		 * <code>map&lt;string, string&gt; data = 1;</code>
		 */

		public java.lang.String getDataOrDefault(java.lang.String key, java.lang.String defaultValue) {
			if (key == null) {
				throw new java.lang.NullPointerException();
			}
			java.util.Map<java.lang.String, java.lang.String> map = internalGetData().getMap();
			return map.containsKey(key) ? map.get(key) : defaultValue;
		}

		/**
		 * <code>map&lt;string, string&gt; data = 1;</code>
		 */

		public java.lang.String getDataOrThrow(java.lang.String key) {
			if (key == null) {
				throw new java.lang.NullPointerException();
			}
			java.util.Map<java.lang.String, java.lang.String> map = internalGetData().getMap();
			if (!map.containsKey(key)) {
				throw new java.lang.IllegalArgumentException();
			}
			return map.get(key);
		}

		private byte memoizedIsInitialized = -1;

		@java.lang.Override
		public final boolean isInitialized() {
			byte isInitialized = memoizedIsInitialized;
			if (isInitialized == 1)
				return true;
			if (isInitialized == 0)
				return false;

			memoizedIsInitialized = 1;
			return true;
		}

		@java.lang.Override
		public void writeTo(com.github.os72.protobuf351.CodedOutputStream output) throws java.io.IOException {
			com.github.os72.protobuf351.GeneratedMessageV3.serializeStringMapTo(output, internalGetData(),
					DataDefaultEntryHolder.defaultEntry, 1);
			unknownFields.writeTo(output);
		}

		@java.lang.Override
		public int getSerializedSize() {
			int size = memoizedSize;
			if (size != -1)
				return size;

			size = 0;
			for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : internalGetData().getMap()
					.entrySet()) {
				com.github.os72.protobuf351.MapEntry<java.lang.String, java.lang.String> data__ = DataDefaultEntryHolder.defaultEntry
						.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build();
				size += com.github.os72.protobuf351.CodedOutputStream.computeMessageSize(1, data__);
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
			if (!(obj instanceof net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag)) {
				return super.equals(obj);
			}
			net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag other = (net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag) obj;

			boolean result = true;
			result = result && internalGetData().equals(other.internalGetData());
			result = result && unknownFields.equals(other.unknownFields);
			return result;
		}

		@SuppressWarnings("unchecked")
		@java.lang.Override
		public int hashCode() {
			if (memoizedHashCode != 0) {
				return memoizedHashCode;
			}
			int hash = 41;
			hash = (19 * hash) + getDescriptor().hashCode();
			if (!internalGetData().getMap().isEmpty()) {
				hash = (37 * hash) + DATA_FIELD_NUMBER;
				hash = (53 * hash) + internalGetData().hashCode();
			}
			hash = (29 * hash) + unknownFields.hashCode();
			memoizedHashCode = hash;
			return hash;
		}

		public static net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag parseFrom(java.nio.ByteBuffer data)
				throws com.github.os72.protobuf351.InvalidProtocolBufferException {
			return PARSER.parseFrom(data);
		}

		public static net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag parseFrom(java.nio.ByteBuffer data,
				com.github.os72.protobuf351.ExtensionRegistryLite extensionRegistry)
				throws com.github.os72.protobuf351.InvalidProtocolBufferException {
			return PARSER.parseFrom(data, extensionRegistry);
		}

		public static net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag parseFrom(
				com.github.os72.protobuf351.ByteString data)
				throws com.github.os72.protobuf351.InvalidProtocolBufferException {
			return PARSER.parseFrom(data);
		}

		public static net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag parseFrom(
				com.github.os72.protobuf351.ByteString data,
				com.github.os72.protobuf351.ExtensionRegistryLite extensionRegistry)
				throws com.github.os72.protobuf351.InvalidProtocolBufferException {
			return PARSER.parseFrom(data, extensionRegistry);
		}

		public static net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag parseFrom(byte[] data)
				throws com.github.os72.protobuf351.InvalidProtocolBufferException {
			return PARSER.parseFrom(data);
		}

		public static net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag parseFrom(byte[] data,
				com.github.os72.protobuf351.ExtensionRegistryLite extensionRegistry)
				throws com.github.os72.protobuf351.InvalidProtocolBufferException {
			return PARSER.parseFrom(data, extensionRegistry);
		}

		public static net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag parseFrom(java.io.InputStream input)
				throws java.io.IOException {
			return com.github.os72.protobuf351.GeneratedMessageV3.parseWithIOException(PARSER, input);
		}

		public static net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag parseFrom(java.io.InputStream input,
				com.github.os72.protobuf351.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.github.os72.protobuf351.GeneratedMessageV3.parseWithIOException(PARSER, input,
					extensionRegistry);
		}

		public static net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag parseDelimitedFrom(
				java.io.InputStream input) throws java.io.IOException {
			return com.github.os72.protobuf351.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
		}

		public static net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag parseDelimitedFrom(
				java.io.InputStream input, com.github.os72.protobuf351.ExtensionRegistryLite extensionRegistry)
				throws java.io.IOException {
			return com.github.os72.protobuf351.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input,
					extensionRegistry);
		}

		public static net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag parseFrom(
				com.github.os72.protobuf351.CodedInputStream input) throws java.io.IOException {
			return com.github.os72.protobuf351.GeneratedMessageV3.parseWithIOException(PARSER, input);
		}

		public static net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag parseFrom(
				com.github.os72.protobuf351.CodedInputStream input,
				com.github.os72.protobuf351.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
			return com.github.os72.protobuf351.GeneratedMessageV3.parseWithIOException(PARSER, input,
					extensionRegistry);
		}

		@java.lang.Override
		public Builder newBuilderForType() {
			return newBuilder();
		}

		public static Builder newBuilder() {
			return DEFAULT_INSTANCE.toBuilder();
		}

		public static Builder newBuilder(net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag prototype) {
			return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
		}

		@java.lang.Override
		public Builder toBuilder() {
			return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
		}

		@java.lang.Override
		protected Builder newBuilderForType(com.github.os72.protobuf351.GeneratedMessageV3.BuilderParent parent) {
			Builder builder = new Builder(parent);
			return builder;
		}

		/**
		 * <pre>
		 * 飞参数据挂载
		 * </pre>
		 *
		 * Protobuf type {@code net.cc.luffy.entity.proto.UavFlyDataBag}
		 */
		public static final class Builder extends com.github.os72.protobuf351.GeneratedMessageV3.Builder<Builder>
				implements
				// @@protoc_insertion_point(builder_implements:net.cc.luffy.entity.proto.UavFlyDataBag)
				net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBagOrBuilder {
			public static final com.github.os72.protobuf351.Descriptors.Descriptor getDescriptor() {
				return net.cc.luffy.entity.proto.UavFlyDataBagProto.internal_static_net_cc_luffy_entity_proto_UavFlyDataBag_descriptor;
			}

			@SuppressWarnings({ "rawtypes" })
			protected com.github.os72.protobuf351.MapField internalGetMapField(int number) {
				switch (number) {
				case 1:
					return internalGetData();
				default:
					throw new RuntimeException("Invalid map field number: " + number);
				}
			}

			@SuppressWarnings({ "rawtypes" })
			protected com.github.os72.protobuf351.MapField internalGetMutableMapField(int number) {
				switch (number) {
				case 1:
					return internalGetMutableData();
				default:
					throw new RuntimeException("Invalid map field number: " + number);
				}
			}

			@java.lang.Override
			protected com.github.os72.protobuf351.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
				return net.cc.luffy.entity.proto.UavFlyDataBagProto.internal_static_net_cc_luffy_entity_proto_UavFlyDataBag_fieldAccessorTable
						.ensureFieldAccessorsInitialized(
								net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag.class,
								net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag.Builder.class);
			}

			// Construct using
			// net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag.newBuilder()
			private Builder() {
				maybeForceBuilderInitialization();
			}

			private Builder(com.github.os72.protobuf351.GeneratedMessageV3.BuilderParent parent) {
				super(parent);
				maybeForceBuilderInitialization();
			}

			private void maybeForceBuilderInitialization() {
				if (com.github.os72.protobuf351.GeneratedMessageV3.alwaysUseFieldBuilders) {
				}
			}

			@java.lang.Override
			public Builder clear() {
				super.clear();
				internalGetMutableData().clear();
				return this;
			}

			@java.lang.Override
			public com.github.os72.protobuf351.Descriptors.Descriptor getDescriptorForType() {
				return net.cc.luffy.entity.proto.UavFlyDataBagProto.internal_static_net_cc_luffy_entity_proto_UavFlyDataBag_descriptor;
			}

			@java.lang.Override
			public net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag getDefaultInstanceForType() {
				return net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag.getDefaultInstance();
			}

			@java.lang.Override
			public net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag build() {
				net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag result = buildPartial();
				if (!result.isInitialized()) {
					throw newUninitializedMessageException(result);
				}
				return result;
			}

			@SuppressWarnings("unused")
			@java.lang.Override
			public net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag buildPartial() {
				net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag result = new net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag(
						this);
				int from_bitField0_ = bitField0_;
				result.data_ = internalGetData();
				result.data_.makeImmutable();
				onBuilt();
				return result;
			}

			@java.lang.Override
			public Builder clone() {
				return (Builder) super.clone();
			}

			@java.lang.Override
			public Builder setField(com.github.os72.protobuf351.Descriptors.FieldDescriptor field,
					java.lang.Object value) {
				return (Builder) super.setField(field, value);
			}

			@java.lang.Override
			public Builder clearField(com.github.os72.protobuf351.Descriptors.FieldDescriptor field) {
				return (Builder) super.clearField(field);
			}

			@java.lang.Override
			public Builder clearOneof(com.github.os72.protobuf351.Descriptors.OneofDescriptor oneof) {
				return (Builder) super.clearOneof(oneof);
			}

			@java.lang.Override
			public Builder setRepeatedField(com.github.os72.protobuf351.Descriptors.FieldDescriptor field, int index,
					java.lang.Object value) {
				return (Builder) super.setRepeatedField(field, index, value);
			}

			@java.lang.Override
			public Builder addRepeatedField(com.github.os72.protobuf351.Descriptors.FieldDescriptor field,
					java.lang.Object value) {
				return (Builder) super.addRepeatedField(field, value);
			}

			@java.lang.Override
			public Builder mergeFrom(com.github.os72.protobuf351.Message other) {
				if (other instanceof net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag) {
					return mergeFrom((net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag) other);
				} else {
					super.mergeFrom(other);
					return this;
				}
			}

			public Builder mergeFrom(net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag other) {
				if (other == net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag.getDefaultInstance())
					return this;
				internalGetMutableData().mergeFrom(other.internalGetData());
				this.mergeUnknownFields(other.unknownFields);
				onChanged();
				return this;
			}

			@java.lang.Override
			public final boolean isInitialized() {
				return true;
			}

			@java.lang.Override
			public Builder mergeFrom(com.github.os72.protobuf351.CodedInputStream input,
					com.github.os72.protobuf351.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
				net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag parsedMessage = null;
				try {
					parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
				} catch (com.github.os72.protobuf351.InvalidProtocolBufferException e) {
					parsedMessage = (net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag) e
							.getUnfinishedMessage();
					throw e.unwrapIOException();
				} finally {
					if (parsedMessage != null) {
						mergeFrom(parsedMessage);
					}
				}
				return this;
			}

			private int bitField0_;

			private com.github.os72.protobuf351.MapField<java.lang.String, java.lang.String> data_;

			private com.github.os72.protobuf351.MapField<java.lang.String, java.lang.String> internalGetData() {
				if (data_ == null) {
					return com.github.os72.protobuf351.MapField.emptyMapField(DataDefaultEntryHolder.defaultEntry);
				}
				return data_;
			}

			private com.github.os72.protobuf351.MapField<java.lang.String, java.lang.String> internalGetMutableData() {
				onChanged();
				;
				if (data_ == null) {
					data_ = com.github.os72.protobuf351.MapField.newMapField(DataDefaultEntryHolder.defaultEntry);
				}
				if (!data_.isMutable()) {
					data_ = data_.copy();
				}
				return data_;
			}

			public int getDataCount() {
				return internalGetData().getMap().size();
			}

			/**
			 * <code>map&lt;string, string&gt; data = 1;</code>
			 */

			public boolean containsData(java.lang.String key) {
				if (key == null) {
					throw new java.lang.NullPointerException();
				}
				return internalGetData().getMap().containsKey(key);
			}

			/**
			 * Use {@link #getDataMap()} instead.
			 */
			@java.lang.Deprecated
			public java.util.Map<java.lang.String, java.lang.String> getData() {
				return getDataMap();
			}

			/**
			 * <code>map&lt;string, string&gt; data = 1;</code>
			 */

			public java.util.Map<java.lang.String, java.lang.String> getDataMap() {
				return internalGetData().getMap();
			}

			/**
			 * <code>map&lt;string, string&gt; data = 1;</code>
			 */

			public java.lang.String getDataOrDefault(java.lang.String key, java.lang.String defaultValue) {
				if (key == null) {
					throw new java.lang.NullPointerException();
				}
				java.util.Map<java.lang.String, java.lang.String> map = internalGetData().getMap();
				return map.containsKey(key) ? map.get(key) : defaultValue;
			}

			/**
			 * <code>map&lt;string, string&gt; data = 1;</code>
			 */

			public java.lang.String getDataOrThrow(java.lang.String key) {
				if (key == null) {
					throw new java.lang.NullPointerException();
				}
				java.util.Map<java.lang.String, java.lang.String> map = internalGetData().getMap();
				if (!map.containsKey(key)) {
					throw new java.lang.IllegalArgumentException();
				}
				return map.get(key);
			}

			public Builder clearData() {
				internalGetMutableData().getMutableMap().clear();
				return this;
			}

			/**
			 * <code>map&lt;string, string&gt; data = 1;</code>
			 */

			public Builder removeData(java.lang.String key) {
				if (key == null) {
					throw new java.lang.NullPointerException();
				}
				internalGetMutableData().getMutableMap().remove(key);
				return this;
			}

			/**
			 * Use alternate mutation accessors instead.
			 */
			@java.lang.Deprecated
			public java.util.Map<java.lang.String, java.lang.String> getMutableData() {
				return internalGetMutableData().getMutableMap();
			}

			/**
			 * <code>map&lt;string, string&gt; data = 1;</code>
			 */
			public Builder putData(java.lang.String key, java.lang.String value) {
				if (key == null) {
					throw new java.lang.NullPointerException();
				}
				if (value == null) {
					throw new java.lang.NullPointerException();
				}
				internalGetMutableData().getMutableMap().put(key, value);
				return this;
			}

			/**
			 * <code>map&lt;string, string&gt; data = 1;</code>
			 */

			public Builder putAllData(java.util.Map<java.lang.String, java.lang.String> values) {
				internalGetMutableData().getMutableMap().putAll(values);
				return this;
			}

			@java.lang.Override
			public final Builder setUnknownFields(final com.github.os72.protobuf351.UnknownFieldSet unknownFields) {
				return super.setUnknownFieldsProto3(unknownFields);
			}

			@java.lang.Override
			public final Builder mergeUnknownFields(final com.github.os72.protobuf351.UnknownFieldSet unknownFields) {
				return super.mergeUnknownFields(unknownFields);
			}

			// @@protoc_insertion_point(builder_scope:net.cc.luffy.entity.proto.UavFlyDataBag)
		}

		// @@protoc_insertion_point(class_scope:net.cc.luffy.entity.proto.UavFlyDataBag)
		private static final net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag DEFAULT_INSTANCE;
		static {
			DEFAULT_INSTANCE = new net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag();
		}

		public static net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag getDefaultInstance() {
			return DEFAULT_INSTANCE;
		}

		private static final com.github.os72.protobuf351.Parser<UavFlyDataBag> PARSER = new com.github.os72.protobuf351.AbstractParser<UavFlyDataBag>() {
			@java.lang.Override
			public UavFlyDataBag parsePartialFrom(com.github.os72.protobuf351.CodedInputStream input,
					com.github.os72.protobuf351.ExtensionRegistryLite extensionRegistry)
					throws com.github.os72.protobuf351.InvalidProtocolBufferException {
				return new UavFlyDataBag(input, extensionRegistry);
			}
		};

		public static com.github.os72.protobuf351.Parser<UavFlyDataBag> parser() {
			return PARSER;
		}

		@java.lang.Override
		public com.github.os72.protobuf351.Parser<UavFlyDataBag> getParserForType() {
			return PARSER;
		}

		@java.lang.Override
		public net.cc.luffy.entity.proto.UavFlyDataBagProto.UavFlyDataBag getDefaultInstanceForType() {
			return DEFAULT_INSTANCE;
		}

	}

	private static final com.github.os72.protobuf351.Descriptors.Descriptor internal_static_net_cc_luffy_entity_proto_UavFlyDataBag_descriptor;
	private static final com.github.os72.protobuf351.GeneratedMessageV3.FieldAccessorTable internal_static_net_cc_luffy_entity_proto_UavFlyDataBag_fieldAccessorTable;
	private static final com.github.os72.protobuf351.Descriptors.Descriptor internal_static_net_cc_luffy_entity_proto_UavFlyDataBag_DataEntry_descriptor;
	@SuppressWarnings("unused")
	private static final com.github.os72.protobuf351.GeneratedMessageV3.FieldAccessorTable internal_static_net_cc_luffy_entity_proto_UavFlyDataBag_DataEntry_fieldAccessorTable;

	public static com.github.os72.protobuf351.Descriptors.FileDescriptor getDescriptor() {
		return descriptor;
	}

	private static com.github.os72.protobuf351.Descriptors.FileDescriptor descriptor;
	static {
		java.lang.String[] descriptorData = { "\n\025uav_flydata_bag.proto\022\031net.cc.luffy.en"
				+ "tity.proto\"~\n\rUavFlyDataBag\022@\n\004data\030\001 \003("
				+ "\01322.net.cc.luffy.entity.proto.UavFlyData"
				+ "Bag.DataEntry\032+\n\tDataEntry\022\013\n\003key\030\001 \001(\t\022"
				+ "\r\n\005value\030\002 \001(\t:\0028\001B\024B\022UavFlyDataBagProto" + "b\006proto3" };
		com.github.os72.protobuf351.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new com.github.os72.protobuf351.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
			public com.github.os72.protobuf351.ExtensionRegistry assignDescriptors(
					com.github.os72.protobuf351.Descriptors.FileDescriptor root) {
				descriptor = root;
				return null;
			}
		};
		com.github.os72.protobuf351.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData,
				new com.github.os72.protobuf351.Descriptors.FileDescriptor[] {}, assigner);
		internal_static_net_cc_luffy_entity_proto_UavFlyDataBag_descriptor = getDescriptor().getMessageTypes().get(0);
		internal_static_net_cc_luffy_entity_proto_UavFlyDataBag_fieldAccessorTable = new com.github.os72.protobuf351.GeneratedMessageV3.FieldAccessorTable(
				internal_static_net_cc_luffy_entity_proto_UavFlyDataBag_descriptor, new java.lang.String[] { "Data", });
		internal_static_net_cc_luffy_entity_proto_UavFlyDataBag_DataEntry_descriptor = internal_static_net_cc_luffy_entity_proto_UavFlyDataBag_descriptor
				.getNestedTypes().get(0);
		internal_static_net_cc_luffy_entity_proto_UavFlyDataBag_DataEntry_fieldAccessorTable = new com.github.os72.protobuf351.GeneratedMessageV3.FieldAccessorTable(
				internal_static_net_cc_luffy_entity_proto_UavFlyDataBag_DataEntry_descriptor,
				new java.lang.String[] { "Key", "Value", });
	}

	// @@protoc_insertion_point(outer_class_scope)
}
