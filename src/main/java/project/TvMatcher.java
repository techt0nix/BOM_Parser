package project;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class TvMatcher implements Matcher {
    TvCellChecker tvCellChecker;

    public TvMatcher(TvCellChecker tvCellChecker) {
        this.tvCellChecker = tvCellChecker;
    }


    public Map<Row, Parts> getMainParts(Iterator<Row> rowIterator) {
        Map<Row, Parts> mainPartsMap = new HashMap<Row, Parts>();

        while(rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if (tvCellChecker.containsMainboard(cell)) {
                    mainPartsMap.put(row, Parts.MAINBOARD);
                    continue;
                } else if (cell.getStringCellValue().contains("speaker")) {
                    mainPartsMap.put(row, Parts.SPEAKER);
                    continue;
                } else if (cell.getStringCellValue().contains("lcd")) {
                    mainPartsMap.put(row, Parts.LCD);
                    continue;
                }
            }
        }

        return mainPartsMap;
    }
}
