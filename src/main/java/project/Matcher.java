package project;

import org.apache.poi.ss.usermodel.Row;

import java.util.Iterator;
import java.util.Map;

public interface Matcher {
    Map<Row, Parts> getMainParts(Iterator<Row> rowIterator);
}