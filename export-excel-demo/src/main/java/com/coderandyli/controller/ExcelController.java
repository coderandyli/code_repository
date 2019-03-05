package com.coderandyli.controller;

import com.coderandyli.entity.ExcelData;
import com.coderandyli.utils.ExportExcelUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhen on 2019-02-22
 */
@RestController
public class ExcelController {
    @RequestMapping(value = "/excel", method = RequestMethod.GET)
    public void excel(HttpServletResponse response) throws Exception {
        ExcelData data = new ExcelData();
        data.setName("hello");
        List<String> titles = new ArrayList();
        titles.add("委托方");
        titles.add("代理方");
        titles.add("航程信息");
        titles.add("港口港区");
        titles.add("ETA");
        titles.add("ETB");
        titles.add("ETD");
        titles.add("订单服务项");
        titles.add("订单状态");
        titles.add("报价");
        titles.add("总价");
        data.setTitles(titles);

        List<List<Object>> rows = new ArrayList();
        List<Object> row = new ArrayList();
        row.add("振振委托方");
        row.add("振振代理方");
        row.add("航程信息001");
        row.add("港口，港区");
        row.add("ETA时间");
        row.add("ETB时间");
        row.add("ETD时间");
        row.add("服务项信息");
        row.add("服务中");
        row.add("$100");
        row.add("$100");
        rows.add(row);
        data.setRows(rows);
        data.setName("order");


        //生成本地
        /*File f = new File("c:/test.xlsx");
        FileOutputStream out = new FileOutputStream(f);
        ExportExcelUtils.exportExcel(data, out);
        out.close();*/
        ExportExcelUtils.exportExcel(response, "order.xlsx", data);
    }
}
