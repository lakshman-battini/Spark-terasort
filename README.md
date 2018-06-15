Spark-Terasort
==============

TeraSort is a popular benchmark that measures the amount of time to sort one terabyte of randomly distributed data (or any other amount of data you want) on a given cluster. 
It is originally written to measure MapReduce performance of an Apache™ Hadoop® cluster. In this project, the code is re-written in Scala to measure the performance of Spark cluster.
It is a benchmark that combines testing the Storage layer(HDFS) and Computation layers(YARN / Spark) of an Hadoop cluster.

A full TeraSort benchmark run consists of the following three steps:

1. Generating the input data via TeraGen.
2. Running the actual TeraSort on the input data.
3. Validating the sorted output data via TeraValidate.

You do not need to re-generate input data before every TeraSort run (step 2). So you can skip step 1 (TeraGen) for later TeraSort runs if you are satisfied with the generated data.

# How to package

```
$ sbt assembly
```

# Running on YARN execution engine

For each spark job metrics will be printed in the logs, you can redirect the logs to store in file and use it to compare.
You may provide the additional configurations like spark.executor.memory, spark.driver.memory, spark.executor.instances etc.

## Step-1: TeraGen
Usage:
```
$ spark-submit --class com.lbattini.spark.terasort.TeraGen --deploy-mode cluster --master yarn spark-terasort-0.1.jar [output-size] [output-directory]
```

Example:
```
$ spark-submit --class com.lbattini.spark.terasort.TeraGen --deploy-mode cluster --master yarn spark-terasort-0.1.jar 1G /benchmarks/terasort/tera_input
```

## Step-2: TeraSort
Usage:
```
$ spark-submit --class com.lbattini.spark.terasort.TeraSort --deploy-mode cluster --master yarn spark-terasort-0.1.jar [input-directory] [output-directory]
```

Example:
```
$ spark-submit --class com.lbattini.spark.terasort.TeraSort --deploy-mode cluster --master yarn spark-terasort-0.1.jar /benchmarks/terasort/tera_input /benchmarks/terasort/tera_output
```

## Step-3: TeraValidate
Usage:
```
$ spark-submit --class com.lbattini.spark.terasort.TeraValidate --deploy-mode cluster --master yarn spark-terasort-0.1.jar [input-directory]
```

Example:
```
$ spark-submit --class com.lbattini.spark.terasort.TeraValidate --deploy-mode cluster --master yarn spark-terasort-0.1.jar /benchmarks/terasort/tera_output /benchmarks/terasort/tera_validate
```

# Running on Kubernetes execution engine

Replace --master yarn with --master <k8s master>
and provide below configurations:
spark.kubernets.container.image
spark.kubernetes.driver.pod.name

# Internals

# Acknowledgements

This code is built based on `https://github.com/ehiggs/spark/tree/terasort`, [Ewan Higgs](https://github.com/ehiggs)' terasort example. Thank you for great example.