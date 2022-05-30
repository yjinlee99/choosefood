package crawling;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class crawl {
    static String name; // 테이블 명
    static String title;
    static String intro;
    static String ingredient;
    static String step;
    static String thumbnail;
    static String stepimg;

    public static void getCrawl(String url) {

        Connection conn = Jsoup.connect(url);

        try {
            Document doc = conn.get();
            createFolder(getTitle(doc).text()); // 폴더 생성

            title = getTitle(doc).text(); // 제목 삽입
            name = underBarSpace(title); // 이름 공백 -> 언더바 치환 후 삽입
            System.out.println("제목: " + getTitle(doc).text()); // 제목 출력

            thumbnail = getThumbnail(doc).attr("src"); // 썸네일 링크 삽입
            saveImg(getTitle(doc).text(), getTitle(doc).text(), getThumbnail(doc).attr("src"), 1); // image 폴더에 썸네일 저장

            intro = getIntro(doc).text(); // 소개 삽입
            intro = apostrophe(intro); // 소개 따옴표 -> 삭제 후 삽입
            System.out.println("요리 소개: " + getIntro(doc).text()); // 소개 출력

            int i = 1;
            System.out.println("[재료]");
            for (Element ele : getIngredient(doc)) { // 재료 출력
                String str = ele.text();
                if (i == 1) // 값 존재 안하면
                    ingredient = str;
                else // 값 존재 하면
                    ingredient = ingredient + "_" + str;
                System.out.println(str);
                i++;
            }

            i = 1;
            System.out.println("[조리 순서]");
            for (Element ele : getStep(doc)) { // 순서 출력
                String str = ele.text();
                if (i == 1) // 값 존재 안하면
                    step = str;
                else // 값 존재 하면
                    step = step + "_" + str;
                System.out.println(i + ") " + str);
                i++;
            }
            step = apostrophe(step); // 순서 따옴표 -> 삭제 후 삽입

            for (int j = 1; j <= i; j++) { // image 폴더에 순서 이미지 저장
                saveImg(getTitle(doc).text(),getTitle(doc).text() + j, getStepImg(doc).select("div[id=stepimg" + j + "]")
                        .select("img").attr("src"), 2);
                String str = getStepImg(doc).select("div[id=stepimg" + j + "]")
                        .select("img").attr("src");
                if (j == 1)
                    stepimg = str;
                else
                    stepimg = stepimg + " " + str;
            }


        } catch (IOException ignored) { }

    }

    // 제목 쿼리
    public static Elements getTitle(Document doc) {
        Elements ele = doc.select("div[class=view2_summary st3]").select("h3");
        return ele;
    }

    // 썸네일 쿼리
    public static Elements getThumbnail(Document doc) {
        Elements ele = doc.select("div[class=view2_pic]").select("img[id=main_thumbs]");
        return ele;
    }

    // 소개 쿼리
    public static Elements getIntro(Document doc) {
        Elements ele = doc.select("div[class=view2_summary_in]");
        return ele;
    }

    // 재료 쿼리
    public static Elements getIngredient(Document doc) {
        Elements ele = doc.select("div[class=ready_ingre3]").select("li");
        return ele;
    }

    // 순서 쿼리
    public static Elements getStep(Document doc) {
        Elements ele = doc.select("div[class=view_step]").select("div[class=media-body]");
        return ele;
    }

    // 순서 이미지 쿼리
    public static Elements getStepImg(Document doc) {
        Elements ele = doc.select("div[class=view_step]");
        return ele;
    }

    // 문자열 공백 제거
    public static String deleteSpace(String name) {
        name = name.replaceAll(" ", "");
        return name;
    }

    // 문자열 공백 언더바 치환
    public static String underBarSpace(String name) {
        name = name.replaceAll(" ", "_");
        return name;
    }

    // 문자열 따옴표 삭제
    public static String apostrophe(String name) {
        name = name.replaceAll("\'", "");
        name = name.replaceAll("\"", "");
        return name;
    }

    // 문자열 슬래시 or 역슬래시 언더바 치환
    public static String underBarSlash(String name) {
        if (name.contains("/")) { // name 에 슬래시 포함되면 언더바로 치환
            name = name.replaceAll("/","_");
        } else if (name.contains("\'")) { // name 에 역슬래시 포함되면 언더바로 치환
            name = name.replaceAll("\'","_");
        }
        return name;
    }

    // 폴더 생성
    public static void createFolder(String name) {
        name = underBarSlash(name); // 파일 저장 시 슬래시(/) 혹은 역슬래시(\)가 name 에 포함되면 프로그램이 경로로 착각하는 것을 방지
        File MainFolder = new File(".\\src\\main\\java\\crawling\\image\\" + name);
        File TitleFolder = new File(".\\src\\main\\java\\crawling\\image\\" + name + "\\TitleImage");
        File StepFolder = new File(".\\src\\main\\java\\crawling\\image\\" + name + "\\StepImage");
        MainFolder.mkdir();
        TitleFolder.mkdir();
        StepFolder.mkdir();
    }

    // 이미지 저장
    public static void saveImg(String folder, String name, String url, Integer num) throws IOException {
        name = underBarSlash(name); // 파일 저장 시 슬래시(/) 혹은 역슬래시(\)가 name 에 포함되면 프로그램이 경로로 착각하는 것을 방지
        folder = underBarSlash(folder); // 파일 저장 시 슬래시(/) 혹은 역슬래시(\)가 name 에 포함되면 프로그램이 경로로 착각하는 것을 방지
        URL imgUrl = new URL(url);
        BufferedImage jpg = ImageIO.read(imgUrl);
        if (num == 1) {
            File file = new File(".\\src\\main\\java\\crawling\\image\\" + folder + "\\TitleImage\\" + name + ".jpg");
            ImageIO.write(jpg, "jpg", file);
        } else if (num == 2) {
            File file = new File(".\\src\\main\\java\\crawling\\image\\" + folder + "\\StepImage\\" + name + ".jpg");
            ImageIO.write(jpg, "jpg", file);
        }
    }

    public static void main(String[] args) {
    }
}