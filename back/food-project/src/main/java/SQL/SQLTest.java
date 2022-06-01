package SQL;

import java.util.ArrayList;

public class SQLTest {
    public static void main(String[] args) {

        DAO.updateFoodName("(색다른분식)잡채계란떡볶이", "잡채계란떡볶이");
        DAO.updateFoodName("[No.1 감자새우덮밥] 고급스러운 중식덮밥", "감자새우덮밥");
        DAO.updateFoodName("[간단 자취요리] 몽쉘로 쫀득쫀득 컵브라우니 만들기!", "컵브라우니");
        DAO.updateFoodName("[메추리알요리]메추리알 꼬치 튀김,추억의 분식요리", "메추리알 꼬치 튀김");
        DAO.updateFoodName("[분식] 옛날 분식집 떡볶이 만들기", "옛날 떡볶이");
        DAO.updateFoodName("[양식조리기능사 실기동영상] 미네스트로니스프 만드는방법", "미네스트로니 수프");
        DAO.updateFoodName("[양식조리기능사 실기동영상] 바베큐폭찹 만드는방법", "바베큐폭찹");
        DAO.updateFoodName("[양식조리기능사 실기동영상] 브라운스톡 만드는 법", "브라운스톡");
        DAO.updateFoodName("[양식조리기능사 실기동영상] 비프스튜 만드는 방법", "비프스튜");
        DAO.updateFoodName("[양식조리기능사 실기동영상] 사우전아일랜드드레싱 만드는 법", "사우전아일랜드 드레싱");
        DAO.updateFoodName("[양식조리기능사 실기동영상] 살리스버리 스테이크 만드는 법", "살리스버리 스테이크");
        DAO.updateFoodName("양식조리기능사 실기동영상] 서로인스테이크 만드는방법", "서로인 스테이크");
        DAO.updateFoodName("[양식조리기능사 실기동영상] 프렌치프라이드쉬림프 만드는방법", "프렌치 프라이드 쉬림프");
        DAO.updateFoodName("[양식조리기능사 실기동영상] 피시뮈니엘 만드는 법", "피시뮈니엘");
        DAO.updateFoodName("[양식조리기능사 실기동영상] 해산물샐러드 만드는방법", "해산물 샐러드");
        DAO.updateFoodName("[양식조리기능사 실기동영상]채소로 속을채운 훈제연어롤 만드는방법", "훈제연어롤");
        DAO.updateFoodName("[에어프라이어] 간단하고 맛있는 마약 토스트 만들기", "마약 토스트");
        DAO.updateFoodName("[일본가정식] 다이어트에도 효과적이라는 낫또 맛있게 먹는 법 :: 낫또덮밥", "낫또덮밥");
        DAO.updateFoodName("[중식/일품요리]밖에서 먹으면 너무 비싼 전가복, 집에서 간단히 만들어요~", "전가복");
        DAO.updateFoodName("[중식/일품요리]쫀득쫀득 입에 착 붙는 별미 요리! 찹살 탕수육, 꿔바로우", "꿔바로우");
        DAO.updateFoodName("[중식조리기능사] 경장육사 만드는 방법", "경장육사");
        DAO.updateFoodName("[중식조리기능사] 부추잡채 만드는 방법", "부추잡채");
        DAO.updateFoodName("[중식조리기능사] 빠스고구마 만드는 방법", "빠스고구마");
        DAO.updateFoodName("[중식조리기능사] 빠스옥수수 (옥수수빠스) 만드는 방법", "빠스옥수수");
        DAO.updateFoodName("[중식조리기능사] 새우케찹볶음 만드는 방법", "새우케찹볶음");
        DAO.updateFoodName("[중식조리기능사] 유니짜장 만드는 방법", "유니짜장");
        DAO.updateFoodName("# 분식요리, 간장 떡볶이", "간장 떡볶이");
        DAO.updateFoodName("10분 여름 가지반찬 가지된장구이/일식 나스덴가쿠", "나스덴가쿠");
        DAO.updateFoodName("10분간식 고구마피자", "고구마피자");
        DAO.updateFoodName("3단계로 만드는 날치알 테마끼스시(일식집에 나오는 그 삼각뿔...)", "테마끼스시");
        DAO.updateFoodName("간단 일식요리 계란초밥", "계란초밥");
        DAO.updateFoodName("감바스 알 아히요 만들기", "감바스 알 아히요");
        DAO.updateFoodName("고등어데리야끼구이 만드는 법(일본식 생선요리)", "고등어데리야끼 구이");
        DAO.updateFoodName("깐풍가지~가지요리 더 맛있게(중식)튀김옷을 입은 가지볶음", "깐풍가지볶음");
        DAO.updateFoodName("달지않아 선물하면 더좋은 계란쿠키맛 아몬드 블루베리 쨈쿠키~", "블루베리잼 쿠키");
        DAO.updateFoodName("달콤한 엄마표 딸기쨈쿠키 만들기 ♬", "딸기잼 쿠키");
        DAO.updateFoodName("닭가슴살 치즈떡볶이 매콤하게 든든한 분식", "닭가슴살 치즈떡볶이");
        DAO.updateFoodName("담백한 웨지감자 만들기...양식 사이드 메뉴( 아이간식 )", "웨지감자");
        DAO.updateFoodName("대파볶음밥 중식볶음밥 코코넛오일을 이용한 중국집볶음밥 만들기", "대파볶음밥");
        DAO.updateFoodName("돈가스덮밥 / 가츠동", "가츠동");
        DAO.updateFoodName("등심스테이크 l 기념일에 빠져서는 안되는 스테이크 레시피 ★", "등심스테이크");
        DAO.updateFoodName("매콤매콤 순대꼬치로 초간단 간식만들기~", "순대꼬치");
        DAO.updateFoodName("매콤하게 사랑받는 삼겹살 강정", "삼겹살 강정");
        DAO.updateFoodName("바삭한 미국식 달고나 허니콤브", "허니콤브");
        DAO.updateFoodName("밥으로 만드는 간단 토마토리조또 ★", "토마토리조또");
        DAO.updateFoodName("버터쿠키 만들기", "버터쿠키");
        DAO.updateFoodName("부드러운 소스가 매력적인 일본가정식 [하이라이스 / 하야시라이스]", "하이라이스");
        DAO.updateFoodName("부드럽고 달콤한 커스타드 푸딩 만들기", "커스타드 푸딩");
        DAO.updateFoodName("분식의 끝판왕 바삭한 김말이 튀김 만들기", "김말이 튀김");
        DAO.updateFoodName("분식의 유혹/빨간 어묵꼬치", "빨간 어묵꼬치");
        DAO.updateFoodName("아삭아삭한 고추된장박이", "고추된장박이");
        DAO.updateFoodName("알감자조림 (자연맛술을 이용한 일본가정식1편) 멸치볶음은 덤!", "알감자조림");
        DAO.updateFoodName("알리오올리오 파스타 만들기", "알리오올리오 파스타");
        DAO.updateFoodName("양식조리기능사 실기동영상] 시저샐러드 만드는방법", "시저 샐러드");
        DAO.updateFoodName("양장피 만들기 고급 중식 레스토랑 부럽지 않은 홈메이드 레시피", "양장피");
        DAO.updateFoodName("어향가지(중식가지볶음)", "어향가지");
        DAO.updateFoodName("에그타르트 만들기", "에그타르트");
        DAO.updateFoodName("유산슬 만들기 중식요리 중국요리 해산물 유산슬덮밥소스 만드는 방법", "유산슬");
        DAO.updateFoodName("일본 가정식, 돼지고기 생강구이", "돼지고기 생강구이");
        DAO.updateFoodName("일본가정식, 고마미소야끼", "고마미소야끼");
        DAO.updateFoodName("부타타마고동", "부타타마고동");
        DAO.updateFoodName("일본식 배추절임 츠케모노(쓰케모노)레시피", "츠케모노");
        DAO.updateFoodName("일본식 쇠고기 전골 ; 스키야키", "스키야키");
        DAO.updateFoodName("일본식 푸딩달걀찜, 차완무시", "차완무시");
        DAO.updateFoodName("일식 돼지고기덮밥 부타동", "부타동");
        DAO.updateFoodName("일식새우튀김 만드는 법", "새우튀김");
        DAO.updateFoodName("주꾸미삼겹살치즈볶음", "쭈꾸미삼겹살치즈볶음");
        DAO.updateFoodName("중식 울면(중식우동)", "울면");
        DAO.updateFoodName("중식우동(갑오징어탕)", "갑오징어탕");
        DAO.updateFoodName("중식의 대가 이연복 쉐프 깐풍만두 초간단 레시피", "깐풍만두");
        DAO.updateFoodName("중식풍 연두부 계란 수프(연두부계란탕)", "연두부 계란탕");
        DAO.updateFoodName("집들이 메뉴로 좋은 중식요리~ 닭가슴살 깐풍기", "닭가슴살 깐풍기");
        DAO.updateFoodName("집에서 즐기는 레스토랑급 안심스테이크 레시피!", "안심스테이크");
        DAO.updateFoodName("집에서도 일식집처럼 맛나게 ! 튀김우동", "튀김우동");
        DAO.updateFoodName("차슈와 돈코츠라멘", "돈코츠라멘");
        DAO.updateFoodName("참치회초밥 (일식조리기능사 실기종목)", "참치회초밥");
        DAO.updateFoodName("초간단 3분요리 일본 가정식 네코맘마", "네코맘마");
        DAO.updateFoodName("추억의 분식 계란초 만들기", "계란초");
        DAO.updateFoodName("추억의 학교앞 간식! 피카츄꼬치 만들기! 떡꼬치 소스는 꼭 듬뿍", "피카츄 돈까스");
        DAO.updateFoodName("프렌치토스트 만들기", "프렌치 토스트");
        DAO.updateFoodName("피시차우더수프 만드는 법 (양식요리)", "피시차우더 수프");


    }
}
