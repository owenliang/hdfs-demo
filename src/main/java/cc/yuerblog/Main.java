package cc.yuerblog;

import cc.yuerblog.fs.AvroFileTest;
import cc.yuerblog.fs.OrcFileTest;
import cc.yuerblog.fs.RawFileTest;
import cc.yuerblog.fs.SequenceFileTest;
import org.apache.hadoop.conf.Configuration;

import java.io.IOException;

public class Main
{
    // hadoop行列存储的原理与优劣：https://blog.csdn.net/Android_xue/article/details/104014833
    public static void main( String[] args ) {
        Configuration conf = new Configuration();
        try {
            // 无格式文件
            RawFileTest raw = new RawFileTest();
            raw.run(conf);

            // 行存储：sequenceFile格式文件
            SequenceFileTest sequence = new SequenceFileTest();
            sequence.run(conf);

            // 行存储：avro格式文件
            AvroFileTest avro = new AvroFileTest();
            avro.run(conf);

            // 列存储：ORC列存格式文件
            OrcFileTest orc = new OrcFileTest();
            orc.run(conf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
