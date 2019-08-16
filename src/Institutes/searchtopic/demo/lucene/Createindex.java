package Institutes.searchtopic.demo.lucene;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;

import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;


/**
 * lucene创建索引
 *
 * @author he
 * @date 2018/9/20
 */
public class Createindex {

    private volatile static Createindex instance;
    private final static String INDEX_DIR_PATH = "./SearchTest/index";//索引目录地址

    private static class SingletonHolder {
        private final static Createindex instance = new Createindex();

    }

    public static Createindex getInstance() {
        return SingletonHolder.instance;

    }

    public boolean createIndex(String indexDir) throws IOException {
        //加点测试的静态数据
//        String[] strId = ReadFile.getArray("./SearchTest/testdata/id.txt");
//        String[] strTitle = ReadFile.getArray("./SearchTest/testdata//title.txt");
//        String[] strTcontent = ReadFile.getArray("./SearchTest/testdata//tcontent.txt");
//
        String ids[] = {"20011"};
//        String ids[] = new String[strId.length];
//        System.arraycopy(strId, 0, ids, 0, strId.length );
//
//
        String titles[] = {"SnowWish百媚圣诞礼盒"};
//        String titles[] = new String[strTitle.length];
//        System.arraycopy(strTitle, 0, titles, 0, strTitle.length);
//
//
        String tcontents[] = {
                "电商"
        };
//        String tcontents[] = new String[strTcontent.length];
//        System.arraycopy(strTcontent, 0, tcontents, 0, strTcontent.length);
//
        long startTime = System.currentTimeMillis();//记录索引开始时间

        Analyzer analyzer = new SmartChineseAnalyzer();
        Directory directory = FSDirectory.open(Paths.get(indexDir));
        IndexWriterConfig config = new IndexWriterConfig(analyzer);

        IndexWriter indexWriter = new IndexWriter(directory, config);

        for (int i = 0; i < ids.length; i++) {
            Document doc = new Document();
            //添加字段
            doc.add(new TextField("id", ids[i], Field.Store.YES)); //添加内容
            doc.add(new TextField("title", titles[i], Field.Store.YES)); //添加文件名，并把这个字段存到索引文件里
            doc.add(new TextField("tcontent", tcontents[i], Field.Store.YES)); //添加文件路径
            indexWriter.addDocument(doc);
        }
        indexWriter.commit();
        System.out.println("共索引了" + indexWriter.numDocs() + "个文件");
        indexWriter.close();
        System.out.println("创建索引所用时间：" + (System.currentTimeMillis() - startTime) + "毫秒");

        return true;
    }

    public static void main(String[] args) {
        try {
            boolean r = Createindex.getInstance().createIndex(INDEX_DIR_PATH);
            if (r) {
                System.out.println("索引创建成功!");
            } else {
                System.out.println("索引创建失败!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}