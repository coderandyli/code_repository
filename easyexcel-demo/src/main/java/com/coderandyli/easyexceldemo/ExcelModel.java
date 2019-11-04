package com.coderandyli.easyexceldemo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * Created by lizhen on 2019-11-04
 */
@Data
public class ExcelModel extends BaseRowModel {

    @ExcelProperty(value = "船舶名称", index = 0)
    private String shipName;

    @ExcelProperty(value = "类型", index = 1)
    private String type;

    @ExcelProperty(value = "艘次", index = 2)
    private Integer num;

    @ExcelProperty(value = "账单金额(USD)", index = 3)
    private String money;

    @ExcelProperty(value = "预报价金额(USD)", index = 4)
    private String preMoney;
}
