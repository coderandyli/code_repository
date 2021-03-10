package com.coderandyli.easyexceldemo;


import com.alibaba.excel.event.WriteHandler;
import org.apache.poi.ss.usermodel.*;

/**
 * @author MouFangCai
 * @date 2019/7/28 18:06
 */
public class StyleExcelHandler implements WriteHandler {
    private CellStyle cellStyle;

    @Override
    public void sheet(int i, Sheet sheet) {
        Workbook workbook = sheet.getWorkbook();
        // 创建样式
        cellStyle = workbook.createCellStyle();
    }

    @Override
    public void row(int i, Row row) {
    }

    @Override
    public void cell(int i, Cell cell) {
        createStyle();
        cell.setCellStyle(this.cellStyle);
    }

    private void createStyle() {
        // 下边框
        cellStyle.setBorderBottom(BorderStyle.THIN);
        // 左边框
        cellStyle.setBorderLeft(BorderStyle.THIN);
        // 右边框
        cellStyle.setBorderRight(BorderStyle.THIN);
        // 上边框
        cellStyle.setBorderTop(BorderStyle.THIN);
        // 设置自动换行
        cellStyle.setWrapText(true);
        // 水平对齐方式
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setFillBackgroundColor((short) 22);
        // 垂直对齐方式
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
    }

}
