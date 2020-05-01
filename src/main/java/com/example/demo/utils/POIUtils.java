package com.example.demo.utils;

import com.example.demo.model.Training_Program;
import com.example.demo.model.Score;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class POIUtils {

    /**
     * Excel 解析成数据集合
     *
     * @return
     */
    public static List<Score> excel2Score(InputStream inputStream) {
        List<Score> list = new ArrayList<>();
        Score score = null;
        try {
            //1. 创建一个 workbook 对象
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

            //2. 获取 workbook 中表单的数量
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                //3. 获取表单
                XSSFSheet sheet = workbook.getSheetAt(i);
                //4. 获取表单中的行数
                int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
                for (int j = 0; j < physicalNumberOfRows+1; j++) {
                    //5. 跳过标题行
                    if (j == 0 || j== 1 || j == 2 ) {
                        continue;//跳过标题行
                    }
                    //6. 获取行
                    XSSFRow row = sheet.getRow(j);
                    if (row == null) {
                        continue;//防止数据中间有空行
                    }
                    //7. 获取列数
                    int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                    score = new Score();
                    for (int k = 0; k < physicalNumberOfCells; k++) {
                        XSSFCell cell = row.getCell(k);
                        //将该单元格的数据转换成String
                        cell.setCellType(CellType.STRING);
                        switch (cell.getCellType()) {
                            // 类型是 String 进入此 case 块
                            case STRING:
                                String cellValue = cell.getStringCellValue();
                                switch (k) {
                                    case 0:
                                        //学号
                                        score.setStudentId(cellValue);
                                        //年级
                                        //编译正则表达式
                                        Pattern pattern = Pattern.compile("^[0-9]{2}");
                                        //指定要匹配的字符串
                                        Matcher matcher = pattern.matcher(cellValue);
                                        while(matcher.find()){
                                            String enrollment_year = "20"+matcher.group();
                                            score.setEnrollment_year(enrollment_year);
                                        }
                                        break;
                                    case 1:
                                        //姓名
                                        score.setStudentName(cellValue);
                                        break;
                                    case 2:
                                        //课程名称
                                        score.setCourse_name(cellValue);
                                        break;
                                    case 3:
                                        //学分
                                        score.setCredit(cellValue);
                                        break;
                                    case 11:
                                        //最高成绩
                                        score.setScore(cellValue);
                                        break;
                                    case 12:
                                        //补考成绩
                                        score.setRetry_score(cellValue);
                                        break;
                                    case 15:
                                        //课程性质
                                        score.setCourse_nature(cellValue);
                                        break;
                                    case 17:
                                        //课程号
                                        String courseId="";
                                        //指定要匹配的字符串
                                        Matcher matcherr = Pattern.compile("\\)\\-(.*?)\\-").matcher(cellValue);
                                        while(matcherr.find()){
                                            courseId = matcherr.group();
                                        }
                                        matcherr = Pattern.compile("[0-9a-zA-Z]+").matcher(courseId);
                                        while(matcherr.find()){
                                            courseId = matcherr.group();
                                        }
                                        score.setCourseId(courseId);
                                        break;
                                    case 18:
                                        //学年
                                        score.setAcademic_year(cellValue);
                                        break;
                                    case 19:
                                        //学期
                                        score.setTerm(cellValue);
                                        break;
                                    case 20:
                                        //学院
                                        score.setCollege(cellValue);
                                        break;
                                    case 21:
                                        //专业名称
                                        score.setMajor(cellValue);
                                        break;
                                    case 22:
                                        //班级
                                        score.setStudentClass(cellValue);
                                        break;
                                }
                                break;
                        }
                    }
                    // 最后将解析后的数据添加到集合中
                    list.add(score);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Training_Program> excel2Training(InputStream inputStream) {
        List<Training_Program> list = new ArrayList<>();
        Training_Program training_program = null;
        try {
            //1. 创建一个 workbook 对象
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

            //2. 获取 workbook 中表单的数量
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                //3. 获取表单
                XSSFSheet sheet = workbook.getSheetAt(i);
                //4. 获取表单中的行数
                int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
                for (int j = 0; j < physicalNumberOfRows+1; j++) {
                    //5. 跳过标题行
                    if (j == 0 || j == 1 || j == 2 ) {
                        continue;//跳过标题行
                    }
                    //6. 获取行
                    XSSFRow row = sheet.getRow(j);
                    if (row == null) {
                        continue;//防止数据中间有空行
                    }
                    //7. 获取列数
                    int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                    training_program = new Training_Program();
                    for (int k = 0; k < physicalNumberOfCells; k++) {
                        XSSFCell cell = row.getCell(k);
                        cell.setCellType(CellType.STRING);
                        switch (cell.getCellType()) {
                            // 类型是 String 进入此 case 块
                            case STRING:
                                String cellValue = cell.getStringCellValue();
                                switch (k) {
                                    case 0:
                                        //课程性质
                                        training_program.setCourse_nature(cellValue);
                                        break;
                                    case 1:
                                        //课程代码
                                        training_program.setCourseId(cellValue);
                                        break;
                                    case 2:
                                        //课程名称
                                        training_program.setCourse_name(cellValue);
                                        break;
                                    case 15:
                                        //学分
                                        training_program.setCredit(cellValue);
                                        break;
                                    case 16:
                                        //开课学期
                                        training_program.setRecommend_term(cellValue);
                                        break;
                                    case 21:
                                        //开课学院
                                        training_program.setCollege(cellValue);
                                        break;
                                    case 27:
                                        //年级
                                        training_program.setEnrollment_year(cellValue);
                                        break;
                                    case 28:
                                        //专业名称
                                        training_program.setMajor(cellValue);
                                        break;
                                }
                                break;
                        }
                    }
                    // 最后将解析后的数据添加到集合中
                    list.add(training_program);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}
