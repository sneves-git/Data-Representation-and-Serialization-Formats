#Não funciona

SRC_DIR=src/main/java/protobuf
DST_DIR=src/main/java
protoc -I=$SRC_DIR --java_out=$DST_DIR $SRC_DIR/school.proto

protoc -I=src/main/java/protobuf --java_out=src/main/java src/main/java/protobuf/school.proto

