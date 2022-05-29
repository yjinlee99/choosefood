package crawling;

import SQL.DAO;

public class crawlTest {
    public static void main(String[] args) {
        DAO.createFoodTable();
        // 한식 35
        crawl.getCrawl("https://www.10000recipe.com/recipe/6751412"); //        소고기 미역국
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "고소", "해장_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/1176470"); //        닭볶음탕
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "매콤_짭짤", "야식_술안주_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6834925"); //        소고기무국
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "고소", "해장_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6928359"); //        떡국
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "고소", "해장_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6953177"); //        김치 떡국
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "매콤_고소_짭짤", "해장_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6927150"); //        만두국
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "고소", "해장_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6929231"); //        김치찌개
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "매콤_짭짤", "해장_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/4850648"); //        된장찌개
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "고소_짭짤", "해장_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6842456"); //        갈릭 닭가슴살버섯볶음
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "고소_짭짤", "술안주_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6898497"); //        팽이버섯 베이컨 볶음
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "고소_짭짤", "술안주_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6901907"); //        낙지볶음
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "매콤_짭짤", "야식_술안주_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6836969"); //        쭈꾸미삼겹살치즈볶음
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "매콤_짭짤", "야식_술안주_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6841752"); //        두루치기 제육볶음
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "매콤_짭짤", "야식_술안주_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6629857"); //        소세지야채볶음
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "짭짤", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6875668"); //        새우볶음밥
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "고소", "식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6838790"); //        스팸 두부김치
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "매콤_고소_짭짤", "야식_술안주_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6882107"); //        데리야키 닭고기 구이
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "매콤_달콤_짭짤", "야식_술안주_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6863727"); //        닭갈비
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "매콤_짭짤", "술안주_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/4123616"); //        고추장 참치김치볶음 계란말이
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "매콤_고소_짭짤", "술안주_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6897873"); //        감자전
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "고소", "야식_술안주");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6908862"); //        김치전
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "매콤_고소_짭짤", "야식_술안주");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6885038"); //        스팸 계란말이
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "달콤_고소_짭짤", "술안주_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6887599"); //        소고기부추수육
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "고소", "야식_술안주_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6836877"); //        고구마맛탕
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "달콤_고소", "간식_술안주");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6838254"); //        두부조림
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "고소_짭짤", "술안주_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6837292"); //        베이컨말이 주먹밥
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "고소_짭짤", "식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6727692"); //        참치마요 주먹밥
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "고소", "식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6847429"); //        삼겹살김밥
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "고소" ,"식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6927171"); //        스팸꼬마김밥
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "짭짤", "식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6974014"); //        김치콩나물라면
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "매콤_짭짤", "야식_술안주_해장");

        // 한식 추가
        crawl.getCrawl("https://www.10000recipe.com/recipe/4030952"); //        고추된장박이
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "매콤_짭짤", "식사_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6830616"); //        배추 된장 들깨무침
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "고소_짭짤", "식사_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6898328"); //        참치 비빔밥
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "매콤_고소_짭짤", "식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6973706"); //        들깨가루 무청시래기나물
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "고소", "식사_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6924357"); //        매콤 삼겹살 강정
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "한식", "매콤_짭짤", "야식_술안주");


        // 분식 18
        crawl.getCrawl("https://www.10000recipe.com/recipe/6842954"); //        떡볶이
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "분식", "매콤_달콤_짭짤", "야식_간식");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6834570"); //        까르보나라 떡볶이
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "분식", "달콤_고소_짭짤", "야식_간식");
        crawl.getCrawl("https://www.10000recipe.com/recipe/745232"); //         기름 떡볶이
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "분식", "달콤_고소_짭짤", "야식_간식");
        crawl.getCrawl("https://www.10000recipe.com/recipe/2899675"); //        쫄면
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "분식", "매콤_달콤_짭짤", "기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/5380902"); //        떡꼬치
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "분식", "매콤_달콤_짭짤", "야식_간식");
        crawl.getCrawl("https://www.10000recipe.com/recipe/1212077"); //        라볶이
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "분식", "매콤_달콤_짭짤", "야식_간식");

        // 분식 추가
        crawl.getCrawl("https://www.10000recipe.com/recipe/6898852"); //        잡채 계란 떡볶이
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "분식", "매콤_달콤_짭짤", "야식_간식");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6859183"); //        닭가슴살 치즈떡볶이
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "분식", "매콤_달콤_짭짤", "야식_간식");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6704677"); //        계란초
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "분식", "달콤_짭짤", "술안주_간식");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6862654"); //        메추리알 꼬치튀김
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "분식", "매콤_달콤_짭짤", "술안주_간식");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6844420"); //        빨간 어묵꼬치
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "분식", "매콤_달콤_짭짤", "술안주_간식");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6888110"); //        어묵 떡 볶음
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "분식", "달콤_짭짤", "야식_간식");
        crawl.getCrawl("https://www.10000recipe.com/recipe/5445436"); //        치즈밥
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "분식", "달콤_짭짤", "야식_간식_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6948256"); //        간장 떡볶이
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "분식", "달콤_짭짤", "야식_간식");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6893249"); //        김말이 튀김
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "분식", "달콤_짭짤", "술안주_간식");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6935081"); //        옛날 떡볶이
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "분식", "매콤_달콤_짭짤", "야식_간식");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6864678"); //        순대 꼬치
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "분식", "고소_달콤_짭짤", "술안주_간식");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6944924"); //        피카츄 돈까스
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "분식", "매콤_달콤_짭짤", "야식_간식");


        // 양식 33
        crawl.getCrawl("https://www.10000recipe.com/recipe/6908129"); //        딸기 케이크
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "달콤", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/1698806"); //        초코 케이크
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "달콤", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/2328895"); //        치즈 케이크
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "달콤", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/2019368"); //        롤케이크
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "달콤_고소", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6848554"); //        팬케이크
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "달콤_고소", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/2451685"); //        컵케이크
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "달콤_고소", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6912207"); //        프렌치토스트
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "달콤_고소", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6944647"); //        마약토스트
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "달콤_짭짤", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6873002"); //        안심스테이크
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "고소", "야식_술안주_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6926532"); //        등심스테이크
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "고소", "야식_술안주_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6845657"); //        함박스테이크
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "고소", "야식_술안주_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6972590"); //        알리오올리오 파스타
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "고소_짭짤", "식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6947036"); //        토마토 파스타
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "달콤_짭짤", "식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6845384"); //        크림 리조또
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "달콤_고소", "식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6919947"); //        토마토 리조또
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "달콤_짭짤", "식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6884805"); //        감바스
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "고소_짭짤", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6866809"); //        오믈렛
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "고소", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6846164"); //        고구마피자
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "달콤_고소_짭짤", "야식_간식_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6840998"); //        불고기피자
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "달콤_고소_짭짤", "야식_간식_식사");

        // 양식 추가
        crawl.getCrawl("https://www.10000recipe.com/recipe/6848229"); //        웨지감자
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "고소_짭짤", "야식_간식");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6980091"); //        피시차우더스프
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "고소_짭짤", "야식_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6916268"); //        서로인 스테이크
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "고소", "야식_술안주_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6916949"); //        해산물 샐러드
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "달콤_고소", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6916271"); //        시저 샐러드
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "달콤_고소", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6915008"); //        미네스트로니스프
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "달콤_짭짤", "야식_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6914618"); //        바베큐 폭찹
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "달콤_고소_짭짤", "야식_술안주_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6914615"); //        프렌치프라이드 쉬림프
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "고소_짭짤", "야식_술안주_간식");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6913650"); //        비프 스튜
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "고소_짭짤", "야식_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6912062"); //        브라운 스톡
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "달콤_짭짤", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6912059"); //        사우전아일랜드 드레싱
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "달콤_고소", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6910920"); //        훈제연어롤
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "달콤_고소", "야식_간식_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6910512"); //        피시뮈니엘
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "고소", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6908131"); //        살리스버리 스테이크
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "양식", "고소", "야식_술안주_식사");


        // 중식 33
        crawl.getCrawl("https://www.10000recipe.com/recipe/6930703"); //        짜장면
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "달콤_짭짤", "야식_술안주_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6837020"); //        나가사키짬뽕
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "매콤_고소_짭짤", "야식_술안주_해장_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6840321"); //        소고기 해물짬뽕
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "매콤_고소_짭짤", "야식_술안주_해장_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6952271"); //        멘보샤
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "고소_짭짤", "간식_술안주");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6888512"); //        고추 잡채
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "매콤_짭짤", "술안주_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6900916"); //        깐풍기
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "달콤_짭짤", "야식_간식_술안주");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6876530"); //        마파두부
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "고소_짭짤", "식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6958855"); //        버섯마라탕
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "매콤_고소_짭짤", "야식_술안주_해장_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6841863"); //        탕수육
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "달콤_고소", "야식_간식_술안주");

        // 중식 추가
        crawl.getCrawl("https://www.10000recipe.com/recipe/6902300"); //        깐풍 만두
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "달콤_고소_짭짤", "야식_간식_술안주");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6841290"); //        감자새우덮밥
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "고소_짭짤", "식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6906389"); //        오징어 청경채볶음
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "달콤_고소_짭짤", "간식_술안주");
        crawl.getCrawl("https://www.10000recipe.com/recipe/3526900"); //        닭가슴살 깐풍기
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "고소_짭짤", "야식_간식_술안주");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6894222"); //        깐풍 가지
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "짭짤", "야식_간식_술안주");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6574194"); //        전가복
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "고소", "간식_술안주");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6979966"); //        어향 가지
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "매콤_고소_짭짤", "야식_간식_술안주");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6971399"); //        양장피
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "매콤_고소", "야식_술안주_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6960670"); //        갑오징어탕
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "고소_짭짤", "야식_술안주_해장");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6923451"); //        유니짜장
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "달콤_짭짤", "야식_술안주_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6922616"); //        경장육사
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "매콤_달콤_고소_짭짤", "야식_술안주_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6921601"); //        부추 잡채
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "고소", "식사_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6920233"); //        새우케찹볶음
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "달콤_짭짤", "야식_간식_술안주");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6920232"); //        빠스옥수수
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "달콤_짭짤", "야식_간식_술안주");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6919250"); //        빠스고구마
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "달콤_고소", "야식_간식_술안주");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6851401"); //        유산슬
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "고소_짭짤", "야식_술안주_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6529446"); //        꿔바로우
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "달콤_고소", "야식_간식_술안주");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6850085"); //        대파 볶음밥
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "고소_짭짤", "야식_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6863067"); //        칠리 새우
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "매콤_달콤_짭짤", "야식_간식_술안주");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6926404"); //        연두부 계란탕
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "고소_짭짤", "술안주_해장");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6975367"); //        울면
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "중식", "고소_짭짤", "야식_술안주_해장");


        //일식 33
        crawl.getCrawl("https://www.10000recipe.com/recipe/6910028"); //        돈가스덮밥(가츠동)
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "고소_짭짤", "식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6846457"); //        볶음우동
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "고소_짭짤", "식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6835948"); //        유부초밥
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "달콤_고소_짭짤", "식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6847550"); //        밀푀유 나베
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "고소_짭짤", "식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6852018"); //        메밀 소바
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "고소_짭짤", "식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6841641"); //        오코노미야키
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "달콤_고소_짭짤", "간식_술안주");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6830755"); //        차슈와 돈코츠라멘
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "고소_짭짤", "해장_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6873305"); //        두부튀김
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "고소", "기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6841801"); //        어묵탕
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "고소_짭짤", "술안주_해장");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6950738"); //        가라아게
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "고소_짭짤", "야식_간식_술안주");
        crawl.getCrawl("https://www.10000recipe.com/recipe/28639"); //          규동
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "고소_짭짤", "식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/1907735"); //        구운 오니기리
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "고소", "간식_술안주");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6910844"); //        차완무시
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "고소", "기타");

        // 일식 추가
        crawl.getCrawl("https://www.10000recipe.com/recipe/6872865"); //        스키야키
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "고소_짭짤", "야식_간식_술안주");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6867572"); //        새우 튀김
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "고소_짭짤", "야식_간식_술안주");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6860728"); //        돈카츠 나베
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "고소_짭짤", "야식_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6976054"); //        부타동
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "고소_짭짤", "야식_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6972988"); //        테마끼스시
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "고소_짭짤", "야식_간식_술안주");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6962840"); //        나스덴가쿠
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "짭짤", "간식_술안주");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6949776"); //        계란 초밥
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "고소_짭짤", "식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6901369"); //        튀김 우동
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "고소_짭짤", "술안주_해장");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6863466"); //        참치회 초밥
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "고소_짭짤", "식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6886034"); //        이모모찌
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "고소_짭짤", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6900875"); //        돼지고기 생강구이
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "고소_짭짤", "야식_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6864830"); //        고등어 데리야끼 구이
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "달콤_고소_짭짤", "식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6877721"); //        츠케모노
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "달콤_짭짤", "식사_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6902083"); //        고마미소야끼
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "달콤_고소_짭짤", "야식_식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6904235"); //        부타타마고동
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "고소_짭짤", "식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6871954"); //        히야시츄카
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "고소_짭짤", "식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6837789"); //        하이라이스
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "달콤_짭짤", "식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6701312"); //        네코맘마
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "고소_짭짤", "식사");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6891671"); //        알감자 조림
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "달콤_고소_짭짤", "식사_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6838495"); //        낫또덮밥
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "일식", "고소_짭짤", "식사");


        //디저트 20
        crawl.getCrawl("https://www.10000recipe.com/recipe/6833597"); //        마카롱
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "디저트", "달콤", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6879930"); //        오레오 파르페
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "디저트", "달콤", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/567648"); //         와플
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "디저트", "달콤_고소", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6842933"); //        파베 초콜릿
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "디저트", "달콤", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6920543"); //        슈크림 붕어빵
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "디저트", "달콤_고소", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6898030"); //        딸기 타르트
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "디저트", "달콤_고소", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6944021"); //        에그 타르트
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "디저트", "달콤_고소", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/385575"); //         푸딩
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "디저트", "달콤", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6909060"); //        수플레
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "디저트", "달콤_고소", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/1754794"); //        초코쿠키
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "디저트", "달콤", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6896976"); //        버터쿠키
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "디저트", "달콤_고소", "간식_기타");

        // 디저트 추가
        crawl.getCrawl("https://www.10000recipe.com/recipe/6865340"); //        컵 브라우니
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "디저트", "달콤", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6848325"); //        아망디오쇼콜라
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "디저트", "달콤", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/1135209"); //        호두 비스킷
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "디저트", "달콤_고소", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6847733"); //        아몬드샤브레
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "디저트", "달콤_고소", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6972163"); //        허니콤브
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "디저트", "달콤", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6837881"); //        딸기잼 쿠키
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "디저트", "달콤_고소", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6972396"); //        블루베리잼 쿠키
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "디저트", "달콤_고소", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6928507"); //        말차샤브레 쿠키
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "디저트", "달콤_고소", "간식_기타");
        crawl.getCrawl("https://www.10000recipe.com/recipe/6837208"); //        초콜릿 크랙쿠키
        DAO.addValues(crawl.title, crawl.intro, crawl.ingredient, crawl.step, crawl.thumbnail, crawl.stepimg, "디저트", "달콤_고소", "간식_기타");
    }
}
