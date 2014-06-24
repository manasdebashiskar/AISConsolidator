AISConsolidator
===============

AISConsolidator is a spark streaming receiver that recieves AIS messages and create a join on the fly.

How to build
====================
sbt dist
cd  target/aISConsolidator-dist/

How to run
===========

source /etc/spark/conf/spark-env.sh 

export JAVA_HOME=/usr/java/jdk1.7.0_45-cloudera 

# system jars: 
CLASSPATH=/etc/hadoop/conf 
CLASSPATH=$CLASSPATH:$HADOOP_HOME/*:$HADOOP_HOME/lib/* 
CLASSPATH=$CLASSPATH:$HADOOP_HOME/../hadoop-mapreduce/*:$HADOOP_HOME/../hadoop-mapreduce/lib/* 
CLASSPATH=$CLASSPATH:$HADOOP_HOME/../hadoop-yarn/*:$HADOOP_HOME/../hadoop-yarn/lib/* 
CLASSPATH=$CLASSPATH:$HADOOP_HOME/../hadoop-hdfs/*:$HADOOP_HOME/../hadoop-hdfs/lib/* 
CLASSPATH=$CLASSPATH:$SPARK_HOME/assembly/lib/* 
CLASSPATH=$CLASSPATH:/lib/* 

# app jar: 
CLASSPATH=$CLASSPATH:/deploy/aisconsolidator-1.0-SNAPSHOT.jar 
CONFIG_OPTS="-Dspark.master=local -Dspark.jars=/deploy/aisconsolidator-1.0-SNAPSHOT.jar" 

$JAVA_HOME/bin/java -cp $CLASSPATH $CONFIG_OPTS org.apache.spark.examples.streaming.NetworkWordCount localhost 9999 

 Make sure the command `$ nc -lk 9999` is already running on localhost. 
