package top.zbeboy.zone.service.util;

import org.apache.commons.compress.parallel.InputStreamSupplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ZipInputStream implements InputStreamSupplier {

    private final Logger log = LoggerFactory.getLogger(ZipInputStream.class);

    private File file;

    public ZipInputStream(File file) {
        this.file = file;
    }

    @Override
    public InputStream get() {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            log.error("Read file error, is {}", e);
        }
        return inputStream;
    }
}

