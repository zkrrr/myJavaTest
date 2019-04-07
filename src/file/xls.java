package file;

import java.io.*;
import java.util.List;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class xls {

    public static void readXlsxImage(File file) {
        try {
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
            XSSFSheet sheet = wb.getSheetAt(0);

            //读取图片
            List<XSSFPictureData> pictures = wb.getAllPictures();
            for (XSSFShape shape : sheet.getDrawingPatriarch().getShapes()) {
                if (shape instanceof XSSFPicture) {
                    XSSFPicture pic = (XSSFPicture) shape;
                    XSSFPictureData picData = pictures.get(0);
                    File image = new File("/home/zk/tupian/"+(file.getName().split("\\."))[0]+".jpg");
                    if (!image.exists())
                        image.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(image);
                    fileOutputStream.write(picData.getData());
//                    System.out.println("image-size:" +file.getName() + " " +picData.getData().length);
                }
            }
        }catch (Exception e){
            System.out.println(file.getName() + "error");
        }
    }

    public static void readImage(File file) {
        try {
            HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(file));
            HSSFSheet sheet = wb.getSheetAt(0);

            //读取图片
            List<HSSFPictureData> pictures = wb.getAllPictures();
            for (HSSFShape shape : sheet.getDrawingPatriarch().getChildren()) {
                if (shape instanceof HSSFPicture) {
                    HSSFPicture pic = (HSSFPicture) shape;
                    int pictureIndex = pic.getPictureIndex()-1;
                    HSSFPictureData picData = pictures.get(pictureIndex);
                    File image = new File("/home/zk/hahaha/图片2/"+(file.getName().split("\\."))[0]+
                            ((HSSFPicture) shape).getPictureIndex()+".jpg");
                    if (!image.exists())
                        image.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(image);
                    fileOutputStream.write(picData.getData());
//                    System.out.println("image-size:" +file.getName() + " " +picData.getData().length);
                }
            }
        }catch (Exception e){
            System.out.println(file.getName() + "error");
        }
    }

    public static void main(String[] args) throws IOException {
//        File excel = new File("/home/zk/hahaha/");
//        File[] files = excel.listFiles();
//        for(File file : files){
//                xls.readImage(file);
//        }
//        File excel = new File("/home/zk/xlsx");
//        File[] files = excel.listFiles();
//        for(File file : files){
//            xls.readXlsxImage(file);
//        }
        File file = new File("/home/zk/hahaha/严智.xls");
        xls.readImage(file);
    }
}
