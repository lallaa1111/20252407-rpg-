package report_RPG;

import java.util.Scanner;

public class Rpg_before_calss {
	static int hero_level, hero_power, hero_hp, hero_defense, hero_mp, hero_experience, hero_money; // 조건 1: 전역 변수 선언/
																									// 정적 메서드 구성
	static int monster_level, monster_power, monster_hp, monster_defense, monster_mp, monster_experience, monster_money;
	static String hero_name, monster_name;
	static String stars = "***************************************************************************************";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("RPG GAME\n20252407 전예림\n" + stars);
		System.out.print("안녕하세요, 용사님!\n저희 세계에 오신걸 환영합니다.\n제가 뭐라고 불러드리면 될까요?\n*이름을 입력하세요: ");
		hero_name = in.next();
		System.out.printf("*이름이 입력되었습니다.\n좋습니다!\n%s님! 행운을 빕니다!\n*게임에 입장하였습니다.\n", hero_name); // 처음 시작
		hero_level = 1;
		hero_power = 15;
		hero_defense = 25;
		hero_hp = 80;
		hero_experience = 0;
		hero_money = 0;
		hero_mp = 0;
		stateOfHero();
		while_hero_alive();
	}

	static void heroDeath1() {
		System.out.println(hero_name + "가 죽었습니다.\n부활하시겠습니까?[y/n]");
		heroDeath2();
	}

	static void heroDeath2() {
		Scanner in = new Scanner(System.in);
		String revival = in.next();
		switch (revival) {
		case "y" -> {
			System.out.println("전투 시스템이 초기화됩니다.");
			System.out.print("안녕하세요, 용사님!\n저희 세계에 오신걸 환영합니다.\n제가 뭐라고 불러드리면 될까요?\n*이름을 입력하세요: ");
			hero_name = in.next();
			System.out.printf("*이름이 입력되었습니다.\n좋습니다!\n%s님! 행운을 빕니다!\n*게임에 입장하였습니다.\n", hero_name); // 처음 시작
			hero_level = 1;
			hero_power = 15;
			hero_defense = 25;
			hero_hp = 80;
			hero_experience = 0;
			hero_money = 0;
			hero_mp = 0;
			stateOfHero();
			while_hero_alive();
		}
		case "n" -> {
			System.out.println("게임을 종료합니다.");
			System.exit(0);
		}
		default -> {
			System.out.println("알 수 없는 명령입니다.");
			heroDeath2();
		}
		}
	}

	static void stateOfHero() {
		System.out.println(stars);
		System.out.println("현재 Hero의 이름: " + hero_name);
		System.out.printf(
				"현재 %s의 레벨: %d\n현재 %s의 힘: %d\n현재 %s의 방어력: %d\n현재 %s의 HP: %d\n현재 %s의 MP: %d\n현재 %s의 경험치: %d\n현재 %s의 돈: %d\n",
				hero_name, hero_level, hero_name, hero_power, hero_name, hero_defense, hero_name, hero_hp, hero_name,
				hero_mp, hero_name, hero_experience, hero_name, hero_money);
		System.out.println(stars);
	}

	static void chooseWhere() {
		Scanner in = new Scanner(System.in);
		int chooseWhere;
		System.out.println("1. 사냥터\n2. 포션 상점");
		System.out.print("입장할 장소를 선택하세요: ");
		chooseWhere = in.nextInt();
		switch (chooseWhere) {
		case 1 -> fight();
		case 2 -> potionStore_show(hero_money, 1);
		default -> {
			System.out.println("알 수 없습니다. 다시 입력하세요: ");
			chooseWhere();
		}
		}
	}

	static int potionStore_show(int money, int num) { // 조건 5: 포션상점 프로세스
		Scanner in = new Scanner(System.in);
		System.out.println(stars + "\n포션 상점에 입장하였습니다.");
		System.out
				.println("1. 힘 증강 포션(30원)\n2. 방어력 증강 포션(30원)\n3. 경헙치 증강 포션(100원)\n4. HP 증강 포션(10원)\n5. MP 증강 포션(10원)");
		System.out.printf("원하시는 물건을 골라주세요: ");
		int choosePotion = in.nextInt();
		System.out.println("포션 상점에서 물건을 구매 시도하는 중입니다.");
		switch (choosePotion) {
		case 1 -> {
			if (hero_money >= 30) {
				hero_money -= 30;
				hero_power += 3;
				System.out.println("구매가 완료되었습니다!");
			} else {
				System.out.printf("포션을 구매할 수 없습니다. (%d원 분족)\n", 30 - hero_money);
			}
		}
		case 2 -> {
			if (hero_money >= 30) {
				hero_money -= 30;
				hero_defense += 3;
				System.out.println("구매가 완료되었습니다!");
			} else {
				System.out.printf("포션을 구매할 수 없습니다. (%d원 분족)\n", 30 - hero_money);
			}
		}
		case 3 -> {
			if (hero_money >= 100) {
				hero_money -= 100;
				hero_experience += 50;
				System.out.println("구매가 완료되었습니다!");
				herolevelup();
			} else {
				System.out.printf("포션을 구매할 수 없습니다. (%d원 분족)\n", 100 - hero_money);
			}
		}
		case 4 -> {
			if (hero_money >= 10) {
				hero_money -= 10;
				hero_hp += 50;
				System.out.println("구매가 완료되었습니다!");
			} else {
				System.out.printf("포션을 구매할 수 없습니다. (%d원 분족)\n", 10 - hero_money);
			}
		}
		case 5 -> {
			if (hero_money >= 10) {
				hero_money -= 10;
				hero_mp += 50;
				System.out.println("구매가 완료되었습니다!");
			} else {
				System.out.printf("포션을 구매할 수 없습니다. (%d원 분족)\n", 10 - hero_money);
			}
		}
		}
		;
		stateOfHero();
		chooseWhere();
		return 0;
	}

	static void herolevelup() { // 조건 3: 히어로 레벨업 프로세스
		if (hero_experience >= hero_level * 80) {
			hero_level += 1;
			System.out.printf("%s의 레벨이 %d가 되었습니다.\n", hero_name, hero_level);
			hero_money += hero_level * 50;
			System.out.printf("보상으로 돈 %d원을 받습니다!\n", hero_level * 50);
			hero_experience = 0;
		}
	}

	static void chooseMonster() { // 조건 4 : 몬스터 구성
		Scanner in = new Scanner(System.in);
		int chooseMonster;
		System.out.println("사냥터에 입장하였습니다.");
		while (true) {
			System.out.println("1. 너구리\n2. 살괭이");
			System.out.print("전투할 상대를 선택하세요: ");
			chooseMonster = in.nextInt();
			switch (chooseMonster) {
			case 1 -> {
				monster_name = "너구리";
				monster_hp = 100;
				monster_mp = 0;
				monster_level = 1;
				monster_power = 20;
				monster_defense = 5;
				monster_money = 10;
				monster_experience = 10;
				return;
			}
			case 2 -> {
				monster_name = "살쾡이";
				monster_hp = 2000;
				monster_mp = 0;
				monster_level = 5;
				monster_power = 100;
				monster_defense = 20;
				monster_money = 30;
				monster_experience = 50;
				return;
			}
			default -> {
				System.out.println("목록에 없습니다. 다시 입력하세요: ");
			}
			}
		}
	}

	static void fight() { // 조건 2: 전투 프로세스
		chooseMonster();
		System.out.println(monster_name + "와의 전투를 시작합니다.");
		while (monster_hp > 0) {
			monster_attacked(hero_attack());
			hero_attacked(monster_attack());
		}

	}

	static int hero_attack() {
		int sum = hero_level * 10 + hero_power * 30;
		return sum;
	}

	static void hero_attacked(int sum) {
		System.out.println(monster_name + "의 공격입니다.");
		sum = monster_attack();
		if (hero_defense >= monster_power) {
			System.out.println(hero_name + "은 데미지를 받지 않았습니다.");
		} else {
			System.out.printf("%s가 받는 데미지는 %d입니다.\n", hero_name, monster_attack());
			hero_hp = hero_hp + hero_defense - sum;
			if (hero_hp > 0) {
				System.out.printf("%s의 HP는 %d입니다.\n", hero_name, hero_hp);
			} else {
				heroDeath1();
			}
		}
	}

	static int monster_attack() {
		int sum = monster_level * 10 + monster_power * 30;
		return sum;
	}

	static void monster_attacked(int sum) {

		System.out.println(hero_name + "의 공격입니다.");
		if (monster_defense >= sum) {
			System.out.printf("공격력이 너무 낮습니다. %s가 받는 데미지는 0입니다.", monster_name);
		} else {
			System.out.printf("%s가 받는 데미지는 %d입니다.\n", monster_name, hero_attack());
			monster_hp = monster_hp + monster_defense - sum;
			if (monster_hp > 0) {
				System.out.printf("%s의 HP는 %d입니다.\n", monster_name, monster_hp);
			} else {
				System.out.println(monster_name + "가 죽었습니다.");
				hero_experience += monster_experience;
				hero_money += monster_money;
				herolevelup();
				double randomnum; // 몬스터를 죽이면 랜덤으로 보상이 나올 가능성 있음.(추가기능)
				randomnum = Math.random();
				if (monster_name.equals("살쾡이") && randomnum >= 0.0 && randomnum <= 0.03) { // 살쾡이를 죽이면 3%의 확률로 전설의 검을
																							// 얻음(효과:힘 50 증가, 경험치 50 증가)
					System.out.println("몬스터로부터 전설의 검을 얻었습니다!");
					hero_power += 50;
					System.out.println("힘이 50 올랐습니다!");
					hero_experience += 50;
					System.out.println("경험치가 50 올랐습니다!");
					herolevelup();
				} else if (randomnum >= 0.2 && randomnum <= 0.3) { // 몬스터를 죽이면 10% 확률로 값비싼 갑옷을 얻음(효과: 방어 15 증가, 경험치 15
																	// 증가)
					System.out.println("몬스터로부터 값비싼 갑옷을 얻었습니다!");
					hero_defense += 15;
					System.out.println("방어력이 15 올랐습니다!");
					hero_experience += 15;
					System.out.println("경험치가 15 올랐습니다!");
					herolevelup();
				} else if (randomnum >= 0.3 && randomnum <= 0.6) { // 몬스터를 죽이면 30% 확률로 싸구려 방패를 얻음(효과: 방어 5 증가, 경험치 5 증가)
					System.out.println("몬스터로부터 싸구려 방패를 얻었습니다!");
					hero_defense += 5;
					System.out.println("방어력이 5 올랐습니다!");
					hero_experience += 5;
					System.out.println("경험치가 5 올랐습니다!");
					herolevelup();
				}
				stateOfHero();
				chooseWhere();
			}
		}
	}

	static void while_hero_alive() {
		while (hero_hp > 0) {
			fight();
			if (hero_hp <= 0) {
				break;
			}
			chooseWhere();
		}
	}
}
