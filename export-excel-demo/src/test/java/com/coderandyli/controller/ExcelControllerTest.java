package com.coderandyli.controller;

import com.coderandyli.dto.TemplateDTO;
import com.coderandyli.dto.WebDto;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lizhen on 2019-03-04
 */
public class ExcelControllerTest {

    //读取单个单元格
    @Test
    public void testRead() throws Exception {
        //Excel文件
        HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(ResourceUtils.getFile("classpath:web-info.xls")));
        //Excel工作表
        HSSFSheet sheet = wb.getSheetAt(0);

        //表头那一行
        HSSFRow titleRow = sheet.getRow(0);

        //表头那个单元格
        HSSFCell titleCell = titleRow.getCell(0);

        String title = titleCell.getStringCellValue();
        System.out.println("标题是：" + title);
    }

    //读取到列表
    @Test
    public void testReadList() throws Exception {
        List<TemplateDTO> list = new ArrayList<>();
        XSSFWorkbook book = new XSSFWorkbook(new FileInputStream(ResourceUtils.getFile("/Users/lizhen/Desktop/message_template.xlsx")));

        XSSFSheet sheet = book.getSheetAt(0);

        for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
            XSSFRow row = sheet.getRow(i);
            String type = row.getCell(0).getStringCellValue(); //名称
            String code = row.getCell(1).getStringCellValue(); //url
            String name = row.getCell(2).getStringCellValue();
            String templeteCn = row.getCell(3).getStringCellValue();
            String templeteEn = row.getCell(4).getStringCellValue();
            String remark = row.getCell(5).getStringCellValue();
            list.add(new TemplateDTO(type, code, name, templeteCn, templeteEn, remark));
        }

        System.out.println("共有 " + list.size() + " 条数据：");
        for (TemplateDTO dto : list) {
            System.out.println(dto);
        }
    }

}