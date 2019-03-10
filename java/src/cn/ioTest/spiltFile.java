package cn.ioTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

public class spiltFile {
    private File src;
    private String destDir;
    private List<String> destPaths;
    private int blockSize;
    private int size;

    public spiltFile(String srcPath, String destDir) {

        this(srcPath, destDir, 1024);

    }

    public spiltFile(String srcPath, String destDir, int blockSize) {
        this.src = new File(srcPath);
        this.destDir = destDir;
        this.blockSize = blockSize;
        this.destPaths = new ArrayList<String>();
        init();
    }

    private void init() {
        long len = this.src.length();
        this.size = (int) Math.ceil(len * 1.0 / blockSize);
        for (int i = 0; i < size; i++) {
            this.destPaths.add(this.destDir + "/" + "-" + this.src.getName());
        }
    }

    public void split() throws IOException {
        long len = src.length();
        int beginPos = 0;
        int actualSize = (int) (blockSize > len ? len : blockSize);
        for (int i = 0; i < size; i++) {
            beginPos = blockSize * i;
            if (i == size - 1) {
                actualSize = (int) len;
            } else {
                actualSize = blockSize;
                len -= actualSize;
            }
            splitDetail(i, beginPos, actualSize);
        }
    }

    private void splitDetail(int i, int beginPos, int actualSize) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(this.src, "r");
        RandomAccessFile raf2 = new RandomAccessFile(this.destPaths.get(i), "rw");
        raf.seek(beginPos);
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len = raf.read(flush)) != -1) {

            if (actualSize > len) {
                raf2.write(flush, 0, len);
                actualSize -= len;
            } else {
                raf2.write(flush, 0, actualSize);
                break;
            }
        }
        raf2.close();
        raf.close();
    }

    public static void main(String[] args) throws IOException {
        spiltFile sf = new spiltFile("src/abc.txt", "dest");
        sf.split();
    }

}
