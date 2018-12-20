# spark4fun
Spark Installation

https://data-flair.training/blogs/install-spark-ubuntu/

spark tool uses

1. start your spark with this command 'spark-shell' and initialized SparkContext with 'sc' command

2. How create jar file for scala project?
      Goto the project directory and type 'sbt package', it will create jar file.

3. cd target/scala-2.11

4. Run Spark code from command promt: spark-submit --class classPath JAR_file_location local inputfile outputDir
Where a. spark-submit use to execute the spark code
      b. local is use for setMaster for spark config.

