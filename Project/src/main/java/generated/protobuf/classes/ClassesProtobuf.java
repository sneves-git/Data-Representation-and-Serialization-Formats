// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: school.proto

package generated.protobuf.classes;

public final class ClassesProtobuf {
  private ClassesProtobuf() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_protobuf_Student_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_protobuf_Student_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_protobuf_Professor_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_protobuf_Professor_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_protobuf_School_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_protobuf_School_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014school.proto\022\010protobuf\"\204\001\n\007Student\022\n\n\002" +
      "id\030\001 \001(\005\022\014\n\004name\030\002 \001(\t\022\021\n\ttelephone\030\003 \001(" +
      "\005\022\016\n\006gender\030\004 \001(\t\022\021\n\tbirthDate\030\005 \001(\t\022\030\n\020" +
      "registrationDate\030\006 \001(\t\022\017\n\007address\030\007 \001(\t\"" +
      "\201\001\n\tProfessor\022\n\n\002id\030\001 \001(\005\022\014\n\004name\030\002 \001(\t\022" +
      "\021\n\ttelephone\030\003 \001(\005\022\021\n\tbirthDate\030\004 \001(\t\022\017\n" +
      "\007address\030\005 \001(\t\022#\n\010students\030\006 \003(\0132\021.proto" +
      "buf.Student\"1\n\006School\022\'\n\nprofessors\030\001 \003(" +
      "\0132\023.protobuf.ProfessorB/\n\032generated.prot" +
      "obuf.classesB\017ClassesProtobufP\001"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_protobuf_Student_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_protobuf_Student_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_protobuf_Student_descriptor,
        new java.lang.String[] { "Id", "Name", "Telephone", "Gender", "BirthDate", "RegistrationDate", "Address", });
    internal_static_protobuf_Professor_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_protobuf_Professor_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_protobuf_Professor_descriptor,
        new java.lang.String[] { "Id", "Name", "Telephone", "BirthDate", "Address", "Students", });
    internal_static_protobuf_School_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_protobuf_School_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_protobuf_School_descriptor,
        new java.lang.String[] { "Professors", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
