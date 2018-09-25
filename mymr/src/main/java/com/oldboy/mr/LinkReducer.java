package com.oldboy.mr;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class LinkReducer extends Reducer<Text,NullWritable,Text,NullWritable>{

}
