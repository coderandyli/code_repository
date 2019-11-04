package com.coderandyli.easyexceldemo;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Font;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.TableStyle;
import com.alibaba.excel.support.ExcelTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhen on 2019-11-04
 */
@Controller
@RequestMapping("/test")
@CrossOrigin
@Slf4j
public class TestController {

    @GetMapping("/export")
    public void export(HttpServletResponse response) throws IOException {

        // 数据准备
        List<ExcelModel> accountList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ExcelModel model = new ExcelModel();
            model.setShipName("shipName");
            model.setType("type");
            model.setNum(i);
            model.setMoney("100");
            model.setMoney("1000");
            accountList.add(model);
        }

        response.setHeader("Content-disposition", "attachment;filename=" + System.currentTimeMillis() + ".xlsx");
        ServletOutputStream out = response.getOutputStream();
        response.setContentType("multipart/from-data");
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
        Sheet sheet = new Sheet(1, 0, ExcelModel.class);
        TableStyle tableStyle = new TableStyle();
        Font font = new Font();
        font.setBold(false);
        short s = 15;
        font.setFontHeightInPoints(s);
        tableStyle.setTableHeadFont(font);
        Font font1 = new Font();
        font1.setFontName("Microsoft YaHei");
        font1.setFontHeightInPoints((short) 11);
        tableStyle.setTableContentFont(font1);
        tableStyle.setTableHeadBackGroundColor(IndexedColors.WHITE);
        tableStyle.setTableContentBackGroundColor(IndexedColors.AUTOMATIC);
        sheet.setTableStyle(tableStyle);
        sheet.setAutoWidth(true);;

        // 追加 总计
        ExcelModel excelShipOrderExportModel = new ExcelModel();
        excelShipOrderExportModel.setShipName("");
        excelShipOrderExportModel.setType("总计：");

        int num = accountList.stream().mapToInt(ExcelModel::getNum).sum();
        excelShipOrderExportModel.setNum(num);

        double money = 1001;
        double preMoney = 100001;
        excelShipOrderExportModel.setPreMoney(String.format("%.2f", preMoney));
        excelShipOrderExportModel.setMoney(String.format("%.2f", money));

        accountList.add(excelShipOrderExportModel);

        writer.write(accountList, sheet);
        writer.finish();
        out.flush();
    }
}
