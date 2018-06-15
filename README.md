Spark-Terasort
==============

Terasort for Spark

# How to package

```
$ sbt assembly
```

## Create Idea project

```
$ sbt gen-idea
```

For more info, please follow the link: https://github.com/mpeltonen/sbt-idea

# How to run

## TeraGen
Usage:
```
$ spark-submit --class com.nexr.spark.terasort.TeraGen --deploy-mode client --master yarn spark-terasort-0.1.jar [output-size] [output-directory]
```

Example:
```
$ spark-submit --class com.nexr.spark.terasort.TeraGen --deploy-mode client --master yarn spark-terasort-0.1.jar 1G /user/root/teragen
```

## TeraSort
Usage:
```
$ spark-submit --class com.nexr.spark.terasort.TeraSort --deploy-mode client --master yarn spark-terasort-0.1.jar [input-file] [output-file]
```

Example:
```
$ spark-submit --class com.nexr.spark.terasort.TeraSort --deploy-mode client --master yarn spark-terasort-0.1.jar /user/root/teragen /user/root/terasort
```

## TeraValidate
Usage:
```
$ spark-submit --class com.nexr.spark.terasort.TeraValidate --deploy-mode client --master yarn spark-terasort-0.1.jar [input-directory]
```

Example:
```
$ spark-submit --class com.nexr.spark.terasort.TeraValidate --deploy-mode client --master yarn spark-terasort-0.1.jar /user/root/teragen
```

## TPCx-HS Style Benchmark

* Copy `src/main/resource/*.sh` to work directory.
* Copy `*.jar` to work directory.
* Run the benchmark with option
```
$ ./run.sh -g 1
```

* The result will be like this:
```
TPCx-HS Performance Metric (HSph@SF) Report

Test Run 2 details: Total Time = 140
                     Total Size = 1000000000
                     Scale-Factor = .1000

TPCx-HS Performance Metric (HSph@SF): 2.5773

```

* Spark configurations in `parametar.sh`
```
## Spark Parametars
# Driver Memory
SPARK_DRIVER_MEMORY=512m

# Executor Memory
SPARK_EXECUTOR_MEMORY=1g

# DEPLOY_MODE one of 'cluster' or 'client'
SPARK_DEPLOY_MODE="client"

# Master URL for the cluster. 'spark://localhost:7077', 'yarn-client' or 'yarn-cluster'
SPARK_MASTER_URL="spark://localhost:7077"
```

# Internals

# Acknowledgements

This codes are from `https://github.com/ehiggs/spark/tree/terasort`, [Ewan Higgs](https://github.com/ehiggs)' terasort example. Thank you for great example.