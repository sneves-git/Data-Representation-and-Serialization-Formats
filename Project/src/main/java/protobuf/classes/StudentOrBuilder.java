// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: school.proto

package classes;

public interface StudentOrBuilder extends
    // @@protoc_insertion_point(interface_extends:classes.Student)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Unique ID number for this student.
   * </pre>
   *
   * <code>int32 id = 1;</code>
   */
  int getId();

  /**
   * <code>string name = 2;</code>
   */
  java.lang.String getName();
  /**
   * <code>string name = 2;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>int32 telephone = 3;</code>
   */
  int getTelephone();

  /**
   * <code>string gender = 4;</code>
   */
  java.lang.String getGender();
  /**
   * <code>string gender = 4;</code>
   */
  com.google.protobuf.ByteString
      getGenderBytes();

  /**
   * <code>string birthDate = 5;</code>
   */
  java.lang.String getBirthDate();
  /**
   * <code>string birthDate = 5;</code>
   */
  com.google.protobuf.ByteString
      getBirthDateBytes();

  /**
   * <code>string registrationDate = 6;</code>
   */
  java.lang.String getRegistrationDate();
  /**
   * <code>string registrationDate = 6;</code>
   */
  com.google.protobuf.ByteString
      getRegistrationDateBytes();

  /**
   * <code>string address = 7;</code>
   */
  java.lang.String getAddress();
  /**
   * <code>string address = 7;</code>
   */
  com.google.protobuf.ByteString
      getAddressBytes();
}